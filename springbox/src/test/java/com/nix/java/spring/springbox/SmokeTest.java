package com.nix.java.spring.springbox;

import static org.assertj.core.api.Assertions.assertThat;

import com.nix.java.spring.springbox.hellocontrol.HelloController;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private HelloController controller;

    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
}
