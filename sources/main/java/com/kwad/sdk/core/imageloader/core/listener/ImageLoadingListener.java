package com.kwad.sdk.core.imageloader.core.listener;

import android.view.View;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface ImageLoadingListener {
    boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult);

    void onLoadingCancelled(String str, View view);

    void onLoadingComplete(String str, View view, DecodedResult decodedResult);

    void onLoadingFailed(String str, View view, FailReason failReason);

    void onLoadingStarted(String str, View view);
}
