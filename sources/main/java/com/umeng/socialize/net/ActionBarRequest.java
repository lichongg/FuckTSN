package com.umeng.socialize.net;

import android.text.TextUtils;
import android.util.Base64;
import com.umeng.socialize.Config;
import com.umeng.socialize.net.base.SocializeRequest;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.umeng.socialize.utils.SocializeUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ActionBarRequest extends SocializeRequest {

    /* renamed from: a, reason: collision with root package name */
    private static final String f42410a = "/bar/get/";

    /* renamed from: b, reason: collision with root package name */
    private static final int f42411b = 1;

    /* renamed from: c, reason: collision with root package name */
    private int f42412c;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ActionBarRequest(android.content.Context r7, boolean r8) {
        /*
            r6 = this;
            com.umeng.socialize.net.utils.URequest$RequestMethod r5 = com.umeng.socialize.net.utils.URequest.RequestMethod.GET
            java.lang.String r2 = ""
            java.lang.Class<com.umeng.socialize.net.ActionBarResponse> r3 = com.umeng.socialize.net.ActionBarResponse.class
            r4 = 1
            r0 = r6
            r1 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            r0.mContext = r1
            r0.f42412c = r8
            r0.mMethod = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.ActionBarRequest.<init>(android.content.Context, boolean):void");
    }

    @Override // com.umeng.socialize.net.base.SocializeRequest
    protected String getPath() {
        return f42410a + SocializeUtils.getAppkey(this.mContext) + "/android";
    }

    @Override // com.umeng.socialize.net.base.SocializeRequest, com.umeng.socialize.net.utils.URequest
    public void onPrepareRequest() {
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_DESCRIPTOR, Config.Descriptor);
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_NEW_INSTALL, String.valueOf(this.f42412c));
        if (TextUtils.isEmpty(Config.EntityName)) {
            return;
        }
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_ENTITY_NAME, Config.EntityName);
    }

    @Override // com.umeng.socialize.net.utils.URequest
    public String getEcryptString(String str) {
        return Base64.encodeToString(str.getBytes(), 2);
    }
}
