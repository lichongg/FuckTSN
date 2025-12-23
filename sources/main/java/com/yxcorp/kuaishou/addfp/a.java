package com.yxcorp.kuaishou.addfp;

import android.content.Context;
import android.os.Build;
import com.yxcorp.kuaishou.addfp.android.a.c;
import com.yxcorp.kuaishou.addfp.android.b.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ KWEGIDDFP f42914a;

    a(KWEGIDDFP kwegiddfp) {
        this.f42914a = kwegiddfp;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        String str;
        ResponseDfpCallback responseDfpCallback;
        ResponseDfpCallback responseDfpCallback2;
        Context unused;
        try {
            context = this.f42914a.mParamContext;
            if (context == null) {
                responseDfpCallback2 = this.f42914a.mCallBack;
                responseDfpCallback2.onFailed(-3, "parameter error");
                return;
            }
            unused = this.f42914a.mParamContext;
            int i6 = e.f42934c;
            if (Build.VERSION.SDK_INT >= 28) {
                e.a();
            }
            KWEGIDDFP kwegiddfp = this.f42914a;
            context2 = kwegiddfp.mParamContext;
            kwegiddfp.mPkgName = context2.getPackageName();
            c c6 = c.c();
            str = this.f42914a.mPkgName;
            c6.b(str);
            KWEGIDDFP kwegiddfp2 = this.f42914a;
            responseDfpCallback = kwegiddfp2.mCallBack;
            kwegiddfp2.getEGid(responseDfpCallback);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
