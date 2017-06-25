package cn.lcx.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lcx.ssm.dao.CustomerDao;
import cn.lcx.ssm.pojo.Customer;
import cn.lcx.ssm.pojo.QueryVo;
import cn.lcx.ssm.utils.Page;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;

	public Page<Customer> selectPageByQueryVo(QueryVo queryVo) {
		Page<Customer> page = new Page<>();
		
		// 当前页 页面传递过来
		if (queryVo.getPage() == null) {
			queryVo.setPage(1);
		}
		page.setPage(queryVo.getPage());
		// 每页数
		page.setSize(5);
		queryVo.setSize(5);
		// 起始索引
		queryVo.setStart((queryVo.getPage() - 1) * queryVo.getSize());
		// 总条数
		page.setTotal(customerDao.queryCountCustomer(queryVo));
		// 结果集
		page.setRows(customerDao.queryListCustomer(queryVo));
		
		return page;
	}

	public Customer toEditCustomer(Integer custId) {
		
		return customerDao.toEditCustomer(custId);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
	}

	@Override
	public void deleteCustomer(Integer id) {
		customerDao.deleteCustomer(id);
	}
	
	
	
}
