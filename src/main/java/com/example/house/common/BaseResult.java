package com.example.house.common;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BaseResult<T> implements Serializable {
    public static final int SUCCESS;
    public static final int FAIL;
    private static final long serialVersionUID = 1L;
    private int code;
    private String message;
    private T data;
    private String[] errorArgs;
    private String currentTime;
    private String traceId;

    public static BaseResult ok() {
        return restBaseResult("", SUCCESS, "success", (String[]) null);
    }

    public static <T> BaseResult<T> ok(T data) {
        return restBaseResult(data, SUCCESS, "success", (String[]) null);
    }

    public static <T> BaseResult<T> ok(T data, String message) {
        return restBaseResult(data, SUCCESS, message, (String[]) null);
    }

    public static BaseResult fail() {
        return restBaseResult("", FAIL, "fail", (String[]) null);
    }

    public static BaseResult fail(String message) {
        return restBaseResult("", FAIL, message, (String[]) null);
    }

    public static <T> BaseResult<T> fail(T data) {
        return restBaseResult(data, FAIL, "fail", (String[]) null);
    }

    public static <T> BaseResult<T> fail(T data, String message) {
        return restBaseResult(data, FAIL, message, (String[]) null);
    }

    public static BaseResult fail(int code, String message) {
        return restBaseResult("", code, message, (String[]) null);
    }

    public static <T> BaseResult<T> fail(int code, String message, T data) {
        return restBaseResult(data, code, message, (String[]) null);
    }

    public static BaseResult fail(int code, String message, String[] errors) {
        return restBaseResult("", code, message, errors);
    }

    private static <T> BaseResult<T> restBaseResult(T data, int code, String message, String[] errors) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        BaseResult<T> apiBaseResult = new BaseResult();
        apiBaseResult.setCode(code);
        apiBaseResult.setData(data);
        apiBaseResult.setErrorArgs(errors);
        apiBaseResult.setMessage(message);
        apiBaseResult.setCurrentTime(simpleDateFormat.format(new Date()));
        return apiBaseResult;
    }

    public boolean isSuccess() {
        return SUCCESS == this.code;
    }

    public BaseResult() {
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public T getData() {
        return this.data;
    }

    public String[] getErrorArgs() {
        return this.errorArgs;
    }

    public String getCurrentTime() {
        return this.currentTime;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setErrorArgs(String[] errorArgs) {
        this.errorArgs = errorArgs;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof BaseResult)) {
            return false;
        } else {
            BaseResult<?> other = (BaseResult) o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getCode() != other.getCode()) {
                return false;
            } else {
                label65:
                {
                    Object this$message = this.getMessage();
                    Object other$message = other.getMessage();
                    if (this$message == null) {
                        if (other$message == null) {
                            break label65;
                        }
                    } else if (this$message.equals(other$message)) {
                        break label65;
                    }

                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                if (!Arrays.deepEquals(this.getErrorArgs(), other.getErrorArgs())) {
                    return false;
                } else {
                    Object this$currentTime = this.getCurrentTime();
                    Object other$currentTime = other.getCurrentTime();
                    if (this$currentTime == null) {
                        if (other$currentTime != null) {
                            return false;
                        }
                    } else if (!this$currentTime.equals(other$currentTime)) {
                        return false;
                    }

                    Object this$traceId = this.getTraceId();
                    Object other$traceId = other.getTraceId();
                    if (this$traceId == null) {
                        if (other$traceId != null) {
                            return false;
                        }
                    } else if (!this$traceId.equals(other$traceId)) {
                        return false;
                    }

                    return true;
                }
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof BaseResult;
    }


    @Override
    public String toString() {
        return "BaseResult(code=" + this.getCode() + ", message=" + this.getMessage() + ", data=" + this.getData() + ", errorArgs=" + Arrays.deepToString(this.getErrorArgs()) + ", currentTime=" + this.getCurrentTime() + ", traceId=" + this.getTraceId() + ")";
    }

    static {
        SUCCESS = ExceptionEnum.SUCCESS.code();
        FAIL = ExceptionEnum.SYSTEM_ERROR.code();
    }
}

