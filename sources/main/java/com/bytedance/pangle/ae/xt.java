package com.bytedance.pangle.ae;

import android.os.RemoteException;
import com.bytedance.pangle.ZeusPluginInstallListener;
import com.bytedance.pangle.r;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt extends r.j {

    /* renamed from: j, reason: collision with root package name */
    private final ZeusPluginInstallListener f25385j;

    @Override // com.bytedance.pangle.r
    public void j(String str, int i6, String str2) throws RemoteException {
        ZeusPluginInstallListener zeusPluginInstallListener = this.f25385j;
        if (zeusPluginInstallListener != null) {
            zeusPluginInstallListener.onPluginInstall(str, i6, str2);
        }
    }

    public xt(ZeusPluginInstallListener zeusPluginInstallListener) {
        this.f25385j = zeusPluginInstallListener;
    }
}
