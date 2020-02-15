package com.suruomo.material.utils;

import com.suruomo.material.pojo.MetalInput;
import com.suruomo.material.pojo.MetalOut;
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
}
