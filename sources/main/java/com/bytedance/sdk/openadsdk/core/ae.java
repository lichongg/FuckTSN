package com.bytedance.sdk.openadsdk.core;

import android.annotation.SuppressLint;
import android.content.Context;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae extends tl {

    /* renamed from: j, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile ae f27948j;

    public static ae j(Context context) {
        if (f27948j == null) {
            synchronized (ae.class) {
                try {
                    if (f27948j == null) {
                        f27948j = new ae(context);
                    }
                } finally {
                }
            }
        }
        return f27948j;
    }

    private ae(Context context) {
        super(context);
    }
}
