package com.ss.android.socialbase.appdownloader.m.j;

import com.bytedance.sdk.component.utils.vl;
import java.io.PrintStream;

/* loaded from: D:\Downloads\app\classes6.dex */
public class tl extends Exception {
    protected int cw;

    /* renamed from: j, reason: collision with root package name */
    protected Throwable f38524j;
    protected int xt;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public tl(java.lang.String r4, com.ss.android.socialbase.appdownloader.m.j.a r5, java.lang.Throwable r6) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = ""
            if (r4 != 0) goto Lb
            r4 = r1
            goto L1c
        Lb:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            java.lang.String r4 = " "
            r2.append(r4)
            java.lang.String r4 = r2.toString()
        L1c:
            r0.append(r4)
            if (r5 != 0) goto L23
            r4 = r1
            goto L3a
        L23:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r2 = "(position:"
            r4.<init>(r2)
            java.lang.String r2 = r5.r()
            r4.append(r2)
            java.lang.String r2 = ") "
            r4.append(r2)
            java.lang.String r4 = r4.toString()
        L3a:
            r0.append(r4)
            if (r6 != 0) goto L40
            goto L4e
        L40:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r1 = "caused by: "
            r4.<init>(r1)
            r4.append(r6)
            java.lang.String r1 = r4.toString()
        L4e:
            r0.append(r1)
            java.lang.String r4 = r0.toString()
            r3.<init>(r4)
            r4 = -1
            r3.xt = r4
            r3.cw = r4
            if (r5 == 0) goto L6b
            int r4 = r5.cw()
            r3.xt = r4
            int r4 = r5.m()
            r3.cw = r4
        L6b:
            r3.f38524j = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.m.j.tl.<init>(java.lang.String, com.ss.android.socialbase.appdownloader.m.j.a, java.lang.Throwable):void");
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        if (this.f38524j == null) {
            super.printStackTrace();
            return;
        }
        synchronized (System.err) {
            PrintStream printStream = System.err;
            super.getMessage();
            printStream.getClass();
            vl.j(this.f38524j);
        }
    }
}
