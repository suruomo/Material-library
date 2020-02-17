package com.suruomo.material.service.impl;

import com.suruomo.material.dao.LogMapper;
import com.suruomo.material.pojo.Log;
import com.suruomo.material.service.LogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Resource
    private LogMapper logMapper;
    @Override
    public List<Log> getAll(int start, int end) {
        List<Log> list=logMapper.getAll(start,end);
        return list;
    }

    @Override
    public List<Log> getList(int start, int end, String range) {
        String[] params = range.split(" ");
        String startTime = params[0] + " " + params[1];
        System.out.println(startTime);
        String endTime = params[3] + " " + params[4];
        System.out.println(endTime);
        List<Log> list = logMapper.getList(start, end, startTime, endTime);
        return list;
    }
}
