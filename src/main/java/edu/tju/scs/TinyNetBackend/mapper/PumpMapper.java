package edu.tju.scs.TinyNetBackend.mapper;

import edu.tju.scs.TinyNetBackend.model.po.Pump;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PumpMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Pump record);

    int insertSelective(Pump record);

    Pump selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Pump record);

    int updateByPrimaryKey(Pump record);
    Integer countB();
    Integer countB1(@Param("val") String val);

    List<Pump> selectByOwner(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps);
    List<Pump> selectByOwner1(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps,@Param("val") String val);
}
