package com.usermanagement.assignment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "syslog")
public class Syslog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String url;

    private Integer time;

    private String method;

    private String params;

    private String ip;

    private String location;

    @CreationTimestamp
    private Timestamp createTime;
}