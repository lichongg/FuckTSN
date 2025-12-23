package com.kwad.components.ad.reward.i;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.e.n;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ac;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a implements n {

    @Nullable
    private Context mContext;

    @Override // com.kwad.components.ad.reward.e.n
    public final boolean id() {
        Context context = this.mContext;
        if (context == null) {
            return true;
        }
        ac.c(this.mContext, context.getResources().getString(R.string.ksad_reward_playable_load_error_toast), 0L);
        return true;
    }

    public a(Context context) {
        this.mContext = context;
    }
}
