package com.suruomo.material.utils;

import com.suruomo.material.dto.Mat1;

import java.io.File;

/**
 * 导出MAT1卡片文件
 * @author 苏若墨
 */
public class ExportMat1 {
    public File export(Mat1 mat1){
        String filePath = getClass().getResource("/file/abc.bdf").getPath();
        File file=new File(filePath);
        return file;
    }
}
