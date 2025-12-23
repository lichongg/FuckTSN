package xyz.adscope.ad;

import android.R;
import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.acse.ottn.adapter.AutoScrollViewPager;
import com.beizi.fusion.widget.ScrollClickView;
import xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.optimize.OptimizeModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.optimize.par.ClickAreaParams;
import xyz.adscope.ad.x4;
import xyz.adscope.common.v2.dev.info.ScreenUtil;
import xyz.adscope.common.v2.thread.timer.cd.PauseAbleCountDown;
import xyz.adscope.common.v2.tool.str.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class d1 extends f1 {

    /* renamed from: d, reason: collision with root package name */
    private final ClickAreaParams f54950d;

    /* renamed from: e, reason: collision with root package name */
    private PauseAbleCountDown f54951e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements x4.b {
        a() {
        }

        @Override // xyz.adscope.ad.x4.b
        public void a(View view, MotionEvent motionEvent) {
            i4 c6;
            View view2 = d1.this.f55132c;
            if (!(view2 instanceof xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a) || (c6 = a.c.c((xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a) view2)) == null) {
                return;
            }
            c6.a(view, d1.this.f55132c, motionEvent);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends PauseAbleCountDown {
        b(long j6, long j7) {
            super(j6, j7);
        }

        @Override // xyz.adscope.common.v2.thread.timer.cd.PauseAbleCountDown
        public void onFinish() {
            d1.this.f54951e = null;
            d1.this.d();
        }

        @Override // xyz.adscope.common.v2.thread.timer.cd.PauseAbleCountDown
        public void onCancel() {
        }

        @Override // xyz.adscope.common.v2.thread.timer.cd.PauseAbleCountDown
        public void onTick(long j6) {
        }
    }

    private FrameLayout.LayoutParams e() {
        ClickAreaParams clickAreaParams;
        int i6;
        int i7;
        if (this.f55132c == null || (clickAreaParams = this.f54950d) == null) {
            return null;
        }
        int f6 = clickAreaParams.f();
        if (f6 == 0) {
            i6 = this.f55132c.getWidth();
            i7 = this.f55132c.getHeight();
        } else {
            i6 = 0;
            i7 = 0;
        }
        if (f6 == 1) {
            i6 = ScreenUtil.getScreenWidth(this.f55132c.getContext());
            i7 = ScreenUtil.getScreenHeight(this.f55132c.getContext());
        }
        int a6 = a(i6, this.f54950d.h());
        int a7 = a(i7, this.f54950d.b());
        if (a6 <= 0 || a7 <= 0) {
            return null;
        }
        Rect rect = new Rect();
        this.f55132c.getGlobalVisibleRect(rect);
        int[] a8 = a(this.f54950d.g(), this.f54950d.c(), rect, a6, a7);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a6, a7);
        layoutParams.topMargin = a8[0];
        layoutParams.leftMargin = a8[1];
        return layoutParams;
    }

    private void f() {
        int a6;
        ClickAreaParams clickAreaParams = this.f54950d;
        if (clickAreaParams == null || (a6 = clickAreaParams.a()) <= 0) {
            return;
        }
        this.f54951e = new b(a6, 1000L);
    }

    @Override // xyz.adscope.ad.f1
    public void a(i3 i3Var) {
        super.a(i3Var);
        if (i3Var instanceof x4) {
            ((x4) i3Var).a((x4.b) new a());
        }
    }

    public d1(@NonNull Context context, @NonNull OptimizeModel optimizeModel) {
        super(context, optimizeModel);
        this.f54950d = optimizeModel.a();
        f();
    }

    @Override // xyz.adscope.ad.f1
    public void b() {
        super.b();
        d();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        PauseAbleCountDown pauseAbleCountDown = this.f54951e;
        if (pauseAbleCountDown != null) {
            pauseAbleCountDown.start();
        }
    }

    private int[] a(String str, String str2, Rect rect, int i6, int i7) {
        int[] iArr = new int[2];
        if (str.equalsIgnoreCase("top")) {
            iArr[0] = rect.top;
        }
        if (str.equalsIgnoreCase("bottom")) {
            iArr[0] = rect.bottom - i7;
        }
        if (str.equalsIgnoreCase(AutoScrollViewPager.f4187g)) {
            int i8 = rect.top;
            iArr[0] = (i8 + ((rect.bottom - i8) / 2)) - (i7 / 2);
        }
        if (str2.equalsIgnoreCase(ScrollClickView.DIR_LEFT)) {
            iArr[1] = rect.left;
        }
        if (str2.equalsIgnoreCase("right")) {
            iArr[1] = rect.right - i6;
        }
        if (str2.equalsIgnoreCase(AutoScrollViewPager.f4187g)) {
            int i9 = rect.left;
            iArr[1] = (i9 + ((rect.right - i9) / 2)) - (i6 / 2);
        }
        return iArr;
    }

    private int a(int i6, String str) {
        if (StringUtil.modelSizeByPercent(str)) {
            return (int) (i6 * StringUtil.parseSizePercent(str));
        }
        return StringUtil.parseInt(str);
    }

    @Override // xyz.adscope.ad.f1
    public void a() {
        ViewGroup viewGroup;
        FrameLayout.LayoutParams e6;
        c();
        View view = this.f55132c;
        if (view != null) {
            View rootView = view.getRootView();
            if (!(rootView instanceof ViewGroup) || (viewGroup = (ViewGroup) rootView.findViewById(R.id.content)) == null || (e6 = e()) == null) {
                return;
            }
            viewGroup.addView(this, e6);
        }
    }
}
