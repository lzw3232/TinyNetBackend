package edu.tju.scs.TinyNetBackend.mapper;

import edu.tju.scs.TinyNetBackend.model.po.Battery;
import edu.tju.scs.TinyNetBackend.model.po.Turbine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TurbineMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Turbine record);

    int insertSelective(Turbine record);

    Turbine selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Turbine record);

    int updateByPrimaryKey(Turbine record);

    List<Turbine> selectByOwner(String username);
    Integer countB();
    Integer countB1(@Param("val") String val);

    List<Turbine> selectByOwner(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps);
    List<Turbine> selectByOwner1(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps,@Param("val") String val);
}
