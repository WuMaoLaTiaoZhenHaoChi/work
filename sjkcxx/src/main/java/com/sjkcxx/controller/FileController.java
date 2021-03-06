package com.sjkcxx.controller;

import com.sjkcxx.base.ResultVo;
import com.sjkcxx.entity.StudentSubject;
import com.sjkcxx.entity.UserExcelInfo;
import com.sjkcxx.service.StudentSubjectService;
import com.sjkcxx.service.UserService;
import com.sjkcxx.util.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.velocity.shaded.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * @Author: ddtt
 * @Date: 2020/04/24 14:25
 * @Description:文件上传
 */
@Slf4j
@RestController
@RequestMapping("file")
public class FileController {

    @Autowired
    private StudentSubjectService studentSubjectService;

    @Autowired
    private UserService userService;
    /**
     * 处理Excel解析的方法
     *
     * @param file 前台上传的文件对象
     * @return
     */
    @PostMapping(value = "/user/upload")
    public ResultVo Excel(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
        String filename = "user";
        String ext = FilenameUtils.getExtension(file.getOriginalFilename());
        String filenames = filename + "." + ext;

        String path = System.getProperty("user.dir");
        String pathname = path + "/doc/" + filenames;//被下载的文件在服务器中的路径,
//        String pathname = "/home/dtt/doc/" + filenames; //linux
//        String pathname = "../doc/" + filenames; //linux

        int count = 0;      //上传文件数
        log.info("被上传的文件路径 : " + pathname);
        try {
            File files = new File(pathname);
            file.transferTo(files);
            List<UserExcelInfo> list = FileUtils.readExcel(files);
            for (UserExcelInfo userExcelInfo : list){
                count += userService.addExcelUser(userExcelInfo);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ResultVo.build("500",e.getMessage());
        }
        return ResultVo.build("200","批量添加用户成功",count);
    }

    //下载模板
    @GetMapping("/user/template")
    public ResultVo userDownload (HttpServletResponse response) {
        response.setContentType("application/binary;charset=UTF-8");
        String filenames = "user_template.xlsx";
        //windows
        String path = System.getProperty("user.dir");
        String downloadFilePath = path + "/doc/" + filenames;//被下载的文件在服务器中的路径,
        //linux
//        String downloadFilePath = "/home/dtt/doc/" + filenames;//被下载的文件在服务器中的路径,linux
        String fileName = filenames;//被下载文件的名称
        log.info("被下载的文件在路径 : " + downloadFilePath);
        File file = new File(downloadFilePath);
        if (file.exists()) {
            FileUtils.download(downloadFilePath, response);
            return null;
        }
        return ResultVo.build("405", "下载失败");


    }

    //下载
    @GetMapping("/download")
    public ResultVo studentDownload(StudentSubject studentSubject, HttpServletResponse response) {
        response.setContentType("application/binary;charset=UTF-8");
        String filenames = studentSubject.getSubjectWork();
        String path = System.getProperty("user.dir");
//        String downloadFilePath = path + "/doc/" + filenames;//被下载的文件在服务器中的路径,
        String downloadFilePath = "/home/dtt/doc/" + filenames;//被下载的文件在服务器中的路径,linux
        String fileName = filenames;//被下载文件的名称
        log.info("被下载的文件在路径 : " + downloadFilePath);
        File file = new File(downloadFilePath);
        if (file.exists()) {
            FileUtils.download(downloadFilePath, response);
            return null;
        }
        return ResultVo.build("405", "下载失败");


    }


    //上传
    @PostMapping("/student/upload")
    public ResultVo studentUpload(@RequestParam(value = "file") MultipartFile file, StudentSubject studentSubject) {
        String filename = studentSubject.getStudentSubjectNum();
        String ext = FilenameUtils.getExtension(file.getOriginalFilename());
        String filenames = filename + "." + ext;

        studentSubject.setSubjectWork(filenames);
        int i = studentSubjectService.studentUpload(studentSubject);
        if (i <= 0) {
            return ResultVo.build("400", "上传失败");
        }
        //        String path = System.getProperty("user.dir");
        String pathname = "/home/dtt/doc/" + filenames; //linux

        log.info("被上传的文件路径 : " + pathname);
        try {
            File files = new File(pathname);
            file.transferTo(files);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResultVo.success();
    }

    /*//下载
    @GetMapping("/download")
    public ResultVo studentDownload(StudentSubject studentSubject, HttpServletResponse response) {
        response.setContentType("application/binary;charset=UTF-8");
        String filenames = studentSubject.getSubjectWork();
        String path = System.getProperty("user.dir");
        String downloadFilePath = path + "/doc/" + filenames;//被下载的文件在服务器中的路径,
        String fileName = filenames;//被下载文件的名称

        File file = new File(downloadFilePath);
        if (file.exists()) {
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream outputStream = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    outputStream.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return ResultVo.build("405","下载失败");


    }*/


}
