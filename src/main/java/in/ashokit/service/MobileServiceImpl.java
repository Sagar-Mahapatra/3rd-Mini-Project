package in.ashokit.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import in.ashokit.entity.Mobile;
import in.ashokit.repo.MobileRepository;

@Service
public class MobileServiceImpl implements MobileService {

	private MobileRepository repo;

	public MobileServiceImpl(MobileRepository repo) {
		this.repo = repo;
	}

	@Override
	public List<Mobile> getAllMobiles() {

		return repo.findAll().stream().sorted(Comparator.comparing(Mobile::getPrice)).collect(Collectors.toList());
	}

	@Override
	public List<String> getAllBrandName() {

		return repo.getBrandNames().stream().distinct().collect(Collectors.toList());
	}

	@Override
	public List<Mobile> getMobilesByCategory(String brand, String ram, Double price) {

		return repo.findAll().stream()
				.filter(mob -> mob.getBrand().equals(brand) && mob.getRam().equals(ram) && mob.getPrice() <= price)
				.sorted(Comparator.comparing(Mobile::getPrice).reversed()).collect(Collectors.toList());
	}

	@Override
	public List<Mobile> getMobilesByCat(String brand, String ram, Double price) {

		boolean brandName = false;
		boolean ramSize = false;
		boolean priceAmt = false;
		if (brand != null) {
			brandName = true;
		}
		if (ram != null) {
			ramSize = true;
		}
		if (price != null) {
			priceAmt = true;
		}

		if (brandName && ramSize) {
			System.out.println("brandName && ramSize");
			return repo.findAll().stream().filter(mob -> mob.getBrand().equals(brand) && mob.getRam().equals(ram))
					.sorted(Comparator.comparing(Mobile::getPrice).reversed()).collect(Collectors.toList());
		} else if (brandName && priceAmt) {
			System.out.println("brandName && priceAmt");
			return repo.findAll().stream().filter(mob -> mob.getBrand().equals(brand) && mob.getPrice() <= price)
					.sorted(Comparator.comparing(Mobile::getPrice).reversed()).collect(Collectors.toList());
		} else if (ramSize && priceAmt) {
			System.out.println("ramSize && priceAmt");
			return repo.findAll().stream().filter(mob -> mob.getRam().equals(ram) && mob.getPrice() <= price)
					.sorted(Comparator.comparing(Mobile::getPrice).reversed()).collect(Collectors.toList());
		} else {
			return new ArrayList<>();
		}
	}

}
