package edu.tju.scs.TinyNetBackend.mapper;

import edu.tju.scs.TinyNetBackend.model.po.Electricitychiller;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ElectricitychillerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Electricitychiller record);

    int insertSelective(Electricitychiller record);

    Electricitychiller selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Electricitychiller record);

    int updateByPrimaryKey(Electricitychiller record);    Integer countB();
    Integer countB1(@Param("val") String val);

    List<Electricitychiller> selectByOwner(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps);
    List<Electricitychiller> selectByOwner1(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps,@Param("val") String val);

}
