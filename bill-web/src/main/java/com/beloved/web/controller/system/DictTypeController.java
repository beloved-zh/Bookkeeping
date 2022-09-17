package com.beloved.web.controller.system;

import com.beloved.common.converter.DictConverter;
import com.beloved.common.model.dto.system.SysDictTypeDto;
import com.beloved.common.model.vo.common.OptionVo;
import com.beloved.system.service.SysDictTypeService;
import com.beloved.web.controller.common.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Beloved
 * @CreateTime: 2022-09-10 19:39
 * @Description:
 */
@RestController
@RequestMapping("/system/dict/type")
public class DictTypeController extends BaseController {

    @Autowired
    private SysDictTypeService dictTypeService;
    
    @Autowired
    private DictConverter dictConverter;
    
    /**
     * 根据字典类型获取字典数据
     * @param dictType
     * @return
     */
    @GetMapping(value = "/optionData/{dictType}")
    public List<OptionVo> optionData(@PathVariable String dictType) {

        SysDictTypeDto dictTypeDto = dictTypeService.querySysDictTypeDataByType(dictType);
        
        return dictConverter.dictDataToOptionList(dictTypeDto.getDictDataList());
    }
}