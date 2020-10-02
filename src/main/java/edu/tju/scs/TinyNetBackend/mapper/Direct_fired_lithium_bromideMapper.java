package edu.tju.scs.TinyNetBackend.mapper;

import edu.tju.scs.TinyNetBackend.model.po.Battery;
import edu.tju.scs.TinyNetBackend.model.po.Direct_fired_lithium_bromide;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface Direct_fired_lithium_bromideMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Direct_fired_lithium_bromide record);

    int insertSelective(Direct_fired_lithium_bromide record);

    Direct_fired_lithium_bromide selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Direct_fired_lithium_bromide record);

    int updateByPrimaryKey(Direct_fired_lithium_bromide record);
    Integer countB();
    Integer countB1(@Param("val") String val);

    List<Direct_fired_lithium_bromide> selectByOwner(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps);
    List<Direct_fired_lithium_bromide> selectByOwner1(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps,@Param("val") String val);
}
