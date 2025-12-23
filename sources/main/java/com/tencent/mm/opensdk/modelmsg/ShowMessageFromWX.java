package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ShowMessageFromWX {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Req extends BaseReq {
        public String country;
        public String lang;
        public WXMediaMessage message;

        public Req() {
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 4;
        }

        public Req(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            WXMediaMessage wXMediaMessage = this.message;
            if (wXMediaMessage == null) {
                return false;
            }
            return wXMediaMessage.checkArgs();
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            Bundle bundle2 = WXMediaMessage.Builder.toBundle(this.message);
            super.toBundle(bundle2);
            bundle.putString("_wxapi_showmessage_req_lang", this.lang);
            bundle.putString("_wxapi_showmessage_req_country", this.country);
            bundle.putAll(bundle2);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.lang = bundle.getString("_wxapi_showmessage_req_lang");
            this.country = bundle.getString("_wxapi_showmessage_req_country");
            this.message = WXMediaMessage.Builder.fromBundle(bundle);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Resp extends BaseResp {
        public Resp() {
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 4;
        }

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }
    }

    private ShowMessageFromWX() {
    }
}
