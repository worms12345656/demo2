package Training;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message="vui long nhap ten")
	private String name;
	@NotBlank(message="vui long nhap lop")
	private String clazz;
	@Min(value=18,message="tuoi phai lon hon 18")
	private int age;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Student(Long id, @NotBlank(message = "vui long nhap ten") String name,
			@NotBlank(message = "vui long nhap lop") String clazz,
			@Min(value = 18, message = "tuoi phai lon hon 18") int age) {
		super();
		this.id = id;
		this.name = name;
		this.clazz = clazz;
		this.age = age;
	}
	
	public Student() {
		
	}
	
	

}
