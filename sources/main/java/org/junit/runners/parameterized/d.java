package org.junit.runners.parameterized;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.runners.model.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final String f51566a;

    /* renamed from: b, reason: collision with root package name */
    private final i f51567b;

    /* renamed from: c, reason: collision with root package name */
    private final List<Object> f51568c;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return this.f51566a.equals(dVar.f51566a) && this.f51568c.equals(dVar.f51568c) && this.f51567b.equals(dVar.f51567b);
    }

    private static void d(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public String a() {
        return this.f51566a;
    }

    public List<Object> b() {
        return this.f51568c;
    }

    public i c() {
        return this.f51567b;
    }

    public int hashCode() {
        return ((((this.f51566a.hashCode() + 14747) * 14747) + this.f51567b.hashCode()) * 14747) + this.f51568c.hashCode();
    }

    public String toString() {
        return this.f51567b.k() + " '" + this.f51566a + "' with parameters " + this.f51568c;
    }

    public d(String str, i iVar, List<Object> list) {
        d(str, "The name is missing.");
        d(iVar, "The test class is missing.");
        d(list, "The parameters are missing.");
        this.f51566a = str;
        this.f51567b = iVar;
        this.f51568c = Collections.unmodifiableList(new ArrayList(list));
    }
}
