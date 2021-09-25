package in.ashokit.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "MOBILE")
public class Mobile {
	@Id
	private Integer id;
	private String brand;
	private String ram;
	private Double price;

}
