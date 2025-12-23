package com.ss.android.socialbase.downloader.impls;

/* loaded from: D:\Downloads\app\classes6.dex */
public class vl {

    /* renamed from: j, reason: collision with root package name */
    private static volatile com.ss.android.socialbase.downloader.downloader.az f38862j;
    private static volatile com.ss.android.socialbase.downloader.downloader.az xt;

    public static com.ss.android.socialbase.downloader.downloader.az j(boolean z5) {
        if (z5 && com.ss.android.socialbase.downloader.downloader.cw.hl()) {
            if (xt == null) {
                synchronized (vl.class) {
                    try {
                        if (xt == null) {
                            xt = com.ss.android.socialbase.downloader.downloader.cw.b().xt();
                        }
                    } finally {
                    }
                }
            }
            return xt;
        }
        if (f38862j == null) {
            synchronized (vl.class) {
                try {
                    if (f38862j == null) {
                        f38862j = new av();
                    }
                } finally {
                }
            }
        }
        return f38862j;
    }
}
