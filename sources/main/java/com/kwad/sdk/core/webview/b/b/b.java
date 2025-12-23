package com.kwad.sdk.core.webview.b.b;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.utils.bp;
import com.kwad.sdk.utils.w;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    public static synchronized boolean a(Context context, com.kwad.sdk.h.a.b bVar) {
        synchronized (b.class) {
            try {
                String str = bVar.aRr;
                File file = new File(str);
                if (!w.O(file)) {
                    return false;
                }
                if (!TextUtils.isEmpty(bVar.ard)) {
                    String fileMD5 = com.kwad.sdk.utils.a.getFileMD5(file);
                    if (fileMD5 != null && fileMD5.length() > 10) {
                        fileMD5 = fileMD5.substring(0, 10);
                    }
                    if (!bp.isEquals(fileMD5, bVar.ard)) {
                        w.ab(file);
                        return false;
                    }
                }
                com.kwad.sdk.core.webview.b.c.b.a(bVar, 2);
                try {
                    com.kwad.sdk.core.webview.b.c.a.f(context, str, com.kwad.sdk.core.webview.b.c.a.H(context, bVar.aRq));
                    w.ab(file);
                    return true;
                } catch (Exception e6) {
                    e6.printStackTrace();
                    com.kwad.sdk.core.webview.b.c.b.a(bVar, 0, 2, e6.getMessage());
                    return false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
