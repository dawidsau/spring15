package pl.sda.springtraining;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pl.sda.springtraining.products.ProductDTO;
import pl.sda.springtraining.products.ProductType;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductsApiTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .build();
    }

    @Test
    public void shouldSaveAndRetrieveProduct() throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setPrice(BigDecimal.TEN);
        productDTO.setProductName("TEST");
        productDTO.setStockAmount(2L);
        productDTO.setType(ProductType.FISH);
        productDTO.setUrl("URL");

        ResultActions resultActions = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/api/product")
                        .content(objectMapper.writeValueAsBytes(productDTO))
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().is(201));

        resultActions.andExpect(jsonPath("$.id").value("3452346534263"));


//        this.mockMvc.perform(
//                MockMvcRequestBuilders.get("/api/product/")
//                        .content(objectMapper.writeValueAsBytes(productDTO))
//                        .contentType(MediaType.APPLICATION_JSON)
//        ).andExpect(status().is(201));
    }
}
