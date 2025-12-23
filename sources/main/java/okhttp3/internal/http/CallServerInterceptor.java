package okhttp3.internal.http;

import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class CallServerInterceptor implements Interceptor {

    @NotNull
    public static final CallServerInterceptor INSTANCE = new CallServerInterceptor();

    private final boolean shouldIgnoreAndWaitForRealResponse(int i6) {
        if (i6 == 100) {
            return true;
        }
        return 102 <= i6 && i6 < 200;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ff A[Catch: IOException -> 0x010c, TryCatch #4 {IOException -> 0x010c, blocks: (B:28:0x00f9, B:30:0x00ff, B:32:0x0108, B:34:0x010f, B:37:0x0136, B:41:0x0142, B:44:0x014d, B:45:0x0154, B:49:0x0158, B:54:0x016a, B:55:0x01ad, B:57:0x01bc, B:64:0x01d1, B:66:0x01e0, B:67:0x0206, B:68:0x01c6, B:69:0x0194), top: B:27:0x00f9 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00b3  */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v9 */
    @Override // okhttp3.Interceptor
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public okhttp3.Response intercept(@org.jetbrains.annotations.NotNull okhttp3.Interceptor.Chain r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 532
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.CallServerInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }

    private CallServerInterceptor() {
    }
}
