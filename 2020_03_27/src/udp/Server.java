package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
//服务器
// Server 必须公开出 port，否则客户端找不到我
// 端口(port) 可以在 0 - 65535 之间随便选
// 但是不能使用已经被其他进程使用的端口 —— 端口只能属于唯一的一个进程
public class Server {
    static final int PORT = 9527;
    static final String CHARSET = "UTF-8";

    public static void main(String[] args) throws IOException {
        // 创建套接字
        // DatagramSocket 是 UDP 协议专用的 套接字
        // PORT 是我选好的准备开饭店的地址
        try (DatagramSocket serverSocket = new DatagramSocket(PORT)) {
            System.out.printf("DEBUG: 在 %d 这个端口上准备好接受请求了%n", PORT);

            // 提前准备好一个字节数组，用来存放接收到的数据（请求）
            // 一次最多可以接收 8192 个字节
            byte[] receiveBuffer = new byte[8192];

            while (true) {
                // 一次循环就是 一次 请求-响应 的处理过程

                // 1. 接收对方发送来的请求（数据）
                // 1.1 必须先创建 DatagramPacket 数据报文对象
                DatagramPacket packetFromClient = new DatagramPacket(
                        receiveBuffer, 0, receiveBuffer.length
                );//有8192个字节可使用
                // 1.2 接收数据
                serverSocket.receive(packetFromClient); // 这个方法不是立即返回的，和 scanner.nextLine();
                // 当走到这里时，数据一定接收到了
                // packetFromClient.getLength(); 一个收到了多少字节的数据

                // 1.3 因为我们收到的是字节格式的数据，所以我们把数据节码成字符格式的
                //     需要字符集编码的知识
                //     利用 String 的一个构造方法，把字节数组的数据解码(decode)成字符格式的数据 String
                String request = new String(
                        receiveBuffer, 0, packetFromClient.getLength(),
                        CHARSET
                );

                System.out.println("DEBUG: 收到的请求是: " + request);
            }
        }
    }
}
