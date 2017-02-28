/** 
 * Project Name:mypractice 
 * File Name:MultiplexerTimeServer.java 
 * Package Name:com.yaoyaohao.io.nonBlockio 
 * Date:2016-1-20下午2:30:06 
 * Copyright (c) 2016, maxing All Rights Reserved. 
 * 药药好（杭州）网络科技有限公司
*/  
package com.matthew.javabase.io.nonBlockio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
public class MultiplexerTimeServer implements Runnable{
	private Selector selector;
	private ServerSocketChannel serverChannel;
	private volatile boolean stop;
	/**
	 * @Title:  MultiplexerTimeServer   
	 * @Description:    初始化多路复用器，绑定监听端口
	 * @author maxing
	 * @date 2016-1-20 下午2:35:30
	 */
	public MultiplexerTimeServer(int port){
		try {
			selector = Selector.open();
			serverChannel = ServerSocketChannel.open();
			serverChannel.configureBlocking(false);//将serverSocketChannel 设置为异步非阻塞模式
			serverChannel.bind(new InetSocketAddress(port),1024);
			serverChannel.register(selector, SelectionKey.OP_ACCEPT);//将serverSocketServer注册到Selector,监听SelectionKey.OP_ACCEPT操作位
			System.out.println("The time server is start in port:"+port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void run() {
		while(!stop){
			try {
				selector.select(1000);//selector每隔1s被唤醒一次
				Set<SelectionKey> selectionKeys = selector.selectedKeys();//当有处于就绪状态的channel时，selector将返回channel的SelectionKey集合。
				Iterator<SelectionKey> it = selectionKeys.iterator();
				SelectionKey key = null;
				while(it.hasNext()){
					key = it.next();
					it.remove();
					try{
						handleInput(key);
					}catch(Exception e2){
						if(key != null){
							key.cancel();
							if(key.channel() !=null){
								key.channel().close();
							}
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//多路复用器关闭后，所有注册在上面的Channel和Pipe等资源都会被自动注册并关闭，所有不需要重复释放资源
		if(selector!=null){
			try {
				selector.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void stop(){
		this.stop = true;
	}
	private void handleInput(SelectionKey key) throws IOException{
		if(key.isValid()){
			//处理新的接入请求信息，根据selectionKey的操作位进行判断即可获知网络事件的类型。
			if(key.isAcceptable()){
				//Accept the new connection
				ServerSocketChannel ssc = (ServerSocketChannel)key.channel();
				SocketChannel sc = ssc.accept();//通过ServerSocketChannel的accept接受客户端的链接请求并创建SocketChannel实例。
				//以上相当于完成了tcp的三次握手，tcp物理连接正式建立。
				sc.configureBlocking(false);//将新创建的SocketChannel设置为异步非阻塞，
				//add the new connection to the selector
				sc.register(selector, SelectionKey.OP_READ);
			}
			if(key.isReadable()){
				//Read the data
				SocketChannel sc = (SocketChannel)key.channel();
				ByteBuffer readBuffer = ByteBuffer.allocate(1024);//开辟一个1MB的缓冲区，
				int readBuffers = sc.read(readBuffer);//调用SocketChannel的read方法读取请求码流。
				//由于我们已经将SocketChannel设置为异步非阻塞模式，因此它的read是非阻塞的，使用返回值进行判断，
				if(readBuffers > 0){//读到了字节，对字节进行编码
					readBuffer.flip();//将缓冲区当前的limit设置为position，position设置为0，用于后续对缓冲区的读取操作。
					byte[] bytes =new byte[readBuffer.remaining()];
					readBuffer.get(bytes);
					String body  = new String(bytes,"UTF-8");
					System.out.println("The time Server received order:"+body);
					String returnMsg ="QUERY TIME ORDER".equalsIgnoreCase(body)?"2016":"can't not recognize";
					doWrite(sc,returnMsg);
				}else if(readBuffers < 0){//链路已经关闭，需要关闭SocketChannel，释放资源。
					key.cancel();
					sc.close();
				}else{
					//没有读到字节，属于正常情况，忽略。
				}
			}
		}
	}
	/**]
	 * @Title:	doWrite
	 * @Description: 将服务器端内容推送到  ++
	 * @param sc
	 * @param returnMsg  void  
	 * @author maxing
	 * @date 2016-1-20 下午5:06:16
	 */
	private void doWrite(SocketChannel sc,String returnMsg) throws IOException{
		if(returnMsg!=null&&returnMsg.trim().length()>0){
			byte[] bytes = returnMsg.getBytes();
			ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
			writeBuffer.put(bytes);
			writeBuffer.flip();
			sc.write(writeBuffer);//由于SocketChannel是异步非阻塞的，它并不能保证一次性把需要发送的字节数组发送完，此时会出现“写半包”问题，
		}
	}
}
  