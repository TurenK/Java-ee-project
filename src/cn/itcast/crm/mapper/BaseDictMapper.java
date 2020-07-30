package cn.itcast.crm.mapper;

import cn.itcast.crm.pojo.BaseDict;

import java.util.List;

/**
 * Created by 11877 on 2017/12/25.
 */
public interface BaseDictMapper {
    /**
     * 根据类别代码查询数据
     *
     * @param dictTypeCode String
     * @return list
     */
    List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode);
}
