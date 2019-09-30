package zpq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import zpq.bean.Customer;
import zpq.bean.CustomerExample;
import zpq.dao.CustomerMapper;

@Controller
public class MyTestController {

	@Autowired
	private CustomerMapper customerMapper;

	@RequestMapping("qryAllCustomers")
	@ResponseBody
	public List<Customer> qryCustomer() {
		return customerMapper.selectByExample(new CustomerExample());
	}
}
