package ustc.gr.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Black on 2017/4/2.
 */
@Controller
public class FileUploadController {

    @RequestMapping(value="/uploadForm")
    public String loginForm(
            HttpServletRequest request,
            Model model) {

//        String path = request.getServletContext().getRealPath("/images/");
//        File file = new File(path);
//        File[] fileList = file.listFiles();
//        List<String> files = new ArrayList<>();
//        System.out.println("该目录下对象个数：" + fileList.length);
//        for (int i = 0; i < fileList.length; i++) {
//            if (fileList[i].isFile()) {
//                System.out.println("文     件：" + fileList[i].getName());
//                files.add(fileList[i].getName());
//            }
//        }
//        model.addAttribute("files",files);
        return "uploadForm";
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(
            HttpServletRequest request,
            @RequestParam("description") String description,
            @RequestParam("file") MultipartFile file,
            Model model
    ) throws IOException {
        System.out.println("文件描述："+description);
        //文件不为空，写上上传路径
        if(!file.isEmpty()){
            //上传路径
            String path = request.getServletContext().getRealPath("/images/");
            System.out.println("images路径："+path);
            //上传文件名
            // getOriginalFilename获取上传文件的原名
            String fileName = file.getOriginalFilename();
            File filepath = new File(path,fileName);
            //判断路径是否存在，不存在就创建
            if(!filepath.getParentFile().exists()){
                filepath.getParentFile().mkdir();
            }
            //将上传文件保存在一个目标文件当中
            file.transferTo(new File(path+File.separator+fileName));

            File file2 = new File(path);
            File[] fileList = file2.listFiles();
            List<String> files = new ArrayList<>();
            System.out.println("该目录下对象个数：" + fileList.length);
            for (int i = 0; i < fileList.length; i++) {
                if (fileList[i].isFile()) {
                    System.out.println("文     件：" + fileList[i].getName());
                    files.add(fileList[i].getName());
                }
            }
            model.addAttribute("files",files);

            return "uploadForm";
        }
        return "error";
    }


    @RequestMapping(value = "/download")
    public ResponseEntity<byte[]> download(
            HttpServletRequest request,
            @RequestParam("fileName") String fileName,
            Model model)throws IOException{
        //下载文件路径
        String path = request.getServletContext().getRealPath("/images/");
        File file = new File(path+File.separator+fileName);
        HttpHeaders headers = new HttpHeaders();
        //下载显示的文件名，解决中文乱码问题
        String downloadFileName = new String(fileName.getBytes("UTF-8"),"iso-8859-1");
        //通知浏览器以attachment(下载方式)打开文件
        headers.setContentDispositionFormData("attachment",downloadFileName);
        //application/octet-stream:二进制流数据（最常见的文件下载）
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //201 HttpStatus.CREATED
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);
    }
}
