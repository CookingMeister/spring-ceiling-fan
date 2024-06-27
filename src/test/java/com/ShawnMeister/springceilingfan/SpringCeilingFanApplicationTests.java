package com.shawnmeister.springceilingfan;

import java.time.LocalDate;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class SpringCeilingFanApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CeilingFan ceilingFan;

    // Set the speed and direction of the ceiling fan to 0 and false before each test
    @BeforeEach
    void setUp() {
        ceilingFan.setSpeed(0);
        ceilingFan.setReversed(false);
    }

    // Test the speed cord endpoint
    @Test
    void testPullSpeedCord() throws Exception {
        mockMvc.perform(get("/api/pull-speed-cord"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Speed cord pulled!")));
        assertEquals(1, ceilingFan.getSpeed());
        assertFalse(ceilingFan.isReversed());
    }

    // Test the direction cord endpoint
    @Test
    void testPullDirectionCord() throws Exception {
        mockMvc.perform(get("/api/pull-direction-cord"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Direction cord pulled!")));

        assertEquals(0, ceilingFan.getSpeed());
        assertTrue(ceilingFan.isReversed());
    }

    // Test the pull speed cord method
    @Test
    void testPullSpeedCordMultipleTimes() {
        for (int i = 0; i < 3; i++) {
            ceilingFan.pullSpeedCord();
        }
        assertEquals(3, ceilingFan.getSpeed());
        assertFalse(ceilingFan.isReversed());
    }

    // Test the pull direction cord method
    @Test
    void testPullDirectionCordMultipleTimes() {
        ceilingFan.pullDirectionCord();
        assertTrue(ceilingFan.isReversed());
        ceilingFan.pullDirectionCord();
        assertFalse(ceilingFan.isReversed());
    }

    // Test the fan is disabled on December 25th
    @Test
    void testOnDecember25th() {
        // Create a new instance of CeilingFan with the overridden getToday() method
        CeilingFan localCeilingFan = new CeilingFan() {
            @Override
            protected LocalDate getToday() {
                return LocalDate.of(2024, 12, 25);
            }
        };

        // Call the cord methods on the local instance
        localCeilingFan.pullSpeedCord();
        localCeilingFan.pullDirectionCord();

        assertEquals(0, localCeilingFan.getSpeed());
        assertFalse(localCeilingFan.isReversed());
    }

}
