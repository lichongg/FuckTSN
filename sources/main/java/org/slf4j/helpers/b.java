package org.slf4j.helpers;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.slf4j.Marker;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b implements org.slf4j.b {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentMap<String, Marker> f51742a = new ConcurrentHashMap();

    @Override // org.slf4j.b
    public boolean b(String str) {
        return (str == null || this.f51742a.remove(str) == null) ? false : true;
    }

    @Override // org.slf4j.b
    public Marker a(String str) {
        Marker putIfAbsent;
        if (str == null) {
            throw new IllegalArgumentException("Marker name cannot be null");
        }
        Marker marker = this.f51742a.get(str);
        return (marker != null || (putIfAbsent = this.f51742a.putIfAbsent(str, (marker = new BasicMarker(str)))) == null) ? marker : putIfAbsent;
    }

    @Override // org.slf4j.b
    public Marker c(String str) {
        return new BasicMarker(str);
    }

    @Override // org.slf4j.b
    public boolean d(String str) {
        if (str == null) {
            return false;
        }
        return this.f51742a.containsKey(str);
    }
}
