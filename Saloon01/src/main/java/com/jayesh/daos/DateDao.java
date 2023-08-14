package com.jayesh.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jayesh.dtos.StringDateDTO;
import com.jayesh.entites.Date;
@Repository
public interface DateDao extends JpaRepository<Date, Integer> {

	Date save(StringDateDTO sdate);

}
