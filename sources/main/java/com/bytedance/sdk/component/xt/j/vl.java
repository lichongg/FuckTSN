package com.bytedance.sdk.component.xt.j;

import android.os.Bundle;
import com.bytedance.sdk.component.cw.xt.kt;
import com.bytedance.sdk.component.cw.xt.p;
import com.bytedance.sdk.component.cw.xt.v;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes4.dex */
public class vl extends tl implements Cloneable {
    static final List<jy> tl = com.bytedance.sdk.component.xt.j.xt.oq.j(jy.HTTP_2, jy.HTTP_1_1);
    public TimeUnit ae;
    public TimeUnit cw;

    /* renamed from: g, reason: collision with root package name */
    public List<jy> f27307g;

    /* renamed from: j, reason: collision with root package name */
    public List<g> f27308j;

    /* renamed from: m, reason: collision with root package name */
    public long f27309m;
    public Set<String> oq;
    public v.j qv;

    /* renamed from: r, reason: collision with root package name */
    public long f27310r;
    public TimeUnit up;
    public Bundle vl;
    public long xt;

    public static final class j {
        public long ae;
        public long cw;

        /* renamed from: g, reason: collision with root package name */
        List<jy> f27311g;

        /* renamed from: j, reason: collision with root package name */
        public final List<g> f27312j;

        /* renamed from: m, reason: collision with root package name */
        public TimeUnit f27313m;
        public Set<String> oq;
        public Bundle qv;

        /* renamed from: r, reason: collision with root package name */
        public TimeUnit f27314r;
        public TimeUnit tl;
        public long up;
        private v.j vl;
        public com.bytedance.sdk.component.xt.j.j.j.j xt;

        public j() {
            this.f27312j = new ArrayList();
            this.cw = 10000L;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.f27314r = timeUnit;
            this.up = 10000L;
            this.f27313m = timeUnit;
            this.ae = 10000L;
            this.tl = timeUnit;
            if (com.bytedance.sdk.component.xt.j.j.j.j().xt()) {
                this.vl = new v.j();
            }
        }

        public j j(long j6, TimeUnit timeUnit) {
            v.j jVar;
            this.cw = j6;
            this.f27314r = timeUnit;
            if (com.bytedance.sdk.component.xt.j.j.j.j().xt() && (jVar = this.vl) != null) {
                jVar.j(this.cw, timeUnit);
            }
            return this;
        }

        public j cw(long j6, TimeUnit timeUnit) {
            v.j jVar;
            this.ae = j6;
            this.tl = timeUnit;
            if (com.bytedance.sdk.component.xt.j.j.j.j().xt() && (jVar = this.vl) != null) {
                jVar.cw(this.ae, timeUnit);
            }
            return this;
        }

        public j xt(long j6, TimeUnit timeUnit) {
            v.j jVar;
            this.up = j6;
            this.f27313m = timeUnit;
            if (com.bytedance.sdk.component.xt.j.j.j.j().xt() && (jVar = this.vl) != null) {
                jVar.xt(this.up, timeUnit);
            }
            return this;
        }

        public j j(com.bytedance.sdk.component.xt.j.j.j.j jVar) {
            v.j jVar2;
            this.xt = jVar;
            if (com.bytedance.sdk.component.xt.j.j.j.j().xt() && (jVar2 = this.vl) != null) {
                jVar2.j(new com.bytedance.sdk.component.xt.j.j.j.cw(jVar));
            }
            return this;
        }

        public j j(final g gVar) {
            v.j jVar;
            this.f27312j.add(gVar);
            if (com.bytedance.sdk.component.xt.j.j.j.j().xt() && (jVar = this.vl) != null) {
                jVar.j(new kt() { // from class: com.bytedance.sdk.component.xt.j.vl.j.1
                    @Override // com.bytedance.sdk.component.cw.xt.kt
                    public p j(kt.j jVar2) throws IOException {
                        return ((com.bytedance.sdk.component.xt.j.j.j.g) gVar.j(new com.bytedance.sdk.component.xt.j.j.j.up(jVar2))).f27275j;
                    }
                });
            }
            return this;
        }

        public j(String str) {
            this.f27312j = new ArrayList();
            this.cw = 10000L;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.f27314r = timeUnit;
            this.up = 10000L;
            this.f27313m = timeUnit;
            this.ae = 10000L;
            this.tl = timeUnit;
            this.f27311g = vl.tl;
            if (com.bytedance.sdk.component.xt.j.j.j.j().xt()) {
                this.vl = new v.j();
            }
        }

        public j j(Set<String> set) {
            this.oq = set;
            v.j jVar = this.vl;
            if (jVar != null) {
                jVar.j(set);
            }
            return this;
        }

        public j j(List<jy> list) {
            ArrayList arrayList = new ArrayList(list);
            if (arrayList.contains(jy.HTTP_1_1)) {
                if (!arrayList.contains(jy.HTTP_1_0)) {
                    if (!arrayList.contains(null)) {
                        arrayList.remove(jy.SPDY_3);
                        this.f27311g = Collections.unmodifiableList(arrayList);
                        return this;
                    }
                    throw new IllegalArgumentException("protocols must not contain null");
                }
                throw new IllegalArgumentException("protocols must not contain http/1.0: ".concat(String.valueOf(arrayList)));
            }
            throw new IllegalArgumentException("protocols doesn't contain http/1.1: ".concat(String.valueOf(arrayList)));
        }

        public j(vl vlVar) {
            this.f27312j = new ArrayList();
            this.cw = 10000L;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.f27314r = timeUnit;
            this.up = 10000L;
            this.f27313m = timeUnit;
            this.ae = 10000L;
            this.tl = timeUnit;
            this.cw = vlVar.xt;
            this.f27314r = vlVar.cw;
            this.up = vlVar.f27310r;
            this.f27313m = vlVar.up;
            this.ae = vlVar.f27309m;
            this.tl = vlVar.ae;
            this.f27311g = vlVar.f27307g;
            this.oq = vlVar.oq;
            if (com.bytedance.sdk.component.xt.j.j.j.j().xt()) {
                this.vl = vlVar.qv;
            }
            v.j jVar = this.vl;
            if (jVar != null) {
                jVar.f26404x = (int) vlVar.xt;
                jVar.f26394h = vlVar.cw;
                jVar.ch = (int) vlVar.f27310r;
                jVar.la = vlVar.up;
                jVar.f26401s = (int) vlVar.f27309m;
                jVar.gq = vlVar.ae;
                jVar.f26399p = vlVar.oq;
                jVar.f26397l = vlVar.vl;
            }
        }

        public j j(Bundle bundle) {
            this.qv = bundle;
            v.j jVar = this.vl;
            if (jVar != null) {
                jVar.f26397l = bundle;
            }
            return this;
        }

        public vl j() {
            if (com.bytedance.sdk.component.xt.j.j.j.j().xt()) {
                return com.bytedance.sdk.component.xt.j.j.j.j(this.vl);
            }
            return com.bytedance.sdk.component.xt.j.j.j.j(this);
        }
    }

    public vl() {
        this(new j());
    }

    public r j() {
        return null;
    }

    public vl(j jVar) {
        this.xt = jVar.cw;
        this.f27310r = jVar.up;
        this.f27309m = jVar.ae;
        this.cw = jVar.f27314r;
        this.up = jVar.f27313m;
        this.ae = jVar.tl;
        this.f27308j = jVar.f27312j;
        this.f27307g = jVar.f27311g;
        this.oq = jVar.oq;
    }

    public xt j(ws wsVar) {
        return null;
    }

    public j xt() {
        return new j(this);
    }

    public vl(v.j jVar) {
        this.xt = jVar.f26404x;
        this.f27310r = jVar.ch;
        this.f27309m = jVar.f26401s;
        this.cw = jVar.f26394h;
        this.up = jVar.la;
        this.ae = jVar.gq;
        this.oq = jVar.f26399p;
        this.qv = jVar;
    }
}
