package com.sjkcxx.controller;

import com.sjkcxx.base.ResultVo;
import com.sjkcxx.entity.StudentSubject;
import com.sjkcxx.service.StudentSubjectService;
import org.apache.velocity.shaded.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: ddtt
 * @Date: 2020/04/24 14:25
 * @Description:文件上传
 */
@RestController
@RequestMapping("file")
public class FileController {

    @Autowired
    private StudentSubjectService studentSubjectService;

    //输出
    @GetMapping(value="/download")
    public String test(StudentSubject studentSubject, HttpServletResponse response) {
        response.setContentType("application/binary;charset=UTF-8");
        String filenames = studentSubject.getStudentSubjectNum();
        Map<String,Object> map = new HashMap<String, Object>();
        String path = System.getProperty("user.dir");
        String pathname = path + "\\sjkcxx\\doc\\" + filenames;
        try {
            ServletOutputStream out = response.getOutputStream();
            //设置文件头：最后一个参数是设置下载文件名
            response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode( pathname, "UTF-8"));
            out.close();
            return "success";
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "error";
        }

    }

    //上传
    @PostMapping("/student/upload")
    public ResultVo studentUploadWord(@RequestParam(value = "file") MultipartFile file, StudentSubject studentSubject) {
        String filename = studentSubject.getStudentSubjectNum();
        String ext = FilenameUtils.getExtension(file.getOriginalFilename());
        String filenames = filename + "." + ext;

        int i = studentSubjectService.studentUpload(studentSubject);
        if (i <= 0){
            return ResultVo.build("400","上传失败");
        }
        String path = System.getProperty("user.dir");
        String pathname = path + "\\sjkcxx\\doc\\" + filenames;
        try {
            File files=new File(pathname);
            file.transferTo(files);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResultVo.success();
    }

}
