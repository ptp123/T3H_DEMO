package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Personal;
import com.example.demo.service.PersonalService;

/**
 * 
 * @author ptphuong. Created date: Jan 15, 2019 Created time: 2:07:41 PM
 *         Description: TODO -
 */

@Controller
@RequestMapping
public class PersonalController {

    @Autowired
    PersonalService personalService;

    // ....getAll
    @GetMapping("/list-personal")
    public String getAll(ModelMap modelMap) {

	List<Personal> listPersonal = personalService.getAll();
	modelMap.addAttribute("listPersonal", listPersonal);
	return "personal/listPersonal";
    }

    // .....getOne
    @GetMapping(value = "/detail-personal/{personalId}")
    public String GetOne(@PathVariable String personalId, ModelMap modelMap) {
	Personal personal = personalService.getOne(Integer.parseInt(personalId));
	modelMap.addAttribute("personal", personal);
	return "personal/detailPersonal";
    }

    // .....insert
    @GetMapping("/add-personal")
    public String personalInsert(ModelMap modelMap) {
	Personal personal = new Personal();
	modelMap.addAttribute("personal", personal);
	return "personal/addPersonal";
    }

    @PostMapping("/add-personal")
    public String insertPersonal(@ModelAttribute Personal personal) {
	personalService.insert(personal);
	return "redirect:/list-personal";
    }

    // .....delete
    @GetMapping("/delete-personal/{personalId}")
    public String delete(@PathVariable String personalId) {
	personalService.delete(Integer.parseInt(personalId));
	return "redirect:/list-personal";
    }

    // .....update
    @GetMapping("/update-personal/{personalId}")
    public String personalUpdate(ModelMap modelMap, @PathVariable String personalId) {
	Personal personal = personalService.getOne(Integer.parseInt(personalId));
	modelMap.addAttribute("personal", personal);
	return "personal/updatePersonal";
    }

    @PostMapping("/update-personal")
    public String updatePersonal(@ModelAttribute Personal personal) {
	personalService.update(personal);
	return "redirect:/list-personal";
    }
}
