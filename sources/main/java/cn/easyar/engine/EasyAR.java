package cn.easyar.engine;

import android.app.Activity;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class EasyAR {
    private static WeakReference<Activity> InitializedActivity;

    public static WeakReference<Activity> getInitializeActivity() {
        return InitializedActivity;
    }

    private static void setInitializeActivity(Activity activity) {
        InitializedActivity = new WeakReference<>(activity);
    }
}
