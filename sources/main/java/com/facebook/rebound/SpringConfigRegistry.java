package com.facebook.rebound;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class SpringConfigRegistry {

    /* renamed from: b, reason: collision with root package name */
    private static final SpringConfigRegistry f32505b = new SpringConfigRegistry(true);

    /* renamed from: a, reason: collision with root package name */
    private final Map<SpringConfig, String> f32506a = new HashMap();

    public static SpringConfigRegistry c() {
        return f32505b;
    }

    public boolean a(SpringConfig springConfig, String str) {
        if (springConfig == null) {
            throw new IllegalArgumentException("springConfig is required");
        }
        if (str == null) {
            throw new IllegalArgumentException("configName is required");
        }
        if (this.f32506a.containsKey(springConfig)) {
            return false;
        }
        this.f32506a.put(springConfig, str);
        return true;
    }

    public Map<SpringConfig, String> b() {
        return Collections.unmodifiableMap(this.f32506a);
    }

    public void d() {
        this.f32506a.clear();
    }

    public boolean e(SpringConfig springConfig) {
        if (springConfig != null) {
            return this.f32506a.remove(springConfig) != null;
        }
        throw new IllegalArgumentException("springConfig is required");
    }

    SpringConfigRegistry(boolean z5) {
        if (z5) {
            a(SpringConfig.f32502c, "default config");
        }
    }
}
