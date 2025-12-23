package com.beizi.ad;

import android.content.Context;
import androidx.annotation.RequiresPermission;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static g f11421a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f11422b;

    @RequiresPermission(com.kuaishou.weapon.p0.g.f36041a)
    public static void a(Context context, String str, g gVar) {
        f11421a = gVar;
        com.beizi.ad.internal.h.a().a(context, str);
    }

    public static boolean b() {
        return f11422b;
    }

    public static void b(String str) {
        com.beizi.ad.internal.h.a().f12000e = str;
    }

    public static g a() {
        return f11421a;
    }

    public static String c(String str) {
        return com.beizi.ad.internal.h.a().b(str);
    }

    public static void a(boolean z5) {
        f11422b = z5;
    }

    public static void a(String str) {
        com.beizi.ad.internal.h.a().a(str);
    }

    public static void a(List<String> list) {
        com.beizi.ad.internal.h.a().a(list);
    }
}
