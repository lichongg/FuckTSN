package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.amap.api.col.p0003l.j4;
import com.amap.api.col.p0003l.o9;
import com.stub.StubApp;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class g {

    /* renamed from: f, reason: collision with root package name */
    private static g f10256f;

    /* renamed from: i, reason: collision with root package name */
    private static long f10257i;

    /* renamed from: d, reason: collision with root package name */
    private File f10261d;

    /* renamed from: e, reason: collision with root package name */
    private String f10262e;

    /* renamed from: g, reason: collision with root package name */
    private Context f10263g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f10264h;

    /* renamed from: c, reason: collision with root package name */
    private LinkedHashMap<String, Long> f10260c = new LinkedHashMap<>();

    /* renamed from: a, reason: collision with root package name */
    String f10258a = "";

    /* renamed from: b, reason: collision with root package name */
    String f10259b = null;

    public static synchronized g a(Context context) {
        g gVar;
        synchronized (g.class) {
            try {
                if (f10256f == null) {
                    f10256f = new g(context);
                }
                gVar = f10256f;
            } catch (Throwable th) {
                throw th;
            }
        }
        return gVar;
    }

    private synchronized void c() {
        LinkedHashMap<String, Long> linkedHashMap = this.f10260c;
        if (linkedHashMap == null || linkedHashMap.size() <= 0) {
            try {
                this.f10258a = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
                Iterator<String> it = j.a(this.f10261d).iterator();
                while (it.hasNext()) {
                    try {
                        try {
                            String[] split = new String(com.autonavi.aps.amapapi.security.a.b(j4.g(it.next()), this.f10262e), "UTF-8").split(",");
                            if (split != null && split.length > 1) {
                                this.f10260c.put(split[0], Long.valueOf(Long.parseLong(split[1])));
                            }
                        } catch (UnsupportedEncodingException e6) {
                            e6.printStackTrace();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public final synchronized void b() {
        try {
            if (b(this.f10263g)) {
                for (Map.Entry<String, Long> entry : this.f10260c.entrySet()) {
                    try {
                        if (!this.f10258a.equals(entry.getKey())) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("param_long_first", entry.getKey());
                            jSONObject.put("param_long_second", entry.getValue());
                            h.a(this.f10263g, "O023", jSONObject);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private void d() {
        try {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Long> entry : this.f10260c.entrySet()) {
                try {
                    sb.append(j4.f(com.autonavi.aps.amapapi.security.a.a((entry.getKey() + "," + entry.getValue()).getBytes("UTF-8"), this.f10262e)) + com.snail.antifake.deviceid.e.f37542d);
                } catch (UnsupportedEncodingException e6) {
                    e6.printStackTrace();
                }
            }
            String sb2 = sb.toString();
            if (TextUtils.isEmpty(sb2)) {
                return;
            }
            j.a(this.f10261d, sb2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private g(Context context) {
        this.f10262e = null;
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f10263g = origApplicationContext;
        String path = origApplicationContext.getFilesDir().getPath();
        if (this.f10262e == null) {
            this.f10262e = j.l(this.f10263g);
        }
        try {
            this.f10261d = new File(path, "reportRecorder");
        } catch (Throwable th) {
            o9.a(th);
        }
        c();
    }

    public final synchronized void a() {
        if (this.f10264h) {
            d();
            this.f10264h = false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x002b, code lost:
    
        if (r6.f10260c.size() >= 9) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007f A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0081 A[Catch: all -> 0x0016, TRY_ENTER, TryCatch #1 {all -> 0x0016, blocks: (B:3:0x0001, B:5:0x000b, B:8:0x002d, B:9:0x003c, B:11:0x0042, B:52:0x005f, B:19:0x0063, B:20:0x0067, B:22:0x006d, B:24:0x0079, B:29:0x0081, B:31:0x0088, B:34:0x0090, B:36:0x009c, B:37:0x00c6, B:39:0x00ce, B:41:0x00d5, B:42:0x00d8, B:46:0x00b9, B:55:0x0019, B:57:0x0023, B:13:0x0048), top: B:2:0x0001, inners: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void a(com.amap.api.location.AMapLocation r7) {
        /*
            Method dump skipped, instructions count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.utils.g.a(com.amap.api.location.AMapLocation):void");
    }

    private boolean b(Context context) {
        if (this.f10259b == null) {
            this.f10259b = i.a(context, "pref", "lastavedate", "0");
        }
        if (this.f10259b.equals(this.f10258a)) {
            return false;
        }
        SharedPreferences.Editor a6 = i.a(context, "pref");
        i.a(a6, "lastavedate", this.f10258a);
        i.a(a6);
        this.f10259b = this.f10258a;
        return true;
    }
}
