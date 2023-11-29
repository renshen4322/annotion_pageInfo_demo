package com.dn;

import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Properties;

@EnableDiscoveryClient
@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class})
@EnableAspectJAutoProxy
@EnableAsync
@MapperScan(basePackages = {"com.dn.dao"})
@Slf4j
public class PlusPageInfoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(PlusPageInfoApplication.class, args);
		ConfigurableApplicationContext run = SpringApplication.run(PlusPageInfoApplication.class);
		Environment env = run.getEnvironment();
		String port = env.getProperty("server.port");
		String path = env.getProperty("server.servlet.context-path");
		System.out.println("\n--------------------------------------\n\t" + "Application is running! Access URLs:\n\t" + "Local: \t\thttp://localhost:" + port + path+ "/doc.html\n\t" + "----------------------------------------------------------");
		log.info("PlusPageInfoApplication 启动成功=========================");
		System.out.println(new BCryptPasswordEncoder().encode(""));
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
