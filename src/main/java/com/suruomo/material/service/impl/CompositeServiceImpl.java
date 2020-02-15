package com.suruomo.material.service.impl;

import com.suruomo.material.dao.CompositeInputMapper;
import com.suruomo.material.dao.CompositeOutMapper;
import com.suruomo.material.pojo.CompositeInput;
import com.suruomo.material.service.CompositeService;
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

/**
 * @author 苏若墨
 */
@Service
public class CompositeServiceImpl implements CompositeService {

    @Resource
    private CompositeInputMapper compositeInputMapper;
    @Resource
    private CompositeOutMapper compositeOutMapper;
    /**
     * 批量导入原始复合
     *
     * @param file
     * @param fileName
     */
    @Override
    public void uploadOriginal(MultipartFile file, String fileName) throws IOException {
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
        //获取数据库当前最大id编号
        int id = compositeInputMapper.getMaxId();
        System.out.println("当前最大编号：" + id);
        //获取总列数
        int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
        //按行插入数据
        for (int r = 1; r <= sheet.getLastRowNum(); r++) {
            Row row = sheet.getRow(r);
            id++;
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
            String parameter = row.getCell(1).toString();
            String condition = row.getCell(2).toString();
            BigDecimal value = new BigDecimal(row.getCell(3).toString());

            //赋值
            CompositeInput compositeInput = new CompositeInput();
            compositeInput.setName(name);
            compositeInput.setParameter(parameter);
            compositeInput.setCondition(condition);
            compositeInput.setValue(value);
            compositeInput.setId(new BigDecimal(id));
            System.out.println("下一个id:" + id);
            //插入数据
            compositeInputMapper.insert(compositeInput);
        }
    }
}
