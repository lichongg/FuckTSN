package com.bytedance.sdk.openadsdk.core.j;

import android.os.Looper;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.tj;
import com.bytedance.sdk.openadsdk.i.cw.xt.qv;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m extends com.bytedance.sdk.openadsdk.tj.j.xt.j.r implements xt {

    /* renamed from: j, reason: collision with root package name */
    private long f29184j;

    @Override // com.bytedance.sdk.openadsdk.tj.j.xt.j.r
    public void xt(final qv qvVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.xt(qvVar);
        } else {
            tj.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.j.m.4
                @Override // java.lang.Runnable
                public void run() {
                    m.super.xt(qvVar);
                }
            });
        }
    }

    public m(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.f29184j = System.currentTimeMillis();
    }

    @Override // com.bytedance.sdk.openadsdk.tj.j.xt.j.r
    public void j(final int i6, final String str) {
        if (str == null) {
            str = "未知异常";
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.j(i6, str);
        } else {
            tj.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.j.m.1
                @Override // java.lang.Runnable
                public void run() {
                    m.super.j(i6, str);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.j.xt
    public long xt() {
        return this.f29184j;
    }

    @Override // com.bytedance.sdk.openadsdk.tj.j.xt.j.r
    public void j(final qv qvVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.j(qvVar);
        } else {
            tj.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.j.m.2
                @Override // java.lang.Runnable
                public void run() {
                    m.super.j(qvVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.tj.j.xt.j.r
    public void j() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.j();
        } else {
            tj.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.j.m.3
                @Override // java.lang.Runnable
                public void run() {
                    m.super.j();
                }
            });
        }
    }
}
