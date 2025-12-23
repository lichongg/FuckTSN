package u1;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private String f54664a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, c> f54665b = new ConcurrentHashMap(16);

    public String a() {
        return this.f54664a;
    }

    public void e(String str) {
        this.f54664a = str;
    }

    public c b(String str) {
        if (TextUtils.isEmpty(str)) {
            Logger.w("ApplicationBean", "In getServing(String serviceName), the serviceName is Empty or null");
            return null;
        }
        return this.f54665b.get(str);
    }

    public void d(String str, c cVar) {
        if (!TextUtils.isEmpty(str) && cVar != null) {
            this.f54665b.put(str, cVar);
        }
    }

    public void c(long j6) {
    }
}
