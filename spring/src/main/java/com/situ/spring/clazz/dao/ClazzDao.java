package com.situ.spring.clazz.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.situ.spring.clazz.pojo.Clazz;

@Repository
public interface ClazzDao {
	int save(Clazz clazz);

	int update(Clazz clazz);

	int delete(Long roeId);

	List<Clazz> find();

	Clazz findOneById(Long rowId);
}
