package com.suruomo.material.utils;

import com.suruomo.material.pojo.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 苏若墨
 */
public class ExcelUtil {
    /**
     *填充原始金属数据
     * @param list
     * @return
     */
    public Workbook fillMetalOriginal(List<MetalInput> list, String templateFileName) throws IOException {
        //首先:从本地磁盘读取模板excel文件,然后读取第一个sheet
        InputStream inp=ExcelUtil.class.getResourceAsStream("/download/"+templateFileName);
       //        POIFSFileSystem fs=new POIFSFileSystem(inp);
        Workbook wb  = null;
        try {
           // 解析2007版本
            wb  = new XSSFWorkbook(inp);
        } catch (Exception ex) {
            try {
                // 解析2003版本
                POIFSFileSystem pfs = new POIFSFileSystem(inp);
                wb = new HSSFWorkbook(pfs);
            } catch (IOException e) {
            }
        }
        Sheet sheet=wb.getSheetAt(0);

        //开始写入数据到模板中: 需要注意的是,因为行头以及设置好,故而需要跳过行头
        int cellNums=sheet.getRow(0).getLastCellNum();
        int rowIndex=1;
        //循环将数据写入表中
        for (MetalInput metal:list) {
            Row row = sheet.createRow(rowIndex++);
            row.createCell(0).setCellValue(metal.getTypeName());
            row.createCell(1).setCellValue(metal.getName());
            row.createCell(2).setCellValue(metal.getFamily());
            row.createCell(3).setCellValue(metal.getSpecification());
            row.createCell(4).setCellValue(metal.getForm());
            row.createCell(5).setCellValue(metal.getTemper());
            row.createCell(6).setCellValue(metal.getThMin()==null?null:metal.getThMin().toString());
            row.createCell(7).setCellValue(metal.getThMax()==null?null:metal.getThMax().toString());
            row.createCell(8).setCellValue(metal.getBasis());
            row.createCell(9).setCellValue(metal.getDirection());
            row.createCell(10).setCellValue(metal.getE()==null?null:metal.getE().toString());
            row.createCell(11).setCellValue(metal.geteSec()==null?null:metal.geteSec().toString());
            row.createCell(12).setCellValue(metal.geteC()==null?null:metal.geteC().toString());
            row.createCell(13).setCellValue(metal.geteCSec()==null?null:metal.geteCSec().toString());
            row.createCell(14).setCellValue(metal.getfBru15()==null?null:metal.getfBru15().toString());
            row.createCell(15).setCellValue(metal.getfBru20()==null?null:metal.getfBru20().toString());
            row.createCell(16).setCellValue(metal.getfBry15()==null?null:metal.getfBry15().toString());
            row.createCell(17).setCellValue(metal.getfBry20()==null?null:metal.getfBry20().toString());
            row.createCell(18).setCellValue(metal.getfCy()==null?null:metal.getfCy().toString());
            row.createCell(19).setCellValue(metal.getfSu()==null?null:metal.getfSu().toString());
            row.createCell(20).setCellValue(metal.getfTu()==null?null:metal.getfTu().toString());
            row.createCell(21).setCellValue(metal.getfTy()==null?null:metal.getfTy().toString());
            row.createCell(22).setCellValue(metal.getG()==null?null:metal.getG().toString());
            row.createCell(23).setCellValue(metal.getNu()==null?null:metal.getNu().toString());
        }
        return wb;
    }

    /**
     * 填充金属材料卡
     * @param list
     * @param templateFileName
     * @return
     */
    public Workbook fillMetalCard(List<MetalOut> list, String templateFileName) {
        //首先:从本地磁盘读取模板excel文件,然后读取第一个sheet
        InputStream inp=ExcelUtil.class.getResourceAsStream("/download/"+templateFileName);
        //        POIFSFileSystem fs=new POIFSFileSystem(inp);
        Workbook wb  = null;
        try {
            // 解析2007版本
            wb  = new XSSFWorkbook(inp);
        } catch (Exception ex) {
            try {
                // 解析2003版本
                POIFSFileSystem pfs = new POIFSFileSystem(inp);
                wb = new HSSFWorkbook(pfs);
            } catch (IOException e) {
            }
        }
        Sheet sheet=wb.getSheetAt(0);

        //开始写入数据到模板中: 需要注意的是,因为行头以及设置好,故而需要跳过行头
        int cellNums=sheet.getRow(0).getLastCellNum();
        int rowIndex=1;
        //循环将数据写入表中
        for (MetalOut metal:list) {
            Row row = sheet.createRow(rowIndex++);
            row.createCell(0).setCellValue(metal.getTypeName());
            row.createCell(1).setCellValue(metal.getName());
            row.createCell(2).setCellValue(metal.getFamily());
            row.createCell(3).setCellValue(metal.getSpecification());
            row.createCell(4).setCellValue(metal.getForm());
            row.createCell(5).setCellValue(metal.getTemper());
            row.createCell(6).setCellValue(metal.getMatId()==null?null:metal.getMatId().toString());
            row.createCell(7).setCellValue(metal.getE()==null?null:metal.getE().toString());
            row.createCell(8).setCellValue(metal.geteC()==null?null:metal.geteC().toString());
            row.createCell(9).setCellValue(metal.getNu()==null?null:metal.getNu().toString());
            row.createCell(10).setCellValue(metal.getG()==null?null:metal.getG().toString());
            row.createCell(11).setCellValue(metal.getfTu()==null?null:metal.getfTu().toString());
            row.createCell(12).setCellValue(metal.getfTy()==null?null:metal.getfTy().toString());
            row.createCell(13).setCellValue(metal.getfCy()==null?null:metal.getfCy().toString());
            row.createCell(14).setCellValue(metal.getfSu()==null?null:metal.getfSu().toString());
            row.createCell(15).setCellValue(metal.getfBru()==null?null:metal.getfBru().toString());
            row.createCell(16).setCellValue(metal.getfBry()==null?null:metal.getfBry().toString());
            row.createCell(17).setCellValue(metal.getRho()==null?null:metal.getRho().toString());
            row.createCell(18).setCellValue(metal.getA()==null?null:metal.getA().toString());
            row.createCell(19).setCellValue(metal.getBooks());
            row.createCell(20).setCellValue(metal.getRemark());
            row.createCell(21).setCellValue(metal.getAircraft());
        }
        return wb;
    }

    /**
     * 填充原始复合
     * @param list
     * @param templateFileName
     * @return
     */
    public Workbook fillCompositeOriginal(List<CompositeInput> list, String templateFileName) {
        //首先:从本地磁盘读取模板excel文件,然后读取第一个sheet
        InputStream inp=ExcelUtil.class.getResourceAsStream("/download/"+templateFileName);
        //        POIFSFileSystem fs=new POIFSFileSystem(inp);
        Workbook wb  = null;
        try {
            // 解析2007版本
            wb  = new XSSFWorkbook(inp);
        } catch (Exception ex) {
            try {
                // 解析2003版本
                POIFSFileSystem pfs = new POIFSFileSystem(inp);
                wb = new HSSFWorkbook(pfs);
            } catch (IOException e) {
            }
        }
        Sheet sheet=wb.getSheetAt(0);

        //开始写入数据到模板中: 需要注意的是,因为行头以及设置好,故而需要跳过行头
        int cellNums=sheet.getRow(0).getLastCellNum();
        int rowIndex=1;
        //循环将数据写入表中
        for (CompositeInput compositeInput:list) {
            Row row = sheet.createRow(rowIndex++);
            row.createCell(0).setCellValue(compositeInput.getName());
            row.createCell(1).setCellValue(compositeInput.getParameter());
            row.createCell(2).setCellValue(compositeInput.getCondition());
            row.createCell(3).setCellValue(compositeInput.getValue()==null?null:compositeInput.getValue().toString());
        }
        return wb;
    }

    /**
     * 填充复材材料卡
     * @param list
     * @param templateFileName
     * @return
     */
    public Workbook fillCompositeCard(List<CompositeOut> list, String templateFileName) {
        //首先:从本地磁盘读取模板excel文件,然后读取第一个sheet
        InputStream inp=ExcelUtil.class.getResourceAsStream("/download/"+templateFileName);
        //        POIFSFileSystem fs=new POIFSFileSystem(inp);
        Workbook wb  = null;
        try {
            // 解析2007版本
            wb  = new XSSFWorkbook(inp);
        } catch (Exception ex) {
            try {
                // 解析2003版本
                POIFSFileSystem pfs = new POIFSFileSystem(inp);
                wb = new HSSFWorkbook(pfs);
            } catch (IOException e) {
            }
        }
        Sheet sheet=wb.getSheetAt(0);

        //开始写入数据到模板中: 需要注意的是,因为行头以及设置好,故而需要跳过行头
        int cellNums=sheet.getRow(0).getLastCellNum();
        int rowIndex=1;
        //循环将数据写入表中
        for (CompositeOut compositeOut:list) {
            Row row = sheet.createRow(rowIndex++);
            row.createCell(0).setCellValue(compositeOut.getName());
            row.createCell(1).setCellValue(compositeOut.getMatId());
            row.createCell(2).setCellValue(compositeOut.getTemperature()==null?null:compositeOut.getTemperature().toString());
            row.createCell(3).setCellValue(compositeOut.getThickness()==null?null:compositeOut.getThickness().toString());
            row.createCell(4).setCellValue(compositeOut.getE1()==null?null:compositeOut.getE1().toString());
            row.createCell(5).setCellValue(compositeOut.getE2()==null?null:compositeOut.getE2().toString());
            row.createCell(6).setCellValue(compositeOut.getNu12()==null?null:compositeOut.getNu12().toString());
            row.createCell(7).setCellValue(compositeOut.getG12()==null?null:compositeOut.getG12().toString());
            row.createCell(8).setCellValue(compositeOut.getG1z()==null?null:compositeOut.getG1z().toString());
            row.createCell(9).setCellValue(compositeOut.getG2z()==null?null:compositeOut.getG2z().toString());
            row.createCell(10).setCellValue(compositeOut.getRho()==null?null:compositeOut.getRho().toString());
            row.createCell(11).setCellValue(compositeOut.getA()==null?null:compositeOut.getA().toString());
            row.createCell(12).setCellValue(compositeOut.getRemark());
            row.createCell(13).setCellValue(compositeOut.getAircraft());
        }
        return wb;
    }

    /**
     * 批量导出铺层
     * @param list
     * @param templateFileName
     * @return
     */
    public Workbook fillLayup(List<Layup> list, String templateFileName) {
        //首先:从本地磁盘读取模板excel文件,然后读取第一个sheet
        InputStream inp=ExcelUtil.class.getResourceAsStream("/download/"+templateFileName);
        //        POIFSFileSystem fs=new POIFSFileSystem(inp);
        Workbook wb  = null;
        try {
            // 解析2007版本
            wb  = new XSSFWorkbook(inp);
        } catch (Exception ex) {
            try {
                // 解析2003版本
                POIFSFileSystem pfs = new POIFSFileSystem(inp);
                wb = new HSSFWorkbook(pfs);
            } catch (IOException e) {
            }
        }
        Sheet sheet=wb.getSheetAt(0);

        //开始写入数据到模板中: 需要注意的是,因为行头以及设置好,故而需要跳过行头
        int cellNums=sheet.getRow(0).getLastCellNum();
        int rowIndex=1;
        //循环将数据写入表中
        for (Layup layup:list) {
            Row row = sheet.createRow(rowIndex++);
            row.createCell(0).setCellValue(layup.getName());
            row.createCell(1).setCellValue(layup.getMid());
            row.createCell(2).setCellValue(layup.getPly());
            row.createCell(3).setCellValue(layup.getSymmetry());
            row.createCell(4).setCellValue(layup.getBalance());
            row.createCell(5).setCellValue(layup.getT()==null?null:layup.getT().toString());
            row.createCell(6).setCellValue(layup.getExx()==null?null:layup.getExx().toString());
            row.createCell(7).setCellValue(layup.getEyy()==null?null:layup.getEyy().toString());
            row.createCell(8).setCellValue(layup.getGxy()==null?null:layup.getGxy().toString());
            row.createCell(9).setCellValue(layup.getNuxy()==null?null:layup.getNuxy().toString());
            row.createCell(10).setCellValue(layup.getNuyx()==null?null:layup.getNuyx().toString());
            row.createCell(11).setCellValue(layup.getA11()==null?null:layup.getA11().toString());
            row.createCell(12).setCellValue(layup.getA22()==null?null:layup.getA22().toString());
            row.createCell(13).setCellValue(layup.getA12()==null?null:layup.getA12().toString());
            row.createCell(14).setCellValue(layup.getA66()==null?null:layup.getA66().toString());
            row.createCell(15).setCellValue(layup.getD11()==null?null:layup.getD11().toString());
            row.createCell(16).setCellValue(layup.getD22()==null?null:layup.getD22().toString());
            row.createCell(17).setCellValue(layup.getD12()==null?null:layup.getD12().toString());
            row.createCell(18).setCellValue(layup.getD66()==null?null:layup.getD66().toString());
            row.createCell(19).setCellValue(layup.getPcomp());
            row.createCell(20).setCellValue(layup.getRemark());
            row.createCell(21).setCellValue(layup.getAircraft());
        }
        return wb;
    }
}
