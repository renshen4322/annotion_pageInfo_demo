package com.dn;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Properties;

@EnableDiscoveryClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableAspectJAutoProxy
@EnableAsync
@MapperScan(basePackages = {"com.dn.dao"})
public class PlusPageInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlusPageInfoApplication.class, args);
		//System.out.println(new BCryptPasswordEncoder().encode("mark"));
	}

	//http://localhost:8080/swagger-ui.html#/

	// 配置mybatis的分页插件pageHelper
		@Bean
		public PageHelper pageHelper() {
			PageHelper pageHelper = new PageHelper();
			Properties properties = new Properties();
			properties.setProperty("offsetAsPageNum", "true");
			properties.setProperty("rowBoundsWithCount", "true");
			properties.setProperty("reasonable", "true");
			properties.setProperty("dialect", "mysql"); // 配置mysql数据库的方言
			pageHelper.setProperties(properties);
			return pageHelper;
		}
}
