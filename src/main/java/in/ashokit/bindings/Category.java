package in.ashokit.bindings;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class Category {
	private Integer id;
	private String brand;
	private String ram;
	private Double price;
}
