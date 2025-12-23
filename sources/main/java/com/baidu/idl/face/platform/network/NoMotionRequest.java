package com.baidu.idl.face.platform.network;

import android.os.Handler;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class NoMotionRequest extends BaseRequest {
    private static final String TAG = "NoMotionRequest";
    public static final String URL_POST_NOMOTION_LIVENESS = "";

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01a6 A[Catch: IOException -> 0x01a2, TryCatch #35 {IOException -> 0x01a2, blocks: (B:113:0x019e, B:101:0x01a6, B:103:0x01ab, B:105:0x01b0), top: B:112:0x019e }] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01ab A[Catch: IOException -> 0x01a2, TryCatch #35 {IOException -> 0x01a2, blocks: (B:113:0x019e, B:101:0x01a6, B:103:0x01ab, B:105:0x01b0), top: B:112:0x019e }] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01b0 A[Catch: IOException -> 0x01a2, TRY_LEAVE, TryCatch #35 {IOException -> 0x01a2, blocks: (B:113:0x019e, B:101:0x01a6, B:103:0x01ab, B:105:0x01b0), top: B:112:0x019e }] */
    /* JADX WARN: Removed duplicated region for block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x019e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0184 A[Catch: IOException -> 0x0180, TryCatch #15 {IOException -> 0x0180, blocks: (B:131:0x017c, B:119:0x0184, B:121:0x0189, B:123:0x018e), top: B:130:0x017c }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0189 A[Catch: IOException -> 0x0180, TryCatch #15 {IOException -> 0x0180, blocks: (B:131:0x017c, B:119:0x0184, B:121:0x0189, B:123:0x018e), top: B:130:0x017c }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x018e A[Catch: IOException -> 0x0180, TRY_LEAVE, TryCatch #15 {IOException -> 0x0180, blocks: (B:131:0x017c, B:119:0x0184, B:121:0x0189, B:123:0x018e), top: B:130:0x017c }] */
    /* JADX WARN: Removed duplicated region for block: B:129:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x017c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x022c A[Catch: IOException -> 0x0228, TryCatch #29 {IOException -> 0x0228, blocks: (B:160:0x0224, B:146:0x022c, B:148:0x0231, B:150:0x0236), top: B:159:0x0224 }] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0231 A[Catch: IOException -> 0x0228, TryCatch #29 {IOException -> 0x0228, blocks: (B:160:0x0224, B:146:0x022c, B:148:0x0231, B:150:0x0236), top: B:159:0x0224 }] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0236 A[Catch: IOException -> 0x0228, TRY_LEAVE, TryCatch #29 {IOException -> 0x0228, blocks: (B:160:0x0224, B:146:0x022c, B:148:0x0231, B:150:0x0236), top: B:159:0x0224 }] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:158:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0224 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01ea A[Catch: IOException -> 0x01e6, TryCatch #32 {IOException -> 0x01e6, blocks: (B:59:0x01e2, B:47:0x01ea, B:49:0x01ef, B:51:0x01f4), top: B:58:0x01e2 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01ef A[Catch: IOException -> 0x01e6, TryCatch #32 {IOException -> 0x01e6, blocks: (B:59:0x01e2, B:47:0x01ea, B:49:0x01ef, B:51:0x01f4), top: B:58:0x01e2 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01f4 A[Catch: IOException -> 0x01e6, TRY_LEAVE, TryCatch #32 {IOException -> 0x01e6, blocks: (B:59:0x01e2, B:47:0x01ea, B:49:0x01ef, B:51:0x01f4), top: B:58:0x01e2 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x020c A[Catch: IOException -> 0x0208, TryCatch #12 {IOException -> 0x0208, blocks: (B:77:0x0204, B:65:0x020c, B:67:0x0211, B:69:0x0216), top: B:76:0x0204 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0211 A[Catch: IOException -> 0x0208, TryCatch #12 {IOException -> 0x0208, blocks: (B:77:0x0204, B:65:0x020c, B:67:0x0211, B:69:0x0216), top: B:76:0x0204 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0216 A[Catch: IOException -> 0x0208, TRY_LEAVE, TryCatch #12 {IOException -> 0x0208, blocks: (B:77:0x0204, B:65:0x020c, B:67:0x0211, B:69:0x0216), top: B:76:0x0204 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0204 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01c8 A[Catch: IOException -> 0x01c4, TryCatch #14 {IOException -> 0x01c4, blocks: (B:95:0x01c0, B:83:0x01c8, B:85:0x01cd, B:87:0x01d2), top: B:94:0x01c0 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01cd A[Catch: IOException -> 0x01c4, TryCatch #14 {IOException -> 0x01c4, blocks: (B:95:0x01c0, B:83:0x01c8, B:85:0x01cd, B:87:0x01d2), top: B:94:0x01c0 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01d2 A[Catch: IOException -> 0x01c4, TRY_LEAVE, TryCatch #14 {IOException -> 0x01c4, blocks: (B:95:0x01c0, B:83:0x01c8, B:85:0x01cd, B:87:0x01d2), top: B:94:0x01c0 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v57 */
    /* JADX WARN: Type inference failed for: r0v58 */
    /* JADX WARN: Type inference failed for: r0v59 */
    /* JADX WARN: Type inference failed for: r0v60 */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r5v12, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v13, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v14, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v15, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v16, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v17, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v38 */
    /* JADX WARN: Type inference failed for: r5v40 */
    /* JADX WARN: Type inference failed for: r5v42 */
    /* JADX WARN: Type inference failed for: r5v44 */
    /* JADX WARN: Type inference failed for: r5v46 */
    /* JADX WARN: Type inference failed for: r5v48 */
    /* JADX WARN: Type inference failed for: r5v53 */
    /* JADX WARN: Type inference failed for: r5v54 */
    /* JADX WARN: Type inference failed for: r5v55 */
    /* JADX WARN: Type inference failed for: r5v56 */
    /* JADX WARN: Type inference failed for: r5v57 */
    /* JADX WARN: Type inference failed for: r5v58 */
    /* JADX WARN: Type inference failed for: r5v59 */
    /* JADX WARN: Type inference failed for: r5v60 */
    /* JADX WARN: Type inference failed for: r5v61 */
    /* JADX WARN: Type inference failed for: r5v62 */
    /* JADX WARN: Type inference failed for: r5v63 */
    /* JADX WARN: Type inference failed for: r5v64 */
    /* JADX WARN: Type inference failed for: r5v65 */
    /* JADX WARN: Type inference failed for: r5v66 */
    /* JADX WARN: Type inference failed for: r5v67 */
    /* JADX WARN: Type inference failed for: r5v68 */
    /* JADX WARN: Type inference failed for: r5v69 */
    /* JADX WARN: Type inference failed for: r9v19, types: [int] */
    /* JADX WARN: Type inference failed for: r9v59 */
    /* JADX WARN: Type inference failed for: r9v60 */
    /* JADX WARN: Type inference failed for: r9v61 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void httpUrlConnectionPost(java.lang.String r9, android.os.Handler r10) {
        /*
            Method dump skipped, instructions count: 591
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.idl.face.platform.network.NoMotionRequest.httpUrlConnectionPost(java.lang.String, android.os.Handler):void");
    }

    public static void sendMessage(final String str, final Handler handler) {
        if (str == null || str.length() <= 0) {
            return;
        }
        new Thread(new Runnable() { // from class: com.baidu.idl.face.platform.network.NoMotionRequest.1
            @Override // java.lang.Runnable
            public void run() {
                NoMotionRequest.httpUrlConnectionPost(str, handler);
            }
        }).start();
    }
}
