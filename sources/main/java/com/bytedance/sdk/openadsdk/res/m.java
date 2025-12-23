package com.bytedance.sdk.openadsdk.res;

import android.graphics.drawable.Drawable;
import android.widget.ProgressBar;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m {
    public static void j(ProgressBar progressBar, Drawable drawable) {
        j(progressBar, "mIndeterminateOnly", Boolean.FALSE);
        progressBar.setIndeterminate(false);
        progressBar.setProgressDrawable(drawable);
        progressBar.setIndeterminateDrawable(null);
    }

    private static void j(Object obj, String str, Object obj2) {
        try {
            Field j6 = j(obj, str);
            if (j6 != null) {
                j(j6);
                j6.set(obj, obj2);
                return;
            }
            throw new IllegalArgumentException("Could not find field [" + str + "] on target [" + obj + "]");
        } catch (Throwable unused) {
        }
    }

    private static Field j(Object obj, String str) {
        return j((Class) obj.getClass(), str);
    }

    private static Field j(Class cls, String str) {
        while (cls != Object.class) {
            try {
                return cls.getDeclaredField(str);
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    private static void j(Field field) {
        if (Modifier.isPublic(field.getModifiers()) && Modifier.isPublic(field.getDeclaringClass().getModifiers())) {
            return;
        }
        field.setAccessible(true);
    }
}
