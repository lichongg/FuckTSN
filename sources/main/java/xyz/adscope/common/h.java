package xyz.adscope.common;

import android.content.Context;
import com.stub.StubApp;
import xyz.adscope.common.v2.conn.IBaseEncryptRequest;
import xyz.adscope.common.v2.conn.IBaseHttpResponseCallback;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private final a f56328a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a extends IBaseEncryptRequest {
        public a(Context context, boolean z5) {
            super(context, z5);
        }
    }

    void a(String str, String str2, byte[] bArr, IBaseHttpResponseCallback iBaseHttpResponseCallback) {
        this.f56328a.setEncryptPatten(str2);
        this.f56328a.requestWithStreamMethod(str, bArr, iBaseHttpResponseCallback);
    }

    h(Context context) {
        this.f56328a = new a(StubApp.getOrigApplicationContext(context.getApplicationContext()), true);
    }
}
