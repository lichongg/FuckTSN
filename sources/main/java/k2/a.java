package k2;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import com.baidu.mobads.sdk.internal.by;
import com.oplus.omes.stdsco.urlcheck.LurCache.a;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static final long f43553b = 129600000;

    /* renamed from: c, reason: collision with root package name */
    private static final int f43554c = 5242880;

    /* renamed from: a, reason: collision with root package name */
    private com.oplus.omes.stdsco.urlcheck.LurCache.a f43555a;

    /* JADX WARN: Removed duplicated region for block: B:14:0x0060 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(java.lang.String r6, k2.c r7) {
        /*
            r5 = this;
            r0 = 0
            com.oplus.omes.stdsco.urlcheck.LurCache.a r1 = r5.f43555a     // Catch: org.json.JSONException -> L51 java.io.IOException -> L53
            com.oplus.omes.stdsco.urlcheck.LurCache.a$c r0 = r1.o(r6)     // Catch: org.json.JSONException -> L51 java.io.IOException -> L53
            if (r0 == 0) goto L55
            r6 = 0
            java.io.OutputStream r6 = r0.i(r6)     // Catch: org.json.JSONException -> L51 java.io.IOException -> L53
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: org.json.JSONException -> L51 java.io.IOException -> L53
            r1.<init>()     // Catch: org.json.JSONException -> L51 java.io.IOException -> L53
            java.lang.String r2 = "id"
            int r3 = r7.b()     // Catch: org.json.JSONException -> L51 java.io.IOException -> L53
            r1.put(r2, r3)     // Catch: org.json.JSONException -> L51 java.io.IOException -> L53
            java.lang.String r2 = "url"
            java.lang.String r3 = r7.d()     // Catch: org.json.JSONException -> L51 java.io.IOException -> L53
            r1.put(r2, r3)     // Catch: org.json.JSONException -> L51 java.io.IOException -> L53
            java.lang.String r2 = "urlType"
            int r3 = r7.e()     // Catch: org.json.JSONException -> L51 java.io.IOException -> L53
            r1.put(r2, r3)     // Catch: org.json.JSONException -> L51 java.io.IOException -> L53
            java.lang.String r2 = "evilClass"
            int r3 = r7.a()     // Catch: org.json.JSONException -> L51 java.io.IOException -> L53
            r1.put(r2, r3)     // Catch: org.json.JSONException -> L51 java.io.IOException -> L53
            java.lang.String r2 = "timestamp"
            long r3 = r7.c()     // Catch: org.json.JSONException -> L51 java.io.IOException -> L53
            r1.put(r2, r3)     // Catch: org.json.JSONException -> L51 java.io.IOException -> L53
            java.lang.String r7 = r1.toString()     // Catch: org.json.JSONException -> L51 java.io.IOException -> L53
            java.lang.String r1 = "UTF-8"
            byte[] r7 = r7.getBytes(r1)     // Catch: org.json.JSONException -> L51 java.io.IOException -> L53
            r6.write(r7)     // Catch: org.json.JSONException -> L51 java.io.IOException -> L53
            r0.f()     // Catch: org.json.JSONException -> L51 java.io.IOException -> L53
            goto L55
        L51:
            r6 = move-exception
            goto L5b
        L53:
            r6 = move-exception
            goto L5b
        L55:
            com.oplus.omes.stdsco.urlcheck.LurCache.a r6 = r5.f43555a     // Catch: org.json.JSONException -> L51 java.io.IOException -> L53
            r6.flush()     // Catch: org.json.JSONException -> L51 java.io.IOException -> L53
            return
        L5b:
            r6.printStackTrace()
            if (r0 == 0) goto L68
            r0.a()     // Catch: java.io.IOException -> L64
            goto L68
        L64:
            r6 = move-exception
            r6.printStackTrace()
        L68:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k2.a.b(java.lang.String, k2.c):void");
    }

    private c f(String key) {
        a.e eVar;
        try {
            eVar = this.f43555a.q(key);
            if (eVar != null) {
                try {
                    JSONObject jSONObject = new JSONObject(new String(a(eVar.b(0)), "UTF-8"));
                    c cVar = new c();
                    cVar.g(jSONObject.getInt("id"));
                    cVar.i(jSONObject.getString("url"));
                    cVar.j(jSONObject.getInt("urlType"));
                    cVar.f(jSONObject.getInt("evilClass"));
                    cVar.h(jSONObject.getLong("timestamp"));
                    eVar.close();
                    if (System.currentTimeMillis() < cVar.c() + f43553b) {
                        return cVar;
                    }
                    this.f43555a.B(key);
                } catch (Exception e6) {
                    e = e6;
                    e.printStackTrace();
                    if (eVar != null) {
                        eVar.close();
                    }
                    return null;
                }
            }
        } catch (Exception e7) {
            e = e7;
            eVar = null;
        }
        return null;
    }

    private byte[] a(InputStream inStream) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inStream.read(bArr);
            if (read == -1) {
                byteArrayOutputStream.close();
                inStream.close();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    private static String c(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b6 : bytes) {
            String hexString = Integer.toHexString(b6 & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    private File g(Context context, String uniqueName) {
        return new File((("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) ? context.getExternalCacheDir().getPath() : context.getCacheDir().getPath()) + File.separator + uniqueName);
    }

    public static String h(String key) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(by.f10823a);
            messageDigest.update(key.getBytes());
            return c(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            return String.valueOf(key.hashCode());
        }
    }

    public a(Context context, String uniqueName) {
        File g6 = g(context, uniqueName);
        if (!g6.exists()) {
            g6.mkdirs();
        }
        try {
            this.f43555a = com.oplus.omes.stdsco.urlcheck.LurCache.a.w(g6, e(context), 1, 5242880L);
        } catch (IOException e6) {
            e6.printStackTrace();
        }
    }

    private int e(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e6) {
            e6.printStackTrace();
            return 1;
        }
    }

    public c d(String url) {
        return f(h(url));
    }

    public void i(c result) {
        b(h(result.d()), result);
    }
}
