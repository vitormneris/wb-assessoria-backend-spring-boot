package com.br.wb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WbApplication {

	public static void main(String[] args) {
		SpringApplication.run(WbApplication.class, args);
	}

	@Bean
	public WebDriver webDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-gpu");

		WebDriver webDriver = new ChromeDriver(options);

		webDriver.get("https://web.whatsapp.com/");
		return webDriver;
	}
}
