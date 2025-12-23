package com.bytedance.pangle.util;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;

/* loaded from: D:\Downloads\app\classes4.dex */
public class tl {
    public static void j(String str, String str2) throws IOException {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        File file = new File(str);
        File file2 = new File(str2);
        if (file.exists() && file.isFile() && file.canRead()) {
            if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
                file2.getParentFile().mkdirs();
            }
            FileInputStream fileInputStream = new FileInputStream(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            FileChannel channel = fileInputStream.getChannel();
            FileChannel channel2 = fileOutputStream.getChannel();
            channel2.write(channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size()));
            channel.close();
            channel2.close();
            fileInputStream.close();
            fileOutputStream.close();
        }
    }

    public static void j(InputStream inputStream, OutputStream outputStream) throws IOException {
        j(inputStream, outputStream, 4096);
    }

    private static void j(InputStream inputStream, OutputStream outputStream, int i6) throws IOException {
        if (inputStream == null || outputStream == null) {
            return;
        }
        ReadableByteChannel newChannel = Channels.newChannel(inputStream);
        WritableByteChannel newChannel2 = Channels.newChannel(outputStream);
        j(newChannel, newChannel2, i6);
        newChannel.close();
        newChannel2.close();
    }

    public static String j(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel channel = fileInputStream.getChannel();
        String charBuffer = Charset.defaultCharset().newDecoder().decode(channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size()).asReadOnlyBuffer()).toString();
        channel.close();
        fileInputStream.close();
        return charBuffer;
    }

    public static boolean j(String str, File file, StringBuilder sb) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            FileChannel channel = fileOutputStream.getChannel();
            channel.write(ByteBuffer.wrap(str.getBytes()));
            channel.close();
            fileOutputStream.close();
            return true;
        } catch (IOException e6) {
            sb.append(e6.getMessage());
            return false;
        }
    }

    private static void j(ReadableByteChannel readableByteChannel, WritableByteChannel writableByteChannel, int i6) throws IOException {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i6);
        while (readableByteChannel.read(allocateDirect) != -1) {
            allocateDirect.flip();
            while (allocateDirect.hasRemaining()) {
                writableByteChannel.write(allocateDirect);
            }
            allocateDirect.clear();
        }
    }
}
