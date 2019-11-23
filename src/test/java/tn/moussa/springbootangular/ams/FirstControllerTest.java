package tn.moussa.springbootangular.ams;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

public class FirstControllerTest {
	
	@Autowired //injection des dépendences des services pour ne pas utiliser new MockMVC
	MockMvc mockMvc;
	
	public void home() throws Exception {
		this.mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(content().string("Your favorite framework"));
	}

}
