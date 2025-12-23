package com.kwad.sdk.collector;

import android.os.Environment;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.model.jni.AnalyseTaskNative;
import com.kwad.sdk.collector.model.jni.AppRunningInfoNative;
import com.kwad.sdk.collector.model.jni.RulesTargetNative;
import com.kwad.sdk.collector.model.jni.UploadEntryNative;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    public static com.kwad.sdk.collector.a DF() {
        return new a();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a implements com.kwad.sdk.collector.a {
        @Override // com.kwad.sdk.collector.a
        public final List<com.kwad.sdk.collector.model.b> a(AppStatusRules.Strategy strategy) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            com.kwad.sdk.collector.model.c.a(strategy, arrayList2);
            File file = new File(Environment.getExternalStorageDirectory(), "/Android/data/");
            int size = arrayList2.size();
            long[] jArr = new long[size];
            for (int i6 = 0; i6 < size; i6++) {
                com.kwad.sdk.collector.model.a aVar = (com.kwad.sdk.collector.model.a) arrayList2.get(i6);
                if (!(aVar instanceof AnalyseTaskNative)) {
                    return arrayList;
                }
                jArr[i6] = ((AnalyseTaskNative) aVar).getNativePtr();
            }
            if (d.DH()) {
                try {
                    long[] analysis = AppStatusNative.analysis(jArr, file.getAbsolutePath() + "/");
                    StringBuilder sb = new StringBuilder("analysisByFile: runningInfoPtrs: ");
                    sb.append(analysis);
                    com.kwad.sdk.core.d.c.d("AppStatusAnalyserNative", sb.toString());
                    for (long j6 : analysis) {
                        arrayList.add(new AppRunningInfoNative(j6));
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }
            com.kwad.sdk.core.d.c.d("AppStatusAnalyserNative", "analysisByFile: info size: " + arrayList.size());
            return arrayList;
        }

        @Override // com.kwad.sdk.collector.a
        public final List<com.kwad.sdk.collector.model.e> a(List<com.kwad.sdk.collector.model.d> list, long j6, String str) {
            int size = list.size();
            long[] jArr = new long[list.size()];
            for (int i6 = 0; i6 < size; i6++) {
                com.kwad.sdk.collector.model.d dVar = list.get(i6);
                if (dVar instanceof RulesTargetNative) {
                    jArr[i6] = ((RulesTargetNative) dVar).getNativePtr();
                }
            }
            ArrayList arrayList = new ArrayList();
            if (d.DH()) {
                try {
                    for (long j7 : AppStatusNative.nativeGetUploadEntry(jArr, j6, str)) {
                        arrayList.add(new UploadEntryNative(j7));
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }
            return arrayList;
        }
    }
}
