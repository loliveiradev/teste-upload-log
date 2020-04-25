package com.lucasoliveira.uploadlog.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.lucasoliveira.uploadlog.api.entity.User;
import com.lucasoliveira.uploadlog.api.enums.ProfileEnum;
import com.lucasoliveira.uploadlog.api.repository.UserRepositoty;



@SpringBootApplication
public class UploadLogApplication {

	// main
	public static void main(String[] args) {

		SpringApplication.run(UploadLogApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepositoty useRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			initUsers(useRepository, passwordEncoder);
		};
	}

	private void initUsers(UserRepositoty userRepositoty, PasswordEncoder passwordEncoder) {
		User admin = new User();
		admin.setEmail("admin@prevent.com");
		admin.setPassword(passwordEncoder.encode("123456"));
		admin.setProfile(ProfileEnum.ROLE_ADMIN);

		User find = userRepositoty.findByEmail("admin@prevent.com");
		if (find == null) {
			userRepositoty.save(admin);
		}

	}

}
