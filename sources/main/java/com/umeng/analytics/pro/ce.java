package com.umeng.analytics.pro;

import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ce implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f41083a;

    /* renamed from: b, reason: collision with root package name */
    public final byte f41084b;

    /* renamed from: c, reason: collision with root package name */
    private final String f41085c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f41086d;

    public ce(byte b6, boolean z5) {
        this.f41084b = b6;
        this.f41083a = false;
        this.f41085c = null;
        this.f41086d = z5;
    }

    public boolean a() {
        return this.f41083a;
    }

    public String b() {
        return this.f41085c;
    }

    public boolean c() {
        return this.f41084b == 12;
    }

    public boolean d() {
        byte b6 = this.f41084b;
        return b6 == 15 || b6 == 13 || b6 == 14;
    }

    public boolean e() {
        return this.f41086d;
    }

    public ce(byte b6) {
        this(b6, false);
    }

    public ce(byte b6, String str) {
        this.f41084b = b6;
        this.f41083a = true;
        this.f41085c = str;
        this.f41086d = false;
    }
}
