package com.umeng.analytics.pro;

import android.content.SharedPreferences;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class af implements aa {

    /* renamed from: a, reason: collision with root package name */
    private int f40830a;

    @Override // com.umeng.analytics.pro.aa
    public boolean a() {
        long j6 = 0;
        try {
            SharedPreferences a6 = ar.a(UMGlobalContext.getAppContext());
            if (a6 != null) {
                j6 = a6.getLong(ar.f40884a, 0L);
                if (j6 >= this.f40830a) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "launch times skipped. times: " + j6 + " ; config: " + this.f40830a);
        return false;
    }

    @Override // com.umeng.analytics.pro.aa
    public long c() {
        return 0L;
    }

    public af(int i6) {
        this.f40830a = i6;
    }

    @Override // com.umeng.analytics.pro.aa
    public boolean b() {
        return !a();
    }
}
