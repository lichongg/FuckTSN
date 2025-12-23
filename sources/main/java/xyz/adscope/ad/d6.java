package xyz.adscope.ad;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a;
import xyz.adscope.ad.b4;
import xyz.adscope.ad.l6;
import xyz.adscope.amps.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class d6 extends y5 {

    /* renamed from: l, reason: collision with root package name */
    private l6 f55084l;

    private void a(ViewGroup viewGroup) {
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return;
        }
        for (int i6 = 0; i6 < viewGroup.getChildCount(); i6++) {
            View childAt = viewGroup.getChildAt(i6);
            if (childAt instanceof l6) {
                this.f55084l = (l6) childAt;
            } else if (childAt instanceof ViewGroup) {
                a((ViewGroup) childAt);
            }
        }
    }

    private void e() {
        xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a expressRoot = getExpressRoot();
        if (expressRoot != null) {
            View b6 = a.c.b(expressRoot);
            if (b6 instanceof l6) {
                this.f55084l = (l6) b6;
            } else if (expressRoot.getChildCount() > 0) {
                a(expressRoot);
            }
        }
    }

    public void f() {
        l6 l6Var = this.f55084l;
        if (l6Var != null) {
            l6Var.a(new l6.e() { // from class: xyz.adscope.ad.g7
                @Override // xyz.adscope.ad.l6.e
                public final void a(boolean z5) {
                    d6.this.a(z5);
                }
            });
        }
    }

    public d6(@NonNull Context context) {
        super(context);
    }

    @Override // xyz.adscope.ad.x5, xyz.adscope.ad.b4
    public void a(b4.a aVar) {
        e();
        super.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z5) {
        if (z5) {
            setImageResource(R.drawable.asnp_voice_off);
        } else {
            setImageResource(R.drawable.asnp_voice_on);
        }
    }
}
