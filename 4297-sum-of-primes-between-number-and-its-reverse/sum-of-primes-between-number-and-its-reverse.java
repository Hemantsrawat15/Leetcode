class Solution {
    public int sumOfPrimesInRange(int n) {
        int num1 = n;
        int num2 = reverse(n);
        if(num1>num2){
            return findSum(num2,num1);
        }
        return findSum(num1,num2);
    }

    public static int findSum(int num1,int num2){
        int sum = 0;
        for(int i = num1;i<=num2;i++){
            if(isPrime(i)) sum+=i; 
        }
        return sum;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static int reverse(int n) {
        int reversed = 0;
        while (n > 0) {
            reversed = reversed * 10 + (n % 10);
            n /= 10;
        }
        return reversed;
    }
}