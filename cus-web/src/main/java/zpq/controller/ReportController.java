package zpq.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import zpq.constants.ReportInfo;
import zpq.service.ICusServiceService;

@RequestMapping("report")
@Controller
public class ReportController {
	
	@Autowired
	@Qualifier("cusServiceService")
	private ICusServiceService cusServiceService;

//	private Log logger = LogFactory.getLog(getClass());
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	/****************************************/
	
	/**
	 * 通过产品分类查询维修记录-次数
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="serviceReportByProd",method=RequestMethod.GET)
	public List<ReportInfo> serviceReportByProd(){
		List<ReportInfo> reportInfos = null;
		reportInfos =  cusServiceService.selectServiceRptWithProdName();
		logger.info(reportInfos.toString());
		return reportInfos;
	}
	/**
	 * 通过产品分类查询维修记录-比例
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="serviceReportByProdPer",method=RequestMethod.GET)
	public List<ReportInfo> serviceReportByProdPer(){
		List<ReportInfo> reportInfos = null;
		reportInfos =  cusServiceService.selectServiceRptWithPro_Per();
		logger.info(reportInfos.toString());
		return reportInfos;
	}
	/**
	 * 通过时间分类查询维修记录
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="serviceReportByTime",method=RequestMethod.GET)
	public List<ReportInfo> serviceReportByTime(){
		List<ReportInfo> reportInfos = null;
		reportInfos =  cusServiceService.selectServiceRptWithTime();
		logger.info(reportInfos.toString());
		return reportInfos;
	}
	/**
	 * 通过产品分类查询订单记录
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="orderReportByProd",method=RequestMethod.GET)
	public List<ReportInfo> orderReportByProd(){
		List<ReportInfo> reportInfos = null;
		reportInfos =  cusServiceService.selectOrderRptWithProdName();
		logger.info(reportInfos.toString());
		return reportInfos;
	}
	/**
	 * 通过时间分类查询订单记录
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="orderReportByTime",method=RequestMethod.GET)
	public List<ReportInfo> orderReportByTime(){
		List<ReportInfo> reportInfos = null;
		reportInfos =  cusServiceService.selectOrderRptWithProdTime();
		logger.info(reportInfos.toString());
		return reportInfos;
	}
}
