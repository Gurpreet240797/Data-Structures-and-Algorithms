package Stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static void main (String args[]) {
        int[] temperature = {73,74,75,71,69,72,76,73};
        int[] result = dailyTemperaturesWrapper(temperature);
        System.out.println(Arrays.toString(result));
    }

    public static int[] dailyTemperaturesWrapper(int[] temperature){
        int[] response = new int[temperature.length];
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<temperature.length; i++) {
            while (!stack.isEmpty() && temperature[i] > temperature[stack.peek()]) {
                int prevDay = stack.pop();
                response[prevDay] = i - prevDay;
            }
            stack.add(i);
        }
        return response;
    }
}
