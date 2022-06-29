package com.example.house;


import com.example.house.common.FileUtil;
import com.example.house.common.QiniuCloudUtil;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import jdk.nashorn.internal.runtime.regexp.joni.Region;
import org.junit.jupiter.api.Test;

import javax.security.auth.login.Configuration;

import java.io.File;
import java.io.IOException;

public class QiniuTest {
    
    @Test
    public void file64() throws IOException{
        String filePath = "C:\\Users\\96560\\Desktop\\test\\Dingtalk_20220526220225.jpg";
        byte[] bytes = FileUtil.getBytesByFile(filePath);
        System.out.println(bytes);
    }
    
    
    @Test
    public void upload() throws IOException {
        QiniuCloudUtil qiniuCloudUtil = new QiniuCloudUtil();
//        File file = new File("D:\\工作\\20200818\\TEST.png");
        String filePath = "C:\\Users\\96560\\Desktop\\test\\Dingtalk_20220526220225.jpg";
        String fileName = "test";
        byte[] bytes = FileUtil.getBytesByFile(filePath);
        try {
            String s = qiniuCloudUtil.put64image(bytes,"123");
            System.out.println(s);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
