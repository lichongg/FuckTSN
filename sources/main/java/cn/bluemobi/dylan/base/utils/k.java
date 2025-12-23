package cn.bluemobi.dylan.base.utils;

import android.app.Activity;
import android.view.Window;
import com.autonavi.amap.mapcore.AMapEngineUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private Activity f1228a;

    public void a() {
        Window window = this.f1228a.getWindow();
        window.addFlags(67108864);
        window.addFlags(AMapEngineUtils.HALF_MAX_P20_WIDTH);
        window.getDecorView().setSystemUiVisibility(1024);
        window.clearFlags(67108864);
        window.setStatusBarColor(0);
    }

    public k(Activity activity) {
        this.f1228a = activity;
    }
}
