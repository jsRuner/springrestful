package com.cn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cn.model.Person;
import com.cn.result.Response;
import com.cn.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;

import com.cn.base.BasicController;
import com.cn.model.User;
import com.cn.service.UserService;
import com.cn.util.CommUtil;
import com.cn.util.RedisUtil;

import javax.validation.Valid;

/**
 * @ClassName: UserController
 * @Description: TODO
 * @Author devfzm@gmail.com
 * @Date 2016年6月16日 下午10:33:24
 */

@RestController
@RequestMapping("/user")
public class UserController extends BasicController {

	@Autowired
	private UserService userService;

	@Autowired
	private PersonService personService;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/{userid}/show", method = RequestMethod.GET)
	public Response show(@PathVariable long userid) throws HttpRequestMethodNotSupportedException {
		// 错误日志自动发送邮件通知
		logger.info("userid: " + userid);
		
		// Redis Test， 同样可以使用RedisUtil实现Session分布式存储
		RedisUtil.set("ifzm", "guoguo");
		logger.info(RedisUtil.get("ifzm"));
		
		RedisUtil.decrBy("", (long) 0);
		
		// 首先从redis缓存中取数据，如果取不到，再查询数据库，这里是直接使用mybatis缓存配置，也可自行封装调用
		List<User> users = (List<User>) userService.findAll();

		List<Person> persons = (List<Person>) personService.findAll();
		logger.info(persons);

        throw new HttpRequestMethodNotSupportedException("post");

//		return new Response().success(persons);

	}

	/**
	 * @Title: commitTest
	 * @Description: 事务测试
	 * @param user
	 * @return Object
	 * @throws
	 */
	@RequestMapping("/test")
	public Response commitTest(@RequestBody @Valid User user) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 模拟数据，进行事务测试
//		User test = new User();
//		test.setAccount(CommUtil.randomUUID());
//
//		try {
//			// account 拥有唯一索引，添加后再次修改 account 为已存在的值，异常触发事务回滚
//			userService.saveOrUpdate(test);
//		} catch (Exception e) {
//			logger.error("Commit error: " + e);
//			map.put("msg", test);
//		}

        logger.info(user);

		return new Response().success();
	}
}
