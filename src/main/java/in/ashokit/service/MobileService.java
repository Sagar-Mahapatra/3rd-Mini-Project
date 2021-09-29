package in.ashokit.service;

import java.util.List;

import in.ashokit.bindings.Category;
import in.ashokit.entity.Mobile;

public interface MobileService {

	List<Mobile> getAllMobiles();

	List<String> getAllBrandName();

	List<Mobile> getMobilesByCategory(Category category);

}
