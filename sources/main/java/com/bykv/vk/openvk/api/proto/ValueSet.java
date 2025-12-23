package com.bykv.vk.openvk.api.proto;

import android.annotation.TargetApi;
import android.util.SparseArray;
import java.util.Set;
import java.util.function.Supplier;

/* loaded from: D:\Downloads\app\classes3.dex */
public interface ValueSet {

    @TargetApi(24)
    public interface ValueGetter<T> extends Supplier<T> {
        @Override // java.util.function.Supplier
        T get();
    }

    <T> T[] arrayValue(int i6, Class<T> cls);

    boolean booleanValue(int i6);

    boolean booleanValue(int i6, boolean z5);

    boolean containsKey(int i6);

    double doubleValue(int i6);

    float floatValue(int i6);

    float floatValue(int i6, float f6);

    int intValue(int i6);

    int intValue(int i6, int i7);

    boolean isEmpty();

    Set<Integer> keys();

    long longValue(int i6);

    long longValue(int i6, long j6);

    <T> T objectValue(int i6, Class<T> cls);

    void remove(int i6);

    int size();

    SparseArray<Object> sparseArray();

    String stringValue(int i6);

    String stringValue(int i6, String str);
}
