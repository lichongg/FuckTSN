package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class an {

    /* renamed from: a, reason: collision with root package name */
    public static final String f10594a = "OAdURLConnection";

    /* renamed from: b, reason: collision with root package name */
    public static final String f10595b = "POST";

    /* renamed from: c, reason: collision with root package name */
    public static final String f10596c = "GET";

    /* renamed from: d, reason: collision with root package name */
    public static final String f10597d = "application/json";

    /* renamed from: e, reason: collision with root package name */
    public static final String f10598e = "text/plain";

    /* renamed from: f, reason: collision with root package name */
    private HttpURLConnection f10599f;

    /* renamed from: g, reason: collision with root package name */
    private bu f10600g;

    /* renamed from: h, reason: collision with root package name */
    private b f10601h;

    /* renamed from: i, reason: collision with root package name */
    private c f10602i;

    /* renamed from: j, reason: collision with root package name */
    private String f10603j;

    /* renamed from: k, reason: collision with root package name */
    private String f10604k;

    /* renamed from: l, reason: collision with root package name */
    private String f10605l;

    /* renamed from: m, reason: collision with root package name */
    private String f10606m;

    /* renamed from: n, reason: collision with root package name */
    private int f10607n;

    /* renamed from: o, reason: collision with root package name */
    private int f10608o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f10609p;

    /* renamed from: q, reason: collision with root package name */
    private Uri.Builder f10610q;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends j {
        a() {
        }

        @Override // com.baidu.mobads.sdk.internal.j
        public Object i() {
            an.this.e();
            an.this.f();
            return null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void a(String str, int i6);

        void a(String str, String str2);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface c {
        void a(InputStream inputStream, String str);

        void a(String str, int i6);
    }

    public an(String str) {
        this(str, "GET");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            try {
                this.f10599f.connect();
                this.f10600g.a(f10594a, this.f10599f.getRequestMethod() + " connect code :" + this.f10599f.getResponseCode());
                int responseCode = this.f10599f.getResponseCode();
                if (responseCode == 302 || responseCode == 301) {
                    this.f10599f.setInstanceFollowRedirects(false);
                    HttpURLConnection a6 = a(this.f10599f);
                    this.f10599f = a6;
                    responseCode = a6.getResponseCode();
                }
                if (responseCode / 100 != 2) {
                    b bVar = this.f10601h;
                    if (bVar != null) {
                        bVar.a(this.f10599f.getResponseMessage(), responseCode);
                    }
                    c cVar = this.f10602i;
                    if (cVar != null) {
                        cVar.a(this.f10599f.getResponseMessage(), responseCode);
                    }
                } else {
                    String g6 = cr.a().g(this.f10603j);
                    b bVar2 = this.f10601h;
                    if (bVar2 != null) {
                        bVar2.a(c(), g6);
                    }
                    c cVar2 = this.f10602i;
                    if (cVar2 != null) {
                        cVar2.a(this.f10599f.getInputStream(), g6);
                    }
                }
                HttpURLConnection httpURLConnection = this.f10599f;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            } catch (Exception e6) {
                b bVar3 = this.f10601h;
                if (bVar3 != null) {
                    bVar3.a("Net Connect RuntimeError: " + e6.toString(), 0);
                }
                c cVar3 = this.f10602i;
                if (cVar3 != null) {
                    cVar3.a("Net Connect RuntimeError: " + e6.toString(), 0);
                }
                HttpURLConnection httpURLConnection2 = this.f10599f;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            }
        } catch (Throwable th) {
            HttpURLConnection httpURLConnection3 = this.f10599f;
            if (httpURLConnection3 != null) {
                httpURLConnection3.disconnect();
            }
            throw th;
        }
    }

    public String c() {
        InputStream inputStream = null;
        try {
            inputStream = this.f10599f.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[128];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    byteArrayOutputStream.flush();
                    String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                    inputStream.close();
                    return byteArrayOutputStream2;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    public an(String str, String str2) {
        this.f10600g = bu.a();
        this.f10601h = null;
        this.f10602i = null;
        this.f10606m = "text/plain";
        this.f10607n = 10000;
        this.f10608o = 10000;
        this.f10609p = false;
        this.f10610q = null;
        this.f10603j = str;
        this.f10604k = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (TextUtils.isEmpty(this.f10603j) || !cr.a().f(this.f10603j)) {
            return;
        }
        try {
            HttpURLConnection a6 = cr.a().a(new URL(this.f10603j));
            this.f10599f = a6;
            a6.setConnectTimeout(this.f10607n);
            if (Integer.parseInt(bn.a((Context) null).b()) < 8) {
                System.setProperty("http.keepAlive", "false");
            }
            this.f10599f.setRequestMethod(this.f10604k);
            this.f10599f.setUseCaches(this.f10609p);
            if (!TextUtils.isEmpty(this.f10605l)) {
                this.f10599f.setRequestProperty("User-Agent", this.f10605l);
            }
            this.f10599f.setRequestProperty("Content-type", this.f10606m);
            this.f10599f.setRequestProperty("Connection", "keep-alive");
            this.f10599f.setRequestProperty("Cache-Control", "no-cache");
            if (this.f10604k.equals("POST")) {
                this.f10599f.setDoInput(true);
                this.f10599f.setDoOutput(true);
                Uri.Builder builder = this.f10610q;
                if (builder != null) {
                    a(builder.build().getEncodedQuery(), this.f10599f);
                }
            }
        } catch (Exception e6) {
            b bVar = this.f10601h;
            if (bVar != null) {
                bVar.a("Net Create RuntimeError: " + e6.toString(), 0);
            }
            c cVar = this.f10602i;
            if (cVar != null) {
                cVar.a("Net Create RuntimeError: " + e6.toString(), 0);
            }
        }
    }

    public String a() {
        e();
        HttpURLConnection httpURLConnection = this.f10599f;
        if (httpURLConnection != null) {
            try {
                if (httpURLConnection.getResponseCode() / 100 != 2) {
                    HttpURLConnection httpURLConnection2 = this.f10599f;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return null;
                }
                String c6 = c();
                HttpURLConnection httpURLConnection3 = this.f10599f;
                if (httpURLConnection3 != null) {
                    httpURLConnection3.disconnect();
                }
                return c6;
            } catch (Throwable unused) {
                HttpURLConnection httpURLConnection4 = this.f10599f;
                if (httpURLConnection4 != null) {
                    httpURLConnection4.disconnect();
                }
            }
        }
        return null;
    }

    public void b() {
        try {
            be.a().a((j) new a());
        } catch (Exception unused) {
        }
    }

    public void d() {
        HttpURLConnection httpURLConnection = this.f10599f;
        if (httpURLConnection != null) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e6) {
                az.h(f10594a).f(e6.toString());
            }
        }
    }

    public void b(int i6) {
        this.f10608o = i6;
    }

    private void a(String str, HttpURLConnection httpURLConnection) {
        OutputStream outputStream;
        BufferedWriter bufferedWriter;
        BufferedWriter bufferedWriter2 = null;
        try {
            outputStream = httpURLConnection.getOutputStream();
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            outputStream = null;
        }
        try {
            bufferedWriter.write(str);
            bufferedWriter.flush();
            bufferedWriter.close();
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedWriter2 = bufferedWriter;
            if (bufferedWriter2 != null) {
                bufferedWriter2.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            throw th;
        }
    }

    public void a(Map<String, String> map) {
        if (this.f10599f != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.f10599f.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    private HttpURLConnection a(HttpURLConnection httpURLConnection) {
        while (true) {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 302 && responseCode != 301) {
                    return httpURLConnection;
                }
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(httpURLConnection.getHeaderField("Location")).openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(httpURLConnection2.getConnectTimeout());
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.setRequestProperty("Range", "bytes=0-");
                    httpURLConnection = httpURLConnection2;
                } catch (Exception unused) {
                    return httpURLConnection2;
                }
            } catch (Exception unused2) {
                return httpURLConnection;
            }
        }
    }

    public void a(b bVar) {
        this.f10601h = bVar;
    }

    public void a(c cVar) {
        this.f10602i = cVar;
    }

    public void a(int i6) {
        this.f10607n = i6;
    }

    public void a(Uri.Builder builder) {
        this.f10610q = builder;
    }

    public void a(String str) {
        this.f10606m = str;
    }
}
