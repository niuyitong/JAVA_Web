package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

//客户端
public class Client {
    // 这里使用 127.0.0.1 代表本机
    private static final String serverIP = "49.233.172.121";

    public static void main(String[] args) throws IOException {
        // 创建 UDP Socket 的
        // 不需要传入端口，让 OS 自动分配一个
        try (DatagramSocket clientSocket = new DatagramSocket()) {

            // 1. 准备好请求，同时，传输的必须是字符格式
            String request = "你好";
            byte[] requestBytes = request.getBytes(Server.CHARSET);

            // 2. 发送请求
            // 2.1 先准备 DatagramPacket
            //     需要指定服务器的 ip + port
            DatagramPacket packetToServer = new DatagramPacket(
                    requestBytes, 0, requestBytes.length,     // 要发送的数据
                    InetAddress.getByName(serverIP), Server.PORT    // 要发送到互联网的哪个进程上
            );

            clientSocket.send(packetToServer);
        }
    }
}
