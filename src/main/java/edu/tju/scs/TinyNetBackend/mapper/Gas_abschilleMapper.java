package edu.tju.scs.TinyNetBackend.mapper;

import edu.tju.scs.TinyNetBackend.model.po.Gas_abschille;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface Gas_abschilleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Gas_abschille record);

    int insertSelective(Gas_abschille record);

    Gas_abschille selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Gas_abschille record);

    int updateByPrimaryKey(Gas_abschille record);
    Integer countB();
    Integer countB1(@Param("val") String val);

    List<Gas_abschille> selectByOwner(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps);
    List<Gas_abschille> selectByOwner1(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps,@Param("val") String val);
}
