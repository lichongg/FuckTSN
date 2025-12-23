package com.google.android.datatransport.runtime.dagger.internal;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class Preconditions {
    public static <T> T checkNotNull(T t5) {
        t5.getClass();
        return t5;
    }

    public static <T> void checkBuilderRequirement(T t5, Class<T> cls) {
        if (t5 != null) {
            return;
        }
        throw new IllegalStateException(cls.getCanonicalName() + " must be set");
    }

    public static <T> T checkNotNull(T t5, String str) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(str);
    }

    private Preconditions() {
    }

    public static <T> T checkNotNull(T t5, String str, Object obj) {
        String valueOf;
        if (t5 != null) {
            return t5;
        }
        if (str.contains("%s")) {
            if (str.indexOf("%s") == str.lastIndexOf("%s")) {
                if (obj instanceof Class) {
                    valueOf = ((Class) obj).getCanonicalName();
                } else {
                    valueOf = String.valueOf(obj);
                }
                throw new NullPointerException(str.replace("%s", valueOf));
            }
            throw new IllegalArgumentException("errorMessageTemplate has more than one format specifier");
        }
        throw new IllegalArgumentException("errorMessageTemplate has no format specifiers");
    }
}
