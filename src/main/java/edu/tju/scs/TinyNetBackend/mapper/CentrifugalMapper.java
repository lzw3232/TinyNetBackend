package edu.tju.scs.TinyNetBackend.mapper;

import edu.tju.scs.TinyNetBackend.model.po.Centrifugal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CentrifugalMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Centrifugal record);

    int insertSelective(Centrifugal record);

    Centrifugal selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Centrifugal record);

    int updateByPrimaryKey(Centrifugal record);
    Integer countB();
    Integer countB1(@Param("val") String val);

    List<Centrifugal> selectByOwner(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps);
    List<Centrifugal> selectByOwner1(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps,@Param("val") String val);
}
