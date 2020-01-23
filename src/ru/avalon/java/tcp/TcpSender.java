package ru.avalon.java.tcp;

import java.io.*;
import java.net.*;

/**
 * Упражнение на выработку базовых умений использования
 * протокола TCP.
 *
 * @author Daniel Alpatov
 */
public final class TcpSender {

    public static void main(String[] args) throws IOException {
        // 1. Подготавливааем сообщение
        final String message = prepareMessage();
        // 2. Подготавливаем адрес
        final SocketAddress address = prepareAddress();
        // 3. Устанавливаем соединение
        Socket socket = connect(address);
        // 4. Отправляем сообщение
        send(socket, message);
        // 5. Закрываем соединеие
        socket.close();
    }
/*
public class Sender {

    public static void main(String[] args) throws UnknownHostException,
                                                  IOException {
        String message = "Hello over TCP protocol";
        InetAddress address = InetAddress.getLocalHost();
        try (Socket socket = new Socket(address, 8080)) {
            OutputStream stream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(stream);
            writer.write(message);
            writer.flush();
        }
    }
}
* */

    /**
     * Возвращает объект сообщения.
     *
     * @return текстовое сообщение.
     */
    private static String prepareMessage() {
        /*
         * TODO Реализовать метод prepareMessage класса TcpSender
         */
        String result = "ресивер, ты дурак";
        return result;
    }

    /**
     * Возвращает адрес, на который будет выполнена отправка сообщения.
     *
     * @return экземпля типа {@link SocketAddress}
     */
    private static SocketAddress prepareAddress() throws UnknownHostException {
        /*
         * TODO Реализовать метод prepareAddress класса TcpSender
         */
        InetAddress inetAdr = InetAddress.getLocalHost();
        return new InetSocketAddress(inetAdr, 11000);
    }

    /**
     * Устанавливает соединение на указанный адрес и возвращает сокет
     * описывающий соединение.
     *
     * @param address адрес, на который будет выполено соединение.
     * @return сокет, описывающий открытое соединеие.
     * @throws IOException
     */
    private static Socket connect(SocketAddress address) throws IOException {
        /*
         * TODO Реализовать метод connect класса TcpSender
         */
        Socket socket = new Socket();
        socket.connect(address);
        return socket;
    }

    /**
     * Выполняет отправку сообщения {@code message} на {@code socket}.
     *
     * @param socket  соединение, через которое будет отправлено сообщение.
     * @param message сообщение
     * @throws IOException
     */
    private static void send(Socket socket, String message) throws IOException {
        /*
         * TODO Реализовать метод send класса TcpSender
         */
        OutputStream outStream = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(outStream);
        writer.println(message);
        writer.flush();
        System.out.println("TCP.Sender message sent: " + message);

        InputStream inStream = socket.getInputStream();
        Reader reader = new InputStreamReader(inStream);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = bufferedReader.readLine();
        System.out.println("TCP.Sender. Reply from receiver:"+ line);

        reader.close();
        writer.close();
    }

}
