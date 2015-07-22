package com.sudarshan.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sudarshan.model.AppUser;
import com.sudarshan.service.UserService;
import com.sudarshan.validator.UserFormValidator;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	UserFormValidator userFormValidator;

	@InitBinder
	public void initBinder(WebDataBinder webDataBnder) {
		webDataBnder.setValidator(userFormValidator);
	}

	@RequestMapping(value = "/",method=RequestMethod.GET)
	public String index() {
		return "redirect:/users";
	}

	@RequestMapping(value="/users",method=RequestMethod.GET)
	public String findAllUsers(Model model) {
		List<AppUser> allUsers = userService.findAll();
		model.addAttribute("users", allUsers);
		return "users/list";
	}

	@RequestMapping(value="/users/add", method=RequestMethod.GET)
	public String showAddUserForm(Model model) {
		AppUser appUserObj = new AppUser();

		appUserObj.setName("Sudarshan Reddy");
		appUserObj.setEmail("sudarshang.reddy@gmail.com");
		appUserObj.setAddress("Malkajgiri Hyderabad");
		appUserObj.setNewsletter(1);
		appUserObj.setSex("M");
		appUserObj.setFramework(new ArrayList<String>(Arrays.asList(new String[]{"Spring MVC","JSF"})));
		appUserObj.setSkill(new ArrayList<String>(Arrays.asList(new String[]{"Spring","Java","Hibernate"})));
		appUserObj.setCountry("IN");
		appUserObj.setNumber(2);
		model.addAttribute("userForm", appUserObj);

		populateDefaultModel(model);

		return "users/userform";
	}
	
	public String saveOrUpdateUser(@ModelAttribute("userForm"))

	private void populateDefaultModel(Model model) {

		List<String> frameworksList = new ArrayList<String>();
		frameworksList.add("Spring MVC");
		frameworksList.add("Struts 2");
		frameworksList.add("JSF");
		frameworksList.add("GWT");
		frameworksList.add("Play");
		frameworksList.add("Apache Wicket");
		model.addAttribute("frameworkList", frameworksList);

		Map<String, String> skill = new LinkedHashMap<String, String>();
		skill.put("Hibernate", "Hibernate");
		skill.put("Spring", "Spring");
		skill.put("Struts", "Struts");
		skill.put("Groovy", "Java");
		skill.put("Grails", "Grails");
		model.addAttribute("javaSkillList", skill);

		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		model.addAttribute("numberList", numbers);

		Map<String, String> country = new LinkedHashMap<String, String>();
		country.put("US", "United Stated");
		country.put("CN", "China");
		country.put("SG", "Singapore");
		country.put("MY", "Malaysia");
		model.addAttribute("countryList", country);

	}



}
