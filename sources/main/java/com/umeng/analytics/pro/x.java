package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class x implements w {

    /* renamed from: a, reason: collision with root package name */
    private long f41468a = AnalyticsConfig.kContinueSessionMillis;

    @Override // com.umeng.analytics.pro.w
    public void a(long j6) {
        this.f41468a = j6;
    }

    @Override // com.umeng.analytics.pro.w
    public long a() {
        return this.f41468a;
    }

    x() {
    }

    @Override // com.umeng.analytics.pro.w
    public String a(Context context) {
        String appkey = UMUtils.getAppkey(context);
        long currentTimeMillis = System.currentTimeMillis();
        if (appkey != null) {
            return UMUtils.MD5(currentTimeMillis + appkey + "02:00:00:00:00:00");
        }
        throw new RuntimeException("Appkey is null or empty, Please check!");
    }

    @Override // com.umeng.analytics.pro.w
    public boolean a(long j6, long j7) {
        long currentTimeMillis = System.currentTimeMillis();
        return (j6 == 0 || currentTimeMillis - j6 >= this.f41468a) && j7 > 0 && currentTimeMillis - j7 > this.f41468a;
    }

    @Override // com.umeng.analytics.pro.w
    public void a(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(context).edit();
            edit.putString("session_id", str);
            edit.putLong(u.f41449b, 0L);
            edit.putLong(u.f41452e, currentTimeMillis);
            edit.putLong(u.f41453f, 0L);
            edit.commit();
        } catch (Exception unused) {
        }
    }
}
