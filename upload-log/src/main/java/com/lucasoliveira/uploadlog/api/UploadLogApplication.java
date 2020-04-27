package com.lucasoliveira.uploadlog.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.lucasoliveira.uploadlog.api.entity.User;
import com.lucasoliveira.uploadlog.api.enums.ProfileEnum;
import com.lucasoliveira.uploadlog.api.repository.UserRepositoty;
import com.lucasoliveira.uploadlog.api.service.UploadService;



@SpringBootApplication
public class UploadLogApplication {

	// main
	public static void main(String[] args) {

		SpringApplication.run(UploadLogApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepositoty useRepository, PasswordEncoder passwordEncoder, UploadService uploadService) {
		return args -> {
			initUsers(useRepository, passwordEncoder);
			upload(uploadService);
		};
	}

	private void upload(UploadService uploadService) {
		uploadService.upload();
		
	}

	private void initUsers(UserRepositoty userRepositoty, PasswordEncoder passwordEncoder) {
		User admin = new User();
		admin.setEmail("admin@prevent.com");
		admin.setPassword(passwordEncoder.encode("123456"));
		admin.setProfile(ProfileEnum.ROLE_ADMIN);
		
		User custumer = new User();
		custumer.setEmail("custumer@prevent.com");
		custumer.setPassword(passwordEncoder.encode("123456"));
		custumer.setProfile(ProfileEnum.ROLE_CUSTOMER);

		User findAdmin = userRepositoty.findByEmail("admin@prevent.com");
		if (findAdmin == null) {
			userRepositoty.save(admin);
		}
		
		User findCustumer = userRepositoty.findByEmail("custumer@prevent.com");
		if (findCustumer == null) {
			userRepositoty.save(custumer);
		}

	}
}
