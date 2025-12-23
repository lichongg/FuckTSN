package com.kwad.sdk.crash.report.upload;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.crash.utils.g;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.w;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d {
    public static void a(@NonNull final File file, boolean z5, @Nullable final CountDownLatch countDownLatch) {
        com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "upload()" + Thread.currentThread());
        final f fVar = new f();
        fVar.aQQ = bd.getDeviceId();
        HashMap hashMap = new HashMap();
        hashMap.put("mLogUUID", g.fU(file.getName()));
        fVar.aQS = new JSONObject(hashMap).toString();
        fVar.aQT = w.getExtension(file.getName());
        fVar.aQV = file;
        final boolean z6 = true;
        new l<c, GetUploadTokenResult>() { // from class: com.kwad.sdk.crash.report.upload.d.1
            @Override // com.kwad.sdk.core.network.l
            public final boolean isPostByJson() {
                return false;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: LZ, reason: merged with bridge method [inline-methods] */
            public c createRequest() {
                return new c(bd.getDeviceId(), f.this.aQP, "zip");
            }

            @NonNull
            private static GetUploadTokenResult fT(String str) {
                JSONObject jSONObject = new JSONObject(str);
                GetUploadTokenResult getUploadTokenResult = new GetUploadTokenResult();
                getUploadTokenResult.parseJson(jSONObject);
                return getUploadTokenResult;
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ GetUploadTokenResult parseData(String str) {
                return fT(str);
            }
        }.request(new o<c, GetUploadTokenResult>() { // from class: com.kwad.sdk.crash.report.upload.d.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@NonNull c cVar, @NonNull GetUploadTokenResult getUploadTokenResult) {
                com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "onSuccess url=" + cVar.getUrl() + " ---{" + getUploadTokenResult.uploadToken);
                if (getUploadTokenResult.isResultOk()) {
                    f fVar2 = f.this;
                    fVar2.aQU = getUploadTokenResult.uploadToken;
                    b.a(file, fVar2, new a() { // from class: com.kwad.sdk.crash.report.upload.d.2.1
                        @Override // com.kwad.sdk.crash.report.upload.a
                        public final void LX() {
                            CountDownLatch countDownLatch2 = countDownLatch;
                            if (countDownLatch2 != null) {
                                countDownLatch2.countDown();
                            }
                        }

                        @Override // com.kwad.sdk.crash.report.upload.a
                        public final void LY() {
                            com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "uploadLogFile onSuccess " + Thread.currentThread() + " delete file:" + file.getPath());
                            CountDownLatch countDownLatch2 = countDownLatch;
                            if (countDownLatch2 != null) {
                                countDownLatch2.countDown();
                            }
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            if (z6) {
                                w.delete(file.getPath());
                            }
                        }
                    });
                }
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(@NonNull com.kwad.sdk.core.network.f fVar2, int i6, String str) {
                a((c) fVar2, i6, str);
            }

            private static void a(@NonNull c cVar, int i6, String str) {
                com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "onError errorCode=" + i6 + "errorMsg=" + str + "url=" + cVar.getUrl());
            }
        });
    }
}
