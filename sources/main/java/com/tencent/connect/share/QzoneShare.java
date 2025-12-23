package com.tencent.connect.share;

import android.content.Context;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class QzoneShare extends BaseApi {
    public static final String SHARE_TO_QQ_APP_NAME = "appName";
    public static final String SHARE_TO_QQ_AUDIO_URL = "audio_url";
    public static final String SHARE_TO_QQ_EXT_INT = "cflag";
    public static final String SHARE_TO_QQ_EXT_STR = "share_qq_ext_str";
    public static final String SHARE_TO_QQ_IMAGE_LOCAL_URL = "imageLocalUrl";
    public static final String SHARE_TO_QQ_IMAGE_URL = "imageUrl";
    public static final String SHARE_TO_QQ_SITE = "site";
    public static final String SHARE_TO_QQ_SUMMARY = "summary";
    public static final String SHARE_TO_QQ_TARGET_URL = "targetUrl";
    public static final String SHARE_TO_QQ_TITLE = "title";
    public static final String SHARE_TO_QZONE_EXTMAP = "extMap";
    public static final String SHARE_TO_QZONE_KEY_TYPE = "req_type";
    public static final int SHARE_TO_QZONE_TYPE_IMAGE = 5;
    public static final int SHARE_TO_QZONE_TYPE_IMAGE_TEXT = 1;
    public static final int SHARE_TO_QZONE_TYPE_MINI_PROGRAM = 7;
    public static final int SHARE_TO_QZONE_TYPE_NO_TYPE = 0;

    /* renamed from: a, reason: collision with root package name */
    private boolean f40395a;

    /* renamed from: d, reason: collision with root package name */
    private boolean f40396d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f40397e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f40398f;
    public String mViaShareQzoneType;

    /* JADX WARN: Removed duplicated region for block: B:20:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x03a2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x03b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(android.app.Activity r24, android.os.Bundle r25, com.tencent.tauth.IUiListener r26) {
        /*
            Method dump skipped, instructions count: 984
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.share.QzoneShare.b(android.app.Activity, android.os.Bundle, com.tencent.tauth.IUiListener):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x03b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void shareToQzone(android.app.Activity r28, android.os.Bundle r29, com.tencent.tauth.IUiListener r30) {
        /*
            Method dump skipped, instructions count: 1105
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.share.QzoneShare.shareToQzone(android.app.Activity, android.os.Bundle, com.tencent.tauth.IUiListener):void");
    }

    public QzoneShare(Context context, QQToken qQToken) {
        super(qQToken);
        this.mViaShareQzoneType = "";
        this.f40395a = true;
        this.f40396d = false;
        this.f40397e = false;
        this.f40398f = false;
    }

    @Override // com.tencent.connect.common.BaseApi
    public void releaseResource() {
    }
}
