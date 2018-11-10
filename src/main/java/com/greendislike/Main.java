package com.greendislike;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //or BufferedReader
        Scanner input = new Scanner(System.in);
        String lineNew;

        while (input.hasNextLine()) {
            lineNew = input.nextLine();
            if (!lineNew.isEmpty()) {
                String transl = Translator.translate(lineNew);
                System.out.println(transl);
            }
        }





//        //or BufferedReader
//        Scanner input = new Scanner(System.in);
//        //List<String> lines = new ArrayList<>();
//        String lineNew;
//
//        while (input.hasNextLine()) {
//            lineNew = input.nextLine();
////            if ("q".equals(lineNew)) {
////                System.out.println("Exit!");
////                break;
////            }
//            //lines.add(lineNew);
//        }
//
//        //System.out.println("Content of List<String> lines:");
//        //lines.stream().forEach(System.out::println);
//
//        String longString = new String();
//        for (String string : lines) {
//            if (!string.isEmpty()) {
//                String transl = Translator.translate(longString);
//                System.out.println(transl);
//            }
//        }

    }
}
