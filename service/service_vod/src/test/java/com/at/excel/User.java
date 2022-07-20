package com.at.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @ClassName User
 * @Description TODO
 * @Author liuqiang
 * @Date 2022-07-20-15:57
 */
@Data
public class User {
    @ExcelProperty(value = "用户编号",index = 0)
    private int id;

    @ExcelProperty(value = "用户名称",index = 1)
    private String name;

}
