package xyz.adscope.ad;

import android.content.DialogInterface;
import android.view.View;
import xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a;
import xyz.adscope.ad.t5;
import xyz.adscope.ad.y1;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class r0 extends z1 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements t5.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f55924a;

        a(View view) {
            this.f55924a = view;
        }

        @Override // xyz.adscope.ad.t5.e
        public void a(String str) {
            r0.this.a(this.f55924a, str);
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
        }
    }

    @Override // xyz.adscope.ad.w2
    public void a(View view, int i6) {
        new t5.b(view.getContext()).a(new a(view)).a().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(View view, String str) {
        xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a aVar;
        if (view instanceof j3) {
            aVar = ((j3) view).getExpressRoot();
        } else {
            aVar = (xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a) view.getTag(ResIdentify.getIDIdentify(this.f56208e, "scope_root_container"));
        }
        if (aVar != null) {
            a.c.a(aVar, str);
        }
        this.f56204a.a(y1.a.COMPLAIN_CONFIRM, view);
    }
}
