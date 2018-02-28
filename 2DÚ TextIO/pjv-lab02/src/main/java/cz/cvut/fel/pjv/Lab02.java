/*
 * File name: Lab06.java
 * Date:      2014/08/26 21:39
 * Author:    @author
 */

package cz.cvut.fel.pjv;

import java.util.Scanner;

public class Lab02
{
    
    Scanner stdin = new Scanner(System.in);
    
    private String getLine()
    {
      return stdin.hasNext() ? stdin.nextLine() : "";
    }
    
    public static boolean isDouble(String s) {
        boolean ret = true;
        try { 
            Double.parseDouble(s); 
        }
        catch(NumberFormatException e) { 
            ret = false; 
        }
        return ret;
    }
    
    private void calculate(double[] numbers, int counter)
    {
        double ar;
        double std;
        double sum = 0;
        int numberOfNumbers = counter + 1;
        
        for (int i = 0; i < numberOfNumbers; i++)
        {
            sum += numbers[i];
        }
        ar = sum / numberOfNumbers;
        
        sum = 0;        
        for (int i = 0; i < numberOfNumbers; i++)
        {
            sum += (numbers[i] - ar) * (numbers[i] - ar);
        }
        std = Math.sqrt(sum / numberOfNumbers);
        
        System.out.printf("%2d %.3f %.3f\n", numberOfNumbers, ar, std);
    }
    
    private void homework()
    {        
        String nextLine;
        double[] numbers;
        numbers = new double[10];
        int numberOfLines = 1;
        int counter = 0;
        
        while (true)
        {
            nextLine = getLine();
            
            if ("".equals(nextLine) || "\n".equals(nextLine))
            {
                System.out.println("End of input detected!");
                if (counter > 1)
                {
                    calculate(numbers, counter - 1);
                }
                return;
            }
            
            if (isDouble(nextLine))
            {
                numbers[counter] = Double.parseDouble(nextLine);
                if (counter == 9)
                {
                    calculate(numbers, counter);
                    counter = 0;
                }
                else
                {
                    counter++;
                }
            }
            else
            {
                System.out.println("A number has not been parsed from line " + numberOfLines);
            }
            
            numberOfLines++;
        }
    }
    
    public void start(String[] args)
    {
        homework();
    }
}

/* end of Lab02.java */
