package com.orhanobut.logger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final int f36483a = 2;

    /* renamed from: b, reason: collision with root package name */
    public static final int f36484b = 3;

    /* renamed from: c, reason: collision with root package name */
    public static final int f36485c = 4;

    /* renamed from: d, reason: collision with root package name */
    public static final int f36486d = 5;

    /* renamed from: e, reason: collision with root package name */
    public static final int f36487e = 6;

    /* renamed from: f, reason: collision with root package name */
    public static final int f36488f = 7;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    private static m f36489g = new k();

    public static void a(@NonNull g gVar) {
        f36489g.i((g) n.a(gVar));
    }

    public static void b() {
        f36489g.k();
    }

    public static void c(@Nullable Object obj) {
        f36489g.d(obj);
    }

    public static void d(@NonNull String str, @Nullable Object... objArr) {
        f36489g.e(str, objArr);
    }

    public static void e(@NonNull String str, @Nullable Object... objArr) {
        f36489g.j(null, str, objArr);
    }

    public static void f(@Nullable Throwable th, @NonNull String str, @Nullable Object... objArr) {
        f36489g.j(th, str, objArr);
    }

    public static void g(@NonNull String str, @Nullable Object... objArr) {
        f36489g.d(str, objArr);
    }

    public static void h(@Nullable String str) {
        f36489g.b(str);
    }

    public static void i(int i6, @Nullable String str, @Nullable String str2, @Nullable Throwable th) {
        f36489g.c(i6, str, str2, th);
    }

    public static m k(@Nullable String str) {
        return f36489g.f(str);
    }

    public static void l(@NonNull String str, @Nullable Object... objArr) {
        f36489g.l(str, objArr);
    }

    public static void m(@NonNull String str, @Nullable Object... objArr) {
        f36489g.m(str, objArr);
    }

    public static void n(@NonNull String str, @Nullable Object... objArr) {
        f36489g.a(str, objArr);
    }

    public static void o(@Nullable String str) {
        f36489g.h(str);
    }

    private j() {
    }

    public static void j(@NonNull m mVar) {
        f36489g = (m) n.a(mVar);
    }
}
