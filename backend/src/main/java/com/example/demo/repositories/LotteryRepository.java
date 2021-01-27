package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Lottery;

@Repository
public interface LotteryRepository extends JpaRepository<Lottery, Long>{

}
