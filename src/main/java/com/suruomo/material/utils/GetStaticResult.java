package com.suruomo.material.utils;

import com.suruomo.material.pojo.*;
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
 * @Date: 2021/5/9 15:24
 * @Description: 获取静力分析结果
 */
@Component
public class GetStaticResult {
    private static GetStaticService getStaticService;
    @Autowired
    public GetStaticResult(GetStaticService getStaticService){
        GetStaticResult.getStaticService=getStaticService;
    }

    /**
     * 1.读取边界条件数据
     * @param path
     */
    public static void readLoadBCSFile(String path,BigDecimal analysisId) {
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
            maxId=getStaticService.getLoadBCSMaxId();
            loadBCS.setId(new BigDecimal(maxId+1));
            getStaticService.insertLoadBCs(loadBCS);
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
            maxId=getStaticService.getMaterialMaxId();
            material.setId(new BigDecimal(maxId+1));
            getStaticService.insertMaterial(material);
        }
    }

    /**
     * 3.读取约束反力数据
     * @param path
     */
    public static void readConstraintForceResultFile(String path,BigDecimal analysisId) {
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
                // Constraint Forces Translational Min
                while ((line=reader.readLine())!=null){
                    if (line.contains("Constraint Forces Translational Min Start")){
                        reader.readLine();
                        while (true){
                            String s=reader.readLine();
                            if (!s.contains("Constraint Forces Translational Min End")){
                                translational_min_list.add(s);
                            }else {
                                break;
                            }
                        }
                        break;
                    }
                }
                // Constraint Forces Translational Max
                while ((line=reader.readLine())!=null){
                    if (line.contains("Constraint Forces Translational Max Start")){
                        reader.readLine();
                        while (true){
                            String s=reader.readLine();
                            if (!s.contains("Constraint Forces Translational Max End")){
                                translational_max_list.add(s);
                            }else {
                                break;
                            }
                        }
                        break;
                    }
                }
                // Constraint Forces Rotational Min
                while ((line=reader.readLine())!=null){
                    if (line.contains("Constraint Forces Rotational Min Start")){
                        reader.readLine();
                        while (true){
                            String s=reader.readLine();
                            if (!s.contains("Constraint Forces Rotational Min End")){
                                rotational_min_list.add(s);
                            }else {
                                break;
                            }
                        }
                        break;
                    }
                }
                // Constraint Forces Rotational Max
                while ((line=reader.readLine())!=null){
                    if (line.contains("Constraint Forces Rotational Max Start")){
                        reader.readLine();
                        while (true){
                            String s=reader.readLine();
                            if (!s.contains("Constraint Forces Rotational Max End")){
                                rotational_max_list.add(s);
                            }else {
                                break;
                            }
                        }
                        break;
                    }
                }
                getConstraintForceResult(translational_min_list,translational_max_list,rotational_min_list,rotational_max_list,analysisId);
                read.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 约束反力数据写入数据库
     * @param translational_min_list
     * @param rotational_max_list
     * @param rotational_min_list
     * @param rotational_max_list
     */
    private static void getConstraintForceResult(List<String> translational_min_list, List<String> translational_max_list, List<String> rotational_min_list, List<String> rotational_max_list,BigDecimal analysisId) {
        System.out.println("translation min 数据：");
        int maxId;
        for(String s:translational_min_list){
            String[] strings=s.split("\\*");
            ConstraintForceTMin constraintForceTMin=new ConstraintForceTMin();
            constraintForceTMin.setAnalysisId(analysisId);
            constraintForceTMin.setGroupName(strings[0]);
            constraintForceTMin.setLoadcaseName(strings[1]);
            constraintForceTMin.setSubcaseName(strings[2]);
            constraintForceTMin.setLayerName(strings[3]);
            constraintForceTMin.setT1(strings[4]);
            constraintForceTMin.setT2(strings[5]);
            constraintForceTMin.setT3(strings[6]);
            constraintForceTMin.setMagnitude(strings[7]);
            maxId=getStaticService.getCFTMinMaxId();
            constraintForceTMin.setId(new BigDecimal(maxId+1));
            getStaticService.insertCFTMin(constraintForceTMin);
        }
        System.out.println("translation max 数据：");
        for(String s:translational_max_list){
            String[] strings=s.split("\\*");
            ConstraintForceTMax constraintForceTMax=new ConstraintForceTMax();
            constraintForceTMax.setAnalysisId(analysisId);
            constraintForceTMax.setGroupName(strings[0]);
            constraintForceTMax.setLoadcaseName(strings[1]);
            constraintForceTMax.setSubcaseName(strings[2]);
            constraintForceTMax.setLayerName(strings[3]);
            constraintForceTMax.setT1(strings[4]);
            constraintForceTMax.setT2(strings[5]);
            constraintForceTMax.setT3(strings[6]);
            constraintForceTMax.setMagnitude(strings[7]);
            maxId=getStaticService.getCFTMaxMaxId();
            constraintForceTMax.setId(new BigDecimal(maxId+1));
            getStaticService.insertCFTMax(constraintForceTMax);
        }
        System.out.println("rotational min 数据：");
        for(String s:rotational_min_list){
            String[] strings=s.split("\\*");
            ConstraintForceRMin constraintForceRMin=new ConstraintForceRMin();
            constraintForceRMin.setAnalysisId(analysisId);
            constraintForceRMin.setGroupName(strings[0]);
            constraintForceRMin.setLoadcaseName(strings[1]);
            constraintForceRMin.setSubcaseName(strings[2]);
            constraintForceRMin.setLayerName(strings[3]);
            constraintForceRMin.setR1(strings[4]);
            constraintForceRMin.setR2(strings[5]);
            constraintForceRMin.setR3(strings[6]);
            constraintForceRMin.setMagnitude(strings[7]);
            maxId=getStaticService.getCFRMinMaxId();
            constraintForceRMin.setId(new BigDecimal(maxId+1));
            getStaticService.insertCFRMin(constraintForceRMin);
        }
        System.out.println("rotational max 数据：");
        for(String s:rotational_max_list){
            String[] strings=s.split("\\*");
            ConstraintForceRMax constraintForceRMax=new ConstraintForceRMax();
            constraintForceRMax.setAnalysisId(analysisId);
            constraintForceRMax.setGroupName(strings[0]);
            constraintForceRMax.setLoadcaseName(strings[1]);
            constraintForceRMax.setSubcaseName(strings[2]);
            constraintForceRMax.setLayerName(strings[3]);
            constraintForceRMax.setR1(strings[4]);
            constraintForceRMax.setR2(strings[5]);
            constraintForceRMax.setR3(strings[6]);
            constraintForceRMax.setMagnitude(strings[7]);
            maxId=getStaticService.getCFRMaxMaxId();
            constraintForceRMax.setId(new BigDecimal(maxId+1));
            getStaticService.insertCFRMax(constraintForceRMax);
        }
    }

    /**
     * 4.读取位移数据
     * @param path
     */
    public static void readDisplacementResultFile(String path,BigDecimal analysisId) {
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
                getDisplacementResult(translational_min_list,translational_max_list,rotational_min_list,rotational_max_list,analysisId);
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
    private static void getDisplacementResult(List<String> translational_min_list, List<String> translational_max_list, List<String> rotational_min_list, List<String> rotational_max_list,BigDecimal analysisId) {
        System.out.println("translation min 数据：");
        int maxId;
        for(String s:translational_min_list){
            String[] strings=s.split("\\*");
            DisplacementTranslationalMin translationalMin=new DisplacementTranslationalMin();
            translationalMin.setAnalysisId(analysisId);
            translationalMin.setGroupName(strings[0]);
            translationalMin.setLoadcaseName(strings[1]);
            translationalMin.setSubcaseName(strings[2]);
            translationalMin.setLayerName(strings[3]);
            translationalMin.setT1(strings[4]);
            translationalMin.setT2(strings[5]);
            translationalMin.setT3(strings[6]);
            translationalMin.setMagnitude(strings[7]);
            maxId=getStaticService.getTranslationalMinMaxId();
            translationalMin.setId(new BigDecimal(maxId+1));
            getStaticService.insertTranslationalMin(translationalMin);
        }
        System.out.println("translation max 数据：");
        for(String s:translational_max_list){
            String[] strings=s.split("\\*");
            DisplacementTranslationalMax translationalMax=new DisplacementTranslationalMax();
            translationalMax.setAnalysisId(analysisId);
            translationalMax.setGroupName(strings[0]);
            translationalMax.setLoadcaseName(strings[1]);
            translationalMax.setSubcaseName(strings[2]);
            translationalMax.setLayerName(strings[3]);
            translationalMax.setT1(strings[4]);
            translationalMax.setT2(strings[5]);
            translationalMax.setT3(strings[6]);
            translationalMax.setMagnitude(strings[7]);
            maxId=getStaticService.getTranslationalMaxMaxId();
            translationalMax.setId(new BigDecimal(maxId+1));
            getStaticService.insertTranslationalMax(translationalMax);
        }
        System.out.println("rotational min 数据：");
        for(String s:rotational_min_list){
            String[] strings=s.split("\\*");
            DisplacementRotationalMin rotationalMin=new DisplacementRotationalMin();
            rotationalMin.setAnalysisId(analysisId);
            rotationalMin.setGroupName(strings[0]);
            rotationalMin.setLoadcaseName(strings[1]);
            rotationalMin.setSubcaseName(strings[2]);
            rotationalMin.setLayerName(strings[3]);
            rotationalMin.setR1(strings[4]);
            rotationalMin.setR2(strings[5]);
            rotationalMin.setR3(strings[6]);
            rotationalMin.setMagnitude(strings[7]);
            maxId=getStaticService.getRotationalMinMaxId();
            rotationalMin.setId(new BigDecimal(maxId+1));
            getStaticService.insertRotationalMin(rotationalMin);
        }
        System.out.println("rotational max 数据：");
        for(String s:rotational_max_list){
            String[] strings=s.split("\\*");
            DisplacementRotationalMax rotationalMax=new DisplacementRotationalMax();
            rotationalMax.setAnalysisId(analysisId);
            rotationalMax.setGroupName(strings[0]);
            rotationalMax.setLoadcaseName(strings[1]);
            rotationalMax.setSubcaseName(strings[2]);
            rotationalMax.setLayerName(strings[3]);
            rotationalMax.setR1(strings[4]);
            rotationalMax.setR2(strings[5]);
            rotationalMax.setR3(strings[6]);
            rotationalMax.setMagnitude(strings[7]);
            maxId=getStaticService.getRotationalMaxMaxId();
            rotationalMax.setId(new BigDecimal(maxId+1));
            getStaticService.insertRotationalMax(rotationalMax);
        }
    }

    /**
     * 5.读取应力数据
     * @param path
     */
    public static void readStressResultFile(String path,BigDecimal analysisId) {
        try {
            File file=new File(path);
            if (file.isFile()&& file.exists()){
                InputStreamReader read=new InputStreamReader(new FileInputStream(path));
                BufferedReader reader=new BufferedReader(read);
                String line = "";
                List<String> stress_min_list=new ArrayList<>();
                List<String> stress_max_list=new ArrayList<>();
                // 读取Min
                while ((line=reader.readLine())!=null){
                    if (line.contains("Stress Tensor Min Start")){
                        reader.readLine();
                        while (true){
                            String s=reader.readLine();
                            if (!s.contains("Stress Tensor Min End")){
                                stress_min_list.add(s);
                            }else {
                                break;
                            }
                        }
                        break;
                    }
                }
                // 读取Max
                while ((line=reader.readLine())!=null){
                    if (line.contains("Stress Tensor Max Start")){
                        reader.readLine();
                        while (true){
                            String s=reader.readLine();
                            if (!s.contains("Stress Tensor Max End")){
                                stress_max_list.add(s);
                            }else {
                                break;
                            }
                        }
                        break;
                    }
                }
                getStressResult(stress_min_list,stress_max_list,analysisId);
                read.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 应力数据写入数据库
     * @param stress_min_list
     * @param stress_max_list
     */
    private static void getStressResult(List<String> stress_min_list, List<String> stress_max_list,BigDecimal analysisId) {
        System.out.println("stress min 数据：");
        int maxId;
        for(String s:stress_min_list){
            String[] strings=s.split("\\*");
            StressMin stressMin=new StressMin();
            stressMin.setAnalysisId(analysisId);
            stressMin.setGroupName(strings[0]);
            stressMin.setLoadcaseName(strings[1]);
            stressMin.setSubcaseName(strings[2]);
            stressMin.setLayerName(strings[3]);
            stressMin.setX(strings[4]);
            stressMin.setY(strings[5]);
            stressMin.setZ(strings[6]);
            stressMin.setXy(strings[7]);
            stressMin.setYz(strings[8]);
            stressMin.setZx(strings[9]);
            stressMin.setVonMises(strings[10]);
            maxId=getStaticService.getStressMinMaxId();
            stressMin.setId(new BigDecimal(maxId+1));
            getStaticService.insertStressMin(stressMin);
        }
        System.out.println("stress max 数据：");
        for(String s:stress_max_list){
            String[] strings=s.split("\\*");
            StressMax stressMax=new StressMax();
            stressMax.setAnalysisId(analysisId);
            stressMax.setGroupName(strings[0]);
            stressMax.setLoadcaseName(strings[1]);
            stressMax.setSubcaseName(strings[2]);
            stressMax.setLayerName(strings[3]);
            stressMax.setX(strings[4]);
            stressMax.setY(strings[5]);
            stressMax.setZ(strings[6]);
            stressMax.setXy(strings[7]);
            stressMax.setYz(strings[8]);
            stressMax.setZx(strings[9]);
            stressMax.setVonMises(strings[10]);
            maxId=getStaticService.getStressMaxMaxId();
            stressMax.setId(new BigDecimal(maxId+1));
            getStaticService.insertStressMax(stressMax);
        }
    }

    /**
     * 6.读取应变数据
     * @param path
     */
    public static void readStrainResultFile(String path,BigDecimal analysisId) {
        try {
            File file=new File(path);
            if (file.isFile()&& file.exists()){
                InputStreamReader read=new InputStreamReader(new FileInputStream(path));
                BufferedReader reader=new BufferedReader(read);
                String line = "";
                List<String> strain_min_list=new ArrayList<>();
                List<String> strain_max_list=new ArrayList<>();
                // 读取Min
                while ((line=reader.readLine())!=null){
                    if (line.contains("Strain Tensor Min Start")){
                        reader.readLine();
                        while (true){
                            String s=reader.readLine();
                            if (!s.contains("Strain Tensor Min End")){
                                strain_min_list.add(s);
                            }else {
                                break;
                            }
                        }
                        break;
                    }
                }
                // 读取Max
                while ((line=reader.readLine())!=null){
                    if (line.contains("Strain Tensor Max Start")){
                        reader.readLine();
                        while (true){
                            String s=reader.readLine();
                            if (!s.contains("Strain Tensor Max End")){
                                strain_max_list.add(s);
                            }else {
                                break;
                            }
                        }
                        break;
                    }
                }
                getStrainResult(strain_min_list,strain_max_list,analysisId);
                read.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 应变数据写入数据库
     * @param strain_min_list
     * @param strain_max_list
     */
    private static void getStrainResult(List<String> strain_min_list, List<String> strain_max_list,BigDecimal analysisId) {
        System.out.println("strain min 数据：");
        int maxId;
        for(String s:strain_min_list){
            String[] strings=s.split("\\*");
            StrainMin strainMin=new StrainMin();
            strainMin.setAnalysisId(analysisId);
            strainMin.setGroupName(strings[0]);
            strainMin.setLoadcaseName(strings[1]);
            strainMin.setSubcaseName(strings[2]);
            strainMin.setLayerName(strings[3]);
            strainMin.setX(strings[4]);
            strainMin.setY(strings[5]);
            strainMin.setZ(strings[6]);
            strainMin.setXy(strings[7]);
            strainMin.setYz(strings[8]);
            strainMin.setZx(strings[9]);
            strainMin.setVonMises(strings[10]);
            maxId=getStaticService.getStrainMinMaxId();
            strainMin.setId(new BigDecimal(maxId+1));
            getStaticService.insertStrainMin(strainMin);
        }
        System.out.println("strain max 数据：");
        for(String s:strain_max_list){
            String[] strings=s.split("\\*");
            StrainMax strainMax=new StrainMax();
            strainMax.setAnalysisId(analysisId);
            strainMax.setGroupName(strings[0]);
            strainMax.setLoadcaseName(strings[1]);
            strainMax.setSubcaseName(strings[2]);
            strainMax.setLayerName(strings[3]);
            strainMax.setX(strings[4]);
            strainMax.setY(strings[5]);
            strainMax.setZ(strings[6]);
            strainMax.setXy(strings[7]);
            strainMax.setYz(strings[8]);
            strainMax.setZx(strings[9]);
            strainMax.setVonMises(strings[10]);
            maxId=getStaticService.getStrainMaxMaxId();
            strainMax.setId(new BigDecimal(maxId+1));
            getStaticService.insertStrainMax(strainMax);
        }
    }
}
