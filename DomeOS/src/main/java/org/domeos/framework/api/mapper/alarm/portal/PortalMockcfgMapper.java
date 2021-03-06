package org.domeos.framework.api.mapper.alarm.portal;

import org.apache.ibatis.annotations.*;
import org.domeos.framework.api.model.alarm.falcon.portal.Mockcfg;
import org.springframework.stereotype.Repository;

/**
 * Created by baokangwang on 2016/4/14.
 */
@Repository
public interface PortalMockcfgMapper {

    @Select("SELECT * FROM portal.mockcfg WHERE name=#{name}")
    Mockcfg getMockcfgByName(@Param("name") String name);

    @Insert("INSERT INTO portal.mockcfg (name, obj, obj_type, metric, tags, dstype, step, mock, creator, t_create, t_modify) " +
            "VALUES (#{name}, #{obj}, #{obj_type}, #{metric}, #{tags}, #{dstype}, #{step}, #{mock}, #{creator}, #{t_create}, #{t_modify})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insertMockcfg(Mockcfg mockcfg);

    @Update("UPDATE portal.mockcfg SET obj=#{obj} WHERE name=#{name}")
    int updateObjByName(@Param("name") String name, @Param("obj") String obj);
}
