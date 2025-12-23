package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.Map;
import ms.bz.bd.c.Pgl.n0;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class m0 implements n0.pgla {

    /* renamed from: a, reason: collision with root package name */
    private final long f50300a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f50301b;

    /* renamed from: c, reason: collision with root package name */
    private final pblu f50302c;

    @Override // ms.bz.bd.c.Pgl.n0.pgla
    public final String a() {
        long j6 = this.f50300a;
        if (j6 == -1) {
            return "";
        }
        int i6 = pbly.f50381b;
        return (String) com.volcengine.mobsecBiz.matrix.pgla.a(33554439, 0, j6, null, null);
    }

    @Override // ms.bz.bd.c.Pgl.n0.pgla
    public final Map<String, String> b(String str, byte[] bArr) {
        HashMap hashMap = new HashMap();
        if (str != null && str.length() != 0) {
            long j6 = this.f50300a;
            int i6 = pbly.f50381b;
            String[] strArr = (String[]) com.volcengine.mobsecBiz.matrix.pgla.a(33554438, 0, j6, str, bArr);
            if (strArr != null && strArr.length % 2 == 0) {
                for (int i7 = 0; i7 < strArr.length; i7 += 2) {
                    String str2 = strArr[i7];
                    String str3 = strArr[i7 + 1];
                    if (str2 != null && str3 != null) {
                        hashMap.put(str2, str3);
                    }
                }
            }
        }
        return hashMap;
    }

    @Override // ms.bz.bd.c.Pgl.n0.pgla
    public final void c(String str) {
        this.f50302c.f50363e = str;
        long j6 = this.f50300a;
        if (j6 != -1) {
            Context context = this.f50301b;
            int i6 = pbly.f50381b;
            com.volcengine.mobsecBiz.matrix.pgla.a(33554435, 0, j6, str, context);
        }
    }

    @Override // ms.bz.bd.c.Pgl.n0.pgla
    public final void d(String str) {
        if (this.f50300a == -1 || TextUtils.isEmpty(str)) {
            return;
        }
        long j6 = this.f50300a;
        Context context = this.f50301b;
        int i6 = pbly.f50381b;
        com.volcengine.mobsecBiz.matrix.pgla.a(InputDeviceCompat.SOURCE_HDMI, 0, j6, str, context);
    }

    @Override // ms.bz.bd.c.Pgl.n0.pgla
    public final void e(String str) {
        this.f50302c.f50361c = str;
        long j6 = this.f50300a;
        if (j6 != -1) {
            Context context = this.f50301b;
            int i6 = pbly.f50381b;
            com.volcengine.mobsecBiz.matrix.pgla.a(33554434, 0, j6, str, context);
        }
    }

    @Override // ms.bz.bd.c.Pgl.n0.pgla
    public final void f(String str) {
        this.f50302c.f50362d = str;
        long j6 = this.f50300a;
        if (j6 != -1) {
            Context context = this.f50301b;
            int i6 = pbly.f50381b;
            com.volcengine.mobsecBiz.matrix.pgla.a(33554437, 0, j6, str, context);
        }
    }

    @Override // ms.bz.bd.c.Pgl.n0.pgla
    public final void g(int i6) {
        long j6 = this.f50300a;
        if (j6 != -1) {
            int i7 = pbly.f50381b;
            com.volcengine.mobsecBiz.matrix.pgla.a(33554441, i6, j6, null, null);
        }
    }

    m0(pblu pbluVar, Context context, long j6) {
        if (context != null) {
            this.f50302c = pbluVar;
            this.f50301b = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f50300a = j6;
            return;
        }
        throw new NullPointerException("context could not be null");
    }
}
