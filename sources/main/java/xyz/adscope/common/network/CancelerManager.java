package xyz.adscope.common.network;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class CancelerManager {

    /* renamed from: a, reason: collision with root package name */
    private final Map<Request, Canceller> f56466a = new ConcurrentHashMap();

    public void addCancel(Request request, Canceller canceller) {
        this.f56466a.put(request, canceller);
    }

    public void cancel(Object obj) {
        for (Map.Entry<Request, Canceller> entry : this.f56466a.entrySet()) {
            Object tag = entry.getKey().tag();
            if (obj == tag || (obj != null && obj.equals(tag))) {
                entry.getValue().cancel();
            }
        }
    }

    public void removeCancel(Request request) {
        this.f56466a.remove(request);
    }
}
