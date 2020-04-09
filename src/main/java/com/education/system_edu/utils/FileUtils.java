package com.education.system_edu.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @Description: TODO
 * @author: skyrimal
 * @date: 2020年04月07日 21:21
 */
public class FileUtils {
    public static void approvalFile( MultipartFile filecontent,String fileName){
        OutputStream os = null;
        InputStream inputStream = null;
        try {
            inputStream = filecontent.getInputStream();
            fileName =fileName+"."+filecontent.getOriginalFilename().split("\\.")[1];
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String path = "D:\\file\\";
            // 2、保存到临时文件
            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流保存到本地文件
            File tempFile = new File(path);
            if (!tempFile.exists()) {
                tempFile.mkdirs();
            }
            os = new FileOutputStream(tempFile.getPath() + File.separator + fileName);
            // 开始读取
            while ((len = inputStream.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 完毕，关闭所有链接
            try {
                os.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
