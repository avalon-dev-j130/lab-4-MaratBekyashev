package ru.avalon.java.udp;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;

/**
 * Упражнение, направленное на выработку умений, связанных
 * с отправкой сообщений средствами протокола UDP.
 *
 * @author Daniel Alpatov
 */
public final class UdpSender {
/*
    public static void main(String[] args) throws UnsupportedEncodingException,
                                                  SocketException,
                                                  UnknownHostException,
                                                  IOException {
        String message = "Hello over UDP protocol!";
        byte[] datagram = message.getBytes("UTF-8");
        DatagramPacket packet = new DatagramPacket(datagram, datagram.length);

        InetAddress address = InetAddress.getLocalHost();
        packet.setAddress(address);
        packet.setPort(8080);

        DatagramSocket socket = new DatagramSocket();
        socket.send(packet);
    }

*/
    public static void main(String[] args) throws IOException {
        // 1. Формируем сообщение
        final String message = prepareMessage();
        // 2. Формируем адрес конечной точки.
        final SocketAddress address = prepareAddress();
        // 3. Формируем датаграмму.
        final DatagramPacket packet = pack(message);
        // 4. Устанавливаем адрес для пакета.
        packet.setSocketAddress(address);
        // 5. Создаём сокет
        DatagramSocket socket = createSocket();
        // 6. Отправляем сообщение
        socket.send(packet);
        // 7. Освобождаем ресурсы
        socket.close();
    }

    /**
     * Возвращает сообщение.
     *
     * @return текстовое сообщение.
     */
    private static String prepareMessage() {
        /*
         * TODO Реализовать метод prepareMessage класса UdpSender
         */
        return "Hi, There! I'm world!";
    }

    /**
     * Возвращает адрес конечной точки взаимодействия.
     *
     * @return адрес конечной точки.
     */
    private static SocketAddress prepareAddress () throws UnknownHostException {
        /*
         * TODO Реализовать метод prepareAddress класса UdpSender
         */
        InetAddress inetAdr = InetAddress.getLocalHost();

        return new InetSocketAddress(inetAdr, 11000);
    }

    /**
     * Возвращает сокет, описывающий взаимодействие по протоколу UDP.
     *
     * @return сокет.
     * @throws IOException
     */
    private static DatagramSocket createSocket() throws IOException {
        /*
         * TODO Реализовать метод createSocket класса UdpSender
         */
        DatagramSocket socket = new DatagramSocket();
        return socket;
    }

    /**
     * Упаковывает текстовое сообщение в объект типа {@link DatagramPacket}.
     *
     * @param message строковое сообщение.
     *
     * @return экземпляр типа {@link DatagramPacket}.
     */
    private static DatagramPacket pack(String message) throws UnsupportedEncodingException {
        /*
         * TODO Реализовать метод pack класса UdpSender
         */
        byte[] datagram = new byte[1024];
        datagram = message.getBytes("UTF-8");
        DatagramPacket packet = new DatagramPacket(datagram, datagram.length);
        return packet;
    }

}
