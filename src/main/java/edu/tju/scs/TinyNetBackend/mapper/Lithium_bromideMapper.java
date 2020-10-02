package edu.tju.scs.TinyNetBackend.mapper;

import edu.tju.scs.TinyNetBackend.model.po.Heat_storage;
import edu.tju.scs.TinyNetBackend.model.po.Lithium_bromide;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface Lithium_bromideMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Lithium_bromide record);

    int insertSelective(Lithium_bromide record);

    Lithium_bromide selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Lithium_bromide record);

    int updateByPrimaryKey(Lithium_bromide record);

    Integer countB();
    Integer countB1(@Param("val") String val);

    List<Lithium_bromide> selectByOwner(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps);
    List<Lithium_bromide> selectByOwner1(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps,@Param("val") String val);
}
