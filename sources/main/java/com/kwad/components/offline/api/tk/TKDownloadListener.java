package com.kwad.components.offline.api.tk;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.tk.model.StyleTemplate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface TKDownloadListener {
    void onFailed(String str);

    void onSuccess(@NonNull StyleTemplate styleTemplate);
}
