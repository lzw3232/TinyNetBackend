package edu.tju.scs.TinyNetBackend.mapper;

import edu.tju.scs.TinyNetBackend.model.po.Gas_steam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface Gas_steamMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Gas_steam record);

    int insertSelective(Gas_steam record);

    Gas_steam selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Gas_steam record);

    int updateByPrimaryKey(Gas_steam record);
    Integer countB();
    Integer countB1(@Param("val") String val);

    List<Gas_steam> selectByOwner(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps);
    List<Gas_steam> selectByOwner1(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps,@Param("val") String val);
}
