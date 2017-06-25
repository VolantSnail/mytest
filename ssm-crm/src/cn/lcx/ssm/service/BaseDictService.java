package cn.lcx.ssm.service;

import java.util.List;

import cn.lcx.ssm.pojo.BaseDict;

public interface BaseDictService {

	// 获取所有客户信息
	public List<BaseDict> queryAllCustomer(String dictTypeCode);
}
