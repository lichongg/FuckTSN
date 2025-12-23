package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class w7 extends x7 {

    /* renamed from: b, reason: collision with root package name */
    protected int f7593b;

    /* renamed from: c, reason: collision with root package name */
    protected long f7594c;

    /* renamed from: d, reason: collision with root package name */
    private String f7595d;

    /* renamed from: e, reason: collision with root package name */
    private Context f7596e;

    @Override // com.amap.api.col.p0003l.x7
    protected final boolean d() {
        if (this.f7594c == 0) {
            String a6 = s5.a(this.f7596e, this.f7595d);
            this.f7594c = TextUtils.isEmpty(a6) ? 0L : Long.parseLong(a6);
        }
        return System.currentTimeMillis() - this.f7594c >= ((long) this.f7593b);
    }

    public w7(Context context, int i6, String str, x7 x7Var) {
        super(x7Var);
        this.f7593b = i6;
        this.f7595d = str;
        this.f7596e = context;
    }

    @Override // com.amap.api.col.p0003l.x7
    public final void c(boolean z5) {
        super.c(z5);
        if (z5) {
            String str = this.f7595d;
            long currentTimeMillis = System.currentTimeMillis();
            this.f7594c = currentTimeMillis;
            s5.d(this.f7596e, str, String.valueOf(currentTimeMillis));
        }
    }
}
