package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ef extends ScrollView {

    /* renamed from: r, reason: collision with root package name */
    public static final String f6043r = "ef";

    /* renamed from: a, reason: collision with root package name */
    private Context f6044a;

    /* renamed from: b, reason: collision with root package name */
    private LinearLayout f6045b;

    /* renamed from: c, reason: collision with root package name */
    private int f6046c;

    /* renamed from: d, reason: collision with root package name */
    private List<String> f6047d;

    /* renamed from: e, reason: collision with root package name */
    private int f6048e;

    /* renamed from: f, reason: collision with root package name */
    private int f6049f;

    /* renamed from: g, reason: collision with root package name */
    private Bitmap f6050g;

    /* renamed from: h, reason: collision with root package name */
    private int f6051h;

    /* renamed from: i, reason: collision with root package name */
    private int f6052i;

    /* renamed from: j, reason: collision with root package name */
    private int f6053j;

    /* renamed from: k, reason: collision with root package name */
    private int f6054k;

    /* renamed from: l, reason: collision with root package name */
    private int f6055l;

    /* renamed from: m, reason: collision with root package name */
    int f6056m;

    /* renamed from: n, reason: collision with root package name */
    private int f6057n;

    /* renamed from: o, reason: collision with root package name */
    private Runnable f6058o;

    /* renamed from: p, reason: collision with root package name */
    private int f6059p;

    /* renamed from: q, reason: collision with root package name */
    private d f6060q;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements Runnable {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.amap.api.col.3l.ef$a$a, reason: collision with other inner class name */
        final class RunnableC0090a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f6062a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f6063b;

            RunnableC0090a(int i6, int i7) {
                this.f6062a = i6;
                this.f6063b = i7;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ef efVar = ef.this;
                efVar.smoothScrollTo(0, (efVar.f6057n - this.f6062a) + ef.this.f6046c);
                ef efVar2 = ef.this;
                efVar2.f6056m = this.f6063b + efVar2.f6054k + 1;
                ef.this.w();
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        final class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f6065a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f6066b;

            b(int i6, int i7) {
                this.f6065a = i6;
                this.f6066b = i7;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ef efVar = ef.this;
                efVar.smoothScrollTo(0, efVar.f6057n - this.f6065a);
                ef efVar2 = ef.this;
                efVar2.f6056m = this.f6066b + efVar2.f6054k;
                ef.this.w();
            }
        }

        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (ef.this.f6057n - ef.this.getScrollY() != 0) {
                ef efVar = ef.this;
                efVar.f6057n = efVar.getScrollY();
                ef efVar2 = ef.this;
                efVar2.postDelayed(efVar2.f6058o, ef.this.f6059p);
                return;
            }
            if (ef.this.f6046c == 0) {
                return;
            }
            int i6 = ef.this.f6057n % ef.this.f6046c;
            int i7 = ef.this.f6057n / ef.this.f6046c;
            if (i6 == 0) {
                ef efVar3 = ef.this;
                efVar3.f6056m = i7 + efVar3.f6054k;
                ef.this.w();
            } else if (i6 > ef.this.f6046c / 2) {
                ef.this.post(new RunnableC0090a(i6, i7));
            } else {
                ef.this.post(new b(i6, i7));
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class b extends Drawable {
        @Override // android.graphics.drawable.Drawable
        public final int getOpacity() {
            return 0;
        }

        b() {
        }

        private void a(Canvas canvas) {
            canvas.drawColor(ef.this.f6051h);
        }

        private void b(Canvas canvas) {
            Paint paint = new Paint();
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            rect.left = 0;
            rect.top = 0;
            rect.right = ef.this.f6050g.getWidth();
            rect.bottom = ef.this.f6050g.getHeight();
            rect2.left = 0;
            rect2.top = ef.this.u()[0];
            rect2.right = ef.this.f6049f;
            rect2.bottom = ef.this.u()[1];
            canvas.drawBitmap(ef.this.f6050g, rect, rect2, paint);
        }

        private void c(Canvas canvas) {
            Paint paint = new Paint();
            Rect clipBounds = canvas.getClipBounds();
            paint.setColor(ef.this.f6052i);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(ef.this.f6053j);
            canvas.drawRect(clipBounds, paint);
        }

        @Override // android.graphics.drawable.Drawable
        public final void draw(Canvas canvas) {
            try {
                a(canvas);
                b(canvas);
                c(canvas);
            } catch (Throwable unused) {
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final void setAlpha(int i6) {
        }

        @Override // android.graphics.drawable.Drawable
        public final void setColorFilter(ColorFilter colorFilter) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f6069a;

        c(int i6) {
            this.f6069a = i6;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ef efVar = ef.this;
            efVar.smoothScrollTo(0, this.f6069a * efVar.f6046c);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface d {
        void a(int i6);
    }

    private static void n(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    private void f(int i6) {
        int i7 = this.f6046c;
        if (i7 == 0) {
            return;
        }
        int i8 = this.f6054k;
        int i9 = (i6 / i7) + i8;
        int i10 = i6 % i7;
        int i11 = i6 / i7;
        if (i10 == 0) {
            i9 = i11 + i8;
        } else if (i10 > i7 / 2) {
            i9 = i11 + i8 + 1;
        }
        int childCount = this.f6045b.getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            TextView textView = (TextView) this.f6045b.getChildAt(i12);
            if (textView == null) {
                return;
            }
            if (i9 == i12) {
                textView.setTextColor(Color.parseColor("#0288ce"));
            } else {
                textView.setTextColor(Color.parseColor("#bbbbbb"));
            }
        }
    }

    private void g(Context context) {
        this.f6044a = context;
        setVerticalScrollBarEnabled(false);
        try {
            if (this.f6050g == null) {
                InputStream open = v2.b(context).open("map_indoor_select.png");
                this.f6050g = BitmapFactory.decodeStream(open);
                open.close();
            }
        } catch (Throwable unused) {
        }
        LinearLayout linearLayout = new LinearLayout(context);
        this.f6045b = linearLayout;
        linearLayout.setOrientation(1);
        addView(this.f6045b);
        this.f6058o = new a();
    }

    private TextView m(String str) {
        TextView textView = new TextView(this.f6044a);
        textView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        textView.setSingleLine(true);
        textView.setTextSize(2, 16.0f);
        textView.setText(str);
        textView.setGravity(17);
        textView.getPaint().setFakeBoldText(true);
        int a6 = a(this.f6044a, 8.0f);
        int a7 = a(this.f6044a, 6.0f);
        textView.setPadding(a6, a7, a6, a7);
        if (this.f6046c == 0) {
            this.f6046c = b(textView);
            this.f6045b.setLayoutParams(new FrameLayout.LayoutParams(-2, this.f6046c * this.f6055l));
            setLayoutParams(new LinearLayout.LayoutParams(-2, this.f6046c * this.f6055l));
        }
        return textView;
    }

    private void r() {
        List<String> list = this.f6047d;
        if (list == null || list.size() == 0) {
            return;
        }
        this.f6045b.removeAllViews();
        this.f6055l = (this.f6054k * 2) + 1;
        for (int size = this.f6047d.size() - 1; size >= 0; size--) {
            this.f6045b.addView(m(this.f6047d.get(size)));
        }
        f(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] u() {
        int i6 = this.f6046c;
        int i7 = this.f6054k;
        return new int[]{i6 * i7, i6 * (i7 + 1)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        d dVar = this.f6060q;
        if (dVar != null) {
            try {
                dVar.a(x());
            } catch (Throwable unused) {
            }
        }
    }

    private int x() {
        List<String> list = this.f6047d;
        if (list == null || list.size() == 0) {
            return 0;
        }
        return Math.min(this.f6047d.size() - (this.f6054k * 2), Math.max(0, ((this.f6047d.size() - 1) - this.f6056m) - this.f6054k));
    }

    public final void e() {
        Bitmap bitmap = this.f6050g;
        if (bitmap != null && !bitmap.isRecycled()) {
            b3.B(this.f6050g);
            this.f6050g = null;
        }
        if (this.f6060q != null) {
            this.f6060q = null;
        }
    }

    @Override // android.widget.ScrollView
    public void fling(int i6) {
        super.fling(i6 / 3);
    }

    public final void h(d dVar) {
        this.f6060q = dVar;
    }

    public final void i(String str) {
        List<String> list = this.f6047d;
        if (list == null || list.size() == 0) {
            return;
        }
        int indexOf = this.f6047d.indexOf(str);
        int size = this.f6047d.size();
        int i6 = ((size - r1) - 1) - indexOf;
        this.f6056m = this.f6054k + i6;
        post(new c(i6));
    }

    public final void j(boolean z5) {
        setVisibility(z5 ? 0 : 8);
    }

    public final void k(String[] strArr) {
        if (this.f6047d == null) {
            this.f6047d = new ArrayList();
        }
        this.f6047d.clear();
        for (String str : strArr) {
            this.f6047d.add(str);
        }
        for (int i6 = 0; i6 < this.f6054k; i6++) {
            this.f6047d.add(0, "");
            this.f6047d.add("");
        }
        r();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i6) {
        this.f6051h = i6;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f6049f == 0) {
            try {
                WindowManager windowManager = (WindowManager) this.f6044a.getSystemService("window");
                if (windowManager != null) {
                    this.f6049f = windowManager.getDefaultDisplay().getWidth();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        super.setBackgroundDrawable(new b());
    }

    public ef(Context context) {
        super(context);
        this.f6046c = 0;
        this.f6048e = -1;
        this.f6050g = null;
        this.f6051h = Color.parseColor("#eeffffff");
        this.f6052i = Color.parseColor("#44383838");
        this.f6053j = 4;
        this.f6054k = 1;
        this.f6056m = 1;
        this.f6059p = 50;
        g(context);
    }

    private static int a(Context context, float f6) {
        return (int) ((f6 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private static int b(View view) {
        n(view);
        return view.getMeasuredHeight();
    }

    private void q() {
        this.f6057n = getScrollY();
        postDelayed(this.f6058o, this.f6059p);
    }

    public final boolean o() {
        if (getVisibility() == 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i6, int i7, int i8, int i9) {
        super.onScrollChanged(i6, i7, i8, i9);
        f(i7);
        if (i7 > i9) {
            this.f6048e = 1;
        } else {
            this.f6048e = 0;
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        this.f6049f = i6;
        try {
            setBackgroundDrawable(null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            q();
        }
        return super.onTouchEvent(motionEvent);
    }
}
