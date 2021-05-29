package edu.tju.scs.TinyNetBackend.mapper;

import edu.tju.scs.TinyNetBackend.model.po.Diesel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DieselMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Diesel record);

    int insertSelective(Diesel record);

    Diesel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Diesel record);

    int updateByPrimaryKey(Diesel record);
    Integer countB();
    Integer countB1(@Param("val") String val);

    List<Diesel> selectByOwner(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps);
    List<Diesel> selectByOwner1(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps,@Param("val") String val);

}
