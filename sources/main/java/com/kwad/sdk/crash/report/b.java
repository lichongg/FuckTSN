package com.kwad.sdk.crash.report;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.model.message.AnrExceptionMessage;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.utils.w;
import java.io.File;
import java.io.IOException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b extends d {
    @Override // com.kwad.sdk.crash.report.d
    protected final ExceptionMessage a(@NonNull File file, File file2, File file3, File file4, File file5) {
        com.kwad.sdk.core.d.c.d("AnrReporter", "AnrReporter parseExceptionInfo basePath=" + file5.getPath());
        AnrExceptionMessage C = C(file2);
        try {
            C.mReason = B(file5);
            a(C, file);
            a(file4, C);
            com.kwad.sdk.crash.utils.g.a(file, (CharSequence) C.toString(), true);
            com.kwad.sdk.crash.utils.g.d(file3, file);
            file.renameTo(file3);
            C.toString();
            File file6 = new File(file5, "meminfo");
            if (file6.exists()) {
                C.mDumpsys = w.W(file6);
            }
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.e("AnrReporter", Log.getStackTraceString(e6));
            this.mErrorMessage += e6 + com.snail.antifake.deviceid.e.f37542d;
        }
        if (!TextUtils.isEmpty(this.mErrorMessage)) {
            C.mErrorMessage += this.mErrorMessage;
        }
        return C;
    }

    private String B(File file) {
        File file2 = new File(file, "anr_reason");
        String str = "";
        if (file2.exists()) {
            try {
                str = w.W(file2);
            } catch (IOException e6) {
                this.mErrorMessage += e6 + com.snail.antifake.deviceid.e.f37542d;
            }
            w.U(file2);
        }
        return str;
    }

    private AnrExceptionMessage C(File file) {
        String str;
        try {
            str = w.W(file);
        } catch (IOException e6) {
            this.mErrorMessage += e6 + com.snail.antifake.deviceid.e.f37542d;
            str = null;
        }
        AnrExceptionMessage anrExceptionMessage = new AnrExceptionMessage();
        if (str != null) {
            try {
                anrExceptionMessage.parseJson(new JSONObject(str));
            } catch (Exception e7) {
                this.mErrorMessage += e7 + com.snail.antifake.deviceid.e.f37542d;
            }
        }
        w.U(file);
        return anrExceptionMessage;
    }

    private static boolean fO(@NonNull String str) {
        for (String str2 : com.kwad.sdk.crash.e.Lr().Ls()) {
            if (str.contains(str2)) {
                com.kwad.sdk.core.d.c.d("AnrReporter", " tag=" + str2);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.kwad.sdk.crash.model.message.AnrExceptionMessage r10, java.io.File r11) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.crash.report.b.a(com.kwad.sdk.crash.model.message.AnrExceptionMessage, java.io.File):void");
    }
}
