package com.kbtg.tech.repositories;

import org.springframework.data.repository.CrudRepository;

import com.kbtg.tech.dto.*;

public interface OrdersRepository extends CrudRepository<Order, Long> { }
