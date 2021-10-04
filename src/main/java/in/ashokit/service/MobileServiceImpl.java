package in.ashokit.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.ashokit.bindings.Category;
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

		return repo.findAll().stream().sorted(Comparator.comparing(Mobile::getPrice).reversed())
				.collect(Collectors.toList());
	}

	@Override
	public List<String> getAllBrandName() {

		return repo.getBrandNames().stream().distinct().collect(Collectors.toList());
	}

	@Override
	public List<Mobile> getMobilesByCategory(Category category) {

		if (category == null) {
			return repo.findAll();
		}

		Mobile mobile = new Mobile();

		if (null != category.getBrand() && !"".equals(category.getBrand())) {
			mobile.setBrand(category.getBrand());
		}
		if (null != category.getRam() && !"".equals(category.getRam())) {
			mobile.setRam(category.getRam());
		}
		Example<Mobile> example = Example.of(mobile);
		List<Mobile> mobiles = repo.findAll(example);
		if (null != category.getPrice()) {
			return mobiles.stream().filter(m -> m.getPrice() <= category.getPrice())
					.sorted(Comparator.comparing(Mobile::getPrice)).collect(Collectors.toList());
		}
		return mobiles;
	}

}
