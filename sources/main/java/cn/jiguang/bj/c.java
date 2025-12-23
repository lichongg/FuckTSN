package cn.jiguang.bj;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.bz.o;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static int f2305a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, Integer> f2306b;

    /* renamed from: cn.jiguang.bj.c$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final c f2307a = new c(null);
    }

    private c() {
        this.f2306b = new HashMap();
    }

    public static c a() {
        return a.f2307a;
    }

    /* synthetic */ c(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static void a(int i6) {
        if (i6 > 3 || i6 < 0) {
            return;
        }
        f2305a = i6;
    }

    public int b(int i6) {
        int i7 = f2305a;
        if (i7 != 2 && i7 != 1) {
            if (i6 == 1) {
                return 1;
            }
            if (i6 == 2) {
                return 2;
            }
        }
        return i7;
    }

    public void a(Context context, int i6) {
        String a6 = o.a(context);
        boolean equals = "wifi".equals(a6);
        String b6 = equals ? cn.jiguang.bz.a.a().b(context, false) : "";
        boolean isEmpty = TextUtils.isEmpty(b6);
        if (!equals || !isEmpty) {
            this.f2306b.put(a6 + b6, Integer.valueOf(i6));
        }
        if (isEmpty) {
            return;
        }
        cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.h(b6).a((cn.jiguang.e.a<Integer>) Integer.valueOf(i6))});
    }
}
