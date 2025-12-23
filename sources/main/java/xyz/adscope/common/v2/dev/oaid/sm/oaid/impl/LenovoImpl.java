package xyz.adscope.common.v2.dev.oaid.sm.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.IGetter;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.IOAID;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.OAIDException;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.OAIDLog;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.impl.OAIDService;
import xyz.adscope.common.v2.dev.oaid.sm.repeackage.com.zui.deviceidservice.IDeviceidInterface;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
class LenovoImpl implements IOAID {
    private final Context context;

    @Override // xyz.adscope.common.v2.dev.oaid.sm.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller() { // from class: xyz.adscope.common.v2.dev.oaid.sm.oaid.impl.LenovoImpl.1
            @Override // xyz.adscope.common.v2.dev.oaid.sm.oaid.impl.OAIDService.RemoteCaller
            public String callRemoteInterface(IBinder iBinder) {
                IDeviceidInterface asInterface = IDeviceidInterface.Stub.asInterface(iBinder);
                if (asInterface != null) {
                    if (asInterface.isSupport()) {
                        return asInterface.getOAID();
                    }
                    throw new OAIDException("IDeviceidInterface#isSupport return false");
                }
                throw new OAIDException("IDeviceidInterface is null");
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
            return context.getPackageManager().getPackageInfo("com.zui.deviceidservice", 0) != null;
        } catch (Exception e6) {
            OAIDLog.print(e6);
            return false;
        }
    }

    public LenovoImpl(Context context) {
        this.context = context;
    }
}
