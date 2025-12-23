package xyz.adscope.ad;

import android.content.Context;
import android.text.TextUtils;
import xyz.adscope.common.v2.conn.IBaseHttpResponseCallback;
import xyz.adscope.common.v2.encrypt.ILinkedEncrypt;
import xyz.adscope.common.v2.encrypt.LinkedEncryptManager;
import xyz.adscope.common.v2.tool.json.JsonUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class n2 {

    /* renamed from: a, reason: collision with root package name */
    protected Context f55715a;

    protected void a(String str, p2 p2Var, IBaseHttpResponseCallback iBaseHttpResponseCallback) {
        a(str, p2Var, iBaseHttpResponseCallback, "101,1001");
    }

    protected void a(String str, p2 p2Var, IBaseHttpResponseCallback iBaseHttpResponseCallback, String str2) {
        if (TextUtils.isEmpty(str)) {
            a(q5.ERROR_INVALID_URL, iBaseHttpResponseCallback);
            return;
        }
        if (p2Var == null) {
            a(q5.ERROR_NULL_MODEL_BUILD, iBaseHttpResponseCallback);
            return;
        }
        v5 v5Var = new v5(this.f55715a, true);
        v5Var.setEncryptPatten(str2);
        String a6 = p2Var.a();
        String encrypt = LinkedEncryptManager.getInstance().getOrCreateImplement(this.f55715a).encrypt(a6, str2, ILinkedEncrypt.B64Model.STEP_BY_STEP, true);
        if (JsonUtil.isValidJson(a6)) {
            v5Var.requestWithPostMethod(str, encrypt, iBaseHttpResponseCallback);
        } else {
            a(q5.ERROR_EMPTY_CONTENT, iBaseHttpResponseCallback);
        }
    }

    protected n2(Context context) {
        this.f55715a = context;
    }

    protected void a(q5 q5Var, IBaseHttpResponseCallback iBaseHttpResponseCallback) {
        if (iBaseHttpResponseCallback != null) {
            iBaseHttpResponseCallback.failCallback(q5Var);
        }
    }
}
