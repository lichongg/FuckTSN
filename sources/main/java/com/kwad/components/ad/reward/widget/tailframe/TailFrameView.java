package com.kwad.components.ad.reward.widget.tailframe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.g;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.KSFrameLayout;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class TailFrameView extends KSFrameLayout {
    private com.kwad.components.ad.reward.widget.tailframe.a EL;
    private g tm;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a extends com.kwad.components.ad.reward.widget.tailframe.a implements com.kwad.sdk.widget.d {
        public a() {
            super(R.layout.ksad_video_tf_view_landscape_horizontal);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            KSImageLoader.loadImage(this.EB, com.kwad.sdk.core.response.b.a.X(this.mAdInfo), this.mAdTemplate);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b extends com.kwad.components.ad.reward.widget.tailframe.a implements com.kwad.sdk.widget.d {
        private ImageView EM;
        private ImageView EN;
        private ImageView EO;

        public b() {
            super(R.layout.ksad_video_tf_view_landscape_vertical);
        }

        private void lw() {
            KSImageLoader.loadImage(this.EM, com.kwad.sdk.core.response.b.a.X(this.mAdInfo), this.mAdTemplate);
            KSImageLoader.loadImage(this.EN, com.kwad.sdk.core.response.b.a.X(this.mAdInfo), this.mAdTemplate);
            KSImageLoader.loadImage(this.EO, com.kwad.sdk.core.response.b.a.X(this.mAdInfo), this.mAdTemplate);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void B(Context context) {
            super.B(context);
            this.EM = (ImageView) this.EA.findViewById(R.id.ksad_video_thumb_left);
            this.EN = (ImageView) this.EA.findViewById(R.id.ksad_video_thumb_mid);
            this.EO = (ImageView) this.EA.findViewById(R.id.ksad_video_thumb_right);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            lw();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class c extends com.kwad.components.ad.reward.widget.tailframe.a implements com.kwad.sdk.widget.d {
        private View EP;

        public c() {
            super(R.layout.ksad_video_tf_view_portrait_horizontal);
        }

        private void lw() {
            AdInfo.AdMaterialInfo.MaterialFeature aX = com.kwad.sdk.core.response.b.a.aX(this.mAdInfo);
            int i6 = aX.width;
            int i7 = aX.height;
            int screenWidth = com.kwad.sdk.c.a.a.getScreenWidth(this.EA.getContext());
            int i8 = (int) (screenWidth * (i7 / i6));
            ViewGroup.LayoutParams layoutParams = this.EB.getLayoutParams();
            layoutParams.width = screenWidth;
            layoutParams.height = i8;
            KSImageLoader.loadImage(this.EB, aX.coverUrl, this.mAdTemplate);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void B(Context context) {
            super.B(context);
            this.EP = this.EA.findViewById(R.id.video_cover);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            if (e.O(this.mAdTemplate)) {
                this.EP.setVisibility(8);
                this.mLogoView.setVisibility(8);
                this.EA.setBackground(null);
            }
            lw();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class d extends com.kwad.components.ad.reward.widget.tailframe.a {
        public d() {
            super(R.layout.ksad_video_tf_view_portrait_vertical);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            if (e.O(this.mAdTemplate)) {
                this.EA.setBackground(null);
                this.EB.setVisibility(8);
                this.mLogoView.setVisibility(8);
            }
            KSImageLoader.loadImage(this.EB, com.kwad.sdk.core.response.b.a.X(this.mAdInfo), this.mAdTemplate);
        }
    }

    public TailFrameView(@NonNull Context context) {
        super(context);
    }

    public final void a(com.kwad.components.ad.reward.widget.tailframe.b bVar) {
        this.EL.setCallerContext(this.tm);
        com.kwad.components.ad.reward.widget.tailframe.a aVar = this.EL;
        g gVar = this.tm;
        aVar.a(gVar.mAdTemplate, gVar.mReportExtData, bVar);
    }

    public TailFrameView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void f(boolean z5, boolean z6) {
        if (this.EL != null) {
            return;
        }
        if (z5) {
            if (z6) {
                this.EL = new d();
                return;
            } else {
                this.EL = new c();
                return;
            }
        }
        if (z6) {
            this.EL = new b();
        } else {
            this.EL = new a();
        }
    }

    public final void destroy() {
        com.kwad.components.ad.reward.widget.tailframe.a aVar = this.EL;
        if (aVar != null) {
            aVar.destroy();
        }
    }

    public final void la() {
        this.EL.la();
    }

    public void setCallerContext(g gVar) {
        this.tm = gVar;
    }

    public TailFrameView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
    }

    public final void a(Context context, boolean z5, boolean z6) {
        f(z5, z6);
        this.EL.B(context);
        this.EL.f(z5, z6);
        addView(this.EL.ls(), -1, -1);
    }

    public TailFrameView(@NonNull Context context, View view) {
        super(context, view);
    }
}
