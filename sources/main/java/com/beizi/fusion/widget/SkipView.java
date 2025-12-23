package com.beizi.fusion.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.beizi.fusion.tool.ap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class SkipView extends TextView {

    /* renamed from: a, reason: collision with root package name */
    private int f13939a;

    /* renamed from: b, reason: collision with root package name */
    private TextPaint f13940b;

    /* renamed from: c, reason: collision with root package name */
    private float f13941c;

    /* renamed from: d, reason: collision with root package name */
    private float f13942d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f13943e;

    /* renamed from: f, reason: collision with root package name */
    private RectF f13944f;

    /* renamed from: g, reason: collision with root package name */
    private RectF f13945g;

    /* renamed from: h, reason: collision with root package name */
    private int f13946h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f13947i;

    /* renamed from: j, reason: collision with root package name */
    private SparseIntArray f13948j;

    /* renamed from: k, reason: collision with root package name */
    private final a f13949k;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private interface a {
        int a(int i6, RectF rectF);
    }

    public SkipView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f13942d = 20.0f;
        this.f13944f = new RectF();
        this.f13947i = true;
        this.f13949k = new a() { // from class: com.beizi.fusion.widget.SkipView.1
            @Override // com.beizi.fusion.widget.SkipView.a
            @TargetApi(16)
            public int a(int i7, RectF rectF) {
                SkipView.this.f13940b.setTextSize(i7);
                String charSequence = SkipView.this.getText().toString();
                SkipView.this.f13944f.bottom = SkipView.this.f13940b.getFontSpacing();
                SkipView.this.f13944f.right = SkipView.this.f13940b.measureText(charSequence);
                SkipView.this.f13944f.offsetTo(0.0f, 0.0f);
                return rectF.contains(SkipView.this.f13944f) ? -1 : 1;
            }
        };
        init(context);
    }

    private void a(Context context, int i6) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#80000000"));
        if (i6 == 1) {
            gradientDrawable.setStroke(1, Color.parseColor("#C0C0C0"));
        }
        gradientDrawable.setCornerRadius(ap.a(context, 45.0f));
        setBackgroundDrawable(gradientDrawable);
    }

    private static int b(int i6, int i7, a aVar, RectF rectF) {
        int i8 = i7 - 1;
        int i9 = i6;
        while (i6 <= i8) {
            i9 = (i6 + i8) >>> 1;
            int a6 = aVar.a(i9, rectF);
            if (a6 >= 0) {
                if (a6 <= 0) {
                    break;
                }
                i9--;
                i8 = i9;
            } else {
                int i10 = i9 + 1;
                i9 = i6;
                i6 = i10;
            }
        }
        return i9;
    }

    public void init(Context context) {
        setGravity(17);
        setLines(1);
        setMaxLines(1);
        setTextColor(-1);
        a(context, 0);
        TextPaint textPaint = new TextPaint();
        this.f13940b = textPaint;
        textPaint.set(getPaint());
        this.f13941c = getTextSize();
        this.f13945g = new RectF();
        this.f13948j = new SparseIntArray();
        this.f13943e = true;
        setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 53));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        SparseIntArray sparseIntArray = this.f13948j;
        if (sparseIntArray != null) {
            sparseIntArray.clear();
        }
        super.onSizeChanged(i6, i7, i8, i9);
        if (i6 == i8 && i7 == i9) {
            return;
        }
        a();
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
        super.onTextChanged(charSequence, i6, i7, i8);
        a();
    }

    public void setData(int i6, int i7) {
        a(getContext(), i6);
        this.f13939a = i7;
    }

    public SkipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13942d = 20.0f;
        this.f13944f = new RectF();
        this.f13947i = true;
        this.f13949k = new a() { // from class: com.beizi.fusion.widget.SkipView.1
            @Override // com.beizi.fusion.widget.SkipView.a
            @TargetApi(16)
            public int a(int i7, RectF rectF) {
                SkipView.this.f13940b.setTextSize(i7);
                String charSequence = SkipView.this.getText().toString();
                SkipView.this.f13944f.bottom = SkipView.this.f13940b.getFontSpacing();
                SkipView.this.f13944f.right = SkipView.this.f13940b.measureText(charSequence);
                SkipView.this.f13944f.offsetTo(0.0f, 0.0f);
                return rectF.contains(SkipView.this.f13944f) ? -1 : 1;
            }
        };
        init(context);
    }

    private void a() {
        a(getText().toString());
    }

    private void a(String str) {
        if (this.f13943e) {
            int i6 = (int) this.f13942d;
            int measuredHeight = ((getMeasuredHeight() - getCompoundPaddingBottom()) - getCompoundPaddingTop()) - this.f13939a;
            int measuredWidth = ((getMeasuredWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight()) - ap.a(getContext(), 8.0f);
            this.f13946h = measuredWidth;
            RectF rectF = this.f13945g;
            rectF.right = measuredWidth;
            rectF.bottom = measuredHeight;
            super.setTextSize(0, a(i6, (int) this.f13941c, this.f13949k, rectF));
        }
    }

    public SkipView(Context context) {
        super(context);
        this.f13942d = 20.0f;
        this.f13944f = new RectF();
        this.f13947i = true;
        this.f13949k = new a() { // from class: com.beizi.fusion.widget.SkipView.1
            @Override // com.beizi.fusion.widget.SkipView.a
            @TargetApi(16)
            public int a(int i7, RectF rectF) {
                SkipView.this.f13940b.setTextSize(i7);
                String charSequence = SkipView.this.getText().toString();
                SkipView.this.f13944f.bottom = SkipView.this.f13940b.getFontSpacing();
                SkipView.this.f13944f.right = SkipView.this.f13940b.measureText(charSequence);
                SkipView.this.f13944f.offsetTo(0.0f, 0.0f);
                return rectF.contains(SkipView.this.f13944f) ? -1 : 1;
            }
        };
        init(context);
    }

    private int a(int i6, int i7, a aVar, RectF rectF) {
        if (!this.f13947i) {
            return b(i6, i7, aVar, rectF);
        }
        String charSequence = getText().toString();
        int length = charSequence == null ? 0 : charSequence.length();
        int i8 = this.f13948j.get(length);
        if (i8 != 0) {
            return i8;
        }
        int b6 = b(i6, i7, aVar, rectF);
        this.f13948j.put(length, b6);
        return b6;
    }
}
