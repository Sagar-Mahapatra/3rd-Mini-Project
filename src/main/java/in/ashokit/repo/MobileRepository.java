package in.ashokit.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.ashokit.entity.Mobile;

public interface MobileRepository extends JpaRepository<Mobile, Serializable> {
	@Query("select brand FROM Mobile")
	List<String> getBrandNames();

	List<Mobile> findByBrandAndRam(String brand, String ram);

	@Query("FROM Mobile where ram=:ram AND price<=:price")
	List<Mobile> getByRamAndPrice(String ram, Double price);

	@Query("FROM Mobile where brand=:brand AND price<=:price")
	List<Mobile> getByBrandAndPrice(String brand, Double price);

}
