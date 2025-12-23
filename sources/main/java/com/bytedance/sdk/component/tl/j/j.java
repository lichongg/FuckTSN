package com.bytedance.sdk.component.tl.j;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements up {
    private com.bytedance.sdk.component.tl.xt.r.xt.j ae;
    private String cw;

    /* renamed from: g, reason: collision with root package name */
    private com.bytedance.sdk.component.tl.xt.r.xt.j f26748g;

    /* renamed from: j, reason: collision with root package name */
    private m f26749j;
    private int jy;

    /* renamed from: m, reason: collision with root package name */
    private com.bytedance.sdk.component.tl.xt.r.xt.j f26750m;
    private boolean oq;
    private r qv;

    /* renamed from: r, reason: collision with root package name */
    private Context f26751r;
    private com.bytedance.sdk.component.tl.xt.r.xt.j tl;
    private com.bytedance.sdk.component.tl.xt.r.xt.j up;
    private AtomicBoolean vl;
    private int ws;
    private qv xt;

    /* renamed from: com.bytedance.sdk.component.tl.j.j$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* renamed from: com.bytedance.sdk.component.tl.j.j$j, reason: collision with other inner class name */
    public static class C0417j {
        private r ae;
        private com.bytedance.sdk.component.tl.xt.r.xt.j cw;

        /* renamed from: j, reason: collision with root package name */
        private qv f26753j;
        private Context jy;

        /* renamed from: m, reason: collision with root package name */
        private boolean f26754m;

        /* renamed from: r, reason: collision with root package name */
        private com.bytedance.sdk.component.tl.xt.r.xt.j f26755r;
        private m tl;
        private com.bytedance.sdk.component.tl.xt.r.xt.j up;
        private String vl;
        private com.bytedance.sdk.component.tl.xt.r.xt.j xt;

        /* renamed from: g, reason: collision with root package name */
        private final AtomicBoolean f26752g = new AtomicBoolean(false);
        private int oq = 5000;
        private int qv = 10;

        public C0417j j(Context context) {
            this.jy = context;
            return this;
        }

        public C0417j xt(boolean z5) {
            this.f26754m = z5;
            return this;
        }

        public C0417j cw(com.bytedance.sdk.component.tl.xt.r.xt.j jVar) {
            this.f26755r = jVar;
            return this;
        }

        public C0417j j(String str) {
            this.vl = str;
            return this;
        }

        public C0417j xt(com.bytedance.sdk.component.tl.xt.r.xt.j jVar) {
            this.cw = jVar;
            return this;
        }

        public C0417j j(boolean z5) {
            this.f26752g.set(z5);
            return this;
        }

        public C0417j j(m mVar) {
            this.tl = mVar;
            return this;
        }

        public C0417j j(r rVar) {
            this.ae = rVar;
            return this;
        }

        public C0417j j(com.bytedance.sdk.component.tl.xt.r.xt.j jVar) {
            this.xt = jVar;
            return this;
        }

        public C0417j j(qv qvVar) {
            this.f26753j = qvVar;
            return this;
        }

        public j j() {
            j jVar = new j(null);
            jVar.xt = this.f26753j;
            jVar.up = this.xt;
            jVar.f26750m = this.cw;
            jVar.ae = this.f26755r;
            jVar.tl = this.up;
            jVar.oq = this.f26754m;
            jVar.qv = this.ae;
            jVar.f26749j = this.tl;
            jVar.vl = this.f26752g;
            jVar.cw = this.vl;
            jVar.f26751r = this.jy;
            jVar.ws = this.qv;
            jVar.jy = this.oq;
            return jVar;
        }
    }

    /* synthetic */ j(AnonymousClass1 anonymousClass1) {
        this();
    }

    private j() {
        this.vl = new AtomicBoolean(false);
        this.jy = 200;
        this.ws = 10;
    }

    @Override // com.bytedance.sdk.component.tl.j.up
    public com.bytedance.sdk.component.tl.xt.r.xt.j ae() {
        return this.up;
    }

    @Override // com.bytedance.sdk.component.tl.j.up
    public boolean cw() {
        return this.vl.get();
    }

    @Override // com.bytedance.sdk.component.tl.j.up
    public com.bytedance.sdk.component.tl.xt.r.xt.j g() {
        return this.ae;
    }

    @Override // com.bytedance.sdk.component.tl.j.up
    public Context getContext() {
        return this.f26751r;
    }

    @Override // com.bytedance.sdk.component.tl.j.up
    public com.bytedance.sdk.component.tl.xt.r.xt.j m() {
        return this.f26748g;
    }

    @Override // com.bytedance.sdk.component.tl.j.up
    public qv oq() {
        return this.xt;
    }

    @Override // com.bytedance.sdk.component.tl.j.up
    public boolean qv() {
        return this.oq;
    }

    @Override // com.bytedance.sdk.component.tl.j.up
    public r r() {
        return this.qv;
    }

    @Override // com.bytedance.sdk.component.tl.j.up
    public com.bytedance.sdk.component.tl.xt.r.xt.j tl() {
        return this.f26750m;
    }

    @Override // com.bytedance.sdk.component.tl.j.up
    public String up() {
        return this.cw;
    }

    @Override // com.bytedance.sdk.component.tl.j.up
    public m xt() {
        return this.f26749j;
    }

    @Override // com.bytedance.sdk.component.tl.j.up
    public com.bytedance.sdk.component.tl.xt.r.xt.j j() {
        return this.tl;
    }

    @Override // com.bytedance.sdk.component.tl.j.up
    public void j(m mVar) {
        this.f26749j = mVar;
    }

    @Override // com.bytedance.sdk.component.tl.j.up
    public void j(boolean z5) {
        this.vl.set(z5);
    }
}
