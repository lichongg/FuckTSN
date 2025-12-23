package xyz.adscope.ad.publish;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import xyz.adscope.ad.f0;
import xyz.adscope.ad.o;
import xyz.adscope.ad.s;
import xyz.adscope.ad.t1;
import xyz.adscope.common.v2.log.SDKLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class ASNPAdSDK {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.ad.publish.ASNPAdSDK$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class InnerCallback implements IInitCallback {

        /* renamed from: a, reason: collision with root package name */
        private final IInitCallback f55809a;

        @Override // xyz.adscope.ad.publish.IInitCallback
        public void alreadyInit() {
            IInitCallback iInitCallback = this.f55809a;
            if (iInitCallback != null) {
                iInitCallback.alreadyInit();
            }
        }

        @Override // xyz.adscope.ad.publish.IInitCallback
        public void initFailed(int i6, String str) {
            IInitCallback iInitCallback = this.f55809a;
            if (iInitCallback != null) {
                iInitCallback.initFailed(i6, str);
            }
        }

        @Override // xyz.adscope.ad.publish.IInitCallback
        public void initSuccess() {
            IInitCallback iInitCallback = this.f55809a;
            if (iInitCallback != null) {
                iInitCallback.initSuccess();
            }
        }

        @Override // xyz.adscope.ad.publish.IInitCallback
        public void initializing() {
            IInitCallback iInitCallback = this.f55809a;
            if (iInitCallback != null) {
                iInitCallback.initializing();
            }
        }

        InnerCallback(IInitCallback iInitCallback) {
            this.f55809a = iInitCallback;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class InstanceHolder {

        /* renamed from: a, reason: collision with root package name */
        private static ASNPAdSDK f55810a = new ASNPAdSDK(null);

        private InstanceHolder() {
        }
    }

    /* synthetic */ ASNPAdSDK(AnonymousClass1 anonymousClass1) {
        this();
    }

    private void a(IInitCallback iInitCallback, o oVar) {
        if (iInitCallback != null) {
            if (oVar == o.INIT_DONE) {
                iInitCallback.initSuccess();
            } else if (oVar == o.ALREADY_INIT) {
                iInitCallback.alreadyInit();
            } else {
                iInitCallback.initFailed(oVar.b(), oVar.c());
            }
        }
    }

    private ASNPAdSDK() {
        if (InstanceHolder.f55810a != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    public void init(Context context, ASNPInitConfig aSNPInitConfig, IInitCallback iInitCallback) {
        InnerCallback innerCallback = new InnerCallback(iInitCallback);
        SDKLog.i("ASNPAdSDK", "ASNP 版本 " + f0.c());
        try {
            SDKLog.i("ASNPAdSDK", "Common库 版本 5.2.1.3");
            if (!a(aSNPInitConfig)) {
                a(innerCallback, o.ERROR_CONFIG_APP_ID);
                return;
            }
            SDKLog.i("ASNPAdSDK", String.format("ASNP 初始化... appID:%s", aSNPInitConfig.getAppId()));
            t1 orCreateImplement = s.a().getOrCreateImplement(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            if (orCreateImplement.a()) {
                a(innerCallback, o.ALREADY_INIT);
            } else {
                orCreateImplement.a(aSNPInitConfig, innerCallback);
            }
        } catch (Throwable unused) {
            a(innerCallback, o.ERROR_SDK_SUPPORT_CLASS_MISSED);
        }
    }

    public static ASNPAdSDK getInstance() {
        return InstanceHolder.f55810a;
    }

    public String getSDKVersionName() {
        return f0.c();
    }

    private boolean a(ASNPInitConfig aSNPInitConfig) {
        if (aSNPInitConfig != null) {
            return !TextUtils.isEmpty(aSNPInitConfig.getAppId());
        }
        return false;
    }
}
