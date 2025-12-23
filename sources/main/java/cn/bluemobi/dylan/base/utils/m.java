package cn.bluemobi.dylan.base.utils;

import android.R;
import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class m implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: e, reason: collision with root package name */
    private static final String f1231e = "ListenerHandler";

    /* renamed from: a, reason: collision with root package name */
    private View f1232a;

    /* renamed from: b, reason: collision with root package name */
    private int f1233b;

    /* renamed from: c, reason: collision with root package name */
    private int f1234c;

    /* renamed from: d, reason: collision with root package name */
    private a f1235d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(boolean z5, int i6);
    }

    private void a() {
        this.f1232a.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    public void b() {
        View view = this.f1232a;
        if (view != null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    public void d(a aVar) {
        this.f1235d = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int i6;
        boolean z5;
        int height = this.f1232a.getHeight();
        if (height == 0) {
            return;
        }
        int i7 = this.f1234c;
        if (i7 == 0) {
            this.f1234c = height;
            this.f1233b = height;
            return;
        }
        if (i7 != height) {
            this.f1234c = height;
            int i8 = this.f1233b;
            if (i8 == height) {
                z5 = false;
                i6 = 0;
            } else {
                i6 = i8 - height;
                z5 = true;
            }
            a aVar = this.f1235d;
            if (aVar != null) {
                aVar.a(z5, i6);
            }
        }
    }

    public m(Activity activity) {
        if (activity == null) {
            return;
        }
        View c6 = c(activity);
        this.f1232a = c6;
        if (c6 != null) {
            a();
        }
    }

    private View c(Activity activity) {
        return activity.findViewById(R.id.content);
    }
}
