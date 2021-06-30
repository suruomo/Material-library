package com.suruomo.material.utils;

import com.suruomo.material.pojo.DisplacementRotationalMax;
import com.suruomo.material.pojo.DisplacementRotationalMin;
import com.suruomo.material.pojo.DisplacementTranslationalMax;
import com.suruomo.material.pojo.DisplacementTranslationalMin;
import com.suruomo.material.service.DisplacementService;
import com.suruomo.material.service.impl.DisplacementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: suruomo
 * @Date: 2021/5/9 15:24
 * @Description: 获取静力分析结果
 */
@Component
public class GetStaticResult {
    private static DisplacementService displacementService;
    @Autowired
    public GetStaticResult(DisplacementService displacementService){
        GetStaticResult.displacementService=displacementService;
    }
    /**
     * 文件中读取位移数据
     * @param path
     */
    public static void readDisplacementResultFile(String path) {
        try {
            File file=new File(path);
            if (file.isFile()&& file.exists()){
                InputStreamReader read=new InputStreamReader(new FileInputStream(path));
                BufferedReader reader=new BufferedReader(read);
                String line = "";
                List<String> translational_min_list=new ArrayList<>();
                List<String> translational_max_list=new ArrayList<>();
                List<String> rotational_min_list=new ArrayList<>();
                List<String> rotational_max_list=new ArrayList<>();
                // 读取Displacements Translational Min
                while ((line=reader.readLine())!=null){
                    if (line.contains("Displacements Translational Min Start")){
                        reader.readLine();
                        while (true){
                            String s=reader.readLine();
                            if (!s.contains("Displacements Translational Min End")){
                                translational_min_list.add(s);
                            }else {
                                break;
                            }
                        }
                        break;
                    }
                }
                // 读取Displacements Translational Max
                while ((line=reader.readLine())!=null){
                    if (line.contains("Displacements Translational Max Start")){
                        reader.readLine();
                        while (true){
                            String s=reader.readLine();
                            if (!s.contains("Displacements Translational Max End")){
                                translational_max_list.add(s);
                            }else {
                                break;
                            }
                        }
                        break;
                    }
                }
                // 读取Displacements Rotational Min
                while ((line=reader.readLine())!=null){
                    if (line.contains("Displacements Rotational Min Start")){
                        reader.readLine();
                        while (true){
                            String s=reader.readLine();
                            if (!s.contains("Displacements Rotational Min End")){
                                rotational_min_list.add(s);
                            }else {
                                break;
                            }
                        }
                        break;
                    }
                }
                // 读取Displacements Rotational Max
                while ((line=reader.readLine())!=null){
                    if (line.contains("Displacements Rotational Max Start")){
                        reader.readLine();
                        while (true){
                            String s=reader.readLine();
                            if (!s.contains("Displacements Rotational Max End")){
                                rotational_max_list.add(s);
                            }else {
                                break;
                            }
                        }
                        break;
                    }
                }
                getDisplacementResult(translational_min_list,translational_max_list,rotational_min_list,rotational_max_list);
                read.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 位移数据写入数据库
     * @param translational_min_list
     * @param rotational_max_list
     * @param rotational_min_list
     * @param rotational_max_list
     */
    private static void getDisplacementResult(List<String> translational_min_list, List<String> translational_max_list, List<String> rotational_min_list, List<String> rotational_max_list) {
        System.out.println("translation min 数据：");
        int maxId;
        for(String s:translational_min_list){
            String[] strings=s.split("\\*");
            DisplacementTranslationalMin translationalMin=new DisplacementTranslationalMin();
            translationalMin.setAnalysisId(new BigDecimal(1));
            translationalMin.setGroupName(strings[0]);
            translationalMin.setLoadcaseName(strings[1]);
            translationalMin.setSubcaseName(strings[2]);
            translationalMin.setLayerName(strings[3]);
            translationalMin.setT1(strings[4]);
            translationalMin.setT2(strings[5]);
            translationalMin.setT3(strings[6]);
            translationalMin.setMagnitude(strings[7]);
            maxId=displacementService.getTranslationalMinMaxId();
            translationalMin.setId(new BigDecimal(maxId+1));
            displacementService.insertTranslationalMin(translationalMin);
        }
        System.out.println("translation max 数据：");
        for(String s:translational_max_list){
            String[] strings=s.split("\\*");
            DisplacementTranslationalMax translationalMax=new DisplacementTranslationalMax();
            translationalMax.setAnalysisId(new BigDecimal(1));
            translationalMax.setGroupName(strings[0]);
            translationalMax.setLoadcaseName(strings[1]);
            translationalMax.setSubcaseName(strings[2]);
            translationalMax.setLayerName(strings[3]);
            translationalMax.setT1(strings[4]);
            translationalMax.setT2(strings[5]);
            translationalMax.setT3(strings[6]);
            translationalMax.setMagnitude(strings[7]);
            maxId=displacementService.getTranslationalMaxMaxId();
            translationalMax.setId(new BigDecimal(maxId+1));
            displacementService.insertTranslationalMax(translationalMax);
        }
        System.out.println("rotational min 数据：");
        for(String s:rotational_min_list){
            String[] strings=s.split("\\*");
            DisplacementRotationalMin rotationalMin=new DisplacementRotationalMin();
            rotationalMin.setAnalysisId(new BigDecimal(1));
            rotationalMin.setGroupName(strings[0]);
            rotationalMin.setLoadcaseName(strings[1]);
            rotationalMin.setSubcaseName(strings[2]);
            rotationalMin.setLayerName(strings[3]);
            rotationalMin.setR1(strings[4]);
            rotationalMin.setR2(strings[5]);
            rotationalMin.setR3(strings[6]);
            rotationalMin.setMagnitude(strings[7]);
            maxId=displacementService.getRotationalMinMaxId();
            rotationalMin.setId(new BigDecimal(maxId+1));
            displacementService.insertRotationalMin(rotationalMin);
        }
        System.out.println("rotational max 数据：");
        for(String s:rotational_max_list){
            String[] strings=s.split("\\*");
            DisplacementRotationalMax rotationalMax=new DisplacementRotationalMax();
            rotationalMax.setAnalysisId(new BigDecimal(1));
            rotationalMax.setGroupName(strings[0]);
            rotationalMax.setLoadcaseName(strings[1]);
            rotationalMax.setSubcaseName(strings[2]);
            rotationalMax.setLayerName(strings[3]);
            rotationalMax.setR1(strings[4]);
            rotationalMax.setR2(strings[5]);
            rotationalMax.setR3(strings[6]);
            rotationalMax.setMagnitude(strings[7]);
            maxId=displacementService.getRotationalMaxMaxId();
            rotationalMax.setId(new BigDecimal(maxId+1));
            displacementService.insertRotationalMax(rotationalMax);
        }
    }

    /**
     * 读取节点约束力汇总数据
     * @param path
     */
    private  void readConstrainForceResultFile(String path) {
        try {
            File file=new File(path);
            if (file.isFile()&& file.exists()){
                InputStreamReader read=new InputStreamReader(new FileInputStream(path));
                BufferedReader reader=new BufferedReader(read);
                String line = "";
                List<String> list=new ArrayList<>();
                while ((line=reader.readLine())!=null){
                    String[] strings=line.trim().split("\\s+");
                    if (strings.length>10&&"F".equals(strings[0])&&"O".equals(strings[1])&&"R".equals(strings[2])){
                        reader.readLine();
                        reader.readLine();
                        while (true){
                            String s=reader.readLine();
                            if (!s.contains("NASTRAN")){
                                list.add(s);
                            }else {
                                break;
                            }
                        }
                    }
                }
                getConstrainForceResult(list);
                read.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private  void getConstrainForceResult(List<String> list) {
        System.out.println("节点约束力汇总数据：");
        for(String s:list){
            System.out.println(s);
        }
    }

}
