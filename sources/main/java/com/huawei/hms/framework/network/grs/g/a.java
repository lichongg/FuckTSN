package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    protected d f33435a;

    /* renamed from: b, reason: collision with root package name */
    private final String f33436b;

    /* renamed from: c, reason: collision with root package name */
    private final c f33437c;

    /* renamed from: d, reason: collision with root package name */
    private final int f33438d;

    /* renamed from: e, reason: collision with root package name */
    private final Context f33439e;

    /* renamed from: f, reason: collision with root package name */
    private final String f33440f;

    /* renamed from: g, reason: collision with root package name */
    private final GrsBaseInfo f33441g;

    /* renamed from: h, reason: collision with root package name */
    private final o1.c f33442h;

    public Context a() {
        return this.f33439e;
    }

    public c b() {
        return this.f33437c;
    }

    public String c() {
        return this.f33436b;
    }

    public int d() {
        return this.f33438d;
    }

    public String e() {
        return this.f33440f;
    }

    public o1.c f() {
        return this.f33442h;
    }

    public Callable<d> g() {
        return new f(this.f33436b, this.f33438d, this.f33437c, this.f33439e, this.f33440f, this.f33441g, this.f33442h);
    }

    public a(String str, int i6, c cVar, Context context, String str2, GrsBaseInfo grsBaseInfo, o1.c cVar2) {
        this.f33436b = str;
        this.f33437c = cVar;
        this.f33438d = i6;
        this.f33439e = context;
        this.f33440f = str2;
        this.f33441g = grsBaseInfo;
        this.f33442h = cVar2;
    }
}
