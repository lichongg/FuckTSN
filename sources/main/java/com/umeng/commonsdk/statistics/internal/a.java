package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.stub.StubApp;
import com.umeng.analytics.pro.bi;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.utils.UMUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Context f41968a;

    /* renamed from: b, reason: collision with root package name */
    private String f41969b;

    /* renamed from: c, reason: collision with root package name */
    private String f41970c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.umeng.commonsdk.statistics.internal.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.umeng.commonsdk.statistics.internal.a$a, reason: collision with other inner class name */
    private static class C0829a {

        /* renamed from: a, reason: collision with root package name */
        private static final a f41971a = new a(null);

        private C0829a() {
        }
    }

    /* synthetic */ a(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static a a(Context context) {
        if (f41968a == null && context != null) {
            f41968a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        return C0829a.f41971a;
    }

    public boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(bi.aL);
    }

    private a() {
        this.f41969b = null;
        this.f41970c = null;
    }

    private void f(String str) {
        try {
            this.f41969b = str.replaceAll("&=", " ").replaceAll("&&", " ").replaceAll("==", "/") + "/Android " + HelperUtils.getUmengMD5(UMUtils.getAppkey(f41968a));
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f41968a, th);
        }
    }

    private void g(String str) {
        try {
            String str2 = str.split("&&")[0];
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            String[] split = str2.split("&=");
            StringBuilder sb = new StringBuilder();
            sb.append(bi.aT);
            for (String str3 : split) {
                if (!TextUtils.isEmpty(str3)) {
                    String substring = str3.substring(0, 2);
                    if (substring.endsWith(ContainerUtils.KEY_VALUE_DELIMITER)) {
                        substring = substring.replace(ContainerUtils.KEY_VALUE_DELIMITER, "");
                    }
                    sb.append(substring);
                }
            }
            this.f41970c = sb.toString();
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f41968a, th);
        }
    }

    public void e(String str) {
        String substring = str.substring(0, str.indexOf(95));
        g(substring);
        f(substring);
    }

    public String b() {
        return this.f41969b;
    }

    public boolean c(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.startsWith(bi.aG);
        }
        return false;
    }

    public boolean d(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.startsWith("h");
        }
        return false;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("a");
    }

    public String a() {
        return this.f41970c;
    }
}
