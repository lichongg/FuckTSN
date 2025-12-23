package com.kwad.sdk.core.network;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.NormalResultData;
import com.kwad.sdk.core.network.n;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bw;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class m<R extends n, T extends NormalResultData> extends a<R> {
    private static final String TAG = "NormalNetworking";

    @Nullable
    private g<R, T> mListener = null;

    protected abstract T createResponseData();

    private void onRequest(@NonNull g<R, T> gVar) {
        this.mListener = gVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.core.network.a
    public void onResponse(R r5, c cVar) {
        if (this.mListener == null) {
            return;
        }
        if (cVar.Hx()) {
            T createResponseData = createResponseData();
            parseResponse(createResponseData, cVar);
            this.mListener.onSuccess(r5, createResponseData);
        } else {
            g<R, T> gVar = this.mListener;
            int i6 = cVar.code;
            Exception exc = cVar.aEj;
            gVar.onError(r5, i6, exc != null ? exc.getMessage() : "");
        }
    }

    @Override // com.kwad.sdk.core.network.a
    protected void cancel() {
        super.cancel();
        this.mListener = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.core.network.a
    protected void fetchImpl() {
        n nVar = (n) createRequest();
        c cVar = null;
        try {
            String url = nVar.getUrl();
            if (nVar.getMethod().equals("POST")) {
                cVar = com.kwad.sdk.g.AI().doPost(url, nVar.getHeader(), nVar.getBody());
            } else {
                cVar = com.kwad.sdk.g.AI().doGet(url, nVar.getHeader());
            }
            if (cVar != null && cVar.code == 200) {
                com.kwad.sdk.core.d.c.d(TAG, "normal request success:" + cVar.code);
            } else {
                com.kwad.sdk.core.d.c.d(TAG, "normal request failed");
            }
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
            if (0 == 0) {
                cVar = new c();
            }
            cVar.code = -1;
            cVar.aEj = e6;
        }
        onResponse((m<R, T>) nVar, cVar);
    }

    protected void parseResponse(T t5, c cVar) {
        t5.parseResponse(cVar);
    }

    public void request(@NonNull g<R, T> gVar) {
        try {
            onRequest(gVar);
            fetch();
        } catch (Throwable th) {
            gVar.onError(null, e.aEv.errorCode, bw.s(th));
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
