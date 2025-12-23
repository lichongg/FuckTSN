package com.huawei.hms.scankit.p;

import android.os.Bundle;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseArray;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.hms.hmsscankit.DetailRect;
import com.huawei.hms.ml.scan.HmsScan;
import com.stub.StubApp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class w3 extends u3 {

    /* renamed from: h, reason: collision with root package name */
    private volatile String f34933h;

    /* renamed from: i, reason: collision with root package name */
    private volatile String f34934i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f34935j;

    /* renamed from: k, reason: collision with root package name */
    private volatile long f34936k;

    /* renamed from: l, reason: collision with root package name */
    public d f34937l;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends SimpleDateFormat {
        a(String str) {
            super(str);
            setTimeZone(TimeZone.getTimeZone("UTC"));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends SimpleDateFormat {
        b(String str) {
            super(str);
            setTimeZone(TimeZone.getTimeZone("UTC"));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private int f34940a;

        /* renamed from: b, reason: collision with root package name */
        private String f34941b;

        /* renamed from: c, reason: collision with root package name */
        private String f34942c;

        /* renamed from: d, reason: collision with root package name */
        private long f34943d;

        /* renamed from: e, reason: collision with root package name */
        private long f34944e;

        /* renamed from: f, reason: collision with root package name */
        private String f34945f;

        /* renamed from: g, reason: collision with root package name */
        private String f34946g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f34947h;

        /* renamed from: i, reason: collision with root package name */
        private int f34948i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f34949j;

        /* synthetic */ c(long j6, String str, String str2, boolean z5, int i6, int i7, a aVar) {
            this(j6, str, str2, z5, i6, i7);
        }

        private c(long j6, String str, String str2, boolean z5, int i6, int i7) {
            this.f34943d = j6;
            this.f34941b = str;
            this.f34942c = str2;
            this.f34947h = z5;
            this.f34948i = i6;
            this.f34940a = i7;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public c b(String str) {
            this.f34946g = str;
            return this;
        }

        public c a(int i6) {
            this.f34940a = i6;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public c a(long j6) {
            this.f34944e = j6;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public c a(boolean z5) {
            this.f34949j = z5;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public c a(String str) {
            this.f34945f = str;
            return this;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        private String f34950a = d.class.getSimpleName();

        /* renamed from: b, reason: collision with root package name */
        public Timer f34951b = new Timer();

        /* renamed from: c, reason: collision with root package name */
        private volatile boolean f34952c = true;

        /* renamed from: d, reason: collision with root package name */
        private List<c> f34953d = new ArrayList(10);

        /* renamed from: e, reason: collision with root package name */
        private List<c> f34954e = new ArrayList(10);

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a extends TimerTask {
            a() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                try {
                    d.this.f34952c = true;
                    d.this.a();
                } catch (Exception unused) {
                    o4.b(d.this.f34950a, "onLog Exception");
                }
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private class b {

            /* renamed from: a, reason: collision with root package name */
            private StringBuilder f34957a;

            /* renamed from: b, reason: collision with root package name */
            private AtomicInteger[] f34958b;

            /* renamed from: c, reason: collision with root package name */
            private String[] f34959c;

            /* renamed from: d, reason: collision with root package name */
            private long[] f34960d;

            private b() {
                this.f34957a = new StringBuilder(100);
                this.f34958b = new AtomicInteger[]{new AtomicInteger(), new AtomicInteger(), new AtomicInteger(), new AtomicInteger(), new AtomicInteger(), new AtomicInteger(), new AtomicInteger()};
                this.f34959c = new String[]{"lt10K:", "lt100K:", "lt1M:", "lt3M:", "lt10M:", "lt40M:", "gt40M:"};
                this.f34960d = new long[]{10240, 102400, PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED, 3145728, 10485760, 41943040, Long.MAX_VALUE};
            }

            /* JADX INFO: Access modifiers changed from: private */
            public String a() {
                StringBuilder sb = this.f34957a;
                sb.delete(0, sb.length());
                this.f34957a.append("{");
                for (int i6 = 0; i6 < this.f34958b.length; i6++) {
                    this.f34957a.append(this.f34959c[i6]);
                    this.f34957a.append(this.f34958b[i6]);
                    this.f34957a.append(",");
                }
                this.f34957a.replace(r0.length() - 1, this.f34957a.length(), "}");
                return this.f34957a.toString();
            }

            /* synthetic */ b(d dVar, a aVar) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a(int i6) {
                int i7 = 0;
                while (true) {
                    AtomicInteger[] atomicIntegerArr = this.f34958b;
                    if (i7 >= atomicIntegerArr.length) {
                        return;
                    }
                    if (i6 <= this.f34960d[i7]) {
                        atomicIntegerArr[i7].addAndGet(1);
                        return;
                    }
                    i7++;
                }
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private class c {

            /* renamed from: a, reason: collision with root package name */
            private StringBuilder f34962a;

            /* renamed from: b, reason: collision with root package name */
            private SparseArray<AtomicInteger> f34963b;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            class a extends SparseArray<AtomicInteger> {
                a() {
                    put(0, new AtomicInteger());
                }
            }

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            class b extends AtomicInteger {
                b() {
                    addAndGet(1);
                }
            }

            private c() {
                this.f34962a = new StringBuilder(60);
                this.f34963b = new a();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a(int i6) {
                if (this.f34963b.get(i6) == null) {
                    this.f34963b.put(i6, new b());
                } else {
                    this.f34963b.get(i6).addAndGet(1);
                }
            }

            /* synthetic */ c(d dVar, a aVar) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public String a() {
                StringBuilder sb = this.f34962a;
                sb.delete(0, sb.length());
                this.f34962a.append("{");
                for (int i6 = 0; i6 < this.f34963b.size(); i6++) {
                    this.f34962a.append(this.f34963b.keyAt(i6));
                    this.f34962a.append(":");
                    this.f34962a.append(this.f34963b.valueAt(i6));
                    this.f34962a.append(",");
                }
                this.f34962a.replace(r0.length() - 1, this.f34962a.length(), "}");
                return this.f34962a.toString();
            }
        }

        public d() {
        }

        public void b() {
            Timer timer = this.f34951b;
            if (timer != null) {
                timer.cancel();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar) {
            if (this.f34953d.size() > 100) {
                return;
            }
            synchronized (this) {
                try {
                    this.f34953d.add(cVar);
                    if (this.f34952c) {
                        this.f34952c = false;
                        this.f34951b.schedule(new a(), 1000L);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            if (this.f34953d.size() > 0) {
                synchronized (this) {
                    List<c> list = this.f34953d;
                    List<c> list2 = this.f34954e;
                    this.f34953d = list2;
                    this.f34954e = list;
                    list2.clear();
                }
                a(this.f34954e);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r24v2, types: [java.lang.Boolean] */
        private void a(List<c> list) {
            HashSet<String> hashSet = new HashSet();
            Iterator<c> it = list.iterator();
            while (it.hasNext()) {
                hashSet.add(it.next().f34942c);
            }
            for (String str : hashSet) {
                a aVar = null;
                c cVar = new c(this, aVar);
                b bVar = new b(this, aVar);
                String str2 = "";
                long j6 = Long.MIN_VALUE;
                long j7 = 0;
                long j8 = 0;
                long j9 = 0;
                long j10 = 0;
                long j11 = Long.MAX_VALUE;
                String str3 = "";
                String str4 = str3;
                for (c cVar2 : list) {
                    str2 = cVar2.f34941b;
                    str3 = cVar2.f34945f;
                    str4 = cVar2.f34946g;
                    ?? valueOf = Boolean.valueOf(cVar2.f34947h);
                    j8 += cVar2.f34944e - cVar2.f34943d;
                    cVar.a(cVar2.f34940a);
                    bVar.a(cVar2.f34948i);
                    j7++;
                    if (cVar2.f34949j) {
                        j10++;
                    }
                    if (cVar2.f34940a != 0) {
                        j9++;
                    }
                    if (cVar2.f34944e - cVar2.f34943d < j11) {
                        j11 = cVar2.f34944e - cVar2.f34943d;
                    }
                    if (cVar2.f34944e - cVar2.f34943d > j6) {
                        j6 = cVar2.f34944e - cVar2.f34943d;
                    }
                    aVar = valueOf;
                }
                LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
                w3.this.g();
                linkedHashMap.putAll(w3.this.f34861b);
                linkedHashMap.put("result", cVar.a());
                linkedHashMap.put("imgSizeHistogram", bVar.a());
                linkedHashMap.put(WiseOpenHianalyticsData.UNION_CALLTIME, str2);
                linkedHashMap.put("transId", str);
                if (j7 != 0) {
                    j8 /= j7;
                }
                linkedHashMap.put(WiseOpenHianalyticsData.UNION_COSTTIME, String.valueOf(j8));
                linkedHashMap.put("allCnt", String.valueOf(j7));
                linkedHashMap.put("failCnt", String.valueOf(j9));
                linkedHashMap.put("codeCnt", String.valueOf(j10));
                linkedHashMap.put("scanType", str3);
                linkedHashMap.put("sceneType", str4);
                linkedHashMap.put("min", String.valueOf(j11));
                linkedHashMap.put("max", String.valueOf(j6));
                linkedHashMap.put("algPhotoMode", String.valueOf(aVar));
                a4.b().b("60001", linkedHashMap);
            }
        }
    }

    public void a(String str) {
        this.f34861b.put("algapi", str);
    }

    public c a(boolean z5, int i6) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                if (this.f34935j) {
                    return new c(currentTimeMillis, new a("yyyyMMddHHmmss.SSS").format(Long.valueOf(currentTimeMillis)), UUID.randomUUID().toString(), z5, i6, 0, null);
                }
                if (currentTimeMillis - this.f34936k > 1500) {
                    String format = new b("yyyyMMddHHmmss.SSS").format(Long.valueOf(currentTimeMillis));
                    String uuid = UUID.randomUUID().toString();
                    if (currentTimeMillis - this.f34936k > 1500) {
                        this.f34933h = format;
                        this.f34934i = uuid;
                        this.f34936k = currentTimeMillis;
                    }
                }
                return new c(currentTimeMillis, this.f34933h, this.f34934i, z5, i6, 0, null);
            } catch (Exception unused) {
                o4.b("HaLog6001", "exception happens");
                return new c(currentTimeMillis, this.f34933h, this.f34934i, z5, i6, 0, null);
            }
        } catch (Exception unused2) {
        }
    }

    public w3(Bundle bundle, String str) {
        super(bundle, StubApp.getOrigApplicationContext(DynamicModuleInitializer.getContext().getApplicationContext()));
        this.f34935j = false;
        this.f34937l = new d();
        this.f34861b.put(WiseOpenHianalyticsData.UNION_API_NAME, str);
        if (DetailRect.PHOTO_MODE.equals(str)) {
            this.f34935j = true;
        }
    }

    public void a(HmsScan[] hmsScanArr, c cVar) {
        try {
            String str = u3.f34856d;
            String str2 = u3.f34857e;
            if (a()) {
                boolean z5 = false;
                int i6 = 0;
                z5 = false;
                if (hmsScanArr != null && hmsScanArr.length > 0) {
                    int length = hmsScanArr.length;
                    while (i6 < length) {
                        HmsScan hmsScan = hmsScanArr[i6];
                        String a6 = u3.a(hmsScan.scanType);
                        i6++;
                        str2 = u3.b(hmsScan.scanTypeForm);
                        str = a6;
                    }
                    z5 = true;
                }
                this.f34937l.a(cVar.a(System.currentTimeMillis()).a(z5).a(str).b(str2));
                this.f34936k = cVar.f34944e;
            }
        } catch (NullPointerException unused) {
            o4.b("HaLog60001", "nullPoint");
        } catch (Exception unused2) {
            o4.b("HaLog60001", "logEnd Exception");
        }
    }
}
