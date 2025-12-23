package com.umeng.analytics.pro;

import android.content.Context;
import org.repackage.com.zui.opendeviceidlibrary.OpenDeviceId;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ba implements av {

    /* renamed from: a, reason: collision with root package name */
    private static final int f40948a = 1;

    /* renamed from: b, reason: collision with root package name */
    private OpenDeviceId f40949b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f40950c = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f40951d = false;

    @Override // com.umeng.analytics.pro.av
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.f40950c) {
            OpenDeviceId openDeviceId = new OpenDeviceId();
            this.f40949b = openDeviceId;
            this.f40951d = openDeviceId.a(context, (OpenDeviceId.CallBack<String>) null) == 1;
            this.f40950c = true;
        }
        bh.a("getOAID", "isSupported", Boolean.valueOf(this.f40951d));
        if (this.f40951d && this.f40949b.c()) {
            return this.f40949b.a();
        }
        return null;
    }
}
