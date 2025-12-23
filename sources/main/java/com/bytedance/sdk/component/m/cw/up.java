package com.bytedance.sdk.component.m.cw;

import android.content.Context;
import com.bytedance.sdk.component.m.i;
import com.bytedance.sdk.component.m.jy;
import com.bytedance.sdk.component.m.mi;
import com.bytedance.sdk.component.m.tj;
import com.bytedance.sdk.component.m.vl;
import com.bytedance.sdk.component.m.w;
import java.util.concurrent.ExecutorService;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up implements jy {
    private i ae;
    private com.bytedance.sdk.component.m.r cw;

    /* renamed from: g, reason: collision with root package name */
    private tj f26582g;

    /* renamed from: j, reason: collision with root package name */
    private vl f26583j;

    /* renamed from: m, reason: collision with root package name */
    private com.bytedance.sdk.component.m.cw f26584m;

    /* renamed from: r, reason: collision with root package name */
    private w f26585r;
    private com.bytedance.sdk.component.m.xt tl;
    private mi up;
    private ExecutorService xt;

    /* renamed from: com.bytedance.sdk.component.m.cw.up$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class j {
        private i ae;
        private com.bytedance.sdk.component.m.r cw;

        /* renamed from: g, reason: collision with root package name */
        private tj f26586g;

        /* renamed from: j, reason: collision with root package name */
        private vl f26587j;

        /* renamed from: m, reason: collision with root package name */
        private com.bytedance.sdk.component.m.cw f26588m;

        /* renamed from: r, reason: collision with root package name */
        private w f26589r;
        private com.bytedance.sdk.component.m.xt tl;
        private mi up;
        private ExecutorService xt;

        public j j(com.bytedance.sdk.component.m.xt xtVar) {
            this.tl = xtVar;
            return this;
        }

        public j j(ExecutorService executorService) {
            this.xt = executorService;
            return this;
        }

        public j j(com.bytedance.sdk.component.m.r rVar) {
            this.cw = rVar;
            return this;
        }

        public up j() {
            return new up(this, null);
        }
    }

    /* synthetic */ up(j jVar, AnonymousClass1 anonymousClass1) {
        this(jVar);
    }

    @Override // com.bytedance.sdk.component.m.jy
    public vl j() {
        return this.f26583j;
    }

    private up(j jVar) {
        this.f26583j = jVar.f26587j;
        this.xt = jVar.xt;
        this.cw = jVar.cw;
        this.f26585r = jVar.f26589r;
        this.up = jVar.up;
        this.f26584m = jVar.f26588m;
        this.tl = jVar.tl;
        this.ae = jVar.ae;
        this.f26582g = jVar.f26586g;
    }

    public static up j(Context context) {
        return new j().j();
    }

    @Override // com.bytedance.sdk.component.m.jy
    public com.bytedance.sdk.component.m.cw ae() {
        return this.f26584m;
    }

    @Override // com.bytedance.sdk.component.m.jy
    public tj cw() {
        return this.f26582g;
    }

    @Override // com.bytedance.sdk.component.m.jy
    public com.bytedance.sdk.component.m.xt g() {
        return this.tl;
    }

    @Override // com.bytedance.sdk.component.m.jy
    public mi m() {
        return this.up;
    }

    @Override // com.bytedance.sdk.component.m.jy
    public com.bytedance.sdk.component.m.r r() {
        return this.cw;
    }

    @Override // com.bytedance.sdk.component.m.jy
    public i tl() {
        return this.ae;
    }

    @Override // com.bytedance.sdk.component.m.jy
    public w up() {
        return this.f26585r;
    }

    @Override // com.bytedance.sdk.component.m.jy
    public ExecutorService xt() {
        return this.xt;
    }
}
