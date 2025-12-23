package com.uyumao;

import android.content.SharedPreferences;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public static volatile m f42601a;

    /* renamed from: b, reason: collision with root package name */
    public final SharedPreferences f42602b = e.a().getSharedPreferences("um_social_azx", 0);

    public static m a() {
        if (f42601a == null) {
            synchronized (m.class) {
                try {
                    if (f42601a == null) {
                        f42601a = new m();
                    }
                } finally {
                }
            }
        }
        return f42601a;
    }
}
