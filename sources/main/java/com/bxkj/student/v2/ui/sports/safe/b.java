package com.bxkj.student.v2.ui.sports.safe;

import android.content.Intent;
import android.provider.Settings;
import com.bxkj.student.App;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f21524a = new b();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static String f21525b = "系统检查到疑似模拟定位，已被系统记录，请【卸载虚拟定位软件】并【关闭开发者选项】后再试";

    @NotNull
    public final String a() {
        return f21525b;
    }

    public final boolean b() {
        return Settings.Secure.getInt(App.f17573d.a().getContentResolver(), "development_settings_enabled", 0) > 0;
    }

    public final void c() {
        Intent intent = new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS");
        intent.setFlags(268435456);
        App.f17573d.a().startActivity(intent);
    }

    public final void d(@NotNull String str) {
        g0.p(str, "<set-?>");
        f21525b = str;
    }

    private b() {
    }
}
