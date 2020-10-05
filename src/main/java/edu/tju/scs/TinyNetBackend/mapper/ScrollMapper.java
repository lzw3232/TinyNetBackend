package edu.tju.scs.TinyNetBackend.mapper;

import edu.tju.scs.TinyNetBackend.model.po.Scroll;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ScrollMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Scroll record);

    int insertSelective(Scroll record);

    Scroll selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Scroll record);

    int updateByPrimaryKey(Scroll record);
    Integer countB();
    Integer countB1(@Param("val") String val);

    List<Scroll> selectByOwner(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps);
    List<Scroll> selectByOwner1(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps,@Param("val") String val);
}
