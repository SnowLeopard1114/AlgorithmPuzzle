import java.util.*;

public class AmazonMaximumUnits {
    public static void main(String[] args) {
        ArrayList<Integer> boxes = new ArrayList<>(Arrays.asList(1, 2, 4, 10));
        List<Integer> unitsPerBox = new ArrayList<>(Arrays.asList(5, 6, 7, 100));
        long truckSize = 4;
        long res = getMaxUnit(4, boxes, 4, unitsPerBox, 7);

        System.out.println(res);
    }
    public static long getMaxUnit(int num, ArrayList<Integer> boxes, int unitSize, List<Integer> unitsPerBox, long truckSize){
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < unitSize; i++){
            int boxIdx = boxes.get(i);
            int size = unitsPerBox.get(i);

            map.put(size, boxIdx);
        }

        Collections.sort(unitsPerBox, Collections.reverseOrder());

        long res = 0;

        for(int boxSize : unitsPerBox){
            if(truckSize == 0)
                return  res;

            int boxCount = map.get(boxSize);

            if(truckSize == (long) boxCount){
                res += (boxCount * boxSize);
                return res;
            }

            if(truckSize > boxCount){
                res += (boxCount * boxSize);
                truckSize -= boxCount;
            }else{
                res += (truckSize * boxSize);
                return res;
            }

        }

        return res;
    }
}
