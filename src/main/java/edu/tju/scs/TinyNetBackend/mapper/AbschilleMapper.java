package edu.tju.scs.TinyNetBackend.mapper;

import edu.tju.scs.TinyNetBackend.model.po.Abschille;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AbschilleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Abschille record);

    int insertSelective(Abschille record);

    Abschille selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Abschille record);

    int updateByPrimaryKey(Abschille record);
    Integer countB();
    Integer countB1(@Param("val") String val);

    List<Abschille> selectByOwner(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps);
    List<Abschille> selectByOwner1(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps,@Param("val") String val);

}
