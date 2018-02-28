package cz.cvut.fel.pjv;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class Lab01 {
   
    private void homework()
    {
        Locale.setDefault(new Locale("en", "US"));
        
        System.out.println("Vyber operaci (1-soucet, 2-rozdil, 3-soucin, 4-podil):");
        Scanner scanner = new Scanner(System.in);
        
        int operationNumber = scanner.nextInt();
        double x;
        double y;
        int decimals;
        double result = 0;
        
        switch(operationNumber)
        {
            case 1:
                System.out.println("Zadej scitanec: ");
                x = scanner.nextDouble();
                System.out.println("Zadej scitanec: ");
                y = scanner.nextDouble();
                break;
            case 2:
                System.out.println("Zadej mensenec: ");
                x = scanner.nextDouble();
                System.out.println("Zadej mensitel: ");
                y = scanner.nextDouble();
                break;
            case 3:
                System.out.println("Zadej cinitel: ");
                x = scanner.nextDouble();
                System.out.println("Zadej cinitel: ");
                y = scanner.nextDouble();
                break;
            case 4:
                System.out.println("Zadej delenec: ");
                x = scanner.nextDouble();
                System.out.println("Zadej delitel: ");
                y = scanner.nextDouble();
                if (y == 0)
                {
                    System.out.println("Pokus o deleni nulou!");
                    return;
                }
                break;
            default:
                System.out.println("Chybna volba!");
                return;
        }
        
        System.out.println("Zadej pocet desetinnych mist: ");
        decimals = scanner.nextInt();
        if (decimals < 0)
        {
            System.out.println("Chyba - musi byt zadane kladne cislo!");
            return;
        }
        
        String formatinString = "0";
        if (decimals > 0)
        {
            formatinString += ".";
        }
        int i;
        for (i = 0; i < decimals; i++)
        {
            formatinString += "0";
        }
        DecimalFormat decimalFormat = new DecimalFormat(formatinString);
        
        String operationSymbol = "";
        switch(operationNumber)
        {
            case 1:
                result = x + y;
                operationSymbol = " + ";
                break;
            case 2:
                result = x - y;
                operationSymbol = " - ";
                break;
            case 3:
                result = x * y;
                operationSymbol = " * ";
                break;
            case 4:
                result = x / y;
                operationSymbol = " / ";
                break;
        }
        
        System.out.printf("%." + String.valueOf(decimals) + "f%s%." + String.valueOf(decimals) + "f = %." + String.valueOf(decimals) + "f\n", x, operationSymbol, y, result);
    }
    
   public void start(String[] args) {
     homework();
   }
}