package org.jgroups.util;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.Map;

import javax.net.ServerSocketFactory;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;

/**
 * @author Tristan Tarrant &lt;tristan@infinispan.org&gt;
 **/
public class TransportSocketFactory implements org.jgroups.util.SocketFactory {
   private final SocketFactory socketFactory;
   private final ServerSocketFactory serverSocketFactory;

   public TransportSocketFactory(SSLContext sslContext) {
      this.socketFactory = sslContext.getSocketFactory();
      this.serverSocketFactory = sslContext.getServerSocketFactory();
   }

   public TransportSocketFactory(SocketFactory socketFactory, ServerSocketFactory serverSocketFactory) {
      this.socketFactory = socketFactory;
      this.serverSocketFactory = serverSocketFactory;
   }

   public TransportSocketFactory() {
      this.socketFactory = SocketFactory.getDefault();
      this.serverSocketFactory = ServerSocketFactory.getDefault();
   }

   @Override
   public Socket createSocket(String s) throws IOException {
      return socketFactory.createSocket();
   }

   @Override
   public Socket createSocket(String s, String host, int port) throws IOException {
      return socketFactory.createSocket(host, port);
   }

   @Override
   public Socket createSocket(String s, InetAddress host, int port) throws IOException {
      return socketFactory.createSocket(host, port);
   }

   @Override
   public Socket createSocket(String s, String host, int port, InetAddress localHost, int localPort) throws IOException {
      return socketFactory.createSocket(host, port, localHost, localPort);
   }

   @Override
   public Socket createSocket(String s, InetAddress host, int port, InetAddress localHost, int localPort) throws IOException {
      return socketFactory.createSocket(host, port, localHost, localPort);
   }

   @Override
   public ServerSocket createServerSocket(String s) throws IOException {
      return serverSocketFactory.createServerSocket();
   }

   @Override
   public ServerSocket createServerSocket(String s, int port) throws IOException {
      return serverSocketFactory.createServerSocket(port);
   }

   @Override
   public ServerSocket createServerSocket(String s, int port, int backlog) throws IOException {
      return serverSocketFactory.createServerSocket(port, backlog);
   }

   @Override
   public ServerSocket createServerSocket(String s, int port, int backlog, InetAddress bindAddress) throws IOException {
      return serverSocketFactory.createServerSocket(port, backlog, bindAddress);
   }

   public DatagramSocket createDatagramSocket(String service_name) throws SocketException {
      return new DatagramSocket();
   }

   public DatagramSocket createDatagramSocket(String service_name, SocketAddress bindaddr) throws SocketException {
      return new DatagramSocket(bindaddr);
   }

   public DatagramSocket createDatagramSocket(String service_name, int port) throws SocketException {
      return new DatagramSocket(port);
   }

   public DatagramSocket createDatagramSocket(String service_name, int port, InetAddress laddr) throws SocketException {
      return new DatagramSocket(port, laddr);
   }

   public MulticastSocket createMulticastSocket(String service_name) throws IOException {
      return new MulticastSocket();
   }

   public MulticastSocket createMulticastSocket(String service_name, int port) throws IOException {
      return new MulticastSocket(port);
   }

   public MulticastSocket createMulticastSocket(String service_name, SocketAddress bindaddr) throws IOException {
      return new MulticastSocket(bindaddr);
   }

   @Override
   public void close(Socket socket) throws IOException {
      Util.close(socket);
   }

   @Override
   public void close(ServerSocket serverSocket) throws IOException {
      Util.close(serverSocket);
   }

   @Override
   public void close(DatagramSocket datagramSocket) {
      Util.close(datagramSocket);
   }

   @Override
   public Map<Object, String> getSockets() {
      return null;
   }
}
