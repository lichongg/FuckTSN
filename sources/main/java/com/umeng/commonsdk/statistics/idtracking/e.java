package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.au;
import com.umeng.analytics.pro.bu;
import com.umeng.analytics.pro.ca;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import io.netty.util.internal.StringUtil;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final long f41943a = 86400000;

    /* renamed from: b, reason: collision with root package name */
    public static e f41944b;

    /* renamed from: c, reason: collision with root package name */
    private static final String f41945c = au.b().b("id");

    /* renamed from: j, reason: collision with root package name */
    private static Object f41946j = new Object();

    /* renamed from: d, reason: collision with root package name */
    private File f41947d;

    /* renamed from: f, reason: collision with root package name */
    private long f41949f;

    /* renamed from: i, reason: collision with root package name */
    private a f41952i;

    /* renamed from: e, reason: collision with root package name */
    private com.umeng.commonsdk.statistics.proto.c f41948e = null;

    /* renamed from: h, reason: collision with root package name */
    private Set<com.umeng.commonsdk.statistics.idtracking.a> f41951h = new HashSet();

    /* renamed from: g, reason: collision with root package name */
    private long f41950g = 86400000;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private Context f41953a;

        /* renamed from: b, reason: collision with root package name */
        private Set<String> f41954b = new HashSet();

        public synchronized boolean a(String str) {
            return !this.f41954b.contains(str);
        }

        public synchronized void b(String str) {
            this.f41954b.add(str);
        }

        public synchronized void a() {
            try {
                if (!this.f41954b.isEmpty()) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<String> it = this.f41954b.iterator();
                    while (it.hasNext()) {
                        sb.append(it.next());
                        sb.append(StringUtil.COMMA);
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    PreferenceWrapper.getDefault(this.f41953a).edit().putString("invld_id", sb.toString()).commit();
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        public void c(String str) {
            this.f41954b.remove(str);
        }

        public a(Context context) {
            this.f41953a = context;
        }

        public synchronized void b() {
            String[] split;
            String string = PreferenceWrapper.getDefault(this.f41953a).getString("invld_id", null);
            if (!TextUtils.isEmpty(string) && (split = string.split(",")) != null) {
                for (String str : split) {
                    if (!TextUtils.isEmpty(str)) {
                        this.f41954b.add(str);
                    }
                }
            }
        }
    }

    public static synchronized void a() {
        synchronized (e.class) {
            e eVar = f41944b;
            if (eVar != null) {
                eVar.e();
                f41944b = null;
            }
        }
    }

    private synchronized void h() {
        try {
            com.umeng.commonsdk.statistics.proto.c cVar = new com.umeng.commonsdk.statistics.proto.c();
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f41951h) {
                if (aVar.c()) {
                    if (aVar.d() != null) {
                        hashMap.put(aVar.b(), aVar.d());
                    }
                    if (aVar.e() != null && !aVar.e().isEmpty()) {
                        arrayList.addAll(aVar.e());
                    }
                }
            }
            cVar.a(arrayList);
            cVar.a(hashMap);
            synchronized (this) {
                this.f41948e = cVar;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void b() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f41949f >= this.f41950g) {
                boolean z5 = false;
                for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f41951h) {
                    if (aVar.c() && aVar.a()) {
                        if (!aVar.c()) {
                            this.f41952i.b(aVar.b());
                        }
                        z5 = true;
                    }
                }
                if (z5) {
                    h();
                    this.f41952i.a();
                    g();
                }
                this.f41949f = currentTimeMillis;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized com.umeng.commonsdk.statistics.proto.c c() {
        return this.f41948e;
    }

    public String d() {
        return null;
    }

    public synchronized void e() {
        try {
            if (f41944b == null) {
                return;
            }
            boolean z5 = false;
            for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f41951h) {
                if (aVar.c() && aVar.e() != null && !aVar.e().isEmpty()) {
                    aVar.a((List<com.umeng.commonsdk.statistics.proto.a>) null);
                    z5 = true;
                }
            }
            if (z5) {
                this.f41948e.b(false);
                g();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void f() {
        com.umeng.commonsdk.statistics.proto.c i6 = i();
        if (i6 == null) {
            return;
        }
        a(i6);
        ArrayList arrayList = new ArrayList(this.f41951h.size());
        synchronized (this) {
            try {
                this.f41948e = i6;
                for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f41951h) {
                    aVar.a(this.f41948e);
                    if (!aVar.c()) {
                        arrayList.add(aVar);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    this.f41951h.remove((com.umeng.commonsdk.statistics.idtracking.a) it.next());
                }
                h();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized void g() {
        com.umeng.commonsdk.statistics.proto.c cVar = this.f41948e;
        if (cVar != null) {
            b(cVar);
        }
    }

    private com.umeng.commonsdk.statistics.proto.c i() {
        Throwable th;
        FileInputStream fileInputStream;
        synchronized (f41946j) {
            if (!this.f41947d.exists()) {
                return null;
            }
            try {
                fileInputStream = new FileInputStream(this.f41947d);
            } catch (Exception e6) {
                e = e6;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
                HelperUtils.safeClose(fileInputStream);
                throw th;
            }
            try {
                try {
                    byte[] readStreamToByteArray = HelperUtils.readStreamToByteArray(fileInputStream);
                    com.umeng.commonsdk.statistics.proto.c cVar = new com.umeng.commonsdk.statistics.proto.c();
                    new bu().a(cVar, readStreamToByteArray);
                    HelperUtils.safeClose(fileInputStream);
                    return cVar;
                } catch (Throwable th3) {
                    th = th3;
                    HelperUtils.safeClose(fileInputStream);
                    throw th;
                }
            } catch (Exception e7) {
                e = e7;
                e.printStackTrace();
                HelperUtils.safeClose(fileInputStream);
                return null;
            }
        }
    }

    e(Context context) {
        this.f41952i = null;
        this.f41947d = new File(context.getFilesDir(), f41945c);
        a aVar = new a(context);
        this.f41952i = aVar;
        aVar.b();
    }

    public static synchronized e a(Context context) {
        e eVar;
        synchronized (e.class) {
            try {
                if (f41944b == null) {
                    e eVar2 = new e(context);
                    f41944b = eVar2;
                    eVar2.a(new f(context));
                    f41944b.a(new b(context));
                    f41944b.a(new j(context));
                    f41944b.a(new d(context));
                    f41944b.a(new c(context));
                    f41944b.a(new g(context));
                    f41944b.a(new i());
                    if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
                        f41944b.a(new h(context));
                    }
                    f41944b.f();
                }
                eVar = f41944b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    private void b(com.umeng.commonsdk.statistics.proto.c cVar) {
        byte[] a6;
        synchronized (f41946j) {
            if (cVar != null) {
                try {
                    synchronized (this) {
                        a(cVar);
                        a6 = new ca().a(cVar);
                    }
                    if (a6 != null) {
                        HelperUtils.writeFile(this.f41947d, a6);
                    }
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
        }
    }

    private boolean a(com.umeng.commonsdk.statistics.idtracking.a aVar) {
        if (this.f41952i.a(aVar.b())) {
            return this.f41951h.add(aVar);
        }
        if (!AnalyticsConstants.UM_DEBUG) {
            return false;
        }
        MLog.w("invalid domain: " + aVar.b());
        return false;
    }

    public void a(long j6) {
        this.f41950g = j6;
    }

    private void a(com.umeng.commonsdk.statistics.proto.c cVar) {
        Map<String, com.umeng.commonsdk.statistics.proto.b> map;
        if (cVar == null || (map = cVar.f42039a) == null) {
            return;
        }
        if (map.containsKey(SocializeProtocolConstants.PROTOCOL_KEY_MAC) && !FieldManager.allow(com.umeng.commonsdk.utils.d.f42119h)) {
            cVar.f42039a.remove(SocializeProtocolConstants.PROTOCOL_KEY_MAC);
        }
        if (cVar.f42039a.containsKey("imei") && !FieldManager.allow(com.umeng.commonsdk.utils.d.f42118g)) {
            cVar.f42039a.remove("imei");
        }
        if (cVar.f42039a.containsKey(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID) && !FieldManager.allow(com.umeng.commonsdk.utils.d.f42120i)) {
            cVar.f42039a.remove(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
        }
        if (cVar.f42039a.containsKey("serial") && !FieldManager.allow(com.umeng.commonsdk.utils.d.f42121j)) {
            cVar.f42039a.remove("serial");
        }
        if (cVar.f42039a.containsKey("idfa") && !FieldManager.allow(com.umeng.commonsdk.utils.d.f42134w)) {
            cVar.f42039a.remove("idfa");
        }
        if (!cVar.f42039a.containsKey("oaid") || FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            return;
        }
        cVar.f42039a.remove("oaid");
    }
}
