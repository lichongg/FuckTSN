package com.bytedance.sdk.component.ae;

import android.content.Context;
import com.stub.StubApp;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {

    /* renamed from: j, reason: collision with root package name */
    private static volatile Context f26057j;

    public static Context getContext() {
        return f26057j;
    }

    public static void j(Context context) {
        if (f26057j == null && context != null) {
            f26057j = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }
}
