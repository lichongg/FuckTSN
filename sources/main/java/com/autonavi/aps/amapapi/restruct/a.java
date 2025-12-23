package com.autonavi.aps.amapapi.restruct;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.amap.api.col.p0003l.j4;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class a<T> {

    /* renamed from: a, reason: collision with root package name */
    public String f9995a;

    /* renamed from: b, reason: collision with root package name */
    private File f9996b;

    /* renamed from: e, reason: collision with root package name */
    private Handler f9999e;

    /* renamed from: f, reason: collision with root package name */
    private String f10000f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f10001g;

    /* renamed from: c, reason: collision with root package name */
    private boolean f9997c = false;

    /* renamed from: d, reason: collision with root package name */
    private Map<String, C0095a> f9998d = new ConcurrentHashMap();

    /* renamed from: h, reason: collision with root package name */
    private Runnable f10002h = new Runnable() { // from class: com.autonavi.aps.amapapi.restruct.a.2
        @Override // java.lang.Runnable
        public final void run() {
            if (a.this.f9997c) {
                if (a.this.f10001g) {
                    a.this.e();
                    a.e(a.this);
                }
                if (a.this.f9999e != null) {
                    a.this.f9999e.postDelayed(a.this.f10002h, 60000L);
                }
            }
        }
    };

    public static int a(long j6, long j7) {
        if (j6 < j7) {
            return -1;
        }
        return j6 == j7 ? 0 : 1;
    }

    static /* synthetic */ boolean e(a aVar) {
        aVar.f10001g = false;
        return false;
    }

    abstract void a(T t5, long j6);

    abstract long b();

    public abstract String b(T t5);

    abstract int c(T t5);

    abstract long c();

    abstract long d(T t5);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.autonavi.aps.amapapi.restruct.a$a, reason: collision with other inner class name */
    static class C0095a {

        /* renamed from: a, reason: collision with root package name */
        int f10005a;

        /* renamed from: b, reason: collision with root package name */
        long f10006b;

        /* renamed from: c, reason: collision with root package name */
        long f10007c;

        public C0095a(int i6, long j6, long j7) {
            this.f10005a = i6;
            this.f10006b = j6;
            this.f10007c = j7;
        }
    }

    private void b(T t5, long j6) {
        if (t5 == null || d((a<T>) t5) < 0) {
            return;
        }
        String b6 = b((a<T>) t5);
        C0095a c0095a = this.f9998d.get(b6);
        if (c0095a == null) {
            a((a<T>) t5, j6);
            this.f9998d.put(b6, new C0095a(c((a<T>) t5), d((a<T>) t5), j6));
            this.f10001g = true;
            return;
        }
        c0095a.f10007c = j6;
        if (c0095a.f10005a == c((a<T>) t5)) {
            a((a<T>) t5, c0095a.f10006b);
            return;
        }
        a((a<T>) t5, j6);
        c0095a.f10005a = c((a<T>) t5);
        c0095a.f10006b = d((a<T>) t5);
        this.f10001g = true;
    }

    private void d() {
        try {
            Iterator<String> it = com.autonavi.aps.amapapi.utils.j.a(this.f9996b).iterator();
            while (it.hasNext()) {
                try {
                    String[] split = new String(com.autonavi.aps.amapapi.security.a.b(j4.g(it.next()), this.f10000f), "UTF-8").split(",");
                    this.f9998d.put(split[0], new C0095a(Integer.parseInt(split[1]), Long.parseLong(split[2]), split.length >= 4 ? Long.parseLong(split[3]) : com.autonavi.aps.amapapi.utils.j.b()));
                } catch (Throwable th) {
                    if (this.f9996b.exists()) {
                        this.f9996b.delete();
                    }
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (c() > 0) {
            this.f9998d.size();
            if (b() > 0) {
                long b6 = com.autonavi.aps.amapapi.utils.j.b();
                Iterator<Map.Entry<String, C0095a>> it = this.f9998d.entrySet().iterator();
                while (it.hasNext()) {
                    if (b6 - this.f9998d.get(it.next().getKey()).f10007c > b()) {
                        it.remove();
                    }
                }
            }
            if (this.f9998d.size() > c()) {
                ArrayList arrayList = new ArrayList(this.f9998d.keySet());
                Collections.sort(arrayList, new Comparator<String>() { // from class: com.autonavi.aps.amapapi.restruct.a.1
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // java.util.Comparator
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public int compare(String str, String str2) {
                        return a.a(((C0095a) a.this.f9998d.get(str2)).f10007c, ((C0095a) a.this.f9998d.get(str)).f10007c);
                    }
                });
                for (int c6 = (int) c(); c6 < arrayList.size(); c6++) {
                    this.f9998d.remove(arrayList.get(c6));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, C0095a> entry : this.f9998d.entrySet()) {
            try {
                sb.append(j4.f(com.autonavi.aps.amapapi.security.a.a((entry.getKey() + "," + entry.getValue().f10005a + "," + entry.getValue().f10006b + "," + entry.getValue().f10007c).getBytes("UTF-8"), this.f10000f)) + com.snail.antifake.deviceid.e.f37542d);
            } catch (UnsupportedEncodingException e6) {
                e6.printStackTrace();
            }
        }
        String sb2 = sb.toString();
        if (TextUtils.isEmpty(sb2)) {
            return;
        }
        com.autonavi.aps.amapapi.utils.j.a(this.f9996b, sb2);
    }

    public a(Context context, String str, Handler handler) {
        this.f10000f = null;
        if (context == null) {
            return;
        }
        this.f9999e = handler;
        this.f9995a = TextUtils.isEmpty(str) ? "unknow" : str;
        this.f10000f = com.autonavi.aps.amapapi.utils.j.l(context);
        try {
            this.f9996b = new File(context.getFilesDir().getPath(), this.f9995a);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        d();
    }

    public final void a() {
        Handler handler;
        if (!this.f9997c && (handler = this.f9999e) != null) {
            handler.removeCallbacks(this.f10002h);
            this.f9999e.postDelayed(this.f10002h, 60000L);
        }
        this.f9997c = true;
    }

    public final void a(boolean z5) {
        Handler handler = this.f9999e;
        if (handler != null) {
            handler.removeCallbacks(this.f10002h);
        }
        if (!z5) {
            this.f10002h.run();
        }
        this.f9997c = false;
    }

    public final void a(T t5) {
        b(t5, com.autonavi.aps.amapapi.utils.j.b());
    }

    public final void a(List<T> list) {
        long b6 = com.autonavi.aps.amapapi.utils.j.b();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            b(it.next(), b6);
        }
        if (this.f9998d.size() >= list.size()) {
            this.f10001g = true;
        }
        if (this.f9998d.size() > 16384 || c() <= 0) {
            this.f9998d.clear();
            for (T t5 : list) {
                this.f9998d.put(b((a<T>) t5), new C0095a(c((a<T>) t5), d((a<T>) t5), b6));
            }
        }
    }

    public final long e(T t5) {
        return (com.autonavi.aps.amapapi.utils.j.b() - d((a<T>) t5)) / 1000;
    }
}
