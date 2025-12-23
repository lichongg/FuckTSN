package xyz.adscope.common.v2.dev.oaid.sm.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.IGetter;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.IOAID;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.OAIDException;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.OAIDLog;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.impl.OAIDService;
import xyz.adscope.common.v2.dev.oaid.sm.repeackage.com.android.creator.IdsSupplier;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class FreemeImpl implements IOAID {
    private final Context context;

    @Override // xyz.adscope.common.v2.dev.oaid.sm.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent("android.service.action.msa");
        intent.setPackage("com.android.creator");
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller() { // from class: xyz.adscope.common.v2.dev.oaid.sm.oaid.impl.FreemeImpl.1
            @Override // xyz.adscope.common.v2.dev.oaid.sm.oaid.impl.OAIDService.RemoteCaller
            public String callRemoteInterface(IBinder iBinder) {
                IdsSupplier asInterface = IdsSupplier.Stub.asInterface(iBinder);
                if (asInterface != null) {
                    return asInterface.getOAID();
                }
                throw new OAIDException("IdsSupplier is null");
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
            return context.getPackageManager().getPackageInfo("com.android.creator", 0) != null;
        } catch (Exception e6) {
            OAIDLog.print(e6);
            return false;
        }
    }

    public FreemeImpl(Context context) {
        this.context = context;
    }
}
