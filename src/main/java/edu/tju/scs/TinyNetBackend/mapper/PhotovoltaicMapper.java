package edu.tju.scs.TinyNetBackend.mapper;

import edu.tju.scs.TinyNetBackend.model.po.Photovoltaic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PhotovoltaicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Photovoltaic record);

    int insertSelective(Photovoltaic record);

    Photovoltaic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Photovoltaic record);

    int updateByPrimaryKey(Photovoltaic record);
    Integer countB();
    Integer countB1(@Param("val") String val);

    List<Photovoltaic> selectByOwner(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps);
    List<Photovoltaic> selectByOwner1(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps,@Param("val") String val);
}
