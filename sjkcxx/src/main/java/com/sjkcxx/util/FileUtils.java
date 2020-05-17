package com.sjkcxx.util;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.sjkcxx.entity.UserExcelInfo;
import com.sjkcxx.entity.UserInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

/**
 * @Author: duant
 * @Date: 2020/4/24 21:31
 * @Description:
 */
public class FileUtils {

    private static final String ENCODING = "UTF-8";
    private static final String CONTENT_DISPOSITION = "Content-Disposition";
    private static final String ATTACHMENT = "attachment;filename=";
    private static final String CONTENT_TYPE = "application/octet-stream;charset=UTF-8";
    private static final String CACHE_CONTROL = "Cache-Control";
    private static final String NO_CACHE = "no-cache";
    private static final String PRAGMA = "Pragma";
    private static final String EXPIRES = "Expires";
    private static final String APPLICATION_X_MSDOWNLOAD = "application/x-msdownload";

    public static void download(String path, HttpServletResponse response) {
        OutputStream fos = null;
        FileInputStream fis = null;
        try {
            File file = new File(path);
            response.setHeader(PRAGMA, NO_CACHE);
            response.setHeader(CACHE_CONTROL, NO_CACHE);
            response.setCharacterEncoding(ENCODING);
            response.setHeader(CONTENT_DISPOSITION, ATTACHMENT + URLEncoder.encode(file.getName(), ENCODING));
            response.setContentType(CONTENT_TYPE);
            response.setDateHeader(EXPIRES, 0);
            fos = response.getOutputStream();
            if (file.exists()) {
                fis = new FileInputStream(file);
                FileCopyUtils.copy(fis, fos);
            }
            fos.flush();
            fis.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (Exception e) {
                e.getMessage();
            }

        }
    }


    //读取excel内容
    public static List readExcel(File file){
        ImportParams params = new ImportParams();
        params.setStartSheetIndex(0);   //sheet页开始
        params.setHeadRows(1);          //表头

        List<UserExcelInfo> list = ExcelImportUtil.importExcel(
                file,
                UserExcelInfo.class, params);
        System.out.println(list.size());
        return list;
    }


}
