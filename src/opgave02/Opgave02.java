package opgave02;

import java.util.ArrayList;

public class Opgave02 {
    public static void main(String[] args) {


        System.out.println(checkParantes("HEJ^()[]{}HEJSA/123"));
    }

    private static Boolean isValid = true;

    public static Boolean checkParantes(String s) {


        //Normal parantehis ()
        int nParanLengthIndex = 0;
        int nParanCurIndex = 0;
        ArrayList<ArrayList<Boolean>> nParantes = new ArrayList<ArrayList<Boolean>>();

        //Square brackets parantheis []
        int sParanLengthIndex = 0;
        int sParanCurIndex = 0;
        ArrayList<ArrayList<Boolean>> sParantes = new ArrayList<ArrayList<Boolean>>();

        //Tuborg brackets {}
        int tParanLengthIndex = 0;
        int tParanCurIndex = 0;
        ArrayList<ArrayList<Boolean>> tParantes = new ArrayList<ArrayList<Boolean>>();

        //Replace everything except ()[]{}
        String paranOnly = s.replaceAll("[^\\(\\)\\[\\]\\{\\}]", "");

        outerloop:
        for (int charIndex = 0; charIndex < paranOnly.length(); charIndex++) {

            if (!isValid) {
                break outerloop;
            }

            char curChar = paranOnly.charAt(charIndex);

            if (curChar == '(') {
                startOpenParan(nParantes, nParanLengthIndex);
                nParanLengthIndex++;
            } else if (curChar == ')') {

                if (checkClosingParan(nParanCurIndex, nParanLengthIndex, nParantes)) {
                    nParanCurIndex++;
                }
            } else if (curChar == '[') {
                startOpenParan(sParantes, sParanLengthIndex);
                sParanLengthIndex++;

            } else if (curChar == ']') {

                if (checkClosingParan(sParanCurIndex, sParanLengthIndex, sParantes)) {
                    sParanCurIndex++;
                }

            } else if (curChar == '{') {
                startOpenParan(tParantes, tParanLengthIndex);
                tParanLengthIndex++;
            } else if (curChar == '}') {
                if (checkClosingParan(tParanCurIndex, tParanLengthIndex, tParantes)) {
                    tParanCurIndex++;
                }
            }
        }

        if (nParanCurIndex != nParanLengthIndex || sParanCurIndex != sParanLengthIndex || tParanCurIndex != tParanLengthIndex) {
            isValid = false;
        }

        return isValid;
    }

    private static Boolean checkClosingParan(int cur, int length, ArrayList<ArrayList<Boolean>> list) {
        boolean toReturn = false;

        if (cur < length) {
            list.get(cur).add(true);
            toReturn = true;
        } else {
            isValid = false;
        }
        return toReturn;

    }


    private static void startOpenParan(ArrayList<ArrayList<Boolean>> list, int paranLengthIndex) {
        list.add(new ArrayList<Boolean>());
        list.get(paranLengthIndex).add(true);
    }


}

