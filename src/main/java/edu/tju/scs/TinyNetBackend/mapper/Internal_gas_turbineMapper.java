package edu.tju.scs.TinyNetBackend.mapper;

import edu.tju.scs.TinyNetBackend.model.po.Internal_gas_turbine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface Internal_gas_turbineMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Internal_gas_turbine record);

    int insertSelective(Internal_gas_turbine record);

    Internal_gas_turbine selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Internal_gas_turbine record);

    int updateByPrimaryKey(Internal_gas_turbine record);
    Integer countB();
    Integer countB1(@Param("val") String val);

    List<Internal_gas_turbine> selectByOwner(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps);
    List<Internal_gas_turbine> selectByOwner1(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps,@Param("val") String val);
}
