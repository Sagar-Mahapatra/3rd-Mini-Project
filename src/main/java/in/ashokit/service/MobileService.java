package in.ashokit.service;

import java.util.List;

import in.ashokit.entity.Mobile;

public interface MobileService {

	List<Mobile> getAllMobiles();

	List<String> getAllBrandName();

	List<Mobile> getMobilesByCategory(String brand, String ram, Double price);

	List<Mobile> getMobilesByCat(String brand, String ram, Double price);

}
