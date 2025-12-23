package com.kwad.sdk.liteapi.report;

import android.content.Context;
import androidx.annotation.Keep;
import com.kwad.sdk.liteapi.LiteApiLogger;
import com.kwad.sdk.liteapi.report.LiteReportHttp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public class LiteApiReporter {
    private static final String REPORT_URL = "https://open.e.kuaishou.com/rest/e/v3/open/logDex";
    private static final String TAG = "LiteApiReporter";

    public static void reportDexError(Context context, String str, int i6) {
        LiteApiLogger.w(TAG, "reportDexError dexErrorCode: " + i6);
        try {
            LiteApiReportRequest newInstance = LiteApiReportRequest.newInstance(context, str, i6);
            LiteReportHttp liteReportHttp = new LiteReportHttp(REPORT_URL);
            LiteApiLogger.w(TAG, "reportDexError before  reportHttp.request ");
            liteReportHttp.request(context, newInstance, new LiteReportHttp.a() { // from class: com.kwad.sdk.liteapi.report.LiteApiReporter.1
                @Override // com.kwad.sdk.liteapi.report.LiteReportHttp.a
                public final void a(LiteApiReportResponse liteApiReportResponse) {
                    LiteApiLogger.w(LiteApiReporter.TAG, "reportDexError request onSuccess: " + liteApiReportResponse);
                }

                @Override // com.kwad.sdk.liteapi.report.LiteReportHttp.a
                public final void b(Exception exc) {
                    LiteApiLogger.w(LiteApiReporter.TAG, "reportDexError request onError: " + exc.getMessage());
                    exc.printStackTrace();
                }
            });
        } catch (Throwable th) {
            LiteApiLogger.w(TAG, "reportDexError  error: " + th.getMessage());
            th.printStackTrace();
        }
    }
}
