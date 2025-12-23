package cn.bluemobi.dylan.base.utils;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UUID;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private static String f1229a = null;

    /* renamed from: b, reason: collision with root package name */
    private static final String f1230b = "INSTALLATION";

    public static synchronized String a(Context context) {
        String str;
        synchronized (l.class) {
            try {
                if (f1229a == null) {
                    File file = new File(context.getFilesDir(), f1230b);
                    try {
                        if (!file.exists()) {
                            c(file);
                        }
                        f1229a = b(file);
                    } catch (Exception e6) {
                        throw new RuntimeException(e6);
                    }
                }
                str = f1229a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    private static String b(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, com.kuaishou.weapon.p0.t.f36150k);
        byte[] bArr = new byte[(int) randomAccessFile.length()];
        randomAccessFile.readFully(bArr);
        randomAccessFile.close();
        return new String(bArr);
    }

    private static void c(File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(UUID.randomUUID().toString().getBytes());
        fileOutputStream.close();
    }
}
