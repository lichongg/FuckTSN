package io.netty.util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class IllegalReferenceCountException extends IllegalStateException {
    private static final long serialVersionUID = -2507492394288153468L;

    public IllegalReferenceCountException() {
    }

    public IllegalReferenceCountException(int i6) {
        this("refCnt: " + i6);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public IllegalReferenceCountException(int r3, int r4) {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "refCnt: "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r3 = ", "
            r0.append(r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            if (r4 <= 0) goto L26
            r3.<init>()
            java.lang.String r1 = "increment: "
            r3.append(r1)
        L1e:
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            goto L30
        L26:
            r3.<init>()
            java.lang.String r1 = "decrement: "
            r3.append(r1)
            int r4 = -r4
            goto L1e
        L30:
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r2.<init>(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.IllegalReferenceCountException.<init>(int, int):void");
    }

    public IllegalReferenceCountException(String str) {
        super(str);
    }

    public IllegalReferenceCountException(String str, Throwable th) {
        super(str, th);
    }

    public IllegalReferenceCountException(Throwable th) {
        super(th);
    }
}
