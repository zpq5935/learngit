package zpq.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zpq.bean.MyOrder;
import zpq.bean.MyOrderExample;

public interface MyOrderMapper {
	int countByExample(MyOrderExample example);

	int deleteByExample(MyOrderExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(MyOrder record);

	int insertSelective(MyOrder record);

	List<MyOrder> selectByExampleWithBLOBs(MyOrderExample example);

	List<MyOrder> selectByExample(MyOrderExample example);

	MyOrder selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") MyOrder record, @Param("example") MyOrderExample example);

	int updateByExampleWithBLOBs(@Param("record") MyOrder record, @Param("example") MyOrderExample example);

	int updateByExample(@Param("record") MyOrder record, @Param("example") MyOrderExample example);

	int updateByPrimaryKeySelective(MyOrder record);

	int updateByPrimaryKeyWithBLOBs(MyOrder record);

	int updateByPrimaryKey(MyOrder record);

	/************* 自己添加的 *************/

	List<MyOrder> selectMoreByExample(MyOrderExample example);
}