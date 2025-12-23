package com.umeng.commonsdk.statistics.idtracking;

import android.annotation.TargetApi;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class i extends a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f41964a = "serial";

    public i() {
        super(f41964a);
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    @TargetApi(9)
    public String f() {
        return DeviceConfig.getSerial();
    }
}
