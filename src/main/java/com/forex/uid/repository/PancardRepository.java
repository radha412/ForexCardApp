package com.forex.uid.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.forex.uid.entity.Pancard;

@Repository
public interface PancardRepository extends JpaRepository<Pancard, String>{
	Pancard  findBypancardNumber(String pancard);
}
