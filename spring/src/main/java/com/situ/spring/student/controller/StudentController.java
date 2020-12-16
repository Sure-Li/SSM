package com.situ.spring.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.spring.student.pojo.Student;
import com.situ.spring.student.service.StudentService;

/**
 * student/index student/goadd student/doadd student/edit
 *
 */
@Controller
//@RequestMapping("student/")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@RequestMapping("student/index")
	public String goIndex(Model model) {
		List<Student> studenList = studentService.findAllStudent();
		model.addAttribute("studenList", studenList);
		return "student/student_index";
	}

	@RequestMapping("student/goadd")
	public String goAdd() {

		return "student/student_add";
	}

	/**
	 * 在接受表单提交的控制层的方法中，书写一个pojo类的参数。 书写在Controller层方法中的参数，SpringMVC都会自动的生成实例。
	 * 并且如果有表单数据也会直接放置到这个实例中。
	 * 
	 * @param student
	 * @return
	 */
	@RequestMapping("student/doadd")
	public String doAdd(Student student) {
		studentService.saveStudent(student);
//		->要进首页了
		System.out.println(studentService.findAllStudent());
		System.out.println(student);
		return "redirect:index";
	}

	@RequestMapping("student/goedit/{rowId}")
	public String goedit(Model model, @PathVariable("rowId") String rowId) {
		List<Student> studenList = studentService.findAllStudent();
		Student studentGoEdit =  studenList.get(Integer.parseInt(rowId));
		System.out.println(studentGoEdit);
		 System.out.println(rowId);
		 model.addAttribute("studentGoEdit", studentGoEdit);
		return "student/student_edit";
	}
	@RequestMapping("student/goedit/doedit")
	public String doedit(Student student) {
		studentService.updateStudent(student);
		return "redirect:/student/index";
	}
	/**
	 * restful 请求资源一样的URL来进行表单提交
	 * 
	 */
	@RequestMapping("student/delect/{rowId}")
	public String delect(@PathVariable("rowId") String rowId) {
		System.out.println("@PathVariable(\"rowId\")"+rowId);
//		studentService.delectStudent(rowId);
		return "redirect:/student/index";
	}
	
	@ResponseBody//需要jackson加持 既可以修饰方法也可以类 
	@RequestMapping("student/checkcode")
	public Integer checkCode( String stuCode) {
		System.out.println(stuCode);
		return studentService.checkCode(stuCode);
	}
}
