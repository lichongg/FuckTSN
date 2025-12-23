package com.bxkj.student.v2.common.utils.safe;

import com.kuaishou.weapon.p0.an;
import java.io.File;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f20946a = new f();

    private final boolean a() {
        return new File("/data/local/tmp/frida-server").exists();
    }

    private final boolean b() {
        try {
            Class.forName(an.f35735b);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private f() {
    }

    public final boolean c() {
        if (!b() && !a()) {
            return false;
        }
        return true;
    }
}
