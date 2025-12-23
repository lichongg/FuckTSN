package com.kwad.components.ad.widget.tailframe.appbar;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class TailFrameBarAppPortraitVertical extends a {
    public TailFrameBarAppPortraitVertical(Context context) {
        this(context, null);
    }

    public TailFrameBarAppPortraitVertical(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.kwad.components.ad.widget.tailframe.appbar.a
    public int getLayoutId() {
        return R.layout.ksad_video_tf_bar_app_portrait_vertical;
    }

    public TailFrameBarAppPortraitVertical(Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
    }

    @Override // com.kwad.components.ad.widget.tailframe.appbar.a
    public final void j(@NonNull AdTemplate adTemplate) {
        if (e.O(adTemplate)) {
            this.GD.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.ksad_translucent));
            this.nr.setTextColor(Color.parseColor("#FFFFFF"));
            this.MU.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            this.GD.setBackgroundColor(Color.parseColor("#E6FFFFFF"));
        }
        super.j(adTemplate);
    }
}
