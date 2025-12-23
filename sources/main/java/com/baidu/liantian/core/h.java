package com.baidu.liantian.core;

import android.content.IntentFilter;
import android.text.TextUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public String f10447a;

    /* renamed from: b, reason: collision with root package name */
    public String f10448b;

    /* renamed from: c, reason: collision with root package name */
    public String f10449c;

    /* renamed from: d, reason: collision with root package name */
    public IntentFilter f10450d;

    public final boolean a(h hVar) {
        if (hVar != null) {
            try {
                if (!TextUtils.isEmpty(hVar.f10447a) && !TextUtils.isEmpty(hVar.f10448b) && !TextUtils.isEmpty(hVar.f10449c) && hVar.f10447a.equals(this.f10447a) && hVar.f10448b.equals(this.f10448b) && hVar.f10449c.equals(this.f10449c)) {
                    IntentFilter intentFilter = hVar.f10450d;
                    if (intentFilter != null) {
                        IntentFilter intentFilter2 = this.f10450d;
                        return intentFilter2 == null || intentFilter2 == intentFilter;
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                com.baidu.liantian.b.e.a();
            }
        }
        return false;
    }

    public final String toString() {
        try {
            return "PluginloaderIntentFilter:" + this.f10447a + "-" + this.f10448b + "-" + this.f10449c + "-" + this.f10450d;
        } catch (Throwable unused) {
            return "";
        }
    }

    public h(String str, IntentFilter intentFilter, String str2, String str3) {
        this.f10447a = str;
        this.f10450d = intentFilter;
        this.f10448b = str2;
        this.f10449c = str3;
    }
}
