package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import dalvik.system.DexClassLoader;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class g {
    private static final List<String> auc;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a extends DexClassLoader {
        private final ClassLoader aud;

        public a(String str, String str2, String str3, ClassLoader classLoader) {
            super(str, str2, str3, classLoader);
            this.aud = classLoader;
            classLoader.getClass();
        }

        private static boolean cr(String str) {
            if (!TextUtils.isEmpty(str)) {
                if (str.startsWith("com.kwad.sdk.api") || str.startsWith("com.kwad.sdk.liteapi")) {
                    return true;
                }
                return false;
            }
            return false;
        }

        @Override // java.lang.ClassLoader
        protected final Class<?> loadClass(String str, boolean z5) {
            if (cr(str)) {
                return getParent().loadClass(str);
            }
            Class<?> findLoadedClass = findLoadedClass(str);
            if (findLoadedClass != null) {
                return findLoadedClass;
            }
            try {
                findLoadedClass = findClass(str);
            } catch (ClassNotFoundException unused) {
            }
            if (findLoadedClass != null) {
                return findLoadedClass;
            }
            try {
                findLoadedClass = super.loadClass(str, z5);
            } catch (ClassNotFoundException unused2) {
            }
            if (findLoadedClass != null) {
                return findLoadedClass;
            }
            try {
                return getParent().loadClass(str);
            } catch (ClassNotFoundException unused3) {
                return findLoadedClass;
            }
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        auc = arrayList;
        arrayList.add("com.kwad.sdk");
        arrayList.add("com.ksad");
        arrayList.add("com.kwai");
        arrayList.add("kwad.support");
        arrayList.add("android.support.rastermill");
    }

    @NonNull
    static ClassLoader a(Context context, ClassLoader classLoader, String str, String str2, String str3) {
        if (b.b(context, "useContextClassLoader", false)) {
            classLoader = context.getClassLoader();
        }
        return new a(str, str2, str3, classLoader);
    }
}
