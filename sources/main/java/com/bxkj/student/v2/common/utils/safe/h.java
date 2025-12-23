package com.bxkj.student.v2.common.utils.safe;

import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSoIsUnderTracedCheck.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SoIsUnderTracedCheck.kt\ncom/bxkj/student/v2/common/utils/safe/SoIsUnderTracedCheck\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 Strings.kt\nkotlin/text/StringsKt__StringsKt\n*L\n1#1,44:1\n1#2:45\n37#3,2:46\n106#4:48\n78#4,22:49\n*S KotlinDebug\n*F\n+ 1 SoIsUnderTracedCheck.kt\ncom/bxkj/student/v2/common/utils/safe/SoIsUnderTracedCheck\n*L\n29#1:46,2\n31#1:48\n31#1:49,22\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f20948a = new h();

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0097, code lost:
    
        r0.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a() {
        /*
            r12 = this;
            java.util.Locale r0 = java.util.Locale.US
            int r1 = android.os.Process.myPid()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r4 = 0
            r3[r4] = r1
            java.lang.String r1 = "/proc/%d/status"
            java.lang.String r0 = java.lang.String.format(r0, r1, r3)
            java.lang.String r1 = "format(...)"
            kotlin.jvm.internal.g0.o(r0, r1)
            java.io.File r1 = new java.io.File
            r1.<init>(r0)
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Exception -> L9a
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Exception -> L9a
            r3.<init>(r1)     // Catch: java.lang.Exception -> L9a
            r0.<init>(r3)     // Catch: java.lang.Exception -> L9a
        L2a:
            java.lang.String r5 = r0.readLine()     // Catch: java.lang.Exception -> L9a
            kotlin.jvm.internal.g0.m(r5)     // Catch: java.lang.Exception -> L9a
            if (r5 == 0) goto L97
            java.lang.String r1 = "TracerPid"
            r3 = 0
            r11 = 2
            boolean r1 = kotlin.text.u.l3(r5, r1, r4, r11, r3)     // Catch: java.lang.Exception -> L9a
            if (r1 == 0) goto L2a
            java.lang.String r1 = ":"
            java.lang.String[] r6 = new java.lang.String[]{r1}     // Catch: java.lang.Exception -> L9a
            r9 = 6
            r10 = 0
            r7 = 0
            r8 = 0
            java.util.List r1 = kotlin.text.u.m5(r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Exception -> L9a
            java.util.Collection r1 = (java.util.Collection) r1     // Catch: java.lang.Exception -> L9a
            java.lang.String[] r3 = new java.lang.String[r4]     // Catch: java.lang.Exception -> L9a
            java.lang.Object[] r1 = r1.toArray(r3)     // Catch: java.lang.Exception -> L9a
            java.lang.String[] r1 = (java.lang.String[]) r1     // Catch: java.lang.Exception -> L9a
            int r3 = r1.length     // Catch: java.lang.Exception -> L9a
            if (r3 != r11) goto L2a
            r1 = r1[r2]     // Catch: java.lang.Exception -> L9a
            int r3 = r1.length()     // Catch: java.lang.Exception -> L9a
            int r3 = r3 - r2
            r5 = 0
            r6 = 0
        L61:
            if (r5 > r3) goto L86
            if (r6 != 0) goto L67
            r7 = r5
            goto L68
        L67:
            r7 = r3
        L68:
            char r7 = r1.charAt(r7)     // Catch: java.lang.Exception -> L9a
            r8 = 32
            int r7 = kotlin.jvm.internal.g0.t(r7, r8)     // Catch: java.lang.Exception -> L9a
            if (r7 > 0) goto L76
            r7 = 1
            goto L77
        L76:
            r7 = 0
        L77:
            if (r6 != 0) goto L80
            if (r7 != 0) goto L7d
            r6 = 1
            goto L61
        L7d:
            int r5 = r5 + 1
            goto L61
        L80:
            if (r7 != 0) goto L83
            goto L86
        L83:
            int r3 = r3 + (-1)
            goto L61
        L86:
            int r3 = r3 + 1
            java.lang.CharSequence r1 = r1.subSequence(r5, r3)     // Catch: java.lang.Exception -> L9a
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L9a
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.Exception -> L9a
            if (r1 == 0) goto L2a
            return r2
        L97:
            r0.close()     // Catch: java.lang.Exception -> L9a
        L9a:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.common.utils.safe.h.a():boolean");
    }

    private h() {
    }
}
