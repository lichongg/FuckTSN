package com.tencent.mm.opensdk.modelbase;

import android.os.Bundle;
import com.tencent.mm.opensdk.channel.a.a;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class BaseReq {
    public String openId;
    public String transaction;

    public abstract boolean checkArgs();

    public abstract int getType();

    public void fromBundle(Bundle bundle) {
        this.transaction = a.a(bundle, "_wxapi_basereq_transaction");
        this.openId = a.a(bundle, "_wxapi_basereq_openid");
    }

    public void toBundle(Bundle bundle) {
        bundle.putInt("_wxapi_command_type", getType());
        bundle.putString("_wxapi_basereq_transaction", this.transaction);
        bundle.putString("_wxapi_basereq_openid", this.openId);
    }
}
