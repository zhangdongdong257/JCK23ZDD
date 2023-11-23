package com.ceshiren.hogwarts.play;

import com.ceshiren.hogwarts.play.testdata.entity.AddEntity;
import com.ceshiren.hogwarts.play.testdata.entity.AverageEntity;
import com.ceshiren.hogwarts.play.testdata.entity.ConcatWordsEntity;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.slf4j.LoggerFactory.getLogger;


@DisplayName("计算机测试")//设置测试类的名称
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)//设定排序方法为注解指定排序
class CalculatorTest {

    //添加日志
    static final Logger logger = getLogger(CalculatorTest.class);

    static Calculator calculator = new Calculator("计算器");


    @Test
    @Order(2)
    @DisplayName("相减结果为正")
    void subtractIsPositive() {
        int rlt = calculator.subtract(3,1);
        logger.info("减法的计算结果："+rlt);

        assertEquals(2,rlt,"计算正确");
    }

    @Test
    @Order(1)
    @DisplayName("相减结果为负")
    void subtractIsNegative() {
        int rlt = calculator.subtract(5,6);
        logger.info("减法的计算结果："+rlt);
        assertEquals(-1,rlt,"计算正确");
    }

    @Test
    @Order(1)
    @DisplayName("相减结果为0")
    void subtractIsZero() {
        int rlt = calculator.subtract(5,5);
        logger.info("减法的计算结果："+rlt);
        assertEquals(0,rlt,"计算正确");
    }

    // 结合hamcrest进行多断言
    @Test
    public void assertMoreSubtract() {
        int result = calculator.subtract(10, 3, 5);
        // 定义断言执行数组
        ArrayList<Executable> assertList = new ArrayList<>();
        // 添加断言方法
        assertList.add(() -> assertEquals(result,70));
        int result2 = calculator.subtract(10, 5, 5);
        assertList.add(() -> assertEquals(result2,80));
        // 多断言每个断言都会运行，可以直接看到所有断言的情况
        int result3 = calculator.subtract(20, 5, 5);
        assertList.add(() -> assertEquals(result3,80));
        assertAll(assertList);
    }

    @ParameterizedTest
    @MethodSource("com.ceshiren.hogwarts.play.testdata.TestDataFactory#getAddTestData")
    @DisplayName("测试计算机加法功能")
    @Description("使用ymalw文件进行等价类和边界测试")
    void sum(AddEntity addEntity) {
        assertEquals(calculator.sum(addEntity.getAddNumber()), addEntity.getExpect());
    }



    @ParameterizedTest
    @MethodSource("com.ceshiren.hogwarts.play.testdata.TestDataFactory#getAverageTestData")
    @DisplayName("测试计算机加法功能")
    @Description("使用ymalw文件进行等价类和边界测试")
    void average(AverageEntity averageEntity) {
        assertEquals(calculator.average(averageEntity.getAverageNumbers()), averageEntity.getExpect());
    }

    @ParameterizedTest
    @MethodSource("com.ceshiren.hogwarts.play.testdata.TestDataFactory#getConcatStrTestData")
    @DisplayName("测试字符串相加功能")
    @Description("使用ymalw文件进行等价类和边界测试")
    void concatStr(ConcatWordsEntity concatWordsEntity) {
        assertEquals(calculator.concatStr(concatWordsEntity.getStr()), concatWordsEntity.getExpect());

    }
}