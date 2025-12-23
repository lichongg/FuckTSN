package com.bytedance.msdk.up.j;

import android.annotation.SuppressLint;
import android.content.Context;

/* loaded from: D:\Downloads\app\classes3.dex */
public class m extends ae {

    /* renamed from: j, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile m f25251j;

    public static m j(Context context) {
        if (f25251j == null) {
            synchronized (m.class) {
                try {
                    if (f25251j == null) {
                        f25251j = new m(context);
                    }
                } finally {
                }
            }
        }
        return f25251j;
    }

    private m(Context context) {
        super(context);
    }
}
