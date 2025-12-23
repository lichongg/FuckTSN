package com.baidu.idl.face.platform.ui.utils;

import android.content.Context;
import com.baidu.idl.face.platform.FaceSDKManager;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.net.URLDecoder;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class SecRequest {
    private static final String REQUEST_URL = "http://10.138.32.176:8518/api/v3/person/verify_sec?appid=7758258";
    private static final String TAG = "SecRequest";

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0153, code lost:
    
        if (r8 != 0) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x013b, code lost:
    
        if (r8 != 0) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0121, code lost:
    
        if (r8 != 0) goto L125;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0146 A[Catch: Exception -> 0x00d2, TRY_ENTER, TryCatch #19 {Exception -> 0x00d2, blocks: (B:24:0x00c9, B:26:0x00ce, B:28:0x00d6, B:29:0x00d9, B:60:0x0114, B:62:0x0119, B:64:0x011e, B:50:0x012e, B:52:0x0133, B:54:0x0138, B:38:0x0146, B:40:0x014b, B:42:0x0150), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x014b A[Catch: Exception -> 0x00d2, TryCatch #19 {Exception -> 0x00d2, blocks: (B:24:0x00c9, B:26:0x00ce, B:28:0x00d6, B:29:0x00d9, B:60:0x0114, B:62:0x0119, B:64:0x011e, B:50:0x012e, B:52:0x0133, B:54:0x0138, B:38:0x0146, B:40:0x014b, B:42:0x0150), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0150 A[Catch: Exception -> 0x00d2, TRY_LEAVE, TryCatch #19 {Exception -> 0x00d2, blocks: (B:24:0x00c9, B:26:0x00ce, B:28:0x00d6, B:29:0x00d9, B:60:0x0114, B:62:0x0119, B:64:0x011e, B:50:0x012e, B:52:0x0133, B:54:0x0138, B:38:0x0146, B:40:0x014b, B:42:0x0150), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012e A[Catch: Exception -> 0x00d2, TRY_ENTER, TryCatch #19 {Exception -> 0x00d2, blocks: (B:24:0x00c9, B:26:0x00ce, B:28:0x00d6, B:29:0x00d9, B:60:0x0114, B:62:0x0119, B:64:0x011e, B:50:0x012e, B:52:0x0133, B:54:0x0138, B:38:0x0146, B:40:0x014b, B:42:0x0150), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0133 A[Catch: Exception -> 0x00d2, TryCatch #19 {Exception -> 0x00d2, blocks: (B:24:0x00c9, B:26:0x00ce, B:28:0x00d6, B:29:0x00d9, B:60:0x0114, B:62:0x0119, B:64:0x011e, B:50:0x012e, B:52:0x0133, B:54:0x0138, B:38:0x0146, B:40:0x014b, B:42:0x0150), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0138 A[Catch: Exception -> 0x00d2, TRY_LEAVE, TryCatch #19 {Exception -> 0x00d2, blocks: (B:24:0x00c9, B:26:0x00ce, B:28:0x00d6, B:29:0x00d9, B:60:0x0114, B:62:0x0119, B:64:0x011e, B:50:0x012e, B:52:0x0133, B:54:0x0138, B:38:0x0146, B:40:0x014b, B:42:0x0150), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0114 A[Catch: Exception -> 0x00d2, TRY_ENTER, TryCatch #19 {Exception -> 0x00d2, blocks: (B:24:0x00c9, B:26:0x00ce, B:28:0x00d6, B:29:0x00d9, B:60:0x0114, B:62:0x0119, B:64:0x011e, B:50:0x012e, B:52:0x0133, B:54:0x0138, B:38:0x0146, B:40:0x014b, B:42:0x0150), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0119 A[Catch: Exception -> 0x00d2, TryCatch #19 {Exception -> 0x00d2, blocks: (B:24:0x00c9, B:26:0x00ce, B:28:0x00d6, B:29:0x00d9, B:60:0x0114, B:62:0x0119, B:64:0x011e, B:50:0x012e, B:52:0x0133, B:54:0x0138, B:38:0x0146, B:40:0x014b, B:42:0x0150), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x011e A[Catch: Exception -> 0x00d2, TRY_LEAVE, TryCatch #19 {Exception -> 0x00d2, blocks: (B:24:0x00c9, B:26:0x00ce, B:28:0x00d6, B:29:0x00d9, B:60:0x0114, B:62:0x0119, B:64:0x011e, B:50:0x012e, B:52:0x0133, B:54:0x0138, B:38:0x0146, B:40:0x014b, B:42:0x0150), top: B:2:0x0003 }] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v38 */
    /* JADX WARN: Type inference failed for: r3v39 */
    /* JADX WARN: Type inference failed for: r3v40 */
    /* JADX WARN: Type inference failed for: r3v41, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v42 */
    /* JADX WARN: Type inference failed for: r3v43 */
    /* JADX WARN: Type inference failed for: r3v44 */
    /* JADX WARN: Type inference failed for: r3v45 */
    /* JADX WARN: Type inference failed for: r3v46 */
    /* JADX WARN: Type inference failed for: r3v47 */
    /* JADX WARN: Type inference failed for: r3v48 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v12, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v13, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v30 */
    /* JADX WARN: Type inference failed for: r7v35, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v37 */
    /* JADX WARN: Type inference failed for: r7v38 */
    /* JADX WARN: Type inference failed for: r7v39 */
    /* JADX WARN: Type inference failed for: r7v40 */
    /* JADX WARN: Type inference failed for: r7v41 */
    /* JADX WARN: Type inference failed for: r7v42 */
    /* JADX WARN: Type inference failed for: r7v43 */
    /* JADX WARN: Type inference failed for: r7v44 */
    /* JADX WARN: Type inference failed for: r7v45 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v16, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String requestPost(java.lang.String r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 371
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.idl.face.platform.ui.utils.SecRequest.requestPost(java.lang.String, java.lang.String):java.lang.String");
    }

    public static void sendMessage(final Context context, final String str, final int i6) {
        new Thread(new Runnable() { // from class: com.baidu.idl.face.platform.ui.utils.SecRequest.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("image_type", "BASE64");
                    jSONObject.put(SocializeProtocolConstants.IMAGE, str);
                    jSONObject.put("id_card_number", "101111111111111111");
                    jSONObject.put(CommonNetImpl.NAME, URLDecoder.decode("张三", "UTF-8"));
                    jSONObject.put("quality_control", "NONE");
                    jSONObject.put("liveness_control", "NONE");
                    jSONObject.put("risk_identify", false);
                    jSONObject.put(bi.al, FaceSDKManager.getInstance().getZid(context));
                    jSONObject.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP, "172.30.154.173");
                    jSONObject.put("phone", "13000000000");
                    int i7 = i6;
                    if (i7 == 0) {
                        jSONObject.put("image_sec", false);
                    } else if (i7 == 1) {
                        jSONObject.put("image_sec", true);
                    }
                    jSONObject.put(Constants.JumpUrlConstants.SRC_TYPE_APP, "Android");
                    jSONObject.put("ev", "smrz");
                    SecRequest.requestPost(jSONObject.toString(), SecRequest.REQUEST_URL);
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
        }).start();
    }
}
