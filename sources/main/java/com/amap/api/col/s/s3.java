package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.common.util.Logger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class s3 extends v3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f8446c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f8447d;

    /* renamed from: e, reason: collision with root package name */
    private int f8448e;

    /* renamed from: f, reason: collision with root package name */
    private int f8449f;

    /* renamed from: b, reason: collision with root package name */
    private String f8445b = "iKey";

    /* renamed from: g, reason: collision with root package name */
    private int f8450g = 0;

    private void f(Context context, boolean z5, int i6, int i7, String str, int i8) {
        this.f8446c = context;
        this.f8447d = z5;
        this.f8448e = i6;
        this.f8449f = i7;
        this.f8445b = str;
        this.f8450g = i8;
    }

    @Override // com.amap.api.col.s.v3
    public final void a(int i6) {
        if (c1.D(this.f8446c) == 1) {
            return;
        }
        String c6 = j1.c(System.currentTimeMillis(), "yyyyMMdd");
        String a6 = e2.a(this.f8446c, this.f8445b);
        if (!TextUtils.isEmpty(a6)) {
            String[] split = a6.split("\\|");
            if (split == null || split.length < 2) {
                e2.g(this.f8446c, this.f8445b);
            } else if (c6.equals(split[0])) {
                i6 += Integer.parseInt(split[1]);
            }
        }
        e2.d(this.f8446c, this.f8445b, c6 + Logger.f33116c + i6);
    }

    @Override // com.amap.api.col.s.v3
    protected final boolean c() {
        if (c1.D(this.f8446c) == 1) {
            return true;
        }
        if (!this.f8447d) {
            return false;
        }
        String a6 = e2.a(this.f8446c, this.f8445b);
        if (TextUtils.isEmpty(a6)) {
            return true;
        }
        String[] split = a6.split("\\|");
        if (split != null && split.length >= 2) {
            return !j1.c(System.currentTimeMillis(), "yyyyMMdd").equals(split[0]) || Integer.parseInt(split[1]) < this.f8449f;
        }
        e2.g(this.f8446c, this.f8445b);
        return true;
    }

    @Override // com.amap.api.col.s.v3
    public final int d() {
        int i6;
        if ((c1.D(this.f8446c) == 1 || (i6 = this.f8448e) <= 0) && ((i6 = this.f8450g) <= 0 || i6 >= Integer.MAX_VALUE)) {
            i6 = Integer.MAX_VALUE;
        }
        v3 v3Var = this.f8578a;
        return v3Var != null ? Math.max(i6, v3Var.d()) : i6;
    }

    public s3(Context context, boolean z5, int i6, int i7, String str, int i8) {
        f(context, z5, i6, i7, str, i8);
    }
}
