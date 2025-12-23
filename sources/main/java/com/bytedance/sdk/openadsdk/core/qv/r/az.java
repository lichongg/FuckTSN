package com.bytedance.sdk.openadsdk.core.qv.r;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Toast;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.qv.r.cw;
import com.bytedance.sdk.openadsdk.core.qv.r.ws;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.v;
import com.ss.android.downloadlib.a;
import com.ss.android.downloadlib.addownload.j.b;
import com.ss.android.downloadlib.addownload.o;
import com.ss.android.downloadlib.j;
import com.ss.android.j.j.cw.c;
import com.ss.android.j.j.up.a;
import com.ss.android.j.j.up.d;
import com.ss.android.socialbase.appdownloader.f;
import com.ss.android.socialbase.downloader.r.la;
import com.ss.android.xt.j.xt.b;
import com.stub.StubApp;
import com.umeng.commonsdk.framework.UMModuleRegister;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import t2.a;
import w2.n;
import w2.q;
import w2.t;
import w2.w;

/* loaded from: D:\Downloads\app\classes4.dex */
public class az {
    private static Map<Integer, cw.j> ae;
    public static com.bytedance.sdk.openadsdk.core.qv.r.r cw;

    /* renamed from: g, reason: collision with root package name */
    private static final a f29960g;

    /* renamed from: j, reason: collision with root package name */
    public static volatile String f29961j;

    /* renamed from: m, reason: collision with root package name */
    private static Context f29962m;
    private static TTAdInteractionListener tl;

    /* renamed from: r, reason: collision with root package name */
    private static final AtomicBoolean f29963r = new AtomicBoolean(false);
    private static final AtomicBoolean up = new AtomicBoolean(false);
    public static boolean xt = true;

    private static class r implements n {
        @Override // w2.n
        public void j(Activity activity, int i6, String[] strArr, int[] iArr) {
        }

        @Override // w2.n
        public void j(Activity activity, String[] strArr, final t tVar) {
            if (az.ae() != null) {
                az.ae().j(activity, strArr, new com.bytedance.sdk.openadsdk.core.qv.r.m() { // from class: com.bytedance.sdk.openadsdk.core.qv.r.az.r.1
                    @Override // com.bytedance.sdk.openadsdk.core.qv.r.m
                    public void j() {
                        t tVar2 = tVar;
                        if (tVar2 != null) {
                            tVar2.j();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.qv.r.m
                    public void j(String str) {
                        t tVar2 = tVar;
                        if (tVar2 != null) {
                            tVar2.j(str);
                        }
                    }
                });
            }
        }

        @Override // w2.n
        public boolean j(Context context, String str) {
            if (az.ae() != null) {
                return az.ae().j(context, str);
            }
            return false;
        }
    }

    public static class xt implements w2.a {
        @Override // w2.a
        public void j(d dVar) {
            j(dVar, true);
        }

        @Override // w2.a
        public void xt(d dVar) {
            j(dVar, false);
            cw(dVar);
        }

        private void cw(d dVar) {
            if (dVar == null) {
                return;
            }
            Object m6 = dVar.m();
            tl xt = tl.j().j(dVar.o()).xt(dVar.k()).j(m6 instanceof JSONObject ? (JSONObject) m6 : null).xt(dVar.c());
            boolean z5 = "download_notification".equals(dVar.o()) || "landing_h5_download_ad_button".equals(dVar.o());
            if (az.ae() != null) {
                az.ae().j(xt, z5);
            }
        }

        private void j(d dVar, boolean z5) {
            ae xt;
            if (az.ae() == null || (xt = az.ae().xt()) == null || dVar == null) {
                return;
            }
            if (xt.j() && az.ae().j(dVar.toString())) {
                return;
            }
            if (z5) {
                az.xt(dVar);
            } else {
                az.xt(dVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cw(String str) {
        b g6;
        JSONObject ae2;
        if (TextUtils.isEmpty(str) || (g6 = o.f.c().g(str)) == null || (ae2 = g6.ae()) == null || ae() == null) {
            return;
        }
        ae().j(ae2, str);
    }

    private static class j implements w2.o {
        private j() {
        }

        @Override // w2.o
        public boolean j(com.ss.android.j.j.cw.b bVar, com.ss.android.socialbase.downloader.ae.cw cwVar) {
            com.bytedance.sdk.openadsdk.core.qv.r.r ae = az.ae();
            if (ae != null) {
                return ae.j(bVar, cwVar);
            }
            return false;
        }

        @Override // w2.o
        public boolean j(com.ss.android.j.j.cw.b bVar) {
            com.bytedance.sdk.openadsdk.core.qv.r.r ae = az.ae();
            if (ae != null) {
                return ae.j(bVar);
            }
            return false;
        }

        @Override // w2.o
        public boolean xt(com.ss.android.j.j.cw.b bVar, com.ss.android.socialbase.downloader.ae.cw cwVar) {
            com.bytedance.sdk.openadsdk.core.qv.r.r ae = az.ae();
            if (ae != null) {
                return ae.xt(bVar, cwVar);
            }
            return false;
        }
    }

    public static class m implements com.ss.android.socialbase.downloader.g.oq {
        @Override // com.ss.android.socialbase.downloader.g.oq
        public com.ss.android.socialbase.downloader.g.g j(int i6, String str, List<com.ss.android.socialbase.downloader.ae.up> list) throws IOException {
            final ws.j j6 = ws.j(str, list);
            if (j6 != null) {
                return new com.ss.android.socialbase.downloader.g.g() { // from class: com.bytedance.sdk.openadsdk.core.qv.r.az.m.1
                    @Override // com.ss.android.socialbase.downloader.g.g
                    public InputStream j() {
                        return j6.f29987j;
                    }

                    @Override // com.ss.android.socialbase.downloader.g.ae
                    public String j(String str2) {
                        Map<String, String> map = j6.xt;
                        if (map != null) {
                            return map.get(str2);
                        }
                        return null;
                    }

                    @Override // com.ss.android.socialbase.downloader.g.g
                    public void r() {
                        try {
                            j6.f29988r.disconnect();
                        } catch (Exception unused) {
                        }
                    }

                    @Override // com.ss.android.socialbase.downloader.g.ae
                    public int xt() {
                        return j6.cw;
                    }

                    @Override // com.ss.android.socialbase.downloader.g.ae
                    public void cw() {
                    }
                };
            }
            return null;
        }
    }

    public static class up implements w {

        /* renamed from: j, reason: collision with root package name */
        private final WeakReference<Context> f29971j;

        @Override // w2.w
        public void j(int i6, Context context, com.ss.android.j.j.cw.b bVar, String str, Drawable drawable, int i7) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                Toast.makeText(context, str, 0).show();
            } catch (Exception e6) {
                com.bytedance.sdk.component.utils.vl.r("LibUIFactory", "showToastWithDuration e " + e6.getMessage());
            }
        }

        public up(Context context) {
            this.f29971j = new WeakReference<>(context);
        }

        private com.bytedance.sdk.openadsdk.core.qv.r.j cw(final com.ss.android.j.j.up.a aVar) {
            return com.bytedance.sdk.openadsdk.core.qv.r.j.j().j(aVar.f38248b).xt(aVar.f38249c).r(aVar.f38251e).cw(aVar.f38250d).j(aVar.f38253g).j(new com.bytedance.sdk.openadsdk.core.qv.r.xt() { // from class: com.bytedance.sdk.openadsdk.core.qv.r.az.up.1
                @Override // com.bytedance.sdk.openadsdk.core.qv.r.xt
                public void cw(DialogInterface dialogInterface) {
                    a.c cVar = aVar.f38254h;
                    if (cVar != null) {
                        cVar.cw(dialogInterface);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.qv.r.xt
                public void j(DialogInterface dialogInterface) {
                    a.c cVar = aVar.f38254h;
                    if (cVar != null) {
                        cVar.j(dialogInterface);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.qv.r.xt
                public void xt(DialogInterface dialogInterface) {
                    a.c cVar = aVar.f38254h;
                    if (cVar != null) {
                        try {
                            cVar.xt(dialogInterface);
                        } catch (Exception e6) {
                            com.bytedance.sdk.component.utils.vl.j(e6);
                        }
                    }
                }
            });
        }

        @Override // w2.w
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public AlertDialog xt(com.ss.android.j.j.up.a aVar) {
            if (aVar != null && az.ae() != null) {
                Context context = aVar.f38247a;
                if (context != null && (context instanceof Activity)) {
                    return az.ae().j((Activity) aVar.f38247a, aVar.f38256j == 1, cw(aVar));
                }
                az.ae().j(this.f29971j, aVar.f38256j == 1, cw(aVar));
            }
            return null;
        }
    }

    static {
        try {
            f29961j = com.bytedance.sdk.openadsdk.api.plugin.xt.j(getContext(), Environment.DIRECTORY_DOWNLOADS).getPath();
        } catch (Throwable unused) {
        }
        f29960g = new t2.a() { // from class: com.bytedance.sdk.openadsdk.core.qv.r.az.8
            @Override // t2.a
            public void j(com.ss.android.socialbase.downloader.ae.cw cwVar, String str) {
                az.cw(str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.bytedance.sdk.openadsdk.core.qv.r.r ae() {
        if (cw == null) {
            cw = jy.r();
        }
        return cw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject g() {
        try {
            com.bytedance.sdk.openadsdk.core.qv.r.r ae2 = ae();
            if (ae2 != null) {
                JSONObject j6 = ae2.j();
                if (j6.optInt("enable_app_install_receiver", 1) == 0) {
                    j6.put("enable_app_install_receiver", 0);
                }
                return j6;
            }
        } catch (Exception unused) {
        }
        return new JSONObject();
    }

    private static Context getContext() {
        Context context = f29962m;
        return context == null ? v.getContext() : context;
    }

    public static void j(TTAdInteractionListener tTAdInteractionListener) {
        tl = tTAdInteractionListener;
    }

    public static Map<Integer, cw.j> r() {
        return ae;
    }

    private static boolean tl() {
        return UMModuleRegister.INNER.equals(h.f29117m);
    }

    public static com.ss.android.downloadlib.g xt() {
        j(getContext());
        return com.ss.android.downloadlib.g.c(getContext());
    }

    private static class cw implements w2.g {
        private cw() {
        }

        @Override // w2.g
        public void j(String str, String str2, Map<String, Object> map, final q qVar) {
            str.getClass();
            int i6 = 0;
            if (!str.equals("GET") && str.equals("POST")) {
                i6 = 1;
            }
            if (az.ae() != null) {
                az.ae().j(i6, str2, map, new com.bytedance.sdk.openadsdk.core.qv.r.up() { // from class: com.bytedance.sdk.openadsdk.core.qv.r.az.cw.1
                    @Override // com.bytedance.sdk.openadsdk.core.qv.r.up
                    public void j(String str3) {
                        q qVar2 = qVar;
                        if (qVar2 != null) {
                            qVar2.j(str3);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.qv.r.up
                    public void j(Throwable th) {
                        q qVar2 = qVar;
                        if (qVar2 != null) {
                            qVar2.j(th);
                        }
                    }
                });
            }
        }

        @Override // w2.g
        public void j(String str, byte[] bArr, String str2, int i6, final q qVar) {
            if (az.ae() != null) {
                az.ae().j(str, bArr, str2, new com.bytedance.sdk.openadsdk.core.qv.r.up() { // from class: com.bytedance.sdk.openadsdk.core.qv.r.az.cw.2
                    @Override // com.bytedance.sdk.openadsdk.core.qv.r.up
                    public void j(String str3) {
                        q qVar2 = qVar;
                        if (qVar2 != null) {
                            qVar2.j(str3);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.qv.r.up
                    public void j(Throwable th) {
                        q qVar2 = qVar;
                        if (qVar2 != null) {
                            qVar2.j(th);
                        }
                    }
                });
            }
        }
    }

    public static TTAdInteractionListener j() {
        return tl;
    }

    public static void j(Context context) {
        if (context == null) {
            context = v.getContext();
        }
        if (context == null) {
            return;
        }
        AtomicBoolean atomicBoolean = f29963r;
        if (!atomicBoolean.get()) {
            synchronized (az.class) {
                try {
                    if (!atomicBoolean.get()) {
                        f29962m = StubApp.getOrigApplicationContext(context.getApplicationContext());
                        if (ae() != null) {
                            String j6 = ae().j(xt);
                            if (!TextUtils.isEmpty(j6)) {
                                f29961j = j6;
                            }
                        }
                        atomicBoolean.set(xt(f29962m));
                    }
                } finally {
                }
            }
        }
        if (atomicBoolean.get()) {
            AtomicBoolean atomicBoolean2 = up;
            if (atomicBoolean2.compareAndSet(false, true)) {
                if ((ae() != null ? ae().xt() : null) == null) {
                    atomicBoolean2.set(false);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0033 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean xt(final android.content.Context r6) {
        /*
            r0 = 0
            if (r6 != 0) goto L4
            return r0
        L4:
            android.content.Context r1 = r6.getApplicationContext()
            android.content.Context r1 = com.stub.StubApp.getOrigApplicationContext(r1)
            java.lang.String r2 = r1.getPackageName()
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 == 0) goto L18
            java.lang.String r2 = ""
        L18:
            boolean r3 = tl()
            if (r3 == 0) goto L29
            com.ss.android.downloadlib.g r3 = com.ss.android.downloadlib.g.c(r1)     // Catch: java.lang.Throwable -> L29
            java.lang.String r4 = "pangolin"
            s2.a r3 = r3.g(r4)     // Catch: java.lang.Throwable -> L29
            goto L31
        L29:
            com.ss.android.downloadlib.g r3 = com.ss.android.downloadlib.g.c(r1)
            s2.a r3 = r3.f()
        L31:
            if (r3 != 0) goto L34
            return r0
        L34:
            com.ss.android.j.j.up.b$a r0 = new com.ss.android.j.j.up.b$a
            r0.<init>()
            java.lang.String r4 = "143"
            com.ss.android.j.j.up.b$a r0 = r0.i(r4)
            java.lang.String r4 = "open_news"
            com.ss.android.j.j.up.b$a r0 = r0.c(r4)
            java.lang.String r4 = com.bytedance.sdk.openadsdk.core.h.cw
            com.ss.android.j.j.up.b$a r0 = r0.a(r4)
            int r4 = com.bytedance.sdk.openadsdk.core.h.xt
            java.lang.String r4 = java.lang.String.valueOf(r4)
            com.ss.android.j.j.up.b$a r0 = r0.f(r4)
            com.ss.android.j.j.up.b r0 = r0.d()
            com.bytedance.sdk.openadsdk.core.qv.r.az$r r4 = new com.bytedance.sdk.openadsdk.core.qv.r.az$r
            r4.<init>()
            s2.a r3 = r3.f(r4)
            com.bytedance.sdk.openadsdk.core.qv.r.az$xt r4 = new com.bytedance.sdk.openadsdk.core.qv.r.az$xt
            r4.<init>()
            s2.a r3 = r3.g(r4)
            com.bytedance.sdk.openadsdk.core.qv.r.az$up r4 = new com.bytedance.sdk.openadsdk.core.qv.r.az$up
            r4.<init>(r1)
            s2.a r3 = r3.i(r4)
            com.bytedance.sdk.openadsdk.core.qv.r.az$cw r4 = new com.bytedance.sdk.openadsdk.core.qv.r.az$cw
            r5 = 0
            r4.<init>()
            s2.a r3 = r3.c(r4)
            com.bytedance.sdk.openadsdk.core.qv.r.az$5 r4 = new com.bytedance.sdk.openadsdk.core.qv.r.az$5
            r4.<init>()
            s2.a r3 = r3.e(r4)
            com.bytedance.sdk.openadsdk.core.qv.r.az$4 r4 = new com.bytedance.sdk.openadsdk.core.qv.r.az$4
            r4.<init>()
            s2.a r6 = r3.l(r4)
            com.bytedance.sdk.openadsdk.core.qv.r.az$3 r3 = new com.bytedance.sdk.openadsdk.core.qv.r.az$3
            r3.<init>()
            s2.a r6 = r6.k(r3)
            com.bytedance.sdk.openadsdk.core.qv.r.az$j r3 = new com.bytedance.sdk.openadsdk.core.qv.r.az$j
            r3.<init>()
            s2.a r6 = r6.h(r3)
            com.bytedance.sdk.openadsdk.core.qv.r.az$2 r3 = new com.bytedance.sdk.openadsdk.core.qv.r.az$2
            r3.<init>()
            s2.a r6 = r6.j(r3)
            s2.a r6 = r6.d(r0)
            com.bytedance.sdk.openadsdk.core.qv.r.az$1 r0 = new com.bytedance.sdk.openadsdk.core.qv.r.az$1
            r0.<init>()
            s2.a r6 = r6.a(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r2)
            java.lang.String r2 = ".TTFileProvider"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            s2.a r6 = r6.j(r0)
            org.json.JSONObject r0 = g()
            com.ss.android.socialbase.downloader.downloader.tl r0 = j(r1, r0)
            s2.a r6 = r6.b(r0)
            r6.j()
            com.ss.android.downloadlib.a.g.d()
            java.lang.String r6 = com.bytedance.sdk.openadsdk.core.h.f29117m
            java.lang.String r0 = "internal"
            boolean r6 = r6.equals(r0)
            r0 = 1
            if (r6 != 0) goto L10a
            com.ss.android.downloadlib.g r6 = com.ss.android.downloadlib.g.c(r1)
            z2.a r6 = r6.p()
            r6.j(r0)
            com.ss.android.downloadlib.g r6 = com.ss.android.downloadlib.g.c(r1)
            t2.a r1 = com.bytedance.sdk.openadsdk.core.qv.r.az.f29960g
            r6.n(r1)
            com.ss.android.socialbase.appdownloader.f r6 = com.ss.android.socialbase.appdownloader.f.L()
            com.bytedance.sdk.openadsdk.core.qv.r.az$6 r1 = new com.bytedance.sdk.openadsdk.core.qv.r.az$6
            r1.<init>()
            r6.x(r1)
        L10a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.qv.r.az.xt(android.content.Context):boolean");
    }

    public static void cw() {
        xt().a();
        if (ae() != null) {
            ae().xt(f29961j);
        }
    }

    public static void j(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f29961j = str;
    }

    public static boolean j(Context context, Uri uri, com.ss.android.j.j.cw.b bVar, com.ss.android.j.j.cw.g gVar, c cVar, w2.h hVar) {
        return xt().r().a(context, uri, bVar, gVar, cVar, hVar);
    }

    public static boolean j(Context context, Uri uri, com.ss.android.j.j.cw.b bVar, com.ss.android.j.j.cw.g gVar, c cVar) {
        return xt().r().d(context, uri, bVar, gVar, cVar);
    }

    public static boolean j(Uri uri) {
        return j.i.a(uri);
    }

    public static void j(int i6) {
        Map<Integer, cw.j> map = ae;
        if (map != null) {
            map.remove(Integer.valueOf(i6));
        }
    }

    public static void j(int i6, cw.j jVar) {
        if (jVar != null) {
            if (ae == null) {
                ae = Collections.synchronizedMap(new WeakHashMap());
            }
            ae.put(Integer.valueOf(i6), jVar);
        }
    }

    public static boolean j(String str, String str2, JSONObject jSONObject, Object obj) {
        Map<Integer, cw.j> r5;
        String str3;
        String str4;
        Object obj2;
        boolean z5 = false;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && jSONObject != null && (r5 = r()) != null) {
            for (Map.Entry<Integer, cw.j> entry : r5.entrySet()) {
                int intValue = entry.getKey().intValue();
                cw.j value = entry.getValue();
                if (value != null) {
                    str3 = str;
                    str4 = str2;
                    obj2 = obj;
                    boolean j6 = value.j(intValue, jSONObject.toString(), str3, str4, obj2);
                    if (!z5 && !j6) {
                        z5 = true;
                    }
                } else {
                    str3 = str;
                    str4 = str2;
                    obj2 = obj;
                }
                str = str3;
                str2 = str4;
                obj = obj2;
            }
        }
        return z5;
    }

    private static com.ss.android.socialbase.downloader.downloader.tl j(Context context, JSONObject jSONObject) {
        return new com.ss.android.socialbase.downloader.downloader.tl(context).j(new la() { // from class: com.bytedance.sdk.openadsdk.core.qv.r.az.7
            @Override // com.ss.android.socialbase.downloader.r.la
            public JSONObject j() {
                return az.g();
            }
        }).j(new m());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject xt(d dVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("category", dVar.e());
            jSONObject.put(CommonNetImpl.TAG, dVar.o());
            jSONObject.put("label", dVar.c());
            jSONObject.put("isAd", dVar.j());
            jSONObject.put("adId", dVar.l());
            jSONObject.put("logExtra", dVar.g());
            jSONObject.put("extValue", dVar.a());
            jSONObject.put("extJson", dVar.k());
            jSONObject.put("paramsJson", dVar.d());
            jSONObject.put("eventSource", dVar.i());
            jSONObject.put("extraObject", dVar.m());
            jSONObject.put("clickTrackUrl", dVar.h());
            jSONObject.put("isV3", dVar.f());
            jSONObject.put("V3EventName", dVar.n());
            jSONObject.put("V3EventParams", dVar.b());
            return jSONObject;
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return jSONObject;
        }
    }

    public static boolean j(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            List<com.ss.android.socialbase.downloader.ae.cw> V = f.L().V(context);
            if (!V.isEmpty()) {
                for (com.ss.android.socialbase.downloader.ae.cw cwVar : V) {
                    if (cwVar != null && str.equals(cwVar.oq())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static Bundle j(int i6, int i7, String str, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        try {
            if (i7 == 101) {
                boolean cw2 = uf.cw(f29962m, str);
                String str5 = cw2 ? "open" : "install";
                if (!cw2) {
                    bundle.putString("msg", "install ".concat(String.valueOf(f.F(f29962m, i6))));
                } else {
                    bundle.putString("msg", "open " + a.f.g(str).a());
                }
                com.bytedance.sdk.openadsdk.core.qv.up.j(str2, str3, str4, str5, str, "media_install", (String) null, (String) null);
                bundle.putString("msg", "success");
                return bundle;
            }
            bundle.putString("msg", "event_type:" + i6 + " not support");
            return bundle;
        } catch (Exception e6) {
            bundle.putString("msg", e6.getMessage());
            return bundle;
        }
    }

    public static boolean j(Activity activity, final com.bytedance.sdk.openadsdk.i.cw.j.j jVar) {
        return com.ss.android.downloadlib.addownload.j.b.a().h(activity, false, new b.InterfaceC0746b() { // from class: com.bytedance.sdk.openadsdk.core.qv.r.az.9
            @Override // com.ss.android.downloadlib.addownload.j.b.InterfaceC0746b
            public void j() {
                com.bytedance.sdk.openadsdk.i.cw.j.j jVar2 = com.bytedance.sdk.openadsdk.i.cw.j.j.this;
                if (jVar2 != null) {
                    jVar2.j();
                }
            }
        });
    }
}
