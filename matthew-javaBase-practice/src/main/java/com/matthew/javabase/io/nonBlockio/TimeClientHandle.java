/** 
 * Project Name:mypractice 
 * File Name:TimeClientHandle.java 
 * Package Name:com.yaoyaohao.io.nonBlockio 
 * Date:2016-1-21下午2:37:26 
 * Copyright (c) 2016, maxing All Rights Reserved. 
 * 药药好（杭州）网络科技有限公司
*/  
package com.matthew.javabase.io.nonBlockio;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
public class TimeClientHandle implements Runnable{
	private String host;
	private int port;
	private Selector selector;
	private SocketChannel socketChannel;
	private volatile boolean stop;
	
	public TimeClientHandle(String host,int port){
		this.host = host==null?"127.0.0.1":host;
		this.port = port;
		try {
			selector = Selector.open();
			socketChannel = SocketChannel.open();//初始化nio的多路复用器和socketChannel对象，
			socketChannel.configureBlocking(false);//将socketChannel设置为异步非阻塞模式。
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void run() {
		try {
			doConnect();//
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		while(!stop){
			try {
				selector.select(1000);
				Set<SelectionKey> selectedKeys= selector.selectedKeys();
				Iterator<SelectionKey>  it =selectedKeys.iterator();
				SelectionKey key = null;
				while(it.hasNext()){
					key = it.next();
					it.remove();
					try {
						handleInput(key);
					} catch (Exception e) {
						key.cancel();
						if(key.channel()!=null){
							key.channel().close();
						}
						e.printStackTrace();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		//多路复用器关闭后，所有注册在上面的channel和Pipe等资源会被自动去注册并关闭，所有不需要重复释放资源
		if(selector!=null){
			try {
				selector.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void handleInput(SelectionKey key) throws Exception{
		if(key.isValid()){
			//判断是否链接成功
			SocketChannel  sc= (SocketChannel)key.channel();
			if(key.isConnectable()){//处于连接状态，说明服务端已经返回ACK应答消息，
				if(sc.finishConnect()){//客户端连接成功，
					sc.register(selector, SelectionKey.OP_READ);
					doWrite(sc);
				}else{
					System.exit(1);//链接失败，进程退出
				}
			}
			if(key.isReadable()){//如果客户端收到了服务端的应答消息，那么SocketChannel是可读的，
				ByteBuffer readBuffer = ByteBuffer.allocate(1024);//
				int readBytes= sc.read(readBuffer);
				if(readBytes>0){
					readBuffer.flip();//很重要
					byte[] bytes = new byte[readBuffer.remaining()];
					readBuffer.get(bytes);
					String  body= new String(bytes,"utf-8");
					System.out.println("Now is :"+body);
					this.stop= true;
				}else if(readBytes<0){
					//对链路关闭\
					key.cancel();
					sc.close();
				}else{
					;//读到0字节忽略
				}
			}
		}
	}
	
	
	private void doConnect() throws IOException{
		if(socketChannel.connect(new InetSocketAddress(host,port))){//对SocketChannel的connect()操作判断，
			socketChannel.register(selector,SelectionKey.OP_READ);//链接成功，将SocketChannel注册到多路复用器Selector
			doWrite(socketChannel);
		}else{
			socketChannel.register(selector,SelectionKey.OP_CONNECT);//如果没有链接成功，则说明服务端没有返回TCP握手应答消息，不代表失败，将socketChannel注册到多路复用器selector上，注册SelectionKey.OP_CONNECT,当服务器返回TCP syn-ack消息后，selector就能轮训到这个SocketChannel处于连接就绪状态。
		}
	}
	private void doWrite(SocketChannel socketChannel) throws IOException{
		byte[] req = "QUERY TIME ORDER".getBytes();
		ByteBuffer writeBuffer = ByteBuffer.allocate(req.length);
		writeBuffer.put(req);
		writeBuffer.flip();
		socketChannel.write(writeBuffer);
		if(!writeBuffer.hasRemaining()){
			System.out.println("Send order 2 server succed!");
		}
		
	}

}
  