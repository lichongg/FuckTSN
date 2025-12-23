package com.bytedance.sdk.openadsdk.i.cw.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31385j;

    public void j() {
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 221101);
        sparseArray.put(-99999985, Void.class);
        this.f31385j.apply(sparseArray);
    }

    public void cw(long j6, long j7, String str, String str2) {
        SparseArray sparseArray = new SparseArray(6);
        sparseArray.put(0, Long.valueOf(j6));
        sparseArray.put(1, Long.valueOf(j7));
        sparseArray.put(2, str);
        sparseArray.put(3, str2);
        sparseArray.put(-99999987, 221104);
        sparseArray.put(-99999985, Void.class);
        this.f31385j.apply(sparseArray);
    }

    public void xt(long j6, long j7, String str, String str2) {
        SparseArray sparseArray = new SparseArray(6);
        sparseArray.put(0, Long.valueOf(j6));
        sparseArray.put(1, Long.valueOf(j7));
        sparseArray.put(2, str);
        sparseArray.put(3, str2);
        sparseArray.put(-99999987, 221103);
        sparseArray.put(-99999985, Void.class);
        this.f31385j.apply(sparseArray);
    }

    public cw(Function<SparseArray<Object>, Object> function) {
        this.f31385j = function == null ? e.f22772d : function;
    }

    public void j(long j6, long j7, String str, String str2) {
        SparseArray sparseArray = new SparseArray(6);
        sparseArray.put(0, Long.valueOf(j6));
        sparseArray.put(1, Long.valueOf(j7));
        sparseArray.put(2, str);
        sparseArray.put(3, str2);
        sparseArray.put(-99999987, 221102);
        sparseArray.put(-99999985, Void.class);
        this.f31385j.apply(sparseArray);
    }

    public void j(long j6, String str, String str2) {
        SparseArray sparseArray = new SparseArray(5);
        sparseArray.put(0, Long.valueOf(j6));
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        sparseArray.put(-99999987, 221105);
        sparseArray.put(-99999985, Void.class);
        this.f31385j.apply(sparseArray);
    }

    public void j(String str, String str2) {
        SparseArray sparseArray = new SparseArray(4);
        sparseArray.put(0, str);
        sparseArray.put(1, str2);
        sparseArray.put(-99999987, 221106);
        sparseArray.put(-99999985, Void.class);
        this.f31385j.apply(sparseArray);
    }
}
