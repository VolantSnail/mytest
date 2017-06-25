package cn.lcx.ssm.dao;

import java.util.List;

import cn.lcx.ssm.pojo.Customer;
import cn.lcx.ssm.pojo.QueryVo;

public interface CustomerDao {

	// 条件查询（查看用户信息） 
	public List<Customer> queryListCustomer(QueryVo queryVo);
	
	// 查询符合条件的数据有多少条
	public Integer queryCountCustomer(QueryVo queryVo);
	
	// 跳转到用户编辑页面数据回现
	public Customer toEditCustomer(Integer custId);
	
	// 修改客户信息
	public void updateCustomer(Customer customer);
	
	// 删除客户信息
	public void deleteCustomer(Integer id);
}
