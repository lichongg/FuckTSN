package com.baidu.mobads.sdk.internal;

import android.content.SharedPreferences;
import android.os.Handler;
import com.baidu.mobads.sdk.internal.ca;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class ci extends j {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ca.c f10872b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Handler f10873c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ca f10874d;

    ci(ca caVar, ca.c cVar, Handler handler) {
        this.f10874d = caVar;
        this.f10872b = cVar;
        this.f10873c = handler;
    }

    @Override // com.baidu.mobads.sdk.internal.j
    protected Object i() {
        bu buVar;
        SharedPreferences m6;
        bu buVar2;
        SharedPreferences m7;
        SharedPreferences.Editor edit;
        bu buVar3;
        SharedPreferences m8;
        try {
            try {
                synchronized (ca.class) {
                    this.f10874d.b(this.f10872b, this.f10873c);
                }
                m8 = this.f10874d.m();
                edit = m8.edit();
                edit.putString(ca.f10838d, this.f10874d.a());
            } catch (Throwable th) {
                try {
                    String str = "Load APK Failed: " + th.toString();
                    buVar2 = this.f10874d.f10860z;
                    buVar2.a(ca.f10835a, str);
                    this.f10874d.b(false);
                    m7 = this.f10874d.m();
                    edit = m7.edit();
                    edit.putString(ca.f10838d, this.f10874d.a());
                } catch (Throwable th2) {
                    try {
                        m6 = this.f10874d.m();
                        SharedPreferences.Editor edit2 = m6.edit();
                        edit2.putString(ca.f10838d, this.f10874d.a());
                        edit2.apply();
                    } catch (Throwable th3) {
                        buVar = this.f10874d.f10860z;
                        buVar.a(ca.f10835a, th3);
                    }
                    throw th2;
                }
            }
            edit.apply();
            return null;
        } catch (Throwable th4) {
            buVar3 = this.f10874d.f10860z;
            buVar3.a(ca.f10835a, th4);
            return null;
        }
    }
}
