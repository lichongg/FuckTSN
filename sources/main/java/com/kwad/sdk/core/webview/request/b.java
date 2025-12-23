package com.kwad.sdk.core.webview.request;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.webview.d.b;
import com.kwad.sdk.utils.bg;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    private static final Handler iK = new Handler(Looper.getMainLooper());

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        @MainThread
        void a(@NonNull WebCardGetDataResponse webCardGetDataResponse);

        @MainThread
        void onError(int i6, String str);
    }

    public final void a(final b.a aVar, @NonNull final a aVar2) {
        new l<com.kwad.sdk.core.webview.request.a, WebCardGetDataResponse>() { // from class: com.kwad.sdk.core.webview.request.b.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: KZ, reason: merged with bridge method [inline-methods] */
            public com.kwad.sdk.core.webview.request.a createRequest() {
                b.a aVar3 = aVar;
                return new com.kwad.sdk.core.webview.request.a(aVar3.url, aVar3.method, aVar3.params) { // from class: com.kwad.sdk.core.webview.request.b.1.1
                    @Override // com.kwad.sdk.core.webview.request.a, com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
                    public final String getUrl() {
                        return aVar.url;
                    }
                };
            }

            @NonNull
            private static WebCardGetDataResponse fh(String str) {
                JSONObject jSONObject = new JSONObject(str);
                WebCardGetDataResponse webCardGetDataResponse = new WebCardGetDataResponse();
                webCardGetDataResponse.parseJson(jSONObject);
                return webCardGetDataResponse;
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ WebCardGetDataResponse parseData(String str) {
                return fh(str);
            }
        }.request(new o<com.kwad.sdk.core.webview.request.a, WebCardGetDataResponse>() { // from class: com.kwad.sdk.core.webview.request.b.2
            private void b(@NonNull final WebCardGetDataResponse webCardGetDataResponse) {
                c.d("WebCardGetDataRequestManager", "onSuccess");
                b.iK.post(new bg() { // from class: com.kwad.sdk.core.webview.request.b.2.2
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        aVar2.a(webCardGetDataResponse);
                    }
                });
            }

            private void u(final int i6, final String str) {
                c.d("WebCardGetDataRequestManager", "onError errorCode=" + i6 + " errorMsg=" + str);
                b.iK.post(new bg() { // from class: com.kwad.sdk.core.webview.request.b.2.3
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        c.d("WebCardGetDataRequestManager", "load onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i6), str));
                        aVar2.onError(i6, str);
                    }
                });
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
                b((WebCardGetDataResponse) baseResultData);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onStartRequest(@NonNull com.kwad.sdk.core.webview.request.a aVar3) {
                super.onStartRequest(aVar3);
                c.d("WebCardGetDataRequestManager", "onStartRequest");
                b.iK.post(new bg() { // from class: com.kwad.sdk.core.webview.request.b.2.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                    }
                });
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(@NonNull f fVar, int i6, String str) {
                u(i6, str);
            }
        });
    }
}
