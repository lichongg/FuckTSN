package com.huawei.hms.feature.dynamic;

import android.os.IBinder;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import java.lang.reflect.Field;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class ObjectWrapper<T> extends IObjectWrapper.Stub {

    /* renamed from: a, reason: collision with root package name */
    public final T f33194a;

    public static <T> T unwrap(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper instanceof ObjectWrapper) {
            return ((ObjectWrapper) iObjectWrapper).f33194a;
        }
        IBinder asBinder = iObjectWrapper.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        int i6 = 0;
        for (Field field : declaredFields) {
            if (!field.isSynthetic()) {
                i6++;
            }
        }
        if (i6 == 1) {
            if (declaredFields[0].isAccessible()) {
                throw new IllegalArgumentException("The field is accessible.");
            }
            declaredFields[0].setAccessible(true);
            try {
                return (T) declaredFields[0].get(asBinder);
            } catch (Exception unused) {
                throw new IllegalArgumentException("Get binder failed: null or not permitted.");
            }
        }
        throw new IllegalArgumentException("Got " + declaredFields.length + " fields, The number of field number should be 1.");
    }

    public static <T> IObjectWrapper wrap(T t5) {
        return new ObjectWrapper(t5);
    }

    public ObjectWrapper(T t5) {
        this.f33194a = t5;
    }
}
