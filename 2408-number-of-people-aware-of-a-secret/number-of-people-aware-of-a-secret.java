class Solution {
  public int peopleAwareOfSecret(int n, int delay, int forget) {
    final int MOD = 1_000_000_007;
    long nextsecret = 0;
    int[] dp = new int[n];
    dp[0] = 1;

    for (int i = 1; i < n; ++i) {
      if (i - delay >= 0)
        nextsecret += dp[i - delay];
      if (i - forget >= 0)
        nextsecret -= dp[i - forget];
      nextsecret += MOD;
      nextsecret %= MOD;
      dp[i] = (int) nextsecret;
    }

    int ans = 0;
    for (int i = n - forget; i < n; ++i)
      ans = (ans + dp[i]) % MOD;
    return ans;
  }
}