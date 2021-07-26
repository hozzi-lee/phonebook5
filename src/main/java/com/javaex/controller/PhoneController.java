package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller
public class PhoneController {
	
	@Autowired
	private PhoneDao phoneDao;
	
	// LIST
		@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
		public String list(Model model) {
			System.out.println("/list");
			
//			PhoneDao phoneDao = new PhoneDao(); --> (field)@Autowired PhoneDao phoneDao;

//			List<PersonVo> pList = phoneDao.getList();
//			model.addAttribute("pList", pList);
			
			model.addAttribute("pList", phoneDao.getList());
			
			return "/list";
		}
		
		// WRITEFORM
		@RequestMapping(value = "/writeForm", method = { RequestMethod.GET, RequestMethod.POST })
		public String writeForm() {
			System.out.println("/writeForm");
			
			return "/writeForm";
		}
		
		// INSERT
		@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
		public String insert(@ModelAttribute PersonVo personVo) {
			System.out.println("/write");
			
			//@ModelAttribute --> new PsrsonVo() --> default constructors + setter
			
			phoneDao.insert(personVo);
			
			return "redirect:/list";
		}
		
		// INSERT - 2
		@RequestMapping(value = "/write2", method = { RequestMethod.GET, RequestMethod.POST })
		public String insert2(@RequestParam("name") String name,
								@RequestParam("hp") String hp,
								@RequestParam("company") String company) {
			System.out.println("/write2");
			
			//@ModelAttribute --> new PsrsonVo() --> default constructors + setter
			
			phoneDao.insert2(name, hp, company);
			
			return "redirect:/list";
		}
		
		// DELTE
		@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
		public String delete(@RequestParam("id") int personID) {
			System.out.println("/delete");
			
//			PhoneDao phoneDao = new PhoneDao();
			
			phoneDao.delete(personID);
			
			return "redirect:/list";
		}
		
		// MODIFYFORM
		@RequestMapping(value = "/modifyForm", method = { RequestMethod.GET, RequestMethod.POST })
		public String modifyForm(@RequestParam("id") int personID, Model model) {
			System.out.println("/modifyForm");
			
//			PhoneDao phoneDao = new PhoneDao();
			model.addAttribute("personInfo", phoneDao.personInfo(personID));
			
			return "/modifyForm";
		}
		
		// MODIFYFORM - 2
		@RequestMapping(value = "/modifyForm2", method = { RequestMethod.GET, RequestMethod.POST })
		public String modifyForm2(Model model, @RequestParam("id") int personID) {
			System.out.println("/modifyForm2");
			
//			PhoneDao phoneDao = new PhoneDao();
			model.addAttribute("personMap", phoneDao.personInfo2(personID));
			
			return "/modifyForm2";
		}
		
		// MODIFY
		@RequestMapping(value = "/modify", method = { RequestMethod.GET, RequestMethod.POST })
		public String modify(@ModelAttribute PersonVo personVo) {
			System.out.println("/modify");
			
//			PhoneDao phoneDao = new PhoneDao();
			phoneDao.update(personVo);
			
			return "redirect:/list";
		}
		
		
		
		
		
		
		
		/* ****************************************************************************** */
		
		@RequestMapping(value = "/board/read/{no}", method = { RequestMethod.GET, RequestMethod.POST })
		public void pathParamTest(@PathVariable("no") int no) {
			//localhost:8088/phonebook5/pb/board/read/1
			//localhost:8088/phonebook5/pb/board/read/3
			System.out.println("pathVariable [read]: /board/read/{no}");
			
			System.out.println(no);
			
		}
		
		@RequestMapping(value = "/test")
		public String test() {
			System.out.println("/pb/test");
			
			return "/test"; // DispatcherServlet에게 FORWARD하라고 시키기
		}

}
