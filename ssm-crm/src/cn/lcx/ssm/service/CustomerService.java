package cn.lcx.ssm.service;

import cn.lcx.ssm.pojo.Customer;
import cn.lcx.ssm.pojo.QueryVo;
import cn.lcx.ssm.utils.Page;

public interface CustomerService {
	
	// //通过页面传递的参数 查询 分页 对象
	public Page<Customer> selectPageByQueryVo(QueryVo vo);
	
	// 跳转到用户编辑页面数据回现
	public Customer toEditCustomer(Integer custId);
	
	// 修改客户信息
	public void updateCustomer(Customer customer);
	
	// 删除客户信息
	public void deleteCustomer(Integer id);
}
