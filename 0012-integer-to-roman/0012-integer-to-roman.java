class Solution {

    private static final int[] VALUES = {1000,500, 100, 50, 10, 5, 1};
    private static final String[] SYMBOLS = {"M","D", "C", "L", "X", "V", "I"};

    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();

        for(int i=0; i<VALUES.length; i++){
            int value = VALUES[i];
            String symbol = SYMBOLS[i];

            while(num>=value){
                result.append(symbol);
                num-=value;
            }

            int subIndex = ( i % 2 ==0 ) ? i+2 : i+1;

            if(subIndex < VALUES.length){
                int subValue = VALUES[i] - VALUES[subIndex];
                if(num >= subValue){
                    result.append(SYMBOLS[subIndex]).append(symbol);
                    num-=subValue;
                }
            }
        }

        return result.toString();
    }
}