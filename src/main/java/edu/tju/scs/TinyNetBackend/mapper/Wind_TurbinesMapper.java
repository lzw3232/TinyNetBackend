package edu.tju.scs.TinyNetBackend.mapper;

import edu.tju.scs.TinyNetBackend.model.po.Battery;
import edu.tju.scs.TinyNetBackend.model.po.Wind_Turbines;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface Wind_TurbinesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Wind_Turbines record);

    int insertSelective(Wind_Turbines record);

    Wind_Turbines selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Wind_Turbines record);

    int updateByPrimaryKey(Wind_Turbines record);

    List<Wind_Turbines> selectByOwner(String username);
    Integer countB();
    Integer countB1(@Param("val") String val);

    List<Wind_Turbines> selectByOwner(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps);
    List<Wind_Turbines> selectByOwner1(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps,@Param("val") String val);
}
