package com.kwad.components.core.e.e;

import android.app.DialogFragment;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.R;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.o.m;
import com.kwad.sdk.widget.KSFrameLayout;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends KSFrameLayout {
    private final DialogFragment PR;
    private final View PS;
    private a.C0616a PT;

    private static Presenter bD() {
        Presenter presenter = new Presenter();
        presenter.a(new d());
        return presenter;
    }

    private c pX() {
        c cVar = new c();
        cVar.PR = this.PR;
        cVar.PT = this.PT;
        return cVar;
    }

    public a(@NonNull Context context, DialogFragment dialogFragment, a.C0616a c0616a) {
        super(context);
        this.PR = dialogFragment;
        this.PT = c0616a;
        m.inflate(context, R.layout.ksad_seconed_confirm_dialog_layout, this);
        this.PS = findViewById(R.id.ksad_second_confirm_root_view);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void aa() {
        super.aa();
        Presenter bD = bD();
        bD.K(this.PS);
        bD.n(pX());
    }
}
