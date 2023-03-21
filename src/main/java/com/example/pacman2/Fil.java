package com.example.pacman2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Fil {
    public static int[][] hentKart(String filnavn) {

        File file = new File(filnavn);

        int colCount = 27;
        int rowCount = 27;

        int[][] map = new int[colCount][rowCount];

        try {
            Scanner input = new Scanner(file);

            for(int i = 0; i<colCount; i++){

                String [] line = input.nextLine().split(";");

                for (int j = 0; j < rowCount; j++) {

                    map[i][j] = Integer.parseInt(line[j]);
                }
            }

        } catch (FileNotFoundException e) {
            return new int[0][0];
        }
        return map;
    }
}
