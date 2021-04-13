package Training.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import Training.Student;
import Training.repository.TrainingRepository;

@Controller
@RequestMapping("/")
public class StudentController {

	private TrainingRepository studentRepo;
	
	@Autowired
	public StudentController(TrainingRepository studentRepo) {
		this.studentRepo = studentRepo;
	}
	
	@GetMapping("/")
	public String getAll(Model model) {
		List<Student> list = (List<Student>) studentRepo.findAll();
		model.addAttribute("student", list);
		return "home";
	}
	
	@GetMapping("/add")
	public String addStudent(Model model) {
		model.addAttribute("student", new Student());
		return "form";
	}
	
	@PostMapping("/save")
	public String saveStudent(@Valid Student student,BindingResult bindingresult) {
		if(bindingresult.hasErrors()) {
			return "form";
		}else {
			studentRepo.save(student);
			return "redirect:/";
		}
	}
	
	@GetMapping("/edit/{id}")
	public String editStudent(Model model,@PathVariable Long id) {
		model.addAttribute("student", studentRepo.findById(id).get());
		return "form";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentRepo.deleteById(id);
		return "redirect:/";
	}
	
	@GetMapping("/search")
	public String deleteStudent(@Param("keyword") String keyword,Model model) {
		List<Student> list = (List<Student>) studentRepo.findByNameContaining(keyword);
		model.addAttribute("student", list);
		return "home";
	}
	
}
