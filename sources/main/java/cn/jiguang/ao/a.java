package cn.jiguang.ao;

import com.snail.antifake.deviceid.e;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private String f1647a;

    /* renamed from: b, reason: collision with root package name */
    private String f1648b;

    /* renamed from: c, reason: collision with root package name */
    private int f1649c;

    /* renamed from: d, reason: collision with root package name */
    private long f1650d;

    public a a(int i6) {
        this.f1649c = i6;
        return this;
    }

    public a b(String str) {
        this.f1648b = str;
        return this;
    }

    public a a(long j6) {
        this.f1650d = j6;
        return this;
    }

    public String b() {
        return this.f1648b;
    }

    public int c() {
        return this.f1649c;
    }

    public long d() {
        return this.f1650d;
    }

    public String toString() {
        return "JCollectResultInfo{\ncollectType='" + this.f1647a + "'\ncollectChildType='" + this.f1648b + "'\n, collectResultCode=" + this.f1649c + "\n, collectMillTime=" + this.f1650d + e.f37542d + '}';
    }

    public a a(String str) {
        this.f1647a = str;
        return this;
    }

    public String a() {
        return this.f1647a;
    }
}
