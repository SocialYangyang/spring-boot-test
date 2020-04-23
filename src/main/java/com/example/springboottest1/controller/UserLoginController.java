package com.example.springboottest1.controller;

import com.example.springboottest1.entity.Professional;
import com.example.springboottest1.entity.User;
import com.example.springboottest1.mapper.ProfessionalMapper;
import com.example.springboottest1.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserLoginController {

    /**
     * 最开始希望用Map的形式接参数，后来不用了，将请求对应的接受方式记录一下
     *
     * @RequestBody Map<String,Object> map      post请求
     * @RequestParam Map<String,Object> map     get请求
     */
    @Autowired
    ProfessionalMapper professionalMapper;
    /**
     * 注入UserLoginService
     */
    @Resource
    private UserLoginService userLoginService;
    private User user;


    /**
     * 同时这个时候可以自己了解一下@Controller与@RestController的区别，以及@ResponseBody的用法。
     */

    /**
     * 跳转到用户报名界面
     * @return 报名页面
     */
    @RequestMapping(value = {"/baoming"})
    public String welcome(Model model){
        Collection<Professional> professionals = professionalMapper.findAll();
        System.out.println(professionals);
        model.addAttribute("userpros",professionals);
        return "user/baoming";
    }
//     /**
//     * 跳转到定位打卡界面
//     * @return
//     */
//    @RequestMapping(value = {"/kaoqin"})
//    public String kaoqin(){
//        return "/user/daka";
//    }

    /**
     * 获取用户名与密码，用户登录
     * @return 登录成功页面
     */

        @PostMapping(value = {"/Login"})
        public String userLogin(Model model, String username, String password,
                                Map<String,Object> map, HttpSession session){
            User user = userLoginService.userLogin(username,password);
            int id = userLoginService.getIdByUserName(username);
            System.out.println(id);
            if(user !=null){
                //id=666就是管理员
                if (id == 666 ){
                    //拦截
                    session.setAttribute("loginUser",username);
                    //把user存入model，并命名为user
                    model.addAttribute("user",user);
                    //登陆成功，防止表单重新提交，可以重定向到主页
                    //来到学生界面
                    return "redirect:/admin.html";
                }
                //id=1就是通过了报名的学生
                if (id == 1){
                    //拦截
                session.setAttribute("loginUser",username);
                //把user存入model，并命名为user
                model.addAttribute("user",user);
                //登陆成功，防止表单重新提交，可以重定向到主页
                //来到学生界面
                return "redirect:/user.html";
                }
                else {
                    map.put("msg","请等待老师通过报名");
                    return "login";
                }
            }
            else{
                map.put("msg","用户名或密码错误");
                return "login";
            }
    }

////验证用户名
//    @RequestMapping(value = "/findByName",method = RequestMethod.POST, headers = "Accept=application/json")
//    @ResponseBody
//    public int findByName(@RequestParam("username") String username){
//            int result = 1;
//            List <User> user = userLoginService.findByName(username); //获取所有用户名
//        for (int i=0; i < user.size() ; i++) { //遍历用户名跟获取到的用户名比较
//            if (user.equals(username)) {
//                result = 0;//用户名已经被注册
//            }
//        }
//            if (!user.equals(username)){
//                result = 2;//用户名可用
//            }
//            return result;
//    }
    /**
     * 注册新用户
     * @return 注册结果
     */
    @RequestMapping(value = {"/register"})
    public String addUser(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          @RequestParam("password2") String password2,Map<String,Object> map) {

        if(StringUtils.isEmpty(username)){
            return "用户名不能为空";

        }

        if(StringUtils.isEmpty(password)){
            return "密码不能为空";
        }

        if(StringUtils.isEmpty(password2)){
            return "确认密码不能为空";
        }

        if(!password.equals(password2)){
            return "两次密码不相同，注册失败！！";
        }else {
            int res = userLoginService.adduser(username,password);
            if(res == 0){
                //页面跳转相对路径
                return "register";
            }else {
                map.put("msg","注册成功，请登陆");
                return "login";
            }
            }

    }


    /**
     * 用于测试拦截器（用户是否登录，查看session）
     * 查询用户列表  http://localhost:8080/user/queryAllUser
     * @return 用户列表（json串）
     */
    @ResponseBody
    @RequestMapping(value = {"/AllUser"})
    public List<Map<String,Object>> queryAllUser(){

        return userLoginService.queryAllUser();
    }

}
