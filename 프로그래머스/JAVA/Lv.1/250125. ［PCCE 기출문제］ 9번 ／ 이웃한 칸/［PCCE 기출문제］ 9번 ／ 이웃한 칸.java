class Solution {
    static int goX[] = {0, 1, -1, 0};
    static int goY[] = {1, 0, 0, -1};
    static int cnt = 0;
    public int solution(String[][] board, int h, int w) {
        String check = board[h][w];
        for(int i=0; i<4; i++){
            int newX = h+goX[i];
            int newY = w+goY[i];
            int N = board.length;
            if(newX < 0 || newX >= N || newY < 0 || newY >= N || !board[newX][newY].equals(check)){
                continue;
            }else{
                if(board[newX][newY].equals(check)){
                    cnt++;
                }
            }
        }
        int answer = cnt;
        return answer;
    }
}