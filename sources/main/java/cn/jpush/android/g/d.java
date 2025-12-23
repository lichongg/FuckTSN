package cn.jpush.android.g;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import cn.asus.push.DataBuffer;
import cn.asus.push.IAIDLInvoke;

/* loaded from: D:\Downloads\app\classes2.dex */
public final class d extends a {

    /* renamed from: b, reason: collision with root package name */
    private IAIDLInvoke f3666b = null;

    static /* synthetic */ IAIDLInvoke a(d dVar, IAIDLInvoke iAIDLInvoke) {
        dVar.f3666b = null;
        return null;
    }

    @Override // cn.jpush.android.g.a
    public final void a(String str, String str2) {
        String str3;
        if (this.f3666b != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("JPUSH_CONTENT", str2);
                this.f3666b.d(new DataBuffer(str, bundle), new b());
                return;
            } catch (Throwable th) {
                str3 = "send data fail:" + th;
            }
        } else {
            str3 = "send data fail, please init first.";
        }
        cn.jpush.android.i.b.g("ServiceConnection", str3);
    }

    @Override // cn.jpush.android.g.a
    public final boolean b() {
        IAIDLInvoke iAIDLInvoke = this.f3666b;
        if (iAIDLInvoke == null) {
            return false;
        }
        return iAIDLInvoke.asBinder().isBinderAlive();
    }

    @Override // cn.jpush.android.g.a
    public final boolean a() {
        byte b6 = 0;
        if (a.f3665a.get()) {
            cn.jpush.android.i.b.b("ServiceConnection", "already connecting.");
            return false;
        }
        a.f3665a.set(true);
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(cn.jpush.android.f.c.f3649e, "cn.jpush.android.service.PushManagerService"));
            e eVar = new e(this, b6);
            boolean bindService = cn.jpush.android.f.c.f3645a.bindService(intent, eVar, 1);
            cn.jpush.android.i.b.b("ServiceConnection", "connect--" + bindService);
            if (bindService) {
                this.f3666b = IAIDLInvoke.Stub.e(eVar.f3667a.take());
                return bindService;
            }
            a.f3665a.set(false);
            return bindService;
        } catch (Throwable th) {
            cn.jpush.android.i.b.g("ServiceConnection", "init fail:" + th);
            a.f3665a.set(false);
            return false;
        }
    }
}
