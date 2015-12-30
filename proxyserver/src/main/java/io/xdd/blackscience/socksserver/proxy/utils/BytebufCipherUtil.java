package io.xdd.blackscience.socksserver.proxy.utils;

import io.netty.buffer.ByteBuf;

import javax.crypto.Cipher;
import java.nio.ByteBuffer;

public class BytebufCipherUtil {

    /**
     * 把 in 中的数据update到 out中
     * */
    public static void update(Cipher cipher,ByteBuf in,ByteBuf out){
        int bytes = in.readableBytes();//需要解密的数据大小
        byte[] decryptBuffer=new byte[bytes];
        in.readBytes(decryptBuffer,0,bytes);
        byte[] result=cipher.update(decryptBuffer);
        out.writeBytes(result);
    }
}