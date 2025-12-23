package cn.bluemobi.dylan.base.adapter.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.util.Linkify;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.utils.o;
import com.bumptech.glide.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: d, reason: collision with root package name */
    private SparseArray<View> f1128d;

    /* renamed from: e, reason: collision with root package name */
    private View f1129e;

    /* renamed from: f, reason: collision with root package name */
    private Context f1130f;

    /* renamed from: g, reason: collision with root package name */
    private int f1131g;

    /* renamed from: h, reason: collision with root package name */
    private int f1132h;

    public ViewHolder M(Typeface typeface, int... iArr) {
        for (int i6 : iArr) {
            TextView textView = (TextView) h(i6);
            textView.setTypeface(typeface);
            textView.setPaintFlags(textView.getPaintFlags() | 128);
        }
        return this;
    }

    public static ViewHolder a(Context context, View view, ViewGroup viewGroup, int i6) {
        if (view != null) {
            return (ViewHolder) view.getTag();
        }
        ViewHolder viewHolder = new ViewHolder(context, LayoutInflater.from(context).inflate(i6, viewGroup, false), viewGroup);
        viewHolder.f1131g = i6;
        return viewHolder;
    }

    public View b() {
        return this.f1129e;
    }

    public int e() {
        return this.f1131g;
    }

    public int f() {
        return this.f1132h;
    }

    public <T extends View> T h(int i6) {
        T t5 = (T) this.f1128d.get(i6);
        if (t5 != null) {
            return t5;
        }
        T t6 = (T) this.f1129e.findViewById(i6);
        this.f1128d.put(i6, t6);
        return t6;
    }

    public ViewHolder v(int i6) {
        this.f1132h = i6;
        return this;
    }

    public ViewHolder(Context context, View view, ViewGroup viewGroup) {
        super(view);
        this.f1132h = getLayoutPosition();
        this.f1130f = context;
        this.f1129e = view;
        this.f1128d = new SparseArray<>();
        this.f1129e.setTag(this);
    }

    public ViewHolder A(int i6, int i7, int i8) {
        ProgressBar progressBar = (ProgressBar) h(i6);
        progressBar.setMax(i8);
        progressBar.setProgress(i7);
        return this;
    }

    public ViewHolder B(int i6, float f6) {
        ((RatingBar) h(i6)).setRating(f6);
        return this;
    }

    public ViewHolder C(int i6, float f6, int i7) {
        RatingBar ratingBar = (RatingBar) h(i6);
        ratingBar.setMax(i7);
        ratingBar.setRating(f6);
        return this;
    }

    public ViewHolder D(int i6, String str, int i7) {
        o.c(this.f1130f, str, (ImageView) h(i6), i7);
        return this;
    }

    public ViewHolder E(int i6, String str, int i7, int i8, int i9) {
        o.d(this.f1130f, str, (ImageView) h(i6), i8, i9, i7);
        return this;
    }

    public ViewHolder F(int i6, String str) {
        o.e(this.f1130f, str, (ImageView) h(i6));
        return this;
    }

    public ViewHolder G(int i6, String str, int i7, int i8) {
        o.f(this.f1130f, str, (ImageView) h(i6), i7, i8);
        return this;
    }

    public ViewHolder H(int i6, int i7, Object obj) {
        h(i6).setTag(i7, obj);
        return this;
    }

    public ViewHolder I(int i6, Object obj) {
        h(i6).setTag(obj);
        return this;
    }

    public ViewHolder J(int i6, CharSequence charSequence) {
        ((TextView) h(i6)).setText(charSequence);
        return this;
    }

    public ViewHolder K(int i6, int i7) {
        ((TextView) h(i6)).setTextColor(i7);
        return this;
    }

    public ViewHolder L(int i6, int i7) {
        ((TextView) h(i6)).setTextColor(this.f1130f.getResources().getColor(i7));
        return this;
    }

    public ViewHolder N(int i6, boolean z5) {
        int i7;
        View h6 = h(i6);
        if (z5) {
            i7 = 0;
        } else {
            i7 = 8;
        }
        h6.setVisibility(i7);
        return this;
    }

    public boolean c(int i6) {
        return h(i6).isEnabled();
    }

    public String d(int i6) {
        return ((TextView) h(i6)).getHint().toString().trim();
    }

    public String g(int i6) {
        return ((TextView) h(i6)).getText().toString().trim();
    }

    public ViewHolder i(int i6) {
        Linkify.addLinks((TextView) h(i6), 15);
        return this;
    }

    @SuppressLint({"NewApi"})
    public ViewHolder j(int i6, float f6) {
        h(i6).setAlpha(f6);
        return this;
    }

    public ViewHolder k(int i6, int i7) {
        h(i6).setBackgroundColor(i7);
        return this;
    }

    public ViewHolder l(int i6, int i7) {
        h(i6).setBackgroundResource(i7);
        return this;
    }

    public ViewHolder m(int i6, boolean z5) {
        ((Checkable) h(i6)).setChecked(z5);
        return this;
    }

    public ViewHolder n(int i6, boolean z5) {
        h(i6).setEnabled(z5);
        return this;
    }

    public ViewHolder o(int i6, String str) {
        ((TextView) h(i6)).setHint(str);
        return this;
    }

    public ViewHolder p(int i6, Bitmap bitmap) {
        ((ImageView) h(i6)).setImageBitmap(bitmap);
        return this;
    }

    public ViewHolder q(int i6, Drawable drawable) {
        ((ImageView) h(i6)).setImageDrawable(drawable);
        return this;
    }

    public ViewHolder r(int i6, int i7) {
        ((ImageView) h(i6)).setImageResource(i7);
        return this;
    }

    public ViewHolder s(int i6, String str) {
        b.D(this.f1130f).a(str).m1((ImageView) h(i6));
        return this;
    }

    public ViewHolder t(int i6, String str, int i7, int i8) {
        b.D(this.f1130f).a(str).y0(i7).z(i8).m1((ImageView) h(i6));
        return this;
    }

    public ViewHolder u(int i6, int i7) {
        ((ProgressBar) h(i6)).setMax(i7);
        return this;
    }

    public ViewHolder w(int i6, View.OnClickListener onClickListener) {
        h(i6).setOnClickListener(onClickListener);
        return this;
    }

    public ViewHolder x(int i6, View.OnLongClickListener onLongClickListener) {
        h(i6).setOnLongClickListener(onLongClickListener);
        return this;
    }

    public ViewHolder y(int i6, View.OnTouchListener onTouchListener) {
        h(i6).setOnTouchListener(onTouchListener);
        return this;
    }

    public ViewHolder z(int i6, int i7) {
        ((ProgressBar) h(i6)).setProgress(i7);
        return this;
    }
}
