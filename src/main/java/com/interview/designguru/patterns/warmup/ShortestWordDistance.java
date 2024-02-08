package com.interview.designguru.patterns.warmup;

/**
 * Given an array of strings words and two different strings that already exist in the array word1
 * and word2, return the shortest distance between these two words in the list.
 *
 * Input: words = ["a", "c", "d", "b", "a"], word1 = "a", word2 = "b"
 * Output: 1
 * Explanation: The shortest distance between "a" and "b" is 1 word. Please note that "a" appeared twice.
 *
 * Input: words = ["the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"],
 * word1 = "fox", word2 = "dog"
 * Output: 5
 * Explanation: The distance between "fox" and "dog" is 5 words.
 */
public class ShortestWordDistance {
    public static void main(String[] args) {
        String[] words = {"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        String word1 = "fox";
        String word2 = "dog";
        System.out.println(shortestDistance(words, word1, word2));
        words = new String[]{"a", "c", "d", "b", "a"};
        word1 = "a";
        word2 = "b";
        System.out.println(shortestDistance(words, word1, word2));
    }

    private static int shortestDistance(String[] words, String word1, String word2){
        int firstIndex = -1;
        int secondIndex = -1;
        int minDistance = Integer.MAX_VALUE;
        for(int i = 0; i< words.length; i++){
            if(words[i].equals(word1)){
                firstIndex = i;
            }

            if(words[i].equals(word2)){
                secondIndex = i;
            }

            if(firstIndex != -1 && secondIndex != -1){
                minDistance = Math.min(minDistance, Math.abs(firstIndex-secondIndex));
            }
        }

        return minDistance;
    }
}
