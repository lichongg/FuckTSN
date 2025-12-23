package com.bytedance.sdk.openadsdk.core.wq.j;

import a1.b;
import android.util.SparseArray;
import com.bykv.j.j.j.j.f;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.TTC;
import com.bytedance.sdk.openadsdk.TTM;
import com.bytedance.sdk.openadsdk.api.TTILog;
import com.bytedance.sdk.openadsdk.tools.LogAdapter;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.lang.reflect.Method;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {

    public interface j {
        void cw(String str, String str2);

        void j();

        void j(String str, String str2);

        void j(String str, String str2, Throwable th);

        void j(String str, Throwable th);

        void r(String str, String str2);

        void up(String str, String str2);

        void xt(String str, String str2);

        void xt(String str, String str2, Throwable th);
    }

    public static class xt implements j {

        /* renamed from: j, reason: collision with root package name */
        Object f31291j;
        Function xt;

        public xt(Object obj) {
            this.f31291j = obj;
        }

        @Override // com.bytedance.sdk.openadsdk.core.wq.j.cw.j
        public void j(String str, String str2) {
            if (this.xt != null) {
                j(-8999900, str, str2, null);
            }
            Object obj = this.f31291j;
            if (obj != null) {
                ((TTILog) obj).v(str, str2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.wq.j.cw.j
        public void xt(String str, String str2) {
            if (this.xt != null) {
                j(-8999901, str, str2, null);
            }
            Object obj = this.f31291j;
            if (obj != null) {
                ((TTILog) obj).d(str, str2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.wq.j.cw.j
        public void cw(String str, String str2) {
            if (this.xt != null) {
                j(-8999902, str, str2, null);
            }
            Object obj = this.f31291j;
            if (obj != null) {
                ((TTILog) obj).i(str, str2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.wq.j.cw.j
        public void r(String str, String str2) {
            if (this.xt != null) {
                j(-8999903, str, str2, null);
            }
            Object obj = this.f31291j;
            if (obj != null) {
                ((TTILog) obj).w(str, str2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.wq.j.cw.j
        public void up(String str, String str2) {
            if (this.xt != null) {
                j(-8999905, str, str2, null);
            }
            Object obj = this.f31291j;
            if (obj != null) {
                ((TTILog) obj).e(str, str2);
            }
        }

        public xt(Function<SparseArray<Object>, Object> function) {
            this.xt = function;
        }

        @Override // com.bytedance.sdk.openadsdk.core.wq.j.cw.j
        public void j(String str, String str2, Throwable th) {
            if (this.xt != null) {
                j(-8999903, str, str2, th);
            }
            Object obj = this.f31291j;
            if (obj != null) {
                ((TTILog) obj).w(str, str2, th);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.wq.j.cw.j
        public void xt(String str, String str2, Throwable th) {
            if (this.xt != null) {
                j(-8999905, str, str2, th);
            }
            Object obj = this.f31291j;
            if (obj != null) {
                ((TTILog) obj).e(str, str2, th);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.wq.j.cw.j
        public void j(String str, Throwable th) {
            if (this.xt != null) {
                j(-8999905, str, null, th);
            }
            Object obj = this.f31291j;
            if (obj != null) {
                ((TTILog) obj).e(str, th);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.wq.j.cw.j
        public void j() {
            if (this.xt != null) {
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(-99999987, -8999907);
                sparseArray.put(-99999985, Void.class);
                this.xt.apply(sparseArray);
            }
            Object obj = this.f31291j;
            if (obj != null) {
                ((TTILog) obj).flush();
            }
        }

        private void j(int i6, String str, String str2, Throwable th) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, Integer.valueOf(i6));
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(-8999920, str);
            sparseArray.put(-8999921, str2);
            sparseArray.put(-8999922, th);
            this.xt.apply(sparseArray);
        }
    }

    public static void j(Object obj) {
        Object apply;
        Object apply2;
        try {
            if (!xt(obj)) {
                if (obj != null) {
                    j(null, obj, r(obj), false);
                    return;
                }
                return;
            }
            Function a6 = b.a(obj);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, -8999924);
            sparseArray.put(-99999985, Object.class);
            apply = a6.apply(sparseArray);
            if (apply != null) {
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(-99999987, -8999923);
                sparseArray2.put(-99999985, String.class);
                apply2 = a6.apply(sparseArray2);
                j(a6, apply, (String) apply2, true);
            }
        } catch (Throwable th) {
            vl.xt("HookObject", "register object  " + obj + " failed for: " + th.getMessage());
        }
    }

    public static boolean xt(Object obj) {
        Object apply;
        Boolean bool;
        if (obj == null || !f.a(obj)) {
            return false;
        }
        try {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, -99999986);
            sparseArray.put(-99999985, SparseArray.class);
            apply = b.a(obj).apply(sparseArray);
            SparseArray sparseArray2 = (SparseArray) apply;
            if (sparseArray2 != null && (bool = (Boolean) sparseArray2.get(-99999978)) != null) {
                if (bool.booleanValue()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e6) {
            vl.j(e6);
        }
        return false;
    }

    public static void cw(Object obj) {
        Object apply;
        String str = "";
        try {
            if (xt(obj)) {
                Function a6 = b.a(obj);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(-99999987, -8999923);
                sparseArray.put(-99999985, String.class);
                apply = a6.apply(sparseArray);
                str = (String) apply;
            } else {
                TTC ttc = (TTC) obj.getClass().getAnnotation(TTC.class);
                if (ttc != null) {
                    str = r(ttc);
                }
            }
        } catch (Throwable unused) {
        }
        str.getClass();
        if (str.equals(TKDownloadReason.KSAD_TK_NET)) {
            com.bytedance.sdk.openadsdk.tl.cw.f31846j = null;
        }
    }

    private static String r(Object obj) {
        if (obj == null) {
            return "";
        }
        TTC ttc = obj instanceof Class ? (TTC) ((Class) obj).getAnnotation(TTC.class) : (TTC) obj.getClass().getAnnotation(TTC.class);
        return ttc == null ? "" : ttc.value();
    }

    private static void xt(Function<SparseArray<Object>, Object> function, Object obj, boolean z5) {
        Object apply;
        if (vl.cw()) {
            com.bytedance.sdk.openadsdk.tl.cw cwVar = new com.bytedance.sdk.openadsdk.tl.cw();
            com.bytedance.sdk.openadsdk.tl.cw.f31846j = cwVar;
            try {
                for (Method method : obj.getClass().getDeclaredMethods()) {
                    if (z5) {
                        SparseArray sparseArray = new SparseArray();
                        sparseArray.put(-99999987, -8999909);
                        sparseArray.put(-99999985, Integer.class);
                        sparseArray.put(-8999925, method);
                        apply = function.apply(sparseArray);
                        Integer num = (Integer) apply;
                        if (num != null) {
                            method.setAccessible(true);
                            cwVar.j(num.intValue(), method);
                        }
                    } else {
                        TTM ttm = (TTM) method.getAnnotation(TTM.class);
                        if (ttm != null) {
                            method.setAccessible(true);
                            cwVar.j(ttm.value(), method);
                        }
                    }
                }
            } catch (Throwable th) {
                vl.j(th);
            }
            cwVar.j(obj);
        }
    }

    private static void j(Function<SparseArray<Object>, Object> function, Object obj, String str, boolean z5) {
        if (obj == null) {
            return;
        }
        str.getClass();
        if (str.equals("log")) {
            j(function, obj, z5);
        } else if (str.equals(TKDownloadReason.KSAD_TK_NET)) {
            xt(function, obj, z5);
        }
        vl.xt("HookObject", "register object  " + obj + " successed~ ");
    }

    private static void j(Function<SparseArray<Object>, Object> function, Object obj, boolean z5) {
        try {
            if (z5) {
                LogAdapter.j((j) new xt(function), true);
            } else if (obj instanceof TTILog) {
                LogAdapter.j((j) new xt(obj), true);
            }
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    public static com.bytedance.sdk.openadsdk.tl.xt j(String str) {
        str.getClass();
        if (str.equals(TKDownloadReason.KSAD_TK_NET)) {
            return com.bytedance.sdk.openadsdk.tl.cw.f31846j;
        }
        return null;
    }
}
