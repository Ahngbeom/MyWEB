package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilMapper {
    @Select("SELECT now()")
    String getTime();
}
