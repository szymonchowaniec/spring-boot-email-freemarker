package com.javatechie.email.api.repository;

import com.javatechie.email.api.entity.Metting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRepository extends JpaRepository<Metting, Long> {
}
