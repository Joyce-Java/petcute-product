package com.system.systemerp.exception.handler;

import com.system.systemerp.common.APIResponse;
import com.system.systemerp.exception.APIException;
import com.system.systemerp.web.WebAPIStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Object> handleAPIException(APIException ex) {
        APIResponse res = new APIResponse();
        res.setRepCode(ex.getStatusEnum().getStatusCode());
        res.setRepMsg(ex.getMessage());

        return ResponseEntity.ok(res);
    }

    /**
     * 出現未單獨處理的例外錯誤時,針對錯誤進行處理。
     * 返回處理錯誤訊息結果。
     *
     * @param ex
     * @return
     * @throws Throwable
     */
    @ExceptionHandler
    public ResponseEntity<Object> handleThrowable(Throwable ex) {
        String message = "Exception: " + ex.getClass().getName() + ": " + ex.getMessage();

        APIResponse res = new APIResponse();
        res.setRepCode(WebAPIStatusEnum.FAIL.getStatusCode());
        res.setRepMsg(WebAPIStatusEnum.FAIL.getShowMsg());

        log.error(message, ex);

        return ResponseEntity.ok(res);
    }
}
