package com.bytedance.pangle;

import androidx.annotation.Keep;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@Keep
/* loaded from: D:\Downloads\app\classes3.dex */
public class PluginClassLoader extends BaseDexClassLoader {
    private static final String TAG = "PluginClassLoader";
    private HashSet<String> allPluginClasses;
    private final ClassLoader hostClassLoader;
    private List<ClassLoader> otherPluginClassLoader;

    private ClassNotFoundException handleException(StringBuilder sb, ClassNotFoundException classNotFoundException, ClassNotFoundException classNotFoundException2) {
        if (classNotFoundException == null) {
            return classNotFoundException2;
        }
        classNotFoundException.addSuppressed(classNotFoundException2);
        return classNotFoundException;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    protected Class<?> findClass(String str) throws ClassNotFoundException {
        List<ClassLoader> list;
        HashSet<String> hashSet = this.allPluginClasses;
        Class<?> cls = null;
        if (hashSet == null || hashSet.contains(str)) {
            try {
                cls = super.findClass(str);
                e = null;
            } catch (ClassNotFoundException e6) {
                e = e6;
            }
        } else {
            e = null;
        }
        StringBuilder sb = new StringBuilder("loadClass from :\n");
        if (cls == null && (list = this.otherPluginClassLoader) != null) {
            Iterator<ClassLoader> it = list.iterator();
            while (it.hasNext()) {
                try {
                    cls = it.next().loadClass(str);
                } catch (ClassNotFoundException e7) {
                    e = handleException(sb, e, e7);
                }
            }
        }
        if (cls == null) {
            try {
                cls = this.hostClassLoader.loadClass(str);
            } catch (ClassNotFoundException e8) {
                e = handleException(sb, e, e8);
            }
        }
        if (cls != null) {
            return cls;
        }
        if (e != null) {
            throw e;
        }
        throw new ClassNotFoundException(str + " class not found in PluginClassLoader");
    }

    public void setAllPluginClasses(HashSet<String> hashSet) {
        this.allPluginClasses = hashSet;
    }

    public void setOtherPluginClassLoader(List<ClassLoader> list) {
        this.otherPluginClassLoader = list;
    }

    public PluginClassLoader(String str, File file, String str2, List<ClassLoader> list) {
        super(str, file, str2, ClassLoader.getSystemClassLoader().getParent());
        this.hostClassLoader = PluginClassLoader.class.getClassLoader();
        this.otherPluginClassLoader = list;
    }
}
