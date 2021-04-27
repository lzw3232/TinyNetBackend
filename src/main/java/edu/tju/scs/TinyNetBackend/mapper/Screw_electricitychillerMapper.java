package edu.tju.scs.TinyNetBackend.mapper;

import edu.tju.scs.TinyNetBackend.model.po.Screw_electricitychiller;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface Screw_electricitychillerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Screw_electricitychiller record);

    int insertSelective(Screw_electricitychiller record);

    Screw_electricitychiller selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Screw_electricitychiller record);

    int updateByPrimaryKey(Screw_electricitychiller record);
    Integer countB();
    Integer countB1(@Param("val") String val);

    List<Screw_electricitychiller> selectByOwner(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps);
    List<Screw_electricitychiller> selectByOwner1(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps,@Param("val") String val);
}
