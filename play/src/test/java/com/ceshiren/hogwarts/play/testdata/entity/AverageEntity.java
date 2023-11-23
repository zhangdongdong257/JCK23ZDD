package com.ceshiren.hogwarts.play.testdata.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 平均数功能测试实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AverageEntity {
    int[] averageNumbers;
    double expect;
}
