package com.john.javaTesting;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class LetterService {
    public static List<LetterGridOutput> create(LetterSpecification letterinput) {
        List<LetterGridOutput> outputs = new ArrayList<>();
        String letter = letterinput.getLetters();
        int size = letterinput.getSize();

        String[] l = letter.split("");
        for (String s : l) {
            LetterGridOutput letterGridOutput = new LetterGridOutput();
            List<String> letterGrid = new ArrayList<>();
            switch (s.toUpperCase()) {
                case "X":
                    for (int row = 0; row < size; row++) {
                        StringBuffer a = new StringBuffer("");
                        for (int column = 0; column < size; column++) {
                            if (row == column || column == size - 1 - row) {
                                a.append("*");
                                System.out.print("*");
                            } else {
                                a.append(" ");
                                System.out.print(" ");
                            }
                        }
                        System.out.println("");
                        letterGrid.add(a.toString());
                    }
                    break;
                case "Y":
                    int mid = size / 2;
                    for (int row = 0; row < size; row++) {
                        StringBuffer a = new StringBuffer("");
                        for (int column = 0; column < size; column++) {
                            if (column == mid && row >= mid) {
                                a.append("*");
                                System.out.print("*");
                            } else if (row < mid && (row == column || column == size - 1 - row)) {
                                a.append("*");
                                System.out.print("*");
                            } else {
                                a.append(" ");
                                System.out.print(" ");
                            }
                        }
                        System.out.println("");
                        letterGrid.add(a.toString());
                    }
                    break;
                case "Z":
                    for (int row = 0; row < size; row++) {
                        StringBuffer a = new StringBuffer("");
                        for (int column = 0; column < size; column++) {
                            if (row == 0 || row == size - 1 || column == size - 1 - row) {
                                a.append("*");
                                System.out.print("*");
                            } else {
                                a.append(" ");
                                System.out.print(" ");
                            }
                        }
                        System.out.println("");
                        letterGrid.add(a.toString());
                    }
                    break;
            }
            letterGridOutput.setLetterGrid(letterGrid);
            outputs.add(letterGridOutput);
        }
        return outputs;
    }

    public static void main(String[] args) {
        LetterSpecification input = new LetterSpecification();
        input.setLetters("y");
        input.setSize(5);
        create(input);
    }
}
