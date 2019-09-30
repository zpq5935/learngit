package zpq.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zpq.bean.MainMan;
import zpq.bean.MainManExample;

public interface MainManMapper {
    int countByExample(MainManExample example);

    int deleteByExample(MainManExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MainMan record);

    int insertSelective(MainMan record);

    List<MainMan> selectByExample(MainManExample example);

    MainMan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MainMan record, @Param("example") MainManExample example);

    int updateByExample(@Param("record") MainMan record, @Param("example") MainManExample example);

    int updateByPrimaryKeySelective(MainMan record);

    int updateByPrimaryKey(MainMan record);
}