package u1;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private String f54668a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, d> f54669b = new ConcurrentHashMap(16);

    /* renamed from: c, reason: collision with root package name */
    private List<b> f54670c = new ArrayList(16);

    public List<b> a() {
        return this.f54670c;
    }

    public void d(List<b> list) {
        this.f54670c = list;
    }

    public String e() {
        return this.f54668a;
    }

    public void g(String str) {
        this.f54668a = str;
    }

    public d b(String str) {
        if (TextUtils.isEmpty(str)) {
            Logger.w("Service", "In servings.getServing(String groupId), the groupId is Empty or null");
            return null;
        }
        return this.f54669b.get(str);
    }

    public void c(String str, d dVar) {
        if (!TextUtils.isEmpty(str) && dVar != null) {
            this.f54669b.put(str, dVar);
        }
    }

    public void f(String str) {
    }
}
