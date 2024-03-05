package src.main.java;
import java.lang.String;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class ParenSymmetry {


    private Boolean isBalanced(String s) {
        // implement this method
        int openNumber = 0;
        int closeNumber = 0;
        for(int i =0; i<=s.length()-1;i++){
            if(s.charAt(i)=='('){
                openNumber++;
            }
            if(s.charAt(i)==')'){
                closeNumber++;
            }
        }
        if(openNumber == closeNumber){
            return true;
        }
        else
            return false;

    }

    private void checkFile(String filename) {
        // open file named filename
        try{
        File myObj = new File("/Users/diksha/Desktop/Projects/ParenSymmetry/TestStrings1.txt");

        // for each line in the file
        Scanner myReader = new Scanner (myObj);
            // read the line
        while (myReader.hasNext()){
            String data = myReader.nextLine();
            System.out.println(data);
        }
        myReader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("An error occured");
            e.printStackTrace();
        }


            // print whether or not the line's parenthesis are balanced

        // CLOSE the file
    }

    public static void main(String[] args) {
        ParenSymmetry ps = new ParenSymmetry();

        Boolean b0 = ps.isBalanced("()");
        printResult(b0, true);

        String[] falseStrings = {"(", "((", ")", "", "(()())((())))"};
        Boolean falses = true;
        for (String strToTest : falseStrings) {
            falses = ps.isBalanced(strToTest);
        }
        printResult(falses, false);

        String[] trueStrings = {"()", "(())", "(((())))", "", "(()())((()))", "(   )", "( () ( ) )"};
        Boolean trues = false;
        for (String strToTest : trueStrings) {
            trues = ps.isBalanced(strToTest);
        }
        printResult(trues, true);

    }

    private static void printResult(Boolean b0, boolean b) {
        if (b0 == null) {
            System.out.println("Null Failure");
            return;
        }
        if (b0 == b) {
            System.out.println("Success");
        } else {
            System.out.println("Failure");
        }
    }
}
