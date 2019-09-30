package zpq.dao;

import java.util.List;

import zpq.myConstants.ReportInfo;

public interface ReportMapper {
	//通过产品名称查询维修记录
	List<ReportInfo> selectServiceRptWithProdName();
	//通过时间查询维修记录
	List<ReportInfo> selectServiceRptByTime();
	//通过时间查询订单记录
	List<ReportInfo> selectOrderRptByTime();
	//通过产品名称查询订单记录
	List<ReportInfo> selectOrderRptWithProdName();
	//返回订单表中产品名的数量
	ReportInfo countOrderByProdName(String prodName);
}
