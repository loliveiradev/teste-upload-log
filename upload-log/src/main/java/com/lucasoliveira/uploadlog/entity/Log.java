package com.lucasoliveira.uploadlog.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import javax.persistence.*;
import java.util.Date;

@Entity(name = "TB_LOG")
@Getter
@Setter
@NoArgsConstructor
public class Log  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private String ip;

    private String status;

    private String userAgent;

    public Log(Long id, Date date, String ip, String status, String userAgent) {
        this.id = id;
        this.date = date;
        this.ip = ip;
        this.status = status;
        this.userAgent = userAgent;
    }
}
