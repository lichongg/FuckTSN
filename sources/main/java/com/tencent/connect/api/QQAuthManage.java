package com.tencent.connect.api;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.tencent.connect.a;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.apireq.BaseResp;
import com.tencent.open.apireq.IApiCallback;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.k;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class QQAuthManage extends BaseApi {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Resp extends BaseResp {
    }

    private int a(Activity activity) {
        if (!k.c(activity)) {
            SLog.i("QQAuthManage", "gotoManagePage: not installed all qq");
            return -1000;
        }
        if (!k.b(activity)) {
            SLog.i("QQAuthManage", "gotoManagePage: only support mobile qq");
            return -1002;
        }
        if (k.c(activity, "8.6.0") >= 0) {
            return 0;
        }
        SLog.i("QQAuthManage", "gotoManagePage: low version");
        return -1001;
    }

    public void gotoManagePage(final Activity activity, final IApiCallback iApiCallback) {
        SLog.i("QQAuthManage", "gotoManagePage");
        final Resp resp = new Resp();
        if (a.a("QQAuthManage", null)) {
            resp.setCode(BaseResp.CODE_PERMISSION_NOT_GRANTED);
            iApiCallback.onResp(resp);
            return;
        }
        int a6 = a(activity);
        if (a6 != 0) {
            resp.setCode(a6);
            iApiCallback.onResp(resp);
        } else {
            if (this.f40366c.isSessionValid() && this.f40366c.getOpenId() != null) {
                this.f40365b.a(new IUiListener() { // from class: com.tencent.connect.api.QQAuthManage.1
                    @Override // com.tencent.tauth.IUiListener
                    public void onComplete(Object obj) {
                        if (obj instanceof JSONObject) {
                            if (((JSONObject) obj).optInt("ret", -1) == 0) {
                                QQAuthManage.this.a(activity, iApiCallback);
                                return;
                            }
                            SLog.i("QQAuthManage", "gotoManagePage: checkLogin not login");
                            resp.setCode(BaseResp.CODE_NOT_LOGIN);
                            iApiCallback.onResp(resp);
                        }
                    }

                    @Override // com.tencent.tauth.IUiListener
                    public void onError(UiError uiError) {
                        resp.setCode(uiError.errorCode);
                        resp.setErrorMsg(uiError.errorMessage);
                        SLog.e("QQAuthManage", "gotoManagePage: checkLogin error. " + resp);
                        iApiCallback.onResp(resp);
                    }

                    @Override // com.tencent.tauth.IUiListener
                    public void onCancel() {
                    }

                    @Override // com.tencent.tauth.IUiListener
                    public void onWarning(int i6) {
                    }
                });
                return;
            }
            SLog.i("QQAuthManage", "gotoManagePage: not login");
            resp.setCode(BaseResp.CODE_NOT_LOGIN);
            iApiCallback.onResp(resp);
        }
    }

    public QQAuthManage(c cVar, QQToken qQToken) {
        super(cVar, qQToken);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, IApiCallback iApiCallback) {
        SLog.i("QQAuthManage", "doGotoMangePage");
        StringBuilder sb = new StringBuilder("mqqapi://opensdk/open_auth_manage");
        a(sb, activity);
        Intent intent = new Intent();
        intent.setData(Uri.parse(sb.toString()));
        intent.putExtra(Constants.PARAM_PKG_NAME, activity.getPackageName());
        intent.setPackage("com.tencent.mobileqq");
        intent.setFlags(335544320);
        activity.startActivity(intent);
        iApiCallback.onResp(new Resp());
    }
}
