package com.snail.antifake.deviceid;

import android.os.RemoteException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class b {
    public static String a(Object obj) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return (String) obj.getClass().getDeclaredMethod("getInterfaceDescriptor", null).invoke(obj, null);
    }

    public static int b(Object obj, String str) throws RemoteException, NoSuchFieldException, IllegalAccessException {
        Field declaredField = obj.getClass().getEnclosingClass().getDeclaredField(str);
        declaredField.setAccessible(true);
        return ((Integer) declaredField.get(obj)).intValue();
    }
}
