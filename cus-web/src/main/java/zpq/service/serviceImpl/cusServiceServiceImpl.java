package zpq.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zpq.bean.Css;
import zpq.bean.CssExample;
import zpq.bean.Customer;
import zpq.bean.CustomerExample;
import zpq.bean.MainMan;
import zpq.bean.MainManExample;
import zpq.bean.Manager;
import zpq.bean.ManagerExample;
import zpq.bean.MyOrder;
import zpq.bean.MyOrderExample;
import zpq.bean.Product;
import zpq.bean.ProductExample;
import zpq.bean.RecordExample;
import zpq.bean.RecordWithBLOBs;
import zpq.dao.CssMapper;
import zpq.dao.CustomerMapper;
import zpq.dao.MainManMapper;
import zpq.dao.ManagerMapper;
import zpq.dao.MyOrderMapper;
import zpq.dao.ProductMapper;
import zpq.dao.RecordMapper;
import zpq.dao.ReportMapper;
import zpq.myConstants.Constrants;
import zpq.myConstants.Msg;
import zpq.myConstants.ReportInfo;
import zpq.service.cusServiceService;

/**
 * cusService服务层接口实现类
 * 
 * @author zcp
 * 修改了数据库，添加了是否删除字段；删除操作不再是真正删除数据，而是修改该字段
 */
@Service("cusServiceService")
public class cusServiceServiceImpl implements cusServiceService {
	@Autowired
	private ManagerMapper managerMapper;
	@Autowired
	private CssMapper cssMapper;
	@Autowired
	private MainManMapper mainManMapper;
	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private MyOrderMapper myOrderMapper;
	@Autowired
	private RecordMapper recordMapper;
	@Autowired
	private ReportMapper reportMapper;

	// 准则查询
	private ManagerExample managerExample;
	private zpq.bean.ManagerExample.Criteria managerCriteria;
	private CssExample cssExample;
	private zpq.bean.CssExample.Criteria cssCriteria;
	private MainManExample mainManExample;
	private zpq.bean.MainManExample.Criteria mainMancriteria;
	private CustomerExample customerExample;
	private zpq.bean.CustomerExample.Criteria customerCriteria;

	//
	private Log logger = LogFactory.getLog(getClass());

	/*************** 接口实现 ****************************/
	/**
	 * 用户登陆
	 * 
	 * @param loginname
	 * @param password
	 * @param type:登陆人员类别{管理员，客服，维修工，客户}
	 * @return
	 */
	@Override
	public Msg login(String account, String password, String hunmanType) {
		// boolean flag = false;
		// 保存登录与否的标识，还有登录人员的信息
		// Map<String, Object> info = new HashMap<>();
		switch (hunmanType) {
		// 管理员
		case Constrants.MANAGER:
			managerExample = new ManagerExample();
			managerCriteria = managerExample.createCriteria();
			managerCriteria.andAccountEqualTo(account);
			managerCriteria.andPasswordEqualTo(password);
			managerCriteria.andIsdeletedEqualTo(false);
			if (0 != managerMapper.countByExample(managerExample)) {
				// flag = true;
				return Msg.success().add("user", managerMapper.selectByExample(managerExample));
			}
			break;
		// 客服
		case Constrants.CUSSERVICER:
			cssExample = new CssExample();
			cssCriteria = cssExample.createCriteria();
			cssCriteria.andAccountEqualTo(account);
			cssCriteria.andPasswordEqualTo(password);
			cssCriteria.andIsdeletedEqualTo(false);
			if (0 != cssMapper.countByExample(cssExample))
				return Msg.success().add("user", cssMapper.selectByExample(cssExample));
			break;
		// 维修员
		case Constrants.MAINMAN:
			mainManExample = new MainManExample();
			mainMancriteria = mainManExample.createCriteria();
			mainMancriteria.andAccountEqualTo(account);
			mainMancriteria.andPasswordEqualTo(password);
			mainMancriteria.andIsdeletedEqualTo(false);
			if (0 != mainManMapper.countByExample(mainManExample))
				return Msg.success().add("user", mainManMapper.selectByExample(mainManExample));
			break;
		// 客户
		case Constrants.CUSTOMER:
			customerExample = new CustomerExample();
			customerCriteria = customerExample.createCriteria();
			customerCriteria.andAccountEqualTo(account);
			customerCriteria.andPasswordEqualTo(password);
			customerCriteria.andIsdeletedEqualTo(false);
			if (0 != customerMapper.countByExample(customerExample))
				return Msg.success().add("user", customerMapper.selectByExample(customerExample));
			break;
		default:
			break;
		}
		return Msg.fail();
	}

	/**
	 * 更新Manager个人信息
	 */
	public Msg updateManager(Manager manager, String oriAccount) {
		// 检查用户名唯一
		managerExample = new ManagerExample();
		managerCriteria = managerExample.createCriteria();
		managerCriteria.andAccountEqualTo(manager.getAccount());
		if (manager.getAccount().equals(oriAccount)) {
			// 不需任何操作
		} else if (!managerMapper.selectByExample(managerExample).isEmpty()) {
			// 不唯一
			return Msg.fail().add("msg", "修改失败：用户名【" + manager.getAccount() + "】已存在");
		}
		manager.setIsdeleted(false);
		if (managerMapper.updateByPrimaryKey(manager) != 0)
			return Msg.success().add("msg", "修改成功" + manager);
		return Msg.fail().add("msg", "修改失败：原因未知");
	}

	/**
	 * 更新Customer个人信息
	 */
	public Msg updateCustomer(Customer customer, String oriAccount) {
		// 检查用户名唯一
		customerExample = new CustomerExample();
		customerCriteria = customerExample.createCriteria();
		customerCriteria.andAccountEqualTo(customer.getAccount());
		if (customer.getAccount().equals(oriAccount)) {
			// 不需任何操作
		} else if (!customerMapper.selectByExample(customerExample).isEmpty()) {
			// 不唯一
			return Msg.fail().add("msg", "修改失败：用户名【" + customer.getAccount() + "】已存在");
		}
		customer.setIsdeleted(false);
		if (customerMapper.updateByPrimaryKey(customer) != 0)
			return Msg.success().add("msg", "修改成功" + customer);
		return Msg.fail().add("msg", "修改失败：原因未知");
	}

	/**
	 * 更新MainMan个人信息
	 */
	public Msg updateMainMan(MainMan mainMan, String oriAccount) {
		// 检查用户名唯一
		mainManExample = new MainManExample();
		mainMancriteria = mainManExample.createCriteria();
		mainMancriteria.andAccountEqualTo(mainMan.getAccount());
		if (mainMan.getAccount().equals(oriAccount)) {
			// 不需任何操作
		} else if (!mainManMapper.selectByExample(mainManExample).isEmpty()) {
			// 不唯一
			return Msg.fail().add("msg", "修改失败：用户名【" + mainMan.getAccount() + "】已存在");
		}
		mainMan.setIsdeleted(false);
		if (mainManMapper.updateByPrimaryKey(mainMan) != 0)
			return Msg.success().add("msg", "修改成功" + mainMan);
		return Msg.fail().add("msg", "修改失败：原因未知");
	}

	/**
	 * 更新Css个人信息
	 */
	public Msg updateCusService(Css css, String oriAccount) {
		// 检查用户名唯一
		cssExample = new CssExample();
		cssCriteria = cssExample.createCriteria();
		cssCriteria.andAccountEqualTo(css.getAccount());
		if (css.getAccount().equals(oriAccount)) {
			// 不需任何操作
		} else if (!cssMapper.selectByExample(cssExample).isEmpty()) {
			// 不唯一
			return Msg.fail().add("msg", "修改失败：用户名【" + css.getAccount() + "】已存在");
		}
		css.setIsdeleted(false);
		if (cssMapper.updateByPrimaryKey(css) != 0)
			return Msg.success().add("msg", "修改成功" + css);
		return Msg.fail().add("msg", "修改失败：原因未知");
	}

	/**
	 * 添加各类人员
	 */
	public Msg addManager(Manager manager) {
		managerExample = new ManagerExample();
		managerCriteria = managerExample.createCriteria();
		managerCriteria.andAccountEqualTo(manager.getAccount());
		if (!managerMapper.selectByExample(managerExample).isEmpty()) {
			return Msg.fail().add("msg", "添加失败：用户名【" + manager.getAccount() + "】已存在");
		}
		if (managerMapper.insertSelective(manager) != 0) {
			return Msg.success().add("msg", "添加成功：用户【" + manager.getAccount() + "】");
		}
		return Msg.fail().add("msg", "添加失败：原因未知");
	}

	public Msg addCustomer(Customer customer) {
		customerExample = new CustomerExample();
		customerCriteria = customerExample.createCriteria();
		customerCriteria.andAccountEqualTo(customer.getAccount());
		if (!customerMapper.selectByExample(customerExample).isEmpty()) {
			return Msg.fail().add("msg", "添加失败：用户名【" + customer.getAccount() + "】已存在");
		}
		if (customerMapper.insertSelective(customer) != 0) {
			return Msg.success().add("msg", "添加成功：用户【" + customer.getAccount() + "】");
		}
		return Msg.fail().add("msg", "添加失败：原因未知");
	}

	public Msg addCss(Css css) {
		cssExample = new CssExample();
		cssCriteria = cssExample.createCriteria();
		cssCriteria.andAccountEqualTo(css.getAccount());
		if (!cssMapper.selectByExample(cssExample).isEmpty()) {
			return Msg.fail().add("msg", "添加失败：用户名【" + css.getAccount() + "】已存在");
		}
		if (cssMapper.insertSelective(css) != 0) {
			return Msg.success().add("msg", "添加成功：用户【" + css.getAccount() + "】");
		}
		return Msg.fail().add("msg", "添加失败：原因未知");
	}

	public Msg addMainMan(MainMan mainMan) {
		mainManExample = new MainManExample();
		mainMancriteria = mainManExample.createCriteria();
		mainMancriteria.andAccountEqualTo(mainMan.getAccount());
		if (!mainManMapper.selectByExample(mainManExample).isEmpty()) {
			return Msg.fail().add("msg", "添加失败：用户名【" + mainMan.getAccount() + "】已存在");
		}
		if (mainManMapper.insertSelective(mainMan) != 0) {
			return Msg.success().add("msg", "添加成功：用户【" + mainMan.getAccount() + "】");
		}
		return Msg.fail().add("msg", "添加失败：原因未知");
	}

	public List selectUsers(String account, String selectUserHunmanType) {
		List users = new ArrayList<>();
		// System.out.println(account+" | "+selectUserHunmanType);
		switch (selectUserHunmanType) {
		case Constrants.MANAGER:
			managerExample = new ManagerExample();
			managerCriteria = managerExample.createCriteria();
			managerCriteria.andIsdeletedEqualTo(false);
			if (account != null && account.length() > 0)
				managerCriteria.andAccountLike("%" + account + "%");
			users = managerMapper.selectByExample(managerExample);
			break;
		case Constrants.CUSSERVICER:
			cssExample = new CssExample();
			cssCriteria = cssExample.createCriteria();
			cssCriteria.andIsdeletedEqualTo(false);
			if (account != null && account.length() > 0)
				cssCriteria.andAccountLike("%" + account + "%");
			users = cssMapper.selectByExample(cssExample);
			break;
		case Constrants.CUSTOMER:
			customerExample = new CustomerExample();
			customerCriteria = customerExample.createCriteria();
			customerCriteria.andIsdeletedEqualTo(false);
			if (account != null && account.length() > 0)
				customerCriteria.andAccountLike("%" + account + "%");
			users = customerMapper.selectByExample(customerExample);
			break;
		case Constrants.MAINMAN:
			mainManExample = new MainManExample();
			mainMancriteria = mainManExample.createCriteria();
			mainMancriteria.andIsdeletedEqualTo(false);
			if (account != null && account.length() > 0)
				mainMancriteria.andAccountLike("%" + account + "%");
			users = mainManMapper.selectByExample(mainManExample);
			break;
		}
		return users;
	}
	
	/**
	 * 根据id及用户类型删除用户,返回0表示删除失败，1就是成功了;
	 * 
	 */
	public Msg deleteUser(Integer id, String selectUserHunmanType) {
		int returnInt = 0;
		switch (selectUserHunmanType) {
		case Constrants.MANAGER:
			Manager manager = new Manager();
			manager.setIsdeleted(true);
			manager.setId(id);
			returnInt = managerMapper.updateByPrimaryKeySelective(manager);
			break;
		case Constrants.CUSSERVICER:
			Css css = new Css();
			css.setIsdeleted(true);
			css.setId(id);
			returnInt = cssMapper.updateByPrimaryKeySelective(css);
			break;
		case Constrants.CUSTOMER:
			Customer customer = new Customer();
			customer.setIsdeleted(true);
			customer.setId(id);
			returnInt = customerMapper.updateByPrimaryKeySelective(customer);
			break;
		case Constrants.MAINMAN:
			MainMan mainMan = new MainMan();
			mainMan.setIsdeleted(true);
			mainMan.setId(id);
			returnInt = mainManMapper.updateByPrimaryKeySelective(mainMan);
			break;
		}
		return (returnInt == 0) ? Msg.fail().add("msg", "删除失败！" + "id=" + id)
				: Msg.success().add("msg", "删除成功!" + "id=" + id);
	}
	
	/**
	 * List参数批量删除员工
	 * 
	 * @param ids
	 * @param selectUserHunmanType
	 * @return
	 */
	public Msg deleteUsers(List<Integer> ids, String selectUserHunmanType) {
		int flag = 0;
		switch (selectUserHunmanType) {
		case Constrants.MANAGER:
			managerExample = new ManagerExample();
			managerCriteria = managerExample.createCriteria();
			managerCriteria.andIdIn(ids);
			Manager manager = new Manager();
			manager.setIsdeleted(true);
			flag = managerMapper.updateByExampleSelective(manager, managerExample);
//			flag = managerMapper.deleteByExample(managerExample);
			break;
		case Constrants.CUSSERVICER:
			cssExample = new CssExample();
			cssCriteria = cssExample.createCriteria();
			cssCriteria.andIdIn(ids);
			Css css = new Css();
			css.setIsdeleted(true);
			flag = cssMapper.updateByExampleSelective(css, cssExample);
//			flag = cssMapper.deleteByExample(cssExample);
			break;
		case Constrants.CUSTOMER:
			customerExample = new CustomerExample();
			customerCriteria = customerExample.createCriteria();
			customerCriteria.andIdIn(ids);
			Customer customer = new Customer();
			customer.setIsdeleted(true);
			flag = customerMapper.updateByExampleSelective(customer, customerExample);
//			flag = customerMapper.deleteByExample(customerExample);
			break;
		case Constrants.MAINMAN:
			mainManExample = new MainManExample();
			mainMancriteria = mainManExample.createCriteria();
			managerCriteria.andIdIn(ids);
			MainMan mainMan = new MainMan();
			mainMan.setIsdeleted(true);
			flag = mainManMapper.updateByExampleSelective(mainMan, mainManExample);
//			flag = mainManMapper.deleteByExample(mainManExample);
			break;
		}
		return (flag == 0) ? Msg.fail().add("msg", "批量删除失败！" + ids) : Msg.success().add("msg", "批量删除成功!" + ids);
	}

	/**
	 * 通过Id查询用户
	 */
	public Msg findUserById(Integer id, String selectUserHunmanType) {
		switch (selectUserHunmanType) {
		case Constrants.CUSTOMER:
			Customer customer = customerMapper.selectByPrimaryKey(id);
			return Msg.success().add("user", customer).add("msg", "查询成功！" + customer);
		case Constrants.MAINMAN:
			MainMan mainMan = mainManMapper.selectByPrimaryKey(id);
			return Msg.success().add("user", mainMan).add("msg", "查询成功！" + mainMan);
		case Constrants.MANAGER:
			Manager manager = managerMapper.selectByPrimaryKey(id);
			return Msg.success().add("user", manager).add("msg", "查询成功！" + manager);
		case Constrants.CUSSERVICER:
			Css css = cssMapper.selectByPrimaryKey(id);
			return Msg.success().add("user", css).add("msg", "查询成功！" + css);
		default:
			break;
		}
		return Msg.fail().add("msg", "查询失败！ID=" + id);
	}

	/*********************************** 客户相关 ******************************************/
	@Override
	public List<Customer> selectCustomer(String account, String onelevelAddress) {
		List<Customer> customers = new ArrayList<>();
		customerExample = new CustomerExample();
		customerCriteria = customerExample.createCriteria();
		if (account != null && account.length() > 0) {
			customerCriteria.andAccountLike("%" + account + "%");
		}
		if (onelevelAddress != null && onelevelAddress != "" && onelevelAddress.length() > 0) {
			logger.info("onelevelAddress = " + onelevelAddress);
			customerCriteria.andOnelevelAddressEqualTo(onelevelAddress);
		}
		customerCriteria.andIsdeletedEqualTo(false);
		customers = customerMapper.selectByExample(customerExample);
		return customers;
	}

	/*********************************** 产品相关 ******************************************/
	/**
	 * 查询产品
	 * 
	 * @param proName
	 * @return
	 */
	public List<Product> selectProducts(String proName) {
		ProductExample productExample = new ProductExample();
		zpq.bean.ProductExample.Criteria productCriteria = productExample.createCriteria();
		productCriteria.andIsdeletedEqualTo(false);
		if (proName != null && proName.length() > 0)
			productCriteria.andProdnameLike("%" + proName + "%");
		List<Product> products = productMapper.selectByExample(productExample);
		return products;
	}

	public Msg addProduct(Product product) {
		ProductExample productExample = new ProductExample();
		ProductExample.Criteria criteria = productExample.createCriteria();
		criteria.andProdnameEqualTo(product.getProdname());
		if (!productMapper.selectByExample(productExample).isEmpty()) {
			return Msg.fail().add("msg", "添加失败！产品名已存在：" + product.getProdname());
		}
		if (productMapper.insert(product) != 0) {
			return Msg.success().add("msg", "添加成功！" + product);
		}
		return Msg.fail().add("msg", "添加失败！原因未知！");
	}

	/**
	 * 更新产品
	 * 
	 * @param product
	 * @param oriProductName
	 * @return
	 */
	public Msg updateProduct(Product product, String oriProductName) {
		// 检查名称唯一
		ProductExample productExample = new ProductExample();
		ProductExample.Criteria criteria = productExample.createCriteria();
		criteria.andProdnameEqualTo(product.getProdname());
		if (product.getProdname().equals(oriProductName)) {
			// 不需任何操作
		} else if (!productMapper.selectByExample(productExample).isEmpty()) {
			// 名称不唯一
			return Msg.fail().add("msg", "修改失败：产品名【" + product.getProdname() + "】已存在");
		}
		if (productMapper.updateByPrimaryKey(product) != 0)
			return Msg.success().add("msg", "修改成功" + product);
		return Msg.fail().add("msg", "修改失败：原因未知");
	}

	/**
	 * 删除单个产品
	 * 
	 * @param id
	 * @return
	 */
	public Msg deleteProduct(Integer id) {
		int flag = 0;
		Product product = new Product();
		product.setIsdeleted(true);
		product.setId(id);
//		flag = productMapper.deleteByPrimaryKey(id);
		flag = productMapper.updateByPrimaryKeySelective(product);
		return (flag == 0) ? Msg.fail().add("msg", "产品删除失败！" + "id=" + id)
				: Msg.success().add("msg", "产品删除成功!" + "id=" + id);
	}

	/**
	 * 删除多个商品
	 * 
	 * @param ids
	 * @return
	 */
	public Msg deleteProducts(List<Integer> ids) {
		int flag = 0;
		ProductExample example = new ProductExample();
		zpq.bean.ProductExample.Criteria criteria = example.createCriteria();
		criteria.andIdIn(ids);
		Product product = new Product();
		product.setIsdeleted(true);
//		flag = productMapper.deleteByExample(example);
		flag = productMapper.updateByExampleSelective(product, example);
		return (flag == 0) ? Msg.fail().add("msg", "产品删除失败！" + "ids=" + ids)
				: Msg.success().add("msg", "产品删除成功!" + "ids=" + ids);
	}

	/**
	 * 根据ID查询产品
	 * 
	 * @param id
	 * @return
	 */
	public Msg findProductById(Integer id) {
		ProductExample example = new ProductExample();
		ProductExample.Criteria criteria= example.createCriteria();
		criteria.andIsdeletedEqualTo(false);
		criteria.andIdEqualTo(id);
//		Product product = productMapper.selectByPrimaryKey(id);
		List<Product> products = productMapper.selectByExample(example);
		if (products.size()!=0)
			return Msg.success().add("product", products.get(0)).add("msg", "查询到ID为" + id + "的产品为" + products.get(0));
		return Msg.fail().add("msg", "未查到产品，ID为" + id);
	}
///*************************************************************************/
	/*************************************************************************/
	/**************************gaigaigai改改改改改改***********************************************/
	/*************************************************************************/
	
	/*********************************** 订单相关 ******************************************/
	/**
	 * 非客户查询全部查询订单
	 * 
	 * @param cssId
	 * @return
	 */
	public List<MyOrder> selectOrder(String cssNickname, String customerNickname, String prodName) {
		MyOrderExample myOrderExample = new MyOrderExample();
		MyOrderExample.Criteria criteria = myOrderExample.createCriteria();
		if (cssNickname != null && cssNickname.length() > 0) {
			criteria.andCssNicknameLike("%" + cssNickname + "%");
			// logger.info(cssNickname);
		}
		if (customerNickname != null && customerNickname.length() > 0) {
			criteria.andCustNicknameLike("%" + customerNickname + "%");
			// logger.info(customerNickname);
		}
		if (prodName != null && prodName.length() > 0) {
			criteria.andProdNameLike("%" + prodName + "%");
			// logger.info(prodName);
		}
//		criteria.andIsdeletedEqualTo(false);
		List<MyOrder> myOrders = myOrderMapper.selectMoreByExample(myOrderExample);
		return myOrders;
	}
	/**
	 * 客户查询自己的订单
	 */
	public List<MyOrder> selectOrderByCusidAndProndame(Integer cusid, String prodName){
		List<MyOrder> myOrders = null;
		MyOrderExample example = new MyOrderExample();
		MyOrderExample.Criteria criteria = example.createCriteria();
		criteria.andCusidEqualTo(cusid);
		if (prodName != null && prodName.length() > 0) {
			criteria.andProdNameLike("%" + prodName + "%");
			// logger.info(prodName);
		}
//		criteria.andIsdeletedEqualTo(false);
		myOrders = myOrderMapper.selectMoreByExample(example);
		return myOrders;
	}
	/**
	 * 返回JSON，用于客户申请售后时ajax查询已有订单
	 */
	public List<MyOrder> selectOrderByCusid(Integer cusid) {
		List<MyOrder> myOrders = null;
		MyOrderExample example = new MyOrderExample();
		MyOrderExample.Criteria criteria = example.createCriteria();
		criteria.andCusidEqualTo(cusid);
//		criteria.andIsdeletedEqualTo(false);
		myOrders = myOrderMapper.selectMoreByExample(example);
		return myOrders;
	}

	/**
	 * 删除单个订单
	 * 
	 * @param id
	 * @return
	 */
	public Msg deleteOrder(Integer id) {
		int flag = 0;
		MyOrder order = new MyOrder();
		order.setIsdeleted(true);
		order.setId(id);
		flag = myOrderMapper.updateByPrimaryKeySelective(order);
		return (flag == 0) ? Msg.fail().add("msg", "订单删除失败！" + "id=" + id)
				: Msg.success().add("msg", "订单删除成功!" + "id=" + id);
	}

	/**
	 * 删除多个订单
	 * 
	 * @param ids
	 * @return
	 */
	public Msg deleteOrders(List<Integer> ids) {
		int flag = 0;
		MyOrderExample example = new MyOrderExample();
		MyOrderExample.Criteria criteria = example.createCriteria();
		criteria.andIdIn(ids);
		MyOrder order = new MyOrder();
		order.setIsdeleted(true);
		flag = myOrderMapper.updateByExampleSelective(order, example);
		return (flag == 0) ? Msg.fail().add("msg", "订单删除失败！" + "ids=" + ids)
				: Msg.success().add("msg", "订单删除成功!" + "ids=" + ids);
	}

	/**
	 * 根据ID查询单个订单,用于更新订单前查询
	 */
	public Msg findOrderById(Integer id) {
		MyOrder myOrder = null;
		myOrder = myOrderMapper.selectByPrimaryKey(id);
		if (myOrder != null) {
			return Msg.success().add("myOrder", myOrder).add("msg", "查询成功!" + myOrder);
		}
		
		return Msg.fail().add("msg", "查询失败!id=" + id);
	}

	/**
	 * 更新订单
	 */
	public Msg updateOrder(MyOrder myOrder) {
		if (0 != myOrderMapper.updateByPrimaryKeyWithBLOBs(myOrder)) {
			return Msg.success().add("msg", "更新成功！" + myOrder);
		}
		return Msg.fail().add("msg", "更新失败!" + myOrder + "原因未知.");
	}

	/**
	 * 
	 */
	public Msg addOrder(MyOrder myOrder) {
		if (0 != myOrderMapper.insertSelective(myOrder)) {
			return Msg.success().add("msg", "订单添加成功！" + myOrder);
		}
		return Msg.fail().add("msg", "订单添加失败！原因未知！");
	}

	/******************************* 维修记录 ********************************/
	public Msg applyService(RecordWithBLOBs recordWithBLOBs) {
		if (0 != recordMapper.insertSelective(recordWithBLOBs)) {
			return Msg.success().add("msg", "申请售后成功！" + recordWithBLOBs);
		}
		return Msg.fail().add("msg", "申请售后失败！" + recordWithBLOBs);
	}

	public List<RecordWithBLOBs> selectService(RecordWithBLOBs recordWithBLOBs) {
		List<RecordWithBLOBs> records = new ArrayList<>();
		RecordExample example = new RecordExample();
		RecordExample.Criteria criteria = example.createCriteria();
		if (recordWithBLOBs.getStatus() != null && recordWithBLOBs.getStatus().length() > 0) {
			criteria.andStatusEqualTo(recordWithBLOBs.getStatus());
		}
		if (recordWithBLOBs.getCusid() != null) {
//			criteria.andCusidEqualTo(recordWithBLOBs.getCusid());
			criteria.andRecord_CusidEqualTo(recordWithBLOBs.getCusid());
		}
		if (recordWithBLOBs.getMmid() != null) {
			criteria.andMmidEqualTo(recordWithBLOBs.getMmid());
		}
		// records = recordMapper.selectByExampleWithBLOBs(example);
		records = recordMapper.selectMoreByExample(example);
		return records;
	}

	public Msg updateRecord(RecordWithBLOBs recordWithBLOBs,String oriStat) {
		RecordExample example = new RecordExample();
		RecordExample.Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(oriStat);
		criteria.andIdEqualTo(recordWithBLOBs.getId());
		if (0 != recordMapper.updateByExampleSelective(recordWithBLOBs, example)) {
			// if(0!=recordMapper.updateByPrimaryKeySelective(recordWithBLOBs)){
			return Msg.success().add("msg", "更新成功！" + recordWithBLOBs);
		}
		return Msg.fail().add("msg", "更新失败！原因未知！" + recordWithBLOBs);
	}
	
	/********************统计报表所需**************************/
	/**
	 * 查询报表功能所需的按产品返回的维修记录表
	 * @return
	 */
	@Override
	public List<ReportInfo> selectServiceRptWithProdName(){
		List<ReportInfo> reportInfos = null;
		reportInfos =  reportMapper.selectServiceRptWithProdName();
//		logger.info("reportInfos"+reportInfos);
		return reportInfos;
	}
	/**
	 * 
	 */
	@Override
	public List<ReportInfo> selectServiceRptWithPro_Per(){
		List<ReportInfo> list = new ArrayList<>();
		List<ReportInfo> reportInfos = null;
		reportInfos =  reportMapper.selectServiceRptWithProdName();
		if(reportInfos.size()==0)
			return null;
		for(ReportInfo rInfo:reportInfos){
			ReportInfo rInfo2 = reportMapper.countOrderByProdName(rInfo.getxAxis());
			rInfo2.setSizeByDouble(rInfo.getSize()/rInfo2.getSize());
			list.add(rInfo2);
		}
//		logger.info("reportInfos"+reportInfos);
		return list;
	}

	/**
	 * 查询报表功能所需的按月份返回的维修记录表
	 * @return
	 */
	@Override
	public	 List<ReportInfo> selectServiceRptWithTime(){
		List<ReportInfo> reportInfos = null;
		reportInfos =  reportMapper.selectServiceRptByTime();
		//logger.info("reportInfos"+reportInfos);
		return reportInfos;
	}

	/**
	 * 查询报表功能所需的按产品返回的维修记录表
	 * @return
	 */
	@Override
	public List<ReportInfo> selectOrderRptWithProdName(){
		List<ReportInfo> reportInfos = null;
		reportInfos =  reportMapper.selectOrderRptWithProdName();
		//logger.info("reportInfos"+reportInfos);
		return reportInfos;
	}
	/**
	 * 查询报表功能所需的按月份返回的维修记录表
	 * @return
	 */
	@Override
	public List<ReportInfo> selectOrderRptWithProdTime(){
		List<ReportInfo> reportInfos = null;
		reportInfos =  reportMapper.selectOrderRptByTime();
		//logger.info("reportInfos"+reportInfos);
		return reportInfos;
	}

	
}
