package zpq.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zpq.bean.Record;
import zpq.bean.RecordExample;
import zpq.bean.RecordWithBLOBs;

public interface RecordMapper {
	int countByExample(RecordExample example);

	int deleteByExample(RecordExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(RecordWithBLOBs record);

	int insertSelective(RecordWithBLOBs record);

	List<RecordWithBLOBs> selectByExampleWithBLOBs(RecordExample example);

	List<Record> selectByExample(RecordExample example);

	RecordWithBLOBs selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") RecordWithBLOBs record, @Param("example") RecordExample example);

	int updateByExampleWithBLOBs(@Param("record") RecordWithBLOBs record, @Param("example") RecordExample example);

	int updateByExample(@Param("record") Record record, @Param("example") RecordExample example);

	int updateByPrimaryKeySelective(RecordWithBLOBs record);

	int updateByPrimaryKeyWithBLOBs(RecordWithBLOBs record);

	int updateByPrimaryKey(Record record);

	/************ 自定义 ************/
	List<RecordWithBLOBs> selectMoreByExample(RecordExample example);
}