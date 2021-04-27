package edu.tju.scs.TinyNetBackend.mapper;

import edu.tju.scs.TinyNetBackend.model.po.Waste_heat_boiler;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface Waste_heat_boilerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Waste_heat_boiler record);

    int insertSelective(Waste_heat_boiler record);

    Waste_heat_boiler selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Waste_heat_boiler record);

    int updateByPrimaryKey(Waste_heat_boiler record);
    Integer countB();
    Integer countB1(@Param("val") String val);

    List<Waste_heat_boiler> selectByOwner(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps);
    List<Waste_heat_boiler> selectByOwner1(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps,@Param("val") String val);
}
