package k0;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Float> f43515a = new HashMap();

    public Set<String> b() {
        return this.f43515a.keySet();
    }

    public float c(String className) {
        if (this.f43515a.containsKey(className)) {
            return this.f43515a.get(className).floatValue();
        }
        return 0.0f;
    }

    public String d() {
        return (String) ((Map.Entry) Collections.max(this.f43515a.entrySet(), new Comparator() { // from class: k0.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return b.a((Map.Entry) obj, (Map.Entry) obj2);
            }
        })).getKey();
    }

    public void e(String className) {
        Map<String, Float> map = this.f43515a;
        map.put(className, Float.valueOf(map.containsKey(className) ? 1.0f + this.f43515a.get(className).floatValue() : 1.0f));
    }

    public void f(String className, float confidence) {
        this.f43515a.put(className, Float.valueOf(confidence));
    }

    public static /* synthetic */ int a(Map.Entry entry, Map.Entry entry2) {
        return (int) (((Float) entry.getValue()).floatValue() - ((Float) entry2.getValue()).floatValue());
    }
}
