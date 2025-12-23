package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ba implements com.kwad.sdk.core.webview.c.a {
    private final Handler acR = new Handler(Looper.getMainLooper());
    private com.kwad.sdk.core.webview.c.c ack;
    private final c aei;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static final class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public int likeUserCount;
        public long liveDuration;
        public int status;
        public long totalWatchingDuration;
        public int watchingUserCount;
        public String displayWatchingUserCount = "0";
        public String displayLikeUserCount = "0";
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b {
        WeakReference<com.kwad.sdk.core.webview.c.c> aek;

        public final void a(a aVar) {
            com.kwad.sdk.core.webview.c.c cVar = this.aek.get();
            if (cVar != null) {
                cVar.a(aVar);
            }
        }

        public b(com.kwad.sdk.core.webview.c.c cVar) {
            this.aek = new WeakReference<>(cVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface c {
        void a(b bVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.ack = null;
        this.acR.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.ack = cVar;
        this.acR.post(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.ba.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                ba.this.aei.a(new b(ba.this.ack));
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerLiveListener";
    }

    public ba(c cVar) {
        this.aei = cVar;
    }
}
