package com.huawei.hms.scankit.p;

import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class w1 {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f34921a;

    /* renamed from: b, reason: collision with root package name */
    private int f34922b;

    /* renamed from: c, reason: collision with root package name */
    private final String f34923c;

    /* renamed from: d, reason: collision with root package name */
    private final List<byte[]> f34924d;

    /* renamed from: e, reason: collision with root package name */
    private final String f34925e;

    /* renamed from: f, reason: collision with root package name */
    private Integer f34926f;

    /* renamed from: g, reason: collision with root package name */
    private Integer f34927g;

    /* renamed from: h, reason: collision with root package name */
    private Object f34928h;

    /* renamed from: i, reason: collision with root package name */
    private final int f34929i;

    /* renamed from: j, reason: collision with root package name */
    private final int f34930j;

    public w1(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    public int a() {
        return this.f34922b;
    }

    public void b(Integer num) {
        this.f34926f = num;
    }

    public w1(byte[] bArr, String str, List<byte[]> list, String str2, int i6, int i7) {
        this.f34921a = bArr;
        this.f34922b = bArr == null ? 0 : bArr.length * 8;
        this.f34923c = str;
        this.f34924d = list;
        this.f34925e = str2;
        this.f34929i = i7;
        this.f34930j = i6;
    }

    public void a(int i6) {
        this.f34922b = i6;
    }

    public Object b() {
        return this.f34928h;
    }

    public byte[] c() {
        return this.f34921a;
    }

    public String d() {
        return this.f34923c;
    }

    public void a(Integer num) {
        this.f34927g = num;
    }

    public void a(Object obj) {
        this.f34928h = obj;
    }
}
