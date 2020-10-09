package com.example.myapplication;

public class Calculater {


    public String addNumber(String num,String number){

        number+=num;
        //number+=Integer.parseInt(num);
        return number;
    }



    public double cal(String a,String b,String symbol) throws Exception{

        String N=String.valueOf(Double.MAX_VALUE);
        if(a.length()>N.length()||b.length()>N.length()){
            ArithmeticException arithmeticException= new ArithmeticException();
            throw  arithmeticException;
        }

        double num1=toDouble(a);
        double num2=toDouble(b);

        try{
            switch (symbol){
                case "+":
                    return num1+num2;
                case "-":
                    return num1-num2;
                case "*":
                    return num1*num2;
                case "/":
                    if(num2==0){
                        return -1;
                    }
                    return num1/num2;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return -1;
    }


    public static double toDouble(String str) {

        if (str == null || "".equals(str.trim())) {
            return 0;
        }
        str = str.trim();
        boolean isMinus = false;
        if (str.startsWith("-")) {
            isMinus = true;
            str = str.substring(1);
        }

        double result = 0;
        String[] strNumArr = str.split("\\.");

        int intNumResult = 0;
        for (int i = 0; i < strNumArr[0].length(); i++) {
            int val = strNumArr[0].charAt(i) - '0';
            if (val < 0 || val > 9) {
                intNumResult /= 10;
                continue;
            }

            intNumResult += val * makeInteger10N(strNumArr[0].length() - i - 1);
        }

        int decimalNumResult = 0;
        if (strNumArr.length > 1) {

            int numNaN = 0;

            for (int i = 0; i < strNumArr[1].length(); i++) {
                int val = strNumArr[1].charAt(i) - '0';
                if (val < 0 || val > 9) {

                    decimalNumResult /= 10;
                    numNaN++;
                    continue;
                }

                decimalNumResult += val * makeInteger10N(strNumArr[1].length() - i - 1);
            }

            result = decimalNumResult * makeDecimal01N(strNumArr[1].length() - numNaN);
        }
        result += intNumResult;

        if (isMinus) {
            result *= -1;
        }
        return result;
    }

    private static int makeInteger10N(int n) {
        int i = 1;
        for (int j = 0; j < n; j++) {
            i *= 10;
        }
        return i;
    }

    private static double makeDecimal01N(int n) {
        double i = 1;
        for (int j = 0; j < n; j++) {
            i /= 10;
        }
        return i;
    }

}
