package cn.jiguang.ba;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.service.JCommonService;

/* loaded from: D:\Downloads\app\classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static String f1897a;

    /* renamed from: b, reason: collision with root package name */
    private static String f1898b;

    /* renamed from: cn.jiguang.ba.d$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final d f1899a = new d(null);
    }

    private d() {
    }

    public static d a() {
        return a.f1899a;
    }

    public static String b(Context context) {
        ComponentInfo a6;
        String str;
        try {
            str = f1897a;
        } catch (Throwable th) {
            cn.jiguang.bb.f.c("JCommonServiceHelper", "getUserServiceClass failed:" + th);
        }
        if (str != null) {
            return str;
        }
        Intent intent = new Intent();
        intent.setAction(JConstants.USER_SERVICE_ACTION);
        intent.setPackage(context.getPackageName());
        String a7 = cn.jiguang.bz.a.a(context, intent, "");
        if (!TextUtils.isEmpty(a7) && JCommonService.class.isAssignableFrom(Class.forName(a7))) {
            f1897a = a7;
            cn.jiguang.bb.f.h("JCommonServiceHelper", "found userServiceClass :" + f1897a + " by getCommonServiceNames");
        }
        if (TextUtils.isEmpty(f1897a) && (a6 = cn.jiguang.bz.a.a(context, context.getPackageName(), (Class<?>) JCommonService.class)) != null) {
            f1897a = a6.name;
            cn.jiguang.bb.f.h("JCommonServiceHelper", "found userServiceClass :" + f1897a + " by getComponentInfo");
        }
        if (TextUtils.isEmpty(f1897a)) {
            f1897a = "";
        }
        return f1897a;
    }

    /* synthetic */ d(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static String a(Context context) {
        StringBuilder sb;
        String str;
        String str2 = f1898b;
        if (str2 != null) {
            return str2;
        }
        String b6 = b(context);
        if (TextUtils.isEmpty(b6)) {
            f1898b = context.getPackageName();
            sb = new StringBuilder();
            str = "user serviceProcess is curProcessName:";
        } else {
            f1898b = cn.jiguang.bz.a.a(context, b6);
            sb = new StringBuilder();
            str = "user serviceProcess is:";
        }
        sb.append(str);
        sb.append(f1898b);
        cn.jiguang.bb.f.c("JCommonServiceHelper", sb.toString());
        return f1898b;
    }

    public void b(Context context, String str, Bundle bundle) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("callAction action:");
            sb.append(str);
            sb.append(" bundle:");
            sb.append(bundle == null ? "null" : bundle.toString());
            cn.jiguang.bb.f.f("JCommonServiceHelper", sb.toString());
            cn.jiguang.be.a.a(cn.jiguang.bz.d.a(context), str, bundle);
        } catch (Throwable th) {
            cn.jiguang.bb.f.f("JCommonServiceHelper", "callAction failed", th);
        }
    }

    public void a(Context context, String str, Bundle bundle) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("onAction action:");
            sb.append(str);
            sb.append(" bundle:");
            sb.append(bundle == null ? "null" : bundle.toString());
            cn.jiguang.bb.f.c("JCommonServiceHelper", sb.toString());
            String b6 = b(context);
            if (TextUtils.isEmpty(b6)) {
                cn.jiguang.a.a.b(context, str, bundle);
            } else {
                e.a().a(context, b6, str, bundle);
            }
        } catch (Throwable th) {
            cn.jiguang.bb.f.f("JCommonServiceHelper", "onAction failed", th);
        }
    }
}
