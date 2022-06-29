package com.example.house.controller;

import com.example.house.common.BaseResult;
import com.example.house.common.QiniuCloudUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;


@RestController
@RequestMapping("/qiniu")
public class QiniuUploadTest {

    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public BaseResult uploadImg(@RequestParam MultipartFile image, HttpServletRequest request) {
        if (image.isEmpty()) {
            return BaseResult.fail(400, "上传文件不能为空");
        }

        try {
            byte[] bytes = image.getBytes();
            //文件名
            //String fileName = FileName.getFileName(image);
            String fileName  = UUID.randomUUID().toString().replace("-", "").toLowerCase();
            //上传工具类
            QiniuCloudUtil qiniuUtil = new QiniuCloudUtil();
            try {
                //使用base64方式上传到七牛云
                String url = qiniuUtil.put64image(bytes, fileName);
                return BaseResult.fail(200, "文件上传成功", url);
            } catch (Exception e) {
                e.printStackTrace();
                return BaseResult.fail(500, "文件上传发生异常");
            }
        } catch (IOException e) {
            return BaseResult.fail(500, "文件上传发生异常");
        }
    }
}
