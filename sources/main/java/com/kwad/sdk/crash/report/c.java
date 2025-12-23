package com.kwad.sdk.crash.report;

import android.util.Log;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class c implements e {
    private ArrayList<a> aQm = new ArrayList<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {
        private ExceptionMessage aQn;
        private int aQo;

        a(ExceptionMessage exceptionMessage, int i6) {
            this.aQn = exceptionMessage;
            this.aQo = i6;
        }
    }

    private boolean c(ExceptionMessage exceptionMessage) {
        try {
            com.kwad.sdk.crash.e Lr = com.kwad.sdk.crash.e.Lr();
            if (Lr.Lw() != null && Lr.Lv() != 2) {
                List<com.kwad.sdk.crash.a> list = Lr.Lw().aOD;
                double d6 = Lr.Lw().aOe;
                String appId = Lr.getAppId();
                String sdkVersion = Lr.getSdkVersion();
                for (com.kwad.sdk.crash.a aVar : list) {
                    if (aVar != null) {
                        if (!com.kwad.sdk.crash.utils.c.b(aVar.aOb) && !aVar.aOb.contains(appId)) {
                        }
                        if (com.kwad.sdk.crash.utils.c.b(aVar.aOc) || aVar.aOc.contains(sdkVersion)) {
                            if (com.kwad.sdk.crash.utils.c.b(aVar.aOd) || a(exceptionMessage.mCrashDetail, aVar.aOd)) {
                                d6 = aVar.aOe;
                            }
                        }
                    }
                }
                return Math.random() < d6;
            }
            return true;
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.w("BaseExceptionUploader", Log.getStackTraceString(e6));
            return true;
        }
    }

    public final void a(ExceptionMessage exceptionMessage, int i6, @Nullable CountDownLatch countDownLatch) {
        try {
            LU();
            b(exceptionMessage, i6, countDownLatch);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            this.aQm.add(new a(exceptionMessage, i6));
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }

    private void LU() {
        if (this.aQm.isEmpty()) {
            return;
        }
        try {
            Iterator<a> it = this.aQm.iterator();
            while (it.hasNext()) {
                a next = it.next();
                b(next.aQn, next.aQo, null);
                it.remove();
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    private void b(ExceptionMessage exceptionMessage, int i6, @Nullable CountDownLatch countDownLatch) {
        if (exceptionMessage == null || !c(exceptionMessage)) {
            return;
        }
        if (i6 == 3) {
            com.kwad.sdk.crash.report.a.b(exceptionMessage);
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(com.kwad.sdk.crash.report.request.c.d(exceptionMessage));
        com.kwad.sdk.crash.report.request.b.a(arrayList, countDownLatch);
    }

    private static boolean a(String str, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }
}
