package com.bytedance.msdk.api.r;

import androidx.annotation.Nullable;

/* loaded from: D:\Downloads\app\classes3.dex */
public class tl {
    private boolean cw;

    /* renamed from: j, reason: collision with root package name */
    private boolean f24393j;

    /* renamed from: r, reason: collision with root package name */
    private boolean f24394r;
    private String xt;

    /* renamed from: com.bytedance.msdk.api.r.tl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class j {

        /* renamed from: j, reason: collision with root package name */
        private boolean f24395j = false;
        private String xt = null;
        private boolean cw = false;

        /* renamed from: r, reason: collision with root package name */
        private boolean f24396r = false;

        public j cw(boolean z5) {
            this.f24396r = z5;
            return this;
        }

        public j j(boolean z5) {
            this.f24395j = z5;
            return this;
        }

        public j xt(boolean z5) {
            this.cw = z5;
            return this;
        }

        public j j(String str) {
            this.xt = str;
            return this;
        }

        public tl j() {
            return new tl(this, null);
        }
    }

    /* synthetic */ tl(j jVar, AnonymousClass1 anonymousClass1) {
        this(jVar);
    }

    private tl(j jVar) {
        this.f24393j = jVar.f24395j;
        this.xt = jVar.xt;
        this.cw = jVar.cw;
        this.f24394r = jVar.f24396r;
    }

    public boolean cw() {
        return this.cw;
    }

    @Nullable
    public String j() {
        return this.xt;
    }

    public boolean r() {
        return this.f24394r;
    }

    public boolean xt() {
        return this.f24393j;
    }
}
