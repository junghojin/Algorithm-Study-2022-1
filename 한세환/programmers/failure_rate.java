import java.util.Collections;

import java.util.ArrayList;



class Solution {

    public int[] solution(int N, int[] stages) {

        int[] answer = new int[N];

        double[] stage = new double[N+1];  
        for(int i : stages){

            if(i == N+1){

                continue;

            }

            stage[i]++;

        }

        ArrayList<Double> fail = new ArrayList<Double>();


        double num =stages.length;
        double tmp = 0;

        for(int i=1; i<stage.length; i++){

            tmp = stage[i];
            if(num == 0){

                stage[i]=0;

            }else{

                stage[i] = stage[i]/num;

                num = num - tmp;

            }

            fail.add(stage[i]);

      }

     Collections.sort(fail,Collections.reverseOrder());

     for(int i=0; i<fail.size(); i++){

         for(int j=1; j<stage.length; j++){

             if(fail.get(i) == stage[j]){

                 answer[i] = j;

                 stage[j] = -1;

                 break;

            }

        }

    }

    return answer;

    }

}