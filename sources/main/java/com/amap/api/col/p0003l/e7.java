package com.amap.api.col.p0003l;

import android.content.Context;
import com.kwad.sdk.collector.AppStatusRules;
import com.tencent.connect.common.Constants;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class e7 {

    /* renamed from: a, reason: collision with root package name */
    static WeakReference<c7> f6003a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f6004a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f6005b;

        a(String str, Context context) {
            this.f6004a = str;
            this.f6005b = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (e7.class) {
                try {
                    String b6 = m4.b(q4.o(this.f6004a));
                    c7 a6 = j7.a(e7.f6003a);
                    j7.f(this.f6005b, a6, s5.f7240j, 50, AppStatusRules.UploadConfig.DEFAULT_FILE_MAX_SIZE, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
                    if (a6.f5853e == null) {
                        a6.f5853e = new j6(new m6(new l6()));
                    }
                    d7.c(b6, q4.o(" \"timestamp\":\"" + q4.c(System.currentTimeMillis(), "yyyyMMdd HH:mm:ss") + "\",\"details\":" + this.f6004a), a6);
                } finally {
                }
            }
        }
    }

    public static void a(String str, Context context) {
        v5.r().submit(new a(str, context));
    }
}
