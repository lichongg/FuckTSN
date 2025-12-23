package com.kwad.components.core.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.aq;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class f extends FrameLayout {
    private boolean ajm;
    protected g kR;
    protected boolean lj;

    @NonNull
    protected Context mContext;

    public final void setOrientationChangeListener(g gVar) {
        this.kR = gVar;
    }

    public f(@NonNull Context context) {
        super(context);
        this.mContext = context;
        this.lj = aq.QW();
    }

    private void wg() {
        boolean QW = aq.QW();
        if (this.ajm && QW != this.lj) {
            this.lj = QW;
            g gVar = this.kR;
            if (gVar != null) {
                gVar.k(!QW);
            }
        }
    }

    @Override // android.view.View
    protected final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        wg();
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(int i6) {
        boolean z5;
        super.onWindowVisibilityChanged(i6);
        if (i6 == 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.ajm = z5;
        wg();
    }
}
