package com.forex.uid.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.forex.uid.entity.AdhaarCard;

@Repository
public interface AdhaarCardRepository extends JpaRepository<AdhaarCard, String>{

	public Optional<AdhaarCard> findByAdhaarNumber(Long adhaarNumber);
}
