package com.amap.api.col.s;

import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class r3 extends v3 {

    /* renamed from: b, reason: collision with root package name */
    private int f8418b;

    /* renamed from: c, reason: collision with root package name */
    private String f8419c;

    private static int f(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.list().length;
            }
            return 0;
        } catch (Throwable th) {
            g2.o(th, "fus", "gfn");
            return 0;
        }
    }

    @Override // com.amap.api.col.s.v3
    protected final boolean c() {
        return f(this.f8419c) >= this.f8418b;
    }

    public r3(String str, v3 v3Var) {
        super(v3Var);
        this.f8418b = 30;
        this.f8419c = str;
    }
}
