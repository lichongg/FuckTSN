package com.huawei.hms.scankit;

import android.os.RemoteException;
import com.huawei.hms.hmsscankit.api.IRemoteDecoderCreator;
import com.huawei.hms.hmsscankit.api.IRemoteFrameDecoderDelegate;
import com.huawei.hms.scankit.p.h4;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class DecoderCreator extends IRemoteDecoderCreator.Stub {
    @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderCreator
    public IRemoteFrameDecoderDelegate newRemoteFrameDecoderDelegate() throws RemoteException {
        return h4.a();
    }
}
