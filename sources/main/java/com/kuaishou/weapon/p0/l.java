package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: D:\Downloads\app\classes6.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private static final String f36064a = "gzip";

    /* renamed from: b, reason: collision with root package name */
    private static final int f36065b = 1024;

    /* renamed from: d, reason: collision with root package name */
    private static volatile l f36066d;

    /* renamed from: e, reason: collision with root package name */
    private static Context f36067e;

    /* renamed from: c, reason: collision with root package name */
    private boolean f36068c = false;

    public static l a(Context context) {
        if (f36066d == null) {
            synchronized (l.class) {
                try {
                    if (f36066d == null) {
                        f36066d = new l(context);
                    }
                } finally {
                }
            }
        }
        return f36066d;
    }

    public void b(m mVar, j jVar) {
        a(mVar, jVar, "POST");
    }

    private l(Context context) {
        f36067e = context;
    }

    public void a(m mVar, j jVar) {
        a(mVar, jVar, "GET");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.net.HttpURLConnection] */
    public HttpURLConnection a(String str, String str2) {
        HttpsURLConnection httpsURLConnection;
        try {
            URL url = new URL(str);
            if (master.flame.danmaku.danmaku.parser.b.f50155b.equals(url.getProtocol())) {
                HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) url.openConnection();
                a(httpsURLConnection2);
                httpsURLConnection = httpsURLConnection2;
            } else {
                httpsURLConnection = (HttpURLConnection) url.openConnection();
            }
            try {
                httpsURLConnection.setRequestMethod(str2);
                httpsURLConnection.setAllowUserInteraction(true);
                httpsURLConnection.setInstanceFollowRedirects(true);
                httpsURLConnection.setChunkedStreamingMode(0);
                httpsURLConnection.setConnectTimeout(10000);
                httpsURLConnection.setReadTimeout(5000);
                httpsURLConnection.setRequestProperty("Charset", "UTF-8");
                httpsURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                if (str2.equalsIgnoreCase("post")) {
                    httpsURLConnection.setDoInput(true);
                    httpsURLConnection.setDoOutput(true);
                    httpsURLConnection.setUseCaches(false);
                }
                return httpsURLConnection;
            } catch (Exception unused) {
                return httpsURLConnection;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    private synchronized void a(HttpsURLConnection httpsURLConnection) {
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x00fd A[Catch: Exception -> 0x0105, TryCatch #6 {Exception -> 0x0105, blocks: (B:72:0x00f8, B:65:0x00fd, B:67:0x0102), top: B:71:0x00f8 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0102 A[Catch: Exception -> 0x0105, TRY_LEAVE, TryCatch #6 {Exception -> 0x0105, blocks: (B:72:0x00f8, B:65:0x00fd, B:67:0x0102), top: B:71:0x00f8 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.kuaishou.weapon.p0.m r10, com.kuaishou.weapon.p0.j r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.l.a(com.kuaishou.weapon.p0.m, com.kuaishou.weapon.p0.j, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0102 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0103 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ec A[Catch: Exception -> 0x00ef, TRY_LEAVE, TryCatch #2 {Exception -> 0x00ef, blocks: (B:65:0x00e7, B:60:0x00ec), top: B:64:0x00e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(com.kuaishou.weapon.p0.m r11) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.l.a(com.kuaishou.weapon.p0.m):java.lang.String");
    }

    public boolean a(String str, File file) {
        HttpURLConnection httpURLConnection;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        InputStream inputStream = null;
        try {
            httpURLConnection = a(str, "GET");
        } catch (Throwable unused) {
            httpURLConnection = null;
        }
        try {
            inputStream = a(httpURLConnection);
            boolean a6 = a(inputStream, file);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable unused2) {
                    return false;
                }
            }
            if (httpURLConnection == null) {
                return a6;
            }
            httpURLConnection.disconnect();
            return a6;
        } catch (Throwable unused3) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable unused4) {
                    return false;
                }
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return false;
        }
    }

    private InputStream a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return null;
        }
        try {
            if ("gzip".equalsIgnoreCase(httpURLConnection.getContentEncoding())) {
                this.f36068c = true;
            } else {
                this.f36068c = false;
            }
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return null;
        }
    }

    private boolean a(InputStream inputStream, File file) {
        BufferedOutputStream bufferedOutputStream;
        if (this.f36068c) {
            try {
                inputStream = new GZIPInputStream(inputStream);
            } catch (IOException unused) {
            }
        }
        if (inputStream == null) {
            return false;
        }
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        bufferedOutputStream.write(bArr, 0, read);
                        bufferedOutputStream.flush();
                    } else {
                        try {
                            bufferedOutputStream.close();
                            return true;
                        } catch (IOException unused2) {
                            return true;
                        }
                    }
                }
            } catch (Throwable unused3) {
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                return false;
            }
        } catch (Throwable unused5) {
            bufferedOutputStream = null;
        }
    }

    public String a(Map<String, String> map) {
        String str = "";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            str = str + ContainerUtils.FIELD_DELIMITER + entry.getKey() + ContainerUtils.KEY_VALUE_DELIMITER + entry.getValue();
        }
        return str.substring(1);
    }
}
