package com.bytedance.embedapplog;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.embedapplog.ll;
import com.bytedance.embedapplog.tk;
import com.bytedance.embedapplog.up;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
final class wi {

    /* renamed from: j, reason: collision with root package name */
    static final String f24089j;
    private static String oq;
    private static long qv;

    /* renamed from: r, reason: collision with root package name */
    private static final List<up> f24090r;
    private static boolean vl;
    private static final String xt;
    private final gr ae;
    private final ReentrantLock cw = new ReentrantLock();

    /* renamed from: g, reason: collision with root package name */
    private final AtomicBoolean f24091g = new AtomicBoolean(false);
    private Map<String, String> jy;

    /* renamed from: m, reason: collision with root package name */
    private final boolean f24092m;
    private final Context tl;
    private final tk up;
    private Long ws;

    static {
        String str = wi.class.getSimpleName() + "#";
        xt = str;
        f24089j = str;
        f24090r = new ArrayList();
    }

    private static Object[] cw() {
        Object[] array;
        List<up> list = f24090r;
        synchronized (list) {
            try {
                array = list.size() > 0 ? list.toArray() : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return array;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        int i6;
        try {
            this.cw.lock();
            na j6 = this.ae.j();
            long j7 = -1;
            boolean z5 = false;
            if (j6 != null) {
                oq = j6.f24014j;
                Boolean bool = j6.cw;
                vl = bool != null && bool.booleanValue();
                Long l6 = j6.ae;
                qv = l6 == null ? -1L : l6.longValue();
                this.jy = j6.j();
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Pair<String, Boolean> j8 = j(this.tl);
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            na naVar = null;
            String str = null;
            if (j8.first != null) {
                if (j6 != null) {
                    str = j6.xt;
                    i6 = j6.f24015m.intValue() + 1;
                } else {
                    i6 = -1;
                }
                if (TextUtils.isEmpty(str)) {
                    str = UUID.randomUUID().toString();
                }
                if (i6 <= 0) {
                    i6 = 1;
                }
                na naVar2 = new na((String) j8.first, str, (Boolean) j8.second, Long.valueOf(elapsedRealtime2), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i6), this.ws);
                this.ae.j(naVar2);
                naVar = naVar2;
            }
            if (naVar != null) {
                oq = naVar.f24014j;
                Boolean bool2 = naVar.cw;
                if (bool2 != null && bool2.booleanValue()) {
                    z5 = true;
                }
                vl = z5;
                Long l7 = naVar.ae;
                if (l7 != null) {
                    j7 = l7.longValue();
                }
                qv = j7;
                this.jy = naVar.j();
            }
            this.cw.unlock();
            j(new up.j(oq, vl, qv), cw());
        } catch (Throwable th) {
            this.cw.unlock();
            j(new up.j(oq, vl, qv), cw());
            throw th;
        }
    }

    @Nullable
    @WorkerThread
    public Map<String, String> j(long j6) {
        if (!this.f24092m) {
            return null;
        }
        if (!j.xt) {
            na j7 = this.ae.j();
            if (j7 != null) {
                return j7.j();
            }
            return null;
        }
        xt();
        if (this.jy == null) {
            SystemClock.elapsedRealtime();
            try {
                if (this.cw.tryLock(j6, TimeUnit.MILLISECONDS)) {
                    this.cw.unlock();
                }
            } catch (InterruptedException e6) {
                uc.j(e6);
            }
        }
        return this.jy;
    }

    public void xt() {
        if (this.f24091g.compareAndSet(false, true)) {
            j(new Runnable() { // from class: com.bytedance.embedapplog.wi.1
                @Override // java.lang.Runnable
                public void run() {
                    wi.this.r();
                }
            });
        }
    }

    wi(Context context) {
        this.tl = StubApp.getOrigApplicationContext(context.getApplicationContext());
        tk j6 = fx.j(context);
        this.up = j6;
        if (j6 != null) {
            this.f24092m = j6.j(context);
        } else {
            this.f24092m = false;
        }
        this.ae = new gr(context);
    }

    @AnyThread
    static void j(@Nullable up upVar) {
        List<up> list = f24090r;
        synchronized (list) {
            list.add(upVar);
        }
        String str = oq;
        if (str != null) {
            j(new up.j(str, vl, qv), new Object[]{upVar});
        }
    }

    public tk j() {
        return this.up;
    }

    private static void j(@Nullable up.j jVar, Object[] objArr) {
        if (jVar == null || objArr == null) {
            return;
        }
        for (Object obj : objArr) {
            ((up) obj).j(jVar);
        }
    }

    static void j(JSONObject jSONObject, String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e6) {
            uc.j(e6);
        }
    }

    static <K, V> void j(Map<K, V> map, K k6, V v5) {
        if (k6 == null || v5 == null) {
            return;
        }
        map.put(k6, v5);
    }

    @NonNull
    @WorkerThread
    private Pair<String, Boolean> j(Context context) {
        String str;
        Boolean bool;
        tk.j xt2;
        tk tkVar = this.up;
        if (tkVar == null || (xt2 = tkVar.xt(context)) == null) {
            str = null;
            bool = null;
        } else {
            str = xt2.xt;
            bool = Boolean.valueOf(xt2.cw);
            if (xt2 instanceof ll.j) {
                this.ws = Long.valueOf(((ll.j) xt2).f24013j);
            }
        }
        return new Pair<>(str, bool);
    }

    private static void j(Runnable runnable) {
        qo.j(f24089j + "-query", runnable);
    }
}
