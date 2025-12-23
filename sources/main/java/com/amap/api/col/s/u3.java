package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class u3 extends v3 {

    /* renamed from: b, reason: collision with root package name */
    protected int f8513b;

    /* renamed from: c, reason: collision with root package name */
    protected long f8514c;

    /* renamed from: d, reason: collision with root package name */
    private String f8515d;

    /* renamed from: e, reason: collision with root package name */
    private Context f8516e;

    @Override // com.amap.api.col.s.v3
    protected final boolean c() {
        if (this.f8514c == 0) {
            String a6 = e2.a(this.f8516e, this.f8515d);
            this.f8514c = TextUtils.isEmpty(a6) ? 0L : Long.parseLong(a6);
        }
        return System.currentTimeMillis() - this.f8514c >= ((long) this.f8513b);
    }

    public u3(Context context, int i6, String str, v3 v3Var) {
        super(v3Var);
        this.f8513b = i6;
        this.f8515d = str;
        this.f8516e = context;
    }

    @Override // com.amap.api.col.s.v3
    public final void b(boolean z5) {
        super.b(z5);
        if (z5) {
            String str = this.f8515d;
            long currentTimeMillis = System.currentTimeMillis();
            this.f8514c = currentTimeMillis;
            e2.d(this.f8516e, str, String.valueOf(currentTimeMillis));
        }
    }
}
