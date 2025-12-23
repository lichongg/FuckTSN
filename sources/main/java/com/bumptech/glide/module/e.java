package com.bumptech.glide.module;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes3.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    private static final String f15830b = "ManifestParser";

    /* renamed from: c, reason: collision with root package name */
    private static final String f15831c = "GlideModule";

    /* renamed from: a, reason: collision with root package name */
    private final Context f15832a;

    private static void c(Class<?> cls, Exception exc) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, exc);
    }

    public List<c> a() {
        Log.isLoggable(f15830b, 3);
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = this.f15832a.getPackageManager().getApplicationInfo(this.f15832a.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                Log.isLoggable(f15830b, 3);
                return arrayList;
            }
            if (Log.isLoggable(f15830b, 2)) {
                Objects.toString(applicationInfo.metaData);
            }
            for (String str : applicationInfo.metaData.keySet()) {
                if (f15831c.equals(applicationInfo.metaData.get(str))) {
                    arrayList.add(b(str));
                    Log.isLoggable(f15830b, 3);
                }
            }
            Log.isLoggable(f15830b, 3);
            return arrayList;
        } catch (PackageManager.NameNotFoundException e6) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", e6);
        }
    }

    public e(Context context) {
        this.f15832a = context;
    }

    private static c b(String str) {
        try {
            Class<?> cls = Class.forName(str);
            Object obj = null;
            try {
                obj = cls.getDeclaredConstructor(null).newInstance(null);
            } catch (IllegalAccessException e6) {
                c(cls, e6);
            } catch (InstantiationException e7) {
                c(cls, e7);
            } catch (NoSuchMethodException e8) {
                c(cls, e8);
            } catch (InvocationTargetException e9) {
                c(cls, e9);
            }
            if (obj instanceof c) {
                return (c) obj;
            }
            throw new RuntimeException("Expected instanceof GlideModule, but found: " + obj);
        } catch (ClassNotFoundException e10) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e10);
        }
    }
}
