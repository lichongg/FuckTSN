package com.bytedance.sdk.component.cw.xt.j.cw;

import com.bytedance.sdk.component.cw.xt.av;
import com.bytedance.sdk.component.cw.xt.kt;
import com.bytedance.sdk.component.cw.xt.p;
import com.bytedance.sdk.component.cw.xt.s;
import java.io.IOException;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class ae implements kt.j {
    private final com.bytedance.sdk.component.cw.xt.up ae;
    private final cw cw;

    /* renamed from: g, reason: collision with root package name */
    private final int f26168g;

    /* renamed from: j, reason: collision with root package name */
    private final List<kt> f26169j;

    /* renamed from: m, reason: collision with root package name */
    private final s f26170m;
    private final int oq;
    private final int qv;

    /* renamed from: r, reason: collision with root package name */
    private final com.bytedance.sdk.component.cw.xt.j.xt.cw f26171r;
    private final av tl;
    private final int up;
    private int vl;
    private final com.bytedance.sdk.component.cw.xt.j.xt.ae xt;

    @Override // com.bytedance.sdk.component.cw.xt.kt.j
    public s j() {
        return this.f26170m;
    }

    public cw ae() {
        return this.cw;
    }

    @Override // com.bytedance.sdk.component.cw.xt.kt.j
    public com.bytedance.sdk.component.cw.xt.up call() {
        return this.ae;
    }

    @Override // com.bytedance.sdk.component.cw.xt.kt.j
    public int cw() {
        return this.oq;
    }

    @Override // com.bytedance.sdk.component.cw.xt.kt.j
    public p j(s sVar) throws IOException {
        return j(sVar, this.xt, this.cw, this.f26171r);
    }

    public com.bytedance.sdk.component.cw.xt.j.xt.ae m() {
        return this.xt;
    }

    @Override // com.bytedance.sdk.component.cw.xt.kt.j
    public int r() {
        return this.qv;
    }

    public av tl() {
        return this.tl;
    }

    public com.bytedance.sdk.component.cw.xt.g up() {
        return this.f26171r;
    }

    @Override // com.bytedance.sdk.component.cw.xt.kt.j
    public int xt() {
        return this.f26168g;
    }

    public ae(List<kt> list, com.bytedance.sdk.component.cw.xt.j.xt.ae aeVar, cw cwVar, com.bytedance.sdk.component.cw.xt.j.xt.cw cwVar2, int i6, s sVar, com.bytedance.sdk.component.cw.xt.up upVar, av avVar, int i7, int i8, int i9) {
        this.f26169j = list;
        this.f26171r = cwVar2;
        this.xt = aeVar;
        this.cw = cwVar;
        this.up = i6;
        this.f26170m = sVar;
        this.ae = upVar;
        this.tl = avVar;
        this.f26168g = i7;
        this.oq = i8;
        this.qv = i9;
    }

    public p j(s sVar, com.bytedance.sdk.component.cw.xt.j.xt.ae aeVar, cw cwVar, com.bytedance.sdk.component.cw.xt.j.xt.cw cwVar2) throws IOException {
        if (this.up < this.f26169j.size()) {
            this.vl++;
            if (this.cw != null && !this.f26171r.j(sVar.j())) {
                throw new IllegalStateException("network interceptor " + this.f26169j.get(this.up - 1) + " must retain the same host and port");
            }
            if (this.cw != null && this.vl > 1) {
                throw new IllegalStateException("network interceptor " + this.f26169j.get(this.up - 1) + " must call proceed() exactly once");
            }
            ae aeVar2 = new ae(this.f26169j, aeVar, cwVar, cwVar2, this.up + 1, sVar, this.ae, this.tl, this.f26168g, this.oq, this.qv);
            kt ktVar = this.f26169j.get(this.up);
            p j6 = ktVar.j(aeVar2);
            if (cwVar != null && this.up + 1 < this.f26169j.size() && aeVar2.vl != 1) {
                throw new IllegalStateException("network interceptor " + ktVar + " must call proceed() exactly once");
            }
            if (j6 == null) {
                throw new NullPointerException("interceptor " + ktVar + " returned a null response");
            }
            if (j6.tl() != null) {
                return j6;
            }
            throw new IllegalStateException("interceptor " + ktVar + " returned a response with no body");
        }
        throw new AssertionError();
    }
}
