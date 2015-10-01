package com.sathish.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sathish.jba.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
