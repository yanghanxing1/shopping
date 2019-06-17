package com.shopping.controller.portal;

import com.shopping.common.Const;
import com.shopping.common.ServerResponse;
import com.shopping.pojo.Category;
import com.shopping.pojo.UserInfo;
import com.shopping.pojo.vo.ProductVO;
import com.shopping.service.ICategoryService;
import com.shopping.service.IProductService;
import com.shopping.service.IUserService;
import com.shopping.util.IpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author teacher.zhang
 */
@RestController
@RequestMapping(value = "/portal/user/")
public class UserController {
    @Autowired
    private IUserService userService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IProductService productService;

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    /*通过logo直接访问首页，用户是未登录状态*/
    @RequestMapping("home.do")
    public ModelAndView toHomeByLogo(Map map){
        map.put("sr",ServerResponse.createServerResponseBySuccess());
        return new ModelAndView("one/home/home",map);
    }

    /*前台用户登录：登录成功添加session*/
    @RequestMapping("login.do")
    public ModelAndView userLogin(HttpServletRequest request, HttpSession session,
                                  @RequestParam(name = "username")String username,
                                  @RequestParam(name = "password")String password) {
//        ServerResponse<UserInfo>
//        String info=NeueduAnalyticsEngineSDK.recordPaidOrderLog("127.0.0.1","1111111","12",String.valueOf(System.currentTimeMillis()),System.currentTimeMillis()+"");
//        logger.info(info);
        ServerResponse<UserInfo> sr = userService.selectByUserName(session, username, password);
        //判断状态码为0，创建session
        if (sr != null && sr.isSuccess()) {
            //更新用户ip
            String userIp = IpUtils.getRemoteAddress(request);
            sr.getData().setUserIp(userIp);
            userService.updateUserIp(sr.getData());
            session.setAttribute(Const.RoleEnum.ROLE_CUSTOMER.getDesc(), sr.getData());
        }
        ServerResponse sr2 = categoryService.getDeepCategory(0);
        ServerResponse sr3 = productService.topcategory(0);
        ServerResponse sr4 = productService.getList(2,"",1,6,"");
        List<Category> categories = null;
        List<Category> categorieList = null;
        List<ProductVO> productVOS = null;
        if(sr.getStatus()==0) {
            categories = (List<Category>) sr2.getData();
            categorieList = (List<Category>) sr3.getData();
            productVOS = (List<ProductVO>) sr4.getData();

        }

        //返回数据
        Map map = new HashMap();
        map.put("sr",sr);
        map.put("categories",categories);
        map.put("categorieList",categorieList);
        map.put("productVOS",productVOS);
        return new ModelAndView("one/home/home",map);
    }

    /*前台用户注册*/
    @RequestMapping("register.do")
    public ServerResponse userRegister(UserInfo ui) {
        ServerResponse sr = userService.insertNew(ui);
        //返回数据
        return sr;
    }

    /*用户注册用户名或者邮箱是否可用*/
    @RequestMapping("check_valid.do")
    public ServerResponse checkUser(String str, String type) {
        ServerResponse sr = userService.checkUser(str, type);

        //返回数据
        return sr;
    }

    /*获取登录用户信息*/
    @RequestMapping("get_user_info.do")
    public ServerResponse getLoginUser(HttpSession session) {
        ServerResponse sr = userService.getLoginUserMsg(session);

        //返回数据
        return sr;
    }

    /*忘记密码*/
    @RequestMapping("forget_get_question.do")
    public ServerResponse forgetUserName(String username) {
        ServerResponse sr = userService.forgetUserName(username);

        //返回数据
        return sr;
    }

    /*提交问题答案*/
    @RequestMapping("forget_check_answer.do")
    public ServerResponse forgetGetAnswer(String username, String question, String answer) {
        ServerResponse sr = userService.forgetGetAnswer(username, question, answer);

        //返回数据
        return sr;
    }

    /*忘记密码的重设密码*/
    @RequestMapping("forget_reset_password.do")
    public ServerResponse forgetResetPassword(String username, String passwordNew, String forgetToken) {
        ServerResponse sr = userService.forgetResetPassword(username, passwordNew, forgetToken);

        //返回数据
        return sr;
    }

    /*登录中状态重置密码*/
    @RequestMapping("reset_password.do")
    public ServerResponse resetPassword(HttpSession session, String passwordOld, String passwordNew) {
        ServerResponse sr = userService.resetPassword(session, passwordOld, passwordNew);

        //返回数据
        return sr;
    }

    /*登录状态更新个人信息*/
    @RequestMapping("update_information.do")
    public ServerResponse updateInformation(HttpSession session, UserInfo usr) {
        ServerResponse sr = userService.updateInformation(session, usr);
        //更新session
        if (sr.isSuccess()) {
            UserInfo ui = (UserInfo) session.getAttribute(Const.RoleEnum.ROLE_CUSTOMER.getDesc());
            UserInfo newUi = userService.selectByPrimaryKey(ui.getId());
            session.setAttribute(Const.RoleEnum.ROLE_CUSTOMER.getDesc(), newUi);
        }
        //返回数据
        return sr;
    }

    /*获取当前登录用户的详细信息*/
    @RequestMapping("get_inforamtion.do")
    public ServerResponse getInforamtion(HttpSession session) {
        ServerResponse sr = userService.getInforamtion(session);

        //返回数据
        return sr;
    }

    /*退出登录*/
    @RequestMapping("logout.do")
    public ServerResponse logout(HttpSession session) {
        ServerResponse sr = userService.logout(session);

        //返回数据
        return sr;
    }
}
