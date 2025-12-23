package com.huawei.agconnect.config.impl;

import android.content.Context;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes5.dex */
class m extends l {

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, String> f32948c;

    /* renamed from: d, reason: collision with root package name */
    private final Object f32949d;

    /* renamed from: e, reason: collision with root package name */
    private i f32950e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f32951f;

    /* renamed from: g, reason: collision with root package name */
    private final String f32952g;

    private String a(String str) {
        return super.a(str, null);
    }

    @Override // com.huawei.agconnect.config.impl.l, com.huawei.agconnect.config.impl.f
    public String a(String str, String str2) {
        if (!this.f32951f) {
            String a6 = a(str);
            return a6 != null ? a6 : str2;
        }
        if (this.f32950e == null) {
            return str2;
        }
        synchronized (this.f32949d) {
            try {
                String str3 = this.f32948c.get(str);
                if (str3 != null) {
                    return str3;
                }
                String a7 = a(str);
                if (a7 != null) {
                    str2 = this.f32950e.a(a7, str2);
                    this.f32948c.put(str, str2);
                }
                return str2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String toString() {
        return "SecurityResourcesReader{mKey=, encrypt=" + this.f32951f + '}';
    }

    m(Context context, String str) {
        super(context, str);
        this.f32948c = new HashMap();
        this.f32949d = new Object();
        this.f32951f = true;
        this.f32952g = str;
        try {
            String a6 = a("/AD91D45E3E72DB6989DDCB13287E75061FABCB933D886E6C6ABEF0939B577138");
            String a7 = a("/B314B3BF013DF5AC4134E880AF3D2B7C9FFBE8F0305EAC1C898145E2BCF1F21C");
            String a8 = a("/C767BD8FDF53E53D059BE95B09E2A71056F5F180AECC62836B287ACA5793421B");
            String a9 = a("/DCB3E6D4C2CF80F30D89CDBC412C964DA8381BB84668769391FBCC3E329AD0FD");
            if (a6 != null && a7 != null && a8 != null && a9 != null) {
                this.f32950e = new h(a6, a7, a8, a9);
            } else {
                this.f32951f = false;
            }
        } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException unused) {
            this.f32950e = null;
        }
    }
}
