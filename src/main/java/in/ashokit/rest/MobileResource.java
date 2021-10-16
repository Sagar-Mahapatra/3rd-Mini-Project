package in.ashokit.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:4200")
public class MobileResource {

	private MobileService service;

	public MobileResource(MobileService service) {
		this.service = service;
	}

	@GetMapping(value = "/all", produces = "appication/json", consumes = "appication/json")
	public ResponseEntity<List<Mobile>> allMobiles() {
		List<Mobile> list = service.getAllMobiles();
		return new ResponseEntity<>(list, HttpStatus.FOUND);
	}

//just for testing front end call from angular app
	@GetMapping(value = "/msg", produces = "appication/json", consumes = "appication/json")
	public ResponseEntity<String> getMsg() {
		return new ResponseEntity<String>("msg from rest api", HttpStatus.OK);

	}

	@GetMapping("/brands")
	public List<String> allBrands() {
		return service.getAllBrandName();
	}

	@PostMapping(value = "/category", consumes = { "application/json", "application/xml" }, produces = {
			"application/json", "application/xml" })
	public ResponseEntity<List<Mobile>> mobileByCategory(@RequestBody Category category) {
		List<Mobile> list = service.getMobilesByCategory(category);
		return new ResponseEntity<List<Mobile>>(list, HttpStatus.FOUND);
	}

}
