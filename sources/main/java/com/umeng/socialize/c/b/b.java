package com.umeng.socialize.c.b;

import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.DefaultClass;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final b f42311a = new b();

    public static b a() {
        return f42311a;
    }

    public byte[] a(File file) {
        FileInputStream fileInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
            }
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        try {
                            fileInputStream.close();
                            byteArrayOutputStream.close();
                            return byteArray;
                        } catch (IOException e6) {
                            SLog.error(UmengText.IMAGE.CLOSE, e6);
                            return byteArray;
                        }
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            } catch (Throwable th3) {
                th = th3;
                try {
                    SLog.error(UmengText.IMAGE.READ_IMAGE_ERROR, th);
                    if (fileInputStream != null) {
                        try {
                        } catch (IOException e7) {
                            return DefaultClass.getBytes();
                        }
                    }
                    return DefaultClass.getBytes();
                } finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e72) {
                            SLog.error(UmengText.IMAGE.CLOSE, e72);
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                }
            }
        } catch (Throwable th4) {
            fileInputStream = null;
            th = th4;
            byteArrayOutputStream = null;
        }
    }

    public File b() throws IOException {
        File file = new File(c(), d());
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        return file;
    }

    private b() {
    }

    public File c() {
        File file = new File(ContextUtil.getContext().getExternalFilesDir(null), c.f42312a);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public String d() {
        return SocializeUtils.hexdigest(String.valueOf(System.currentTimeMillis())) + ".jpg";
    }
}
