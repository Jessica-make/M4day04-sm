package org.spoto.controller;

import com.alibaba.fastjson.JSONObject;
import org.spoto.model.Account;
import org.spoto.service.AccountService;
import org.spoto.utils.StringUtils;
import org.spoto.utils.TableData;
import org.spoto.utils.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("/account")
public class AccountController {

   @Resource
   private AccountService accountService;

    //查询
     @RequestMapping("/account-list.ajax")
     @ResponseBody
     public String list(String account,String passwd,Integer index){
         //1.参数校验
         if (index==null){
             index=1;
         }
         //2.1抓取异常;
         TableData<Account> td =accountService.list(index,account,passwd);
         //3.返回数据
         return WebUtils.returnData(td);
     }

    //JSON格式
    //新增和修改;
    @RequestMapping("/save.ajax")
    @ResponseBody
    public String save(Account ac){
        accountService.save(ac);
        //4.返回响应数据;
        JSONObject data = new JSONObject();
        data.put("type",true);
       return data.toJSONString();
    }

//    //实现删除功能;
    @RequestMapping("/del.ajax")
    @ResponseBody
    public String del(String ids){
        //1.定义Object
        JSONObject data = new JSONObject();
        //2.参数校验;
        if (StringUtils.isEmpty(ids)){
            data.put("type",false);
            return data.toJSONString();
        }
        //3.分割数组,遍历;
        String[] idListStr = ids.split(",");
        List<Integer> idList=new ArrayList<>();
        for (String idstr:idListStr){
            int id = Integer.parseInt(idstr);
            idList.add(id);
        }
        //4.调用接口;
        accountService.del(idList);
        //5.返回数据;
       data.put("type",true);
       return data.toJSONString();

    }

//   @RequestMapping("/login.ajax")
//   @ResponseBody
//   public String login(String uname,String passwd,HttpServletRequest request,HttpServletResponse response){
//
//       //定义一个状态码;
//       int code=0;
//       //2.参数校验;
////        //isAllNotEmpty 全都不为空;加了！表示有一个是空的;
//       if (!StringUtils.isAllNotEmpty(uname,passwd)){
//           //空参数操作;
//           code=-1;
//       }else {
//           //3.调用业务处理;
//           LoginService ls = new LoginServiceImpl();
//           boolean logined = ls.NewLogin(uname, passwd);
//           if (logined){
//               User u = new User(uname,passwd);
//               request.setAttribute("u",u);
//               request.getSession().setAttribute("logined",uname);
//
//               code=0;
//           }else {
//               code=-2;
//           }
//       }
//       //4.处理结果，响应出去;
//       JSONObject data = new JSONObject();
//       data.put("code",code);
//       return data.toJSONString();
//   }
}
