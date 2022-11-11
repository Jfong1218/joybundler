package com.jonathanfong.joybu.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jonathanfong.joybu.models.Bundle;

@Repository
public interface BundleRepository extends CrudRepository<Bundle, Long> {
	List<Bundle> findAll();
}
