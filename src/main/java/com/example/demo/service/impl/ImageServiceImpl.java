package com.example.demo.service.impl;

import com.example.demo.bean.Image;
import com.example.demo.mapper.ImageMapper;
import com.example.demo.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


@Service
public class ImageServiceImpl implements ImageService {


    @Value("${pic-path}")
    private String save_path;

    @Autowired
    ImageMapper imageMapper;

    @Override
    public String uploadImg(MultipartFile file) throws IOException {

        String path = null;// 文件路径
        double fileSize = file.getSize();
        System.out.println("文件的大小是" + fileSize);

        byte[] sizebyte = new byte[0];
        try {
            sizebyte = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("文件的byte大小是" + sizebyte.toString());


        if (file != null) {// 判断上传的文件是否为空
            String type = null;// 文件类型
            String fileName = file.getOriginalFilename();// 文件原名称
            String newName= UUID.randomUUID().toString();
            System.out.println("上传的文件原名称:" + fileName);
            // 判断文件类型
            type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
            if (type != null) {// 判断文件类型是否为空

                if ("GIF".equals(type.toUpperCase()) || "PNG".equals(type.toUpperCase()) || "JPG".equals(type.toUpperCase())) {

                    // 项目在容器中实际发布运行的根路径
                    //String realPath = request.getSession().getServletContext().getRealPath("/");
                    // 自定义的文件名称
                    //String trueFileName = String.valueOf(System.currentTimeMillis()) + "." + type;
                    // 设置存放图片文件的路径

                    path = save_path + newName+"."+type;
                    newName = newName+"."+type;
                    System.out.println("存放图片文件的路径:" + path);

                    // 转存文件到指定的路径
                    file.transferTo(new File(path));
                    Image image = new Image();
                    image.setHostname("http://118.25.182.23:8051/img/");
                    image.setUrl(newName);
                    image.setNewname(newName);
                    image.setOriginalname(fileName);
                    System.out.println(image);

                    int a = imageMapper.savaImage(image);
                    System.out.println(a);
                    return image.getHostname()+image.getNewname();

                }

            } else {
                System.out.println("不是我们想要的文件类型,请按要求重新上传");
                return "不是我们想要的文件类型,请按要求重新上传";
            }
        } else {
            System.out.println("文件类型为空");
            return "文件类型为空";
        }

        return "后台代码error";
    }

}
