import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.*;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

class CalculatorTest {
    //через аннотацию программа видит, что это тест
    static Calculator calculator; //можно убрать статик, если не @BeforeAll

    // @BeforeAll срабатывает перед вызовом всего класса. Метод должен быть статик.
    //static void init()

    @BeforeEach//аннотация, чтобы выполнялось перед каждым методом
    void init(){
       calculator = new Calculator();
    }

    @AfterEach
    void after(){
        System.out.println("Меня вызвали.");
    }

    //@Disabled //аннотация, что этот тест не надо запускать. "Заглушка".
    @Timeout(value = 5, unit = TimeUnit.SECONDS ) //максимальное время, которое может работать этот тест. Например, если ждем чего-то, чтобы не "повеситься".
    @Test
    void sumTest() {
        //Calculator calculator = new Calculator(); //надо использовать в тесте объект калькулятора
        double a = 10;
        double b = 5;
        try {
            Thread.sleep(1000); //прервался по таймауту! Если, напр, 6000
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals(a + b, calculator.sum(a, b)); //сначала наши ожидания, как правильно. Потом реальность
    }

    @Test
    void substractTest() {
        double a = 10;
        double b = 5;
        Assertions.assertEquals(a - b, calculator.substract(a, b));
    }

    private static Stream<Arguments> dataForST() {
        List <Arguments> data = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 5000; i++) { //будет 5000 значений
            double a = random.nextDouble();
            double b = random.nextDouble();
            double resultado = a - b;
            data.add(Arguments.arguments(a, b, resultado)); //надо добавить в лист
        }
        return data.stream(); //надо преобразовать в стрим
    }

    @MethodSource("dataForST") //аннотация для множественной проверки. В скобках название метода, который будет поставщиком данных
    @ParameterizedTest
    void substractTest3(double a, double b, double resultado) {
        Assertions.assertEquals(resultado, calculator.substract(a, b));
    }

    @Test
    void multiplicationTest() {
        double a = 10;
        double b = 5;
        Assertions.assertEquals(a * b, calculator.multiplication(a, b));
    }

    @Test
    void divisionTest() {
        double a = 10;
        double b = 5;
        Assertions.assertEquals(a / b, calculator.division(a, b));
    }

    @CsvSource({ //для передачи множественных проверок
            "1, 1, 0",
            "5, 4, 1",
            "33, 22, 11"
    })

    @ParameterizedTest //для множественного тестирования
    void substractTest2(double a, double b, double resaltado) {
        Assertions.assertEquals(resaltado, calculator.substract(a, b));
    }
}