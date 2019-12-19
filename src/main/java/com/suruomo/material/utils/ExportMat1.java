package com.suruomo.material.utils;

import com.suruomo.material.dto.Mat1;
import org.apache.commons.lang.RandomStringUtils;

import java.io.*;

/**
 * 导出MAT1卡片文件
 *
 * @author 苏若墨
 */
public class ExportMat1 {
    public File export(Mat1 mat1) throws IOException {
        //创建临时.bdf文件，文件名称为随机5个字符串
        File file = File.createTempFile(RandomStringUtils.random(5), ".bdf");
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        try {
            //执行控制语句
            bufferedWriter.write("ID " + mat1.getID()+"," +"METAL\n");
            bufferedWriter.write("SOL " + mat1.getSOL()+"\n");
            bufferedWriter.write("CEND\n");
            //情况控制语句
            bufferedWriter.write("TITLE=" + mat1.getTITLE()+"\n");
            bufferedWriter.write("BEGIN BULK\n");
            //模型数据集
            bufferedWriter.write("MAT1,"+mat1.getMID()+","+mat1.getE()+","+mat1.getG()+","+mat1.getNU()+","+mat1.getRHO()+","+mat1.getA()+"\n");
            bufferedWriter.write("        ,"+mat1.getST()+","+mat1.getSC()+","+mat1.getSS()+"\n");
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
