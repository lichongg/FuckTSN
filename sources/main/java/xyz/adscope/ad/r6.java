package xyz.adscope.ad;

import android.content.Context;
import android.view.View;
import xyz.adscope.ad.n3;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class r6 extends g1 {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        a(n3.a.CLICK_INTERACTIVE_TRIGGER);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // xyz.adscope.ad.g1, xyz.adscope.ad.i3
    public void a(View view, c cVar) {
        super.a(view, cVar);
        if (view != 0) {
            view.setOnClickListener(new View.OnClickListener() { // from class: xyz.adscope.ad.v7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    r6.this.a(view2);
                }
            });
            if (view instanceof b3) {
                ((b3) view).a(new l3() { // from class: xyz.adscope.ad.w7
                    @Override // xyz.adscope.ad.l3
                    public final void a(View view2) {
                        r6.this.b(view2);
                    }
                });
            }
        }
    }

    public r6(Context context, String str) {
        super(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        a(n3.a.CLICK_INTERACTIVE_TRIGGER);
    }

    @Override // xyz.adscope.ad.g1
    protected void d() {
    }
}
