package com.bytedance.sdk.component.xt.j.j.xt;

import android.text.TextUtils;
import com.bytedance.sdk.component.cw.xt.l;
import com.bytedance.sdk.component.xt.j.av;
import com.bytedance.sdk.component.xt.j.i;
import com.bytedance.sdk.component.xt.j.jy;
import com.bytedance.sdk.component.xt.j.qv;
import com.bytedance.sdk.component.xt.j.ws;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m extends av {
    public long cw;

    /* renamed from: j, reason: collision with root package name */
    HttpURLConnection f27287j;

    /* renamed from: r, reason: collision with root package name */
    public long f27288r;
    l up = null;
    ws xt;

    @Override // com.bytedance.sdk.component.xt.j.av
    public long j() {
        return this.cw;
    }

    @Override // com.bytedance.sdk.component.xt.j.av
    public com.bytedance.sdk.component.xt.j.m ae() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<String>> entry : this.f27287j.getHeaderFields().entrySet()) {
            for (String str : entry.getValue()) {
                if (!"Content-Range".equalsIgnoreCase(entry.getKey()) || cw() != 206) {
                    arrayList.add(entry.getKey());
                    arrayList.add(str);
                }
            }
        }
        return new com.bytedance.sdk.component.xt.j.m((String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    @Override // com.bytedance.sdk.component.xt.j.av
    public int cw() {
        try {
            return this.f27287j.getResponseCode();
        } catch (Exception unused) {
            return -1;
        }
    }

    @Override // com.bytedance.sdk.component.xt.j.av
    public qv g() {
        return new qv(this.up);
    }

    @Override // com.bytedance.sdk.component.xt.j.av
    public String j(String str) {
        return this.f27287j.getHeaderField(str);
    }

    @Override // com.bytedance.sdk.component.xt.j.av
    public i m() {
        try {
            return new ae(this.f27287j);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.xt.j.av
    public jy tl() {
        return jy.HTTP_1_1;
    }

    public String toString() {
        return "";
    }

    @Override // com.bytedance.sdk.component.xt.j.av
    public String up() throws IOException {
        return this.f27287j.getResponseMessage();
    }

    @Override // com.bytedance.sdk.component.xt.j.av
    public long xt() {
        return this.f27288r;
    }

    public m(HttpURLConnection httpURLConnection, ws wsVar) {
        this.f27287j = httpURLConnection;
        this.xt = wsVar;
    }

    @Override // com.bytedance.sdk.component.xt.j.av, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            m().close();
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.xt.j.av
    public String j(String str, String str2) {
        return !TextUtils.isEmpty(j(str)) ? j(str) : str2;
    }

    @Override // com.bytedance.sdk.component.xt.j.av
    public boolean r() {
        if (cw() >= 200 && cw() < 300) {
            return true;
        }
        return false;
    }
}
