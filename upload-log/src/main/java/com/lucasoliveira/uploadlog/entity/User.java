package com.lucasoliveira.uploadlog.entity;

import com.lucasoliveira.uploadlog.enums.ProfileEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity(name = "TB_USER")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    private String id;

    @NotBlank(message = "Email required")
    @Email(message = "Email invalid")
    private String email;


    @NotBlank(message = "Password required")
    @Size(min=6)
    private String password;

    private ProfileEnum profile;
}
