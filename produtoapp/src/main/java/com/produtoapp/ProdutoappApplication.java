package com.produtoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;

@SpringBootApplication(scanBasePackages="com.produtoapp.controller")
public class ProdutoappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProdutoappApplication.class, args);
	}

}
