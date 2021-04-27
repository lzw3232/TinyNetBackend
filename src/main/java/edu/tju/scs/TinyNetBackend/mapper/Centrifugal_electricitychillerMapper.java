package edu.tju.scs.TinyNetBackend.mapper;

import edu.tju.scs.TinyNetBackend.model.po.Centrifugal_electricitychiller;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface Centrifugal_electricitychillerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Centrifugal_electricitychiller record);

    int insertSelective(Centrifugal_electricitychiller record);

    Centrifugal_electricitychiller selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Centrifugal_electricitychiller record);

    int updateByPrimaryKey(Centrifugal_electricitychiller record);
    Integer countB();
    Integer countB1(@Param("val") String val);

    List<Centrifugal_electricitychiller> selectByOwner(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps);
    List<Centrifugal_electricitychiller> selectByOwner1(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps,@Param("val") String val);
}
