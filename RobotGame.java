//input would be a string[], calculate the total score
//sample: [5, -2, 4, Z, X, 9, +, +]
//Integer : just add to the score
//Z:remove last round
//X:Double the score of the last round
//+:Add score of the previous 2 round to the total socre

import java.util.ArrayList;
import java.util.List;

public class RobotGame {
    public static void main(String[] args) {
        String[] input = new String[8];
        input[0] = "5";
        input[1] = "+";
        input[2] = "1";
        input[3] = "+";
        input[4] = "1";
        input[5] = "1";
        input[6] = "1";
        input[7] = "1";

        int res = foo(input);
        System.out.println(res);
    }

    private static int foo(String[] input){
        if(input == null || input.length == 0)
            return 0;

        int total = 0;
        List<Integer> record = new ArrayList<>();
        for(String str : input){
            int add = 0;
            if(str.equals("X")){
                add = record.get(record.size() - 1) * 2;
                total += add;
                record.add(add);
            }
            else if(str.equals("Z")){
                total -= record.get(record.size() - 1);
                record.remove(record.size() - 1);
            }
            else if(str.equals("+")){
                if(record.size() >= 2){
                    add = record.get(record.size() - 1) + record.get(record.size() - 2);
                    total += add;
                }
                else if(record.size() == 1) {
                    add = record.get(record.size() - 1);
                    total += add;
                }
                record.add(add);
            }
            else{
                total += Integer.parseInt(str);
                record.add(Integer.parseInt(str));
            }
        }

        return total;
    }
}
