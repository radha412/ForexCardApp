package com.forex.uid.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.forex.uid.entity.Passport;

@Repository
public interface PassportRepository extends JpaRepository<Passport, Integer>{
	Optional<Passport> findBypassportNumber(String passportNumber);
//
//	Optional<Passport> findById(Integer passportId);
	
}
