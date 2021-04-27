package edu.tju.scs.TinyNetBackend.mapper;

import edu.tju.scs.TinyNetBackend.model.po.Heat_exchanger;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface Heat_exchangerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Heat_exchanger record);

    int insertSelective(Heat_exchanger record);

    Heat_exchanger selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Heat_exchanger record);

    int updateByPrimaryKey(Heat_exchanger record);
    Integer countB();
    Integer countB1(@Param("val") String val);

    List<Heat_exchanger> selectByOwner(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps);
    List<Heat_exchanger> selectByOwner1(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps,@Param("val") String val);
}
