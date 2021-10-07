package in.ashokit.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import in.ashokit.entity.Mobile;
import in.ashokit.service.MobileService;

@WebMvcTest(value = MobileResource.class)
public class TestMobileResource {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private MobileService service;

	@Test
	public void testAllMobiles() throws Exception {
		List<Mobile> list = new ArrayList<>();
		list.add(new Mobile(101, "Honor", "4GB", 20000.00));
		list.add(new Mobile(102, "Apple", "4GB", 40000.00));
		when(service.getAllMobiles()).thenReturn(list);
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/mobile/all");
		int status = mockMvc.perform(requestBuilder).andReturn().getResponse().getStatus();
		assertEquals(status, 302);
	}

}
