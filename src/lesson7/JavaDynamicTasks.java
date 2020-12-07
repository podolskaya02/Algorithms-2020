package lesson7;

import kotlin.NotImplementedError;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class JavaDynamicTasks {
    /**
     * Наибольшая общая подпоследовательность.
     * Средняя
     *
     * Дано две строки, например "nematode knowledge" и "empty bottle".
     * Найти их самую длинную общую подпоследовательность -- в примере это "emt ole".
     * Подпоследовательность отличается от подстроки тем, что её символы не обязаны идти подряд
     * (но по-прежнему должны быть расположены в исходной строке в том же порядке).
     * Если общей подпоследовательности нет, вернуть пустую строку.
     * Если есть несколько самых длинных общих подпоследовательностей, вернуть любую из них.
     * При сравнении подстрок, регистр символов *имеет* значение.
     */
    //Ресурсоемкость О(firstLenght * secondLenght)
    //Трудоемкость O(firstLenght * secondLenght)
    public static String longestCommonSubSequence(String first, String second) {
        StringBuilder subSequence = new StringBuilder();
        int firstLenght = first.length();
        int secondLenght = second.length();
        int x = 0;
        int y = 0;
        int[][] array = new int[firstLenght + 1][secondLenght + 1];

        for (int i = firstLenght - 1; i >= 0; i--) {
            for (int j = secondLenght - 1; j >= 0; j--) {
                if (first.charAt(i) == second.charAt(j)) array[i][j] = array[i + 1][j + 1] + 1;
                else array[i][j] = Math.max(array[i + 1][j], array[i][j + 1]);
            }
        }

        while (x < firstLenght && y < secondLenght) {
            if (first.charAt(x) == second.charAt(y)) {
                subSequence.append(first.charAt(x));
                x++;
                y++;
            } else if (array[x + 1][y] >= array[x][y + 1]) x++;
            else y++;
        }
        return subSequence.toString();
    }

    /**
     * Наибольшая возрастающая подпоследовательность
     * Сложная
     *
     * Дан список целых чисел, например, [2 8 5 9 12 6].
     * Найти в нём самую длинную возрастающую подпоследовательность.
     * Элементы подпоследовательности не обязаны идти подряд,
     * но должны быть расположены в исходном списке в том же порядке.
     * Если самых длинных возрастающих подпоследовательностей несколько (как в примере),
     * то вернуть ту, в которой числа расположены раньше (приоритет имеют первые числа).
     * В примере ответами являются 2, 8, 9, 12 или 2, 5, 9, 12 -- выбираем первую из них.
     */
    //Трудоемкость = O(N^2)
    //Ресурсоемкость = O(N), N = list.size()
    public static List<Integer> longestIncreasingSubSequence(List<Integer> list) {
        int size = list.size();
        List<Integer> subSequence = new ArrayList<>();

        if (size == 0 || size == 1) return list;

        else if (size == 2) {
            if (list.get(0) > list.get(1)) {
                subSequence.add(list.get(0));
                return subSequence;
            }
            else return list;
        }

        else {
            int[] prevNumArray = new int[size];
            int[] lenghtsArray = new int[size];
            int k = 0;
            int count = -1;
            for (int i = 0; i < size; i++) {
                prevNumArray[i] = -1;
                lenghtsArray[i] = 0;
                for (int j = 0; j < i; j++){
                    if (list.get(j) < list.get(i) && lenghtsArray[j] + 1 > lenghtsArray[i]) {
                        prevNumArray[i] = j;
                        lenghtsArray[i] = lenghtsArray[j] + 1;
                    }
                }
                if (lenghtsArray[i] > count) {
                    count = lenghtsArray[i];
                    k = i;
                }
            }
            while (k >= 0) {
                subSequence.add(0, list.get(k));
                k = prevNumArray[k];
            }
        }
        return subSequence;
    }

    /**
     * Самый короткий маршрут на прямоугольном поле.
     * Средняя
     *
     * В файле с именем inputName задано прямоугольное поле:
     *
     * 0 2 3 2 4 1
     * 1 5 3 4 6 2
     * 2 6 2 5 1 3
     * 1 4 3 2 6 2
     * 4 2 3 1 5 0
     *
     * Можно совершать шаги длиной в одну клетку вправо, вниз или по диагонали вправо-вниз.
     * В каждой клетке записано некоторое натуральное число или нуль.
     * Необходимо попасть из верхней левой клетки в правую нижнюю.
     * Вес маршрута вычисляется как сумма чисел со всех посещенных клеток.
     * Необходимо найти маршрут с минимальным весом и вернуть этот минимальный вес.
     *
     * Здесь ответ 2 + 3 + 4 + 1 + 2 = 12
     */
    public static int shortestPathOnField(String inputName) {
        throw new NotImplementedError();
    }

    // Задачу "Максимальное независимое множество вершин в графе без циклов"
    // смотрите в уроке 5
}
