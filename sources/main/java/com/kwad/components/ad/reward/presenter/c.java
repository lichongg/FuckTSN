package com.kwad.components.ad.reward.presenter;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aq;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class c extends b {
    private ImageView vy;
    private AdInfo vz;

    protected int iB() {
        return R.id.ksad_blur_video_cover;
    }

    public c(AdInfo adInfo) {
        this.vz = adInfo;
    }

    private static void a(ImageView imageView, String str, AdTemplate adTemplate) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        KSImageLoader.loadImage(imageView, str, adTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.reward.presenter.c.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                return true;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str2, View view, DecodedResult decodedResult) {
            }
        });
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        AdTemplate adTemplate = this.tm.mAdTemplate;
        if (!iA() && adTemplate.adInfoList.size() > 0) {
            String X = com.kwad.sdk.core.response.b.a.X(adTemplate.adInfoList.get(0));
            this.vy.setVisibility(iC());
            try {
                a(this.vy, X, adTemplate);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTrace(th);
            }
        }
    }

    protected int iC() {
        getContext();
        if (com.kwad.components.ad.reward.g.O(this.tm.mAdTemplate) && !aq.QW()) {
            return 0;
        }
        if (com.kwad.components.ad.reward.g.N(this.tm.mAdTemplate) && !aq.QW()) {
            return 0;
        }
        if ((com.kwad.sdk.core.response.b.e.ex(this.tm.mAdTemplate) && !aq.QW()) || com.kwad.components.ad.reward.g.g(this.vz)) {
            return 0;
        }
        if (com.kwad.sdk.core.response.b.a.cJ(this.vz) && com.kwad.components.ad.reward.a.b.hM() && !aq.QW()) {
            return 0;
        }
        return 8;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.vy = (ImageView) findViewById(iB());
    }
}
