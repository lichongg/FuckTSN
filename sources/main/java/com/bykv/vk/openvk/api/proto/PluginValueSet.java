package com.bykv.vk.openvk.api.proto;

import android.util.SparseArray;
import java.util.Set;

/* loaded from: D:\Downloads\app\classes3.dex */
public interface PluginValueSet {
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
