package com.ceshiren.hogwarts.play.testdata.mapper;

import com.ceshiren.hogwarts.play.testdata.entity.AddEntity;
import com.ceshiren.hogwarts.play.testdata.entity.AverageEntity;
import com.ceshiren.hogwarts.play.testdata.entity.ConcatWordsEntity;
import com.ceshiren.hogwarts.play.testdata.entity.HereEntity;

public enum EntityFileMapping {
    // 保存实体类与文件的对应关系

    ADD_ENTITY(AddEntity.class, "add-data.yaml"),
    AVERAGE_ENTITY(AverageEntity.class, "average-data.yaml"),

    CONCATWORDS_ENTITY(ConcatWordsEntity.class, "concatstr-data.yaml");

    private  Class<?> entityClass;
    private  String filePath;

    EntityFileMapping(Class<?> entityClass, String filePath){
        this.entityClass = entityClass;
        this.filePath = filePath;
    }

    public Class<?> getEntityClass(){
        return entityClass;
    }

    public String getFilePath(){
        return filePath;
    }
}
