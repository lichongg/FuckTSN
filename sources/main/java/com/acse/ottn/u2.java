package com.acse.ottn;

import android.content.Context;
import android.content.Intent;
import java.io.ObjectStreamException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class u2 {

    /* renamed from: a, reason: collision with root package name */
    public static u2 f5368a;

    public static u2 a() {
        if (f5368a == null) {
            synchronized (u2.class) {
                try {
                    if (f5368a == null) {
                        f5368a = new u2();
                    }
                } finally {
                }
            }
        }
        return f5368a;
    }

    public final Object b() throws ObjectStreamException {
        return f5368a;
    }

    public void a(Context context) {
        j3.a().a("oaid_permission", Boolean.TRUE);
        context.startActivity(new Intent("android.settings.SETTINGS"));
    }
}
