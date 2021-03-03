package com.yidiandian.vo;

import lombok.Data;

/**
 * @author 凤凰小哥哥
 * @date 2020-12-20
 */
@Data
public class Result<T> {
    private boolean flag;
    private Integer code;
    private String message;
    private T data;

    public Result(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    public Result(boolean flag, Integer code, String message, T data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result() {}

    public static <T> Result<T> success(T data) {
        Result<T> response = new Result();
        response.setFlag( true );
        response.setCode( 200);
        response.setMessage("成功");
        response.setData(data);
        return response;
    }
    public static <T> Result<T> success() {
        Result<T> response = new Result();
        response.setFlag( true );
        response.setCode( 200);
        response.setMessage("成功");
        response.setData(null);
        return response;
    }
    public static <T> Result<T> error(T data) {
        Result<T> response = new Result();
        response.setFlag( false );
        response.setCode( 500);
        response.setMessage("失败");
        response.setData(data);
        return response;
    }

    public static <T> Result<T> error() {
        Result<T> response = new Result();
        response.setFlag( false );
        response.setCode( 500);
        response.setMessage("失败");
        response.setData(null);
        return response;
    }

    public static <T> Result<T> error(Integer code,String message) {
        Result<T> response = new Result();
        response.setFlag( false );
        response.setCode(code);
        response.setMessage(message);
        return response;
    }
}
