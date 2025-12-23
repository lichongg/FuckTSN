package com.bytedance.sdk.openadsdk.core;

import android.util.SparseArray;
import java.util.HashMap;

/* loaded from: D:\Downloads\app\classes4.dex */
public class x {

    /* renamed from: j, reason: collision with root package name */
    private static final SparseArray<HashMap> f31305j = new SparseArray<>();

    public static <T> void j(String str, T t5, Class cls) {
        if (t5 == null) {
            return;
        }
        int hashCode = cls.hashCode();
        SparseArray<HashMap> sparseArray = f31305j;
        HashMap hashMap = sparseArray.get(hashCode);
        if (hashMap == null) {
            hashMap = new HashMap();
            sparseArray.put(hashCode, hashMap);
        }
        hashMap.put(str, t5);
    }

    public static <T> T xt(String str, Class<T> cls) {
        HashMap hashMap;
        if (cls == null || str == null || (hashMap = f31305j.get(cls.hashCode())) == null) {
            return null;
        }
        return (T) hashMap.remove(str);
    }

    public static <T> void j(String str) {
        int size = f31305j.size();
        for (int i6 = 0; i6 < size; i6++) {
            SparseArray<HashMap> sparseArray = f31305j;
            HashMap hashMap = sparseArray.get(sparseArray.keyAt(i6));
            if (hashMap != null) {
                hashMap.remove(str);
            }
        }
    }

    public static <T> T j(String str, Class<T> cls) {
        HashMap hashMap;
        if (cls == null || str == null || (hashMap = f31305j.get(cls.hashCode())) == null) {
            return null;
        }
        return (T) hashMap.get(str);
    }
}
