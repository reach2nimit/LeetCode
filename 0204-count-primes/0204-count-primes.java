class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        if(n<=1)
            return 0;
        isPrime[0] = false; isPrime[1]=false;
        int count = 0;
        for(int p = 2; p*p <=n ; p++){
            if(isPrime[p]){
                for(int i = p * p; i<=n; i+=p)
                    isPrime[i]=false;
            }
        }

        for(int i=2; i<n; i++)
            if(isPrime[i])
                count++;

        return count;
    }
}