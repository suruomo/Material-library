package com.suruomo.material;


import com.suruomo.material.service.DisplacementService;
import com.suruomo.material.utils.GetStaticResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class MaterialApplicationTests {
    @Autowired
    DisplacementService displacementService;
    @Test
    void main(){
        String path = "G:\\heminmin\\patran\\0621\\lin-static\\export-static-result-30-Jun-21-14-11-20.txt";
        GetStaticResult getStaticResult=new GetStaticResult(displacementService);
        GetStaticResult.readDisplacementResultFile(path);
    }

}
