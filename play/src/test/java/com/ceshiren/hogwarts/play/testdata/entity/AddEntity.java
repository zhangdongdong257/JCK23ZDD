package com.ceshiren.hogwarts.play.testdata.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 添加功能测试实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddEntity {
    int[] addNumber;
    Integer expect;
}
