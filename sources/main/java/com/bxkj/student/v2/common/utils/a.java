package com.bxkj.student.v2.common.utils;

import android.app.Activity;
import com.bxkj.student.v2.ui.face.FaceDetectV3Activity;
import com.bxkj.student.v2.ui.face.FaceLiveV3Activity;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f20868a = new a();

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private static WeakReference<Activity> f20869b;

    @Nullable
    public final Activity a() {
        WeakReference<Activity> weakReference = f20869b;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final void b(@NotNull Activity activity) {
        g0.p(activity, "activity");
        if ((activity instanceof FaceDetectV3Activity) || (activity instanceof FaceLiveV3Activity)) {
            return;
        }
        f20869b = new WeakReference<>(activity);
    }

    private a() {
    }
}
