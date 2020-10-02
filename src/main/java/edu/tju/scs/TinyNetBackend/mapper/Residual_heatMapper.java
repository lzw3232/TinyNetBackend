package edu.tju.scs.TinyNetBackend.mapper;

import edu.tju.scs.TinyNetBackend.model.po.Battery;
import edu.tju.scs.TinyNetBackend.model.po.Residual_heat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface Residual_heatMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Residual_heat record);

    int insertSelective(Residual_heat record);

    Residual_heat selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Residual_heat record);

    int updateByPrimaryKey(Residual_heat record);
    Integer countB();
    Integer countB1(@Param("val") String val);

    List<Residual_heat> selectByOwner(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps);
    List<Residual_heat> selectByOwner1(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps,@Param("val") String val);
}
