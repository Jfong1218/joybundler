package com.jonathanfong.joybu.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.jonathanfong.joybu.models.Bundle;
import com.jonathanfong.joybu.services.BundleService;

@Controller
public class HomeController {
	@Autowired
	private BundleService bundleService;
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		else {
			model.addAttribute("bundleList", bundleService.allBundles());
			return "dashboard.jsp";
		}
	}
	
	//Create
	//1. display the form
	@GetMapping("/bundles/new")
	public String newBundleForm(@ModelAttribute("bundle")Bundle bundle) {
		return "newEntry.jsp";
	}
	//2. Processing the form
	@PostMapping("/bundles/new")
	public String processCreateBundle(
			@Valid @ModelAttribute("bundle") Bundle bundle,
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "newEntry.jsp";
		}
		else {
			bundleService.createBundle(bundle);
			return "redirect:/dashboard";
		}
	}
	//Detail page one bundle 
	@GetMapping("/bundles/{id}")
	public String bundleDetails(@PathVariable("id")Long id, Model model) {
		Bundle bundle = bundleService.oneBundle(id);
		model.addAttribute("bundle", bundle);
		return "oneEntry.jsp";
	}
	
	//Edit
	//1. Display the form
	@GetMapping("/bundles/{id}/edit")
	public String editBundle(@PathVariable("id")Long id, Model model) {
		Bundle bundle = bundleService.oneBundle(id);
		model.addAttribute("bundle", bundle);
		return "editEntry.jsp";
	}
	//2. Process the edit form
	@PutMapping("/bundles/{id}/edit")
	public String processEditBundle(
			@Valid @ModelAttribute("bundle") Bundle bundle,
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "editEntry.jsp";
		}
		else {
			bundleService.editBundle(bundle);
			return "redirect:/dashboard";
		}
	}
	
	//delete
	@DeleteMapping("/bundles/{id}/delete")
	public String deleteBundle(@PathVariable("id")Long id) {
		bundleService.deleteBundle(id);
		return "redirect:/dashboard";
	}
}
























