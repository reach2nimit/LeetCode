//good problem check it 
class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] candies = new int[len];
        //imp step check it
        Arrays.fill(candies, 1);

        for(int i = 1; i<len; i++)
            if(ratings[i] > ratings[i-1])
                candies[i] = candies[i-1] + 1;
        
        int result = candies[len - 1];

        for(int i = len-2; i>=0; i--){
            if(ratings[i] > ratings[i+1])
                candies[i] = Math.max(candies[i], candies[i+1]+1);
                result+=candies[i];
        }

        return result;
    }
}