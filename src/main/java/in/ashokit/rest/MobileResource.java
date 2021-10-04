package in.ashokit.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	private static Logger log = LoggerFactory.getLogger(MobileResource.class);

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

	@PostMapping(value = "/category", consumes = { "application/json", "application/xml" }, produces = {
			"application/json", "application/xml" })
	public ResponseEntity<List<Mobile>> mobileByCategory(@RequestBody Category category) {

		log.info("Category: " + category);
		List<Mobile> list = service.getMobilesByCategory(category);
		log.info("mobilesByCategory:: " + list);

		return new ResponseEntity<List<Mobile>>(list, HttpStatus.FOUND);

	}

}
