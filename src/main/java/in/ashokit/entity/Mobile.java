package in.ashokit.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "MOBILE")
@XmlRootElement
@AllArgsConstructor
@NoArgsConstructor
public class Mobile {
	@Id
	private Integer id;
	private String brand;
	private String ram;
	private Double price;

}
