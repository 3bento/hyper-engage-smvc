package com.kennycode.hyperengagesmvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=test")
@AutoConfigureMockMvc
public class AppTest extends TestCase {

	@Test
    public void testMe() {
        System.out.println("Hello World!");
    }
}
