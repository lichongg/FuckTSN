package com.bytedance.sdk.component.cw.j;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes4.dex */
public class g extends kt {

    /* renamed from: j, reason: collision with root package name */
    private kt f26089j;

    public final kt j() {
        return this.f26089j;
    }

    @Override // com.bytedance.sdk.component.cw.j.kt
    public void ae() throws IOException {
        this.f26089j.ae();
    }

    @Override // com.bytedance.sdk.component.cw.j.kt
    public boolean cw() {
        return this.f26089j.cw();
    }

    public final g j(kt ktVar) {
        if (ktVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f26089j = ktVar;
        return this;
    }

    @Override // com.bytedance.sdk.component.cw.j.kt
    public kt m() {
        return this.f26089j.m();
    }

    @Override // com.bytedance.sdk.component.cw.j.kt
    public long n_() {
        return this.f26089j.n_();
    }

    @Override // com.bytedance.sdk.component.cw.j.kt
    public long o_() {
        return this.f26089j.o_();
    }

    @Override // com.bytedance.sdk.component.cw.j.kt
    public kt up() {
        return this.f26089j.up();
    }

    public g(kt ktVar) {
        if (ktVar != null) {
            this.f26089j = ktVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // com.bytedance.sdk.component.cw.j.kt
    public kt j(long j6, TimeUnit timeUnit) {
        return this.f26089j.j(j6, timeUnit);
    }

    @Override // com.bytedance.sdk.component.cw.j.kt
    public kt j(long j6) {
        return this.f26089j.j(j6);
    }
}
