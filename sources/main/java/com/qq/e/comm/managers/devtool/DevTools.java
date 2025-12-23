package com.qq.e.comm.managers.devtool;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class DevTools {

    /* renamed from: a, reason: collision with root package name */
    private String f36754a;

    public String getDemoGameUrl() {
        String str = this.f36754a;
        this.f36754a = null;
        return str;
    }

    public void testDemoGame(Context context, String str) {
        if (TextUtils.isEmpty(str) || !context.getPackageName().equals("com.qq.e.union.demo.union")) {
            return;
        }
        this.f36754a = str;
    }
}
