package com.system.systemerp.common;

import com.system.systemerp.web.WebAPIStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class APIResponse {
    private String repCode;

    private String repMsg;

    private Object data;

    public APIResponse() {
        setStatus(WebAPIStatusEnum.SUCCESS);
    }

    public String getRepCode() {
        return repCode;
    }

    public void setRepCode(String repCode) {
        this.repCode = repCode;
    }

    public String getRepMsg() {
        return repMsg;
    }

    public void setRepMsg(String repMsg) {
        this.repMsg = repMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setStatus(WebAPIStatusEnum status) {
        this.repCode = status.getStatusCode();
        this.repMsg = status.getShowMsg();
    }
}
