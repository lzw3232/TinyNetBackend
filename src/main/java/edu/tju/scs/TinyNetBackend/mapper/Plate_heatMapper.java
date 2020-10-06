package edu.tju.scs.TinyNetBackend.mapper;

import edu.tju.scs.TinyNetBackend.model.po.Battery;
import edu.tju.scs.TinyNetBackend.model.po.Plate_heat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface Plate_heatMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Plate_heat record);

    int insertSelective(Plate_heat record);

    Plate_heat selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Plate_heat record);

    int updateByPrimaryKey(Plate_heat record);
    Integer countB();
    Integer countB1(@Param("val") String val);

    List<Plate_heat> selectByOwner(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps);
    List<Plate_heat> selectByOwner1(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps,@Param("val") String val);
}
