package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class g extends a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f41957a = "mac";

    /* renamed from: b, reason: collision with root package name */
    private Context f41958b;

    public g(Context context) {
        super("mac");
        this.f41958b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        try {
            return DeviceConfig.getMac(this.f41958b);
        } catch (Exception e6) {
            if (AnalyticsConstants.UM_DEBUG) {
                e6.printStackTrace();
            }
            UMCrashManager.reportCrash(this.f41958b, e6);
            return null;
        }
    }
}
