package com.whq;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.bean.sUser;
import com.dao.UserMapper;
import com.service.SetUpConn;
import com.yzm.bag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("index")
public class index {

    SetUpConn setUpConn = null;
    public UserMapper reUserMapper(){
        setUpConn = new SetUpConn();
        //setUpConn.returnUserMapper()方法返回的是UserMapper接口的对象
        UserMapper userMapper = setUpConn.returnUserMapper();
        return userMapper;
    }

    @RequestMapping("insertUser")
    public String insertUser(sUser user){
        int s = reUserMapper().insertUser(user);
        return "redirect:/index.jsp";
    }
    @RequestMapping("yzm_if")
    public Map<String, Object> yzm_if(HttpServletResponse response, HttpServletRequest request, Model model){
        response.setDateHeader("Expires", 0);// 禁止server端缓存
        Map<String, Object> map = new HashMap<String, Object>();
        bag bag = new bag();
        BufferedImage buffImg =
                new BufferedImage(bag.getImgWidth(), bag.getImgHeight(), BufferedImage.TYPE_INT_RGB);
        BufferedOutputStream out = null;
        Graphics gd;
        gd = bag.initGraphics(buffImg);
        bag.drawDisturbLines(gd);
        String code = String.valueOf(bag.drawString(gd));
        map.put("yzm",code);
        model.addAttribute("yzmNumber",code);
        System.out.println("code="+code);
        model.addAttribute("yzmUrl","img/yzm.png");
        bag.saveImg(buffImg, out);
        return map;
    }
    /**
     * 使用HuTool工具类生成验证码
     *
     * @param response 响应
     * @throws IOException io
     */
    @RequestMapping("getCode")
    public void getCode(HttpServletResponse response, HttpSession session)
            throws IOException {
        //定义图形验证码的长和宽CaptchaUtil
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(116, 36, 4, 5);
        session.setAttribute("code", lineCaptcha.getCode());
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(lineCaptcha.getImage(), "JPEG", outputStream);
    }
}
