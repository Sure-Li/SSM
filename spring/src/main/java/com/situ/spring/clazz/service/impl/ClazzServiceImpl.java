package com.situ.spring.clazz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.spring.clazz.dao.ClazzDao;
import com.situ.spring.clazz.service.ClazzService;
@Service
public class ClazzServiceImpl implements ClazzService {
	@Autowired
	private ClazzDao  clazzDao;
}
