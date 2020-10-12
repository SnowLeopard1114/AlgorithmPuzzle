public class CuttingMetalSurplus {
    static int maxProfit(int costPerCut, int salePrice, int[] lengths)
    {
        int max = 0;
        for(int i : lengths){   //find out the max one
            if(i > max){
                max = i;
            }
        }

        long maxRevenue = 0;

        while(max > 0){
            int len = max;
            int totalCuts = 0;
            int peices = 0;

            for(int wood : lengths){

                if(wood < len)
                    continue;

                boolean extra = false;
                int extraCut = 0;
                while(wood%len != 0){
                    extra = true;
                    wood--;
                }
                if(extra){
                    extraCut = 1;
                }

                int regularCut = wood/len - 1;

                if((len*(wood/len)*salePrice)-(regularCut+extraCut)*costPerCut < 0){
                    continue;
                }

                totalCuts += extraCut + regularCut;

                peices += wood/len;
            }

            long revenue = peices*len*salePrice - totalCuts*costPerCut;

            if(revenue > maxRevenue){
                maxRevenue = revenue;
            }

            max--;
        }

        return (int)maxRevenue;
    }


    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        int[] lengths={26,103,59};
        System.out.println(maxProfit(1,10,lengths));
    }
}
