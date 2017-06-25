package cn.lcx.ssm.dao;

import java.util.List;

import cn.lcx.ssm.pojo.BaseDict;

public interface BaseDictDao {
	// 获取所有客户信息
	public List<BaseDict> queryAllCustomer(String dictTypeCode);
}
