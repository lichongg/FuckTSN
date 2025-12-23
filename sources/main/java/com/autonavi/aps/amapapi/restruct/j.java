package com.autonavi.aps.amapapi.restruct;

import android.net.wifi.WifiInfo;
import android.text.TextUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private WifiInfo f10090a;

    /* renamed from: b, reason: collision with root package name */
    private String f10091b;

    /* renamed from: c, reason: collision with root package name */
    private String f10092c;

    /* renamed from: d, reason: collision with root package name */
    private int f10093d = -1;

    public final String a() {
        if (this.f10092c == null) {
            this.f10092c = h.a(this.f10090a);
        }
        return this.f10092c;
    }

    public final String b() {
        if (this.f10091b == null) {
            this.f10091b = h.b(this.f10090a);
        }
        return this.f10091b;
    }

    public final int c() {
        if (this.f10093d == -1) {
            this.f10093d = h.c(this.f10090a);
        }
        return this.f10093d;
    }

    public final boolean d() {
        return (this.f10090a == null || TextUtils.isEmpty(b()) || !com.autonavi.aps.amapapi.utils.j.a(a())) ? false : true;
    }

    public j(WifiInfo wifiInfo) {
        this.f10090a = wifiInfo;
    }
}
