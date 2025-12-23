package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class f extends a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f41955a = "imei";

    /* renamed from: b, reason: collision with root package name */
    private Context f41956b;

    public f(Context context) {
        super("imei");
        this.f41956b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfig.getImeiNew(this.f41956b);
    }
}
