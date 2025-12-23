package xyz.adscope.ad.ad.nativead.render.view.asnp.prefab;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import xyz.adscope.ad.a3;
import xyz.adscope.ad.b4;
import xyz.adscope.ad.h4;
import xyz.adscope.ad.i4;
import xyz.adscope.ad.j2;
import xyz.adscope.ad.l2;
import xyz.adscope.ad.l6;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.report.ReportModel;
import xyz.adscope.ad.publish.ASNPInitConfig;
import xyz.adscope.ad.y2;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class a extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private final y2 f54822a;

    /* renamed from: b, reason: collision with root package name */
    private final i4 f54823b;

    /* renamed from: c, reason: collision with root package name */
    private String f54824c;

    /* renamed from: d, reason: collision with root package name */
    private View f54825d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C1085a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class b implements a3 {

        /* renamed from: a, reason: collision with root package name */
        private final a3 f54826a;

        /* synthetic */ b(a aVar, a3 a3Var, C1085a c1085a) {
            this(a3Var);
        }

        @Override // xyz.adscope.ad.a3
        public void b(l2 l2Var, View view) {
            a.this.c();
            a3 a3Var = this.f54826a;
            if (a3Var != null) {
                a3Var.b(l2Var, view);
            }
        }

        private b(a3 a3Var) {
            this.f54826a = a3Var;
        }

        @Override // xyz.adscope.ad.m2
        public void a(y2 y2Var) {
            this.f54826a.a((a3) y2Var);
        }

        @Override // xyz.adscope.ad.a3
        public void a(View view) {
            a.this.b();
            a3 a3Var = this.f54826a;
            if (a3Var != null) {
                a3Var.a(view);
            }
        }

        @Override // xyz.adscope.ad.a3
        public void b(View view) {
            a3 a3Var = this.f54826a;
            if (a3Var != null) {
                a3Var.b(view);
            }
        }

        @Override // xyz.adscope.ad.a3
        public void a(l2 l2Var, View view) {
            a3 a3Var = this.f54826a;
            if (a3Var != null) {
                a3Var.a(l2Var, view);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class c {
        public static void a(a aVar, ReportModel reportModel, a3 a3Var, h4 h4Var) {
            aVar.a(reportModel, a3Var, h4Var);
        }

        public static void a(a aVar, View view) {
            aVar.a(view);
        }

        public static void a(a aVar, String str) {
            aVar.setComplainBy(str);
        }

        public static View b(a aVar) {
            return aVar.getVideoView();
        }

        public static i4 c(a aVar) {
            return aVar.getViewRecorder();
        }

        public static String a(a aVar) {
            return aVar.getComplainBy();
        }
    }

    public a(@NonNull Context context, String str) {
        super(context);
        this.f54822a = new y2(this, str);
        this.f54823b = i4.a.a();
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (getChildCount() > 0) {
            for (int i6 = 0; i6 < getChildCount(); i6++) {
                KeyEvent.Callback childAt = getChildAt(i6);
                if (childAt instanceof b4) {
                    ((b4) childAt).b();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (getChildCount() > 0) {
            for (int i6 = 0; i6 < getChildCount(); i6++) {
                KeyEvent.Callback childAt = getChildAt(i6);
                if (childAt instanceof b4) {
                    ((b4) childAt).c();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getComplainBy() {
        return this.f54824c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getVideoView() {
        return this.f54825d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i4 getViewRecorder() {
        return this.f54823b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setComplainBy(String str) {
        this.f54824c = str;
    }

    protected j2 getMonitor() {
        return this.f54822a;
    }

    public void onActivityPause() {
        this.f54822a.c();
        b();
    }

    public void onActivityResume() {
        this.f54822a.a();
        c();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f54823b.a(motionEvent);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f54822a.a();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f54822a.c();
    }

    public void onViewDestroy() {
        if (getChildCount() > 0) {
            for (int i6 = 0; i6 < getChildCount(); i6++) {
                KeyEvent.Callback childAt = getChildAt(i6);
                if (childAt instanceof b4) {
                    ((b4) childAt).a();
                }
            }
        }
    }

    public void removeFromParent() {
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this);
        }
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f54822a = new y2(this, a(context, attributeSet));
        this.f54823b = i4.a.a();
        a();
    }

    protected void a(ReportModel reportModel, a3 a3Var, h4 h4Var) {
        this.f54822a.a(reportModel);
        this.f54822a.a((a3) new b(this, a3Var, null));
        View view = this.f54825d;
        if (view instanceof l6) {
            ((l6) view).a(h4Var);
        }
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f54822a = new y2(this, a(context, attributeSet));
        this.f54823b = i4.a.a();
        a();
    }

    private String a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{ResIdentify.getResIdentify(context, "attr", "api_key")});
        try {
            String string = obtainStyledAttributes.getString(0);
            if (!TextUtils.isEmpty(string)) {
                androidx.core.provider.c.a(obtainStyledAttributes);
                return string;
            }
            androidx.core.provider.c.a(obtainStyledAttributes);
            return ASNPInitConfig.AD_SCOPE_ADN;
        } catch (Throwable th) {
            if (obtainStyledAttributes != null) {
                try {
                    androidx.core.provider.c.a(obtainStyledAttributes);
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        this.f54822a = new y2(this, a(context, attributeSet));
        this.f54823b = i4.a.a();
        a();
    }

    private void a() {
        getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.c
            @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
            public final void onWindowFocusChanged(boolean z5) {
                a.this.a(z5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z5) {
        if (z5) {
            onActivityResume();
        } else {
            onActivityPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        this.f54825d = view;
    }
}
