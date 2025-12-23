package com.bytedance.sdk.openadsdk.core.tj;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.xt.r;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class x implements com.bytedance.sdk.component.adexpress.cw {
    public final int ae;
    public SparseArray<r.j> av;
    public final boolean az;
    public final float cw;

    /* renamed from: g, reason: collision with root package name */
    public final int f30478g;

    /* renamed from: i, reason: collision with root package name */
    public String f30479i;

    /* renamed from: j, reason: collision with root package name */
    public final float f30480j;
    public final String jy;

    /* renamed from: m, reason: collision with root package name */
    public final long f30481m;
    private JSONObject mi;
    public final int oq;
    public final String qv;

    /* renamed from: r, reason: collision with root package name */
    public final float f30482r;
    public final int tl;
    public final long up;
    public final String vl;

    /* renamed from: w, reason: collision with root package name */
    public int f30483w;
    public final String ws;
    public final float xt;

    /* renamed from: com.bytedance.sdk.openadsdk.core.tj.x$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class j {
        private float ae;
        private boolean av;
        private String az;
        private long cw;

        /* renamed from: g, reason: collision with root package name */
        private int f30484g;

        /* renamed from: i, reason: collision with root package name */
        private JSONObject f30485i;
        private String jy;

        /* renamed from: m, reason: collision with root package name */
        private float f30487m;
        private int oq;
        private int qv;

        /* renamed from: r, reason: collision with root package name */
        private float f30488r;
        private int tl;
        private float up;
        private String vl;

        /* renamed from: w, reason: collision with root package name */
        private String f30489w;
        private String ws;
        private long xt;

        /* renamed from: j, reason: collision with root package name */
        protected SparseArray<r.j> f30486j = new SparseArray<>();
        private int mi = -1;

        public j cw(float f6) {
            this.f30487m = f6;
            return this;
        }

        public j j(boolean z5) {
            this.av = z5;
            return this;
        }

        public j r(float f6) {
            this.ae = f6;
            return this;
        }

        public j up(String str) {
            this.f30489w = str;
            return this;
        }

        public j xt(long j6) {
            this.cw = j6;
            return this;
        }

        public j cw(int i6) {
            this.oq = i6;
            return this;
        }

        public j j(long j6) {
            this.xt = j6;
            return this;
        }

        public j r(int i6) {
            this.qv = i6;
            return this;
        }

        public j up(int i6) {
            this.mi = i6;
            return this;
        }

        public j xt(float f6) {
            this.up = f6;
            return this;
        }

        public j cw(String str) {
            this.ws = str;
            return this;
        }

        public j j(float f6) {
            this.f30488r = f6;
            return this;
        }

        public j r(String str) {
            this.az = str;
            return this;
        }

        public j xt(int i6) {
            this.f30484g = i6;
            return this;
        }

        public j j(int i6) {
            this.tl = i6;
            return this;
        }

        public j xt(String str) {
            this.jy = str;
            return this;
        }

        public j j(String str) {
            this.vl = str;
            return this;
        }

        public j j(SparseArray<r.j> sparseArray) {
            this.f30486j = sparseArray;
            return this;
        }

        public j j(JSONObject jSONObject) {
            this.f30485i = jSONObject;
            return this;
        }

        public x j() {
            return new x(this, null);
        }
    }

    /* synthetic */ x(j jVar, AnonymousClass1 anonymousClass1) {
        this(jVar);
    }

    private x(j jVar) {
        this.f30483w = -1;
        this.f30480j = jVar.ae;
        this.xt = jVar.f30487m;
        this.cw = jVar.up;
        this.f30482r = jVar.f30488r;
        this.up = jVar.cw;
        this.f30481m = jVar.xt;
        this.ae = jVar.tl;
        this.tl = jVar.f30484g;
        this.f30478g = jVar.oq;
        this.oq = jVar.qv;
        this.qv = jVar.vl;
        this.av = jVar.f30486j;
        this.az = jVar.av;
        this.mi = jVar.f30485i;
        this.vl = jVar.jy;
        this.jy = jVar.ws;
        this.ws = jVar.az;
        this.f30479i = jVar.f30489w;
        this.f30483w = jVar.mi;
    }

    public JSONObject j() {
        if (this.mi == null) {
            this.mi = new JSONObject();
        }
        return this.mi;
    }
}
