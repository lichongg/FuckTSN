package xyz.adscope.amps.tool.request;

import android.telephony.mbms.FileInfo;
import java.io.File;
import xyz.adscope.amps.manager.AMPSSDKManager;
import xyz.adscope.amps.model.AMPSGlobalModel;
import xyz.adscope.amps.tool.AMPSSecurityUtil;
import xyz.adscope.amps.tool.request.inter.BaseHttpRequest;
import xyz.adscope.amps.tool.request.inter.IHttpResponseCallback;
import xyz.adscope.common.network.FileBody;
import xyz.adscope.common.network.FormBody;
import xyz.adscope.common.network.JsonBody;
import xyz.adscope.common.network.Kalle;
import xyz.adscope.common.network.ProgressBar;
import xyz.adscope.common.network.simple.SimpleBodyRequest;
import xyz.adscope.common.network.simple.SimpleCallback;
import xyz.adscope.common.network.simple.SimpleResponse;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSHttpRequest extends BaseHttpRequest {
    /* JADX WARN: Multi-variable type inference failed */
    public void uploadFile(String str, String str2, IHttpResponseCallback iHttpResponseCallback) {
        ((SimpleBodyRequest.Api) Kalle.post(str).body(new FileBody(new File(str2))).tag(this)).perform(iHttpResponseCallback);
    }

    @Override // xyz.adscope.amps.tool.request.inter.IHttpRequest
    public void doRequestWithJson(String str, String str2, IHttpResponseCallback iHttpResponseCallback) {
        requestWithPostMethod(str, str2, iHttpResponseCallback);
    }

    @Override // xyz.adscope.amps.tool.request.inter.IHttpRequest
    public void requestWithGetMethod(String str, IHttpResponseCallback iHttpResponseCallback) {
        try {
            Kalle.get(str).perform(iHttpResponseCallback);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.tool.request.inter.IHttpRequest
    public void requestWithPostMethod(String str, String str2, IHttpResponseCallback iHttpResponseCallback) {
        try {
            AMPSGlobalModel globalModel = AMPSSDKManager.getInstance().getIAMPSInitInterface().getGlobalModel();
            String str3 = "101,1001";
            if (globalModel != null) {
                str3 = globalModel.getAcceptEncrypt();
            }
            Kalle.post(str).body(new JsonBody(AMPSSecurityUtil.processCompressEncrypt(str2, str3))).perform(iHttpResponseCallback);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void uploadFile(String str, String str2, String str3, IHttpResponseCallback iHttpResponseCallback) {
        FormBody build = FormBody.newBuilder().file(str2, new File(str3)).build();
        build.onProgress(new ProgressBar<FormBody>() { // from class: xyz.adscope.amps.tool.request.AMPSHttpRequest.1
            @Override // xyz.adscope.common.network.ProgressBar
            public void progress(FormBody formBody, int i6) {
            }
        });
        ((SimpleBodyRequest.Api) Kalle.post(str).body(build).tag(this)).perform(new SimpleCallback<FileInfo>() { // from class: xyz.adscope.amps.tool.request.AMPSHttpRequest.2
            @Override // xyz.adscope.common.network.simple.Callback
            public void onResponse(SimpleResponse<FileInfo, String> simpleResponse) {
                simpleResponse.isSucceed();
            }
        });
    }
}
