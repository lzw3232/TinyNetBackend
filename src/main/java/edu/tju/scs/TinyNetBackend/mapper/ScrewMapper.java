package edu.tju.scs.TinyNetBackend.mapper;

import edu.tju.scs.TinyNetBackend.model.po.Screw;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ScrewMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Screw record);

    int insertSelective(Screw record);

    Screw selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Screw record);

    int updateByPrimaryKey(Screw record);
    Integer countB();
    Integer countB1(@Param("val") String val);

    List<Screw> selectByOwner(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps);
    List<Screw> selectByOwner1(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps,@Param("val") String val);
}
