package com.bytedance.sdk.component.j;

import android.text.TextUtils;

/* loaded from: D:\Downloads\app\classes4.dex */
public class av {
    public final String ae;
    public final String cw;

    /* renamed from: j, reason: collision with root package name */
    public final int f26471j;

    /* renamed from: m, reason: collision with root package name */
    public final String f26472m;

    /* renamed from: r, reason: collision with root package name */
    public final String f26473r;
    public final String tl;
    public final String up;
    public final String xt;

    /* renamed from: com.bytedance.sdk.component.j.av$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class j {
        private String ae;
        private String cw;

        /* renamed from: j, reason: collision with root package name */
        private String f26474j;

        /* renamed from: m, reason: collision with root package name */
        private String f26475m;

        /* renamed from: r, reason: collision with root package name */
        private String f26476r;
        private String up;
        private String xt;

        /* synthetic */ j(AnonymousClass1 anonymousClass1) {
            this();
        }

        private j() {
        }

        public j ae(String str) {
            this.ae = str;
            return this;
        }

        public j cw(String str) {
            this.cw = str;
            return this;
        }

        public j j(String str) {
            this.f26474j = str;
            return this;
        }

        public j m(String str) {
            this.f26475m = str;
            return this;
        }

        public j r(String str) {
            this.f26476r = str;
            return this;
        }

        public j up(String str) {
            this.up = str;
            return this;
        }

        public j xt(String str) {
            this.xt = str;
            return this;
        }

        public av j() {
            return new av(this, (AnonymousClass1) null);
        }
    }

    /* synthetic */ av(j jVar, AnonymousClass1 anonymousClass1) {
        this(jVar);
    }

    public static j j() {
        return new j(null);
    }

    private av(String str, int i6) {
        this.xt = null;
        this.cw = null;
        this.f26473r = null;
        this.up = null;
        this.f26472m = str;
        this.ae = null;
        this.f26471j = i6;
        this.tl = null;
    }

    public static av j(String str, int i6) {
        return new av(str, i6);
    }

    public String toString() {
        return "methodName: " + this.f26473r + ", params: " + this.up + ", callbackId: " + this.f26472m + ", type: " + this.cw + ", version: " + this.xt + ", ";
    }

    public static boolean j(av avVar) {
        return avVar == null || avVar.f26471j != 1 || TextUtils.isEmpty(avVar.f26473r) || TextUtils.isEmpty(avVar.up);
    }

    private av(j jVar) {
        this.xt = jVar.f26474j;
        this.cw = jVar.xt;
        this.f26473r = jVar.cw;
        this.up = jVar.f26476r;
        this.f26472m = jVar.up;
        this.ae = jVar.f26475m;
        this.f26471j = 1;
        this.tl = jVar.ae;
    }
}
