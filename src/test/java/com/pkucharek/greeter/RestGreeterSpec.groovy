package com.pkucharek.greeter

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import spock.lang.Specification

@WebMvcTest
@ContextConfiguration(classes = GreeterControllerTestConfig.class)
class RestGreeterSpec extends Specification {

    @Autowired
    private MockMvc mvc

    def "should_greet"() {
        expect:
            mvc.perform(get("/greet/John"))
                .andExpect(status().isOk())
                .andReturn()
                .response
                .contentAsString == "Hello John"
    }
}
