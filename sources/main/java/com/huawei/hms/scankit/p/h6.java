package com.huawei.hms.scankit.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class h6 {

    /* renamed from: a, reason: collision with root package name */
    private u4 f34344a;

    /* renamed from: b, reason: collision with root package name */
    private b3 f34345b;

    /* renamed from: c, reason: collision with root package name */
    private b8 f34346c;

    /* renamed from: d, reason: collision with root package name */
    private int f34347d = -1;

    /* renamed from: e, reason: collision with root package name */
    private c0 f34348e;

    public static boolean a(int i6) {
        return i6 >= 0 && i6 < 8;
    }

    public c0 a() {
        return this.f34348e;
    }

    public void b(int i6) {
        this.f34347d = i6;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("<<\n");
        sb.append(" mode: ");
        sb.append(this.f34344a);
        sb.append("\n ecLevel: ");
        sb.append(this.f34345b);
        sb.append("\n version: ");
        sb.append(this.f34346c);
        sb.append("\n maskPattern: ");
        sb.append(this.f34347d);
        sb.append(">>\n");
        return sb.toString();
    }

    public void a(u4 u4Var) {
        this.f34344a = u4Var;
    }

    public void a(b3 b3Var) {
        this.f34345b = b3Var;
    }

    public void a(b8 b8Var) {
        this.f34346c = b8Var;
    }

    public void a(c0 c0Var) {
        this.f34348e = c0Var;
    }
}
