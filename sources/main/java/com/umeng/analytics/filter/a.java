package com.umeng.analytics.filter;

import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a extends EventList {

    /* renamed from: a, reason: collision with root package name */
    private d f40805a;

    /* renamed from: b, reason: collision with root package name */
    private Object f40806b;

    @Override // com.umeng.analytics.filter.EventList
    protected void eventListChange() {
        if (TextUtils.isEmpty(this.mEventList)) {
            return;
        }
        synchronized (this.f40806b) {
            this.f40805a = null;
            this.f40805a = new d(false, this.mEventList);
        }
    }

    @Override // com.umeng.analytics.filter.EventList
    public boolean matchHit(String str) {
        boolean a6;
        if (TextUtils.isEmpty(this.mEventList)) {
            return false;
        }
        synchronized (this.f40806b) {
            try {
                if (this.f40805a == null) {
                    this.f40805a = new d(false, this.mEventList);
                }
                a6 = this.f40805a.a(str);
            } catch (Throwable th) {
                throw th;
            }
        }
        return a6;
    }

    @Override // com.umeng.analytics.filter.EventList
    public void setMD5ClearFlag(boolean z5) {
        AnalyticsConfig.CLEAR_EKV_BL = z5;
    }

    public a(String str, String str2) {
        super(str, str2);
        this.f40806b = new Object();
    }
}
