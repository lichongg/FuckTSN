package com.scwang.smartrefresh.layout.internal.pathview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class b extends Drawable {

    /* renamed from: n, reason: collision with root package name */
    protected static final Region f37452n = new Region();

    /* renamed from: o, reason: collision with root package name */
    protected static final Region f37453o = new Region(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);

    /* renamed from: a, reason: collision with root package name */
    protected Paint f37454a;

    /* renamed from: b, reason: collision with root package name */
    protected List<Path> f37455b;

    /* renamed from: c, reason: collision with root package name */
    protected List<Integer> f37456c;

    /* renamed from: d, reason: collision with root package name */
    protected int f37457d = 1;

    /* renamed from: e, reason: collision with root package name */
    protected int f37458e = 1;

    /* renamed from: f, reason: collision with root package name */
    protected int f37459f = 0;

    /* renamed from: g, reason: collision with root package name */
    protected int f37460g = 0;

    /* renamed from: h, reason: collision with root package name */
    protected int f37461h;

    /* renamed from: i, reason: collision with root package name */
    protected int f37462i;

    /* renamed from: j, reason: collision with root package name */
    protected List<Path> f37463j;

    /* renamed from: k, reason: collision with root package name */
    protected List<String> f37464k;

    /* renamed from: l, reason: collision with root package name */
    private Bitmap f37465l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f37466m;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void i(String... strArr) {
        this.f37462i = 0;
        this.f37461h = 0;
        this.f37464k = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.f37463j = arrayList;
        this.f37455b = arrayList;
        for (String str : strArr) {
            this.f37464k.add(str);
            this.f37463j.add(a.e(str));
        }
        g();
    }

    public void l() {
        this.f37466m = false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i6, int i7, int i8, int i9) {
        int i10 = i8 - i6;
        int i11 = i9 - i7;
        List<Path> list = this.f37463j;
        if (list == null || list.size() <= 0 || (i10 == this.f37457d && i11 == this.f37458e)) {
            super.setBounds(i6, i7, i8, i9);
        } else {
            this.f37455b = a.j((i10 * 1.0f) / this.f37461h, (i11 * 1.0f) / this.f37462i, this.f37463j, this.f37464k);
            g();
        }
    }

    private void d(Canvas canvas) {
        canvas.translate(-this.f37459f, -this.f37460g);
        if (this.f37455b != null) {
            for (int i6 = 0; i6 < this.f37455b.size(); i6++) {
                List<Integer> list = this.f37456c;
                if (list != null && i6 < list.size()) {
                    this.f37454a.setColor(this.f37456c.get(i6).intValue());
                }
                canvas.drawPath(this.f37455b.get(i6), this.f37454a);
            }
        }
    }

    public boolean a(int i6, int i7) {
        return i6 == this.f37465l.getWidth() && i7 == this.f37465l.getHeight();
    }

    public boolean b() {
        return !this.f37466m;
    }

    public void c(int i6, int i7) {
        if (this.f37465l == null || !a(i6, i7)) {
            this.f37465l = Bitmap.createBitmap(i6, i7, Bitmap.Config.ARGB_8888);
            this.f37466m = true;
        }
    }

    public Paint e() {
        return this.f37454a;
    }

    protected void g() {
        Integer num;
        Integer num2;
        Integer num3;
        List<Path> list = this.f37455b;
        Integer num4 = null;
        if (list != null) {
            Integer num5 = null;
            num2 = null;
            num3 = null;
            for (Path path : list) {
                Region region = f37452n;
                region.setPath(path, f37453o);
                Rect bounds = region.getBounds();
                num4 = Integer.valueOf(Math.min(num4 == null ? bounds.top : num4.intValue(), bounds.top));
                num5 = Integer.valueOf(Math.min(num5 == null ? bounds.left : num5.intValue(), bounds.left));
                num2 = Integer.valueOf(Math.max(num2 == null ? bounds.right : num2.intValue(), bounds.right));
                num3 = Integer.valueOf(Math.max(num3 == null ? bounds.bottom : num3.intValue(), bounds.bottom));
            }
            num = num4;
            num4 = num5;
        } else {
            num = null;
            num2 = null;
            num3 = null;
        }
        this.f37459f = num4 == null ? 0 : num4.intValue();
        this.f37460g = num == null ? 0 : num.intValue();
        this.f37457d = num2 == null ? 0 : num2.intValue() - this.f37459f;
        int intValue = num3 != null ? num3.intValue() - this.f37460g : 0;
        this.f37458e = intValue;
        if (this.f37461h == 0) {
            this.f37461h = this.f37457d;
        }
        if (this.f37462i == 0) {
            this.f37462i = intValue;
        }
        Rect bounds2 = getBounds();
        int i6 = bounds2.left;
        int i7 = bounds2.top;
        super.setBounds(i6, i7, this.f37457d + i6, this.f37458e + i7);
    }

    public void h(int... iArr) {
        this.f37456c = new ArrayList();
        for (int i6 : iArr) {
            this.f37456c.add(Integer.valueOf(i6));
        }
    }

    public void m(int i6, int i7) {
        this.f37465l.eraseColor(0);
        d(new Canvas(this.f37465l));
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i6) {
        this.f37454a.setAlpha(i6);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f37454a.setColorFilter(colorFilter);
    }

    public b() {
        Paint paint = new Paint();
        this.f37454a = paint;
        paint.setColor(-15614977);
        this.f37454a.setStyle(Paint.Style.FILL);
        this.f37454a.setAntiAlias(true);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        if (this.f37454a.getAlpha() == 255) {
            canvas.save();
            canvas.translate(bounds.left - this.f37459f, bounds.top - this.f37460g);
            if (this.f37455b != null) {
                for (int i6 = 0; i6 < this.f37455b.size(); i6++) {
                    List<Integer> list = this.f37456c;
                    if (list != null && i6 < list.size()) {
                        this.f37454a.setColor(this.f37456c.get(i6).intValue());
                    }
                    canvas.drawPath(this.f37455b.get(i6), this.f37454a);
                }
                this.f37454a.setAlpha(255);
            }
            canvas.restore();
            return;
        }
        c(width, height);
        if (!b()) {
            m(width, height);
            l();
        }
        canvas.drawBitmap(this.f37465l, bounds.left, bounds.top, this.f37454a);
    }

    public int f() {
        return getBounds().height();
    }

    public void j(int i6) {
        Rect bounds = getBounds();
        float height = (i6 * 1.0f) / bounds.height();
        setBounds((int) (bounds.left * height), (int) (bounds.top * height), (int) (bounds.right * height), (int) (bounds.bottom * height));
    }

    public void k(int i6) {
        Rect bounds = getBounds();
        float width = (i6 * 1.0f) / bounds.width();
        setBounds((int) (bounds.left * width), (int) (bounds.top * width), (int) (bounds.right * width), (int) (bounds.bottom * width));
    }

    public int n() {
        return getBounds().width();
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(@NonNull Rect rect) {
        setBounds(rect.left, rect.top, rect.right, rect.bottom);
    }
}
