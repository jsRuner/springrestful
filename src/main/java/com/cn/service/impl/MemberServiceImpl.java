package com.cn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.base.BasicMapper;
import com.cn.base.BasicServiceImpl;
import com.cn.service.MemberService;
import com.cn.dao.MemberMapper;

@Service
public class MemberServiceImpl extends BasicServiceImpl implements MemberService {

	@Autowired
	MemberMapper member;

	@Override
	public BasicMapper getMapper() {
		return member;
	}

}
