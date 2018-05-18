package domain.base.controller;

import domain.base.entity.ParamEntity;
import domain.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static domain.base.BaseWebURLMapping.PARAM_URL;

@Controller
public class BaseController{

    final private BaseService baseService;

    @Autowired
    public BaseController(BaseService baseService){
        this.baseService = baseService;
    }

    @RequestMapping(value = PARAM_URL)
    @ResponseBody
    public List<ParamEntity> getParams(@PathVariable("paramType") String paramType){
        return baseService.getParams(paramType);
    }
}
