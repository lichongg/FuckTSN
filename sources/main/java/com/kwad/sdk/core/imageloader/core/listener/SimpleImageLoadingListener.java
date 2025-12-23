package com.kwad.sdk.core.imageloader.core.listener;

import android.view.View;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class SimpleImageLoadingListener implements ImageLoadingListener {
    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
        return false;
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public void onLoadingCancelled(String str, View view) {
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public void onLoadingStarted(String str, View view) {
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public void onLoadingFailed(String str, View view, FailReason failReason) {
    }
}
