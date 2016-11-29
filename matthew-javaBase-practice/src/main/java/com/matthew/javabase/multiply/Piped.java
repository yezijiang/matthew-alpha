package com.matthew.javabase.multiply;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-08-08 16:59
 */
public class Piped {
    public static void main(String[] args) throws IOException {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();

        out.connect(in);
        Print print = new Print(in);
        Thread printThread = new Thread(print,"printThread");
        printThread.start();
        try {
                out.write("hello world");
        } finally{
           out.close();
        }
    }
    static class Print implements Runnable{
        private PipedReader reader;
        public Print(PipedReader in){
            this.reader = in;
        }
        public void run() {
            int receive = 0;
            try {
                while((receive = reader.read()) != -1){
                    System.out.print((char)receive);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
