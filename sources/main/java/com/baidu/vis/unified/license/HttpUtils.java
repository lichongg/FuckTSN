package com.baidu.vis.unified.license;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class HttpUtils {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0155 A[Catch: IOException -> 0x014c, TRY_LEAVE, TryCatch #19 {IOException -> 0x014c, blocks: (B:110:0x0148, B:98:0x0150, B:100:0x0155), top: B:109:0x0148 }] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:108:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0148 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0136 A[Catch: IOException -> 0x0132, TryCatch #4 {IOException -> 0x0132, blocks: (B:53:0x012e, B:41:0x0136, B:43:0x013b), top: B:52:0x012e }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x013b A[Catch: IOException -> 0x0132, TRY_LEAVE, TryCatch #4 {IOException -> 0x0132, blocks: (B:53:0x012e, B:41:0x0136, B:43:0x013b), top: B:52:0x012e }] */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x012e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0117 A[Catch: IOException -> 0x0113, TryCatch #13 {IOException -> 0x0113, blocks: (B:69:0x010f, B:59:0x0117, B:61:0x011c), top: B:68:0x010f }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x011c A[Catch: IOException -> 0x0113, TRY_LEAVE, TryCatch #13 {IOException -> 0x0113, blocks: (B:69:0x010f, B:59:0x0117, B:61:0x011c), top: B:68:0x010f }] */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x010f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f5 A[Catch: IOException -> 0x00f1, TryCatch #3 {IOException -> 0x00f1, blocks: (B:85:0x00ed, B:75:0x00f5, B:77:0x00fa), top: B:84:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00fa A[Catch: IOException -> 0x00f1, TRY_LEAVE, TryCatch #3 {IOException -> 0x00f1, blocks: (B:85:0x00ed, B:75:0x00f5, B:77:0x00fa), top: B:84:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0150 A[Catch: IOException -> 0x014c, TryCatch #19 {IOException -> 0x014c, blocks: (B:110:0x0148, B:98:0x0150, B:100:0x0155), top: B:109:0x0148 }] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v19, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v18, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v10, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v13, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v14, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v27, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v28, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v29 */
    /* JADX WARN: Type inference failed for: r9v30 */
    /* JADX WARN: Type inference failed for: r9v31 */
    /* JADX WARN: Type inference failed for: r9v32 */
    /* JADX WARN: Type inference failed for: r9v33 */
    /* JADX WARN: Type inference failed for: r9v34 */
    /* JADX WARN: Type inference failed for: r9v35 */
    /* JADX WARN: Type inference failed for: r9v36 */
    /* JADX WARN: Type inference failed for: r9v37 */
    /* JADX WARN: Type inference failed for: r9v38 */
    /* JADX WARN: Type inference failed for: r9v39 */
    /* JADX WARN: Type inference failed for: r9v40 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.baidu.vis.unified.license.HttpStatus requestPost(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.vis.unified.license.HttpUtils.requestPost(java.lang.String, java.lang.String, java.lang.String, java.lang.String):com.baidu.vis.unified.license.HttpStatus");
    }
}
