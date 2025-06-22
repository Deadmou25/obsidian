## Scopes

1. Singleton - создаётся 1 объект, все последующие экземпляры ссылаются на один и тот же объект
2. Prototype - при вызове метода getBean() создаётся новый инстанс класса. Чаще всего используется тогда, когда у бига есть изменяемые состояния (stateful)
## Init Method

Запускается в ходе инициализации бина 
Инициализация ресурсов, обращение к внешним файлам, запуск БД

## Destroy-Method

Метод, который запускается в ходе уничтожения бина (при завершении приложения)
Очищение ресурсов, закрытие потоков ввода-вывода, закрытие доступа к БД

![[Screenshot_2025-06-22-20-18-45-219_org.telegram.messenger.png]]

## applicationContext
`<beans xmlns="http://www.springframework.org/schema/beans" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:context="http://www.springframework.org/schema/context" xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">

<context:property-placeholder location="classpath:mucicPlayer.properties"/>



<bean id="musicBeanPhonk" class="org.example.PhonkMusic"> </bean>

<bean id="musicBeanRock" class="org.example.RockMusic"> </bean>

<bean id="musicBeanClassical" class="org.example.ClassicalMusic" init-method="init" destroy-method="destroy"> </bean>
<bean id="musicPlayerBean" class="org.example.MusicPlayer">
<property name="musicList" ref="musicBeanClassical"/>
</bean>
</beans>`

## ClassicalMusic
`package org.example;  
  
public class ClassicalMusic implements Music {  
  
  public void init() {  
    System.out.println("ClassicalMusic init");  
  }  
  public void destroy() {  
    System.out.println("ClassicalMusic destroy");  
  }  
  @Override  
  public String getSong() {  
    return "classic music";  
  }}`


## TestSpring

`package org.example;  
  
import org.springframework.context.support.ClassPathXmlApplicationContext;  
  
public class TestSpring {  
    public static void main(String[] args) {  
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {  
            ClassicalMusic musicPlayer = context.getBean("musicBeanClassical",  ClassicalMusic.class);  
            System.out.println(musicPlayer.getSong());  
        }    }}`

