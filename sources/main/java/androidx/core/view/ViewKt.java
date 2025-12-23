package androidx.core.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.Px;
import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 View.kt\nandroidx/core/view/ViewKt\n+ 2 Bitmap.kt\nandroidx/core/graphics/BitmapKt\n*L\n1#1,414:1\n37#1:415\n53#1:416\n326#1,4:420\n43#2,3:417\n*S KotlinDebug\n*F\n+ 1 View.kt\nandroidx/core/view/ViewKt\n*L\n68#1:415\n68#1:416\n310#1:420,4\n232#1:417,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class ViewKt {
    public static final void doOnNextLayout(@NotNull View view, @NotNull final Function1<? super View, kotlin.n1> function1) {
        view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.core.view.ViewKt$doOnNextLayout$1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(@NotNull View view2, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
                view2.removeOnLayoutChangeListener(this);
                function1.invoke(view2);
            }
        });
    }

    @NotNull
    public static final OneShotPreDrawListener doOnPreDraw(@NotNull final View view, @NotNull final Function1<? super View, kotlin.n1> function1) {
        return OneShotPreDrawListener.add(view, new Runnable() { // from class: androidx.core.view.ViewKt$doOnPreDraw$1
            @Override // java.lang.Runnable
            public final void run() {
                function1.invoke(view);
            }
        });
    }

    public static /* synthetic */ Bitmap drawToBitmap$default(View view, Bitmap.Config config, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return drawToBitmap(view, config);
    }

    @NotNull
    public static final kotlin.sequences.m<View> getAllViews(@NotNull View view) {
        return kotlin.sequences.p.b(new ViewKt$allViews$1(view, null));
    }

    @NotNull
    public static final Runnable postDelayed(@NotNull View view, long j6, @NotNull final Function0<kotlin.n1> function0) {
        Runnable runnable = new Runnable() { // from class: androidx.core.view.ViewKt$postDelayed$runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                function0.invoke();
            }
        };
        view.postDelayed(runnable, j6);
        return runnable;
    }

    @NotNull
    public static final Runnable postOnAnimationDelayed(@NotNull View view, long j6, @NotNull final Function0<kotlin.n1> function0) {
        Runnable runnable = new Runnable() { // from class: androidx.core.view.l0
            @Override // java.lang.Runnable
            public final void run() {
                Function0.this.invoke();
            }
        };
        view.postOnAnimationDelayed(runnable, j6);
        return runnable;
    }

    public static final void setGone(@NotNull View view, boolean z5) {
        view.setVisibility(z5 ? 8 : 0);
    }

    public static final void setInvisible(@NotNull View view, boolean z5) {
        view.setVisibility(z5 ? 4 : 0);
    }

    public static final void setVisible(@NotNull View view, boolean z5) {
        view.setVisibility(z5 ? 0 : 8);
    }

    public static /* synthetic */ void updatePadding$default(View view, int i6, int i7, int i8, int i9, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i6 = view.getPaddingLeft();
        }
        if ((i10 & 2) != 0) {
            i7 = view.getPaddingTop();
        }
        if ((i10 & 4) != 0) {
            i8 = view.getPaddingRight();
        }
        if ((i10 & 8) != 0) {
            i9 = view.getPaddingBottom();
        }
        view.setPadding(i6, i7, i8, i9);
    }

    public static /* synthetic */ void updatePaddingRelative$default(View view, int i6, int i7, int i8, int i9, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i6 = view.getPaddingStart();
        }
        if ((i10 & 2) != 0) {
            i7 = view.getPaddingTop();
        }
        if ((i10 & 4) != 0) {
            i8 = view.getPaddingEnd();
        }
        if ((i10 & 8) != 0) {
            i9 = view.getPaddingBottom();
        }
        view.setPaddingRelative(i6, i7, i8, i9);
    }

    public static final void doOnAttach(@NotNull final View view, @NotNull final Function1<? super View, kotlin.n1> function1) {
        if (view.isAttachedToWindow()) {
            function1.invoke(view);
        } else {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.core.view.ViewKt$doOnAttach$1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(@NotNull View view2) {
                    view.removeOnAttachStateChangeListener(this);
                    function1.invoke(view2);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(@NotNull View view2) {
                }
            });
        }
    }

    public static final void doOnDetach(@NotNull final View view, @NotNull final Function1<? super View, kotlin.n1> function1) {
        if (!view.isAttachedToWindow()) {
            function1.invoke(view);
        } else {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.core.view.ViewKt$doOnDetach$1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(@NotNull View view2) {
                    view.removeOnAttachStateChangeListener(this);
                    function1.invoke(view2);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(@NotNull View view2) {
                }
            });
        }
    }

    public static final void doOnLayout(@NotNull View view, @NotNull final Function1<? super View, kotlin.n1> function1) {
        if (view.isLaidOut() && !view.isLayoutRequested()) {
            function1.invoke(view);
        } else {
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.core.view.ViewKt$doOnLayout$$inlined$doOnNextLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(@NotNull View view2, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
                    view2.removeOnLayoutChangeListener(this);
                    Function1.this.invoke(view2);
                }
            });
        }
    }

    @NotNull
    public static final Bitmap drawToBitmap(@NotNull View view, @NotNull Bitmap.Config config) {
        if (view.isLaidOut()) {
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), config);
            Canvas canvas = new Canvas(createBitmap);
            canvas.translate(-view.getScrollX(), -view.getScrollY());
            view.draw(canvas);
            return createBitmap;
        }
        throw new IllegalStateException("View needs to be laid out before calling drawToBitmap()");
    }

    @NotNull
    public static final kotlin.sequences.m<ViewParent> getAncestors(@NotNull View view) {
        return kotlin.sequences.p.t(view.getParent(), ViewKt$ancestors$1.INSTANCE);
    }

    public static final int getMarginBottom(@NotNull View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            return marginLayoutParams.bottomMargin;
        }
        return 0;
    }

    public static final int getMarginEnd(@NotNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).getMarginEnd();
        }
        return 0;
    }

    public static final int getMarginLeft(@NotNull View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            return marginLayoutParams.leftMargin;
        }
        return 0;
    }

    public static final int getMarginRight(@NotNull View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            return marginLayoutParams.rightMargin;
        }
        return 0;
    }

    public static final int getMarginStart(@NotNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).getMarginStart();
        }
        return 0;
    }

    public static final int getMarginTop(@NotNull View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            return marginLayoutParams.topMargin;
        }
        return 0;
    }

    public static final boolean isGone(@NotNull View view) {
        if (view.getVisibility() == 8) {
            return true;
        }
        return false;
    }

    public static final boolean isInvisible(@NotNull View view) {
        if (view.getVisibility() == 4) {
            return true;
        }
        return false;
    }

    public static final boolean isVisible(@NotNull View view) {
        if (view.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public static final void setPadding(@NotNull View view, @Px int i6) {
        view.setPadding(i6, i6, i6, i6);
    }

    public static final void updateLayoutParams(@NotNull View view, @NotNull Function1<? super ViewGroup.LayoutParams, kotlin.n1> function1) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            function1.invoke(layoutParams);
            view.setLayoutParams(layoutParams);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @JvmName(name = "updateLayoutParamsTyped")
    public static final /* synthetic */ <T extends ViewGroup.LayoutParams> void updateLayoutParamsTyped(View view, Function1<? super T, kotlin.n1> function1) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        kotlin.jvm.internal.g0.y(1, ExifInterface.GPS_DIRECTION_TRUE);
        function1.invoke(layoutParams);
        view.setLayoutParams(layoutParams);
    }

    public static final void updatePadding(@NotNull View view, @Px int i6, @Px int i7, @Px int i8, @Px int i9) {
        view.setPadding(i6, i7, i8, i9);
    }

    public static final void updatePaddingRelative(@NotNull View view, @Px int i6, @Px int i7, @Px int i8, @Px int i9) {
        view.setPaddingRelative(i6, i7, i8, i9);
    }
}
