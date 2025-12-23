package com.google.android.gms.dynamic;

import android.os.IBinder;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.RetainForClient;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.lang.reflect.Field;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RetainForClient
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public final class ObjectWrapper<T> extends IObjectWrapper.Stub {
    private final Object zza;

    @NonNull
    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public static <T> T unwrap(@NonNull IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper instanceof ObjectWrapper) {
            return (T) ((ObjectWrapper) iObjectWrapper).zza;
        }
        IBinder asBinder = iObjectWrapper.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        Field field = null;
        int i6 = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i6++;
                field = field2;
            }
        }
        if (i6 != 1) {
            throw new IllegalArgumentException("Unexpected number of IObjectWrapper declared fields: " + declaredFields.length);
        }
        Preconditions.checkNotNull(field);
        if (field.isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
        field.setAccessible(true);
        try {
            return (T) field.get(asBinder);
        } catch (IllegalAccessException e6) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", e6);
        } catch (NullPointerException e7) {
            throw new IllegalArgumentException("Binder object is null.", e7);
        }
    }

    @NonNull
    @KeepForSdk
    public static <T> IObjectWrapper wrap(@NonNull T t5) {
        return new ObjectWrapper(t5);
    }

    private ObjectWrapper(Object obj) {
        this.zza = obj;
    }
}
