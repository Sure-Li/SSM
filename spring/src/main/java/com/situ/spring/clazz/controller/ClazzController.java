package com.situ.spring.clazz.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.situ.spring.clazz.pojo.Clazz;
/**
 * 
 * 
 *
 */
@RestController//继承了 responsebody和controller
@RequestMapping("/clazz")
public class ClazzController {
	static List<Clazz> clazzList = new ArrayList<Clazz>();
	static Long rowId = 0L;
	static {
		clazzList.add(new Clazz(rowId,200901, "2009java", 32, "2020年10月份java班级", 1));
	}
//	@RequestMapping(method = RequestMethod.GET)
	@GetMapping
	public ModelAndView goIndex(ModelAndView modelAndView) {
		modelAndView.setViewName("clazz/clazz_index");
		return modelAndView;
	}
	@PostMapping
	public ModelAndView doAdd(Clazz clazz,ModelAndView modelAndView) {
		rowId++;
		clazz.setRowId(rowId);
		clazz.setActiveFlag(1);
		clazzList.add(clazz);
		modelAndView.addObject("clazzList", clazzList);
		modelAndView.setViewName("clazz/clazz_list");
		return modelAndView;
	}
	@PostMapping("/goadd")
	public ModelAndView goAdd(ModelAndView modelAndView) {
		modelAndView.setViewName("clazz/clazz_add");
		return modelAndView;
	}
	@PutMapping("/{rowId}")
	public ModelAndView goEdit(@PathVariable Long rowId,ModelAndView modelAndView) {
		System.out.println("@PutMapping");
		System.out.println("@PathVariable Long rowId:"+rowId);
		Clazz clazzGoEdit = clazzList.get(Integer.parseInt((rowId.toString())));
		modelAndView.addObject("clazzGoEdit", clazzGoEdit);
		modelAndView.setViewName("clazz/clazz_edit");
		return modelAndView;
	}
	@DeleteMapping("/{rowId}")
	public ModelAndView doDelete(@PathVariable Long rowId,ModelAndView modelAndView) {
		System.out.println("@DeleteMapping");
		System.out.println("@PathVariable Long rowId:"+rowId);
		int clazzRowId = Integer.parseInt(rowId.toString());
		Clazz clazzGet = clazzList.get(clazzRowId);
		clazzGet.setActiveFlag(0);
		clazzList.set(clazzRowId, clazzGet);
		modelAndView.addObject("clazzList", clazzList);
		System.out.println("clazzList:"+ clazzList);
		modelAndView.setViewName("clazz/clazz_list");
		return modelAndView;
	}
	@GetMapping("/list")
	public ModelAndView getList(ModelAndView modelAndView) {
		modelAndView.addObject("clazzList", clazzList);
		System.out.println("clazzList:"+ clazzList);
		modelAndView.setViewName("clazz/clazz_list");
		return modelAndView;
	}

}
