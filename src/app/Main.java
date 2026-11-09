package app;

import java.util.Random;

public class Main {
    public static void main(String[] args){
        int[] numbers = new int[20];
        Random random = new Random();

        System.out.printf("Елементи масиву: ");
        for (int i = 0; i < numbers.length; i++){
            numbers[i] = random.nextInt(201) - 100;
            System.out.print(numbers[i] + " ");
        }

        int negativeSum = 0;
        int oddCount = 0;
        int evenCount = 0;

        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] < 0){
                negativeSum += numbers[i];
            }
            if (numbers[i] % 2 == 0){
                evenCount++;
            }
            else{
                oddCount++;
            }
        }

        int max = numbers[0];
        int maxIndex = 0;
        int min = numbers[0];
        int minIndex = 0;

        for (int i = 1; i < numbers.length; i++){
            if (numbers[i] > max){
                max = numbers[i];
                maxIndex = i;
            }
            else if (numbers[i] < min){
                min = numbers[i];
                minIndex = i;
            }
        }

        int firstNegativeIndex = -1;
        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] < 0){
                firstNegativeIndex = i;
                break;
            }
        }

        double average = 0;

        if (firstNegativeIndex == -1){
            System.out.println("Від'ємних чисел немає");
        } else {
            int sumAfterNegative = 0;
            int countAfterNegative = 0;

            for (int i = firstNegativeIndex + 1; i < numbers.length; i++){
                sumAfterNegative += numbers[i];
                countAfterNegative++;
            }
            average = (double) sumAfterNegative / countAfterNegative;
        }

        System.out.println();
        System.out.println("Сума від'ємних чисел: " + negativeSum);
        System.out.println("Кількість парних чисел: " + evenCount);
        System.out.println("Кількість непарних чисел: " + oddCount);
        System.out.println("Найменший елемент: " + min + "(з індексом " + minIndex + ")");
        System.out.println("Найбільший елемент: " + max + "(з індексом " + maxIndex + ")");
        System.out.println(String.format("Середнє арифметичне чисел після першого від'ємного числа: " + String.format("%.2f", average)));

    }
}