package cn.jiguang.bc;

import cn.jiguang.bb.f;
import cn.jiguang.bz.l;
import com.google.common.base.Ascii;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f1978a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f1979b;

    /* renamed from: c, reason: collision with root package name */
    private static final String f1980c;

    static {
        String b6 = l.b(new byte[]{87, 84, 99});
        f1978a = b6;
        f1979b = l.b(new byte[]{73, 83, 66, Ascii.US, 99, 91, 75, 57, 65, 123, 99, 74, 61, 70, 112, 84, 68, 112, 102, 113});
        f1980c = b6;
    }

    private static void a(int i6, String str, File file, File file2) {
        String substring = str.substring(0, 16);
        f.c("CryptoUtils", "doCrypto cipherMode is " + i6 + ", key is " + str + ", IvParameterSpec is " + substring + ", inputFile is " + file.getAbsolutePath() + ", outputFile is " + file2.getAbsolutePath());
        try {
            Charset charset = StandardCharsets.UTF_8;
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(charset), f1980c);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(substring.getBytes(charset));
            Cipher cipher = Cipher.getInstance(f1979b);
            cipher.init(i6, secretKeySpec, ivParameterSpec);
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byte[] update = cipher.update(bArr, 0, read);
                        if (update != null) {
                            byteArrayOutputStream.write(update);
                        }
                    }
                    byte[] doFinal = cipher.doFinal();
                    if (doFinal != null) {
                        byteArrayOutputStream.write(doFinal);
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    try {
                        byteArrayOutputStream.writeTo(fileOutputStream);
                        fileOutputStream.close();
                        byteArrayOutputStream.close();
                        fileInputStream.close();
                    } finally {
                    }
                } finally {
                }
            } finally {
            }
        } catch (Exception e6) {
            f.b("CryptoUtils", "Error encrypting/decrypting file, error message is " + e6.getMessage(), e6);
        }
    }

    public static void a(String str, File file, File file2) {
        a(1, str, file, file2);
    }
}
