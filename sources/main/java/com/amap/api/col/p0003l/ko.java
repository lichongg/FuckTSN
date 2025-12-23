package com.amap.api.col.p0003l;

import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class ko implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public String f6699a;

    /* renamed from: b, reason: collision with root package name */
    public String f6700b;

    /* renamed from: c, reason: collision with root package name */
    public int f6701c;

    /* renamed from: d, reason: collision with root package name */
    public int f6702d;

    /* renamed from: e, reason: collision with root package name */
    public long f6703e;

    /* renamed from: f, reason: collision with root package name */
    public long f6704f;

    /* renamed from: g, reason: collision with root package name */
    public int f6705g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f6706h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f6707i;

    public ko() {
        this.f6699a = "";
        this.f6700b = "";
        this.f6701c = 99;
        this.f6702d = Integer.MAX_VALUE;
        this.f6703e = 0L;
        this.f6704f = 0L;
        this.f6705g = 0;
        this.f6707i = true;
    }

    private static int a(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e6) {
            o9.a(e6);
            return 0;
        }
    }

    @Override // 
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public abstract ko clone();

    public final int b() {
        return a(this.f6699a);
    }

    public final int c() {
        return a(this.f6700b);
    }

    public String toString() {
        return "AmapCell{mcc=" + this.f6699a + ", mnc=" + this.f6700b + ", signalStrength=" + this.f6701c + ", asulevel=" + this.f6702d + ", lastUpdateSystemMills=" + this.f6703e + ", lastUpdateUtcMills=" + this.f6704f + ", age=" + this.f6705g + ", main=" + this.f6706h + ", newapi=" + this.f6707i + '}';
    }

    public final void a(ko koVar) {
        this.f6699a = koVar.f6699a;
        this.f6700b = koVar.f6700b;
        this.f6701c = koVar.f6701c;
        this.f6702d = koVar.f6702d;
        this.f6703e = koVar.f6703e;
        this.f6704f = koVar.f6704f;
        this.f6705g = koVar.f6705g;
        this.f6706h = koVar.f6706h;
        this.f6707i = koVar.f6707i;
    }

    public ko(boolean z5, boolean z6) {
        this.f6699a = "";
        this.f6700b = "";
        this.f6701c = 99;
        this.f6702d = Integer.MAX_VALUE;
        this.f6703e = 0L;
        this.f6704f = 0L;
        this.f6705g = 0;
        this.f6706h = z5;
        this.f6707i = z6;
    }
}
