package ru.artembulkhak.trainee.yandex;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputOutputExample {
    public static void main(String[] args) throws Exception {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        int a = Integer.parseInt(bufferedReader.readLine());
//        int b = Integer.parseInt(bufferedReader.readLine());
//        bufferedReader.close();
//
//        System.out.println(a+b);
//        --------------------------------
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String str = bufferedReader.readLine();
        bufferedReader.close();

//        ----------------- via files ---------------
//        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
//        String file = reader.readLine();
//        String[] nums = file.split(" ");
//        int sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            sum += Integer.parseInt(nums[i]);
//        }
//        FileWriter writer = new FileWriter("output.txt");
//        writer.write(String.valueOf(sum));
//        writer.flush();
    }
}
