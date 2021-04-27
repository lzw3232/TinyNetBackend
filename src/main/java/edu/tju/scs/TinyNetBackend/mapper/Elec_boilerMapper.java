package edu.tju.scs.TinyNetBackend.mapper;

import edu.tju.scs.TinyNetBackend.model.po.Elec_boiler;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface Elec_boilerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Elec_boiler record);

    int insertSelective(Elec_boiler record);

    Elec_boiler selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Elec_boiler record);

    int updateByPrimaryKey(Elec_boiler record);
    Integer countB();
    Integer countB1(@Param("val") String val);

    List<Elec_boiler> selectByOwner(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps);
    List<Elec_boiler> selectByOwner1(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps,@Param("val") String val);
}
