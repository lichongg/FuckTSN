package com.umeng.analytics.pro;

import android.content.SharedPreferences;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ae implements aa {

    /* renamed from: a, reason: collision with root package name */
    private String f40828a;

    /* renamed from: b, reason: collision with root package name */
    private long f40829b;

    @Override // com.umeng.analytics.pro.aa
    public boolean a() {
        try {
            String str = ar.f40885b + this.f40828a;
            SharedPreferences a6 = ar.a(UMGlobalContext.getAppContext());
            if (a6 == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis() - a6.getLong(str, 0L);
            if (currentTimeMillis > this.f40829b * 1000) {
                return true;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "internal period skipped. elapse: " + currentTimeMillis + "; config: " + (this.f40829b * 1000));
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.umeng.analytics.pro.aa
    public long c() {
        return 0L;
    }

    public ae(String str, long j6) {
        this.f40828a = str;
        this.f40829b = j6;
    }

    @Override // com.umeng.analytics.pro.aa
    public boolean b() {
        return !a();
    }
}
