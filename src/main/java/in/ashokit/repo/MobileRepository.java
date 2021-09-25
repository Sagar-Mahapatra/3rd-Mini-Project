package in.ashokit.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.ashokit.entity.Mobile;

public interface MobileRepository extends JpaRepository<Mobile, Serializable> {
	@Query("select brand FROM Mobile")
	List<String> getBrandNames();

}
