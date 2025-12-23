package com.kwad.components.offline.api.core.soloader;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface SoLoadListener {
    void onFailed(int i6, Throwable th);

    void onLoaded();

    void onPreUpdate();
}
