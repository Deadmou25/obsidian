package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            ClassicalMusic musicPlayer = context.getBean("musicBeanClassical",  ClassicalMusic.class);
            System.out.println(musicPlayer.getSong());
        }
    }
}
