package com.kwad.sdk.core.download.b;

import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.kwad.sdk.api.core.IProgressRemoteView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    private IProgressRemoteView aDL;

    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0031 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.kwad.sdk.core.download.b.c a(android.content.Context r2, int r3, boolean r4) {
        /*
            java.lang.Class<com.kwad.sdk.service.a.f> r0 = com.kwad.sdk.service.a.f.class
            java.lang.Object r0 = com.kwad.sdk.service.ServiceProvider.get(r0)
            com.kwad.sdk.service.a.f r0 = (com.kwad.sdk.service.a.f) r0
            int r0 = r0.getApiVersionCode()
            r1 = 3031000(0x2e3fd8, float:4.247336E-39)
            if (r0 < r1) goto L20
            com.kwad.sdk.api.core.IProgressRemoteView r3 = com.kwad.sdk.api.core.RemoteViewBuilder.createProgressView(r2, r3, r4)     // Catch: java.lang.Throwable -> L1b
            com.kwad.sdk.core.download.b.c r4 = new com.kwad.sdk.core.download.b.c     // Catch: java.lang.Throwable -> L1b
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L1b
            goto L2f
        L1b:
            r3 = move-exception
            com.kwad.sdk.core.d.c.printStackTraceOnly(r3)
            goto L2e
        L20:
            com.kwad.sdk.api.core.IProgressRemoteView r3 = com.kwad.sdk.api.core.RemoteViewBuilder.createProgressView(r2)     // Catch: java.lang.Throwable -> L2a
            com.kwad.sdk.core.download.b.c r4 = new com.kwad.sdk.core.download.b.c     // Catch: java.lang.Throwable -> L2a
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L2a
            goto L2f
        L2a:
            r3 = move-exception
            com.kwad.sdk.core.d.c.printStackTraceOnly(r3)
        L2e:
            r4 = 0
        L2f:
            if (r4 != 0) goto L40
            com.kwad.sdk.api.core.IProgressRemoteView r2 = com.kwad.sdk.api.core.RemoteViewBuilder.createProgressView(r2)     // Catch: java.lang.Throwable -> L3c
            com.kwad.sdk.core.download.b.c r3 = new com.kwad.sdk.core.download.b.c     // Catch: java.lang.Throwable -> L3c
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L3c
            r4 = r3
            goto L40
        L3c:
            r2 = move-exception
            com.kwad.sdk.core.d.c.printStackTraceOnly(r2)
        L40:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.download.b.c.a(android.content.Context, int, boolean):com.kwad.sdk.core.download.b.c");
    }

    final RemoteViews build() {
        IProgressRemoteView iProgressRemoteView = this.aDL;
        if (iProgressRemoteView != null) {
            return iProgressRemoteView.build();
        }
        return null;
    }

    public final void setControlBtnPaused(boolean z5) {
        try {
            IProgressRemoteView iProgressRemoteView = this.aDL;
            if (iProgressRemoteView != null) {
                iProgressRemoteView.setControlBtnPaused(z5);
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    public final void setIcon(Bitmap bitmap) {
        IProgressRemoteView iProgressRemoteView = this.aDL;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setIcon(bitmap);
        }
    }

    public final void setName(String str) {
        IProgressRemoteView iProgressRemoteView = this.aDL;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setName(str);
        }
    }

    public final void setPercentNum(String str) {
        IProgressRemoteView iProgressRemoteView = this.aDL;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setPercentNum(str);
        }
    }

    public final void setProgress(int i6, int i7, boolean z5) {
        IProgressRemoteView iProgressRemoteView = this.aDL;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setProgress(100, i7, false);
        }
    }

    public final void setSize(String str) {
        IProgressRemoteView iProgressRemoteView = this.aDL;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setSize(str);
        }
    }

    public final void setStatus(String str) {
        IProgressRemoteView iProgressRemoteView = this.aDL;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setStatus(str);
        }
    }

    private c(IProgressRemoteView iProgressRemoteView) {
        this.aDL = iProgressRemoteView;
    }
}
