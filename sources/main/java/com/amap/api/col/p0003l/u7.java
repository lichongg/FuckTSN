package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.common.util.Logger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class u7 extends x7 {

    /* renamed from: c, reason: collision with root package name */
    private Context f7400c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f7401d;

    /* renamed from: e, reason: collision with root package name */
    private int f7402e;

    /* renamed from: f, reason: collision with root package name */
    private int f7403f;

    /* renamed from: b, reason: collision with root package name */
    private String f7399b = "iKey";

    /* renamed from: g, reason: collision with root package name */
    private int f7404g = 0;

    public u7(Context context, boolean z5, int i6, int i7, String str) {
        f(context, z5, i6, i7, str, 0);
    }

    private void f(Context context, boolean z5, int i6, int i7, String str, int i8) {
        this.f7400c = context;
        this.f7401d = z5;
        this.f7402e = i6;
        this.f7403f = i7;
        this.f7399b = str;
        this.f7404g = i8;
    }

    @Override // com.amap.api.col.p0003l.x7
    public final int a() {
        int i6;
        if ((i4.M(this.f7400c) == 1 || (i6 = this.f7402e) <= 0) && ((i6 = this.f7404g) <= 0 || i6 >= Integer.MAX_VALUE)) {
            i6 = Integer.MAX_VALUE;
        }
        x7 x7Var = this.f7672a;
        return x7Var != null ? Math.max(i6, x7Var.a()) : i6;
    }

    @Override // com.amap.api.col.p0003l.x7
    public final void b(int i6) {
        if (i4.M(this.f7400c) == 1) {
            return;
        }
        String c6 = q4.c(System.currentTimeMillis(), "yyyyMMdd");
        String a6 = s5.a(this.f7400c, this.f7399b);
        if (!TextUtils.isEmpty(a6)) {
            String[] split = a6.split("\\|");
            if (split == null || split.length < 2) {
                s5.g(this.f7400c, this.f7399b);
            } else if (c6.equals(split[0])) {
                i6 += Integer.parseInt(split[1]);
            }
        }
        s5.d(this.f7400c, this.f7399b, c6 + Logger.f33116c + i6);
    }

    @Override // com.amap.api.col.p0003l.x7
    protected final boolean d() {
        if (i4.M(this.f7400c) == 1) {
            return true;
        }
        if (!this.f7401d) {
            return false;
        }
        String a6 = s5.a(this.f7400c, this.f7399b);
        if (TextUtils.isEmpty(a6)) {
            return true;
        }
        String[] split = a6.split("\\|");
        if (split != null && split.length >= 2) {
            return !q4.c(System.currentTimeMillis(), "yyyyMMdd").equals(split[0]) || Integer.parseInt(split[1]) < this.f7403f;
        }
        s5.g(this.f7400c, this.f7399b);
        return true;
    }

    public u7(Context context, boolean z5, int i6, int i7, String str, int i8) {
        f(context, z5, i6, i7, str, i8);
    }
}
