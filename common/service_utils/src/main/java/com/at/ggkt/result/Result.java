package com.at.ggkt.result;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Result
 * @Description TODO
 * @Author liuqiang
 * @Date 2022-07-17-0:03
 */
@Data
@NoArgsConstructor
public class Result<T> {
    private Integer code; // 状态码
    private String message; // 返回的状态信息
    private T data; //返回数据



    //成功的方法
    public static <T> Result<T> ok(T data){
        Result<T> result = new Result<>();
        if(data!=null){
            result.setData(data);
        }
        result.setCode(20000);
        result.setMessage("成功");

        return result;
    }

    //失败的方法
    public static <T> Result<T> fail(){
        Result<T> result = new Result<>();
        result.setCode(20001);
        result.setMessage("失败");
        return result;
    }

    public Result<T> message(String msg){
        this.setMessage(msg);
        return this;
    }

    public Result<T> code(Integer code){
        this.setCode(code);
        return this;
    }
}
