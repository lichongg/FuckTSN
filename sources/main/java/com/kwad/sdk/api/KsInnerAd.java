package com.kwad.sdk.api;

import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsAdSdkApi
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public interface KsInnerAd {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsAdSdkApi
    @Keep
    public interface KsInnerAdInteractionListener {
        @KsAdSdkApi
        @Keep
        void onAdClicked(KsInnerAd ksInnerAd);

        @KsAdSdkApi
        @Keep
        void onAdShow(KsInnerAd ksInnerAd);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Keep
    @Retention(RetentionPolicy.SOURCE)
    public @interface KsInnerAdType {
        public static final int AGGREGATION = 1;
        public static final int REFLOW = 2;
        public static final int UNKNOWN = 0;
    }

    int getType();
}
