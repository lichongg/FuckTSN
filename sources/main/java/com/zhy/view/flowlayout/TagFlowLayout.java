package com.zhy.view.flowlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.hms.common.util.Logger;
import com.zhy.view.flowlayout.b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class TagFlowLayout extends FlowLayout implements b.a {

    /* renamed from: q, reason: collision with root package name */
    private static final String f42946q = "TagFlowLayout";

    /* renamed from: r, reason: collision with root package name */
    private static final String f42947r = "key_choose_pos";

    /* renamed from: s, reason: collision with root package name */
    private static final String f42948s = "key_default";

    /* renamed from: j, reason: collision with root package name */
    private com.zhy.view.flowlayout.b f42949j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f42950k;

    /* renamed from: l, reason: collision with root package name */
    private int f42951l;

    /* renamed from: m, reason: collision with root package name */
    private MotionEvent f42952m;

    /* renamed from: n, reason: collision with root package name */
    private Set<Integer> f42953n;

    /* renamed from: o, reason: collision with root package name */
    private a f42954o;

    /* renamed from: p, reason: collision with root package name */
    private b f42955p;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(Set<Integer> set);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        boolean a(View view, int i6, FlowLayout flowLayout);
    }

    public TagFlowLayout(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f42950k = true;
        this.f42951l = -1;
        this.f42953n = new HashSet();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TagFlowLayout);
        this.f42950k = obtainStyledAttributes.getBoolean(R.styleable.TagFlowLayout_auto_select_effect, true);
        this.f42951l = obtainStyledAttributes.getInt(R.styleable.TagFlowLayout_max_select, -1);
        obtainStyledAttributes.recycle();
        if (this.f42950k) {
            setClickable(true);
        }
    }

    private void d(TagView tagView, int i6) {
        if (this.f42950k) {
            if (tagView.isChecked()) {
                tagView.setChecked(false);
                this.f42953n.remove(Integer.valueOf(i6));
            } else if (this.f42951l == 1 && this.f42953n.size() == 1) {
                Integer next = this.f42953n.iterator().next();
                ((TagView) getChildAt(next.intValue())).setChecked(false);
                tagView.setChecked(true);
                this.f42953n.remove(next);
                this.f42953n.add(Integer.valueOf(i6));
            } else {
                if (this.f42951l > 0 && this.f42953n.size() >= this.f42951l) {
                    return;
                }
                tagView.setChecked(true);
                this.f42953n.add(Integer.valueOf(i6));
            }
            a aVar = this.f42954o;
            if (aVar != null) {
                aVar.a(new HashSet(this.f42953n));
            }
        }
    }

    @Override // com.zhy.view.flowlayout.b.a
    public void a() {
        this.f42953n.clear();
        b();
    }

    public com.zhy.view.flowlayout.b getAdapter() {
        return this.f42949j;
    }

    public Set<Integer> getSelectedList() {
        return new HashSet(this.f42953n);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        String string = bundle.getString(f42947r);
        if (!TextUtils.isEmpty(string)) {
            for (String str : string.split("\\|")) {
                int parseInt = Integer.parseInt(str);
                this.f42953n.add(Integer.valueOf(parseInt));
                TagView tagView = (TagView) getChildAt(parseInt);
                if (tagView != null) {
                    tagView.setChecked(true);
                }
            }
        }
        super.onRestoreInstanceState(bundle.getParcelable(f42948s));
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(f42948s, super.onSaveInstanceState());
        String str = "";
        if (this.f42953n.size() > 0) {
            Iterator<Integer> it = this.f42953n.iterator();
            while (it.hasNext()) {
                str = str + it.next().intValue() + Logger.f33116c;
            }
            str = str.substring(0, str.length() - 1);
        }
        bundle.putString(f42947r, str);
        return bundle;
    }

    @Override // android.view.View
    public boolean performClick() {
        MotionEvent motionEvent = this.f42952m;
        if (motionEvent == null) {
            return super.performClick();
        }
        int x5 = (int) motionEvent.getX();
        int y5 = (int) this.f42952m.getY();
        this.f42952m = null;
        TagView e6 = e(x5, y5);
        int f6 = f(e6);
        if (e6 == null) {
            return true;
        }
        d(e6, f6);
        b bVar = this.f42955p;
        if (bVar != null) {
            return bVar.a(e6.getTagView(), f6, this);
        }
        return true;
    }

    public void setAdapter(com.zhy.view.flowlayout.b bVar) {
        this.f42949j = bVar;
        bVar.f(this);
        this.f42953n.clear();
        b();
    }

    public void setMaxSelectCount(int i6) {
        if (this.f42953n.size() > i6) {
            this.f42953n.clear();
        }
        this.f42951l = i6;
    }

    public void setOnSelectListener(a aVar) {
        this.f42954o = aVar;
        if (aVar != null) {
            setClickable(true);
        }
    }

    public void setOnTagClickListener(b bVar) {
        this.f42955p = bVar;
        if (bVar != null) {
            setClickable(true);
        }
    }

    private void b() {
        removeAllViews();
        com.zhy.view.flowlayout.b bVar = this.f42949j;
        HashSet<Integer> c6 = bVar.c();
        for (int i6 = 0; i6 < bVar.a(); i6++) {
            View d6 = bVar.d(this, i6, bVar.b(i6));
            TagView tagView = new TagView(getContext());
            d6.setDuplicateParentStateEnabled(true);
            if (d6.getLayoutParams() != null) {
                tagView.setLayoutParams(d6.getLayoutParams());
            } else {
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
                marginLayoutParams.setMargins(c(getContext(), 5.0f), c(getContext(), 5.0f), c(getContext(), 5.0f), c(getContext(), 5.0f));
                tagView.setLayoutParams(marginLayoutParams);
            }
            tagView.addView(d6);
            addView(tagView);
            if (c6.contains(Integer.valueOf(i6))) {
                tagView.setChecked(true);
            }
            if (this.f42949j.g(i6, bVar.b(i6))) {
                this.f42953n.add(Integer.valueOf(i6));
                tagView.setChecked(true);
            }
        }
        this.f42953n.addAll(c6);
    }

    public static int c(Context context, float f6) {
        return (int) ((f6 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private TagView e(int i6, int i7) {
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            TagView tagView = (TagView) getChildAt(i8);
            if (tagView.getVisibility() != 8) {
                Rect rect = new Rect();
                tagView.getHitRect(rect);
                if (rect.contains(i6, i7)) {
                    return tagView;
                }
            }
        }
        return null;
    }

    private int f(View view) {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            if (getChildAt(i6) == view) {
                return i6;
            }
        }
        return -1;
    }

    @Override // com.zhy.view.flowlayout.FlowLayout, android.view.View
    protected void onMeasure(int i6, int i7) {
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            TagView tagView = (TagView) getChildAt(i8);
            if (tagView.getVisibility() != 8 && tagView.getTagView().getVisibility() == 8) {
                tagView.setVisibility(8);
            }
        }
        super.onMeasure(i6, i7);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.f42952m = MotionEvent.obtain(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public TagFlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TagFlowLayout(Context context) {
        this(context, null);
    }
}
