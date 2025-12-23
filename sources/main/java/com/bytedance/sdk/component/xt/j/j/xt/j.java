package com.bytedance.sdk.component.xt.j.j.xt;

import android.text.TextUtils;
import com.bytedance.sdk.component.cw.xt.l;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.component.xt.j.av;
import com.bytedance.sdk.component.xt.j.az;
import com.bytedance.sdk.component.xt.j.g;
import com.bytedance.sdk.component.xt.j.ws;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements com.bytedance.sdk.component.xt.j.xt {

    /* renamed from: j, reason: collision with root package name */
    ws f27281j;

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f27282m;
    r xt;
    private AtomicBoolean up = new AtomicBoolean(false);
    final String cw = com.bytedance.sdk.component.xt.j.xt.r.j(UUID.randomUUID().toString()).j();

    /* renamed from: r, reason: collision with root package name */
    l f27283r = new l();

    /* renamed from: com.bytedance.sdk.component.xt.j.j.xt.j$j, reason: collision with other inner class name */
    final class C0425j extends com.bytedance.sdk.component.xt.j.xt.up {
        private final com.bytedance.sdk.component.xt.j.cw cw;

        /* renamed from: r, reason: collision with root package name */
        private final j f27286r;

        C0425j(com.bytedance.sdk.component.xt.j.cw cwVar, j jVar) {
            super("net-async-call", new Object[0]);
            this.cw = cwVar;
            this.f27286r = jVar;
        }

        public void j() {
            l lVar;
            j jVar = this.f27286r;
            if (jVar == null || (lVar = jVar.f27283r) == null) {
                return;
            }
            lVar.qv();
        }

        @Override // com.bytedance.sdk.component.xt.j.xt.up
        protected void xt() {
            l lVar;
            try {
                j jVar = this.f27286r;
                if (jVar != null && (lVar = jVar.f27283r) != null) {
                    lVar.j();
                }
                av r5 = j.this.r();
                if (r5 == null) {
                    this.cw.onFailure(j.this, new IOException("response is null"));
                } else {
                    this.cw.onResponse(j.this, r5);
                }
            } catch (Throwable th) {
                try {
                    if (th instanceof IOException) {
                        this.cw.onFailure(j.this, th);
                    } else {
                        this.cw.onFailure(j.this, new IOException(th));
                    }
                    try {
                        this.f27286r.xt.xt(this);
                    } catch (Throwable th2) {
                        vl.j(th2);
                    }
                } finally {
                    try {
                        this.f27286r.xt.xt(this);
                    } catch (Throwable th3) {
                        vl.j(th3);
                    }
                }
            }
        }
    }

    private boolean cw(az azVar) {
        ws wsVar;
        return (azVar == null || (wsVar = this.f27281j) == null || !"POST".equalsIgnoreCase(wsVar.cw()) || azVar.f27267m != az.j.STRING_TYPE || TextUtils.isEmpty(azVar.f27268r)) ? false : true;
    }

    private boolean xt(az azVar) {
        ws wsVar;
        byte[] bArr;
        return azVar != null && (wsVar = this.f27281j) != null && "POST".equalsIgnoreCase(wsVar.cw()) && azVar.f27267m == az.j.BYTE_ARRAY_TYPE && (bArr = azVar.up) != null && bArr.length > 0;
    }

    @Override // com.bytedance.sdk.component.xt.j.xt
    public void j(com.bytedance.sdk.component.xt.j.cw cwVar) {
        try {
            synchronized (this) {
                if (this.f27282m) {
                    throw new IllegalStateException("Already Executed");
                }
                this.f27282m = true;
            }
            this.xt.j(new C0425j(cwVar, this));
        } catch (Throwable th) {
            if (cwVar != null) {
                cwVar.onFailure(this, new IOException(th.getMessage()));
            }
        }
    }

    private boolean m() {
        if (this.f27281j.r() == null) {
            return false;
        }
        return this.f27281j.r().containsKey("Content-Type");
    }

    public av r() {
        List<g> list;
        if (this.up.get()) {
            return null;
        }
        try {
            com.bytedance.sdk.component.xt.j.vl vlVar = this.f27281j.f27316j;
            if (vlVar == null || (list = vlVar.f27308j) == null || list.size() <= 0) {
                return j(this.f27281j);
            }
            ArrayList arrayList = new ArrayList(this.f27281j.f27316j.f27308j);
            arrayList.add(new g() { // from class: com.bytedance.sdk.component.xt.j.j.xt.j.1
                @Override // com.bytedance.sdk.component.xt.j.g
                public av j(g.j jVar) throws IOException {
                    return j.this.j(jVar.j());
                }
            });
            return ((g) arrayList.get(0)).j(new xt(arrayList, this.f27281j));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: up, reason: merged with bridge method [inline-methods] */
    public com.bytedance.sdk.component.xt.j.xt clone() {
        return new j(this.f27281j, this.xt);
    }

    j(ws wsVar, r rVar) {
        this.f27281j = wsVar;
        this.xt = rVar;
    }

    @Override // com.bytedance.sdk.component.xt.j.xt
    public boolean cw() {
        return this.up.get();
    }

    @Override // com.bytedance.sdk.component.xt.j.xt
    public void xt() {
        this.up.set(true);
    }

    @Override // com.bytedance.sdk.component.xt.j.xt
    public av j() throws IOException {
        synchronized (this) {
            if (!this.f27282m) {
                this.f27282m = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        try {
            this.xt.j(this);
            return r();
        } finally {
            this.xt.xt(this);
        }
    }

    public av j(ws wsVar) throws IOException {
        try {
            l lVar = this.f27283r;
            if (lVar != null) {
                lVar.xt();
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(wsVar.xt().j().toString()).openConnection();
            if (wsVar.r() != null && wsVar.r().size() > 0) {
                for (Map.Entry<String, List<String>> entry : wsVar.r().entrySet()) {
                    Iterator<String> it = entry.getValue().iterator();
                    while (it.hasNext()) {
                        httpURLConnection.addRequestProperty(entry.getKey(), it.next());
                    }
                }
            }
            com.bytedance.sdk.component.xt.j.vl vlVar = wsVar.f27316j;
            if (vlVar != null) {
                TimeUnit timeUnit = vlVar.cw;
                if (timeUnit != null) {
                    httpURLConnection.setConnectTimeout((int) timeUnit.toMillis(vlVar.xt));
                }
                com.bytedance.sdk.component.xt.j.vl vlVar2 = wsVar.f27316j;
                TimeUnit timeUnit2 = vlVar2.up;
                if (timeUnit2 != null) {
                    httpURLConnection.setReadTimeout((int) timeUnit2.toMillis(vlVar2.f27310r));
                }
            }
            if (wsVar.m() == null) {
                httpURLConnection.setRequestMethod("GET");
            } else {
                if (!m() && wsVar.m().cw != null) {
                    httpURLConnection.addRequestProperty("Content-Type", wsVar.m().cw.toString());
                }
                httpURLConnection.setRequestMethod(wsVar.cw());
                if (j(wsVar.m())) {
                    j(httpURLConnection);
                }
                if ("POST".equalsIgnoreCase(wsVar.cw())) {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    if (cw(wsVar.m())) {
                        outputStream.write(wsVar.m().f27268r.getBytes());
                    } else if (j(wsVar.m())) {
                        j(wsVar.m().up, outputStream, wsVar.m().xt(), wsVar.m().j());
                    } else if (xt(wsVar.m())) {
                        outputStream.write(wsVar.m().up);
                    }
                    outputStream.flush();
                    outputStream.close();
                }
            }
            httpURLConnection.connect();
            long currentTimeMillis = System.currentTimeMillis();
            l lVar2 = this.f27283r;
            if (lVar2 != null) {
                lVar2.cw();
                this.f27283r.j(currentTimeMillis);
            }
            httpURLConnection.getResponseCode();
            long currentTimeMillis2 = System.currentTimeMillis();
            if (this.up.get()) {
                httpURLConnection.disconnect();
                return null;
            }
            m mVar = new m(httpURLConnection, wsVar);
            mVar.f27288r = currentTimeMillis;
            mVar.cw = currentTimeMillis2;
            l lVar3 = this.f27283r;
            if (lVar3 != null) {
                lVar3.xt(currentTimeMillis2);
            }
            mVar.up = this.f27283r;
            return mVar;
        } catch (Exception e6) {
            throw new IOException(e6);
        }
    }

    private void j(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return;
        }
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + this.cw);
    }

    private void j(byte[] bArr, OutputStream outputStream, String str, String str2) throws IOException {
        if (bArr == null || outputStream == null) {
            return;
        }
        PrintWriter printWriter = new PrintWriter((Writer) new OutputStreamWriter(outputStream, "UTF-8"), true);
        printWriter.append((CharSequence) ("--" + this.cw)).append((CharSequence) org.apache.commons.net.g.f50795q);
        printWriter.append((CharSequence) ("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + str2 + "\"")).append((CharSequence) org.apache.commons.net.g.f50795q);
        printWriter.append((CharSequence) "Content-Type: multipart/form-data").append((CharSequence) org.apache.commons.net.g.f50795q);
        StringBuilder sb = new StringBuilder("Content-Length: ");
        sb.append(bArr.length);
        printWriter.append((CharSequence) sb.toString()).append((CharSequence) org.apache.commons.net.g.f50795q);
        printWriter.append((CharSequence) org.apache.commons.net.g.f50795q);
        printWriter.flush();
        outputStream.write(bArr);
        printWriter.append((CharSequence) org.apache.commons.net.g.f50795q);
        printWriter.append((CharSequence) ("--" + this.cw + "--")).append((CharSequence) org.apache.commons.net.g.f50795q);
        printWriter.flush();
        printWriter.close();
    }

    private boolean j(az azVar) {
        ws wsVar;
        byte[] bArr;
        return azVar != null && (wsVar = this.f27281j) != null && "POST".equalsIgnoreCase(wsVar.cw()) && azVar.f27267m == az.j.FILE_TYPE && (bArr = azVar.up) != null && bArr.length > 0;
    }
}
