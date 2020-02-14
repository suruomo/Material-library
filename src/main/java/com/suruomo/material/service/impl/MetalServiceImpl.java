package com.suruomo.material.service.impl;

import com.suruomo.material.dao.MetalInputMapper;
import com.suruomo.material.pojo.MetalInput;
import com.suruomo.material.service.MetalService;
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
import java.util.List;

@Service
public class MetalServiceImpl implements MetalService {
   @Resource
  private MetalInputMapper metalInputMapper;

    /**
     * 批量导入金属原始数据
     * @param file
     * @param fileName
     * @throws IOException
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
        int id= metalInputMapper.getMaxId().intValue();
        System.out.println("当前最大编号："+id);
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
                if(row.getCell(j) == null){
                    row.getCell(j);
                    //如果读取到额cell不为null 则直接加入	listRow集合
                }else{
                    cell = row.getCell(j).toString();
                    row.getCell(j);
                }
                // 在第i列 依次获取第i列的第j个位置上的值 %15s表示前后间隔15个字节输出
                System.out.printf("%15s", cell);
            }
            System.out.println();
            //从excel第二行开始获取每个单元格的数据

            String typeName= row.getCell(0).toString();
            String name = row.getCell(1).toString();
            String family = row.getCell(2).toString();
            String specification = row.getCell(3).toString();
            String form= row.getCell(4).toString();
            String temper = row.getCell(5).toString();
            BigDecimal thMin = new BigDecimal(row.getCell(6).toString());
            BigDecimal thMax =new BigDecimal(row.getCell(7).toString()) ;
            String basis = row.getCell(8).toString();
            String direction= row.getCell(9).toString();
            BigDecimal e=row.getCell(10).toString()==null?null: new BigDecimal(row.getCell(10).toString());
            BigDecimal eSec=row.getCell(11)==null?null: new BigDecimal(row.getCell(11).toString());
            BigDecimal eC =row.getCell(12)==null?null: new BigDecimal(row.getCell(12).toString());
            BigDecimal eCSec = row.getCell(13)==null?null: new BigDecimal(row.getCell(13).toString());
            BigDecimal fBru15 =row.getCell(14)==null?null: new BigDecimal(row.getCell(14).toString());
            BigDecimal fBru20 =row.getCell(15)==null?null: new BigDecimal(row.getCell(15).toString());
            BigDecimal fBry15 =row.getCell(16)==null?null: new BigDecimal(row.getCell(16).toString());
            BigDecimal fBry20 =row.getCell(17)==null?null: new BigDecimal(row.getCell(17).toString());
            BigDecimal fCy =row.getCell(18)==null?null: new BigDecimal(row.getCell(18).toString());
            BigDecimal fSu =row.getCell(19)==null?null: new BigDecimal(row.getCell(19).toString());
            BigDecimal fTu = row.getCell(20)==null?null: new BigDecimal(row.getCell(20).toString());
            BigDecimal fTy =row.getCell(21)==null?null: new BigDecimal(row.getCell(21).toString());
            BigDecimal g = row.getCell(22)==null?null: new BigDecimal(row.getCell(22).toString());
            BigDecimal nu = row.getCell(23)==null?null: new BigDecimal(row.getCell(23).toString());
            //赋值
            MetalInput metalInput=new MetalInput();
            metalInput.setTypeName(typeName);
            metalInput.setName(name);
            metalInput.setFamily(family);
            metalInput.setSpecification(specification);
            metalInput.setForm(form);
            metalInput.setTemper(temper);
            metalInput.setThMin(thMin);
            metalInput.setThMax(thMax);
            metalInput.setBasis(basis);
            metalInput.setDirection(direction);
            metalInput.setE(e);
            metalInput.seteSec(eSec);
            metalInput.seteC(eC);
            metalInput.seteCSec(eCSec);
            metalInput.setfBru15(fBru15);
            metalInput.setfBru20(fBru20);
            metalInput.setfBry15(fBry15);
            metalInput.setfBry20(fBry20);
            metalInput.setfCy(fCy);
            metalInput.setfSu(fSu);
            metalInput.setfTu(fTu);
            metalInput.setfTy(fTy);
            metalInput.setId(new BigDecimal(id));
            metalInput.setG(g);
            metalInput.setNu(nu);
            System.out.println("下一个id:"+id);
            //插入数据
            metalInputMapper.insert(metalInput);
        }
    }

    /**
     * 获取原始金属数据
     * @return
     */
    @Override
    public List<MetalInput> getAll() {
        return metalInputMapper.getList();
    }


}
