package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class SubscribeMessage {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Req extends BaseReq {
        private static final int LENGTH_LIMIT = 1024;
        private static final String TAG = "MicroMsg.SDK.SubscribeMessage.Req";
        public String reserved;
        public int scene;
        public String templateID;

        public Req() {
        }

        public Req(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            String str;
            String str2 = this.templateID;
            if (str2 == null || str2.length() == 0) {
                str = "checkArgs fail, templateID is null";
            } else if (this.templateID.length() > 1024) {
                str = "checkArgs fail, templateID is too long";
            } else {
                String str3 = this.reserved;
                if (str3 == null || str3.length() <= 1024) {
                    return true;
                }
                str = "checkArgs fail, reserved is too long";
            }
            Log.e(TAG, str);
            return false;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 18;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.scene = bundle.getInt("_wxapi_subscribemessage_req_scene");
            this.templateID = bundle.getString("_wxapi_subscribemessage_req_templateid");
            this.reserved = bundle.getString("_wxapi_subscribemessage_req_reserved");
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putInt("_wxapi_subscribemessage_req_scene", this.scene);
            bundle.putString("_wxapi_subscribemessage_req_templateid", this.templateID);
            bundle.putString("_wxapi_subscribemessage_req_reserved", this.reserved);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Resp extends BaseResp {
        private static final String TAG = "MicroMsg.SDK.SubscribeMessage.Resp";
        public String action;
        public String reserved;
        public int scene;
        public String templateID;

        public Resp() {
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            return true;
        }

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 18;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.templateID = bundle.getString("_wxapi_subscribemessage_resp_templateid");
            this.scene = bundle.getInt("_wxapi_subscribemessage_resp_scene");
            this.action = bundle.getString("_wxapi_subscribemessage_resp_action");
            this.reserved = bundle.getString("_wxapi_subscribemessage_resp_reserved");
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_subscribemessage_resp_templateid", this.templateID);
            bundle.putInt("_wxapi_subscribemessage_resp_scene", this.scene);
            bundle.putString("_wxapi_subscribemessage_resp_action", this.action);
            bundle.putString("_wxapi_subscribemessage_resp_reserved", this.reserved);
        }
    }

    private SubscribeMessage() {
    }
}
