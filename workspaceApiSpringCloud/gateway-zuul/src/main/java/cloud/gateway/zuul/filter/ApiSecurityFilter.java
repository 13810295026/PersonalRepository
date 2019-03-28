package cloud.gateway.zuul.filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class ApiSecurityFilter extends ZuulFilter {

	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@Resource(name = "stringRedisTemplate")
	ValueOperations<String, String> valOps;

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		System.out.println(request.getMethod() + "|" + request.getRequestURI());

		if (!request.getRequestURI().startsWith("/api/hello/")) {
			String staffid = request.getHeader("staffid");
			String timestamp = request.getHeader("timestamp");
			String nonce = request.getHeader("nonce");
			String signature = request.getHeader("signature");

			// 请求参数是否完整
			if (null == staffid || null == timestamp || null == nonce || null == signature
					|| !Pattern.compile("^[-\\+]?[\\d]*$").matcher(staffid).matches()) {
				ctx.setSendZuulResponse(false);
				ctx.setResponseStatusCode(401);
				ctx.set("isSuccess", false);

				return null;
			}

			long timeValidate = System.currentTimeMillis() - Long.parseLong(timestamp);
			// 判断Url是否已超过有效时长（5秒）
			if (timeValidate < 0 || timeValidate > 5000) {
				ctx.setSendZuulResponse(false);
				ctx.setResponseStatusCode(402);
				ctx.set("isSuccess", false);

				return null;
			}
			// 判断随机数和签名是否为空
			String token = valOps.get(staffid);
			// 判断登录身份是否已过期
			if (null == token) {
				ctx.setSendZuulResponse(false);
				ctx.setResponseStatusCode(203);
				ctx.set("isSuccess", false);

				return null;
			}

			// 判断是否已在别处登录
			String signToken = request.getHeader("signToken");
			if (!token.equals(signToken)) {
				ctx.setSendZuulResponse(false);
				ctx.setResponseStatusCode(203);
				ctx.set("isSuccess", false);

				return null;
			}

			// 取得请求数据
			String reqData = "";
			switch (request.getMethod()) {
			case "POST":
				BufferedReader br = null;
				try {
					br = new BufferedReader(
							new InputStreamReader((ServletInputStream) request.getInputStream(), "utf-8"));
					StringBuffer sb = new StringBuffer("");
					String buffer;
					while ((buffer = br.readLine()) != null) {
						sb.append(buffer);
					}
					br.close();

					reqData = sb.toString();
				} catch (IOException e) {
					e.printStackTrace();
				}

				break;
			case "GET":
				String strParam = request.getQueryString();
				if (null != strParam) {
					Map<String, String> parameters = new TreeMap<String, String>();
					String[] params = strParam.split("\\&");
					for (String param : params) {
						parameters.put(param.split("=")[0], param.split("=")[1]);
					}

					StringBuffer sb = new StringBuffer("");
					for (String key : parameters.keySet()) {
						sb.append(key).append(parameters.get(key));
					}
					reqData = sb.toString();
				}

				break;
			default:
				break;
			}
			try {
				String signStr = timestamp + nonce + staffid + token + reqData;
				String sortStr = signStr;// 将字符串升序排序
				byte[] bytes = sortStr.getBytes("UTF-8");
				byte[] md5Val = bytes;// 将字节数组md5加密
				StringBuffer sb = new StringBuffer("");
				for (byte c : md5Val) {
					sb.append(c);
				}

				// 校验签名
				if (!signature.equals(sb.toString())) {
					ctx.setSendZuulResponse(false);
					ctx.setResponseStatusCode(403);
					ctx.set("isSuccess", false);

					return null;
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	@Override
	public boolean shouldFilter() {
		// 是否执行该过滤器
		return true;
	}

	@Override
	public int filterOrder() {
		// 优先级0，最高
		return 0;
	}

	@Override
	public String filterType() {
		// 前置过滤器
		return "pre";
	}
}
