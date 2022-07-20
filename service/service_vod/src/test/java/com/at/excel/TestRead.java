package com.at.excel;

import com.alibaba.excel.EasyExcel;

/**
 * @ClassName TestRead
 * @Description TODO
 * @Author liuqiang
 * @Date 2022-07-20-16:10
 */
public class TestRead {
    public static void main(String[] args) {
        String fileName = "D:\\demo.xlsx";

        EasyExcel.read(fileName,User.class,new ExcelListener()).sheet().doRead();
    }
}
