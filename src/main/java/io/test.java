package io;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @author wangzhiguo
 */
public class test {

    public static void main(String[] args) throws IOException {
        Reactor reactor = new Reactor(8888);
        reactor.run();
    }
}
