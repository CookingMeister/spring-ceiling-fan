// package com.ShawnMeister.springceilingfan;

// import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.context.SpringBootTest;

// @SpringBootTest
// class SpringCeilingFanApplicationTests {

// 	@Test
// 	void contextLoads() {
// 	}

// }
package com.ShawnMeister.springceilingfan;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SpringCeilingFanApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CeilingFan ceilingFan;

    @BeforeEach
    void setUp() {
        ceilingFan = new CeilingFan();
		ceilingFan.setSpeed(0);
		ceilingFan.setReversed(false);
    }

     @Test
    void testPullSpeedCord() throws Exception {
        mockMvc.perform(get("/pull-speed-cord"))
                .andExpect(status().isOk())
                .andExpect(content().string("Speed cord pulled!"));

        assertEquals(1, ceilingFan.getSpeed());
        assertFalse(ceilingFan.isReversed());
    }

    @Test
    void testPullDirectionCord() throws Exception {
        mockMvc.perform(get("/pull-direction-cord"))
                .andExpect(status().isOk())
                .andExpect(content().string("Direction cord pulled!"));

        assertEquals(0, ceilingFan.getSpeed());
        assertTrue(ceilingFan.isReversed());
    }

	// @Test
    // void testHandleKeyEvent() throws Exception {
    //     mockMvc.perform(post("/key-event")
    //             .contentType("application/json")
    //             .content("{\"key\": \"s\"}"))
    //             .andExpect(status().isOk());

    //     assertEquals(1, ceilingFan.getSpeed());
    //     assertFalse(ceilingFan.isReversed());

    //     mockMvc.perform(post("/key-event")
    //             .contentType("application/json")
    //             .content("{\"key\": \"d\"}"))
    //             .andExpect(status().isOk());

    //     assertEquals(1, ceilingFan.getSpeed());
    //     assertTrue(ceilingFan.isReversed());
    // }
}
