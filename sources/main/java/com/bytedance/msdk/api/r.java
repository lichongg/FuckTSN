package com.bytedance.msdk.api;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;
import com.stub.StubApp;

/* loaded from: D:\Downloads\app\classes3.dex */
public final class r {

    /* renamed from: j, reason: collision with root package name */
    private static Toast f24345j;

    public static void j(Context context, String str) {
        j(context, str, 0);
    }

    public static void j(Context context, String str, int i6) {
        Toast j6 = j(context);
        if (j6 == null) {
            com.bytedance.msdk.j.up.cw.xt("TToast", "toast msg: ".concat(String.valueOf(str)));
            return;
        }
        j6.setDuration(i6);
        j6.setText(String.valueOf(str));
        j6.show();
    }

    @SuppressLint({"ShowToast"})
    private static Toast j(Context context) {
        if (context == null) {
            return f24345j;
        }
        Toast makeText = Toast.makeText(StubApp.getOrigApplicationContext(context.getApplicationContext()), "", 0);
        f24345j = makeText;
        return makeText;
    }
}
