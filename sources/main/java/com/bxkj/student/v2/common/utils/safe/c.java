package com.bxkj.student.v2.common.utils.safe;

import android.os.Debug;
import com.bxkj.student.App;
import java.io.File;
import kotlin.io.i;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f20938a = new c();

    private final boolean a() {
        File file = new File("/proc/net/tcp");
        return file.exists() && file.canRead() && u.l3(i.D(file, null, 1, null), "0100007F:0016", false, 2, null);
    }

    private final boolean e() {
        return (App.f17573d.a().getApplicationInfo().flags & 2) != 0;
    }

    private c() {
    }

    private final boolean b() {
        return Debug.isDebuggerConnected();
    }

    private final boolean c() {
        return Debug.waitingForDebugger();
    }

    public final boolean d() {
        if (!b() && !c() && !a() && !e()) {
            return false;
        }
        return true;
    }
}
