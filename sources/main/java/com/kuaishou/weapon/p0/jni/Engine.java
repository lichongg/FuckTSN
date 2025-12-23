package com.kuaishou.weapon.p0.jni;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.bh;
import com.kuaishou.weapon.p0.bp;
import com.kuaishou.weapon.p0.bq;
import com.kuaishou.weapon.p0.ck;
import com.kuaishou.weapon.p0.df;
import com.kuaishou.weapon.p0.h;
import com.kuaishou.weapon.p0.t;
import java.lang.reflect.Member;
import java.util.HashMap;

/* loaded from: D:\Downloads\app\classes6.dex */
public class Engine {
    private static volatile Engine instance;
    public static volatile int loadSoCount;
    public static volatile boolean loadSuccess;
    public static volatile String soPath;
    public static volatile String soVersion;

    public static native String abc();

    public static native String bcd();

    public static native int mmo(Member member, int i6, int i7);

    public static native int mqc(Member member, int i6);

    public static native int off();

    public static native String tao(int i6, long j6, Object obj);

    public native byte[] ac(byte[] bArr, byte[] bArr2);

    public native byte[] ar(byte[] bArr, byte[] bArr2);

    public native String cde();

    public native byte[] dc(byte[] bArr, byte[] bArr2);

    public native String def();

    public native byte[] dr(byte[] bArr, byte[] bArr2);

    public native String efg();

    public native String eopq(int i6, int i7, int i8, String str);

    public native String fgh();

    public native String ghi();

    public native String hij();

    public native String klm(int i6, String str);

    public native String nop();

    public native String pqr(int i6, int i7, int i8, String str);

    public native String qrs();

    public native String stu(int i6, int i7, int i8, int i9, String str);

    public static synchronized Engine getInstance(Context context) {
        synchronized (Engine.class) {
            try {
                if (!TextUtils.isEmpty(soVersion) && !loadSuccess && instance == null) {
                    if (instance == null) {
                        instance = new Engine();
                    }
                    h a6 = h.a(context, "re_po_rt");
                    try {
                    } catch (Throwable th) {
                        loadSuccess = false;
                        try {
                            HashMap hashMap = new HashMap();
                            hashMap.put("e", th.getMessage());
                            hashMap.put("v", soVersion);
                            hashMap.put(t.f36143d, ck.f35880m);
                            bh.a(context, ck.f35868a, hashMap);
                        } catch (Exception unused) {
                        }
                    }
                    if (!bp.a(context, bq.f35803d + soVersion.replace(".", "") + ".so")) {
                        loadSuccess = false;
                        return instance;
                    }
                    String b6 = a6.b(df.f35993f, "");
                    if (TextUtils.isEmpty(b6)) {
                        b6 = soVersion;
                        a6.c(df.f35993f, b6, false);
                    }
                    loadSoCount = a6.c(df.bg);
                    if (!TextUtils.equals(b6, soVersion)) {
                        String str = soVersion;
                        loadSoCount = 0;
                        a6.c(df.f35993f, str, false);
                    }
                    if (loadSoCount + 1 < 10) {
                        loadSoCount++;
                        a6.d(df.bg, loadSoCount);
                        System.loadLibrary(bq.f35803d + soVersion.replace(".", ""));
                        bcd();
                        loadSoCount = 0;
                        loadSuccess = true;
                    }
                    a6.d(df.bg, loadSoCount);
                }
                return instance;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
