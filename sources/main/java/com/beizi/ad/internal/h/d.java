package com.beizi.ad.internal.h;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class d extends AsyncTask<Void, Void, e> {

    /* renamed from: a, reason: collision with root package name */
    private static String f12065a = "HTTPGet";

    /* renamed from: b, reason: collision with root package name */
    private boolean f12066b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f12067c;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ba, code lost:
    
        if (0 == 0) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a1, code lost:
    
        if (0 == 0) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0059 A[Catch: all -> 0x001a, Exception -> 0x0099, IOException -> 0x00a7, MalformedURLException -> 0x00b2, TryCatch #3 {MalformedURLException -> 0x00b2, IOException -> 0x00a7, Exception -> 0x0099, blocks: (B:3:0x0007, B:5:0x0016, B:8:0x001d, B:13:0x0054, B:15:0x0059, B:16:0x0065, B:18:0x0069, B:19:0x0076, B:21:0x007d, B:23:0x0081, B:25:0x0088, B:26:0x0092), top: B:2:0x0007, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0069 A[Catch: all -> 0x001a, Exception -> 0x0099, IOException -> 0x00a7, MalformedURLException -> 0x00b2, TryCatch #3 {MalformedURLException -> 0x00b2, IOException -> 0x00a7, Exception -> 0x0099, blocks: (B:3:0x0007, B:5:0x0016, B:8:0x001d, B:13:0x0054, B:15:0x0059, B:16:0x0065, B:18:0x0069, B:19:0x0076, B:21:0x007d, B:23:0x0081, B:25:0x0088, B:26:0x0092), top: B:2:0x0007, outer: #3 }] */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.beizi.ad.internal.h.e doInBackground(java.lang.Void... r8) {
        /*
            r7 = this;
            com.beizi.ad.internal.h.e r8 = new com.beizi.ad.internal.h.e
            r8.<init>()
            r0 = 0
            r1 = 0
            java.net.URL r2 = new java.net.URL     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L99 java.io.IOException -> La7 java.net.MalformedURLException -> Lb2
            java.lang.String r3 = r7.a()     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L99 java.io.IOException -> La7 java.net.MalformedURLException -> Lb2
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L99 java.io.IOException -> La7 java.net.MalformedURLException -> Lb2
            java.lang.String r3 = r2.getHost()     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L99 java.io.IOException -> La7 java.net.MalformedURLException -> Lb2
            if (r3 != 0) goto L1d
            r8.a(r0)     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L99 java.io.IOException -> La7 java.net.MalformedURLException -> Lb2
            return r8
        L1a:
            r8 = move-exception
            goto Lbe
        L1d:
            java.net.HttpURLConnection r1 = r7.a(r2)     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L99 java.io.IOException -> La7 java.net.MalformedURLException -> Lb2
            r7.a(r1)     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L99 java.io.IOException -> La7 java.net.MalformedURLException -> Lb2
            r1.connect()     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L99 java.io.IOException -> La7 java.net.MalformedURLException -> Lb2
            int r2 = r1.getResponseCode()     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L99 java.io.IOException -> La7 java.net.MalformedURLException -> Lb2
            java.lang.String r3 = com.beizi.ad.internal.h.d.f12065a     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L99 java.io.IOException -> La7 java.net.MalformedURLException -> Lb2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L99 java.io.IOException -> La7 java.net.MalformedURLException -> Lb2
            r4.<init>()     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L99 java.io.IOException -> La7 java.net.MalformedURLException -> Lb2
            java.lang.String r5 = "HTTPGet code:"
            r4.append(r5)     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L99 java.io.IOException -> La7 java.net.MalformedURLException -> Lb2
            r4.append(r2)     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L99 java.io.IOException -> La7 java.net.MalformedURLException -> Lb2
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L99 java.io.IOException -> La7 java.net.MalformedURLException -> Lb2
            com.beizi.ad.lance.a.m.a(r3, r4)     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L99 java.io.IOException -> La7 java.net.MalformedURLException -> Lb2
            java.util.Map r3 = r1.getHeaderFields()     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L99 java.io.IOException -> La7 java.net.MalformedURLException -> Lb2
            r8.a(r3)     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L99 java.io.IOException -> La7 java.net.MalformedURLException -> Lb2
            r3 = 200(0xc8, float:2.8E-43)
            r4 = 302(0x12e, float:4.23E-43)
            if (r2 == r3) goto L53
            if (r2 != r4) goto L51
            goto L53
        L51:
            r3 = 0
            goto L54
        L53:
            r3 = 1
        L54:
            r8.a(r3)     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L99 java.io.IOException -> La7 java.net.MalformedURLException -> Lb2
            if (r2 != r4) goto L65
            r8.a(r2)     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L99 java.io.IOException -> La7 java.net.MalformedURLException -> Lb2
            java.lang.String r2 = "Location"
            java.lang.String r2 = r1.getHeaderField(r2)     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L99 java.io.IOException -> La7 java.net.MalformedURLException -> Lb2
            r8.b(r2)     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L99 java.io.IOException -> La7 java.net.MalformedURLException -> Lb2
        L65:
            boolean r2 = r7.f12067c     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L99 java.io.IOException -> La7 java.net.MalformedURLException -> Lb2
            if (r2 == 0) goto L95
            java.io.InputStream r2 = r1.getInputStream()     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L99 java.io.IOException -> La7 java.net.MalformedURLException -> Lb2
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L99 java.io.IOException -> La7 java.net.MalformedURLException -> Lb2
            r3.<init>()     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L99 java.io.IOException -> La7 java.net.MalformedURLException -> Lb2
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L99 java.io.IOException -> La7 java.net.MalformedURLException -> Lb2
        L76:
            int r5 = r2.read(r4)     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L99 java.io.IOException -> La7 java.net.MalformedURLException -> Lb2
            r6 = -1
            if (r5 == r6) goto L81
            r3.write(r4, r0, r5)     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L99 java.io.IOException -> La7 java.net.MalformedURLException -> Lb2
            goto L76
        L81:
            r2.close()     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L99 java.io.IOException -> La7 java.net.MalformedURLException -> Lb2
            boolean r2 = r7.f12066b     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L99 java.io.IOException -> La7 java.net.MalformedURLException -> Lb2
            if (r2 != 0) goto L92
            java.lang.String r2 = "UTF-8"
            java.lang.String r2 = r3.toString(r2)     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L99 java.io.IOException -> La7 java.net.MalformedURLException -> Lb2
            r8.a(r2)     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L99 java.io.IOException -> La7 java.net.MalformedURLException -> Lb2
            goto L95
        L92:
            r8.a(r3)     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L99 java.io.IOException -> La7 java.net.MalformedURLException -> Lb2
        L95:
            r1.disconnect()
            return r8
        L99:
            r8.a(r0)     // Catch: java.lang.Throwable -> L1a
            com.beizi.ad.internal.h.h r0 = com.beizi.ad.internal.h.h.TRANSPORT_ERROR     // Catch: java.lang.Throwable -> L1a
            r8.a(r0)     // Catch: java.lang.Throwable -> L1a
            if (r1 == 0) goto Lbd
        La3:
            r1.disconnect()
            goto Lbd
        La7:
            r8.a(r0)     // Catch: java.lang.Throwable -> L1a
            com.beizi.ad.internal.h.h r0 = com.beizi.ad.internal.h.h.TRANSPORT_ERROR     // Catch: java.lang.Throwable -> L1a
            r8.a(r0)     // Catch: java.lang.Throwable -> L1a
            if (r1 == 0) goto Lbd
            goto La3
        Lb2:
            r8.a(r0)     // Catch: java.lang.Throwable -> L1a
            com.beizi.ad.internal.h.h r0 = com.beizi.ad.internal.h.h.URL_FORMAT_ERROR     // Catch: java.lang.Throwable -> L1a
            r8.a(r0)     // Catch: java.lang.Throwable -> L1a
            if (r1 == 0) goto Lbd
            goto La3
        Lbd:
            return r8
        Lbe:
            if (r1 == 0) goto Lc3
            r1.disconnect()
        Lc3:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.ad.internal.h.d.doInBackground(java.lang.Void[]):com.beizi.ad.internal.h.e");
    }

    protected abstract String a();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public abstract void onPostExecute(e eVar);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    @TargetApi(11)
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onCancelled(e eVar) {
        super.onCancelled(null);
    }

    public d(boolean z5, boolean z6) {
        this.f12066b = z5;
        this.f12067c = z6;
    }

    private HttpURLConnection a(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setDoOutput(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestMethod("GET");
        return httpURLConnection;
    }

    private void a(HttpURLConnection httpURLConnection) throws ProtocolException {
        httpURLConnection.setRequestProperty("User-Agent", com.beizi.ad.internal.h.a().f12000e);
    }
}
