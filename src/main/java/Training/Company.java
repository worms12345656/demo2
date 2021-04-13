package Training;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Company implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "vui long nhap ten cong ty")
	private String name;
	@NotBlank(message = "vui long nhap dia chi")
	private String address;
	@Max(value = 100, message = "so thue phai duoi 100")
	@Min(value = 30, message = "so thhue phai tren 30 ")
	private int tax;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public Company(Long id, @NotBlank(message = "vui long nhap ten cong ty") String name,
			@NotBlank(message = "vui long nhap dia chi") String address,
			@Max(value = 100, message = "so thue phai duoi 100") @Min(value = 30, message = "so thhue phai tren 30 ") int tax) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.tax = tax;
	}

	public Company() {

	}

}
