import java.util.*;

public class SupplierInventory {
    public static void main(String[] args) {
        List<Long> list = new ArrayList<>(Arrays.asList(3L, 5L));
        System.out.println(supplierInventory(2, list, 6L));

    }

    public static long supplierInventory(int numSupplier, List<Long> inventory, long order){
        /*
        Map<Long, Long> map = new HashMap<>();
        long highest = 0;
        long profit = 0;

        for(int i = 0; i < inventory.size(); i++){
            map.put(inventory.get(i), map.getOrDefault(inventory.get(i), 0L) + 1);
            if(highest < inventory.get(i))
                highest = inventory.get(i);
        }

        while(order > 0 && !map.isEmpty()){
            long highestFreq = map.get(highest);
            if(order > highestFreq){
                profit += highestFreq * highest;
                order -= highestFreq;
                map.remove(highest);
                map.put(highest - 1, map.getOrDefault(highest - 1, 0L) + highestFreq);
                highest --;
            }else{
                profit += highest * order;
                order = 0;
            }
        }

        return profit;
        */
        Map<Long, Long> map = new HashMap<>();
        long highest = 0;
        long profit = 0;

        for(int i = 0; i < inventory.size(); i++){
            map.put(inventory.get(i), map.getOrDefault(inventory.get(i), 0L) + 1);
            if(highest < inventory.get(i))
                highest = inventory.get(i);
        }

        while(order > 0 && !map.isEmpty()){
            long freq = map.get(highest);
            if(order > freq){
                profit += freq * highest;
                order -= freq;
                map.remove(highest);
                map.put(highest - 1, map.getOrDefault(highest - 1, 0L) + freq);
                highest --;
            }
            else{
                profit += order * highest;
                order = 0;
            }
        }

        return profit;
    }
}
