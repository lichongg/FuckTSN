package xyz.adscope.ad;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.Map;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.DisplayModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
class b0 implements v1 {

    /* renamed from: a, reason: collision with root package name */
    private final Context f54836a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, t4> f54837b = new HashMap();

    @Override // xyz.adscope.ad.v1
    public void a(DisplayModel displayModel) {
        if (displayModel != null) {
            String f6 = displayModel.f();
            if (TextUtils.isEmpty(f6) || this.f54837b.containsKey(f6)) {
                return;
            }
            t4 t4Var = new t4(this.f54836a);
            t4Var.a(displayModel);
            this.f54837b.put(f6, t4Var);
        }
    }

    b0(Context context) {
        this.f54836a = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    @Override // xyz.adscope.ad.v1
    public void a(l2 l2Var, b1 b1Var, String str) {
        if (this.f54837b.get(str) != null) {
            t4 t4Var = this.f54837b.get(str);
            if (t4Var.a()) {
                t4Var.a(l2Var, b1Var);
            }
        }
    }
}
