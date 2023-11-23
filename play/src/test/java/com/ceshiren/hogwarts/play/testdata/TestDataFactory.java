package com.ceshiren.hogwarts.play.testdata;

import com.ceshiren.hogwarts.play.testdata.entity.AddEntity;
import com.ceshiren.hogwarts.play.testdata.entity.AverageEntity;
import com.ceshiren.hogwarts.play.testdata.entity.ConcatWordsEntity;
import com.ceshiren.hogwarts.play.testdata.mapper.EntityFileMapping;
import com.ceshiren.hogwarts.play.utils.TestDataUtil;

import java.io.IOException;
import java.util.List;

public class TestDataFactory {
    //用于返回测试数据的静态方法的工程类，可以被@MethodSource进行调用

    /**
     * 返回加法的实体类列表对象
     *
     * @throws IOException
     **/
    public static List<AddEntity> getAddTestData() throws IOException {
        return TestDataUtil.loadYamlData(EntityFileMapping.ADD_ENTITY);
    }

    /**
     * 返回平均数实体类列表对象
     *
     * @throws IOException
     * */

    public static List<AverageEntity> getAverageTestData() throws IOException{
        return TestDataUtil.loadYamlData(EntityFileMapping.AVERAGE_ENTITY);
    }


    /**
     * 返回连接字符串实体类列表对象
     *
     * @throws IOException
     * */

    public static List<ConcatWordsEntity> getConcatStrTestData() throws IOException{
        return TestDataUtil.loadYamlData(EntityFileMapping.CONCATWORDS_ENTITY);
    }
}
