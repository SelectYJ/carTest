package com.whq;

import com.bean.sCar;
import com.bean.sUser;
import com.dao.UserMapper;
import com.service.SetUpConn;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("html")
public class SysController {
    private String usName=null;//记录登录的用户的用户名
    private String usId=null;//记录登录的用户的ID
    private String usImg=null;//记录登录的用户的头像
    // 加载mybatis-config.xml配置文件
    SetUpConn setUpConn = null;


    /**
     * 登录的后台操作页面
     * @param username 用户名
     * @param password 密码
     * @param model 用于存储数据，方便页面跳转后获取
     * @return  main.jsp视图，同过hello.loginTr()的返回值
     * @throws IOException
     */
    @RequestMapping(value = "hello")
    public String serT1(
            @RequestParam(value = "username",required = false) String username,
            @RequestParam(value = "password",required = false) String password,
            Model model
    ) {//返回main.jsp视图
        if(username!=null){
            usName = username;
            model.addAttribute("msg",usName);
            SetUpConn setUpConn = new SetUpConn();
            UserMapper userMapper = setUpConn.returnUserMapper();
            Map<String, Object> data = new HashMap();
            List<sUser> roleList = userMapper.getPassAndId(username);
            if(roleList.size()!=0){
                usId=roleList.get(0).getUs_id();
                usName = roleList.get(0).getUs_username();
                usImg = roleList.get(0).getUs_img();
                model.addAttribute("msg1",usId);
                model.addAttribute("msg2",usImg);
                data.put("userPass",roleList.get(0).getUs_pass());
                setUpConn.commitCloseSqlSession();
                setUpConn.inputStreamSqlSession();
                if(!data.isEmpty() && password.equals(data.get("userPass"))){
                    return "main";
                }else {
                    return "error";
                }
            }else {
                return "error";
            }
        }else {
//            System.out.println("类SysController-48-usName="+usName);
            model.addAttribute("msg1",usId);
            model.addAttribute("msg2",usImg);
            model.addAttribute("msg",usName);
            return "main";
        }
    }

    /**
     * 用户管理页面
     * @return 返回【用户管理（index1.jsp）】视图
     */
    @RequestMapping("index1")
    public String toIndex1(){
        return "index1";
    }

    /**
     * 用于返回UserMapper对象
     * @return
     */
    public UserMapper reUserMapper(){
        setUpConn = new SetUpConn();
        //setUpConn.returnUserMapper()方法返回的是UserMapper接口的对象
        UserMapper userMapper = setUpConn.returnUserMapper();
        return userMapper;
    }

    /**
     * 返回给用户管理页面的数据
     * @return 返回从数据库查询到的某一个用户的个人信息
     */
    @RequestMapping("reToIndex1")
    @ResponseBody
    public Map<String,Object> reToIndex1(){
        Map<String, Object> data = new HashMap();
        List<sUser> roleList = reUserMapper().getsUser(usId);
        for (sUser s : roleList) {
            data.put("userId",s.getUs_id());
            data.put("userName",s.getUs_username());
            data.put("userPass",s.getUs_pass());
            data.put("userEmail",s.getUs_email());
            data.put("userPhoto",s.getUs_photo());
        }
        setUpConn.commitCloseSqlSession();
        setUpConn.inputStreamSqlSession();
        return data;
    }

    /**
     * 修改
     * @param user
     * @param model
     * @return
     */
    @RequestMapping("upDataIndex1")
    public String upDataIndex1(sUser user,Model model) {
        System.out.println(user);
        int s = reUserMapper().upDataUser(user);
        if(s==1){
            System.out.println("msg="+user.getUs_username()+"msg1="+user.getUs_id()+"msg2="+usImg);
            model.addAttribute("msg",user.getUs_username());
            model.addAttribute("msg1",user.getUs_id());
            model.addAttribute("msg2",usImg);
        }
        return "main";
    }

    /**
     * 车辆管理页面
     * @return
     */
    @RequestMapping("index2")
    public String toIndex2() {
        return "index2";
    }

    /**
     * 返回给车辆管理页面的数据
     * @return 返回从数据库查询到的某一个车辆的信息
     */
    @RequestMapping("reToIndex2")
    @ResponseBody
    public List<Map<String, Object>> reToIndex2() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        List<sCar> roleList = reUserMapper().getsCar();
        for (sCar c : roleList) {
            Map<String, Object> data = new HashMap();
            data.put("carId",c.getCar_id());
            data.put("carName",c.getCar_name());
            data.put("carPrice",c.getCar_price());
            data.put("carQuantity",c.getCar_quantity());
            data.put("carProductionTime",c.getCar_production_time());
            data.put("carImg",c.getCar_img());
            list.add(data);
        }
//        System.out.println(list.size());
//        for(Map<String,Object> m:list){    //取list集合里的那一条Map集合
//            for(String s:m.keySet()){    //取map集合里的String类型的key，
//                System.out.println(m.get(s));//根据key迭代输出value
//            }
//        }
        setUpConn.commitCloseSqlSession();
        setUpConn.inputStreamSqlSession();
        return list;
    }

    /**
     * 商品页面
     * @return 返回商品视图页面
     */
    @RequestMapping("index3")
    public String toIndex3() {
        return "GoShopping";
    }

    /**
     * 查询的后台方法
     * @param action 查询的名字
     * @return 查询的结果
     */
    @RequestMapping(value = "selectCar")
    @ResponseBody
    public List<Map<String, Object>> reSelectCar(String action){
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        List<sCar> roleList = reUserMapper().reSelectCar(action);
        for (sCar c : roleList) {
            Map<String, Object> data = new HashMap();
            data.put("carName",c.getCar_name());
            data.put("carPrice",c.getCar_price());
            data.put("carQuantity",c.getCar_quantity());
            data.put("carImg",c.getCar_img());
            list.add(data);
        }
        setUpConn.commitCloseSqlSession();
        setUpConn.inputStreamSqlSession();
        return list;
    }

    @RequestMapping("deleteUser")
    public String deleteUser(){
        int bool = reUserMapper().deleteUser(usName);
        System.out.println("bool="+bool);
        return "redirect:/index.jsp";
    }


    @RequestMapping("index4")
    public String toIndex4() {
        return "index4";
    }@RequestMapping("index5")
    public String toIndex5() {
        return "index5";
    }@RequestMapping("index6")
    public String toIndex6() {
        return "index6";
    }

}
