package com.bytedance.msdk.tl;

import android.content.Context;
import android.content.Intent;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r {

    public interface j {
    }

    public static void j(Context context, Intent intent, j jVar) {
        if (context == null || intent == null) {
            return;
        }
        try {
            context.startActivity(intent);
        } catch (Throwable unused) {
        }
    }
}
