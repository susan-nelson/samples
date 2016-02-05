package com.susannelson;

/**
 * Assume there is an array of (positive) integers, of which each element is either +1 or -1 compared to its adjacent elements.
 * Now search for n and return its position.
 * http://stackoverflow.com/questions/34481582/efficient-way-to-search-an-element?newsletter=1&nlcode=526763%7c008b
 */
public class SearchPlusOneArray {

    public static void main(String[] args)
    {
        int arr[]={4,5,6,5,4,3,2,3,4,5,6,7,8};
        int pos=searchArray(arr,7);

        if(pos==-1)
            System.out.println("not found");
        else
            System.out.println("position="+pos);
    }

    public static int searchArray(int[] array,int value)
    {
        int i=0;
        int strtValue=0;
        int pos=-1;

        while(i<array.length)
        {
            strtValue=array[i];

            if(strtValue<value)
            {
                i+=value-strtValue;
            }
            else if (strtValue==value)
            {
                pos=i;
                break;
            }
            else
            {
                i+=strtValue-value;
            }
        }

        return pos;
    }
}
