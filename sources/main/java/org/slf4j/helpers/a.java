package org.slf4j.helpers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a implements j5.c {

    /* renamed from: a, reason: collision with root package name */
    private InheritableThreadLocal<Map<String, String>> f51740a = new C0999a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: org.slf4j.helpers.a$a, reason: collision with other inner class name */
    class C0999a extends InheritableThreadLocal<Map<String, String>> {
        C0999a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.InheritableThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map<String, String> childValue(Map<String, String> map) {
            if (map == null) {
                return null;
            }
            return new HashMap(map);
        }
    }

    @Override // j5.c
    public void a(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("key cannot be null");
        }
        Map<String, String> map = this.f51740a.get();
        if (map == null) {
            map = new HashMap<>();
            this.f51740a.set(map);
        }
        map.put(str, str2);
    }

    @Override // j5.c
    public Map<String, String> b() {
        Map<String, String> map = this.f51740a.get();
        if (map != null) {
            return new HashMap(map);
        }
        return null;
    }

    @Override // j5.c
    public void c(Map<String, String> map) {
        this.f51740a.set(new HashMap(map));
    }

    @Override // j5.c
    public void clear() {
        Map<String, String> map = this.f51740a.get();
        if (map != null) {
            map.clear();
            this.f51740a.remove();
        }
    }

    public Set<String> d() {
        Map<String, String> map = this.f51740a.get();
        if (map != null) {
            return map.keySet();
        }
        return null;
    }

    @Override // j5.c
    public String get(String str) {
        Map<String, String> map = this.f51740a.get();
        if (map == null || str == null) {
            return null;
        }
        return map.get(str);
    }

    @Override // j5.c
    public void remove(String str) {
        Map<String, String> map = this.f51740a.get();
        if (map != null) {
            map.remove(str);
        }
    }
}
