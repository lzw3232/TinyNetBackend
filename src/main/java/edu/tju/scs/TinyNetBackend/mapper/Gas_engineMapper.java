package edu.tju.scs.TinyNetBackend.mapper;

import edu.tju.scs.TinyNetBackend.model.po.Gas_engine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface Gas_engineMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Gas_engine record);

    int insertSelective(Gas_engine record);

    Gas_engine selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Gas_engine record);

    int updateByPrimaryKey(Gas_engine record);
    Integer countB();
    Integer countB1(@Param("val") String val);

    List<Gas_engine> selectByOwner(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps);
    List<Gas_engine> selectByOwner1(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps,@Param("val") String val);
}
