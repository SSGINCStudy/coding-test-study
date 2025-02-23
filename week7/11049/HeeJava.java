import java.io.*;
import java.util.StringTokenizer;

public class 행렬곱셈순서{
    /*
        11049 / 208ms
     */
    public static int[][] matrix;		//행렬의 크기 저장 배열
    public static int[][] DP = new int[501][501];		//행렬의 곱 최소 연산 수 저장 배열
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        matrix = new int[N+1][2];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }
        matrixMul(N);
        bw.write(DP[1][N] + "");
        bw.flush();
        bw.close();
        br.close();
    }
    //---------행렬 곱셈의 연산의 수 최고값 구하는 함수--------
    public static void matrixMul(int N) {
        for(int i = 2; i <= N; i++) {		//목적지
            for(int j = i-1; j > 0; j--) {		//출발지
                DP[j][i] = Integer.MAX_VALUE;
                for(int s = j; s < i; s++) {		//중간 지점
                    //행렬의 곱셈 연산 수
                    int temp = matrix[j][0] * matrix[s][1] * matrix[i][1];
                    //최소값 구하기
                    DP[j][i] = Math.min(DP[j][i], DP[j][s] + DP[s+1][i] + temp);
                }
            }
        }
    }
}