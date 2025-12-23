package com.yxcorp.kuaishou.addfp.android.b;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Process;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a {
    public static String a(Context context, String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.UserHandle");
            Class<?> cls2 = Integer.TYPE;
            Method declaredMethod = cls.getDeclaredMethod("getUserId", cls2);
            declaredMethod.setAccessible(true);
            Integer num = (Integer) declaredMethod.invoke(null, Integer.valueOf(Process.myUid()));
            num.intValue();
            Method declaredMethod2 = Class.forName("android.provider.Settings$" + str).getDeclaredMethod("getStringForUser", ContentResolver.class, String.class, cls2);
            declaredMethod2.setAccessible(true);
            return (String) declaredMethod2.invoke(null, context.getContentResolver(), str2, num);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}
