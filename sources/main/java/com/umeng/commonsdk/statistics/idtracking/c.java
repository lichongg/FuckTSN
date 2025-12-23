package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c extends a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f41939a = "idfa";

    /* renamed from: b, reason: collision with root package name */
    private Context f41940b;

    public c(Context context) {
        super(f41939a);
        this.f41940b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfig.getIdfa(this.f41940b);
    }
}
