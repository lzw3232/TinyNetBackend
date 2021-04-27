package edu.tju.scs.TinyNetBackend.mapper;

import edu.tju.scs.TinyNetBackend.model.po.Wind_turbine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface Wind_turbineMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Wind_turbine record);

    int insertSelective(Wind_turbine record);

    Wind_turbine selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Wind_turbine record);

    int updateByPrimaryKey(Wind_turbine record);
    Integer countB();
    Integer countB1(@Param("val") String val);

    List<Wind_turbine> selectByOwner(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps);
    List<Wind_turbine> selectByOwner1(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps,@Param("val") String val);
}
