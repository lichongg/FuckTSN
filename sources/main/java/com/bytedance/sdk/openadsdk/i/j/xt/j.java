package com.bytedance.sdk.openadsdk.i.j.xt;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private final ExitInstallListener f31503j;

    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.f31503j != null && a.j(sparseArray).k().intValue(-99999987) == 223101) {
            this.f31503j.onExitInstall();
        }
        return null;
    }

    public j(ExitInstallListener exitInstallListener) {
        this.f31503j = exitInstallListener;
    }
}
