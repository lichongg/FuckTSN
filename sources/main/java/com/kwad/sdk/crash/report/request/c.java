package com.kwad.sdk.crash.report.request;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.d;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.report.ReportEvent;
import com.kwad.sdk.crash.utils.e;
import java.util.Calendar;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    public static ReportEvent d(@NonNull ExceptionMessage exceptionMessage) {
        ReportEvent reportEvent = new ReportEvent();
        reportEvent.clientIncrementId = e.ID();
        reportEvent.clientTimeStamp = exceptionMessage.mCurrentTimeStamp;
        reportEvent.sessionId = fS(exceptionMessage.mCustomMsg);
        reportEvent.timeZone = Calendar.getInstance().getTimeZone().getID();
        reportEvent.statPackage = new ReportEvent.StatPackage();
        ReportEvent.ExceptionEvent exceptionEvent = new ReportEvent.ExceptionEvent();
        exceptionEvent.type = exceptionMessage.mExceptionType;
        exceptionEvent.message = exceptionMessage.toJson().toString();
        exceptionEvent.urlPackage = new ReportEvent.UrlPackage();
        reportEvent.statPackage.exceptionEvent = exceptionEvent;
        return reportEvent;
    }

    private static String fS(String str) {
        if (!TextUtils.isEmpty(str) && !"Unknown".equals(str)) {
            try {
                String optString = new JSONObject(str).optString(d.aOO);
                if (!TextUtils.isEmpty(optString)) {
                    return optString;
                }
            } catch (Exception e6) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
            }
        }
        return "Unknown";
    }
}
