package xyz.adscope.common.v2.dev.oaid.sm.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.IGetter;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.IOAID;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.OAIDException;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.OAIDLog;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.impl.OAIDService;
import xyz.adscope.common.v2.dev.oaid.sm.repeackage.com.bun.lib.MsaIdInterface;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
class MsaImpl implements IOAID {
    private final Context context;

    private void startMsaKlService() {
        try {
            Intent intent = new Intent("com.bun.msa.action.start.service");
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
            intent.putExtra("com.bun.msa.param.pkgname", this.context.getPackageName());
            if (Build.VERSION.SDK_INT < 26) {
                this.context.startService(intent);
            } else {
                this.context.startForegroundService(intent);
            }
        } catch (Exception e6) {
            OAIDLog.print(e6);
        }
    }

    @Override // xyz.adscope.common.v2.dev.oaid.sm.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        startMsaKlService();
        Intent intent = new Intent("com.bun.msa.action.bindto.service");
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.putExtra("com.bun.msa.param.pkgname", this.context.getPackageName());
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller() { // from class: xyz.adscope.common.v2.dev.oaid.sm.oaid.impl.MsaImpl.1
            @Override // xyz.adscope.common.v2.dev.oaid.sm.oaid.impl.OAIDService.RemoteCaller
            public String callRemoteInterface(IBinder iBinder) {
                MsaIdInterface asInterface = MsaIdInterface.Stub.asInterface(iBinder);
                if (asInterface != null) {
                    if (asInterface.isSupported()) {
                        return asInterface.getOAID();
                    }
                    throw new OAIDException("MsaIdInterface#isSupported return false");
                }
                throw new OAIDException("MsaIdInterface is null");
            }
        });
    }

    @Override // xyz.adscope.common.v2.dev.oaid.sm.oaid.IOAID
    public boolean supported() {
        Context context = this.context;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.mdid.msa", 0) != null;
        } catch (Exception e6) {
            OAIDLog.print(e6);
            return false;
        }
    }

    public MsaImpl(Context context) {
        this.context = context;
    }
}
