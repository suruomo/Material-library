package com.suruomo.material.utils;

import com.suruomo.material.pojo.*;
import com.suruomo.material.service.GetModeService;
import com.suruomo.material.service.GetStaticService;
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
 * @Date: 2021/7/6 15:37
 * @Description: 获取模态分析结果
 */
@Component
public class GetModeResult {
    private static GetModeService getModeService;
    @Autowired
    public GetModeResult(GetModeService getModeService){
        GetModeResult.getModeService=getModeService;
    }

    /**
     * 1.读取边界条件数据
     * @param path
     */
    public static void readLoadBCSFile(String path, BigDecimal analysisId) {
        try {
            File file=new File(path);
            if (file.isFile()&& file.exists()){
                InputStreamReader read=new InputStreamReader(new FileInputStream(path));
                BufferedReader reader=new BufferedReader(read);
                String line = "";
                List<String> list=new ArrayList<>();
                // 读取Displacements Translational Min
                while ((line=reader.readLine())!=null){
                    if (line.contains("Load/BCs Start")){
                        reader.readLine();
                        while (true){
                            String s=reader.readLine();
                            if (!s.contains("Load/BCs End")){
                                list.add(s);
                            }else {
                                break;
                            }
                        }
                        break;
                    }
                }
                getLoadBCS(list,analysisId);
                read.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 边界条件数据写入数据库
     * @param list
     */
    private static void getLoadBCS(List<String> list,BigDecimal analysisId){
        int maxId;
        for(String s:list){
            String[] strings=s.split("\\*");
            LoadBCS loadBCS=new LoadBCS();
            loadBCS.setAnalysisId(analysisId);
            loadBCS.setLoadcaseName(strings[0]);
            loadBCS.setLoadcaseType(strings[1]);
            loadBCS.setLoadId(strings[2]);
            loadBCS.setLoadName(strings[3]);
            loadBCS.setLoadType(strings[4]);
            loadBCS.setApplicationType(strings[5]);
            loadBCS.setElementDimension(strings[6]);
            maxId=getModeService.getLoadBCSMaxId();
            loadBCS.setId(new BigDecimal(maxId+1));
            getModeService.insertLoadBCs(loadBCS);
        }
    }
    /**
     * 2.读取材料数据
     * @param path
     */
    public static void readMaterialFile(String path,BigDecimal analysisId) {
        try {
            File file=new File(path);
            if (file.isFile()&& file.exists()){
                InputStreamReader read=new InputStreamReader(new FileInputStream(path));
                BufferedReader reader=new BufferedReader(read);
                String line = "";
                List<String> list=new ArrayList<>();
                // 读取Displacements Translational Min
                while ((line=reader.readLine())!=null){
                    if (line.contains("Material Start")){
                        reader.readLine();
                        while (true){
                            String s=reader.readLine();
                            if (!s.contains("Material End")){
                                list.add(s);
                            }else {
                                break;
                            }
                        }
                        break;
                    }
                }
                getMaterial(list,analysisId);
                read.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 材料数据写入数据库
     * @param list
     */
    private static void getMaterial(List<String> list,BigDecimal analysisId){
        int maxId;
        for(String s:list){
            String[] strings=s.split("\\*");
            Material material=new Material();
            material.setAnalysisId(analysisId);
            material.setMaterialName(strings[0]);
            material.setMaterialInfo(strings[1]);
            maxId=getModeService.getMaterialMaxId();
            material.setId(new BigDecimal(maxId+1));
            getModeService.insertMaterial(material);
        }
    }

    /**
     * 3.读取模态频率数据
     * @param path
     */
    public static void readFrequencyFile(String path,BigDecimal analysisId) {
        try {
            File file=new File(path);
            if (file.isFile()&& file.exists()){
                InputStreamReader read=new InputStreamReader(new FileInputStream(path));
                BufferedReader reader=new BufferedReader(read);
                String line = "";
                List<String> list=new ArrayList<>();
                // 读取Min
                while ((line=reader.readLine())!=null){
                    if (line.contains("Modal Frequency Start")){
                        reader.readLine();
                        reader.readLine();
                        reader.readLine();
                        while (true){
                            String s=reader.readLine();
                            if (!s.contains("Modal Frequency End")){
                                list.add(s);
                            }else {
                                break;
                            }
                        }
                        break;
                    }
                }
                getFrequency(list,analysisId);
                read.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 模态频率数据写入数据库
     * @param list
     */
    private static void getFrequency(List<String> list,BigDecimal analysisId) {
        System.out.println("frequency 数据：");
        int maxId;
        for(String s:list){
            String[] strings=s.trim().split("\\s+");
            ModeFrequencyResult frequencyResult=new ModeFrequencyResult();
            frequencyResult.setAnalysisId(analysisId);
            frequencyResult.setModeNo(new BigDecimal(strings[0]));
            frequencyResult.setModeOrder(new BigDecimal(strings[1]));
            frequencyResult.setE(strings[2]);
            frequencyResult.setR(strings[3]);
            frequencyResult.setC(strings[4]);
            frequencyResult.setMass(strings[5]);
            frequencyResult.setStiffness(strings[6]);
            maxId=getModeService.getFrequencyMaxId();
            frequencyResult.setId(new BigDecimal(maxId+1));
            getModeService.insertFrequency(frequencyResult);
        }
    }

    /**
     * 3.读取模态参与因子数据
     * @param path
     */
    public static void readFactorsFile(String path,BigDecimal analysisId) {
        try {
            File file=new File(path);
            if (file.isFile()&& file.exists()){
                InputStreamReader read=new InputStreamReader(new FileInputStream(path));
                BufferedReader reader=new BufferedReader(read);
                String line = "";
                List<String> list=new ArrayList<>();
                // 读取Min
                while ((line=reader.readLine())!=null){
                    if (line.contains("Modal Participation Factors Start")){
                        reader.readLine();
                        reader.readLine();
                        reader.readLine();
                        reader.readLine();
                        reader.readLine();
                        while (true){
                            String s=reader.readLine();
                            if (!s.contains("Modal Participation Factors End")){
                                list.add(s);
                            }else {
                                list.remove(list.size()-1);
                                break;
                            }
                        }
                        break;
                    }
                }
                getFrequency(list,analysisId);
                read.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 模态参与因子数据写入数据库
     * @param list
     */
    private static void getFactors(List<String> list,BigDecimal analysisId) {
        System.out.println("factors 数据：");
        int maxId;
        for(String s:list){
            String[] strings=s.trim().split("\\s+");
            ModeFactors modeFactors=new ModeFactors();
            modeFactors.setAnalysisId(analysisId);
            modeFactors.setModeNo(new BigDecimal(strings[0]));
            modeFactors.setFrequency(new BigDecimal(strings[1]));
            modeFactors.setT1(strings[2]);
            modeFactors.setT2(strings[3]);
            modeFactors.setT3(strings[4]);
            modeFactors.setR1(strings[5]);
            modeFactors.setR2(strings[6]);
            modeFactors.setR3(strings[7]);
            maxId=getModeService.getFactorsMaxId();
            modeFactors.setId(new BigDecimal(maxId+1));
            getModeService.insertFactors(modeFactors);
        }
    }

    /**
     * 3.读取模态单点约束数据
     * @param path
     */
    public static void readSpcForcesFile(String path,BigDecimal analysisId) {
        try {
            File file=new File(path);
            if (file.isFile()&& file.exists()){
                InputStreamReader read=new InputStreamReader(new FileInputStream(path));
                BufferedReader reader=new BufferedReader(read);
                String line = "";
                List<String> list=new ArrayList<>();
                // 读取Min
                while ((line=reader.readLine())!=null){
                    if (line.contains("SpcForces Start")){
                        reader.readLine();
                        reader.readLine();
                        reader.readLine();
                        while (true){
                            String s=reader.readLine();
                            if (!s.contains("SpcForces End")){
                                list.add(s);
                            }else {
                                break;
                            }
                        }
                        break;
                    }
                }
                getSpcForces(list,analysisId);
                read.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 单点约束数据写入数据库
     * @param list
     */
    private static void getSpcForces(List<String> list,BigDecimal analysisId) {
        System.out.println("spcforces 数据：");
        int maxId;
        for(String s:list){
            String[] strings=s.trim().split("\\s+");
            ModeMaxSpcForces spcForces=new ModeMaxSpcForces();
            spcForces.setAnalysisId(analysisId);
            spcForces.setModeNo(new BigDecimal(strings[1]));
            spcForces.setT1(strings[2]);
            spcForces.setT2(strings[3]);
            spcForces.setT3(strings[4]);
            spcForces.setR1(strings[5]);
            spcForces.setR2(strings[6]);
            spcForces.setR3(strings[7]);
            maxId=getModeService.getSpcForcesMaxId();
            spcForces.setId(new BigDecimal(maxId+1));
            getModeService.insertSpcForces(spcForces);
        }
    }

    /**
     * 4.读取模态最大位移数据
     * @param path
     */
    public static void readDisplacementsFile(String path,BigDecimal analysisId) {
        try {
            File file=new File(path);
            if (file.isFile()&& file.exists()){
                InputStreamReader read=new InputStreamReader(new FileInputStream(path));
                BufferedReader reader=new BufferedReader(read);
                String line = "";
                List<String> list=new ArrayList<>();
                // 读取Min
                while ((line=reader.readLine())!=null){
                    if (line.contains("Max Displacement Start")){
                        reader.readLine();
                        reader.readLine();
                        reader.readLine();
                        while (true){
                            String s=reader.readLine();
                            if (!s.contains("Max Displacement End")){
                                list.add(s);
                            }else {
                                break;
                            }
                        }
                        break;
                    }
                }
                getDisplacements(list,analysisId);
                read.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 最大位移数据写入数据库
     * @param list
     */
    private static void getDisplacements(List<String> list,BigDecimal analysisId) {
        System.out.println("displacements 数据：");
        int maxId;
        for(String s:list){
            String[] strings=s.trim().split("\\s+");
            System.out.println(s);
            ModeMaxDisplacements displacements=new ModeMaxDisplacements();
            displacements.setAnalysisId(analysisId);
            displacements.setModeNo(new BigDecimal(strings[1]));
            displacements.setT1(strings[2]);
            displacements.setT2(strings[3]);
            displacements.setT3(strings[4]);
            displacements.setR1(strings[5]);
            displacements.setR2(strings[6]);
            displacements.setR3(strings[7]);
            maxId=getModeService.getDisplacementsMaxId();
            displacements.setId(new BigDecimal(maxId+1));
            getModeService.insertDisplacements(displacements);
        }
    }
}
