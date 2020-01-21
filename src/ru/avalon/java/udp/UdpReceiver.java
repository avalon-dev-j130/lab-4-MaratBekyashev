package ru.avalon.java.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Упражнение, на правленное на выработку умений, связанных с полученеим
 * сообщений, отправленных с использование протокола UDP.
 *
 * @author Daniel Alpatov
 */
/*
import java.net.*;
import java.io.*;

public class Receiver {

    public static void main(String[] args) throws SocketException,
                                                  IOException {
        byte[] buffer = new byte[MAX_MESSAGE_SIZE];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        DatagramSocket socket = new DatagramSocket(8080);
        socket.receive(packet);

        String message = new String(buffer, "UTF-8");
        System.out.println(message);
    }
}
*/
public final class UdpReceiver {
    final static int MAX_MESSAGE_SIZE = 1024;

    public static void main(String[] args) throws IOException {
        // 1. Формируем буффер, для хранения получаемых данных.
        final byte[] buffer = prepareBuffer();
        // 2. Формируем пакет, на основе созданного буфера.
        final DatagramPacket packet = preparePacket(buffer);
        // 3. Выбираем порт, на который ожидается получение сообщения.
        final int port = 0;
        // 4. Формируем сокет, связанный с выбранным портом.
        final DatagramSocket socket = prepareSocket(port);
        // 5. Получаем сообщение.
        socket.receive(packet);
        // 6. На основании данных пакета формируем текстовое сообщение.
        final String message = getMessage(packet);
        // 7. Освобождаем ресурсы.
        System.out.println(message);
        socket.close();
    }

    /**
     * Возвращает буффер, который будет испопльзован для храрнения получаемых данных.
     *
     * @return двоичный массив.
     */
    private static byte[] prepareBuffer() {
        /*
         * TODO Реализовать метод prepareBuffer класса UdpReceiver
         */
        byte[] buffer = new byte[MAX_MESSAGE_SIZE];
        return buffer;
    }

    /**
     * Упаковывает переданный двоичный массив (буффер) в экземпляр
     * типа {@link DatagramPacket}.
     *
     * @param buffer буффек, который будет использован пакетом для
     *               хранения получаемых данных.
     *
     * @return экземпляр типа {@link DatagramPacket}.
     */
    private static DatagramPacket preparePacket(byte[] buffer) {
        /*
         * TODO Реализовать метод preparePacket класса UdpReceiver
         */
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        return packet;
    }

    /**
     * Возвращает сокет, связанный с указанным портом.
     *
     * @param port порт.
     *
     * @return сокет.
     */
    private static DatagramSocket prepareSocket(int port) throws SocketException {
        /*
         * TODO Реализовать метод prepareSocket класса UdpReceiver
         */
        DatagramSocket socket = new DatagramSocket(11000);
        return socket;
    }

    /**
     * Преобразует данные, содержащиеся в полученном пакете в текстовое
     * представление.
     *
     * @param packet пакет.
     *
     * @return строковое сообщение.
     */
    private static String getMessage(DatagramPacket packet) {
        /*
         * TODO Реализовать метод getMessage класса UdpReceiver
         */
        String message = new String(packet.getData());
        return message;
    }

}
