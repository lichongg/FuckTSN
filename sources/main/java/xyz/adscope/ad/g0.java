package xyz.adscope.ad;

import android.content.Context;
import xyz.adscope.common.v2.conn.IBaseHttpResponseCallback;
import xyz.adscope.common.v2.conn.IBaseSimpleRequest;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class g0 implements w1 {

    /* renamed from: a, reason: collision with root package name */
    private final IBaseSimpleRequest f55160a;

    @Override // xyz.adscope.ad.w1
    public void a(String str, IBaseHttpResponseCallback iBaseHttpResponseCallback) {
        this.f55160a.requestWithGetMethod(str, iBaseHttpResponseCallback);
    }

    @Override // xyz.adscope.ad.w1
    public void a(String str, String str2, IBaseHttpResponseCallback iBaseHttpResponseCallback) {
        this.f55160a.requestWithPostMethod(str, str2, iBaseHttpResponseCallback);
    }

    g0(Context context) {
        this.f55160a = new IBaseSimpleRequest(context, true);
    }
}
