package edu.tju.scs.TinyNetBackend.mapper;

import edu.tju.scs.TinyNetBackend.model.po.Record;
import edu.tju.scs.TinyNetBackend.model.po.RecordWithBLOBs;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecordMapper {
    int deleteByPrimaryKey(String name);

    int insert(RecordWithBLOBs record);

    int insertSelective(RecordWithBLOBs record);

    RecordWithBLOBs selectByPrimaryKey(String name);

    int updateByPrimaryKeySelective(RecordWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(RecordWithBLOBs record);

    int updateByPrimaryKey(Record record);

    List<RecordWithBLOBs> selectByOwner(String owner);
}