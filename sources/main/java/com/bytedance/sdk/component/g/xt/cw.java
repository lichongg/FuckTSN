package com.bytedance.sdk.component.g.xt;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.xt.j.ae;
import com.bytedance.sdk.component.xt.j.av;
import com.bytedance.sdk.component.xt.j.i;
import com.bytedance.sdk.component.xt.j.j;
import com.bytedance.sdk.component.xt.j.m;
import com.bytedance.sdk.component.xt.j.vl;
import com.bytedance.sdk.component.xt.j.ws;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw extends r {

    /* renamed from: j, reason: collision with root package name */
    public static final com.bytedance.sdk.component.xt.j.j f26453j = new j.C0424j().j().xt();
    public static final com.bytedance.sdk.component.xt.j.j xt = new j.C0424j().xt();

    /* renamed from: g, reason: collision with root package name */
    private boolean f26454g;
    private Map<String, String> oq;
    private com.bytedance.sdk.component.xt.j.j tl;

    public void j(String str, String str2) {
        if (str == null) {
            com.bytedance.sdk.component.g.r.up.j("GetExecutor", "name cannot be null !!!");
        } else {
            this.oq.put(str, str2);
        }
    }

    public cw(vl vlVar) {
        super(vlVar);
        this.tl = f26453j;
        this.f26454g = false;
        this.oq = new HashMap();
    }

    public void j(final com.bytedance.sdk.component.g.j.j jVar) {
        try {
            ws.j jVar2 = new ws.j();
            if (this.f26454g) {
                jVar2.j(this.f26458m);
            } else {
                ae.j jVar3 = new ae.j();
                Uri parse = Uri.parse(this.f26458m);
                jVar3.j(parse.getScheme());
                jVar3.xt(parse.getHost());
                String encodedPath = parse.getEncodedPath();
                if (!TextUtils.isEmpty(encodedPath)) {
                    if (encodedPath.startsWith("/")) {
                        encodedPath = encodedPath.substring(1);
                    }
                    jVar3.cw(encodedPath);
                }
                Set<String> queryParameterNames = parse.getQueryParameterNames();
                if (queryParameterNames != null && queryParameterNames.size() > 0) {
                    for (String str : queryParameterNames) {
                        this.oq.put(str, parse.getQueryParameter(str));
                    }
                }
                for (Map.Entry<String, String> entry : this.oq.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key)) {
                        String encode = URLEncoder.encode(key, "UTF-8");
                        if (value == null) {
                            value = "";
                        }
                        jVar3.j(encode, URLEncoder.encode(value, "UTF-8"));
                    }
                }
                jVar2.j(jVar3.xt());
            }
            j(jVar2);
            jVar2.j(this.tl);
            jVar2.j((Object) xt());
            this.cw.j(jVar2.j().xt()).j(new com.bytedance.sdk.component.xt.j.cw() { // from class: com.bytedance.sdk.component.g.xt.cw.1
                @Override // com.bytedance.sdk.component.xt.j.cw
                public void onFailure(com.bytedance.sdk.component.xt.j.xt xtVar, IOException iOException) {
                    com.bytedance.sdk.component.g.j.j jVar4 = jVar;
                    if (jVar4 != null) {
                        jVar4.j(cw.this, iOException);
                    }
                }

                @Override // com.bytedance.sdk.component.xt.j.cw
                public void onResponse(com.bytedance.sdk.component.xt.j.xt xtVar, av avVar) throws IOException {
                    if (jVar != null) {
                        HashMap hashMap = new HashMap();
                        if (avVar != null) {
                            m ae = avVar.ae();
                            if (ae != null) {
                                for (int i6 = 0; i6 < ae.j(); i6++) {
                                    hashMap.put(ae.j(i6), ae.xt(i6));
                                }
                            }
                            i m6 = avVar.m();
                            jVar.j(cw.this, new com.bytedance.sdk.component.g.xt(avVar.r(), avVar.cw(), avVar.up(), hashMap, m6 == null ? "" : m6.xt(), avVar.xt(), avVar.j()));
                        }
                    }
                }
            });
        } catch (Throwable th) {
            if (com.bytedance.sdk.component.g.r.up.j()) {
                com.bytedance.sdk.component.utils.vl.j(th);
            }
            if (jVar != null) {
                jVar.j(this, new IOException(th.getMessage()));
            }
        }
    }

    @Override // com.bytedance.sdk.component.g.xt.r
    public com.bytedance.sdk.component.g.xt j() {
        try {
            ws.j jVar = new ws.j();
            if (this.f26454g) {
                jVar.j(this.f26458m);
            } else {
                ae.j jVar2 = new ae.j();
                Uri parse = Uri.parse(this.f26458m);
                jVar2.j(parse.getScheme());
                jVar2.xt(parse.getHost());
                String encodedPath = parse.getEncodedPath();
                if (!TextUtils.isEmpty(encodedPath)) {
                    if (encodedPath.startsWith("/")) {
                        encodedPath = encodedPath.substring(1);
                    }
                    jVar2.cw(encodedPath);
                }
                Set<String> queryParameterNames = parse.getQueryParameterNames();
                if (queryParameterNames != null && queryParameterNames.size() > 0) {
                    for (String str : queryParameterNames) {
                        this.oq.put(str, parse.getQueryParameter(str));
                    }
                }
                for (Map.Entry<String, String> entry : this.oq.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key)) {
                        String encode = URLEncoder.encode(key, "UTF-8");
                        if (value == null) {
                            value = "";
                        }
                        jVar2.j(encode, URLEncoder.encode(value, "UTF-8"));
                    }
                }
                jVar.j(jVar2.xt());
            }
            j(jVar);
            jVar.j(this.tl);
            jVar.j((Object) xt());
            av j6 = this.cw.j(jVar.j().xt()).j();
            if (j6 == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            m ae = j6.ae();
            if (ae != null) {
                for (int i6 = 0; i6 < ae.j(); i6++) {
                    hashMap.put(ae.j(i6), ae.xt(i6));
                }
            }
            i m6 = j6.m();
            return new com.bytedance.sdk.component.g.xt(j6.r(), j6.cw(), j6.up(), hashMap, m6 != null ? m6.xt() : "", j6.xt(), j6.j());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
            return null;
        }
    }
}
