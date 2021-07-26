package com.suruomo.material.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.suruomo.material.dao.ProfileLibMapper;
import com.suruomo.material.pojo.MetalInput;
import com.suruomo.material.pojo.ProfileLib;
import com.suruomo.material.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author: suruomo
 * @Date: 2021/7/26 13:19
 * @Description: 型材
 */
@Controller
public class ProfileController {
    @Resource
    private ProfileLibMapper profileLibMapper;
    @Resource
    private Result result;
    /**
     * 跳转ISAP型材数据列表页面
     * @return
     */
    @GetMapping("/profiles/isap/list")
    public String rawDatas() {
        return "profile/isap_list";
    }

    /**
     * 返回全部ISAP型材数据
     * @param page
     * @param limit
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @GetMapping(value = "/profiles/isap/data",params = {"page","limit"})
    public Map<String, Object> profiles(int page, int limit) throws JsonProcessingException {
        int start=(page-1)*limit+1;
        int end =page*limit;
        try {
            List<ProfileLib> lists = profileLibMapper.getAll(start, end);
            return result.successResult(lists);
        }catch (Exception e){
            return result.errorsResult();
        }
    }
}
