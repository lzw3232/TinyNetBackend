package edu.tju.scs.TinyNetBackend.mapper;

import edu.tju.scs.TinyNetBackend.model.po.Abschille;
import edu.tju.scs.TinyNetBackend.model.po.Hydro_turbine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface Hydro_turbineMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hydro_turbine record);

    int insertSelective(Hydro_turbine record);

    Hydro_turbine selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hydro_turbine record);

    int updateByPrimaryKey(Hydro_turbine record);
    Integer countB();
    Integer countB1(@Param("val") String val);

    List<Hydro_turbine> selectByOwner(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps);
    List<Hydro_turbine> selectByOwner1(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps,@Param("val") String val);

}
