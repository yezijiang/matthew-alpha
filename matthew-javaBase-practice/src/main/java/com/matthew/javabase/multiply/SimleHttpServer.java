package com.matthew.javabase.multiply;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 简单的web服务器，
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-08-16 16:26
 */
public class SimleHttpServer {

    static ThreadPool<HttpRequestHelper> threadPool = new DefaultThreadPool<HttpRequestHelper>(1);
    static String basePath;
    static ServerSocket sc;
    static int port = 8080;
    public static void setPort(int port){
        if(port>0){
            SimleHttpServer.port = port;
        }
    }
    public static void setBasePath(String basePath){
        if(basePath != null && new File(basePath).exists()&& new File(basePath).isDirectory()){
            SimleHttpServer.basePath = basePath;
        }
    }

    //启动SimleHttpServer
    public static void start() throws IOException {
        sc = new ServerSocket(port);
        Socket socket = null;
        while ( (socket = sc.accept())!=null ){
            //接受一个客户端socket，生成一个HttpRequestHandler放入线程池
            threadPool.execute(new HttpRequestHelper(socket));
        }
        sc.close();
    }

    static class HttpRequestHelper implements Runnable{
        private Socket socket;
        public HttpRequestHelper(Socket socket){
            this.socket = socket;
        }
        public void run() {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String header = reader.readLine();
                System.out.println(header);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        SimleHttpServer.start();
        Socket socket = new Socket("127.0.0.1",8080);
    }
}
