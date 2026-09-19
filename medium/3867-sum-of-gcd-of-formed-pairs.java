class Solution {

    private static int gcd(int a, int b) {
        while (b != 0) {
            int rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }

    public long gcdSum(int[] nums) {
        int n = nums.length;

        int[] prefixGcd = new int[n];
        int mx = nums[0];

        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, nums[i]);
            prefixGcd[i] = gcd(nums[i], mx);
        }

        Arrays.sort(prefixGcd);

        int low = 0, high = n - 1;
        long sum = 0;

        while (low < high) {
            sum += gcd(prefixGcd[low], prefixGcd[high]);
            low++;
            high--;
        }
        return sum;
    }
}