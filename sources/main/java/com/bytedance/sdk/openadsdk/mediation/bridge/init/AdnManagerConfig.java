package com.bytedance.sdk.openadsdk.mediation.bridge.init;

import a1.b;
import android.util.SparseArray;
import com.bykv.j.j.j.j.f;
import com.bytedance.sdk.openadsdk.api.m;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qq.e.comm.constants.ErrorCode;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class AdnManagerConfig {
    private static volatile Function<SparseArray<Object>, Object> ae;
    private static volatile Function<SparseArray<Object>, Object> cw;

    /* renamed from: j, reason: collision with root package name */
    private static volatile Function<SparseArray<Object>, Object> f31693j;

    /* renamed from: m, reason: collision with root package name */
    private static volatile Function<SparseArray<Object>, Object> f31694m;

    /* renamed from: r, reason: collision with root package name */
    private static volatile Function<SparseArray<Object>, Object> f31695r;
    private static volatile Function<SparseArray<Object>, Object> tl;
    private static volatile Function<SparseArray<Object>, Object> up;
    private static volatile Function<SparseArray<Object>, Object> xt;

    public static Function<SparseArray<Object>, Object> getAdapterManager(String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
        }
        return null;
    }

    private static boolean j(String str, String str2) {
        Object apply;
        if (str2 == null) {
            return false;
        }
        try {
            Object newInstance = Class.forName(str).newInstance();
            if (f.a(newInstance)) {
                Function a6 = b.a(newInstance);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(-99999987, Integer.valueOf(ErrorCode.PrivateError.LOAD_TIME_OUT));
                sparseArray.put(-99999985, Object.class);
                apply = a6.apply(sparseArray);
                if (f.a(apply)) {
                    Function<SparseArray<Object>, Object> a7 = b.a(apply);
                    switch (str2.hashCode()) {
                        case -902468465:
                            if (!str2.equals(MediationConstant.ADN_SIGMOB)) {
                                return true;
                            }
                            f31694m = a7;
                            return true;
                        case -759499589:
                            if (!str2.equals("xiaomi")) {
                                return true;
                            }
                            tl = a7;
                            return true;
                        case 3432:
                            if (!str2.equals(MediationConstant.ADN_KS)) {
                                return true;
                            }
                            f31695r = a7;
                            return true;
                        case 102199:
                            if (!str2.equals(MediationConstant.ADN_GDT)) {
                                return true;
                            }
                            cw = a7;
                            return true;
                        case 92668925:
                            if (!str2.equals(MediationConstant.ADN_ADMOB)) {
                                return true;
                            }
                            f31693j = a7;
                            return true;
                        case 93498907:
                            if (!str2.equals("baidu")) {
                                return true;
                            }
                            xt = a7;
                            return true;
                        case 111433589:
                            if (!str2.equals(MediationConstant.ADN_UNITY)) {
                                return true;
                            }
                            ae = a7;
                            return true;
                        case 1126045977:
                            if (!str2.equals(MediationConstant.ADN_MINTEGRAL)) {
                                return true;
                            }
                            up = a7;
                            return true;
                        default:
                            return true;
                    }
                }
            }
        } catch (Throwable th) {
            m.j(th);
        }
        return false;
    }

    public static boolean initAdnManager(String str, String str2) {
        return j(str, str2);
    }
}
