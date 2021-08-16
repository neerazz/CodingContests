package weekly.weekly253;

/**
 * Created on:  Aug 08, 2021
 * Ref :
 */
public class MinimumNumberOfSwapsToMakeTheStringBalanced {
    public static void main(String[] args) {

    }
    public int minSwaps(String s) {
        int count =0;
        for(char c: s.toCharArray()){
            if(c == '['){
                count++;
            }else if(count > 0){
                count--;
            }
        }
        return (count +1)/2;
    }
}
