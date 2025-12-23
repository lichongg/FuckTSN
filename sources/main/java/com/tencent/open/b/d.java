package com.tencent.open.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.WindowManager;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static String f40531a;

    /* renamed from: b, reason: collision with root package name */
    private static String f40532b;

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f40531a)) {
            return f40531a;
        }
        if (context == null) {
            return "";
        }
        f40531a = "";
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            f40531a = windowManager.getDefaultDisplay().getWidth() + "x" + windowManager.getDefaultDisplay().getHeight();
        }
        return f40531a;
    }

    public static String a() {
        return Locale.getDefault().getLanguage();
    }
}
