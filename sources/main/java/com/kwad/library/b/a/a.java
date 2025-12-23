package com.kwad.library.b.a;

import android.app.Activity;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends PathClassLoader {
    private static final List<ClassLoader> apV = new CopyOnWriteArrayList();
    private final BaseDexClassLoader apU;

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    protected final Class<?> findClass(String str) {
        Class<?> loadClass;
        Class<?> loadClass2;
        Class<?> cls = null;
        try {
            loadClass2 = this.apU.loadClass(str);
        } catch (Throwable th) {
            th = th;
        }
        if (Activity.class.isAssignableFrom(loadClass2)) {
            return loadClass2;
        }
        th = null;
        cls = loadClass2;
        if (cls != null) {
            return cls;
        }
        Iterator<ClassLoader> it = apV.iterator();
        while (it.hasNext()) {
            try {
                loadClass = it.next().loadClass(str);
            } catch (Throwable unused) {
            }
            if (loadClass != null) {
                return loadClass;
            }
        }
        if (th instanceof ClassNotFoundException) {
            throw th;
        }
        throw new ClassNotFoundException(str, th);
    }

    public a(BaseDexClassLoader baseDexClassLoader) {
        super("", baseDexClassLoader);
        this.apU = baseDexClassLoader;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public final String findLibrary(String str) {
        return this.apU.findLibrary(str);
    }

    @Override // java.lang.ClassLoader
    public final URL getResource(String str) {
        return this.apU.getResource(str);
    }

    @Override // java.lang.ClassLoader
    public final InputStream getResourceAsStream(String str) {
        return this.apU.getResourceAsStream(str);
    }

    @Override // java.lang.ClassLoader
    public final Enumeration<URL> getResources(String str) {
        return this.apU.getResources(str);
    }

    @Override // dalvik.system.BaseDexClassLoader
    public final String toString() {
        return this.apU.toString();
    }

    @Override // java.lang.ClassLoader
    public final Class<?> loadClass(String str) {
        return findClass(str);
    }
}
