package com.qq.e.ads;

import com.qq.e.comm.pi.IBiddingLoss;
import com.qq.e.comm.util.AdError;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class NativeAbstractAD<T extends IBiddingLoss> extends AbstractAD<T> implements IBiddingLoss {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface BasicADListener {
        void onNoAD(AdError adError);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.ads.AbstractAD
    public void a(T t5) {
    }

    @Override // com.qq.e.comm.pi.IBiddingLoss
    public void sendLossNotification(Map<String, Object> map) {
        ((IBiddingLoss) this.f36545a).sendLossNotification(map);
    }
}
