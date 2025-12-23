package com.huawei.hms.scankit.p;

import java.nio.charset.StandardCharsets;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class y2 {

    /* renamed from: a, reason: collision with root package name */
    private final String f35032a;

    /* renamed from: b, reason: collision with root package name */
    private e7 f35033b;

    /* renamed from: c, reason: collision with root package name */
    private l2 f35034c;

    /* renamed from: d, reason: collision with root package name */
    private l2 f35035d;

    /* renamed from: e, reason: collision with root package name */
    private final StringBuilder f35036e;

    /* renamed from: f, reason: collision with root package name */
    int f35037f;

    /* renamed from: g, reason: collision with root package name */
    private int f35038g;

    /* renamed from: h, reason: collision with root package name */
    private d7 f35039h;

    /* renamed from: i, reason: collision with root package name */
    private int f35040i;

    public void a(e7 e7Var) {
        this.f35033b = e7Var;
    }

    public StringBuilder b() {
        return this.f35036e;
    }

    public char c() {
        return this.f35032a.charAt(this.f35037f);
    }

    public void j() {
        this.f35038g = -1;
    }

    public void k() {
        this.f35039h = null;
    }

    private int h() {
        return this.f35032a.length() - this.f35040i;
    }

    public void a(l2 l2Var, l2 l2Var2) {
        this.f35034c = l2Var;
        this.f35035d = l2Var2;
    }

    public void b(int i6) {
        this.f35038g = i6;
    }

    public void c(int i6) {
        d7 d7Var = this.f35039h;
        if (d7Var == null || i6 > d7Var.a()) {
            this.f35039h = d7.a(i6, this.f35033b, this.f35034c, this.f35035d, true);
        }
    }

    public String d() {
        return this.f35032a;
    }

    public int e() {
        return this.f35038g;
    }

    public d7 g() {
        return this.f35039h;
    }

    public boolean i() {
        return this.f35037f < h();
    }

    y2(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        StringBuilder sb = new StringBuilder(bytes.length);
        int length = bytes.length;
        for (int i6 = 0; i6 < length; i6++) {
            char c6 = (char) (bytes[i6] & 255);
            if (c6 == '?' && str.charAt(i6) != '?') {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
            sb.append(c6);
        }
        this.f35032a = sb.toString();
        this.f35033b = e7.FORCE_NONE;
        this.f35036e = new StringBuilder(str.length());
        this.f35038g = -1;
    }

    public int f() {
        return h() - this.f35037f;
    }

    public void l() {
        c(a());
    }

    public void a(int i6) {
        this.f35040i = i6;
    }

    public void a(String str) {
        this.f35036e.append(str);
    }

    public void a(char c6) {
        this.f35036e.append(c6);
    }

    public int a() {
        return this.f35036e.length();
    }
}
