package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.common.DataHelper;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private String f41865a = "10.0.0.172";

    /* renamed from: b, reason: collision with root package name */
    private int f41866b = 80;

    /* renamed from: c, reason: collision with root package name */
    private Context f41867c;

    private void a() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f41867c, "sl_domain_p", "");
        if (TextUtils.isEmpty(imprintProperty)) {
            return;
        }
        a.f41849i = DataHelper.assembleStatelessURL(imprintProperty);
    }

    private void b() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f41867c, "sl_domain_p", "");
        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f41867c, "oversea_sl_domain_p", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            a.f41848h = DataHelper.assembleStatelessURL(imprintProperty);
        }
        if (!TextUtils.isEmpty(imprintProperty2)) {
            a.f41851k = DataHelper.assembleStatelessURL(imprintProperty2);
        }
        a.f41849i = a.f41851k;
        if (TextUtils.isEmpty(com.umeng.commonsdk.statistics.b.f41875b)) {
            return;
        }
        if (com.umeng.commonsdk.statistics.b.f41875b.startsWith("460") || com.umeng.commonsdk.statistics.b.f41875b.startsWith("461")) {
            a.f41849i = a.f41848h;
        }
    }

    public c(Context context) {
        this.f41867c = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0132, code lost:
    
        if (r11 == 0) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0135, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x011d, code lost:
    
        com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> stateless: disconnect connection.");
        r11.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x011b, code lost:
    
        if (r11 == 0) goto L65;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v12, types: [java.net.HttpURLConnection, java.net.URLConnection, javax.net.ssl.HttpsURLConnection] */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.StringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(byte[] r9, java.lang.String r10, java.lang.String r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 338
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.c.a(byte[], java.lang.String, java.lang.String, java.lang.String):boolean");
    }
}
