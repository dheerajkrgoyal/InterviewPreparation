package com.interview.designguru.patterns.twopointers;

import java.util.Stack;

/**
 * Given two strings containing backspaces (identified by the character ‘#’),
 * check if the two strings are equal.
 *
 * Input: str1="xy#z", str2="xzz#"
 * Output: true
 * Explanation: After applying backspaces the strings become "xz" and "xz" respectively.
 *
 * Input: str1="xywrrmp", str2="xywrrmu#p"
 * Output: true
 * Explanation: After applying backspaces the strings become "xywrrmp" and "xywrrmp" respectively.
 *
 * Input: str1="xp#", str2="xyz##"
 * Output: true
 * Explanation: After applying backspaces the strings become "x" and "x" respectively.
 * In "xyz##", the first '#' removes the character 'z' and the second '#' removes the character 'y'.
 */
public class CompareStringWithBackSpace {
    public static void main(String[] args) {
        String str1 = "xp#";
        String str2 = "xyz##";

        System.out.println(compare(str1, str2));
        System.out.println(compare1(str1, str2));
    }

    /**
     * This method will run in O(N) time but uses o(N) extra space as well.
     * Since we are using stack and StringBuilder as extra space cam we eliminate it?
     * @param str1
     * @param str2
     * @return
     */
    private static boolean compare(String str1, String str2){
        str1 = simplify(str1);
        str2 = simplify(str2);
        return str1.equals(str2);
    }

    private static String simplify(String str){
        Stack<Character> stack = new Stack<>();
        for(char c: str.toCharArray()){
            if(c == '#' && !stack.isEmpty()){
                stack.pop();
            }
            else{
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }



    private static boolean compare1(String str1, String str2){
        int index1 = str1.length()-1;
        int index2 = str2.length()-1;
        while(index1>=0 && index2 >=0){
            int i1 = validChar(str1, index1);
            int i2 = validChar(str2, index2);
            if (i1<0 && i2<0){
                return true;
            }

            else if(i1<0 || i2<0){
                return false;
            }

            else if(str1.charAt(i1) != str2.charAt(i2) ){
                return false;
            }
            index1 = i1-1;
            index2 = i2-1;
        }
        return true;
    }

    private static int validChar(String str, int index){
        int bs = 0;
        while(index>=0){
            if(str.charAt(index) == '#'){
                bs++;
            }
            else if(bs>0){
                bs--;
            }
            else{
                break;
            }
            index--;
        }
        return index;
    }
}
