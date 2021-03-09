package homework14;
import java.util.Arrays;

public class homework14 {
    static int [] array = {1, 13, 0, -7, 4, 12, 15, 16}; //вообще всё это заменяют тесты... но давайте оставим, уж очень наглядно.
    static int [] array2 = {1, 4, 5, 7, 4, 9};
    static int [] array3 = {2, 8, 16};
    static int [] array4 = {1, 1, 4, 4, 4}; //для метода четверок и единиц
    static int [] array5 = {4,4,4,4};

    public static void main(String[] args) {
        four(array);
        System.out.println();
        four(array2);
        System.out.println();
//        four(array3);

        // если мы хотим, чтобы наш код продолжился, исключение надо все-таки поймать, а не только бросить.
        try {
            four(array3);
        } catch (RuntimeException e){
            e.printStackTrace();
        }

        System.out.println(haveOneorFour(array3));
        System.out.println(haveOneorFour(array4));
        System.out.println(haveOneorFour(array5));
    }

    //задание 1
    public static int [] four(int [] arr) throws RuntimeException {
        int find = -1; //место в массиве, где нашлась четверка. Если четверок нет, регулируем исключением. Начальное значение прописываем заведомо нереалистичным.
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 4) {
                    find = i;
                    break;
            }
        }
            if (find == -1){
                System.out.println("В этом массиве нет четвёрок!");
                throw new RuntimeException();
            }

            int [] arrayAfterFour = new int[arr.length - find - 1];
            System.arraycopy(arr, find + 1, arrayAfterFour, 0, arr.length - find - 1);
            System.out.println(Arrays.toString(arrayAfterFour));
        return arrayAfterFour;
    }

    //задание 2
    public static boolean haveOneorFour(int[]arr) {
        boolean oneOrFore = true; //главная булеан
        boolean haveOne = false; //эта и ниже - вспомогательные булеаны
        boolean haveFour = false;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] != 1) && (arr[i] != 4)){
                oneOrFore = false;
            }
            if (arr[i] == 1){
             haveOne = true;
            } if (arr[i] == 4){
                haveFour = true;
            }
        }
        if (!haveOne || !haveFour){
            oneOrFore = false;
        }
        return oneOrFore;
    }
}
