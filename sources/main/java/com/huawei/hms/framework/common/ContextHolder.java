package com.huawei.hms.framework.common;

import android.annotation.SuppressLint;
import android.content.Context;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class ContextHolder {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33274a = "ContextHolder";

    /* renamed from: b, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static Context f33275b;

    /* renamed from: c, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static Context f33276c;

    public static Context getAppContext() {
        return f33275b;
    }

    public static Context getKitContext() {
        return f33276c;
    }

    public static void setAppContext(Context context) {
        if (f33275b != null) {
            return;
        }
        CheckParamUtils.checkNotNull(context, "sAppContext == null");
        f33275b = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    public static void setKitContext(Context context) {
        CheckParamUtils.checkNotNull(context, "sKitContext == null");
        f33276c = context;
    }

    public static Context getResourceContext() {
        if (getKitContext() != null) {
            return getKitContext();
        }
        return getAppContext();
    }
}
