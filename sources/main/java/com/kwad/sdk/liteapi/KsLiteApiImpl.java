package com.kwad.sdk.liteapi;

import android.content.Context;
import androidx.annotation.Keep;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.a.b;
import com.kwad.sdk.api.loader.DexLoadError;
import com.kwad.sdk.api.loader.q;
import com.kwad.sdk.liteapi.encrypt.LiteEncryptUtils;
import com.kwad.sdk.liteapi.report.LiteApiReporter;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public class KsLiteApiImpl implements q {
    private static final String TAG = "KsLiteApiImpl";

    @Override // com.kwad.sdk.api.loader.q
    public String getAESKey(Context context) {
        return LiteEncryptUtils.getKey(context, 0);
    }

    @Override // com.kwad.sdk.api.loader.q
    public void holdSdkConfig(SdkConfig sdkConfig) {
        if (sdkConfig != null) {
            InputParamHolder.holderSdkConfig(sdkConfig);
        }
    }

    @Override // com.kwad.sdk.api.loader.q
    public void reportDexLoadError(final Context context, final DexLoadError dexLoadError) {
        LiteApiLogger.d(TAG, "reportDexLoadError dexLoadError: " + dexLoadError);
        if (dexLoadError != null) {
            com.kwad.sdk.api.a.a.a(new b() { // from class: com.kwad.sdk.liteapi.KsLiteApiImpl.1
                @Override // com.kwad.sdk.api.a.b
                public final void doTask() {
                    LiteApiLogger.d(KsLiteApiImpl.TAG, "reportDexLoadError doTask: ");
                    LiteApiReporter.reportDexError(context, dexLoadError.getErrorMsg(), dexLoadError.getErrorCode());
                }
            });
        }
    }

    @Override // com.kwad.sdk.api.loader.q
    public void onInit(Context context) {
        LiteOAIDHelper.getAppOAID(context);
    }
}
