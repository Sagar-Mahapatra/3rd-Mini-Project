package in.ashokit.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.entity.Mobile;
import in.ashokit.service.MobileService;

@RestController
@RequestMapping("/mobile")
public class MobileResource {

	private MobileService service;

	public MobileResource(MobileService service) {
		this.service = service;
	}

	@GetMapping("/all")
	public List<Mobile> allMobiles() {

		return service.getAllMobiles();

	}

	@GetMapping("/brands")
	public List<String> allBrands() {

		return service.getAllBrandName();

	}

	@GetMapping("/")
	public List<Mobile> mobileByCategory(@RequestParam(required = false) String brand,
			@RequestParam(required = false) String ram, @RequestParam(required = false) Double price) {

		if (brand != null && ram != null && price != null) {
			return service.getMobilesByCategory(brand, ram, price);

		} else {
			return service.getMobilesByCat(brand, ram, price);

		}

	}

}
