package com.suruomo.material.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.suruomo.material.dao.MetalOutMapper;
import com.suruomo.material.pojo.MetalOut;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 苏若墨
 */
@Controller
public class MetalController {
    @Resource
    MetalOutMapper metalOutMapper;

    /**
     * 跳转所有铝数据列表页面
     * @return
     */
    @GetMapping("/metal/aluminum")
    public String aluminumList(Model model) {
        model.addAttribute("type","aluminum");
        return "metal/list";
    }
    /**
     * 跳转所有钢数据列表页面
     * @return
     */
    @GetMapping("/metal/steel")
    public String steelList(Model model) {
        model.addAttribute("type","steel");
        return "metal/list";
    }
    /**
     * 跳转所有钛数据列表页面
     * @return
     */
    @GetMapping("/metal/titanium")
    public String titaniumList(Model model) {
        model.addAttribute("type","titanium");
        return "metal/list";
    }

    /**
     * 返回查询金属数据
     * @param page
     * @param limit
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @GetMapping("/metals")
    public Map<String, Object> list(@RequestParam("page") int page, @RequestParam("limit") int limit,@RequestParam("type") String type) throws JsonProcessingException {
        int start=(page-1)*limit+1;
        int end =page*limit;
        String queryType = "";
        System.out.println("类型"+queryType);
        if (type.equals("aluminum")) {
            queryType = "EO_Material_Aluminium";
        } else if (type.equals("steel")) {
            queryType = "EO_Material_Steel";
        } else if (type.equals("titanium")) {
            queryType = "EO_Material_Titanium";
        }
        List<MetalOut> users = metalOutMapper.getAll(start, end,queryType);
        int count = metalOutMapper.getCount(queryType);
        HashMap<String, Object> map = new HashMap();
        //返回Json
        ObjectMapper mapper = new ObjectMapper();
        //json内对象不为空
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String data = mapper.writeValueAsString(users);
        JSONArray json = JSONArray.fromObject(data);
        map.put("code", 0);
        map.put("msg", "");
        map.put("data", json);
        map.put("count", count);
        return map;
    }

    /**
     * 跳转至导出MAT1页面
     * @return
     */

    @GetMapping("/metal/export/{name}")
    public String mat(@PathVariable String name, Model model) {
        System.out.println(name);
        MetalOut metalOut=metalOutMapper.selectByPrimaryKey(name);
        model.addAttribute("metal",metalOut);
        return "metal/mat1";
    }


}
