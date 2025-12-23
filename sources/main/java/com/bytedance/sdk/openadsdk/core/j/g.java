package com.bytedance.sdk.openadsdk.core.j;

import android.os.Looper;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.tj;
import com.bytedance.sdk.openadsdk.i.cw.xt.az;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class g extends com.bytedance.sdk.openadsdk.tj.j.xt.j.ae implements xt {

    /* renamed from: j, reason: collision with root package name */
    private long f29177j;

    @Override // com.bytedance.sdk.openadsdk.tj.j.xt.j.ae
    public void xt(final az azVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.xt(azVar);
        } else {
            tj.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.j.g.4
                @Override // java.lang.Runnable
                public void run() {
                    g.super.xt(azVar);
                }
            });
        }
    }

    public g(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.f29177j = System.currentTimeMillis();
    }

    @Override // com.bytedance.sdk.openadsdk.tj.j.xt.j.ae
    public void j(final int i6, final String str) {
        if (str == null) {
            str = "未知异常";
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.j(i6, str);
        } else {
            tj.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.j.g.1
                @Override // java.lang.Runnable
                public void run() {
                    g.super.j(i6, str);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.j.xt
    public long xt() {
        return this.f29177j;
    }

    @Override // com.bytedance.sdk.openadsdk.tj.j.xt.j.ae
    public void j(final az azVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.j(azVar);
        } else {
            tj.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.j.g.2
                @Override // java.lang.Runnable
                public void run() {
                    g.super.j(azVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.tj.j.xt.j.ae
    public void j() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.j();
        } else {
            tj.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.j.g.3
                @Override // java.lang.Runnable
                public void run() {
                    g.super.j();
                }
            });
        }
    }
}
