package com.huawei.hms.scankit;

import android.os.RemoteException;
import com.huawei.hms.hmsscankit.api.IRemoteCreator;
import com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate;
import com.huawei.hms.hmsscankit.api.IRemoteHmsDecoderDelegate;
import com.huawei.hms.scankit.p.o4;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class Creator extends IRemoteCreator.Stub {
    private static final String TAG = "Creator";
    private e iRemoteViewDelegate = null;
    private f iRemoteDecoderDelegate = null;
    private g iRemoteHmsDecoderDelegate = null;

    @Override // com.huawei.hms.hmsscankit.api.IRemoteCreator
    public IRemoteDecoderDelegate newRemoteDecoderDelegate() throws RemoteException {
        o4.d(TAG, "newRemoteDecoderDelegate()");
        f a6 = f.a();
        this.iRemoteDecoderDelegate = a6;
        return a6;
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteCreator
    public IRemoteHmsDecoderDelegate newRemoteHmsDecoderDelegate() throws RemoteException {
        o4.d(TAG, "newRemoteHmsDecoderDelegate()");
        g a6 = g.a();
        this.iRemoteHmsDecoderDelegate = a6;
        return a6;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c0  */
    @Override // com.huawei.hms.hmsscankit.api.IRemoteCreator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.hms.hmsscankit.api.IRemoteViewDelegate newRemoteViewDelegate(com.huawei.hms.feature.dynamic.IObjectWrapper r14, com.huawei.hms.feature.dynamic.IObjectWrapper r15) throws android.os.RemoteException {
        /*
            Method dump skipped, instructions count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.Creator.newRemoteViewDelegate(com.huawei.hms.feature.dynamic.IObjectWrapper, com.huawei.hms.feature.dynamic.IObjectWrapper):com.huawei.hms.hmsscankit.api.IRemoteViewDelegate");
    }
}
