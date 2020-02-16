package com.suruomo.material.service.impl;


import com.suruomo.material.dao.LayupMapper;
import com.suruomo.material.pojo.Layup;
import com.suruomo.material.service.LayupService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

@Service
public class LayupServiceImpl implements LayupService {
    @Resource
    private LayupMapper layupMapper;
    /**
     * 批量导入铺层
     * @param file
     * @param fileName
     */
    @Override
    public void upload(MultipartFile file, String fileName) throws IOException {
        boolean isExcel2003 = true;
        int str = 0;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = file.getInputStream();
        Workbook wb = null;
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);
        }
        Sheet sheet = wb.getSheetAt(0);
        if (sheet != null) {
            //文件上传成功
            str = 1;
        } else {
            //上传失败sheet为空
            str = 0;
        }
        System.out.println(sheet.getLastRowNum());
        //获取总列数
        int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
        //按行插入数据
        for (int r = 1; r <= sheet.getLastRowNum(); r++) {
            Row row = sheet.getRow(r);
            if (row == null) {
                continue;
            }
            for (int j = 0; j < columnCount; j++) {
                //下列步骤为判断cell读取到的数据是否为null 如果不做处理 程序会报错
                String cell = null;
                //如果未null则加上""组装成非null的字符串
                if (row.getCell(j) == null) {
                    row.getCell(j);
                    //如果读取到额cell不为null 则直接加入	listRow集合
                } else {
                    cell = row.getCell(j).toString();
                    row.getCell(j);
                }
                // 在第i列 依次获取第i列的第j个位置上的值 %15s表示前后间隔15个字节输出
                System.out.printf("%15s", cell);
            }
            System.out.println();
            //从excel第二行开始获取每个单元格的数据

            String name = row.getCell(0).toString();
            String matId = row.getCell(1).toString();
            String ply = row.getCell(2).toString();
            String symmetry = row.getCell(3).toString();
            String balance = row.getCell(4).toString();
            BigDecimal t = new BigDecimal(row.getCell(5).toString());
            BigDecimal  Exx= new BigDecimal(row.getCell(6).toString());
            BigDecimal Eyy = new BigDecimal(row.getCell(7).toString());
            BigDecimal Gxy = new BigDecimal(row.getCell(8).toString());
            BigDecimal NUXY = new BigDecimal(row.getCell(9).toString());
            BigDecimal NUYX = new BigDecimal(row.getCell(10).toString());
            BigDecimal A11 = new BigDecimal(row.getCell(11).toString());
            BigDecimal A22= new BigDecimal(row.getCell(12).toString());
            BigDecimal A12= new BigDecimal(row.getCell(13).toString());
            BigDecimal A66= new BigDecimal(row.getCell(14).toString());
            BigDecimal D11= new BigDecimal(row.getCell(15).toString());
            BigDecimal D22= new BigDecimal(row.getCell(16).toString());
            BigDecimal D12= new BigDecimal(row.getCell(17).toString());
            BigDecimal D66= new BigDecimal(row.getCell(18).toString());
            String pcomp = row.getCell(19).toString();
            String aircraft = row.getCell(20).toString();
            String remark = row.getCell(21).toString();

            //赋值
            Layup layup = new Layup();
            layup.setName(name);
            layup.setMid(matId);
            layup.setT(t);
            layup.setSymmetry(symmetry);
            layup.setBalance(balance);
            layup.setPly(ply);
            layup.setExx(Exx);
            layup.setEyy(Eyy);
            layup.setGxy(Gxy);
            layup.setNuxy(NUXY);
            layup.setNuyx(NUYX);
            layup.setA11(A11);
            layup.setA22(A22);
            layup.setA12(A12);
            layup.setA66(A66);
            layup.setD11(D11);
            layup.setD22(D22);
            layup.setD12(D12);
            layup.setD66(D66);
            layup.setPcomp(pcomp);
            layup.setRemark(remark);
            layup.setAircraft(aircraft);
            //插入数据
            layupMapper.insert(layup);
        }
    }
}
