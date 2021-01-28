package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Lottery;
import com.example.demo.entities.User;

@Repository
public interface LotteryRepository extends JpaRepository<Lottery, Long>{
	public List<Lottery> findByUser(User user);
}
