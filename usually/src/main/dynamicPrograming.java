package main;

public class dynamicPrograming {
    public static void main(String[] args) {
        int[] a={1,2,4};
        dynamicPrograming dp=new dynamicPrograming();
        int c=dp.countWay(a,3,3);
        System.out.println("the answer is "+c);
    }

    /**
     * 这个例子是错误的
     * @param penny
     * @param n
     * @param aim
     * @return
     */
    public int countWay(int[] penny,int n,int aim){
        //dp[n][m]表示使用前n中金额凑成m的种数
        int[][] dp=new int[n][aim+1];
        //初始化，所有能组成金额0的都置为1
        for(int i=0;i<n;i++){
            dp[i][0]=1;
        }
        //初始化
        for(int i=1;penny[0]*i<=aim;i++){
            dp[0][penny[0]*i]=1;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<aim;j++){
                if(j>=penny[i]){
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-penny[i]];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<aim+1;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[n-1][aim];
    }
}
