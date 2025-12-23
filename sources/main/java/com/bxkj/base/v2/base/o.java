package com.bxkj.base.v2.base;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.databinding.BindingAdapter;
import com.bxkj.base.R;
import com.bxkj.base.v2.common.view.SportCardView;
import java.io.File;
import java.text.DecimalFormat;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nBindingAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BindingAdapter.kt\ncom/bxkj/base/v2/base/BindingAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,134:1\n1#2:135\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final o f16740a = new o();

    @BindingAdapter({"background"})
    @JvmStatic
    public static final void c(@NotNull ViewGroup viewGroup, @Nullable Drawable drawable) {
        g0.p(viewGroup, "viewGroup");
        if (drawable != null) {
            viewGroup.setBackground(drawable);
        }
    }

    @BindingAdapter({"bitmap"})
    @JvmStatic
    public static final void d(@NotNull ImageView imageView, @Nullable Bitmap bitmap) {
        g0.p(imageView, "imageView");
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    @BindingAdapter({"src"})
    @JvmStatic
    public static final void e(@NotNull ImageView imageView, @Nullable Drawable drawable) {
        g0.p(imageView, "imageView");
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    @BindingAdapter({"imageUrl"})
    @JvmStatic
    public static final void f(@NotNull ImageView imageView, @Nullable String str) {
        g0.p(imageView, "imageView");
        com.bumptech.glide.b.D(imageView.getContext()).a(str).m1(imageView);
    }

    @BindingAdapter({"imageUrl", "placeHolder", "error"})
    @JvmStatic
    public static final void g(@NotNull ImageView imageView, @Nullable String str, @Nullable Drawable drawable, @Nullable Drawable drawable2) {
        g0.p(imageView, "imageView");
        if (str != null) {
            if (str.length() <= 0) {
                str = null;
            }
            if (str != null) {
                if (u.H2(str, master.flame.danmaku.danmaku.parser.b.f50154a, false, 2, null)) {
                    com.bumptech.glide.b.D(imageView.getContext()).a(str).z0(drawable).A(drawable2).m1(imageView);
                } else if (u.H2(str, "/", false, 2, null)) {
                    com.bumptech.glide.b.D(imageView.getContext()).e(new File(str)).z0(drawable).A(drawable2).m1(imageView);
                } else {
                    com.bumptech.glide.b.D(imageView.getContext()).p(Integer.valueOf(Integer.parseInt(str))).z0(drawable).A(drawable2).m1(imageView);
                }
            }
        }
    }

    @BindingAdapter({"cardBackground"})
    @JvmStatic
    public static final void h(@NotNull CardView cardView, int i6) {
        g0.p(cardView, "cardView");
        cardView.setCardBackgroundColor(i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(TextView textView, ValueAnimator animation) {
        g0.p(animation, "animation");
        textView.setText(animation.getAnimatedValue().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(TextView textView, ValueAnimator animation) {
        g0.p(animation, "animation");
        g0.n(animation.getAnimatedValue(), "null cannot be cast to non-null type kotlin.Float");
        textView.setText(new DecimalFormat("0.000").format(((Float) r4).floatValue()));
    }

    @BindingAdapter({NotificationCompat.CATEGORY_PROGRESS, "max"})
    @JvmStatic
    public static final void m(@NotNull ProgressBar progressBar, int i6, int i7) {
        g0.p(progressBar, "progressBar");
        progressBar.setMax(i7);
        progressBar.setProgress(i6);
    }

    @BindingAdapter({"count", "distance"})
    @JvmStatic
    public static final void n(@NotNull SportCardView sportCardView, @Nullable String str, @Nullable String str2) {
        g0.p(sportCardView, "sportCardView");
        if (str != null) {
            o oVar = f16740a;
            View findViewById = sportCardView.findViewById(R.id.tv_count);
            g0.o(findViewById, "findViewById(...)");
            oVar.i((TextView) findViewById, (int) Float.parseFloat(str));
        }
        if (str2 != null) {
            o oVar2 = f16740a;
            View findViewById2 = sportCardView.findViewById(R.id.tv_distance);
            g0.o(findViewById2, "findViewById(...)");
            oVar2.k((TextView) findViewById2, Float.parseFloat(str2));
        }
    }

    public final void i(@NotNull final TextView tvCount, int i6) {
        g0.p(tvCount, "tvCount");
        ValueAnimator ofInt = ValueAnimator.ofInt(0, i6);
        ofInt.setDuration(1000L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bxkj.base.v2.base.n
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                o.j(tvCount, valueAnimator);
            }
        });
        ofInt.start();
    }

    public final void k(@NotNull final TextView tvDistance, float f6) {
        g0.p(tvDistance, "tvDistance");
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, f6);
        ofFloat.setDuration(1000L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bxkj.base.v2.base.m
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                o.l(tvDistance, valueAnimator);
            }
        });
        ofFloat.start();
    }

    private o() {
    }
}
