package com.usermanagement.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usermanagement.assignment.model.Syslog;

@Repository
public interface SyslogRepo extends JpaRepository<Syslog,Long>{
}