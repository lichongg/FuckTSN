package org.junit.rules;

import java.lang.management.ManagementFactory;
import java.util.List;
import org.junit.runner.Description;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a implements l {

    /* renamed from: a, reason: collision with root package name */
    private final l f51451a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f51452b;

    public a(l lVar) {
        this(lVar, ManagementFactory.getRuntimeMXBean().getInputArguments());
    }

    a(l lVar, List<String> list) {
        this.f51451a = lVar;
        this.f51452b = c(list);
    }

    @Override // org.junit.rules.l
    public org.junit.runners.model.h a(org.junit.runners.model.h hVar, Description description) {
        return this.f51452b ? hVar : this.f51451a.a(hVar, description);
    }

    public boolean b() {
        return this.f51452b;
    }

    private static boolean c(List<String> list) {
        for (String str : list) {
            if ("-Xdebug".equals(str) || str.startsWith("-agentlib:jdwp")) {
                return true;
            }
        }
        return false;
    }
}
