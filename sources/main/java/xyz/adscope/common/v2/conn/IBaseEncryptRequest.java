package xyz.adscope.common.v2.conn;

import android.content.Context;
import xyz.adscope.common.v2.conn.http.CommonRequestBuilder;
import xyz.adscope.common.v2.conn.http.RequestMethod;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class IBaseEncryptRequest extends IBaseSimpleRequest {
    private String mEncryptPatten;

    public void setEncryptPatten(String str) {
        this.mEncryptPatten = str;
    }

    public IBaseEncryptRequest(Context context, boolean z5) {
        super(context, z5);
        this.mEncryptPatten = "101,1001";
    }

    @Override // xyz.adscope.common.v2.conn.IBaseSimpleRequest
    protected CommonRequestBuilder createNewRequest(RequestMethod requestMethod, String str, IBaseHttpResponseCallback iBaseHttpResponseCallback) {
        CommonRequestBuilder createNewRequest = super.createNewRequest(requestMethod, str, iBaseHttpResponseCallback);
        if (createNewRequest != null) {
            createNewRequest.appendHeader("Accept-Encrypt", this.mEncryptPatten);
            return createNewRequest;
        }
        return super.createNewRequest(requestMethod, str, iBaseHttpResponseCallback);
    }
}
