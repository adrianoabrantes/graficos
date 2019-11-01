package br.com.empresa.graficos;

import java.io.FileWriter;
import java.io.PrintWriter;

public class CreateFile {
    CreateFile(String filename, String volume) {
        try {
            FileWriter fw = new FileWriter(filename);
            PrintWriter print = new PrintWriter(fw);
            print.write(volume);
            fw.close();
            print.close();
            
        } catch (Exception e) {
            e.getStackTrace();
        }

    }
}