package com.aaron.file.controller;

import com.aaron.file.util.Base64DecodedMultipartFile;
import com.aaron.file.util.Base64StrToImage;
import com.aaron.file.util.FileUploading;
import com.aaron.file.util.result.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class FIleUpload {

    @PostMapping("/fileUploading")
    public AjaxResult uploadImg(@RequestParam(required = false, value = "fileStr") String fileStr, HttpServletRequest request)  {

        Base64DecodedMultipartFile base64DecodedMultipartFile = null;
        if (null != fileStr && !fileStr.isEmpty()) {
            base64DecodedMultipartFile = (Base64DecodedMultipartFile) Base64StrToImage.base64MutipartFile(fileStr);
            List<String> stringList = null;
            if (null != base64DecodedMultipartFile && !base64DecodedMultipartFile.equals("")) {
                FileUploading fileUploading = new FileUploading();
                try {
                    stringList = fileUploading.phtoUpload(base64DecodedMultipartFile, request);
                } catch (IOException e) {
                    e.printStackTrace();
                    return AjaxResult.error("信息异常"+e, 1);
                }
            }
            return AjaxResult.successState("上传成功", 0, stringList);
        } else {
            return AjaxResult.error("信息异常", 1);
        }
    }
}
