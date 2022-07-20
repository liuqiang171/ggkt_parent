package com.at.excel;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TestWrite
 * @Description TODO
 * @Author liuqiang
 * @Date 2022-07-20-16:00
 */
public class TestWrite {

    public static void main(String[] args) {
        String fileName = "D:\\demo.xlsx";
        //调用方法
        EasyExcel.write(fileName,User.class).sheet("写操作")
                .doWrite(data());
    }

    private static List<User> data() {
        List<User> list = new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            User data = new User();
            data.setId(i);
            data.setName("张三"+i);
            list.add(data);
        }
        return list;
    }
}
