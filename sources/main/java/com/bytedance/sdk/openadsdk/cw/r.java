package com.bytedance.sdk.openadsdk.cw;

import a1.b;
import android.app.Application;
import android.util.SparseArray;
import com.bykv.j.j.j.j.f;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.cw.j;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class r implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private static volatile r f31368j;
    private final j cw = new j();
    private cw xt;

    public static r j() {
        if (f31368j == null) {
            synchronized (r.class) {
                try {
                    if (f31368j == null) {
                        f31368j = new r();
                    }
                } finally {
                }
            }
        }
        return f31368j;
    }

    public Application.ActivityLifecycleCallbacks xt() {
        return this.cw;
    }

    private r() {
    }

    public void j(cw cwVar) {
        this.xt = cwVar;
    }

    private void j(final xt xtVar) {
        this.cw.j(new j.InterfaceC0500j() { // from class: com.bytedance.sdk.openadsdk.cw.r.1
            @Override // com.bytedance.sdk.openadsdk.cw.j.InterfaceC0500j
            public void j() {
                xtVar.j();
            }

            @Override // com.bytedance.sdk.openadsdk.cw.j.InterfaceC0500j
            public void xt() {
                xtVar.xt();
            }
        });
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        Function<SparseArray<Object>, Object> j6;
        Object apply;
        int intValue = ((Integer) sparseArray.get(-99999987)).intValue();
        if (intValue == -99999986) {
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(10000, 5);
            return sparseArray2;
        }
        if (intValue != 14) {
            switch (intValue) {
                case 2:
                    return this.cw.j();
                case 3:
                    return TTAppContextHolder.getContext();
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    cw cwVar = this.xt;
                    if (cwVar != null && (j6 = cwVar.j(4)) != null) {
                        apply = j6.apply(sparseArray);
                        return apply;
                    }
                    return null;
                case 9:
                    Object obj = sparseArray.get(0);
                    if (f.a(obj)) {
                        j(new xt(b.a(obj)));
                    }
                    return null;
                case 10:
                    cw cwVar2 = this.xt;
                    if (cwVar2 == null) {
                        return null;
                    }
                    return cwVar2.j(((Integer) sparseArray.get(0)).intValue());
                default:
                    return null;
            }
        }
        return this.cw.xt();
    }
}
