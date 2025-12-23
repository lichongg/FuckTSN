package com.beizi.ad;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Display;
import android.view.Menu;
import android.view.WindowManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import com.beizi.ad.internal.h.x;
import com.stub.StubApp;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class AdActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f11237a;

    /* renamed from: b, reason: collision with root package name */
    static Class f11238b;

    /* renamed from: c, reason: collision with root package name */
    private a f11239c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.beizi.ad.AdActivity$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            int i6 = 0;
            while (i6 != 3) {
                i6++;
                if (AdActivity.f11237a) {
                    AdActivity.f11237a = false;
                    AdActivity.this.finish();
                    i6 = 3;
                }
                SystemClock.sleep(500L);
            }
        }

        AnonymousClass1() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a();

        void b();

        void c();

        void d();

        void e();

        WebView f();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum b {
        portrait,
        landscape,
        none
    }

    public static Class a() {
        return f11238b;
    }

    public static void b(Activity activity) {
        activity.setRequestedOrientation(-1);
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.beizi.ad.AdActivity$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f11241a;

        static {
            int[] iArr = new int[b.values().length];
            f11241a = iArr;
            try {
                iArr[b.none.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11241a[b.landscape.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11241a[b.portrait.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        StubApp.interface11(12412);
        f11238b = AdActivity.class;
    }

    public static void a(Activity activity) {
        b(activity, activity.getResources().getConfiguration().orientation);
    }

    @TargetApi(9)
    private static void b(Activity activity, int i6) {
        try {
            String t5 = com.beizi.ad.internal.h.a.a().t();
            Locale locale = Locale.US;
            String upperCase = t5.toUpperCase(locale);
            boolean z5 = com.beizi.ad.internal.h.a.a().s().toUpperCase(locale).equals("AMAZON") && (upperCase.equals("KFTT") || upperCase.equals("KFJWI") || upperCase.equals("KFJWA"));
            Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
            if (i6 == 1) {
                int rotation = defaultDisplay.getRotation();
                if (rotation != 1 && rotation != 2) {
                    activity.setRequestedOrientation(1);
                    return;
                }
                activity.setRequestedOrientation(9);
                return;
            }
            if (i6 == 2) {
                int rotation2 = defaultDisplay.getRotation();
                if (z5) {
                    if (rotation2 != 0 && rotation2 != 1) {
                        activity.setRequestedOrientation(0);
                        return;
                    }
                    activity.setRequestedOrientation(8);
                    return;
                }
                if (rotation2 != 0 && rotation2 != 1) {
                    activity.setRequestedOrientation(8);
                    return;
                }
                activity.setRequestedOrientation(0);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        a aVar = this.f11239c;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        a aVar = this.f11239c;
        if (aVar != null) {
            aVar.c();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onPause() {
        a aVar = this.f11239c;
        if (aVar != null) {
            x.c(aVar.f());
        }
        CookieSyncManager cookieSyncManager = CookieSyncManager.getInstance();
        if (cookieSyncManager != null) {
            cookieSyncManager.stopSync();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        a aVar = this.f11239c;
        if (aVar != null) {
            x.b(aVar.f());
        }
        CookieSyncManager cookieSyncManager = CookieSyncManager.getInstance();
        if (cookieSyncManager != null) {
            cookieSyncManager.startSync();
        }
        super.onResume();
    }

    public static void a(Activity activity, int i6) {
        b(activity, i6);
    }

    public static void a(Activity activity, b bVar) {
        int i6 = activity.getResources().getConfiguration().orientation;
        int i7 = AnonymousClass2.f11241a[bVar.ordinal()];
        if (i7 != 1) {
            if (i7 == 2) {
                i6 = 2;
            } else if (i7 == 3) {
                i6 = 1;
            }
            b(activity, i6);
            return;
        }
        activity.setRequestedOrientation(-1);
    }
}
