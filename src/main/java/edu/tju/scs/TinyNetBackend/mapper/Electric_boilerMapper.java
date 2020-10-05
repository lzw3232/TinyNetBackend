package edu.tju.scs.TinyNetBackend.mapper;

import edu.tju.scs.TinyNetBackend.model.po.Electric_boiler;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface Electric_boilerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Electric_boiler record);

    int insertSelective(Electric_boiler record);

    Electric_boiler selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Electric_boiler record);

    int updateByPrimaryKey(Electric_boiler record);
    Integer countB();
    Integer countB1(@Param("val") String val);

    List<Electric_boiler> selectByOwner(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps);
    List<Electric_boiler> selectByOwner1(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps,@Param("val") String val);
}
