package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.snail.antifake.deviceid.e;
import java.io.IOException;
import org.apache.commons.net.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class LineBuffer {
    private StringBuilder line = new StringBuilder();
    private boolean sawReturn;

    protected abstract void handleLine(String str, String str2) throws IOException;

    @CanIgnoreReturnValue
    private boolean finishLine(boolean z5) throws IOException {
        handleLine(this.line.toString(), this.sawReturn ? z5 ? g.f50795q : "\r" : z5 ? e.f37542d : "");
        this.line = new StringBuilder();
        this.sawReturn = false;
        return z5;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void add(char[] r7, int r8, int r9) throws java.io.IOException {
        /*
            r6 = this;
            boolean r0 = r6.sawReturn
            r1 = 0
            r2 = 10
            r3 = 1
            if (r0 == 0) goto L1a
            if (r9 <= 0) goto L1a
            char r0 = r7[r8]
            if (r0 != r2) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            boolean r0 = r6.finishLine(r0)
            if (r0 == 0) goto L1a
            int r0 = r8 + 1
            goto L1b
        L1a:
            r0 = r8
        L1b:
            int r8 = r8 + r9
            r9 = r0
        L1d:
            if (r0 >= r8) goto L53
            char r4 = r7[r0]
            if (r4 == r2) goto L46
            r5 = 13
            if (r4 == r5) goto L28
            goto L51
        L28:
            java.lang.StringBuilder r4 = r6.line
            int r5 = r0 - r9
            r4.append(r7, r9, r5)
            r6.sawReturn = r3
            int r9 = r0 + 1
            if (r9 >= r8) goto L43
            char r4 = r7[r9]
            if (r4 != r2) goto L3b
            r4 = 1
            goto L3c
        L3b:
            r4 = 0
        L3c:
            boolean r4 = r6.finishLine(r4)
            if (r4 == 0) goto L43
            r0 = r9
        L43:
            int r9 = r0 + 1
            goto L51
        L46:
            java.lang.StringBuilder r4 = r6.line
            int r5 = r0 - r9
            r4.append(r7, r9, r5)
            r6.finishLine(r3)
            goto L43
        L51:
            int r0 = r0 + r3
            goto L1d
        L53:
            java.lang.StringBuilder r0 = r6.line
            int r8 = r8 - r9
            r0.append(r7, r9, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.LineBuffer.add(char[], int, int):void");
    }

    protected void finish() throws IOException {
        if (this.sawReturn || this.line.length() > 0) {
            finishLine(false);
        }
    }

    LineBuffer() {
    }
}
