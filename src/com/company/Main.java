package com.company;

import java.util.Scanner;

interface Operation {
    boolean isEqual(int n, int m);
}

class OperationSort{
    static boolean sortAscend(int n, int m){
        return n < m;
    }
    static boolean sortDescend(int n, int m){
        return n > m;
    }
}

public class Main {

    public static void selectionSort(int[] sortArr, Operation Sort) {
        for (int i = 0; i < sortArr.length; i++) {
            int num_id = i;
            int num = sortArr[i];
            for (int j = i + 1; j < sortArr.length; j++) {
                if (Sort.isEqual(sortArr[j],num)) {
                    num_id = j;
                    num = sortArr[j];
                }
            }
            sortArr[num_id] = sortArr[i];
            sortArr[i] = num;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int[] nums = new int[in.nextInt()];
        for (int i = 0; i < nums.length; i++){
            System.out.printf("Введите %d элемент: ", i + 1);
            nums[i] = in.nextInt();
        }
        System.out.println("Выберите вид сортировки: \n1) по возрастанию \n2) по убыванию");
        int input = in.nextInt();
        if (input == 1){
            selectionSort(nums, OperationSort::sortAscend);
        }
        else if (input == 2){
            selectionSort(nums, OperationSort::sortDescend);
        }
        else{
            System.out.println("Ошибка");
        }
        for (int j : nums) {
            System.out.print(j + " ");
        }
    }
}
