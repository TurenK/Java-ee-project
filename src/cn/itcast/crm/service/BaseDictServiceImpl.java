package cn.itcast.crm.service;

import cn.itcast.crm.mapper.BaseDictMapper;
import cn.itcast.crm.mapper.BaseDictMapperImpl;
import cn.itcast.crm.pojo.BaseDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 11877 on 2017/12/25.
 */
@Service
public class BaseDictServiceImpl implements BaseDictService {

    private BaseDictMapper baseDictMapper;

    public BaseDictServiceImpl(){
        baseDictMapper = new BaseDictMapperImpl();
    }

    @Override
    public List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode) {
        return this.baseDictMapper.queryBaseDictByDictTypeCode(dictTypeCode);
    }
}

