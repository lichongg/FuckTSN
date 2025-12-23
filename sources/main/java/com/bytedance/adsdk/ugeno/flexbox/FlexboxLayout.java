package com.bytedance.adsdk.ugeno.flexbox;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.flexbox.r;
import com.bytedance.adsdk.ugeno.m.ae;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class FlexboxLayout extends ViewGroup implements com.bytedance.adsdk.ugeno.flexbox.j {
    private Drawable ae;
    private List<cw> av;
    private r az;
    private int cw;

    /* renamed from: g, reason: collision with root package name */
    private int f23642g;

    /* renamed from: i, reason: collision with root package name */
    private com.bytedance.adsdk.ugeno.cw f23643i;

    /* renamed from: j, reason: collision with root package name */
    private int f23644j;
    private int[] jy;

    /* renamed from: m, reason: collision with root package name */
    private int f23645m;
    private int oq;
    private int qv;

    /* renamed from: r, reason: collision with root package name */
    private int f23646r;
    private Drawable tl;
    private int up;
    private int vl;

    /* renamed from: w, reason: collision with root package name */
    private r.j f23647w;
    private SparseIntArray ws;
    private int xt;

    public static class j extends ViewGroup.MarginLayoutParams implements xt {
        public static final Parcelable.Creator<j> CREATOR = new Parcelable.Creator<j>() { // from class: com.bytedance.adsdk.ugeno.flexbox.FlexboxLayout.j.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public j createFromParcel(Parcel parcel) {
                return new j(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public j[] newArray(int i6) {
                return new j[i6];
            }
        };
        private int ae;
        private float cw;

        /* renamed from: g, reason: collision with root package name */
        private int f23648g;

        /* renamed from: j, reason: collision with root package name */
        private int f23649j;

        /* renamed from: m, reason: collision with root package name */
        private int f23650m;
        private boolean oq;

        /* renamed from: r, reason: collision with root package name */
        private int f23651r;
        private int tl;
        private float up;
        private float xt;

        public j(j jVar) {
            super((ViewGroup.MarginLayoutParams) jVar);
            this.f23649j = 1;
            this.xt = 0.0f;
            this.cw = 0.0f;
            this.f23651r = -1;
            this.up = -1.0f;
            this.f23650m = -1;
            this.ae = -1;
            this.tl = 16777215;
            this.f23648g = 16777215;
            this.f23649j = jVar.f23649j;
            this.xt = jVar.xt;
            this.cw = jVar.cw;
            this.f23651r = jVar.f23651r;
            this.up = jVar.up;
            this.f23650m = jVar.f23650m;
            this.ae = jVar.ae;
            this.tl = jVar.tl;
            this.f23648g = jVar.f23648g;
            this.oq = jVar.oq;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.xt
        public int cw() {
            return this.f23649j;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.xt
        public int j() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.xt
        public float r() {
            return this.xt;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.xt
        public int xt() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.xt
        public int ae() {
            return this.f23650m;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.xt
        public int av() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.xt
        public int az() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        public void cw(int i6) {
            this.f23649j = i6;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.xt
        public int g() {
            return this.tl;
        }

        public void j(float f6) {
            this.xt = f6;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.xt
        public int jy() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.xt
        public int m() {
            return this.f23651r;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.xt
        public int oq() {
            return this.f23648g;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.xt
        public boolean qv() {
            return this.oq;
        }

        public void r(int i6) {
            this.f23651r = i6;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.xt
        public int tl() {
            return this.ae;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.xt
        public float up() {
            return this.cw;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.xt
        public float vl() {
            return this.up;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            parcel.writeInt(this.f23649j);
            parcel.writeFloat(this.xt);
            parcel.writeFloat(this.cw);
            parcel.writeInt(this.f23651r);
            parcel.writeFloat(this.up);
            parcel.writeInt(this.f23650m);
            parcel.writeInt(this.ae);
            parcel.writeInt(this.tl);
            parcel.writeInt(this.f23648g);
            parcel.writeByte(this.oq ? (byte) 1 : (byte) 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.xt
        public int ws() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        public void xt(float f6) {
            this.cw = f6;
        }

        public void cw(float f6) {
            this.up = f6;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.xt
        public void j(int i6) {
            this.f23650m = i6;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.xt
        public void xt(int i6) {
            this.ae = i6;
        }

        public j(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f23649j = 1;
            this.xt = 0.0f;
            this.cw = 0.0f;
            this.f23651r = -1;
            this.up = -1.0f;
            this.f23650m = -1;
            this.ae = -1;
            this.tl = 16777215;
            this.f23648g = 16777215;
        }

        public j(int i6, int i7) {
            super(new ViewGroup.LayoutParams(i6, i7));
            this.f23649j = 1;
            this.xt = 0.0f;
            this.cw = 0.0f;
            this.f23651r = -1;
            this.up = -1.0f;
            this.f23650m = -1;
            this.ae = -1;
            this.tl = 16777215;
            this.f23648g = 16777215;
        }

        public j(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f23649j = 1;
            this.xt = 0.0f;
            this.cw = 0.0f;
            this.f23651r = -1;
            this.up = -1.0f;
            this.f23650m = -1;
            this.ae = -1;
            this.tl = 16777215;
            this.f23648g = 16777215;
        }

        protected j(Parcel parcel) {
            super(0, 0);
            this.f23649j = 1;
            this.xt = 0.0f;
            this.cw = 0.0f;
            this.f23651r = -1;
            this.up = -1.0f;
            this.f23650m = -1;
            this.ae = -1;
            this.tl = 16777215;
            this.f23648g = 16777215;
            this.f23649j = parcel.readInt();
            this.xt = parcel.readFloat();
            this.cw = parcel.readFloat();
            this.f23651r = parcel.readInt();
            this.up = parcel.readFloat();
            this.f23650m = parcel.readInt();
            this.ae = parcel.readInt();
            this.tl = parcel.readInt();
            this.f23648g = parcel.readInt();
            this.oq = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }
    }

    public FlexboxLayout(Context context) {
        super(context, null);
        this.f23645m = -1;
        this.az = new r(this);
        this.av = new ArrayList();
        this.f23647w = new r.j();
    }

    private boolean m(int i6) {
        if (i6 >= 0 && i6 < this.av.size()) {
            for (int i7 = i6 + 1; i7 < this.av.size(); i7++) {
                if (this.av.get(i7).xt() > 0) {
                    return false;
                }
            }
            if (j()) {
                return (this.f23642g & 4) != 0;
            }
            if ((this.oq & 4) != 0) {
                return true;
            }
        }
        return false;
    }

    private boolean r(int i6, int i7) {
        return up(i6, i7) ? j() ? (this.oq & 1) != 0 : (this.f23642g & 1) != 0 : j() ? (this.oq & 2) != 0 : (this.f23642g & 2) != 0;
    }

    private boolean up(int i6, int i7) {
        for (int i8 = 1; i8 <= i7; i8++) {
            View cw = cw(i6 - i8);
            if (cw != null && cw.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    public View cw(int i6) {
        if (i6 < 0) {
            return null;
        }
        int[] iArr = this.jy;
        if (i6 >= iArr.length) {
            return null;
        }
        return getChildAt(iArr[i6]);
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.j
    public int j(View view) {
        return 0;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.j
    public View xt(int i6) {
        return cw(i6);
    }

    private void j(int i6, int i7) {
        if (this.ws == null) {
            this.ws = new SparseIntArray(getChildCount());
        }
        if (this.az.xt(this.ws)) {
            this.jy = this.az.j(this.ws);
        }
        int i8 = this.f23644j;
        if (i8 == 0 || i8 == 1) {
            xt(i6, i7);
        } else if (i8 == 2 || i8 == 3) {
            cw(i6, i7);
        } else {
            throw new IllegalStateException("Invalid value for the flex direction is set: " + this.f23644j);
        }
    }

    private void xt(int i6, int i7) {
        this.av.clear();
        this.f23647w.j();
        this.az.j(this.f23647w, i6, i7);
        this.av = this.f23647w.f23661j;
        this.az.j(i6, i7);
        if (this.f23646r == 3) {
            for (cw cwVar : this.av) {
                int i8 = Integer.MIN_VALUE;
                for (int i9 = 0; i9 < cwVar.tl; i9++) {
                    View cw = cw(cwVar.az + i9);
                    if (cw != null && cw.getVisibility() != 8) {
                        j jVar = (j) cw.getLayoutParams();
                        i8 = this.xt != 2 ? Math.max(i8, cw.getMeasuredHeight() + Math.max(cwVar.vl - cw.getBaseline(), ((ViewGroup.MarginLayoutParams) jVar).topMargin) + ((ViewGroup.MarginLayoutParams) jVar).bottomMargin) : Math.max(i8, cw.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) jVar).topMargin + Math.max((cwVar.vl - cw.getMeasuredHeight()) + cw.getBaseline(), ((ViewGroup.MarginLayoutParams) jVar).bottomMargin));
                    }
                }
                cwVar.ae = i8;
            }
        }
        this.az.xt(i6, i7, getPaddingTop() + getPaddingBottom());
        this.az.j();
        j(this.f23644j, i6, i7, this.f23647w.xt);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i6, ViewGroup.LayoutParams layoutParams) {
        if (this.ws == null) {
            this.ws = new SparseIntArray(getChildCount());
        }
        this.jy = this.az.j(view, i6, layoutParams, this.ws);
        super.addView(view, i6, layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof j;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof j ? new j((j) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new j((ViewGroup.MarginLayoutParams) layoutParams) : new j(layoutParams);
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.j
    public int getAlignContent() {
        return this.up;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.j
    public int getAlignItems() {
        return this.f23646r;
    }

    public Drawable getDividerDrawableHorizontal() {
        return this.ae;
    }

    public Drawable getDividerDrawableVertical() {
        return this.tl;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.j
    public int getFlexDirection() {
        return this.f23644j;
    }

    public List<cw> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.av.size());
        for (cw cwVar : this.av) {
            if (cwVar.xt() != 0) {
                arrayList.add(cwVar);
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.j
    public List<cw> getFlexLinesInternal() {
        return this.av;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.j
    public int getFlexWrap() {
        return this.xt;
    }

    public int getJustifyContent() {
        return this.cw;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.j
    public int getLargestMainSize() {
        Iterator<cw> it = this.av.iterator();
        int i6 = Integer.MIN_VALUE;
        while (it.hasNext()) {
            i6 = Math.max(i6, it.next().up);
        }
        return i6;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.j
    public int getMaxLine() {
        return this.f23645m;
    }

    public int getShowDividerHorizontal() {
        return this.f23642g;
    }

    public int getShowDividerVertical() {
        return this.oq;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.j
    public int getSumOfCrossSize() {
        int size = this.av.size();
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            cw cwVar = this.av.get(i7);
            if (r(i7)) {
                i6 += j() ? this.qv : this.vl;
            }
            if (m(i7)) {
                i6 += j() ? this.qv : this.vl;
            }
            i6 += cwVar.ae;
        }
        return i6;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.tl == null && this.ae == null) {
            return;
        }
        if (this.f23642g == 0 && this.oq == 0) {
            return;
        }
        int j6 = ae.j(this);
        int i6 = this.f23644j;
        if (i6 == 0) {
            j(canvas, j6 == 1, this.xt == 2);
            return;
        }
        if (i6 == 1) {
            j(canvas, j6 != 1, this.xt == 2);
            return;
        }
        if (i6 == 2) {
            boolean z5 = j6 == 1;
            if (this.xt == 2) {
                z5 = !z5;
            }
            xt(canvas, z5, false);
            return;
        }
        if (i6 != 3) {
            return;
        }
        boolean z6 = j6 == 1;
        if (this.xt == 2) {
            z6 = !z6;
        }
        xt(canvas, z6, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        boolean z6;
        com.bytedance.adsdk.ugeno.cw cwVar = this.f23643i;
        if (cwVar != null) {
            cwVar.r();
        }
        int j6 = ae.j(this);
        int i10 = this.f23644j;
        if (i10 == 0) {
            j(j6 == 1, i6, i7, i8, i9);
        } else if (i10 == 1) {
            j(j6 != 1, i6, i7, i8, i9);
        } else if (i10 == 2) {
            z6 = j6 == 1;
            if (this.xt == 2) {
                z6 = !z6;
            }
            j(z6, false, i6, i7, i8, i9);
        } else {
            if (i10 != 3) {
                throw new IllegalStateException("Invalid flex direction is set: " + this.f23644j);
            }
            z6 = j6 == 1;
            if (this.xt == 2) {
                z6 = !z6;
            }
            j(z6, true, i6, i7, i8, i9);
        }
        com.bytedance.adsdk.ugeno.cw cwVar2 = this.f23643i;
        if (cwVar2 != null) {
            cwVar2.j(i6, i7, i8, i9);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        com.bytedance.adsdk.ugeno.cw cwVar = this.f23643i;
        if (cwVar != null) {
            int[] j6 = cwVar.j(i6, i7);
            j(j6[0], j6[1]);
        } else {
            j(i6, i7);
        }
        com.bytedance.adsdk.ugeno.cw cwVar2 = this.f23643i;
        if (cwVar2 != null) {
            cwVar2.cw();
        }
    }

    public void setAlignContent(int i6) {
        if (this.up != i6) {
            this.up = i6;
            requestLayout();
        }
    }

    public void setAlignItems(int i6) {
        if (this.f23646r != i6) {
            this.f23646r = i6;
            requestLayout();
        }
    }

    public void setDividerDrawableHorizontal(Drawable drawable) {
        if (drawable == this.ae) {
            return;
        }
        this.ae = drawable;
        if (drawable != null) {
            this.qv = drawable.getIntrinsicHeight();
        } else {
            this.qv = 0;
        }
        xt();
        requestLayout();
    }

    public void setDividerDrawableVertical(Drawable drawable) {
        if (drawable == this.tl) {
            return;
        }
        this.tl = drawable;
        if (drawable != null) {
            this.vl = drawable.getIntrinsicWidth();
        } else {
            this.vl = 0;
        }
        xt();
        requestLayout();
    }

    public void setFlexDirection(int i6) {
        if (this.f23644j != i6) {
            this.f23644j = i6;
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.j
    public void setFlexLines(List<cw> list) {
        this.av = list;
    }

    public void setFlexWrap(int i6) {
        if (this.xt != i6) {
            this.xt = i6;
            requestLayout();
        }
    }

    public void setJustifyContent(int i6) {
        if (this.cw != i6) {
            this.cw = i6;
            requestLayout();
        }
    }

    public void setMaxLine(int i6) {
        if (this.f23645m != i6) {
            this.f23645m = i6;
            requestLayout();
        }
    }

    public void setShowDividerHorizontal(int i6) {
        if (i6 != this.f23642g) {
            this.f23642g = i6;
            requestLayout();
        }
    }

    public void setShowDividerVertical(int i6) {
        if (i6 != this.oq) {
            this.oq = i6;
            requestLayout();
        }
    }

    private void cw(int i6, int i7) {
        this.av.clear();
        this.f23647w.j();
        this.az.xt(this.f23647w, i6, i7);
        this.av = this.f23647w.f23661j;
        this.az.j(i6, i7);
        this.az.xt(i6, i7, getPaddingLeft() + getPaddingRight());
        this.az.j();
        j(this.f23644j, i6, i7, this.f23647w.xt);
    }

    private boolean up(int i6) {
        for (int i7 = 0; i7 < i6; i7++) {
            if (this.av.get(i7).xt() > 0) {
                return false;
            }
        }
        return true;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.j
    public int getFlexItemCount() {
        return getChildCount();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.adsdk.ugeno.cw cwVar = this.f23643i;
        if (cwVar != null) {
            cwVar.up();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bytedance.adsdk.ugeno.cw cwVar = this.f23643i;
        if (cwVar != null) {
            cwVar.m();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        com.bytedance.adsdk.ugeno.cw cwVar = this.f23643i;
        if (cwVar != null) {
            cwVar.xt(i6, i7, i8, i9);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
        com.bytedance.adsdk.ugeno.cw cwVar = this.f23643i;
        if (cwVar != null) {
            cwVar.j(z5);
        }
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setShowDivider(int i6) {
        setShowDividerVertical(i6);
        setShowDividerHorizontal(i6);
    }

    private boolean r(int i6) {
        if (i6 >= 0 && i6 < this.av.size()) {
            if (up(i6)) {
                return j() ? (this.f23642g & 1) != 0 : (this.oq & 1) != 0;
            }
            if (j()) {
                return (this.f23642g & 2) != 0;
            }
            if ((this.oq & 2) != 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.j
    public View j(int i6) {
        return getChildAt(i6);
    }

    private void j(int i6, int i7, int i8, int i9) {
        int sumOfCrossSize;
        int largestMainSize;
        int resolveSizeAndState;
        int resolveSizeAndState2;
        int mode = View.MeasureSpec.getMode(i7);
        int size = View.MeasureSpec.getSize(i7);
        int mode2 = View.MeasureSpec.getMode(i8);
        int size2 = View.MeasureSpec.getSize(i8);
        if (i6 == 0 || i6 == 1) {
            sumOfCrossSize = getSumOfCrossSize() + getPaddingTop() + getPaddingBottom();
            largestMainSize = getLargestMainSize();
        } else {
            if (i6 != 2 && i6 != 3) {
                throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(i6)));
            }
            sumOfCrossSize = getLargestMainSize();
            largestMainSize = getSumOfCrossSize() + getPaddingLeft() + getPaddingRight();
        }
        if (mode == Integer.MIN_VALUE) {
            if (size < largestMainSize) {
                i9 = View.combineMeasuredStates(i9, 16777216);
            } else {
                size = largestMainSize;
            }
            resolveSizeAndState = View.resolveSizeAndState(size, i7, i9);
        } else if (mode == 0) {
            resolveSizeAndState = View.resolveSizeAndState(largestMainSize, i7, i9);
        } else if (mode == 1073741824) {
            if (size < largestMainSize) {
                i9 = View.combineMeasuredStates(i9, 16777216);
            }
            resolveSizeAndState = View.resolveSizeAndState(size, i7, i9);
        } else {
            throw new IllegalStateException("Unknown width mode is set: ".concat(String.valueOf(mode)));
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (size2 < sumOfCrossSize) {
                i9 = View.combineMeasuredStates(i9, 256);
            } else {
                size2 = sumOfCrossSize;
            }
            resolveSizeAndState2 = View.resolveSizeAndState(size2, i8, i9);
        } else if (mode2 == 0) {
            resolveSizeAndState2 = View.resolveSizeAndState(sumOfCrossSize, i8, i9);
        } else if (mode2 == 1073741824) {
            if (size2 < sumOfCrossSize) {
                i9 = View.combineMeasuredStates(i9, 256);
            }
            resolveSizeAndState2 = View.resolveSizeAndState(size2, i8, i9);
        } else {
            throw new IllegalStateException("Unknown height mode is set: ".concat(String.valueOf(mode2)));
        }
        setMeasuredDimension(resolveSizeAndState, resolveSizeAndState2);
    }

    private void xt(Canvas canvas, boolean z5, boolean z6) {
        int i6;
        int i7;
        int bottom;
        int top2;
        int paddingTop = getPaddingTop();
        int max = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.av.size();
        for (int i8 = 0; i8 < size; i8++) {
            cw cwVar = this.av.get(i8);
            for (int i9 = 0; i9 < cwVar.tl; i9++) {
                int i10 = cwVar.az + i9;
                View cw = cw(i10);
                if (cw != null && cw.getVisibility() != 8) {
                    j jVar = (j) cw.getLayoutParams();
                    if (r(i10, i9)) {
                        if (z6) {
                            top2 = cw.getBottom() + ((ViewGroup.MarginLayoutParams) jVar).bottomMargin;
                        } else {
                            top2 = (cw.getTop() - ((ViewGroup.MarginLayoutParams) jVar).topMargin) - this.qv;
                        }
                        xt(canvas, cwVar.f23654j, top2, cwVar.ae);
                    }
                    if (i9 == cwVar.tl - 1 && (this.f23642g & 4) > 0) {
                        if (z6) {
                            bottom = (cw.getTop() - ((ViewGroup.MarginLayoutParams) jVar).topMargin) - this.qv;
                        } else {
                            bottom = cw.getBottom() + ((ViewGroup.MarginLayoutParams) jVar).bottomMargin;
                        }
                        xt(canvas, cwVar.f23654j, bottom, cwVar.ae);
                    }
                }
            }
            if (r(i8)) {
                if (z5) {
                    i7 = cwVar.cw;
                } else {
                    i7 = cwVar.f23654j - this.vl;
                }
                j(canvas, i7, paddingTop, max);
            }
            if (m(i8) && (this.oq & 4) > 0) {
                if (z5) {
                    i6 = cwVar.f23654j - this.vl;
                } else {
                    i6 = cwVar.cw;
                }
                j(canvas, i6, paddingTop, max);
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.j
    public boolean j() {
        int i6 = this.f23644j;
        return i6 == 0 || i6 == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void j(boolean r25, int r26, int r27, int r28, int r29) {
        /*
            Method dump skipped, instructions count: 517
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.flexbox.FlexboxLayout.j(boolean, int, int, int, int):void");
    }

    private void xt(Canvas canvas, int i6, int i7, int i8) {
        Drawable drawable = this.ae;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i6, i7, i8 + i6, this.qv + i7);
        this.ae.draw(canvas);
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.j
    public int xt(int i6, int i7, int i8) {
        return ViewGroup.getChildMeasureSpec(i6, i7, i8);
    }

    private void xt() {
        if (this.ae == null && this.tl == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void j(boolean r25, boolean r26, int r27, int r28, int r29, int r30) {
        /*
            Method dump skipped, instructions count: 497
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.flexbox.FlexboxLayout.j(boolean, boolean, int, int, int, int):void");
    }

    private void j(Canvas canvas, boolean z5, boolean z6) {
        int i6;
        int i7;
        int right;
        int left;
        int paddingLeft = getPaddingLeft();
        int max = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.av.size();
        for (int i8 = 0; i8 < size; i8++) {
            cw cwVar = this.av.get(i8);
            for (int i9 = 0; i9 < cwVar.tl; i9++) {
                int i10 = cwVar.az + i9;
                View cw = cw(i10);
                if (cw != null && cw.getVisibility() != 8) {
                    j jVar = (j) cw.getLayoutParams();
                    if (r(i10, i9)) {
                        if (z5) {
                            left = cw.getRight() + ((ViewGroup.MarginLayoutParams) jVar).rightMargin;
                        } else {
                            left = (cw.getLeft() - ((ViewGroup.MarginLayoutParams) jVar).leftMargin) - this.vl;
                        }
                        j(canvas, left, cwVar.xt, cwVar.ae);
                    }
                    if (i9 == cwVar.tl - 1 && (this.oq & 4) > 0) {
                        if (z5) {
                            right = (cw.getLeft() - ((ViewGroup.MarginLayoutParams) jVar).leftMargin) - this.vl;
                        } else {
                            right = cw.getRight() + ((ViewGroup.MarginLayoutParams) jVar).rightMargin;
                        }
                        j(canvas, right, cwVar.xt, cwVar.ae);
                    }
                }
            }
            if (r(i8)) {
                if (z6) {
                    i7 = cwVar.f23656r;
                } else {
                    i7 = cwVar.xt - this.qv;
                }
                xt(canvas, paddingLeft, i7, max);
            }
            if (m(i8) && (this.f23642g & 4) > 0) {
                if (z6) {
                    i6 = cwVar.xt - this.qv;
                } else {
                    i6 = cwVar.f23656r;
                }
                xt(canvas, paddingLeft, i6, max);
            }
        }
    }

    private void j(Canvas canvas, int i6, int i7, int i8) {
        Drawable drawable = this.tl;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i6, i7, this.vl + i6, i8 + i7);
        this.tl.draw(canvas);
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.j
    public int j(View view, int i6, int i7) {
        int i8;
        int i9;
        if (j()) {
            i8 = r(i6, i7) ? this.vl : 0;
            if ((this.oq & 4) <= 0) {
                return i8;
            }
            i9 = this.vl;
        } else {
            i8 = r(i6, i7) ? this.qv : 0;
            if ((this.f23642g & 4) <= 0) {
                return i8;
            }
            i9 = this.qv;
        }
        return i8 + i9;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.j
    public void j(cw cwVar) {
        if (j()) {
            if ((this.oq & 4) > 0) {
                int i6 = cwVar.up;
                int i7 = this.vl;
                cwVar.up = i6 + i7;
                cwVar.f23655m += i7;
                return;
            }
            return;
        }
        if ((this.f23642g & 4) > 0) {
            int i8 = cwVar.up;
            int i9 = this.qv;
            cwVar.up = i8 + i9;
            cwVar.f23655m += i9;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.j
    public int j(int i6, int i7, int i8) {
        return ViewGroup.getChildMeasureSpec(i6, i7, i8);
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.j
    public void j(View view, int i6, int i7, cw cwVar) {
        if (r(i6, i7)) {
            if (j()) {
                int i8 = cwVar.up;
                int i9 = this.vl;
                cwVar.up = i8 + i9;
                cwVar.f23655m += i9;
                return;
            }
            int i10 = cwVar.up;
            int i11 = this.qv;
            cwVar.up = i10 + i11;
            cwVar.f23655m += i11;
        }
    }

    public void j(com.bytedance.adsdk.ugeno.xt.cw cwVar) {
        this.f23643i = cwVar;
    }
}
