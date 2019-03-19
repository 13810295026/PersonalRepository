package cloud.gateway.zuul.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import com.ceac.easystudy.po.ResultMsg;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ExercisesFallback implements ZuulFallbackProvider {

	@Override
	public String getRoute() {
		return "consumer-mock";
	}

	@Override
	public ClientHttpResponse fallbackResponse() {
		return new ClientHttpResponse() {

			@Override
			public HttpHeaders getHeaders() {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
				return headers;
			}

			@Override
			public InputStream getBody() throws IOException {
				//zuul熔断器返回值
				ResultMsg msg = new ResultMsg(202, "微服务暂时不可用");
				ObjectMapper mapper = new ObjectMapper();
				String msgJson = mapper.writeValueAsString(msg);
				return new ByteArrayInputStream(msgJson.getBytes());
			}

			@Override
			public String getStatusText() throws IOException {
				return HttpStatus.BAD_REQUEST.getReasonPhrase();
			}

			@Override
			public HttpStatus getStatusCode() throws IOException {
				return HttpStatus.BAD_REQUEST;
			}

			@Override
			public int getRawStatusCode() throws IOException {
				return HttpStatus.BAD_REQUEST.value();
			}

			@Override
			public void close() {

			}
		};
	}
}
