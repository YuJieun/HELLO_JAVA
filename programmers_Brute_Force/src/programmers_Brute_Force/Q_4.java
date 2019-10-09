package programmers_Brute_Force;

class Q_4 {
    public int[] solution(int brown, int red) {
        int[] answer = new int[2];
        for(int i=1; i<=red; i++){
            //i를 red가로로 생각
            if(red%i==0 && i>=red/i){
                int red_hor = i;
                int red_ver = red/i;
                
                int tmp = (red_hor+2)*(red_ver+2) - red;
                if(tmp==brown){
                    answer[0] = red_hor+2;
                    answer[1] = red_ver+2;
                    break;
                }
            }              
        }        
        return answer;
    }
}