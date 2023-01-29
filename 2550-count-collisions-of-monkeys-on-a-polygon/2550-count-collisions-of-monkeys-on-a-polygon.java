import java.math.BigInteger;

class Solution {
    public int monkeyMove(int n) {
		int mod = 1000_000_007;
		BigInteger powMod = BigInteger.valueOf(2).modPow(BigInteger.valueOf(n), BigInteger.valueOf(mod));
		int ans = powMod.intValue()-2 + mod;
		return ans % mod;
    }
}