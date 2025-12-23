package cn.jpush.android.w;

import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private String f3957a;

    /* renamed from: b, reason: collision with root package name */
    private String f3958b;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, Object> f3959c;

    /* renamed from: d, reason: collision with root package name */
    private int f3960d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f3961e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f3962f;

    /* renamed from: g, reason: collision with root package name */
    private int f3963g;

    /* renamed from: h, reason: collision with root package name */
    private int f3964h;

    public d() {
        this.f3963g = -1;
        this.f3964h = -1;
        this.f3959c = new HashMap();
    }

    public String a() {
        return this.f3958b;
    }

    public int b() {
        return this.f3963g;
    }

    public d(String str) {
        this.f3963g = -1;
        this.f3964h = -1;
        this.f3957a = str;
        this.f3960d = 0;
        this.f3961e = false;
        this.f3962f = false;
        this.f3959c = new HashMap();
    }

    public void a(int i6) {
        this.f3963g = i6;
    }

    public void b(int i6) {
        this.f3964h = i6;
    }

    public String toString() {
        return "HttpResponse{responseBody='" + this.f3958b + "', responseCode=" + this.f3963g + '}';
    }

    public void a(String str) {
        this.f3958b = str;
    }

    public void a(String str, String str2) {
        Map<String, Object> map = this.f3959c;
        if (map != null) {
            map.put(str, str2);
        }
    }
}
