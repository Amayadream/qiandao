package com.amayadream.qiandao.web.controller;

import com.amayadream.qiandao.common.ResultCode;
import com.amayadream.qiandao.common.ResultEntity;
import com.amayadream.qiandao.common.ResultMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author :  Amayadream
 * @date :  2017.04.12 21:11
 */
@Controller
@RequestMapping(value = "/sign")
public class SignController {

    @RequestMapping(value = "/{webId}")
    @ResponseBody
    public ResultEntity sign(@PathVariable String webId) {
        return ResultEntity.buildOkResult(ResultCode.SUCCESS, ResultMessage.SUCCESS);
    }

}
