package cn.itcast.crm.mapper;

import cn.itcast.crm.pojo.BaseDict;
import cn.itcast.crm.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 11877 on 2017/12/26.
 */
public class BaseDictMapperImpl implements BaseDictMapper {
    private SqlSession sqlSession;

    @Override
    public List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode) {
        List<BaseDict> baseDictList = new ArrayList<>();
        try {
            sqlSession = MyBatisUtils.getSqlSession();
            if (sqlSession != null) {
                baseDictList = sqlSession.selectList("queryBaseDictByDictTypeCode",dictTypeCode);
            }
            if (sqlSession != null) {
                sqlSession.commit();
            }
        }finally {
            if(sqlSession != null) {
                sqlSession.close();
            }
        }
        return baseDictList;
    }
}
