package cn.lcx.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lcx.ssm.pojo.BaseDict;
import cn.lcx.ssm.pojo.Customer;
import cn.lcx.ssm.pojo.QueryVo;
import cn.lcx.ssm.service.BaseDictService;
import cn.lcx.ssm.service.CustomerService;
import cn.lcx.ssm.utils.Page;

@Controller
public class CustomerController {

	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private CustomerService customerService;
	
	// 处理硬编码问题
	@Value(value="${b.fromType}")
	private String ft;
	@Value(value="${b.industryType}")
	private String it;
	@Value(value="${b.levelType}")
	private String lt;
	
	
	@RequestMapping(value = "/customer/list.action")
	public String index(QueryVo queryVo, Model model){
		// 客户来源
		List<BaseDict> fromType = baseDictService.queryAllCustomer(ft);
		System.out.println(fromType);
		// 所属行业
		List<BaseDict> industryType = baseDictService.queryAllCustomer(it);
		
		// 客户级别
		List<BaseDict> levelType = baseDictService.queryAllCustomer(lt);
		
		
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		
		// 分页查询数据
		Page<Customer> page = customerService.selectPageByQueryVo(queryVo);
		// 把分页查询的结果放到模型中
		model.addAttribute("page", page);

		// 数据回显
		model.addAttribute("custName", queryVo.getCustName());
		model.addAttribute("custSource", queryVo.getCustSource());
		model.addAttribute("custIndustry", queryVo.getCustIndustry());
		model.addAttribute("custLevel", queryVo.getCustLevel());

		return "customer";
	} 
	
	
	// 跳转到客户信息修改页面
	@RequestMapping(value="customer/edit.action")
	public @ResponseBody Customer edit(Integer id){
		
		return customerService.toEditCustomer(id);
	}
	
	
	// 修改客户信息
	@RequestMapping(value="customer/update.action")
	@ResponseBody
	public String updateCust(Customer customer){
		customerService.updateCustomer(customer);
		return "ok";
	}
	
	
	// 删除客户信息
	@RequestMapping("customer/delete")
	@ResponseBody
	public String deleteCust(Integer id){
		customerService.deleteCustomer(id);
		return "ok";
	}
	
}
