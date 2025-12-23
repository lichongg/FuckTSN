package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class WXLiteAppObject implements WXMediaMessage.IMediaObject {
    private static final String TAG = "MicroMsg.SDK.WXLiteAppObject";
    public String path;
    public String query;
    public String userName;
    public String webpageUrl;

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        if (!b.b(this.userName)) {
            return true;
        }
        Log.e(TAG, "userName is null");
        return false;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putString("_wxliteapp_webpageurl", this.webpageUrl);
        bundle.putString("_wxliteapp_username", this.userName);
        bundle.putString("_wxliteapp_path", this.path);
        bundle.putString("_wxliteapp_query", this.query);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 68;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.webpageUrl = bundle.getString("_wxliteapp_webpageurl");
        this.userName = bundle.getString("_wxliteapp_username");
        this.path = bundle.getString("_wxliteapp_path");
        this.query = bundle.getString("_wxliteapp_query");
    }
}
