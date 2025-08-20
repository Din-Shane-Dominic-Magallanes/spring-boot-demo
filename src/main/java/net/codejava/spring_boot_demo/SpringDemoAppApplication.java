package net.codejava.spring_boot_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringDemoAppApplication {

	public static void main(String[] args) {
        SpringApplication.run(SpringDemoAppApplication.class, args);
	}

    @GetMapping
    public String helloWorld(){
        return "Hello World Spring Boot";
    }

}
