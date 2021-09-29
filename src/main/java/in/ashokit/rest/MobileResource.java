package in.ashokit.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.bindings.Category;
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

	@PostMapping("/category")
	public List<Mobile> mobileByCategory(@RequestBody Category category) {
		return service.getMobilesByCategory(category);

	}

}
