package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static Context f35231a;

    public static Context a() {
        return f35231a;
    }

    public static void b(Context context) {
        if (context == null || f35231a != null) {
            return;
        }
        f35231a = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }
}
