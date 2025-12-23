package com.kwad.sdk.mobileid.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.mobileid.d;
import com.kwad.sdk.mobileid.model.CMTokenResponse;
import com.kwad.sdk.mobileid.model.UaidTokenResponse;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends com.kwad.sdk.mobileid.b {
    private l<b, CMTokenResponse> add;
    private int retryCount = 0;
    private int aGj = 3;

    @Override // com.kwad.sdk.mobileid.b
    public final void ci(Context context) {
        b(context, false);
    }

    static /* synthetic */ int c(a aVar) {
        int i6 = aVar.retryCount;
        aVar.retryCount = i6 + 1;
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cj(final Context context) {
        new l<c, UaidTokenResponse>() { // from class: com.kwad.sdk.mobileid.a.a.3
            @NonNull
            private static c ND() {
                return new c();
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.l
            @NonNull
            /* renamed from: gs, reason: merged with bridge method [inline-methods] */
            public UaidTokenResponse parseData(String str) {
                UaidTokenResponse uaidTokenResponse = new UaidTokenResponse();
                uaidTokenResponse.parseJson(new JSONObject(str));
                if (!TextUtils.isEmpty(uaidTokenResponse.uaid)) {
                    ag.Z(ServiceProvider.Pp(), uaidTokenResponse.uaid);
                    ag.e(ServiceProvider.Pp(), System.currentTimeMillis());
                }
                ag.aa(ServiceProvider.Pp(), "");
                com.kwad.sdk.mobileid.c.a(context, uaidTokenResponse);
                return uaidTokenResponse;
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            public final /* synthetic */ f createRequest() {
                return ND();
            }
        }.request(new o<c, UaidTokenResponse>() { // from class: com.kwad.sdk.mobileid.a.a.4
            private static void NE() {
                com.kwad.sdk.mobileid.a.Nt();
            }

            private void x(int i6, String str) {
                com.kwad.sdk.mobileid.a.Nt();
                com.kwad.sdk.mobileid.c.c(context, i6, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(@NonNull f fVar, int i6, String str) {
                x(i6, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
                NE();
            }
        });
    }

    @SuppressLint({"CheckResult"})
    public final void b(final Context context, final boolean z5) {
        com.kwad.sdk.mobileid.c.b(context, z5 ? new d(true, "uaidTokenCanRequestByWifi") : new d(true, "uaidTokenCanRequest"));
        l<b, CMTokenResponse> lVar = new l<b, CMTokenResponse>() { // from class: com.kwad.sdk.mobileid.a.a.1
            @NonNull
            private static b NC() {
                return new b();
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.l
            @NonNull
            /* renamed from: gr, reason: merged with bridge method [inline-methods] */
            public CMTokenResponse parseData(String str) {
                CMTokenResponse cMTokenResponse = new CMTokenResponse();
                cMTokenResponse.parseJson(new JSONObject(str));
                ag.aa(context, cMTokenResponse.getResultToken());
                com.kwad.sdk.mobileid.a.Nt();
                com.kwad.sdk.mobileid.c.a(context, cMTokenResponse);
                return cMTokenResponse;
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            public final /* synthetic */ f createRequest() {
                return NC();
            }
        };
        this.add = lVar;
        lVar.request(new o<b, CMTokenResponse>() { // from class: com.kwad.sdk.mobileid.a.a.2
            private void w(int i6, String str) {
                com.kwad.sdk.mobileid.c.b(context, i6, str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@NonNull b bVar, @NonNull CMTokenResponse cMTokenResponse) {
                boolean z6;
                d dVar;
                super.onSuccess(bVar, cMTokenResponse);
                boolean isEmpty = TextUtils.isEmpty(ag.cT(context));
                if (a.this.retryCount < a.this.aGj) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (!isEmpty && z6) {
                    a.c(a.this);
                    if (z5) {
                        dVar = new d(true, "uaidTokenCanRequestByWifi");
                    } else {
                        dVar = new d(true, "uaidTokenCanRequest");
                    }
                    a.this.cj(context);
                } else if (isEmpty) {
                    dVar = new d(false, "noRequestUaidTokenEmpty");
                } else {
                    dVar = new d(false, "noRequestUaidRetry");
                }
                com.kwad.sdk.mobileid.c.c(context, dVar);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(@NonNull f fVar, int i6, String str) {
                w(i6, str);
            }
        });
    }
}
