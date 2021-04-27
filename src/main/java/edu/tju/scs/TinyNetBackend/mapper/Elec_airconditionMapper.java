package edu.tju.scs.TinyNetBackend.mapper;

import edu.tju.scs.TinyNetBackend.model.po.Elec_aircondition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface Elec_airconditionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Elec_aircondition record);

    int insertSelective(Elec_aircondition record);

    Elec_aircondition selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Elec_aircondition record);

    int updateByPrimaryKey(Elec_aircondition record);
    Integer countB();
    Integer countB1(@Param("val") String val);

    List<Elec_aircondition> selectByOwner(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps);
    List<Elec_aircondition> selectByOwner1(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps,@Param("val") String val);
}
