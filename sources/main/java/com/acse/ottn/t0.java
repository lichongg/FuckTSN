package com.acse.ottn;

import java.io.ObjectStreamException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class t0 {

    /* renamed from: a, reason: collision with root package name */
    public static t0 f5308a;

    public static t0 a() {
        if (f5308a == null) {
            synchronized (t0.class) {
                try {
                    if (f5308a == null) {
                        f5308a = new t0();
                    }
                } finally {
                }
            }
        }
        return f5308a;
    }

    public final Object b() throws ObjectStreamException {
        return f5308a;
    }
}
