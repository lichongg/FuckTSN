package com.kwad.framework.filedownloader.f;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class e {
    public final int apE;
    public final long apF;
    public final boolean apG;
    public final boolean apH;
    public final int apI;
    public final boolean apJ;
    public final boolean apK;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {
        private static final e apL = new e(0);
    }

    /* synthetic */ e(byte b6) {
        this();
    }

    public static int ce(int i6) {
        if (i6 > 12) {
            d.d(e.class, "require the count of network thread  is %d, what is more than the max valid count(%d), so adjust to %d auto", Integer.valueOf(i6), 12, 12);
            return 12;
        }
        if (i6 > 0) {
            return i6;
        }
        d.d(e.class, "require the count of network thread  is %d, what is less than the min valid count(%d), so adjust to %d auto", Integer.valueOf(i6), 1, 1);
        return 1;
    }

    /* JADX WARN: Not initialized variable reg: 13, insn: 0x0052: MOVE (r12 I:??[OBJECT, ARRAY]) = (r13 I:??[OBJECT, ARRAY]), block:B:95:0x0052 */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0083 A[Catch: all -> 0x0051, TryCatch #0 {all -> 0x0051, blocks: (B:57:0x0033, B:60:0x003a, B:63:0x003e, B:66:0x0042, B:68:0x0046, B:71:0x004a, B:75:0x007f, B:77:0x0083, B:79:0x0087, B:81:0x008f), top: B:4:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x008f A[Catch: all -> 0x0051, TRY_LEAVE, TryCatch #0 {all -> 0x0051, blocks: (B:57:0x0033, B:60:0x003a, B:63:0x003e, B:66:0x0042, B:68:0x0046, B:71:0x004a, B:75:0x007f, B:77:0x0083, B:79:0x0087, B:81:0x008f), top: B:4:0x0023 }] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private e() {
        /*
            Method dump skipped, instructions count: 487
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.f.e.<init>():void");
    }

    public static e zB() {
        return a.apL;
    }
}
