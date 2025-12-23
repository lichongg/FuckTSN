package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class cp extends j {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ co f10959b;

    cp(co coVar) {
        this.f10959b = coVar;
    }

    @Override // com.baidu.mobads.sdk.internal.j
    protected Object i() {
        String a6;
        String a7;
        Context context;
        String a8;
        try {
            a6 = this.f10959b.a("key_crash_trace");
            a7 = this.f10959b.a("key_crash_ad");
            if (TextUtils.isEmpty(a6)) {
                return null;
            }
            cl a9 = cl.a();
            context = this.f10959b.f10929n;
            a9.a(context);
            a8 = this.f10959b.a("key_crash_source");
            a9.a(a8, a6, a7);
            this.f10959b.g();
            return null;
        } catch (Exception e6) {
            bu.a().a(e6);
            return null;
        }
    }
}
