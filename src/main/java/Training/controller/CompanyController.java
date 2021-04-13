package Training.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Training.Company;
import Training.repository.CompanyRepository;

@Controller
@RequestMapping("/")
public class CompanyController {

	private CompanyRepository companyRepo;

	@Autowired
	public CompanyController(CompanyRepository companyRepo) {
		this.companyRepo = companyRepo;
	}

	@GetMapping("/")
	public String getAll(Model model) {
		model.addAttribute("company", companyRepo.findAll());
		return "home";
	}

	@GetMapping("/add")
	public String addCompany(Model model) {
		model.addAttribute("company", new Company());
		return "form";
	}

	@PostMapping("/save")
	public String addCompany(@Valid Company company, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "form";
		} else {
			companyRepo.save(company);
			return "redirect:/";
		}
	}

	@GetMapping("/edit/{id}")
	public String editCompany(Model model, @PathVariable Long id) {
		model.addAttribute("company", companyRepo.findById(id).get());
		return "form";
	}

	@GetMapping("/delete/{id}")
	public String deleteCompany(Model model, @PathVariable Long id) {
		companyRepo.deleteById(id);
		return "redirect:/";
	}

	@GetMapping("/search")
	public String searchCompany(@Param("keyword") String keyword, Model model) {
		List<Company> list = companyRepo.findAllByNameContaining(keyword);
		model.addAttribute("company", list);
		return "home";
	}
}
