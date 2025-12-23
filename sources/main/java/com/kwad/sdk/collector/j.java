package com.kwad.sdk.collector;

import android.content.Context;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.collector.model.jni.UploadEntryNative;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.utils.aa;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class j {
    private static List<UploadEntryNative> bm(Context context) {
        File file = new File(context.getApplicationInfo().dataDir, "LOCAL_TEMP_UPLOAD_FAILURE_JSON");
        if (!file.exists()) {
            return null;
        }
        try {
            return aa.gV(com.kwad.sdk.crash.utils.h.J(file));
        } catch (IOException unused) {
            return null;
        }
    }

    public static void bn(Context context) {
        try {
            File file = new File(context.getApplicationInfo().dataDir, "LOCAL_TEMP_UPLOAD_FAILURE_JSON");
            if (file.exists()) {
                file.delete();
            }
        } catch (Throwable unused) {
        }
    }

    @RequiresApi(api = 19)
    private static void d(final Context context, final List<com.kwad.sdk.collector.model.e> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        new l<com.kwad.sdk.collector.a.b, CollectResponse>() { // from class: com.kwad.sdk.collector.j.1
            @Override // com.kwad.sdk.core.network.l
            public final boolean enableMonitorReport() {
                return false;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: DK, reason: merged with bridge method [inline-methods] */
            public com.kwad.sdk.collector.a.b createRequest() {
                return new com.kwad.sdk.collector.a.b(list);
            }

            @NonNull
            private static CollectResponse cE(String str) {
                CollectResponse collectResponse = new CollectResponse();
                collectResponse.parseJson(new JSONObject(str));
                return collectResponse;
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ CollectResponse parseData(String str) {
                return cE(str);
            }
        }.request(new o<com.kwad.sdk.collector.a.b, CollectResponse>() { // from class: com.kwad.sdk.collector.j.2
            private synchronized void DL() {
                j.bn(context);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onStartRequest(@NonNull com.kwad.sdk.collector.a.b bVar) {
                super.onStartRequest(bVar);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@NonNull com.kwad.sdk.collector.a.b bVar, @NonNull CollectResponse collectResponse) {
                super.onSuccess(bVar, collectResponse);
                DL();
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(@NonNull com.kwad.sdk.collector.a.b bVar, int i6, String str) {
                super.onError(bVar, i6, str);
            }
        });
    }

    @WorkerThread
    public static void a(Context context, AppStatusRules appStatusRules) {
        long obtainUploadConfigFileMaxSize = appStatusRules.obtainUploadConfigFileMaxSize();
        List<com.kwad.sdk.collector.model.d> uploadTargets = appStatusRules.getUploadTargets();
        if (uploadTargets == null) {
            return;
        }
        List<com.kwad.sdk.collector.model.e> a6 = b.DF().a(uploadTargets, obtainUploadConfigFileMaxSize, new File(Environment.getExternalStorageDirectory(), "/Android/data/").getAbsolutePath() + "/");
        List<UploadEntryNative> bm = bm(context);
        if (bm != null) {
            a6.addAll(bm);
            HashSet hashSet = new HashSet(a6);
            a6.clear();
            a6.addAll(hashSet);
        }
        d(context, a6);
    }
}
