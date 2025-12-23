package com.qq.e.ads.hybrid;

import android.content.Context;
import com.qq.e.ads.AbstractAD;
import com.qq.e.comm.pi.HADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class HybridAD extends AbstractAD<HADI> implements HADI {

    /* renamed from: h, reason: collision with root package name */
    private HybridADListener f36604h;

    /* renamed from: i, reason: collision with root package name */
    private CountDownLatch f36605i = new CountDownLatch(1);

    /* renamed from: j, reason: collision with root package name */
    private HybridADSetting f36606j;

    public HybridAD(Context context, HybridADSetting hybridADSetting, HybridADListener hybridADListener) {
        this.f36606j = hybridADSetting;
        this.f36604h = hybridADListener;
        a(context, "NO_POS_ID");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.ads.AbstractAD
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public HADI a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getHybridAD(this.f36606j, this.f36604h);
    }

    @Override // com.qq.e.comm.pi.HADI
    public void loadUrl(final String str) {
        if (!a()) {
            return;
        }
        if (b()) {
            T t5 = this.f36545a;
            if (t5 != 0) {
                ((HADI) t5).loadUrl(str);
                return;
            } else {
                a("loadUrl");
                return;
            }
        }
        new Thread(new Runnable() { // from class: com.qq.e.ads.hybrid.HybridAD.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    HybridAD.this.f36605i.await(30L, TimeUnit.SECONDS);
                    if (HybridAD.this.b() && ((AbstractAD) HybridAD.this).f36545a != null) {
                        ((HADI) ((AbstractAD) HybridAD.this).f36545a).loadUrl(str);
                    } else {
                        GDTLogger.e("初始化错误：广告实例未被初始化");
                        HybridAD.this.a(2001);
                    }
                } catch (InterruptedException unused) {
                    GDTLogger.e("初始化错误：广告实例未被初始化");
                    HybridAD.this.a(2001);
                }
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.ads.AbstractAD
    public void a(HADI hadi) {
        this.f36605i.countDown();
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void b(int i6) {
        HybridADListener hybridADListener = this.f36604h;
        if (hybridADListener != null) {
            hybridADListener.onError(AdErrorConvertor.formatErrorCode(i6));
        }
        this.f36605i.countDown();
    }
}
