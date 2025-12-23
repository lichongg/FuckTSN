package com.bytedance.msdk.up;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r {
    public String ae;
    public String av;
    public String az;
    public String cw;

    /* renamed from: g, reason: collision with root package name */
    public long f25311g;

    /* renamed from: i, reason: collision with root package name */
    public int f25312i;

    /* renamed from: j, reason: collision with root package name */
    public String f25313j;
    public String jy;

    /* renamed from: m, reason: collision with root package name */
    public String f25314m;
    public String oq;
    public String qv;

    /* renamed from: r, reason: collision with root package name */
    public String f25315r;
    public String tj;
    public String tl;
    public String up;
    public String vl;

    /* renamed from: w, reason: collision with root package name */
    public long f25317w;
    public int ws;
    public String xt;
    public int mi = -1;
    public int kt = -1;

    /* renamed from: f, reason: collision with root package name */
    public Map<String, Object> f25310f = new ConcurrentHashMap();

    /* renamed from: v, reason: collision with root package name */
    private long f25316v = -1;

    public r cw(String str) {
        this.oq = str;
        return this;
    }

    public r j(int i6) {
        this.jy = String.valueOf(i6);
        return this;
    }

    public r m(String str) {
        this.f25315r = str;
        return this;
    }

    public r r(String str) {
        this.xt = str;
        return this;
    }

    public r up(String str) {
        this.cw = str;
        return this;
    }

    public r xt(String str) {
        this.tl = str;
        return this;
    }

    public r ae(String str) {
        this.up = str;
        return this;
    }

    public r cw(int i6) {
        this.az = String.valueOf(i6);
        return this;
    }

    public r g(String str) {
        this.ae = str;
        return this;
    }

    public r j(long j6) {
        this.f25317w = j6;
        return this;
    }

    public r m(int i6) {
        this.kt = i6;
        return this;
    }

    public r oq(String str) {
        this.qv = str;
        return this;
    }

    public r qv(String str) {
        this.tj = str;
        return this;
    }

    public r r(int i6) {
        this.av = String.valueOf(i6);
        return this;
    }

    public r setResult(int i6) {
        this.mi = i6;
        return this;
    }

    public r tl(String str) {
        this.f25314m = str;
        return this;
    }

    public r up(int i6) {
        this.f25312i = i6;
        return this;
    }

    public r xt(long j6) {
        this.f25311g = j6;
        return this;
    }

    protected r() {
    }

    public r cw(long j6) {
        this.f25316v = j6;
        return this;
    }

    public r j(String str) {
        this.f25313j = str;
        return this;
    }

    public r xt(int i6) {
        this.ws = i6;
        return this;
    }

    public static r cw() {
        r rVar = new r();
        rVar.cw(System.currentTimeMillis());
        return rVar;
    }

    public static r xt() {
        return new r();
    }

    public r j(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            this.f25310f.put(str, obj);
        }
        return this;
    }

    public r j(Map<String, Object> map) {
        if (map != null && map.size() > 0) {
            this.f25310f.putAll(map);
        }
        return this;
    }

    public long j() {
        return this.f25316v;
    }
}
