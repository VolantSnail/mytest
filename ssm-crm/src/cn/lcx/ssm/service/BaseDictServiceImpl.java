package cn.lcx.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lcx.ssm.dao.BaseDictDao;
import cn.lcx.ssm.pojo.BaseDict;

@Service
public class BaseDictServiceImpl implements BaseDictService {

	@Autowired
	private BaseDictDao baseDictDao;
	
	
	public List<BaseDict> queryAllCustomer(String dictTypeCode) {
		
		return baseDictDao.queryAllCustomer(dictTypeCode);
	}

}
