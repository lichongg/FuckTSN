package com.google.firebase.components;

import com.acse.ottn.l3;
import com.umeng.analytics.pro.d;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class Dependency {
    private final Class<?> anInterface;
    private final int injection;
    private final int type;

    public static Dependency deferred(Class<?> cls) {
        return new Dependency(cls, 0, 2);
    }

    private static String describeInjection(int i6) {
        if (i6 == 0) {
            return "direct";
        }
        if (i6 == 1) {
            return d.M;
        }
        if (i6 == 2) {
            return "deferred";
        }
        throw new AssertionError("Unsupported injection: " + i6);
    }

    public static Dependency optional(Class<?> cls) {
        return new Dependency(cls, 0, 0);
    }

    public static Dependency optionalProvider(Class<?> cls) {
        return new Dependency(cls, 0, 1);
    }

    public static Dependency required(Class<?> cls) {
        return new Dependency(cls, 1, 0);
    }

    public static Dependency requiredProvider(Class<?> cls) {
        return new Dependency(cls, 1, 1);
    }

    public static Dependency setOf(Class<?> cls) {
        return new Dependency(cls, 2, 0);
    }

    public static Dependency setOfProvider(Class<?> cls) {
        return new Dependency(cls, 2, 1);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Dependency) {
            Dependency dependency = (Dependency) obj;
            if (this.anInterface == dependency.anInterface && this.type == dependency.type && this.injection == dependency.injection) {
                return true;
            }
        }
        return false;
    }

    public Class<?> getInterface() {
        return this.anInterface;
    }

    public int hashCode() {
        return ((((this.anInterface.hashCode() ^ 1000003) * 1000003) ^ this.type) * 1000003) ^ this.injection;
    }

    public boolean isDeferred() {
        return this.injection == 2;
    }

    public boolean isDirectInjection() {
        return this.injection == 0;
    }

    public boolean isRequired() {
        return this.type == 1;
    }

    public boolean isSet() {
        return this.type == 2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.anInterface);
        sb.append(", type=");
        int i6 = this.type;
        sb.append(i6 == 1 ? "required" : i6 == 0 ? "optional" : l3.f4738h);
        sb.append(", injection=");
        sb.append(describeInjection(this.injection));
        sb.append("}");
        return sb.toString();
    }

    private Dependency(Class<?> cls, int i6, int i7) {
        this.anInterface = (Class) Preconditions.checkNotNull(cls, "Null dependency anInterface.");
        this.type = i6;
        this.injection = i7;
    }
}
