package com.suruomo.material.service;

import com.suruomo.material.pojo.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LogService {
    List<Log> getAll(int start, int end);

    List<Log> getList(int start, int end, String time);
}
