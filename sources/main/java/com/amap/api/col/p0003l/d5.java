package com.amap.api.col.p0003l;

import android.text.TextUtils;
import java.util.Vector;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class d5 {

    /* renamed from: d, reason: collision with root package name */
    private static int f5909d = 100;

    /* renamed from: e, reason: collision with root package name */
    private static int f5910e = 10000;

    /* renamed from: a, reason: collision with root package name */
    private Vector<a5> f5911a;

    /* renamed from: b, reason: collision with root package name */
    private int f5912b;

    /* renamed from: c, reason: collision with root package name */
    private int f5913c;

    public d5() {
        this.f5913c = 0;
        this.f5912b = 10;
        this.f5911a = new Vector<>();
    }

    public final synchronized void b(a5 a5Var) {
        if (a5Var != null) {
            if (!TextUtils.isEmpty(a5Var.g())) {
                this.f5911a.add(a5Var);
                this.f5913c += a5Var.g().getBytes().length;
            }
        }
    }

    public final synchronized boolean c(String str) {
        if (str == null) {
            return false;
        }
        if (this.f5911a.size() >= this.f5912b) {
            return true;
        }
        return this.f5913c + str.getBytes().length > f5910e;
    }

    public final synchronized void d() {
        this.f5911a.clear();
        this.f5913c = 0;
    }

    public final Vector<a5> a() {
        return this.f5911a;
    }

    public d5(byte b6) {
        this.f5912b = f5909d;
        this.f5913c = 0;
        this.f5911a = new Vector<>();
    }
}
