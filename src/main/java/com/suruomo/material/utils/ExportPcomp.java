package com.suruomo.material.utils;

import com.suruomo.material.dto.Pcomp;
import org.apache.commons.lang.RandomStringUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 导出PCOMP卡片文件
 * @author 苏若墨
 */
public class ExportPcomp {
    public File export(Pcomp pcomp) throws IOException {
        File file = File.createTempFile(RandomStringUtils.random(5), ".bdf");
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String[] thetas=pcomp.getDATA().split("/");
        int size=thetas.length;
        try {
            //执行控制语句
            bufferedWriter.write("ID " + pcomp.getID()+"," +"LAYUP\n");
            bufferedWriter.write("SOL " + pcomp.getSOL()+"\n");
            bufferedWriter.write("CEND\n");
            //情况控制语句
            bufferedWriter.write("TITLE=" + pcomp.getTITLE()+"\n");
            bufferedWriter.write("BEGIN BULK\n");
            //模型数据集
            bufferedWriter.write("PCOMP,"+pcomp.getPID()+",,,,"+pcomp.getFT()+",,,"+pcomp.getLAM()+"\n");
            //若是对称铺层，只输入半铺层，否则输入全部层数据
            if(pcomp.getLAM().equals("SYM")){
                int number=1;
                for(int i=0;i<size/2;i+=2) {
                    if((i+1)>size/2-1){
                        bufferedWriter.write("     ,"+(number++)+",,"+thetas[i]+","+pcomp.getSOUT()+"\n");
                    }
                    else{
                        bufferedWriter.write("     ,"+(number++)+",,"+thetas[i]+","+pcomp.getSOUT()+","+(number++)+",,"+thetas[i+1]+","+pcomp.getSOUT()+"\n");
                    }
                }
            }else {
                int number=1;
                for(int i=0;i<size;i+=2) {
                    if((i+1)>size-1){
                        bufferedWriter.write("     ,"+(number++)+",,"+thetas[i]+","+pcomp.getSOUT()+"\n");
                    }
                    else {
                        bufferedWriter.write("     ," + (number++) + ",," + thetas[i] + "," + pcomp.getSOUT() + "," + (number++) + ",," + thetas[i + 1] + "," + pcomp.getSOUT() + "\n");
                    }
                }
            }
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
