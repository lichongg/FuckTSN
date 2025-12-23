package xyz.adscope.common.v2.tool.io;

import com.baidu.mobads.sdk.internal.by;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import xyz.adscope.common.v2.log.SDKLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class FileVerify {
    private static final String[] strHex = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public static String getFileBufferedMD5(String str) {
        return getFileBufferedMD5(new File(str));
    }

    public static String getFileMD5(String str) {
        return getFileMD5(new File(str));
    }

    private static byte[] File2byte(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    fileInputStream.close();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (IOException e6) {
            SDKLog.stack(e6);
            return null;
        }
    }

    private static String bytesToHex(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b6 : bArr) {
            sb.append(String.format("%02x", Byte.valueOf(b6)));
        }
        return sb.toString();
    }

    public static String getFileBufferedMD5(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                DigestInputStream digestInputStream = new DigestInputStream(fileInputStream, MessageDigest.getInstance(by.f10823a));
                try {
                    while (digestInputStream.read(new byte[8192]) != -1) {
                    }
                    String bytesToHex = bytesToHex(digestInputStream.getMessageDigest().digest());
                    digestInputStream.close();
                    fileInputStream.close();
                    return bytesToHex;
                } finally {
                }
            } finally {
            }
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public static String getFileMD5(File file) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            for (int i6 : MessageDigest.getInstance(by.f10823a).digest(File2byte(file))) {
                if (i6 < 0) {
                    i6 += 256;
                }
                String[] strArr = strHex;
                stringBuffer.append(strArr[i6 / 16]);
                stringBuffer.append(strArr[i6 % 16]);
            }
        } catch (NoSuchAlgorithmException e6) {
            SDKLog.stack(e6);
        }
        return stringBuffer.toString();
    }

    private FileVerify() {
        throw new RuntimeException("class don't need new instance");
    }
}
