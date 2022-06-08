package com.example.JavaSpringLearning;

import com.example.JavaSpringLearning.models.ProductModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class JavaSpringLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringLearningApplication.class, args);
	}

}
