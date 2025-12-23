package com.bytedance.pangle.ae;

import android.os.RemoteException;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.r;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw extends ZeusPluginStateListener {

    /* renamed from: j, reason: collision with root package name */
    private final r f25375j;
    private final int xt;

    @Override // com.bytedance.pangle.ZeusPluginStateListener
    public void onStateChangeOnCurThread(String str, int i6, Object... objArr) {
        if (i6 == 5 || i6 == 7 || i6 == 6) {
            String str2 = "";
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        str2 = String.valueOf(objArr[0]);
                    }
                } catch (RemoteException unused) {
                    return;
                }
            }
            this.f25375j.j(str, i6, str2);
        }
    }

    public int j() {
        return this.xt;
    }

    public cw(r rVar, int i6) {
        this.f25375j = rVar;
        this.xt = i6;
    }
}
