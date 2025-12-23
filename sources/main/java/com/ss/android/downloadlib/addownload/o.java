package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.ats.cw;
import com.ss.android.downloadlib.a;
import com.ss.android.socialbase.downloader.downloader.ae;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class o {

    /* renamed from: b, reason: collision with root package name */
    private static volatile o f37914b;

    /* renamed from: a, reason: collision with root package name */
    private Handler f37915a = null;

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f37916a;

        a(String str) {
            this.f37916a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            m.d().j(3, m.getContext(), null, "下载失败，请重试！", null, 0);
            l c6 = com.ss.android.downloadlib.c.d().c(this.f37916a);
            if (c6 != null) {
                c6.h();
            }
        }
    }

    public class b {

        /* renamed from: a, reason: collision with root package name */
        private int f37918a;

        /* renamed from: b, reason: collision with root package name */
        private int f37919b;

        /* renamed from: c, reason: collision with root package name */
        private String f37920c;

        public b(int i6) {
            this(i6, 0, null);
        }

        public b(int i6, int i7) {
            this(i6, i7, null);
        }

        public int a() {
            return this.f37919b;
        }

        public String b() {
            return this.f37920c;
        }

        public int getType() {
            return this.f37918a;
        }

        public b(int i6, String str) {
            this(i6, 0, str);
        }

        public b(int i6, int i7, String str) {
            this.f37918a = i6;
            this.f37919b = i7;
            this.f37920c = str;
        }
    }

    public class c {

        /* renamed from: g, reason: collision with root package name */
        public static int f37921g = 0;

        /* renamed from: h, reason: collision with root package name */
        public static int f37922h = 1;

        /* renamed from: i, reason: collision with root package name */
        public static int f37923i = 2;

        /* renamed from: a, reason: collision with root package name */
        private int f37924a = f37921g;

        /* renamed from: b, reason: collision with root package name */
        private long f37925b = 0;

        /* renamed from: c, reason: collision with root package name */
        private JSONObject f37926c = null;

        /* renamed from: d, reason: collision with root package name */
        private int f37927d = 0;

        /* renamed from: e, reason: collision with root package name */
        private String f37928e = "";

        /* renamed from: f, reason: collision with root package name */
        private String f37929f = "";

        public c a(int i6) {
            this.f37924a = i6;
            return this;
        }

        public boolean b() {
            return this.f37924a == f37922h;
        }

        public int c() {
            return this.f37927d;
        }

        public c d(int i6) {
            this.f37927d = i6;
            return this;
        }
    }

    public class d {

        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Collection f37930a;

            a(Collection collection) {
                this.f37930a = collection;
            }

            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor edit = d.this.a().edit();
                for (com.ss.android.xt.j.xt.b bVar : this.f37930a) {
                    if (bVar != null && bVar.xt() != 0) {
                        edit.putString(String.valueOf(bVar.xt()), bVar.z0().toString());
                    }
                }
                edit.apply();
            }
        }

        class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ List f37932a;

            b(List list) {
                this.f37932a = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor edit = d.this.a().edit();
                Iterator it = this.f37932a.iterator();
                while (it.hasNext()) {
                    edit.remove((String) it.next());
                }
                edit.apply();
            }
        }

        private static class c {

            /* renamed from: a, reason: collision with root package name */
            private static d f37934a = new d(null);
        }

        /* synthetic */ d(a aVar) {
            this();
        }

        public synchronized void e(Collection<com.ss.android.xt.j.xt.b> collection) {
            if (collection != null) {
                if (!collection.isEmpty()) {
                    com.ss.android.downloadlib.e.c().f(new a(collection), true);
                }
            }
        }

        private d() {
        }

        public void d(com.ss.android.xt.j.xt.b bVar) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(bVar);
            e(arrayList);
        }

        public void f(List<String> list) {
            if (list == null || list.isEmpty()) {
                return;
            }
            com.ss.android.downloadlib.e.c().f(new b(list), true);
        }

        @NonNull
        ConcurrentHashMap<Long, com.ss.android.xt.j.xt.b> g() {
            ConcurrentHashMap<Long, com.ss.android.xt.j.xt.b> concurrentHashMap = new ConcurrentHashMap<>();
            Map<String, ?> all = a().getAll();
            if (all != null) {
                for (Map.Entry<String, ?> entry : all.entrySet()) {
                    if (entry.getValue() != null) {
                        try {
                            Long valueOf = Long.valueOf(entry.getKey());
                            long longValue = valueOf.longValue();
                            com.ss.android.xt.j.xt.b V0 = com.ss.android.xt.j.xt.b.V0(new JSONObject(String.valueOf(entry.getValue())));
                            if (longValue > 0 && V0 != null) {
                                concurrentHashMap.put(valueOf, V0);
                            }
                        } catch (Exception e6) {
                            vl.j(e6);
                        }
                    }
                }
            }
            return concurrentHashMap;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public SharedPreferences a() {
            return cw.j(m.getContext(), "sp_ad_download_event", 0);
        }

        public static d c() {
            return c.f37934a;
        }
    }

    public class e {

        /* renamed from: a, reason: collision with root package name */
        public long f37935a;

        /* renamed from: b, reason: collision with root package name */
        public long f37936b;

        /* renamed from: c, reason: collision with root package name */
        public long f37937c;

        /* renamed from: d, reason: collision with root package name */
        public String f37938d;

        /* renamed from: e, reason: collision with root package name */
        public String f37939e;

        /* renamed from: f, reason: collision with root package name */
        public String f37940f;

        /* renamed from: g, reason: collision with root package name */
        public String f37941g;

        /* renamed from: h, reason: collision with root package name */
        public volatile long f37942h;

        public e() {
        }

        public static e a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            e eVar = new e();
            try {
                eVar.f37935a = a.h.j(jSONObject, "mDownloadId");
                eVar.f37936b = a.h.j(jSONObject, "mAdId");
                eVar.f37937c = a.h.j(jSONObject, "mExtValue");
                eVar.f37938d = jSONObject.optString("mPackageName");
                eVar.f37939e = jSONObject.optString("mAppName");
                eVar.f37940f = jSONObject.optString("mLogExtra");
                eVar.f37941g = jSONObject.optString("mFileName");
                eVar.f37942h = a.h.j(jSONObject, "mTimeStamp");
                return eVar;
            } catch (Exception e6) {
                vl.j(e6);
                return null;
            }
        }

        public e(long j6, long j7, long j8, String str, String str2, String str3, String str4) {
            this.f37935a = j6;
            this.f37936b = j7;
            this.f37937c = j8;
            this.f37938d = str;
            this.f37939e = str2;
            this.f37940f = str3;
            this.f37941g = str4;
        }

        public JSONObject b() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mDownloadId", this.f37935a);
                jSONObject.put("mAdId", this.f37936b);
                jSONObject.put("mExtValue", this.f37937c);
                jSONObject.put("mPackageName", this.f37938d);
                jSONObject.put("mAppName", this.f37939e);
                jSONObject.put("mLogExtra", this.f37940f);
                jSONObject.put("mFileName", this.f37941g);
                jSONObject.put("mTimeStamp", this.f37942h);
                return jSONObject;
            } catch (JSONException e6) {
                vl.j(e6);
                return jSONObject;
            }
        }
    }

    public class f {

        /* renamed from: a, reason: collision with root package name */
        private volatile boolean f37943a;

        /* renamed from: b, reason: collision with root package name */
        private final ConcurrentHashMap<Long, com.ss.android.j.j.cw.b> f37944b;

        /* renamed from: c, reason: collision with root package name */
        private final ConcurrentHashMap<Long, com.ss.android.j.j.cw.g> f37945c;

        /* renamed from: d, reason: collision with root package name */
        private final ConcurrentHashMap<Long, com.ss.android.j.j.cw.c> f37946d;

        /* renamed from: e, reason: collision with root package name */
        private final ConcurrentHashMap<Long, com.ss.android.xt.j.xt.b> f37947e;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (f.this.f37943a) {
                    return;
                }
                synchronized (f.class) {
                    try {
                        if (!f.this.f37943a) {
                            f.this.f37947e.putAll(d.c().g());
                            f.this.f37943a = true;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        private static class b {

            /* renamed from: a, reason: collision with root package name */
            private static f f37949a = new f(null);
        }

        /* synthetic */ f(a aVar) {
            this();
        }

        public com.ss.android.xt.j.xt.b f(com.ss.android.socialbase.downloader.ae.cw cwVar) {
            if (cwVar == null) {
                return null;
            }
            for (com.ss.android.xt.j.xt.b bVar : this.f37947e.values()) {
                if (bVar != null && bVar.mi() == cwVar.ae()) {
                    return bVar;
                }
            }
            if (!TextUtils.isEmpty(cwVar.h())) {
                try {
                    long j6 = a.h.j(new JSONObject(cwVar.h()), JThirdPlatFormInterface.KEY_EXTRA);
                    if (j6 != 0) {
                        for (com.ss.android.xt.j.xt.b bVar2 : this.f37947e.values()) {
                            if (bVar2 != null && bVar2.xt() == j6) {
                                return bVar2;
                            }
                        }
                        com.ss.android.downloadlib.up.a.a().c("getNativeModelByInfo");
                    }
                } catch (Exception e6) {
                    vl.j(e6);
                }
            }
            for (com.ss.android.xt.j.xt.b bVar3 : this.f37947e.values()) {
                if (bVar3 != null && TextUtils.equals(bVar3.j(), cwVar.oq())) {
                    return bVar3;
                }
            }
            return null;
        }

        public synchronized void l(com.ss.android.xt.j.xt.b bVar) {
            if (bVar == null) {
                return;
            }
            this.f37947e.put(Long.valueOf(bVar.xt()), bVar);
            d.c().d(bVar);
        }

        public synchronized void m(List<Long> list) {
            try {
                ArrayList arrayList = new ArrayList();
                for (Long l6 : list) {
                    arrayList.add(String.valueOf(l6.longValue()));
                    this.f37947e.remove(l6);
                }
                d.c().f(arrayList);
            } catch (Throwable th) {
                throw th;
            }
        }

        private f() {
            this.f37943a = false;
            this.f37944b = new ConcurrentHashMap<>();
            this.f37945c = new ConcurrentHashMap<>();
            this.f37946d = new ConcurrentHashMap<>();
            this.f37947e = new ConcurrentHashMap<>();
        }

        public com.ss.android.j.j.cw.c a(long j6) {
            return this.f37946d.get(Long.valueOf(j6));
        }

        public ConcurrentHashMap<Long, com.ss.android.xt.j.xt.b> b() {
            return this.f37947e;
        }

        public com.ss.android.j.j.cw.b d(long j6) {
            return this.f37944b.get(Long.valueOf(j6));
        }

        public com.ss.android.xt.j.xt.b e(int i6) {
            for (com.ss.android.xt.j.xt.b bVar : this.f37947e.values()) {
                if (bVar != null && bVar.mi() == i6) {
                    return bVar;
                }
            }
            return null;
        }

        @NonNull
        public Map<Long, com.ss.android.xt.j.xt.b> h(String str, String str2) {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                for (com.ss.android.xt.j.xt.b bVar : this.f37947e.values()) {
                    if (bVar != null && TextUtils.equals(bVar.j(), str)) {
                        bVar.Y0(str2);
                        hashMap.put(Long.valueOf(bVar.xt()), bVar);
                    }
                }
            }
            return hashMap;
        }

        public void i(long j6, com.ss.android.j.j.cw.c cVar) {
            if (cVar != null) {
                this.f37946d.put(Long.valueOf(j6), cVar);
            }
        }

        public void j(long j6, com.ss.android.j.j.cw.g gVar) {
            if (gVar != null) {
                this.f37945c.put(Long.valueOf(j6), gVar);
            }
        }

        public void k(com.ss.android.j.j.cw.b bVar) {
            if (bVar != null) {
                this.f37944b.put(Long.valueOf(bVar.r()), bVar);
                if (bVar.l() != null) {
                    bVar.l().c(bVar.r());
                    bVar.l().e(bVar.s());
                }
            }
        }

        public void p(long j6) {
            this.f37944b.remove(Long.valueOf(j6));
            this.f37945c.remove(Long.valueOf(j6));
            this.f37946d.remove(Long.valueOf(j6));
        }

        public com.ss.android.xt.j.xt.b q(long j6) {
            return this.f37947e.get(Long.valueOf(j6));
        }

        @NonNull
        public i r(long j6) {
            i iVar = new i();
            iVar.f37960a = j6;
            iVar.f37961b = d(j6);
            com.ss.android.j.j.cw.g s5 = s(j6);
            iVar.f37962c = s5;
            if (s5 == null) {
                iVar.f37962c = new com.ss.android.j.j.cw.a();
            }
            com.ss.android.j.j.cw.c a6 = a(j6);
            iVar.f37963d = a6;
            if (a6 == null) {
                iVar.f37963d = new com.ss.android.j.j.cw.d();
            }
            return iVar;
        }

        public com.ss.android.j.j.cw.g s(long j6) {
            return this.f37945c.get(Long.valueOf(j6));
        }

        public static f c() {
            return b.f37949a;
        }

        public com.ss.android.xt.j.xt.b g(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            for (com.ss.android.xt.j.xt.b bVar : this.f37947e.values()) {
                if (bVar != null && str.equals(bVar.up())) {
                    return bVar;
                }
            }
            return null;
        }

        public com.ss.android.xt.j.xt.b t(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            for (com.ss.android.xt.j.xt.b bVar : this.f37947e.values()) {
                if (bVar != null && str.equals(bVar.j())) {
                    return bVar;
                }
            }
            return null;
        }

        public void v() {
            com.ss.android.downloadlib.e.c().f(new a(), true);
        }

        public void w(String str, String str2) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                for (com.ss.android.j.j.cw.b bVar : this.f37944b.values()) {
                    if ((bVar instanceof com.ss.android.xt.j.j.a) && TextUtils.equals(bVar.j(), str)) {
                        ((com.ss.android.xt.j.j.a) bVar).z(str2);
                    }
                }
            }
        }
    }

    public class g {

        /* renamed from: b, reason: collision with root package name */
        private static volatile g f37950b;

        /* renamed from: c, reason: collision with root package name */
        private static final String[] f37951c = {"com", FaceEnvironment.OS, "ss"};

        /* renamed from: d, reason: collision with root package name */
        private static final int[] f37952d = {3101, 3102, 3103, 3201, 3202, 3203};

        /* renamed from: a, reason: collision with root package name */
        private final LinkedList<b> f37953a = new LinkedList<>();

        static /* synthetic */ class a {
        }

        public static class b {

            /* renamed from: a, reason: collision with root package name */
            public final String f37954a;

            /* renamed from: b, reason: collision with root package name */
            public final int f37955b;

            /* renamed from: c, reason: collision with root package name */
            public final String f37956c;

            /* renamed from: d, reason: collision with root package name */
            public final String f37957d;

            /* renamed from: e, reason: collision with root package name */
            public final long f37958e;

            /* synthetic */ b(String str, int i6, String str2, String str3, long j6, a aVar) {
                this(str, i6, str2, str3, j6);
            }

            private b(String str, int i6, String str2, String str3, long j6) {
                this.f37954a = str;
                this.f37955b = i6;
                this.f37956c = str2 != null ? str2.toLowerCase() : null;
                this.f37957d = str3 != null ? str3.toLowerCase() : null;
                this.f37958e = j6;
            }
        }

        public b b(com.ss.android.xt.j.xt.b bVar) {
            if (bVar == null) {
                return null;
            }
            g();
            synchronized (this.f37953a) {
                try {
                    Iterator<b> it = this.f37953a.iterator();
                    while (it.hasNext()) {
                        b next = it.next();
                        if (next.f37958e > bVar.g0()) {
                            return next;
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public static g c() {
            if (f37950b == null) {
                synchronized (g.class) {
                    try {
                        if (f37950b == null) {
                            f37950b = new g();
                        }
                    } finally {
                    }
                }
            }
            return f37950b;
        }

        private static boolean e(String str, String str2) {
            String[] split;
            String[] split2;
            boolean z5;
            try {
                split = str.split("\\.");
                split2 = str2.split("\\.");
            } catch (Throwable th) {
                vl.j(th);
            }
            if (split.length != 0 && split2.length != 0) {
                int i6 = 0;
                int i7 = 0;
                for (String str3 : split) {
                    String[] strArr = f37951c;
                    int length = strArr.length;
                    int i8 = 0;
                    while (true) {
                        if (i8 >= length) {
                            z5 = false;
                            break;
                        }
                        String str4 = strArr[i8];
                        if (str4.equals(str3)) {
                            if (i6 < split2.length && str4.equals(split2[i6])) {
                                i6++;
                            }
                            z5 = true;
                        } else {
                            i8++;
                        }
                    }
                    if (!z5) {
                        int i9 = i7;
                        int i10 = i6;
                        while (i6 < split2.length) {
                            if (str3.equals(split2[i6])) {
                                if (i6 == i10) {
                                    i10++;
                                }
                                i9++;
                                if (i9 >= 2) {
                                    return true;
                                }
                            }
                            i6++;
                        }
                        i6 = i10;
                        i7 = i9;
                    }
                }
                return false;
            }
            return false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:39:0x0099, code lost:
        
            r7[1] = r11;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public android.util.Pair<com.ss.android.downloadlib.addownload.o.g.b, java.lang.Integer> f(com.ss.android.xt.j.xt.b r19) {
            /*
                Method dump skipped, instructions count: 340
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.o.g.f(com.ss.android.xt.j.xt.b):android.util.Pair");
        }

        private g() {
        }

        private b a(String str) {
            try {
                PackageManager packageManager = m.getContext().getPackageManager();
                PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                if (packageInfo != null) {
                    return new b(str, packageInfo.versionCode, packageInfo.versionName, (String) packageManager.getApplicationLabel(packageInfo.applicationInfo), System.currentTimeMillis(), null);
                }
                return null;
            } catch (Throwable th) {
                vl.j(th);
                return null;
            }
        }

        private void g() {
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (this.f37953a) {
                try {
                    Iterator<b> it = this.f37953a.iterator();
                    while (it.hasNext() && currentTimeMillis - it.next().f37958e > 1800000) {
                        it.remove();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void d(String str) {
            b a6;
            g();
            if (!TextUtils.isEmpty(str) && (a6 = a(str)) != null) {
                synchronized (this.f37953a) {
                    this.f37953a.add(a6);
                }
            }
        }

        public void h(String str) {
            g();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            synchronized (this.f37953a) {
                try {
                    Iterator<b> it = this.f37953a.iterator();
                    while (it.hasNext()) {
                        if (str.equals(it.next().f37954a)) {
                            it.remove();
                            return;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public class h {

        /* renamed from: a, reason: collision with root package name */
        private static volatile h f37959a;

        public static h a() {
            if (f37959a == null) {
                synchronized (g.class) {
                    try {
                        if (f37959a == null) {
                            f37959a = new h();
                        }
                    } finally {
                    }
                }
            }
            return f37959a;
        }

        public void b(int i6, int i7, com.ss.android.xt.j.xt.b bVar) {
            if (bVar == null) {
                return;
            }
            com.ss.android.socialbase.downloader.jy.j j6 = com.ss.android.socialbase.downloader.jy.j.j(bVar.mi());
            if (j6.j("report_api_hijack", 0) == 0) {
                return;
            }
            int i8 = i7 - i6;
            if (i6 <= 0 || i8 <= j6.j("check_api_hijack_version_code_diff", 500)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("version_code_diff", i8);
                jSONObject.put("installed_version_code", i7);
                jSONObject.put("hijack_type", 1);
            } catch (JSONException e6) {
                vl.j(e6);
            }
            com.ss.android.downloadlib.r.b.a().x("api_hijack", jSONObject, bVar);
        }

        private h() {
        }
    }

    public class i implements com.ss.android.xt.j.xt.a {

        /* renamed from: a, reason: collision with root package name */
        public long f37960a;

        /* renamed from: b, reason: collision with root package name */
        public com.ss.android.j.j.cw.b f37961b;

        /* renamed from: c, reason: collision with root package name */
        public com.ss.android.j.j.cw.g f37962c;

        /* renamed from: d, reason: collision with root package name */
        public com.ss.android.j.j.cw.c f37963d;

        /* renamed from: e, reason: collision with root package name */
        public com.ss.android.xt.j.xt.b f37964e;

        public i() {
        }

        @Override // com.ss.android.xt.j.xt.a
        public int mi() {
            return 0;
        }

        public i(long j6, @NonNull com.ss.android.j.j.cw.b bVar, @NonNull com.ss.android.j.j.cw.g gVar, @NonNull com.ss.android.j.j.cw.c cVar) {
            this.f37960a = j6;
            this.f37961b = bVar;
            this.f37962c = gVar;
            this.f37963d = cVar;
        }

        @Override // com.ss.android.xt.j.xt.a
        public JSONObject ae() {
            return this.f37961b.h();
        }

        @Override // com.ss.android.xt.j.xt.a
        public JSONObject av() {
            return this.f37962c.ws();
        }

        @Override // com.ss.android.xt.j.xt.a
        public Object az() {
            return this.f37962c.oq();
        }

        public boolean b() {
            com.ss.android.j.j.cw.b bVar;
            if (this.f37960a == 0 || (bVar = this.f37961b) == null || this.f37962c == null || this.f37963d == null) {
                return true;
            }
            return bVar.x() && this.f37960a <= 0;
        }

        @Override // com.ss.android.xt.j.xt.a
        public boolean cw() {
            return this.f37961b.x();
        }

        @Override // com.ss.android.xt.j.xt.a
        public com.ss.android.j.j.cw.g f() {
            return this.f37962c;
        }

        @Override // com.ss.android.xt.j.xt.a
        public String g() {
            return this.f37962c.j();
        }

        @Override // com.ss.android.xt.j.xt.a
        public boolean i() {
            return this.f37963d.ws();
        }

        @Override // com.ss.android.xt.j.xt.a
        public String j() {
            return this.f37961b.j();
        }

        @Override // com.ss.android.xt.j.xt.a
        public boolean jy() {
            return this.f37962c.jy();
        }

        @Override // com.ss.android.xt.j.xt.a
        public int kt() {
            return this.f37962c.qv();
        }

        @Override // com.ss.android.xt.j.xt.a
        public String m() {
            if (this.f37961b.l() != null) {
                return this.f37961b.l().f();
            }
            return null;
        }

        @Override // com.ss.android.xt.j.xt.a
        public String oq() {
            return this.f37962c.xt();
        }

        @Override // com.ss.android.xt.j.xt.a
        public JSONObject qv() {
            return this.f37962c.az();
        }

        @Override // com.ss.android.xt.j.xt.a
        public String r() {
            return this.f37961b.ch();
        }

        @Override // com.ss.android.xt.j.xt.a
        public com.ss.android.j.j.cw.b tj() {
            return this.f37961b;
        }

        @Override // com.ss.android.xt.j.xt.a
        public int tl() {
            if (this.f37963d.xt() == 2) {
                return 2;
            }
            return this.f37961b.c();
        }

        @Override // com.ss.android.xt.j.xt.a
        public String up() {
            return this.f37961b.s();
        }

        @Override // com.ss.android.xt.j.xt.a
        public com.ss.android.j.j.cw.c v() {
            return this.f37963d;
        }

        @Override // com.ss.android.xt.j.xt.a
        public long vl() {
            return this.f37961b.ae();
        }

        @Override // com.ss.android.xt.j.xt.a
        public JSONObject w() {
            return this.f37961b.w();
        }

        @Override // com.ss.android.xt.j.xt.a
        public List<String> ws() {
            return this.f37961b.p();
        }

        @Override // com.ss.android.xt.j.xt.a
        public long xt() {
            return this.f37961b.r();
        }

        public boolean a() {
            if (b()) {
                return false;
            }
            if (this.f37961b.x()) {
                com.ss.android.j.j.cw.b bVar = this.f37961b;
                if (!(bVar instanceof com.ss.android.xt.j.j.a) || TextUtils.isEmpty(bVar.ch()) || !(this.f37962c instanceof com.ss.android.xt.j.j.c) || !(this.f37963d instanceof com.ss.android.xt.j.j.b)) {
                    return false;
                }
                return true;
            }
            return this.f37961b instanceof com.ss.android.xt.j.j.a;
        }
    }

    public class j {

        /* renamed from: a, reason: collision with root package name */
        public long f37965a;

        /* renamed from: b, reason: collision with root package name */
        public long f37966b;

        /* renamed from: c, reason: collision with root package name */
        public String f37967c;

        /* renamed from: d, reason: collision with root package name */
        public String f37968d;

        /* renamed from: e, reason: collision with root package name */
        public String f37969e;

        /* renamed from: f, reason: collision with root package name */
        public String f37970f;

        /* renamed from: g, reason: collision with root package name */
        public String f37971g;

        /* renamed from: h, reason: collision with root package name */
        public final List<Pair<String, String>> f37972h = new ArrayList();

        /* renamed from: i, reason: collision with root package name */
        public String f37973i;

        public static long b(long j6, long j7) {
            return j6 > 0 ? j6 : j7;
        }

        public long a() {
            return b(this.f37965a, this.f37966b);
        }
    }

    public static o a() {
        if (f37914b == null) {
            synchronized (o.class) {
                try {
                    if (f37914b == null) {
                        f37914b = new o();
                    }
                } finally {
                }
            }
        }
        return f37914b;
    }

    public void b(Context context, com.ss.android.socialbase.downloader.ae.cw cwVar) {
        if (!c() || cwVar == null) {
            return;
        }
        try {
            File file = new File(cwVar.qv(), cwVar.tl());
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        } catch (Exception e6) {
            vl.j(e6);
        }
        if (this.f37915a == null) {
            this.f37915a = new Handler(Looper.getMainLooper());
        }
        String oq = cwVar.oq();
        ae.xt(context).oq(cwVar.ae());
        this.f37915a.post(new a(oq));
    }

    public boolean c() {
        if (m.f().optInt("forbid_invalidte_download_file_install", 0) != 1) {
            return false;
        }
        return true;
    }
}
