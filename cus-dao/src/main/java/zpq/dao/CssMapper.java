package zpq.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zpq.bean.Css;
import zpq.bean.CssExample;

public interface CssMapper {
    int countByExample(CssExample example);

    int deleteByExample(CssExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Css record);

    int insertSelective(Css record);

    List<Css> selectByExample(CssExample example);

    Css selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Css record, @Param("example") CssExample example);

    int updateByExample(@Param("record") Css record, @Param("example") CssExample example);

    int updateByPrimaryKeySelective(Css record);

    int updateByPrimaryKey(Css record);
}