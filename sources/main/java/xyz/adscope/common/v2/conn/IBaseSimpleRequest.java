package xyz.adscope.common.v2.conn;

import android.content.Context;
import xyz.adscope.common.v2.conn.http.CommonRequestBuilder;
import xyz.adscope.common.v2.conn.http.RequestMethod;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class IBaseSimpleRequest implements IBaseHttpRequest {
    private final boolean mAutoRedirect;
    protected final Context mContext;

    protected CommonRequestBuilder createNewRequest(RequestMethod requestMethod, String str, IBaseHttpResponseCallback iBaseHttpResponseCallback) {
        CommonRequestBuilder concern = new CommonRequestBuilder().autoRedirected(this.mAutoRedirect).concern(iBaseHttpResponseCallback);
        if (RequestMethod.POST == requestMethod) {
            concern.post(str);
        }
        if (RequestMethod.GET == requestMethod) {
            concern.get(str);
        }
        if (RequestMethod.STREAM == requestMethod) {
            concern.postStream(str);
            concern.appendHeader("Content-Type", "application/octet-stream");
        }
        return concern;
    }

    @Override // xyz.adscope.common.v2.conn.IBaseHttpRequest
    public void requestWithGetMethod(String str, IBaseHttpResponseCallback iBaseHttpResponseCallback) {
        CommonRequestBuilder createNewRequest = createNewRequest(RequestMethod.GET, str, iBaseHttpResponseCallback);
        if (createNewRequest != null) {
            createNewRequest.perform(this.mContext);
        }
    }

    @Override // xyz.adscope.common.v2.conn.IBaseHttpRequest
    public void requestWithPostMethod(String str, String str2, IBaseHttpResponseCallback iBaseHttpResponseCallback) {
        CommonRequestBuilder createNewRequest = createNewRequest(RequestMethod.POST, str, iBaseHttpResponseCallback);
        if (createNewRequest != null) {
            createNewRequest.body(str2.getBytes()).perform(this.mContext);
        }
    }

    @Override // xyz.adscope.common.v2.conn.IBaseHttpRequest
    public void requestWithStreamMethod(String str, byte[] bArr, IBaseHttpResponseCallback iBaseHttpResponseCallback) {
        CommonRequestBuilder createNewRequest = createNewRequest(RequestMethod.STREAM, str, iBaseHttpResponseCallback);
        if (createNewRequest != null) {
            createNewRequest.body(bArr).perform(this.mContext);
        }
    }

    public IBaseSimpleRequest(Context context, boolean z5) {
        this.mContext = context;
        this.mAutoRedirect = z5;
    }
}
