package com.baidu.liantian.b;

import android.accounts.NetworkErrorException;
import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Objects;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.X509TrustManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"NewApi"})
/* loaded from: D:\Downloads\app\classes2.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    Context f10367a;

    /* renamed from: b, reason: collision with root package name */
    byte[] f10368b;

    /* renamed from: c, reason: collision with root package name */
    private String f10369c;

    /* renamed from: d, reason: collision with root package name */
    private String f10370d;

    /* renamed from: e, reason: collision with root package name */
    private int f10371e;

    /* renamed from: f, reason: collision with root package name */
    private int f10372f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f10373g;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements X509TrustManager {

        /* renamed from: b, reason: collision with root package name */
        private X509TrustManager f10375b;

        a(X509TrustManager x509TrustManager) {
            this.f10375b = x509TrustManager;
        }

        @Override // javax.net.ssl.X509TrustManager
        public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            com.baidu.liantian.b.a();
            this.f10375b.checkClientTrusted(x509CertificateArr, str);
        }

        @Override // javax.net.ssl.X509TrustManager
        public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            com.baidu.liantian.b.a();
            try {
                this.f10375b.checkServerTrusted(x509CertificateArr, str);
                com.baidu.liantian.b.a();
            } catch (Throwable th) {
                e.a();
                for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
                    if ((th2 instanceof CertificateExpiredException) || (th2 instanceof CertificateNotYetValidException)) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("0", Long.valueOf(System.currentTimeMillis()));
                        e.a(StubApp.getOrigApplicationContext(m.this.f10367a.getApplicationContext()), "1003121", hashMap);
                        return;
                    }
                }
                if (th instanceof CertificateException) {
                    throw th;
                }
                throw new CertificateException();
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public final X509Certificate[] getAcceptedIssuers() {
            com.baidu.liantian.b.a();
            return this.f10375b.getAcceptedIssuers();
        }
    }

    public m(Context context) {
        this.f10368b = new byte[8192];
        this.f10371e = 120000;
        this.f10372f = 120000;
        this.f10373g = false;
        this.f10367a = context;
    }

    private void a(String str, String str2) {
        this.f10369c = str;
        this.f10370d = str2;
    }

    private static byte[] b(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00ec A[Catch: all -> 0x0110, TRY_LEAVE, TryCatch #0 {all -> 0x0110, blocks: (B:35:0x00d4, B:29:0x00ec, B:39:0x00cf, B:41:0x00c2, B:32:0x00bb, B:37:0x00c8), top: B:25:0x00b9, inners: #1, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00bb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.net.HttpURLConnection a() {
        /*
            Method dump skipped, instructions count: 450
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.b.m.a():java.net.HttpURLConnection");
    }

    public m(Context context, byte b6) {
        this.f10368b = new byte[8192];
        this.f10371e = 120000;
        this.f10372f = 120000;
        this.f10373g = false;
        this.f10367a = context;
    }

    private InputStream a(byte[] bArr, HttpURLConnection httpURLConnection) {
        OutputStream outputStream = null;
        if (httpURLConnection == null) {
            return null;
        }
        try {
            try {
                if (bArr == null) {
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        String contentEncoding = httpURLConnection.getContentEncoding();
                        if (!TextUtils.isEmpty(contentEncoding) && "gzip".equalsIgnoreCase(contentEncoding)) {
                            this.f10373g = true;
                        } else {
                            this.f10373g = false;
                        }
                        return httpURLConnection.getInputStream();
                    }
                    throw new NetworkErrorException(String.valueOf(responseCode));
                }
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                try {
                    bufferedOutputStream.write(bArr);
                    bufferedOutputStream.flush();
                    int responseCode2 = httpURLConnection.getResponseCode();
                    if (responseCode2 == 200) {
                        if ("gzip".equalsIgnoreCase(httpURLConnection.getContentEncoding())) {
                            this.f10373g = true;
                        } else {
                            this.f10373g = false;
                        }
                        InputStream inputStream = httpURLConnection.getInputStream();
                        try {
                            bufferedOutputStream.close();
                        } catch (Throwable unused) {
                        }
                        return inputStream;
                    }
                    throw new NetworkErrorException(String.valueOf(responseCode2));
                } catch (NetworkErrorException e6) {
                    throw e6;
                } catch (IOException e7) {
                    throw e7;
                } catch (Throwable unused2) {
                    e.a();
                    throw new IOException();
                }
            } catch (NetworkErrorException e8) {
                throw e8;
            } catch (IOException e9) {
                throw e9;
            } catch (Throwable unused3) {
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    outputStream.close();
                } catch (Throwable unused4) {
                }
            }
            throw th;
        }
    }

    private InputStream a(HttpURLConnection httpURLConnection) {
        if (!e.f(this.f10367a) || httpURLConnection == null) {
            return null;
        }
        try {
            if ("gzip".equalsIgnoreCase(httpURLConnection.getContentEncoding())) {
                this.f10373g = true;
            } else {
                this.f10373g = false;
            }
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            e.a();
            return null;
        }
    }

    private String a(InputStream inputStream) {
        if (inputStream != null) {
            byte[] b6 = b(inputStream);
            if (b6 != null) {
                if (this.f10373g) {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(b6);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    j.b(byteArrayInputStream, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    byteArrayInputStream.close();
                    b6 = byteArray;
                }
                if (b6 != null) {
                    return new String(b6);
                }
                throw new IOException();
            }
            throw new NullPointerException("responseBytes");
        }
        throw new NullPointerException("InputStream");
    }

    public final String a(String str, byte[] bArr) {
        HttpURLConnection httpURLConnection;
        s.a();
        try {
            a("POST", str);
            InputStream inputStream = null;
            try {
                httpURLConnection = a();
            } catch (Throwable th) {
                th = th;
                httpURLConnection = null;
            }
            try {
                inputStream = a(bArr, httpURLConnection);
                String a6 = a(inputStream);
                if (inputStream != null) {
                    inputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                s.b();
                return a6;
            } catch (Throwable th2) {
                th = th2;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th3) {
            s.b();
            throw th3;
        }
    }

    public final String a(String str) {
        HttpURLConnection httpURLConnection;
        s.a();
        try {
            com.baidu.liantian.b.a();
            InputStream inputStream = null;
            try {
                a("GET", str);
                httpURLConnection = a();
            } catch (Throwable th) {
                th = th;
                httpURLConnection = null;
            }
            try {
                inputStream = a((byte[]) null, httpURLConnection);
                String a6 = a(inputStream);
                if (inputStream != null) {
                    inputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                s.b();
                return a6;
            } catch (Throwable th2) {
                th = th2;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th3) {
            s.b();
            throw th3;
        }
    }

    public final boolean a(String str, File file) {
        HttpURLConnection httpURLConnection;
        s.a();
        try {
            com.baidu.liantian.b.a();
            if (!e.f(this.f10367a)) {
                s.b();
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                s.b();
                return false;
            }
            Objects.toString(file);
            com.baidu.liantian.b.a();
            InputStream inputStream = null;
            try {
                a("GET", str);
                httpURLConnection = a();
                try {
                    inputStream = a(httpURLConnection);
                    boolean a6 = a(inputStream, file);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable unused) {
                            e.a();
                            s.b();
                            return false;
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    s.b();
                    return a6;
                } catch (Throwable unused2) {
                    try {
                        e.a();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable unused3) {
                                e.a();
                                s.b();
                                return false;
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        s.b();
                        return false;
                    } catch (Throwable th) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable unused4) {
                                e.a();
                                s.b();
                                return false;
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                }
            } catch (Throwable unused5) {
                httpURLConnection = null;
            }
        } catch (Throwable th2) {
            s.b();
            throw th2;
        }
    }

    private boolean a(InputStream inputStream, File file) {
        BufferedOutputStream bufferedOutputStream;
        if (this.f10373g) {
            try {
                inputStream = new GZIPInputStream(inputStream);
            } catch (IOException unused) {
                e.a();
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
                            e.a();
                            return true;
                        }
                    }
                }
            } catch (Throwable unused3) {
                try {
                    e.a();
                    return false;
                } finally {
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException unused4) {
                            e.a();
                        }
                    }
                }
            }
        } catch (Throwable unused5) {
            bufferedOutputStream = null;
        }
    }
}
