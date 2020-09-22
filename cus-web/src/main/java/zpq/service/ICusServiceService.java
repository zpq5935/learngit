package zpq.service;

import java.util.List;

import zpq.bean.Css;
import zpq.bean.Customer;
import zpq.bean.MainMan;
import zpq.bean.MyOrder;
import zpq.bean.Product;
import zpq.bean.RecordWithBLOBs;
import zpq.constants.Msg;
import zpq.constants.ReportInfo;

public interface ICusServiceService {

	/**
	 * 用户登陆
	 * 
	 * @param loginname
	 * @param password
	 * @param type:登陆人员类别{管理员，客服，维修工，客户}
	 * @return
	 */
	Msg login(String loginname, String password, String type);



	/**
	 * 更新Customer个人信息
	 * 
	 * @param manager
	 * @return
	 */
	public Msg updateCustomer(Customer customer, String oriAccount);

	/**
	 * 更新MainMan个人信息
	 * 
	 * @param manager
	 * @return
	 */
	public Msg updateMainMan(MainMan mainMan, String oriAccount);

	/**
	 * 更新Css个人信息
	 * 
	 * @param manager
	 * @return
	 */
	public Msg updateCusService(Css css, String oriAccount);



	public Msg addCustomer(Customer customer);

	public Msg addCss(Css css);

	public Msg addMainMan(MainMan mainMan);

	/**
	 * 
	 * @param account
	 * @param selectUserFormStatus
	 * @return
	 */
	public List selectUsers(String account, String selectUserFormStatus);

	/**
	 * 
	 * @param id
	 * @param selectUserHunmanType
	 */
	public Msg deleteUser(Integer id, String selectUserHunmanType);

	/**
	 * List参数批量删除员工
	 * 
	 * @param ids
	 * @param selectUserHunmanType
	 * @return
	 */
	public Msg deleteUsers(List<Integer> ids, String selectUserHunmanType);

	/**
	 * 根据id查找用户
	 * 
	 * @param id
	 * @param selectUserHunmanType
	 * @return
	 */
	public Msg findUserById(Integer id, String selectUserHunmanType);

	/**
	 * 根据账户及地址查询客户
	 * 
	 * @param account
	 * @param onelevelAddress
	 * @return
	 */
	public List<Customer> selectCustomer(String account, String onelevelAddress);

	/**
	 * 查询产品
	 * 
	 * @param proName
	 * @return
	 */
	public List<Product> selectProducts(String proName);

	/**
	 * 客服-查询订单
	 * 
	 * @param cssId
	 * @return
	 */
	public List<MyOrder> selectOrder(String cssNickname, String customerNickname, String prodName);
	/**
	 * 客户-查询订单
	 * @param cusid
	 * @param prodName
	 * @return
	 */
	public List<MyOrder> selectOrderByCusidAndProndame(Integer cusid, String prodName);

	public List<MyOrder> selectOrderByCusid(Integer cusid);

	/**
	 * 
	 * @param product
	 * @return
	 */
	public Msg addProduct(Product product);

	/**
	 * 更行产品
	 * 
	 * @param product
	 * @param oriProductName
	 * @return
	 */
	public Msg updateProduct(Product product, String oriProductName);

	/**
	 * 删除单个产品
	 * 
	 * @param id
	 * @return
	 */
	public Msg deleteProduct(Integer id);

	/**
	 * 删除多个商品
	 * 
	 * @param ids
	 * @return
	 */
	public Msg deleteProducts(List<Integer> ids);

	/**
	 * 根据ID查询产品
	 * 
	 * @param id
	 * @return
	 */
	public Msg findProductById(Integer id);

	/**
	 * 根据ID删除单个订单
	 * 
	 * @param id
	 * @return
	 */
	public Msg deleteOrder(Integer id);

	/**
	 * 根据ID删除多个订单
	 * 
	 * @param ids
	 * @return
	 */
	public Msg deleteOrders(List<Integer> ids);

	/**
	 * 
	 * @param myOrder
	 * @return
	 */
	public Msg updateOrder(MyOrder myOrder);

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Msg findOrderById(Integer id);

	/**
	 * 
	 * @param myOrder
	 * @return
	 */
	public Msg addOrder(MyOrder myOrder);

	/**
	 * 客户申请售后
	 * 
	 * @param record
	 * @return
	 */
	public Msg applyService(RecordWithBLOBs recordWithBLOBs);

	public List<RecordWithBLOBs> selectService(RecordWithBLOBs recordWithBLOBs);

	public Msg updateRecord(RecordWithBLOBs recordWithBLOBs, String oriStat);

	/**********************/
	/**
	 * 查询报表功能所需的按产品返回的维修记录表的频率
	 * @return
	 */
	public List<ReportInfo> selectServiceRptWithProdName();

	/**
	 * 查询报表功能所需的按月份返回的维修记录表
	 * @return
	 */
	public List<ReportInfo> selectServiceRptWithTime();
	/**
	 * 查询报表功能所需的按产品返回的维修记录的比例
	 * @return
	 */
	public List<ReportInfo> selectServiceRptWithPro_Per();

	/**
	 * 查询报表功能所需的按产品返回的维修记录表
	 * @return
	 */
	public List<ReportInfo> selectOrderRptWithProdName();
	/**
	 * 查询报表功能所需的按月份返回的维修记录表
	 * @return
	 */
	public List<ReportInfo> selectOrderRptWithProdTime();
}
