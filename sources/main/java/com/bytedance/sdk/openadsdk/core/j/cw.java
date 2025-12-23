package com.bytedance.sdk.openadsdk.core.j;

import android.os.Looper;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.tj;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw extends com.bytedance.sdk.openadsdk.tj.j.xt.j.j implements xt {

    /* renamed from: j, reason: collision with root package name */
    private long f29172j;

    @Override // com.bytedance.sdk.openadsdk.tj.j.xt.j.j
    public void xt(final com.bytedance.sdk.openadsdk.i.cw.xt.xt xtVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.xt(xtVar);
        } else {
            tj.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.j.cw.3
                @Override // java.lang.Runnable
                public void run() {
                    cw.super.xt(xtVar);
                }
            });
        }
    }

    public cw(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.f29172j = System.currentTimeMillis();
    }

    @Override // com.bytedance.sdk.openadsdk.tj.j.xt.j.j
    public void j(final com.bytedance.sdk.openadsdk.i.cw.xt.xt xtVar) {
        if (com.bytedance.sdk.openadsdk.core.component.splash.r.j()) {
            super.j(xtVar);
        } else {
            com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.j.cw.1
                @Override // java.lang.Runnable
                public void run() {
                    cw.super.j(xtVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.j.xt
    public long xt() {
        return this.f29172j;
    }

    @Override // com.bytedance.sdk.openadsdk.tj.j.xt.j.j
    public void j(final com.bytedance.sdk.openadsdk.i.cw.xt.j jVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.j(jVar);
        } else {
            tj.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.j.cw.2
                @Override // java.lang.Runnable
                public void run() {
                    cw.super.j(jVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.tj.j.xt.j.j
    public void j(final com.bytedance.sdk.openadsdk.i.cw.xt.xt xtVar, final com.bytedance.sdk.openadsdk.i.cw.xt.j jVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.j(xtVar, jVar);
        } else {
            tj.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.j.cw.4
                @Override // java.lang.Runnable
                public void run() {
                    cw.super.j(xtVar, jVar);
                }
            });
        }
    }
}
