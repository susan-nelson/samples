package com.susannelson;

/**
 * Implement C strstr in Java. Find the first instance of a string in another string.
 * Solution from http://www.mytechinterviews.com/implement-strstr
 */
public class StrStr {

    public int search(String haystack, String needle){
        for(int i = 0; i < haystack.length(); i++ ) {
            for(int j = 0; j < needle.length() &&
                    i+j < haystack.length(); j++ ) {
                if(needle.charAt(j) != haystack.charAt(i+j)) {
                    break;
                } else if (j == needle.length()-1) {
                    return i;
                }
            }
        }
        return -1;
    }
}
