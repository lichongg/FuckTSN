package com.kwad.components.ad.reward.n;

import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.IdRes;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class s extends d {
    protected ViewGroup vV;

    public final void a(ViewGroup viewGroup, @IdRes int i6, @IdRes int i7) {
        if (this.vV != null) {
            return;
        }
        ViewStub viewStub = (ViewStub) viewGroup.findViewById(i6);
        if (viewStub != null) {
            this.vV = (ViewGroup) viewStub.inflate();
        } else {
            this.vV = (ViewGroup) viewGroup.findViewById(i7);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public ViewGroup hP() {
        return this.vV;
    }
}
