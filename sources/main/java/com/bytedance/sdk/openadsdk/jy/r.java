package com.bytedance.sdk.openadsdk.jy;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.acse.ottn.l3;
import com.baidu.mobads.sdk.internal.ca;
import com.bytedance.sdk.component.oq.ae;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.component.utils.ws;
import com.bytedance.sdk.component.xt.j.av;
import com.bytedance.sdk.component.xt.j.m;
import com.bytedance.sdk.component.xt.j.oq;
import com.bytedance.sdk.component.xt.j.ws;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.v.up;
import com.bytedance.sdk.openadsdk.jy.j.j;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r implements j {

    /* renamed from: j, reason: collision with root package name */
    public static final AtomicInteger f31540j = new AtomicInteger(0);

    /* renamed from: m, reason: collision with root package name */
    private String f31541m;

    /* renamed from: r, reason: collision with root package name */
    private List<com.bytedance.sdk.openadsdk.jy.j.j> f31542r = new ArrayList();
    private HashMap<String, HashMap<String, byte[]>> up = new HashMap<>();
    public AtomicInteger xt = new AtomicInteger(0);
    final ExecutorService cw = ae.j();

    public static boolean cw() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.jy.j
    public AtomicInteger xt() {
        return this.xt;
    }

    @Override // com.bytedance.sdk.openadsdk.jy.j
    public HashMap<String, HashMap<String, byte[]>> j() {
        return this.up;
    }

    public void r() {
        if (!this.f31542r.isEmpty()) {
            Iterator<com.bytedance.sdk.openadsdk.jy.j.j> it = this.f31542r.iterator();
            while (it.hasNext()) {
                it.next().cw();
            }
        }
        this.f31542r.clear();
    }

    public WebResourceResponse xt(WebView webView, final xt xtVar, WebResourceResponse webResourceResponse) {
        String xt;
        if (xtVar != null && (xt = xtVar.xt()) != null && TextUtils.equals(xt, l3.f4736f)) {
            if (v.xt().ol() == 1) {
                WebResourceResponse j6 = j(v.getContext(), this.f31541m, xtVar);
                if (j6 != null) {
                    j6.getResponseHeaders().put("Access-Control-Allow-Origin", "*");
                    return j6;
                }
            } else {
                j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.jy.r.2
                    @Override // java.lang.Runnable
                    public void run() {
                        r.this.j(v.getContext(), r.this.f31541m, xtVar);
                    }
                });
            }
        }
        return webResourceResponse;
    }

    private r(cw cwVar, String str, String str2, JSONObject jSONObject, String str3, String str4) {
        r rVar;
        String str5;
        String str6;
        JSONObject jSONObject2;
        String str7;
        String str8;
        if (cwVar != null) {
            if (cwVar.j()) {
                rVar = this;
                str5 = str;
                str6 = str2;
                jSONObject2 = jSONObject;
                str7 = str3;
                str8 = str4;
                com.bytedance.sdk.openadsdk.jy.j.xt xtVar = new com.bytedance.sdk.openadsdk.jy.j.xt(rVar, str5, str6, jSONObject2, str7, str8);
                xtVar.xt();
                rVar.f31542r.add(xtVar);
            } else {
                rVar = this;
                str5 = str;
                str6 = str2;
                jSONObject2 = jSONObject;
                str7 = str3;
                str8 = str4;
            }
            if (cwVar.xt()) {
                String str9 = str8;
                String str10 = str7;
                JSONObject jSONObject3 = jSONObject2;
                com.bytedance.sdk.openadsdk.jy.j.cw cwVar2 = new com.bytedance.sdk.openadsdk.jy.j.cw(this, str5, str6, jSONObject3, str10, str9);
                rVar = this;
                str8 = str9;
                cwVar2.xt();
                rVar.f31542r.add(cwVar2);
            }
            rVar.f31541m = str8;
            f31540j.incrementAndGet();
            j((WebView) null, rVar.f31541m);
        }
    }

    public static cw j(n nVar, Context context) {
        boolean z5 = false;
        boolean z6 = nVar.pz() == 1;
        boolean j6 = com.bytedance.sdk.openadsdk.core.m.xt.j(nVar.xt() / 100.0f, false);
        boolean z7 = v.xt().nd() == 1;
        boolean z8 = ws.r(context) || !(v.xt().b() == 1);
        boolean cw = cw();
        boolean z9 = z6 && z7 && z8 && cw;
        if (j6 && z7 && cw) {
            z5 = true;
        }
        cw cwVar = new cw();
        cwVar.j(z9);
        cwVar.xt(z5);
        return cwVar;
    }

    public static String xt(Context context) {
        return com.bytedance.sdk.openadsdk.api.plugin.xt.xt(context).getAbsolutePath() + File.separator + ".lp_cache";
    }

    public static r j(Context context, n nVar, String str) {
        JSONObject ot;
        cw j6 = j(nVar, context);
        if ((!j6.j() && !j6.xt()) || (ot = nVar.ot()) == null) {
            return null;
        }
        String optString = ot.optString("cid");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        String optString2 = ot.optString("req_id");
        if (TextUtils.isEmpty(optString2)) {
            return null;
        }
        return new r(j6, optString, optString2, ot, nVar.os(), str);
    }

    public WebResourceResponse j(WebView webView, xt xtVar, WebResourceResponse webResourceResponse) {
        Iterator<com.bytedance.sdk.openadsdk.jy.j.j> it = this.f31542r.iterator();
        boolean z5 = false;
        while (it.hasNext()) {
            if (it.next().j(webView)) {
                z5 = true;
            }
        }
        return !z5 ? webResourceResponse : xt(webView, xtVar, webResourceResponse);
    }

    @Override // com.bytedance.sdk.openadsdk.jy.j
    public void j(final Runnable runnable) {
        this.cw.submit(new Runnable() { // from class: com.bytedance.sdk.openadsdk.jy.r.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (r.this.cw) {
                    try {
                        runnable.run();
                    } finally {
                    }
                }
            }
        });
    }

    protected WebResourceResponse j(final Context context, final String str, final xt xtVar) {
        WebResourceResponse webResourceResponse;
        final Pair<WebResourceResponse, WebResourceResponse> j6;
        final Pair<WebResourceResponse, oq> j7 = j(xtVar);
        if (j7 == null || (webResourceResponse = (WebResourceResponse) j7.first) == null) {
            return null;
        }
        Iterator<com.bytedance.sdk.openadsdk.jy.j.j> it = this.f31542r.iterator();
        boolean z5 = false;
        while (it.hasNext()) {
            if (it.next().j((oq) j7.second)) {
                z5 = true;
            }
        }
        if (!z5 || (j6 = j(webResourceResponse)) == null) {
            return null;
        }
        for (final com.bytedance.sdk.openadsdk.jy.j.j jVar : this.f31542r) {
            jVar.j(xtVar, (WebResourceResponse) j6.second, (oq) j7.second, new j.InterfaceC0502j() { // from class: com.bytedance.sdk.openadsdk.jy.r.3
                @Override // com.bytedance.sdk.openadsdk.jy.j.j.InterfaceC0502j
                public void j(boolean z6, final Map<String, Object> map) {
                    if (z6) {
                        r.this.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.jy.r.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    AtomicBoolean atomicBoolean = jVar.up;
                                    if (atomicBoolean == null || atomicBoolean.get()) {
                                        return;
                                    }
                                    AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                    r.this.j(context, str, xtVar, (WebResourceResponse) j6.second, (oq) j7.second, map, jVar);
                                } catch (Throwable th) {
                                    vl.j(th);
                                }
                            }
                        });
                    }
                }
            });
        }
        return (WebResourceResponse) j6.first;
    }

    protected void j(Context context, String str, xt xtVar, WebResourceResponse webResourceResponse, oq oqVar, Map<String, Object> map, com.bytedance.sdk.openadsdk.jy.j.j jVar) {
        if (jVar.j(oqVar)) {
            v.xt().q();
            if (v.xt().q() == 1) {
                jVar.j(context, str, xtVar, webResourceResponse, oqVar, map);
            } else {
                jVar.xt(context, str, xtVar, webResourceResponse, oqVar, map);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.util.Pair<android.webkit.WebResourceResponse, android.webkit.WebResourceResponse> j(android.webkit.WebResourceResponse r13) {
        /*
            r12 = this;
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            r2 = 0
            java.io.InputStream r0 = r13.getData()     // Catch: java.lang.Exception -> L26
            int r0 = com.bytedance.sdk.openadsdk.jy.xt.xt.j(r0, r1)     // Catch: java.lang.Exception -> L26
            r3 = -1
            if (r0 == r3) goto L29
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch: java.lang.Exception -> L26
            byte[] r0 = r1.toByteArray()     // Catch: java.lang.Exception -> L26
            r3.<init>(r0)     // Catch: java.lang.Exception -> L26
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream     // Catch: java.lang.Exception -> L24
            byte[] r4 = r1.toByteArray()     // Catch: java.lang.Exception -> L24
            r0.<init>(r4)     // Catch: java.lang.Exception -> L24
            goto L38
        L24:
            r0 = move-exception
            goto L2c
        L26:
            r0 = move-exception
            r3 = r2
            goto L2c
        L29:
            r0 = r2
            r3 = r0
            goto L38
        L2c:
            com.bytedance.sdk.component.utils.vl.j(r0)
            r1.close()     // Catch: java.lang.Throwable -> L33
            goto L37
        L33:
            r0 = move-exception
            com.bytedance.sdk.component.utils.vl.j(r0)
        L37:
            r0 = r2
        L38:
            boolean r1 = cw()
            if (r1 == 0) goto L8b
            android.webkit.WebResourceResponse r4 = new android.webkit.WebResourceResponse
            java.lang.String r5 = r13.getMimeType()
            java.lang.String r6 = r13.getEncoding()
            int r7 = r13.getStatusCode()
            java.lang.String r8 = r13.getReasonPhrase()
            java.util.Map r9 = r13.getResponseHeaders()
            r1 = 0
            if (r3 != 0) goto L5e
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream
            byte[] r2 = new byte[r1]
            r3.<init>(r2)
        L5e:
            r10 = r3
            r4.<init>(r5, r6, r7, r8, r9, r10)
            android.webkit.WebResourceResponse r5 = new android.webkit.WebResourceResponse
            java.lang.String r6 = r13.getMimeType()
            java.lang.String r7 = r13.getEncoding()
            int r8 = r13.getStatusCode()
            java.lang.String r9 = r13.getReasonPhrase()
            java.util.Map r10 = r13.getResponseHeaders()
            if (r0 != 0) goto L81
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream
            byte[] r13 = new byte[r1]
            r0.<init>(r13)
        L81:
            r11 = r0
            r5.<init>(r6, r7, r8, r9, r10, r11)
            android.util.Pair r13 = new android.util.Pair
            r13.<init>(r4, r5)
            return r13
        L8b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.jy.r.j(android.webkit.WebResourceResponse):android.util.Pair");
    }

    private Pair<WebResourceResponse, oq> j(xt xtVar) {
        if (cw() && xtVar != null) {
            try {
                com.bytedance.sdk.component.xt.j.vl m6 = up.j().xt().m();
                ws.j jVar = new ws.j();
                Map<String, String> cw = xtVar.cw();
                if (cw != null) {
                    for (String str : cw.keySet()) {
                        jVar.xt(str, cw.get(str));
                    }
                }
                jVar.j(xtVar.j().toString());
                av j6 = m6.j(jVar.xt()).j();
                int cw2 = j6.cw();
                if (cw2 == 200) {
                    HashMap hashMap = new HashMap();
                    m ae = j6.ae();
                    if (ae != null) {
                        for (int i6 = 0; i6 < ae.j(); i6++) {
                            hashMap.put(ae.j(i6), ae.xt(i6));
                        }
                    }
                    InputStream cw3 = j6.m().cw();
                    oq j7 = j(hashMap);
                    return new Pair<>(new WebResourceResponse(j7.j() + "/" + j7.xt(), j7.cw() == null ? null : j7.cw().toString(), cw2, j(cw2), hashMap, cw3), j7);
                }
            } catch (Throwable th) {
                vl.j(th);
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.bytedance.sdk.component.xt.j.oq j(java.util.Map<java.lang.String, java.lang.String> r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L2f
            java.lang.String r0 = "Content-Type"
            boolean r1 = r3.containsKey(r0)
            if (r1 == 0) goto L11
            java.lang.Object r3 = r3.get(r0)
            java.lang.String r3 = (java.lang.String) r3
            goto L30
        L11:
            java.lang.String r0 = "content-type"
            boolean r1 = r3.containsKey(r0)
            if (r1 == 0) goto L20
            java.lang.Object r3 = r3.get(r0)
            java.lang.String r3 = (java.lang.String) r3
            goto L30
        L20:
            java.lang.String r0 = "CONTENT-TYPE"
            boolean r1 = r3.containsKey(r0)
            if (r1 == 0) goto L2f
            java.lang.Object r3 = r3.get(r0)
            java.lang.String r3 = (java.lang.String) r3
            goto L30
        L2f:
            r3 = 0
        L30:
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 == 0) goto L38
            java.lang.String r3 = "text/html; charset=UTF-8"
        L38:
            com.bytedance.sdk.component.xt.j.oq r3 = com.bytedance.sdk.component.xt.j.oq.j(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.jy.r.j(java.util.Map):com.bytedance.sdk.component.xt.j.oq");
    }

    public static void j(Context context) {
        if (cw()) {
            try {
                File file = new File(xt(context));
                if (System.currentTimeMillis() - file.lastModified() <= 3000 || !file.exists()) {
                    return;
                }
                com.bytedance.sdk.openadsdk.jy.xt.j.xt(xt(context));
            } catch (Throwable th) {
                vl.j(th);
            }
        }
    }

    public void j(WebView webView, String str) {
        if (com.bytedance.sdk.component.utils.ws.j(str)) {
            this.xt.incrementAndGet();
            this.xt.get();
            Iterator<com.bytedance.sdk.openadsdk.jy.j.j> it = this.f31542r.iterator();
            while (it.hasNext()) {
                it.next().j(str);
            }
        }
    }

    private String j(int i6) {
        if (i6 == 100) {
            return "Continue";
        }
        if (i6 != 101) {
            switch (i6) {
                case 200:
                    return ca.f10845k;
                case 201:
                    return "Created";
                case 202:
                    return "Accepted";
                case 203:
                    return "Non-Authoritative Information";
                case 204:
                    return "No Content";
                case 205:
                    return "Reset Content";
                case 206:
                    return "Partial Content";
                default:
                    switch (i6) {
                        case 400:
                            return "Bad Request";
                        case 401:
                            return "Unauthorized";
                        case 402:
                            return "Payment Required";
                        case 403:
                            return "Forbidden";
                        case 404:
                            return "Not Found";
                        case 405:
                            return "Method Not Allowed";
                        case 406:
                            return "Not Acceptable";
                        case 407:
                            return "Proxy Authentication Required";
                        case TTAdConstant.INTERACTION_TYPE_CODE /* 408 */:
                            return "Request Time-out";
                        case TTAdConstant.IMAGE_LIST_CODE /* 409 */:
                            return "Conflict";
                        case TTAdConstant.IMAGE_LIST_SIZE_CODE /* 410 */:
                            return "Gone";
                        case 411:
                            return "Length Required";
                        case 412:
                            return "Precondition Failed";
                        case TTAdConstant.VIDEO_INFO_CODE /* 413 */:
                            return "Request Entity Too Large";
                        case TTAdConstant.VIDEO_URL_CODE /* 414 */:
                            return "Request-URI Too Large";
                        case TTAdConstant.VIDEO_COVER_URL_CODE /* 415 */:
                            return "Unsupported Media Type";
                        case TTAdConstant.LIVE_AD_CODE /* 416 */:
                            return "Requested range not satisfiable";
                        case TTAdConstant.LIVE_FEED_URL_CODE /* 417 */:
                            return "Expectation Failed";
                        default:
                            switch (i6) {
                                case 500:
                                    return "Internal Server Error";
                                case 501:
                                    return "Not Implemented";
                                case 502:
                                    return "Bad Gateway";
                                case 503:
                                    return "Service Unavailable";
                                case 504:
                                    return "Gateway Time-out";
                                case 505:
                                    return "HTTP Version not supported";
                                default:
                                    return "";
                            }
                    }
            }
        }
        return "Switching Protocols";
    }
}
