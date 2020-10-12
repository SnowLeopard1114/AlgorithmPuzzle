import java.util.*;
public class AmazonFetchItemToDisplay {
    public static List<String> fetchItemsToDisplay(String[][] items, int sortParameter, int sortOrder, int x, int y) {
        int start = x * y;
        if(start > items.length){
            return null;
        }
        Arrays.sort(items, new Comparator<String[]>(){
            @Override
            public int compare(String[] o1, String[] o2) {
                if(sortParameter == 0){ //sort by name
                    if(sortOrder == 0)
                        return o1[0].compareTo(o2[0]);
                    else
                        return o2[0].compareTo(o1[0]);
                }
                int num1 = Integer.parseInt(o1[sortParameter]);
                int num2 =Integer.parseInt(o2[sortParameter]);

                if(sortOrder == 0)
                    return num1 - num2;
                else
                    return num2 - num1;
            }
        });
        List<String> res = new ArrayList<>();
        for(int i = 0; i < x && start + i < items.length; i ++){
            res.add(items[start + i][0]);
        }
        return res;
    }
    public static void main(String[] args) {
        String[][] items = new String[3][3];
        items[0] = new String[]{"Item1", "3", "5"};
        items[1] = new String[]{"Item2", "32", "15"};
        items[2] = new String[]{"Item3", "30", "3"};
        System.out.println(fetchItemsToDisplay(items, 0, 0,1,0));

    }
}
