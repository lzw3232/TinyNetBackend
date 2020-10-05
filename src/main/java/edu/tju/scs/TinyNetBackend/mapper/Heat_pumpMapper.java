package edu.tju.scs.TinyNetBackend.mapper;

import edu.tju.scs.TinyNetBackend.model.po.Heat_pump;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface Heat_pumpMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Heat_pump record);

    int insertSelective(Heat_pump record);

    Heat_pump selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Heat_pump record);

    int updateByPrimaryKey(Heat_pump record);
    Integer countB();
    Integer countB1(@Param("val") String val);

    List<Heat_pump> selectByOwner(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps);
    List<Heat_pump> selectByOwner1(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps,@Param("val") String val);
}
