import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class UILogic{

    public static void main(String[] args) {
        new UIGui();
    }


    //process
    public double myProcess(String notation){
        ArrayList<String> notationList = myNotationList(notation);
        System.out.println(notationList);//prints separated numbers and operators

        ArrayList<String> resultList = myResultNotation(notationList);//final answer
        String resultString = String.join("",resultList);//list to string
        if(resultString.contains("Infinity")){
            JOptionPane.showMessageDialog(null,"Output is Infinity", "Information",JOptionPane.INFORMATION_MESSAGE);
        }
        double resultDouble = Double.parseDouble(resultString);//string to double


        //variables to check if resultDouble is double or integer
        int div = resultString.indexOf(".");//checks index of decimal point exist
        int numOne = Integer.parseInt(String.valueOf(resultString.charAt(div+1)));
        int numTwo = Integer.parseInt(String.valueOf(resultString.charAt(div+2)));



        //prints out double if list contains double else integer
        if(numOne>0||numTwo>0){
            System.out.println("Answer is: "+String.format("%.2f",resultDouble));

        }else {
            System.out.println("Answer is: "+ (int) resultDouble);
        }
        return resultDouble;
    }




    public ArrayList<String> myResultNotation(ArrayList<String> notationList){
        //continues until list length = 0
        while (notationList.size()>1){
            //in order of operation;
            if(notationList.contains("^")){
                myPow(notationList);

                // Product and Quotient
            }else if(notationList.contains("*")&&notationList.contains("/")){
                //order if two same value operation exist in same notation
                int product = notationList.indexOf("*");
                int quotient = notationList.indexOf("/");
                if(product<quotient){
                    myPro(notationList);
                    myDiv(notationList);
                }else {
                    myDiv(notationList);
                    myPro(notationList);
                }
            } else if (notationList.contains("*")){
                myPro(notationList);
            } else if (notationList.contains("/")) {
                myDiv(notationList);

                // Sum and Difference
            }else if(notationList.contains("+")&&notationList.contains("-")){
                //order if two same value operation exist in same notation
                int sum = notationList.indexOf("+");
                int diff = notationList.indexOf("-");
                if(sum<diff){
                    mySum(notationList);
                    myDiff(notationList);
                }else {
                    myDiff(notationList);
                    mySum(notationList);
                }
            } else if (notationList.contains("+")){
                mySum(notationList);
            } else {
                myDiff(notationList);
            }

        }
        return notationList;//returns out remaining elements in list
    }






    public ArrayList<String> myNotationList(String notation){
        ArrayList<String> notationList = new ArrayList<>();

        String isDigit = "";
        //separate numbers from operations
        for(int i=0;i<notation.length();i++){
            if(Character.isDigit(notation.charAt(i))||notation.charAt(i)=='.'){
                isDigit += notation.charAt(i);// concatenate a char to isDigit
                if(i==(notation.length()-1)){//this adds last number in notation;
                    notationList.add(isDigit);
                }
            }else {
                if(notation.charAt(0)=='-'&&i==0){//checks if notation starts with a negative
                    isDigit += "-";//assigns a negative sign to isDigit
                }else {
                    notationList.add(isDigit);//add isDigit to list
                    notationList.add(String.valueOf(notation.charAt(i)));//add operator to the list
                    notationList.remove("");// remove blank index in list(helps if notation starts with negative)
                    isDigit = "";//resets the value of isDigit
                }
            }
        }

        //returns a separated numbers and operators
        return notationList;
    }





    //call Exponent Function
    public ArrayList<String> myPow(ArrayList<String> notationList){//[x,^,y]
        int occurrences = Collections.frequency(notationList,"^");
        int div;
        if(occurrences>1){
            div = notationList.lastIndexOf("^");//gets index of ^: 1
        }else{
            div = notationList.indexOf("^");
        }
        double base = Double.parseDouble(notationList.get(div-1)); //parse numbers index of list [1-1]||[0]: x
        double exponent = Double.parseDouble(notationList.get(div+1));//parse numbers index of list [1+1]||[2]: y
        String c = String.format("%.2f",Math.pow(base,exponent));// gets pow of base and exponent: z
        notationList.add(div,c);//[x,z,/,y]
        notationList.remove(div+1);//[x,z,y]
        notationList.remove(div+1);//[x,z]
        notationList.remove(div-1);//[z]
        return notationList;//returns parameter list to an updated list
        //repeats in other operation
    }

    //call Division Function
    public ArrayList<String> myDiv(ArrayList<String> notationList){
        int div = notationList.indexOf("/");
        double a = Double.parseDouble(notationList.get(div-1));
        double b = Double.parseDouble(notationList.get(div+1));
        String c = String.format("%.2f", a/b);
        notationList.add(div,c);
        notationList.remove("/");
        notationList.remove(div+1);
        notationList.remove(div-1);
        return notationList;
    }

    //call Multiplication Function
    public ArrayList<String> myPro(ArrayList<String> notationList){
        int div = notationList.indexOf("*");
        double a = Double.parseDouble(notationList.get(div-1));
        double b = Double.parseDouble(notationList.get(div+1));
        String c = String.format("%.2f", a*b);
        notationList.add(div,c);
        notationList.remove("*");
        notationList.remove(div+1);
        notationList.remove(div-1);
        return notationList;
    }

    //call Addition Function
    public ArrayList<String> mySum(ArrayList<String> notationList){
        int div = notationList.indexOf("+");
        double a = Double.parseDouble(notationList.get(div-1));
        double b = Double.parseDouble(notationList.get(div+1));
        String c = String.format("%.2f", a +b);
        notationList.add(div,c);
        notationList.remove("+");
        notationList.remove(div+1);
        notationList.remove(div-1);
        return notationList;
    }

    //call Subtraction Function
    public ArrayList<String> myDiff(ArrayList<String> notationList){
        int div = notationList.indexOf("-");
        double a = Double.parseDouble(notationList.get(div-1));
        double b = Double.parseDouble(notationList.get(div+1));
        String c = String.format("%.2f", a -b);
        notationList.add(div,c);
        notationList.remove("-");
        notationList.remove(div+1);
        notationList.remove(div-1);
        return notationList;
    }
}
