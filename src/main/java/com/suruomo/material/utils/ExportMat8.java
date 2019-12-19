package com.suruomo.material.utils;

import com.suruomo.material.dto.Mat8;
import org.apache.commons.lang.RandomStringUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 导出MAT8卡片文件
 * @author 苏若墨
 */
public class ExportMat8 {
    public File export(Mat8 mat8) throws IOException {
        File file = File.createTempFile(RandomStringUtils.random(5), ".bdf");
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        try {
            //执行控制语句
            bufferedWriter.write("ID " + mat8.getID()+"," +"COMPOSITE\n");
            bufferedWriter.write("SOL " + mat8.getSOL()+"\n");
            bufferedWriter.write("CEND\n");
            //情况控制语句
            bufferedWriter.write("TITLE=" + mat8.getTITLE()+"\n");
            bufferedWriter.write("BEGIN BULK\n");
            //模型数据集
            bufferedWriter.write("MAT8,"+mat8.getMID()+","+mat8.getE1()+","+mat8.getE2()+","+mat8.getNU12()+","+mat8.getG12()+","+mat8.getG1Z()+","+mat8.getG2Z()+","+mat8.getRHO()+"\n");
            bufferedWriter.write("        ,"+mat8.getA1()+","+mat8.getA2()+","+mat8.getTREF()+"\n");
            //文件结束
            bufferedWriter.write("ENDDATA");
        } catch (Exception e) {
            System.out.println("创建bdf文件失败");
        }finally {
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
            //删除临时文件
            file.deleteOnExit();
        }
        return file;
    }
}
