package xyz.adscope.ad;

import android.content.Context;
import xyz.adscope.ad.a2;
import xyz.adscope.ad.publish.ASNPInitConfig;
import xyz.adscope.common.v2.dev.oaid.OAIDHelper;
import xyz.adscope.common.v2.encrypt.ILinkedEncrypt;
import xyz.adscope.common.v2.encrypt.LinkedEncryptManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class s5 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static s5 f55960a = new s5(null);
    }

    /* synthetic */ s5(a aVar) {
        this();
    }

    public static s5 a() {
        return b.f55960a;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class c extends a2 {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static class a extends a2.a<c> {
            @Override // xyz.adscope.ad.a2.a
            protected xyz.adscope.ad.c a() {
                return xyz.adscope.ad.c.S2S;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // xyz.adscope.ad.a2.a
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public c f(a2.a<c> aVar) {
                return new c(this);
            }

            @Override // xyz.adscope.ad.a2.a
            public a2.a<c> setTimeoutMillion(long j6) {
                return super.setTimeoutMillion(j6);
            }
        }

        protected c(a aVar) {
            super(aVar);
        }
    }

    private s5() {
        if (b.f55960a != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    private void a(Context context, ASNPInitConfig aSNPInitConfig) {
        if (aSNPInitConfig != null) {
            if (aSNPInitConfig.canUseOAIDInfo()) {
                OAIDHelper.getInstance().initOAID(context);
            }
            OAIDHelper.getInstance().setPersonalRecommend(aSNPInitConfig.canUseOAIDInfo());
        }
    }

    public String a(Context context, String str) {
        z0 z0Var = new z0(context);
        ASNPInitConfig a6 = f.a().getOrCreateImplement(context).a();
        a(context, a6);
        if (a6 != null) {
            c.a aVar = new c.a();
            aVar.setTimeoutMillion(5000L);
            c build = aVar.build(str);
            z0Var.a(build, a6, xyz.adscope.ad.c.S2S, new b1(build).t());
            return LinkedEncryptManager.getInstance().getOrCreateImplement(context).encrypt(z0Var.a(), "101,1001", ILinkedEncrypt.B64Model.STEP_BY_STEP, true);
        }
        return "";
    }
}
