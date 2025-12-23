package com.baidu.idl.face.platform.network;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class LogRequest extends BaseRequest {
    public static final String URL_GET_LOG = "";

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x018f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0167 A[Catch: IOException -> 0x00e4, TRY_ENTER, TryCatch #30 {IOException -> 0x00e4, blocks: (B:22:0x00d3, B:24:0x00d8, B:26:0x00dd, B:27:0x00e0, B:82:0x0123, B:84:0x0128, B:86:0x012d, B:41:0x0132, B:71:0x013d, B:73:0x0142, B:75:0x0147, B:60:0x0152, B:62:0x0157, B:64:0x015c, B:35:0x0167, B:37:0x016c, B:39:0x0171, B:49:0x017c, B:51:0x0181, B:53:0x0186), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x016c A[Catch: IOException -> 0x00e4, TryCatch #30 {IOException -> 0x00e4, blocks: (B:22:0x00d3, B:24:0x00d8, B:26:0x00dd, B:27:0x00e0, B:82:0x0123, B:84:0x0128, B:86:0x012d, B:41:0x0132, B:71:0x013d, B:73:0x0142, B:75:0x0147, B:60:0x0152, B:62:0x0157, B:64:0x015c, B:35:0x0167, B:37:0x016c, B:39:0x0171, B:49:0x017c, B:51:0x0181, B:53:0x0186), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0171 A[Catch: IOException -> 0x00e4, TRY_LEAVE, TryCatch #30 {IOException -> 0x00e4, blocks: (B:22:0x00d3, B:24:0x00d8, B:26:0x00dd, B:27:0x00e0, B:82:0x0123, B:84:0x0128, B:86:0x012d, B:41:0x0132, B:71:0x013d, B:73:0x0142, B:75:0x0147, B:60:0x0152, B:62:0x0157, B:64:0x015c, B:35:0x0167, B:37:0x016c, B:39:0x0171, B:49:0x017c, B:51:0x0181, B:53:0x0186), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x017c A[Catch: IOException -> 0x00e4, TRY_ENTER, TryCatch #30 {IOException -> 0x00e4, blocks: (B:22:0x00d3, B:24:0x00d8, B:26:0x00dd, B:27:0x00e0, B:82:0x0123, B:84:0x0128, B:86:0x012d, B:41:0x0132, B:71:0x013d, B:73:0x0142, B:75:0x0147, B:60:0x0152, B:62:0x0157, B:64:0x015c, B:35:0x0167, B:37:0x016c, B:39:0x0171, B:49:0x017c, B:51:0x0181, B:53:0x0186), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0181 A[Catch: IOException -> 0x00e4, TryCatch #30 {IOException -> 0x00e4, blocks: (B:22:0x00d3, B:24:0x00d8, B:26:0x00dd, B:27:0x00e0, B:82:0x0123, B:84:0x0128, B:86:0x012d, B:41:0x0132, B:71:0x013d, B:73:0x0142, B:75:0x0147, B:60:0x0152, B:62:0x0157, B:64:0x015c, B:35:0x0167, B:37:0x016c, B:39:0x0171, B:49:0x017c, B:51:0x0181, B:53:0x0186), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0186 A[Catch: IOException -> 0x00e4, TRY_LEAVE, TryCatch #30 {IOException -> 0x00e4, blocks: (B:22:0x00d3, B:24:0x00d8, B:26:0x00dd, B:27:0x00e0, B:82:0x0123, B:84:0x0128, B:86:0x012d, B:41:0x0132, B:71:0x013d, B:73:0x0142, B:75:0x0147, B:60:0x0152, B:62:0x0157, B:64:0x015c, B:35:0x0167, B:37:0x016c, B:39:0x0171, B:49:0x017c, B:51:0x0181, B:53:0x0186), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0152 A[Catch: IOException -> 0x00e4, TRY_ENTER, TryCatch #30 {IOException -> 0x00e4, blocks: (B:22:0x00d3, B:24:0x00d8, B:26:0x00dd, B:27:0x00e0, B:82:0x0123, B:84:0x0128, B:86:0x012d, B:41:0x0132, B:71:0x013d, B:73:0x0142, B:75:0x0147, B:60:0x0152, B:62:0x0157, B:64:0x015c, B:35:0x0167, B:37:0x016c, B:39:0x0171, B:49:0x017c, B:51:0x0181, B:53:0x0186), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0157 A[Catch: IOException -> 0x00e4, TryCatch #30 {IOException -> 0x00e4, blocks: (B:22:0x00d3, B:24:0x00d8, B:26:0x00dd, B:27:0x00e0, B:82:0x0123, B:84:0x0128, B:86:0x012d, B:41:0x0132, B:71:0x013d, B:73:0x0142, B:75:0x0147, B:60:0x0152, B:62:0x0157, B:64:0x015c, B:35:0x0167, B:37:0x016c, B:39:0x0171, B:49:0x017c, B:51:0x0181, B:53:0x0186), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x015c A[Catch: IOException -> 0x00e4, TRY_LEAVE, TryCatch #30 {IOException -> 0x00e4, blocks: (B:22:0x00d3, B:24:0x00d8, B:26:0x00dd, B:27:0x00e0, B:82:0x0123, B:84:0x0128, B:86:0x012d, B:41:0x0132, B:71:0x013d, B:73:0x0142, B:75:0x0147, B:60:0x0152, B:62:0x0157, B:64:0x015c, B:35:0x0167, B:37:0x016c, B:39:0x0171, B:49:0x017c, B:51:0x0181, B:53:0x0186), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x013d A[Catch: IOException -> 0x00e4, TRY_ENTER, TryCatch #30 {IOException -> 0x00e4, blocks: (B:22:0x00d3, B:24:0x00d8, B:26:0x00dd, B:27:0x00e0, B:82:0x0123, B:84:0x0128, B:86:0x012d, B:41:0x0132, B:71:0x013d, B:73:0x0142, B:75:0x0147, B:60:0x0152, B:62:0x0157, B:64:0x015c, B:35:0x0167, B:37:0x016c, B:39:0x0171, B:49:0x017c, B:51:0x0181, B:53:0x0186), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0142 A[Catch: IOException -> 0x00e4, TryCatch #30 {IOException -> 0x00e4, blocks: (B:22:0x00d3, B:24:0x00d8, B:26:0x00dd, B:27:0x00e0, B:82:0x0123, B:84:0x0128, B:86:0x012d, B:41:0x0132, B:71:0x013d, B:73:0x0142, B:75:0x0147, B:60:0x0152, B:62:0x0157, B:64:0x015c, B:35:0x0167, B:37:0x016c, B:39:0x0171, B:49:0x017c, B:51:0x0181, B:53:0x0186), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0147 A[Catch: IOException -> 0x00e4, TRY_LEAVE, TryCatch #30 {IOException -> 0x00e4, blocks: (B:22:0x00d3, B:24:0x00d8, B:26:0x00dd, B:27:0x00e0, B:82:0x0123, B:84:0x0128, B:86:0x012d, B:41:0x0132, B:71:0x013d, B:73:0x0142, B:75:0x0147, B:60:0x0152, B:62:0x0157, B:64:0x015c, B:35:0x0167, B:37:0x016c, B:39:0x0171, B:49:0x017c, B:51:0x0181, B:53:0x0186), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0123 A[Catch: IOException -> 0x00e4, TRY_ENTER, TryCatch #30 {IOException -> 0x00e4, blocks: (B:22:0x00d3, B:24:0x00d8, B:26:0x00dd, B:27:0x00e0, B:82:0x0123, B:84:0x0128, B:86:0x012d, B:41:0x0132, B:71:0x013d, B:73:0x0142, B:75:0x0147, B:60:0x0152, B:62:0x0157, B:64:0x015c, B:35:0x0167, B:37:0x016c, B:39:0x0171, B:49:0x017c, B:51:0x0181, B:53:0x0186), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0128 A[Catch: IOException -> 0x00e4, TryCatch #30 {IOException -> 0x00e4, blocks: (B:22:0x00d3, B:24:0x00d8, B:26:0x00dd, B:27:0x00e0, B:82:0x0123, B:84:0x0128, B:86:0x012d, B:41:0x0132, B:71:0x013d, B:73:0x0142, B:75:0x0147, B:60:0x0152, B:62:0x0157, B:64:0x015c, B:35:0x0167, B:37:0x016c, B:39:0x0171, B:49:0x017c, B:51:0x0181, B:53:0x0186), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x012d A[Catch: IOException -> 0x00e4, TryCatch #30 {IOException -> 0x00e4, blocks: (B:22:0x00d3, B:24:0x00d8, B:26:0x00dd, B:27:0x00e0, B:82:0x0123, B:84:0x0128, B:86:0x012d, B:41:0x0132, B:71:0x013d, B:73:0x0142, B:75:0x0147, B:60:0x0152, B:62:0x0157, B:64:0x015c, B:35:0x0167, B:37:0x016c, B:39:0x0171, B:49:0x017c, B:51:0x0181, B:53:0x0186), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0197 A[Catch: IOException -> 0x0193, TryCatch #20 {IOException -> 0x0193, blocks: (B:104:0x018f, B:93:0x0197, B:95:0x019c, B:97:0x01a1), top: B:103:0x018f }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x019c A[Catch: IOException -> 0x0193, TryCatch #20 {IOException -> 0x0193, blocks: (B:104:0x018f, B:93:0x0197, B:95:0x019c, B:97:0x01a1), top: B:103:0x018f }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01a1 A[Catch: IOException -> 0x0193, TRY_LEAVE, TryCatch #20 {IOException -> 0x0193, blocks: (B:104:0x018f, B:93:0x0197, B:95:0x019c, B:97:0x01a1), top: B:103:0x018f }] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v13, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v14, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v15, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v16, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v17, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v32 */
    /* JADX WARN: Type inference failed for: r4v33 */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v36 */
    /* JADX WARN: Type inference failed for: r4v37 */
    /* JADX WARN: Type inference failed for: r4v38 */
    /* JADX WARN: Type inference failed for: r4v44, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v46 */
    /* JADX WARN: Type inference failed for: r4v47 */
    /* JADX WARN: Type inference failed for: r4v48 */
    /* JADX WARN: Type inference failed for: r4v49 */
    /* JADX WARN: Type inference failed for: r4v50 */
    /* JADX WARN: Type inference failed for: r4v51 */
    /* JADX WARN: Type inference failed for: r4v52 */
    /* JADX WARN: Type inference failed for: r4v53 */
    /* JADX WARN: Type inference failed for: r4v54 */
    /* JADX WARN: Type inference failed for: r4v55 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v15, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v25, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v27 */
    /* JADX WARN: Type inference failed for: r9v28 */
    /* JADX WARN: Type inference failed for: r9v29 */
    /* JADX WARN: Type inference failed for: r9v30 */
    /* JADX WARN: Type inference failed for: r9v31 */
    /* JADX WARN: Type inference failed for: r9v32 */
    /* JADX WARN: Type inference failed for: r9v33 */
    /* JADX WARN: Type inference failed for: r9v34 */
    /* JADX WARN: Type inference failed for: r9v35 */
    /* JADX WARN: Type inference failed for: r9v41 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void httpUrlConnectionPost(java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 425
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.idl.face.platform.network.LogRequest.httpUrlConnectionPost(java.lang.String):void");
    }

    public static void sendLogMessage(final String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        new Thread(new Runnable() { // from class: com.baidu.idl.face.platform.network.LogRequest.1
            @Override // java.lang.Runnable
            public void run() {
                LogRequest.httpUrlConnectionPost(str);
            }
        }).start();
    }
}
