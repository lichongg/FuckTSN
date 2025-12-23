package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.internal.bj;
import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class bm implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IOAdEvent f10743a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ bj.a f10744b;

    @Override // java.lang.Runnable
    public void run() {
        HashMap hashMap;
        String str;
        String str2;
        int i6 = 0;
        int i7 = 0;
        r0 = false;
        boolean z5 = false;
        IOAdEvent iOAdEvent = this.f10743a;
        if (iOAdEvent == null || TextUtils.isEmpty(iOAdEvent.getType())) {
            return;
        }
        String type = this.f10743a.getType();
        if (z.I.equals(type)) {
            bj.this.a(this.f10743a);
            return;
        }
        if (z.L.equals(type)) {
            bj.this.f10736p = this.f10743a.getMessage();
            bj.this.q();
            return;
        }
        if (z.M.equals(type)) {
            bj.this.e(this.f10743a);
            return;
        }
        if (z.N.equals(type)) {
            bj.this.f(this.f10743a);
            return;
        }
        if (z.V.equals(type)) {
            bj.this.g(this.f10743a);
            return;
        }
        String str3 = "";
        if (z.f11227q.equals(type)) {
            HashMap hashMap2 = (HashMap) this.f10743a.getData();
            if (hashMap2 != null) {
                str3 = (String) hashMap2.get("error_message");
                Object obj = hashMap2.get("error_code");
                i6 = ((Integer) (obj != null ? obj : 0)).intValue();
                bj.this.f10730j = (String) hashMap2.get(bj.f10725e);
                str2 = bj.this.f10730j;
            } else {
                str2 = "";
            }
            bj.this.a(str3, i6, str2);
            return;
        }
        if (z.K.equals(type)) {
            HashMap hashMap3 = (HashMap) this.f10743a.getData();
            if (hashMap3 != null) {
                str3 = (String) hashMap3.get("error_message");
                Object obj2 = hashMap3.get("error_code");
                i7 = ((Integer) (obj2 != null ? obj2 : 0)).intValue();
                bj.this.f10730j = (String) hashMap3.get(bj.f10725e);
                str = bj.this.f10730j;
            } else {
                str = "";
            }
            bj.this.a(i7, str3, str);
            return;
        }
        if (z.G.equals(type)) {
            bj.this.h(this.f10743a);
            return;
        }
        if (z.W.equals(type)) {
            bj.this.d();
            return;
        }
        if (z.X.equals(type)) {
            bj.this.d(this.f10743a);
            return;
        }
        if (z.Z.equals(type)) {
            bj.this.s();
            return;
        }
        if (z.aa.equals(type)) {
            IOAdEvent iOAdEvent2 = this.f10743a;
            if (iOAdEvent2 != null && (hashMap = (HashMap) iOAdEvent2.getData()) != null) {
                z5 = "1".equals((String) hashMap.get("serverVerify"));
            }
            bj.this.b(z5);
            return;
        }
        if (z.ab.equals(type)) {
            bj.this.b();
            return;
        }
        if (z.ac.equals(type)) {
            bj.this.c();
            return;
        }
        if (z.ad.equals(type)) {
            bj.this.c();
            return;
        }
        if (z.J.equals(type)) {
            bj.this.b(this.f10743a);
            return;
        }
        if (z.ae.equals(type)) {
            bj.this.a(this.f10743a.getMessage(), 1 == this.f10743a.getCode());
            return;
        }
        if (z.af.equals(type)) {
            bj.this.e(this.f10743a.getMessage());
            return;
        }
        if (z.ag.equals(type)) {
            bj.this.f(this.f10743a.getMessage());
            return;
        }
        if (z.ah.equals(type)) {
            bj.this.d(this.f10743a.getMessage());
            return;
        }
        if (z.C.equals(type)) {
            bj.this.g(this.f10743a.getMessage());
            return;
        }
        if (z.Y.equals(type)) {
            bj.this.t();
            return;
        }
        if (z.ai.equals(type)) {
            bj.this.b(this.f10743a.getMessage(), 1 == this.f10743a.getCode());
            return;
        }
        if (z.al.equals(type)) {
            bj.this.c(this.f10743a);
            return;
        }
        if (z.aj.equals(type)) {
            bj.this.u();
            return;
        }
        if (z.ak.equals(type)) {
            bj.this.v();
            return;
        }
        if (z.an.equals(type)) {
            bj.this.i(this.f10743a);
        } else if (z.ao.equals(type)) {
            bj.this.j(this.f10743a);
        } else if (z.am.equals(type)) {
            bj.this.k(this.f10743a);
        }
    }

    bm(bj.a aVar, IOAdEvent iOAdEvent) {
        this.f10744b = aVar;
        this.f10743a = iOAdEvent;
    }
}
