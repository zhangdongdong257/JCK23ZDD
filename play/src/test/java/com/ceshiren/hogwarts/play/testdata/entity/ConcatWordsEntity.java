package com.ceshiren.hogwarts.play.testdata.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 连接字符串实体类
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConcatWordsEntity {
    String[] str;
    String expect;
}
