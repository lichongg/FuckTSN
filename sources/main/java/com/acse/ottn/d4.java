package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.app.Service;
import java.io.ObjectStreamException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class d4 {

    /* renamed from: a, reason: collision with root package name */
    public static d4 f4444a = null;

    /* renamed from: b, reason: collision with root package name */
    public static String f4445b = "ServiceUtils";

    public static d4 a() {
        if (f4444a == null) {
            synchronized (d4.class) {
                try {
                    if (f4444a == null) {
                        f4444a = new d4();
                    }
                } finally {
                }
            }
        }
        return f4444a;
    }

    public final Object b() throws ObjectStreamException {
        return f4444a;
    }

    public boolean a(Service service) {
        return !(service instanceof AccessibilityService);
    }
}
