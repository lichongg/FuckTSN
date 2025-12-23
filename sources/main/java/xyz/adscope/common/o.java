package xyz.adscope.common;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import java.util.Iterator;
import java.util.List;
import xyz.adscope.common.analyse.model.impl.HistoryDbModel;
import xyz.adscope.common.v2.conn.IBaseEncryptRequest;
import xyz.adscope.common.v2.conn.IBaseHttpResponseCallback;
import xyz.adscope.common.v2.encrypt.ILinkedEncrypt;
import xyz.adscope.common.v2.encrypt.LinkedEncryptManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    private final a f56743a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f56744b;

    void a(String str, String str2, List<HistoryDbModel> list, IBaseHttpResponseCallback iBaseHttpResponseCallback) {
        this.f56743a.setEncryptPatten(str2);
        this.f56743a.requestWithPostMethod(str, LinkedEncryptManager.getInstance().getOrCreateImplement(this.f56744b).encrypt(a(list), str2, ILinkedEncrypt.B64Model.AS_LAST_OR_FIRST, true), iBaseHttpResponseCallback);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a extends IBaseEncryptRequest {
        public a(Context context, boolean z5) {
            super(context, z5);
        }
    }

    o(Context context) {
        this.f56744b = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f56743a = new a(context, true);
    }

    private String a(List<HistoryDbModel> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<HistoryDbModel> it = list.iterator();
        while (it.hasNext()) {
            String macros = it.next().getMacros();
            if (!TextUtils.isEmpty(macros)) {
                sb.append(macros);
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.setCharAt(sb.length() - 1, ']');
        } else {
            sb.append("]");
        }
        return sb.toString();
    }
}
