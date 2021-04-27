package edu.tju.scs.TinyNetBackend.mapper;

import edu.tju.scs.TinyNetBackend.model.po.Gas_turbine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface Gas_turbineMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Gas_turbine record);

    int insertSelective(Gas_turbine record);

    Gas_turbine selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Gas_turbine record);

    int updateByPrimaryKey(Gas_turbine record);
    Integer countB();
    Integer countB1(@Param("val") String val);

    List<Gas_turbine> selectByOwner(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps);
    List<Gas_turbine> selectByOwner1(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps,@Param("val") String val);
}
