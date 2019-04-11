package cloud.gateway.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import cloud.gateway.zuul.filter.ApiSecurityFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient // zuul服务要注册到Eureka上
public class ZuulApp {
	public static void main(String[] args) {
		SpringApplication.run(ZuulApp.class, args);
	}

	//@Bean 暂时不启动zuul签名验证过滤器
	public ApiSecurityFilter apiSecurityilter() {
		return new ApiSecurityFilter();
	}
	
	@Bean
	public CorsFilter corsFilter() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.setMaxAge(18000L);
		// config.addAllowedMethod("*");
		config.addAllowedMethod("GET");
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}
}
