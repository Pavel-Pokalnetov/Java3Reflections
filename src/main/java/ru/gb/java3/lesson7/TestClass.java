package ru.gb.java3.lesson7;

public class TestClass {
    @BeforeSuite
    public void init() {
        System.out.println("Предварительные действия");
    }

    @Test(priority = 2)
    public void testMethod_1() {
        System.out.println("Тест №1");
    }
    @Test(priority = 1)
    public void testMethod_2() {
        System.out.println("Тест №2");
    }

    @Test(priority = 6)
    public void testMethod_3() {
        System.out.println("Тест №3");
    }

    @Test(priority = 5)
    public void testMethod_4() {
        System.out.println("Тест №4");
    }

    @Test(priority = 4)
    public void testMethod_5() {
        System.out.println("Тест №5");
    }

    public void anotherMethod_1() {
        System.out.println("Какой-то другой метод ");
    }
    public void anotherMethod_2() {
        System.out.println("Какой-то ещё другой метод ");
    }

    @AfterSuite
    public void stop() {
        System.out.println("Заключительные действия");
    }

}
