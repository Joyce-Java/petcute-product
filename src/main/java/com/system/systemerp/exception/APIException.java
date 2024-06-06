package com.system.systemerp.exception;

import com.system.systemerp.web.WebAPIStatusEnum;
import lombok.extern.slf4j.Slf4j;

/**
 * 實作 API Exception
 * TODO 需在增加多國語系的錯誤訊息處理方式
 *
 * @author Joyce
 */
@Slf4j
public class APIException extends RuntimeException {

    private WebAPIStatusEnum statusEnum;

    public APIException(WebAPIStatusEnum statusEnum) {
        super(statusEnum.getShowMsg());
        this.statusEnum = statusEnum;
    }

    public WebAPIStatusEnum getStatusEnum() {
        return this.statusEnum;
    }
}
