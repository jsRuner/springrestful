package com.cn.controller;

import com.cn.model.Member;
import com.cn.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/member")
public class MemberController {

    /**
     * 此方法是用于第一次给页面添加一个user模型数据的
     */
    @RequestMapping(value="/add",method = RequestMethod.GET)
    public ModelAndView initForm(){
        Member member = new Member();
        return new ModelAndView("/add").addObject(member);
    }

    /**
     * 给入参的模型对象User加入@Valid注解，说明这个对象里面的属性需要校验
     * BindingResult入参是用以判断上面的校验是否出错
     */
    @RequestMapping("/create")
    public ModelAndView createUser(@Valid Member member, BindingResult bindingResult){
        ModelAndView view = new ModelAndView();
        System.out.println(member.getUserName()+"----");

        //如果校验有问题，跑回原来的add.jsp页面，如果没问题跑到success.jsp页面
        if(bindingResult.hasErrors()){
            view.setViewName("/add");
        }else{
            view.setViewName("/success");
        }

        return view;
    }


}
