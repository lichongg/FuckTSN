package com.bxkj.base.v2.netty4android.client.command;

import com.orhanobut.logger.j;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private byte f17081a;

    /* renamed from: b, reason: collision with root package name */
    private int f17082b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private String f17083c;

    public a(byte b6, int i6, @NotNull String datas) {
        g0.p(datas, "datas");
        this.f17081a = b6;
        this.f17082b = i6;
        this.f17083c = datas;
    }

    public static /* synthetic */ void e(a aVar, String str, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = "命令数据：";
        }
        aVar.d(str);
    }

    public final byte a() {
        return this.f17081a;
    }

    @NotNull
    public final String b() {
        return this.f17083c;
    }

    public final int c() {
        return this.f17082b;
    }

    public final void d(@Nullable String str) {
        j.g(str + this, new Object[0]);
    }

    public final void f(byte b6) {
        this.f17081a = b6;
    }

    public final void g(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f17083c = str;
    }

    public final void h(int i6) {
        this.f17082b = i6;
    }

    @NotNull
    public String toString() {
        return "Command{cType=" + b0.a.f1020a.b(new byte[]{this.f17081a}) + ", length=" + this.f17082b + ", datas='" + this.f17083c + "'}";
    }
}
