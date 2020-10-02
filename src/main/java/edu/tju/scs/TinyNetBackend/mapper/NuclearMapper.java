package edu.tju.scs.TinyNetBackend.mapper;

import edu.tju.scs.TinyNetBackend.model.po.Battery;
import edu.tju.scs.TinyNetBackend.model.po.Nuclear;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NuclearMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Nuclear record);

    int insertSelective(Nuclear record);

    Nuclear selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Nuclear record);

    int updateByPrimaryKey(Nuclear record);
    Integer countB();
    Integer countB1(@Param("val") String val);

    List<Nuclear> selectByOwner(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps);
    List<Nuclear> selectByOwner1(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps,@Param("val") String val);
}
