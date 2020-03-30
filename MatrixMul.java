class MatrixMul{
    public static void main(String[] args) {
        int dimens[] = {30,35,15,5,10,20,25};
        int matrixCount = dimens.length-1;
        int dp[][] = new int[matrixCount][matrixCount];
        bottomUp(dimens, dp);
        System.out.println(dp[0][5]);
        print(dp);
    }

    static void  print(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                System.out.print(" "+dp[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    static void bottomUp(int dimens[],int dp[][]){
        int diff= 0;
        for(int i=0;i<dimens.length-1;i++){
            for(int j=i;j<dimens.length-1;j++){
                // System.out.println((j-i)+" "+(j+i-diff));
                int row = j-i;
                int col = j+i-diff;
                dp[row][col] = Integer.MAX_VALUE;
                if(row == col)
                    dp[row][col] = 0;
                int q;
                for(int k=row;k<col;k++){
                    // if(row == 0)
                    q = dp[row][k]+dp[k+1][col]+(dimens[row]*dimens[k+1]*dimens[col+1]);
                    // else
                    // q = dp[row][k]+dp[k+1][col]+(dimens[row-1]*dimens[k]*dimens[col]);
                    if(dp[row][col] > q)
                        dp[row][col] =q;
                }

            }
            diff++;
        }
    }
}