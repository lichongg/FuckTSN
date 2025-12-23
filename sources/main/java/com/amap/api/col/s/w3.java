package com.amap.api.col.s;

import android.content.Context;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class w3 extends v3 {

    /* renamed from: b, reason: collision with root package name */
    private Context f8604b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f8605c = false;

    @Override // com.amap.api.col.s.v3
    protected final boolean c() {
        return c1.D(this.f8604b) == 1 || this.f8605c;
    }

    public w3(Context context) {
        this.f8604b = context;
    }
}
