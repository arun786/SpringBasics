package controller;

import com.arun.didemo.controller.SetterInjectedController;
import com.arun.didemo.service.GreetingService;
import com.arun.didemo.service.GreetingServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SetterInjectedControllerTest {

    private SetterInjectedController setterInjectedController;

    @Before
    public void setUp() {
        setterInjectedController = new SetterInjectedController();
        GreetingService greetingService = new GreetingServiceImpl();
        setterInjectedController.setGreetingService(greetingService);
    }

    @Test
    public void testSayHello() {

        String hello = setterInjectedController.sayGreeting();
        assertEquals("Say hello", hello);
    }
}
