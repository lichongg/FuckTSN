package j1;

import android.content.Context;
import com.huawei.agconnect.e;
import com.stub.StubApp;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Deprecated
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class a implements e {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, a> f43446a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private static final Object f43447b = new Object();

    public abstract void f(b bVar);

    public abstract void g(InputStream inputStream);

    public abstract void h(String str, String str2);

    public abstract void i(com.huawei.agconnect.b bVar);

    public static a e(Context context, String str) {
        a aVar;
        synchronized (f43447b) {
            try {
                Map<String, a> map = f43446a;
                aVar = map.get(str);
                if (aVar == null) {
                    aVar = new com.huawei.agconnect.config.impl.e(context, str);
                    map.put(str, aVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public static a d(Context context) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (origApplicationContext != null) {
            context = origApplicationContext;
        }
        return e(context, context.getPackageName());
    }
}
