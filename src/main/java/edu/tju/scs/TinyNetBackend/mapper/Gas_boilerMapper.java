package edu.tju.scs.TinyNetBackend.mapper;

import edu.tju.scs.TinyNetBackend.model.po.Gas_boiler;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface Gas_boilerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Gas_boiler record);

    int insertSelective(Gas_boiler record);

    Gas_boiler selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Gas_boiler record);

    int updateByPrimaryKey(Gas_boiler record);
    Integer countB();
    Integer countB1(@Param("val") String val);

    List<Gas_boiler> selectByOwner(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps);
    List<Gas_boiler> selectByOwner1(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps,@Param("val") String val);
}
