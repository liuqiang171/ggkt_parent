package com.at.ggkt.vod.controller;

import com.at.ggkt.result.Result;
import com.at.ggkt.vod.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName FileUploadController
 * @Description TODO
 * @Author liuqiang
 * @Date 2022-07-19-16:32
 */
@Api(tags = "文件上传接口")
@RestController
@CrossOrigin
@RequestMapping("/admin/vod/file")
public class FileUploadController {
    @Autowired
    private FileService fileService;

    @ApiOperation("文件上传")
    @PostMapping("upload")
    public Result uploadFile(MultipartFile file){
        String url = fileService.upload(file);
        return Result.ok(url).message("上传文件成功");
    }
}
