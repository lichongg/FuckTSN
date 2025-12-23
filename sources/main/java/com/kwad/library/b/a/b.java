package com.kwad.library.b.a;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b extends BaseDexClassLoader {
    private final List<String> apW;
    private final List<String> apX;
    private final ClassLoader apY;

    @Override // java.lang.ClassLoader
    protected final Class<?> loadClass(String str, boolean z5) {
        List<String> list = this.apW;
        if (list != null && list.contains(str)) {
            return super.loadClass(str, z5);
        }
        List<String> list2 = this.apX;
        if (list2 != null) {
            Iterator<String> it = list2.iterator();
            while (it.hasNext()) {
                if (str.startsWith(it.next() + ".")) {
                    return super.loadClass(str, z5);
                }
            }
        }
        Class<?> findLoadedClass = findLoadedClass(str);
        if (findLoadedClass != null) {
            return findLoadedClass;
        }
        try {
            return findClass(str);
        } catch (ClassNotFoundException e6) {
            try {
                return getParent().loadClass(str);
            } catch (ClassNotFoundException e7) {
                e7.addSuppressed(e6);
                throw e7;
            }
        }
    }

    public b(ClassLoader classLoader, String str, @Nullable File file, String str2, List<String> list, List<String> list2) {
        super(str, file, str2, classLoader);
        this.apY = classLoader;
        this.apW = list;
        this.apX = list2;
        while (classLoader.getParent() != null) {
            classLoader = classLoader.getParent();
        }
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public final String findLibrary(String str) {
        String findLibrary = super.findLibrary(str);
        if (TextUtils.isEmpty(findLibrary) && (this.apY instanceof BaseDexClassLoader)) {
            return ((BaseDexClassLoader) this.apY).findLibrary(str);
        }
        return findLibrary;
    }
}
