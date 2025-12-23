package xyz.adscope.ad;

import android.content.Context;
import android.os.Message;
import xyz.adscope.ad.a2;
import xyz.adscope.ad.publish.ad.IAdListener;
import xyz.adscope.common.v2.handle.WeakReferenceHandler;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class v3<C extends a2, L extends IAdListener> extends t2<C, L> {

    /* renamed from: f, reason: collision with root package name */
    private b<C, L> f56020f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b<C extends a2, L extends IAdListener> extends WeakReferenceHandler {

        /* renamed from: a, reason: collision with root package name */
        private v3<C, L> f56021a;

        /* synthetic */ b(Context context, v3 v3Var, a aVar) {
            this(context, v3Var);
        }

        private b(Context context, v3<C, L> v3Var) {
            super(context);
            this.f56021a = v3Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            removeMessages(1);
            this.f56021a = null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // xyz.adscope.common.v2.handle.WeakReferenceHandler
        public void scopeHandleMessage(Message message) {
            v3<C, L> v3Var;
            if (message.what != 1 || (v3Var = this.f56021a) == 0) {
                return;
            }
            v3Var.a((v3<C, L>) message.obj);
        }
    }

    protected void a(L l6) {
        refresh((v3<C, L>) l6);
    }

    private void a(L l6, long j6) {
        b<C, L> bVar = this.f56020f;
        if (bVar != null) {
            bVar.removeMessages(1);
            this.f56020f.sendMessageDelayed(this.f56020f.obtainMessage(1, l6), j6);
        }
    }

    public void refresh(L l6) {
        C c6 = this.f54908b;
        if (!(c6 instanceof u3)) {
            super.a((v3<C, L>) l6);
            return;
        }
        long intervalMillion = ((u3) c6).getIntervalMillion();
        if (intervalMillion <= 0) {
            super.a((v3<C, L>) l6);
            return;
        }
        if (intervalMillion < 10000) {
            intervalMillion = 10000;
        }
        a(l6, intervalMillion);
    }

    public v3(Context context, C c6) {
        super(context, c6);
        this.f56020f = new b<>(context, this, null);
    }

    @Override // xyz.adscope.ad.s2
    public void destroyAd() {
        super.destroyAd();
        b<C, L> bVar = this.f56020f;
        if (bVar != null) {
            bVar.a();
            this.f56020f = null;
        }
    }
}
