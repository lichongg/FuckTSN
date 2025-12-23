package com.umeng.analytics.filter;

import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b extends EventList {

    /* renamed from: a, reason: collision with root package name */
    private d f40807a;

    /* renamed from: b, reason: collision with root package name */
    private Object f40808b;

    @Override // com.umeng.analytics.filter.EventList
    protected void eventListChange() {
        if (TextUtils.isEmpty(this.mEventList)) {
            return;
        }
        synchronized (this.f40808b) {
            this.f40807a = null;
            this.f40807a = new d(true, this.mEventList);
        }
    }

    @Override // com.umeng.analytics.filter.EventList
    public boolean matchHit(String str) {
        boolean a6;
        if (TextUtils.isEmpty(this.mEventList)) {
            return true;
        }
        synchronized (this.f40808b) {
            try {
                if (this.f40807a == null) {
                    this.f40807a = new d(true, this.mEventList);
                }
                a6 = this.f40807a.a(str);
            } catch (Throwable th) {
                throw th;
            }
        }
        return a6;
    }

    @Override // com.umeng.analytics.filter.EventList
    public void setMD5ClearFlag(boolean z5) {
        AnalyticsConfig.CLEAR_EKV_WL = z5;
    }

    public b(String str, String str2) {
        super(str, str2);
        this.f40808b = new Object();
    }
}
