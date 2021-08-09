package niraj.biweekly.biweekly58;

/**
 * Created on:  Aug 07, 2021
 * Ref : https://leetcode.com/contest/biweekly-contest-58/problems/delete-characters-to-make-fancy-string/
 */
public class DeleteCharactersToMakeFancyString {
    public static void main(String[] args) {

    }
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        char pre = ' ';
        int count = 0;
        for(char cur: s.toCharArray()){
            if(cur == pre){
                count++;
                if(count < 3){
                    sb.append(cur);
                }
            }else{
                sb.append(cur);
                pre = cur;
                count =1;
            }
        }
        return sb.toString();
    }
}
