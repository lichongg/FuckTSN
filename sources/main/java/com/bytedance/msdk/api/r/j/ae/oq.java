package com.bytedance.msdk.api.r.j.ae;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class oq {
    public final int ae;
    public final int cw;

    /* renamed from: g, reason: collision with root package name */
    public final int f24355g;

    /* renamed from: j, reason: collision with root package name */
    public final int f24356j;
    public final int jy;

    /* renamed from: m, reason: collision with root package name */
    public final int f24357m;
    public final int oq;
    public final int qv;

    /* renamed from: r, reason: collision with root package name */
    public final int f24358r;
    public final int tl;
    public final int up;
    public final int vl;

    @NonNull
    public final Map<String, Integer> ws;
    public final int xt;

    public static class j {
        protected int ae;
        protected int cw;

        /* renamed from: g, reason: collision with root package name */
        protected int f24359g;

        /* renamed from: j, reason: collision with root package name */
        protected int f24360j;
        protected int jy;

        /* renamed from: m, reason: collision with root package name */
        protected int f24361m;
        protected int oq;
        protected int qv;

        /* renamed from: r, reason: collision with root package name */
        protected int f24362r;
        protected int tl;
        protected int up;
        protected int vl;

        @NonNull
        protected Map<String, Integer> ws;
        protected int xt;

        @NonNull
        public j j(int i6) {
            this.xt = i6;
            return this;
        }

        @NonNull
        public j ae(int i6) {
            this.tl = i6;
            return this;
        }

        @NonNull
        public j cw(int i6) {
            this.oq = i6;
            return this;
        }

        @NonNull
        public j g(int i6) {
            this.cw = i6;
            return this;
        }

        @NonNull
        public j j(Map<String, Integer> map) {
            this.ws = new HashMap(map);
            return this;
        }

        @NonNull
        public j m(int i6) {
            this.f24361m = i6;
            return this;
        }

        @NonNull
        public j oq(int i6) {
            this.f24362r = i6;
            return this;
        }

        @NonNull
        public j qv(int i6) {
            this.up = i6;
            return this;
        }

        @NonNull
        public j r(int i6) {
            this.qv = i6;
            return this;
        }

        @NonNull
        public j tl(int i6) {
            this.ae = i6;
            return this;
        }

        @NonNull
        public j up(int i6) {
            this.vl = i6;
            return this;
        }

        @NonNull
        public j xt(int i6) {
            this.f24359g = i6;
            return this;
        }

        public j(int i6) {
            this.ws = Collections.EMPTY_MAP;
            this.f24360j = i6;
            this.ws = new HashMap();
        }

        @NonNull
        public oq j() {
            return new oq(this);
        }
    }

    public static oq j(com.bytedance.sdk.openadsdk.mediation.ad.j.xt.j.r rVar) {
        if (rVar == null) {
            return null;
        }
        j jVar = new j(rVar.j());
        jVar.j(rVar.xt()).oq(rVar.r()).g(rVar.cw()).cw(rVar.g()).r(rVar.oq()).up(rVar.qv()).m(rVar.m()).tl(rVar.ae()).qv(rVar.up()).xt(rVar.vl()).ae(rVar.tl()).j(rVar.jy());
        return jVar.j();
    }

    protected oq(@NonNull j jVar) {
        this.f24356j = jVar.f24360j;
        this.xt = jVar.xt;
        this.cw = jVar.cw;
        this.f24358r = jVar.f24362r;
        this.up = jVar.up;
        this.f24357m = jVar.f24361m;
        this.ae = jVar.ae;
        this.tl = jVar.tl;
        this.ws = jVar.ws;
        this.f24355g = jVar.oq;
        this.oq = jVar.qv;
        this.qv = jVar.vl;
        this.vl = jVar.f24359g;
        this.jy = jVar.jy;
    }

    public static com.bytedance.msdk.j.r.xt.j j(oq oqVar) {
        if (oqVar != null) {
            return new com.bytedance.msdk.j.r.xt.j(oqVar);
        }
        return null;
    }
}
