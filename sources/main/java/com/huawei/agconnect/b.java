package com.huawei.agconnect;

import java.util.Arrays;

/* loaded from: D:\Downloads\app\classes5.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    public static final b f32910b = new b(0);

    /* renamed from: c, reason: collision with root package name */
    public static final b f32911c = new b(1);

    /* renamed from: d, reason: collision with root package name */
    public static final b f32912d = new b(2);

    /* renamed from: e, reason: collision with root package name */
    public static final b f32913e = new b(3);

    /* renamed from: f, reason: collision with root package name */
    public static final b f32914f = new b(4);

    /* renamed from: a, reason: collision with root package name */
    private final int f32915a;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && b.class == obj.getClass() && this.f32915a == ((b) obj).f32915a;
    }

    public String a() {
        int i6 = this.f32915a;
        return i6 != 1 ? i6 != 2 ? i6 != 3 ? i6 != 4 ? "UNKNOWN" : "SG" : "RU" : "DE" : com.huawei.hms.feature.dynamic.f.e.f33257e;
    }

    public int hashCode() {
        return b(Integer.valueOf(this.f32915a));
    }

    private b(int i6) {
        this.f32915a = i6;
    }

    private int b(Object... objArr) {
        return Arrays.hashCode(objArr);
    }
}
