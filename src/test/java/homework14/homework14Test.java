package homework14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
import java.util.List;
import java.util.ArrayList;

class homework14Test {
    homework14 homework14 = new homework14();

    private static Stream <Arguments> dataForArray(){
        List <Arguments> data = new ArrayList<>();
        int [] a = {1, 15, 0, 14, 4, 5, 12, 8};
        int [] b = {5, 12, 8};
        int [] c = {1, 6, 7, 4, 12, 4, 9, 0};
        int [] d = {12, 4, 9, 0};
        data.add(Arguments.arguments(a, b, c, d));
        return data.stream();
    }

    @MethodSource("dataForArray")
    @ParameterizedTest
    void Testfour(int[] a, int[] b, int [] c, int [] d) {
        Assertions.assertArrayEquals(b, homework14.four(a));
        Assertions.assertArrayEquals(d, homework14.four(c));
    }

//НО! Можно, конечно, провести массово все тесты здесь, но если будет завален один из примеров, тест покажет, что завалено всё. Наверное, лучше писать такие тесты по отдельности.
//Этот пример я оставлю, т.к. интересная возможность. Да и у нас просили "набор тестов", что бы это ни значило.

    private static Stream <Arguments> dataForArray2(){
        List <Arguments> data = new ArrayList<>();
        int [] a = {4, 6, 17, 8};
        int [] b = {6, 17, 8};
        data.add(Arguments.arguments(a, b));
        return data.stream();
    }

    @MethodSource("dataForArray2")
    @ParameterizedTest
    void Testfour2(int[] a, int[] b) {
        Assertions.assertArrayEquals(b, homework14.four(a));
    }

    private static Stream <Arguments> dataForArray3(){ //это тест без четверок
        List <Arguments> data = new ArrayList<>();
        int [] a = {1, 1, 1, 1};
        int [] b = {};
        data.add(Arguments.arguments(a, b));
        return data.stream();
    }

    @MethodSource("dataForArray3")
    @ParameterizedTest
    void Testfour3(int[] a, int[] b) {
        Assertions.assertArrayEquals(b, homework14.four(a));
    }

    private static Stream <Arguments> dataForArray4(){ //а это тест, которому мы подсунем ошибку
        List <Arguments> data = new ArrayList<>();
        int [] a = {1, 1, 1, 4, 1};
        int [] b = {1, 1};
        data.add(Arguments.arguments(a, b));
        return data.stream();
    }

    @MethodSource("dataForArray4")
    @ParameterizedTest
    void Testfour4(int[] a, int[] b) {
        Assertions.assertArrayEquals(b, homework14.four(a));
    }


// теперь тесты для второго метода

    @Test
    void testHaveOneFourOrNo(){
        int [] a = {1, 1, 1, 4, 1};
        Assertions.assertEquals(true, homework14.haveOneorFour(a));
    }

    @Test
    void testHaveOneFourOrNo2(){
        int [] a = {1, 1, 1, 1, 1};
        Assertions.assertEquals(false, homework14.haveOneorFour(a));
    }

    @Test
    void testHaveOneFourOrNo3(){
        int [] a = {3, 1, 1, 4, 1};
        Assertions.assertEquals(false, homework14.haveOneorFour(a));
    }
}
//итого: 2 провалено, 5 пройдено