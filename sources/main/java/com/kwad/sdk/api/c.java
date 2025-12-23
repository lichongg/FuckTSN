package com.kwad.sdk.api;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.IKsAdSDK;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    private static List<Throwable> Oe;
    private static IKsAdSDK atA;

    public static boolean De() {
        Boolean bool = (Boolean) g("enableDynamic", new Object[0]);
        return (bool == null || bool.booleanValue()) ? false : true;
    }

    public static int Df() {
        Integer num = (Integer) g("getAutoRevertTime", new Object[0]);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public static String cm(String str) {
        return (String) g("TRANSFORM_API_HOST", str);
    }

    static /* synthetic */ List t(List list) {
        Oe = null;
        return null;
    }

    public static IKsAdSDK Dd() {
        return atA;
    }

    public static void a(IKsAdSDK iKsAdSDK) {
        atA = iKsAdSDK;
    }

    private static void b(Throwable th) {
        try {
            if (Oe == null) {
                Oe = new CopyOnWriteArrayList();
            }
            Oe.add(th);
        } catch (Throwable unused) {
        }
    }

    @Nullable
    public static <T> T g(String str, Object... objArr) {
        try {
            T t5 = (T) atA.dM(str, objArr);
            if (t5 != null) {
                return t5;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void m(Throwable th) {
        try {
            if (atA == null || !KsAdSDK.haseInit()) {
                b(th);
            } else {
                atA.re(th);
            }
        } catch (Throwable unused) {
        }
    }

    public static void ow() {
        try {
            com.kwad.sdk.api.a.a.a(new com.kwad.sdk.api.a.b() { // from class: com.kwad.sdk.api.c.1
                @Override // com.kwad.sdk.api.a.b
                public final void doTask() {
                    try {
                        if (c.Oe != null) {
                            for (Throwable th : c.Oe) {
                                if (c.atA != null && KsAdSDK.haseInit()) {
                                    c.atA.re(th);
                                }
                            }
                            c.Oe.clear();
                            c.t(null);
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }
}
