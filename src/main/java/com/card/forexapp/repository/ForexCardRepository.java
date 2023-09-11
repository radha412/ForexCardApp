package com.card.forexapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.card.forexapp.entity.ForexCard;
import java.util.Optional;

public interface ForexCardRepository extends JpaRepository<ForexCard, Integer> {

	Optional<ForexCard> findByForexCardNumber(Long forexCardNumber);

}
