package com.suruomo.material;


import com.suruomo.material.dao.ModeMaxDisplacementsMapper;
import com.suruomo.material.pojo.ModeMaxDisplacements;
import com.suruomo.material.service.GetModeService;
import com.suruomo.material.service.GetStaticService;
import com.suruomo.material.utils.GetModeResult;
import com.suruomo.material.utils.GetStaticResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;


@SpringBootTest
class MaterialApplicationTests {
    @Autowired
    GetModeService getModeService;
    @Autowired
    GetStaticService getStaticService;
    @Autowired
    ModeMaxDisplacementsMapper displacementsMapper;

    String path = "G:\\heminmin\\patran\\0705\\mode_wing\\export-mode-result-06-Jul-21-16-08-07.txt";
//    @Test
//    void main(){
//
//        GetModeResult getModeResult=new GetModeResult(getModeService);
//        GetModeResult.readFrequencyFile(path,new BigDecimal(8));
////        getModeService.getModeResult(new BigDecimal(8),path);
//    }
//
//    @Test
//    void insert(){
//        GetModeResult getModeResult=new GetModeResult(getModeService);
//        GetModeResult.readDisplacementsFile(path,new BigDecimal(8));
//    }

    @Test
    void delete() throws IOException {
//        getStaticService.deleteAnalysisTask("5");
        getModeService.deleteAnalysisTask("2");
    }

}
