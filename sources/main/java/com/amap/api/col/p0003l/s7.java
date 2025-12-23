package com.amap.api.col.p0003l;

import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class s7 extends x7 {

    /* renamed from: b, reason: collision with root package name */
    private int f7248b;

    /* renamed from: c, reason: collision with root package name */
    private String f7249c;

    private static int f(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.list().length;
            }
            return 0;
        } catch (Throwable th) {
            v5.p(th, "fus", "gfn");
            return 0;
        }
    }

    @Override // com.amap.api.col.p0003l.x7
    protected final boolean d() {
        return f(this.f7249c) >= this.f7248b;
    }

    public s7(String str, x7 x7Var) {
        super(x7Var);
        this.f7248b = 30;
        this.f7249c = str;
    }
}
