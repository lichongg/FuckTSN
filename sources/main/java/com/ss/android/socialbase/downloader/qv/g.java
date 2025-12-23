package com.ss.android.socialbase.downloader.qv;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public final class g {
    private int ae;
    private final long cw;

    /* renamed from: j, reason: collision with root package name */
    volatile jy f38914j;

    /* renamed from: m, reason: collision with root package name */
    private long f38915m;

    /* renamed from: r, reason: collision with root package name */
    private final AtomicLong f38916r;
    private JSONObject tl;
    private volatile long up;
    int xt;

    public g(long j6, long j7) {
        AtomicLong atomicLong = new AtomicLong();
        this.f38916r = atomicLong;
        this.xt = 0;
        this.cw = j6;
        atomicLong.set(j6);
        this.up = j6;
        if (j7 >= j6) {
            this.f38915m = j7;
        } else {
            this.f38915m = -1L;
        }
    }

    public long cw() {
        return this.cw;
    }

    public long j() {
        return this.f38916r.get() - this.cw;
    }

    public long r() {
        long j6 = this.f38916r.get();
        long j7 = this.f38915m;
        if (j7 > 0) {
            long j8 = j7 + 1;
            if (j6 > j8) {
                return j8;
            }
        }
        return j6;
    }

    public long xt() {
        long j6 = this.f38915m;
        if (j6 >= this.cw) {
            return (j6 - up()) + 1;
        }
        return -1L;
    }

    public int ae() {
        return this.ae;
    }

    void cw(long j6) {
        if (j6 >= this.cw) {
            this.f38915m = j6;
            return;
        }
        com.bytedance.sdk.component.utils.vl.xt("Segment", "setEndOffset: endOffset = " + j6 + ", segment = " + this);
        if (j6 == -1) {
            this.f38915m = j6;
        }
    }

    void g() {
        this.xt--;
    }

    public void j(long j6) {
        long j7 = this.cw;
        if (j6 < j7) {
            j6 = j7;
        }
        long j8 = this.f38915m;
        if (j8 > 0) {
            long j9 = j8 + 1;
            if (j6 > j9) {
                j6 = j9;
            }
        }
        this.f38916r.set(j6);
    }

    public long m() {
        return this.f38915m;
    }

    int oq() {
        return this.xt;
    }

    public JSONObject qv() throws JSONException {
        JSONObject jSONObject = this.tl;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
            this.tl = jSONObject;
        }
        jSONObject.put("st", cw());
        jSONObject.put("cu", r());
        jSONObject.put("en", m());
        return jSONObject;
    }

    void tl() {
        this.xt++;
    }

    public String toString() {
        return "Segment{startOffset=" + this.cw + ",\t currentOffset=" + this.f38916r + ",\t currentOffsetRead=" + up() + ",\t endOffset=" + this.f38915m + '}';
    }

    public long up() {
        jy jyVar = this.f38914j;
        if (jyVar != null) {
            long r5 = jyVar.r();
            if (r5 > this.up) {
                return r5;
            }
        }
        return this.up;
    }

    public void r(long j6) {
        if (j6 >= this.f38916r.get()) {
            this.up = j6;
        }
    }

    void xt(long j6) {
        this.f38916r.addAndGet(j6);
    }

    void xt(int i6) {
        this.xt = i6;
    }

    void j(int i6) {
        this.ae = i6;
    }

    public static String j(List<g> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Collections.sort(list, new Comparator<g>() { // from class: com.ss.android.socialbase.downloader.qv.g.1
            @Override // java.util.Comparator
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public int compare(g gVar, g gVar2) {
                return (int) (gVar.cw() - gVar2.cw());
            }
        });
        StringBuilder sb = new StringBuilder();
        Iterator<g> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(org.apache.commons.net.g.f50795q);
        }
        return sb.toString();
    }

    public g(g gVar) {
        AtomicLong atomicLong = new AtomicLong();
        this.f38916r = atomicLong;
        this.xt = 0;
        this.cw = gVar.cw;
        this.f38915m = gVar.f38915m;
        atomicLong.set(gVar.f38916r.get());
        this.up = atomicLong.get();
        this.ae = gVar.ae;
    }

    public g(JSONObject jSONObject) {
        this.f38916r = new AtomicLong();
        this.xt = 0;
        this.cw = jSONObject.optLong("st");
        cw(jSONObject.optLong("en"));
        j(jSONObject.optLong("cu"));
        r(r());
    }
}
