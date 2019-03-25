package me.test.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import me.test.entity.Car;
import me.test.utils.FileUtil;

@Controller
public class DemoController {
	@RequestMapping("/")
	@ResponseBody
	public String hello() {
		return "hello,li";
	}

	@RequestMapping("/car")
	@ResponseBody
	public Car jsonTest() {
		Car car = new Car();
		car.setColor("red");
		car.setPrice(100000);
		return car;
	}
	
	@RequestMapping("/user")
	public String pageTest() {
		return "users";
	}
	
	@RequestMapping("/param")
	@ResponseBody
	public void transferparam(HttpServletRequest request,HttpServletResponse response) {
		String param1=request.getParameter("p1");
		System.out.println(param1);
		try {
			response.getWriter().write("aaa");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/upload", method = RequestMethod.POST)
    public @ResponseBody String uploadImg(@RequestParam("img") MultipartFile file,
                                          HttpServletRequest request) {
     
        String contentType = file.getContentType();   //图片文件类型
        String fileName = file.getOriginalFilename();  //图片名字

        //文件存放路径
        String filePath = "d:/lpfile/test/";
        
        //调用文件处理类FileUtil，处理文件，将文件写入指定位置
       try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            // TODO: handle exception
        }

       // 返回图片的存放路径
        return filePath;
    }



}
