package zpq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import zpq.bean.Customer;
import zpq.bean.CustomerExample;
import zpq.bean.MyOrder;
import zpq.bean.MyOrderExample;
import zpq.dao.CustomerMapper;
import zpq.dao.MyOrderMapper;

@Controller
public class MyTestController {

	@Autowired
	private CustomerMapper customerMapper;

	@Autowired
	private MyOrderMapper myOrderMapper;

	@RequestMapping("qryAllCustomers")
	@ResponseBody
	public List<Customer> qryAllCustomers() {
		return customerMapper.selectByExample(new CustomerExample());
	}

	@RequestMapping("qryAllOrders")
	@ResponseBody
	public List<MyOrder> qryAllOrders() {
		return myOrderMapper.selectByExample(new MyOrderExample());
	}
}
