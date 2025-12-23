package com.kwad.components.core.widget.a;

import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bz;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class b extends a {
    private View mRootView;

    @Override // com.kwad.components.core.widget.a.a
    public boolean ae() {
        return bz.a(this.mRootView, 70, true);
    }

    public b(@NonNull View view, int i6) {
        super(view, i6);
        this.mRootView = view;
    }
}
