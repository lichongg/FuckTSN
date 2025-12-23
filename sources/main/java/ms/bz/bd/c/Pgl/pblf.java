package ms.bz.bd.c.Pgl;

import android.content.Context;
import com.bytedance.sdk.openadsdk.api.plugin.xt;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class pblf {

    /* renamed from: a, reason: collision with root package name */
    private static final String f50326a = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "1f8836", new byte[]{46, 101, 5, 79, 22, 45});

    public static int a(Context context) {
        InputStream inputStream;
        int i6;
        String sb;
        ByteArrayOutputStream byteArrayOutputStream;
        int i7 = 255;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(xt.j(context).getAbsolutePath());
            i6 = 0;
            sb2.append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "661864", new byte[]{104}));
            String str = f50326a;
            sb2.append(str);
            sb = sb2.toString();
            File file = new File(sb);
            if (file.exists()) {
                i7 = 2;
                file.delete();
            }
            inputStream = context.getResources().getAssets().open(str);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            inputStream = null;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr, 0, 4096);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            FileOutputStream fileOutputStream = new FileOutputStream(sb);
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            fileOutputStream.close();
            if (byteArrayOutputStream.size() <= 0) {
                i6 = 3;
            } else if (!new File(sb).exists()) {
                i6 = i7;
            }
            try {
                inputStream.close();
            } catch (Throwable unused3) {
            }
            try {
                byteArrayOutputStream.close();
                return i6;
            } catch (Throwable unused4) {
                return i6;
            }
        } catch (Throwable unused5) {
            byteArrayOutputStream2 = byteArrayOutputStream;
            try {
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "db1183", new byte[]{116, 99, 125, 66});
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable unused6) {
                    }
                }
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Throwable unused7) {
                    }
                }
                return i7;
            } finally {
            }
        }
    }
}
