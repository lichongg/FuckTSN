package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class ViewGroupKt {
    @NotNull
    public static final kotlin.ranges.m getIndices(@NotNull ViewGroup viewGroup) {
        return kotlin.ranges.t.W1(0, viewGroup.getChildCount());
    }

    @NotNull
    public static final kotlin.sequences.m<View> getChildren(@NotNull final ViewGroup viewGroup) {
        return new kotlin.sequences.m<View>() { // from class: androidx.core.view.ViewGroupKt$children$1
            @Override // kotlin.sequences.m
            @NotNull
            public Iterator<View> iterator() {
                return ViewGroupKt.iterator(viewGroup);
            }
        };
    }

    @NotNull
    public static final kotlin.sequences.m<View> getDescendants(@NotNull final ViewGroup viewGroup) {
        return new kotlin.sequences.m<View>() { // from class: androidx.core.view.ViewGroupKt$special$$inlined$Sequence$1
            @Override // kotlin.sequences.m
            @NotNull
            public Iterator<View> iterator() {
                return new TreeIterator(ViewGroupKt.getChildren(viewGroup).iterator(), new Function1<View, Iterator<? extends View>>() { // from class: androidx.core.view.ViewGroupKt$descendants$1$1
                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final Iterator<View> invoke(@NotNull View view) {
                        kotlin.sequences.m<View> children;
                        ViewGroup viewGroup2 = view instanceof ViewGroup ? (ViewGroup) view : null;
                        if (viewGroup2 == null || (children = ViewGroupKt.getChildren(viewGroup2)) == null) {
                            return null;
                        }
                        return children.iterator();
                    }
                });
            }
        };
    }

    @NotNull
    public static final Iterator<View> iterator(@NotNull ViewGroup viewGroup) {
        return new ViewGroupKt$iterator$1(viewGroup);
    }

    public static /* synthetic */ void updateMargins$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i6, int i7, int i8, int i9, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i6 = marginLayoutParams.leftMargin;
        }
        if ((i10 & 2) != 0) {
            i7 = marginLayoutParams.topMargin;
        }
        if ((i10 & 4) != 0) {
            i8 = marginLayoutParams.rightMargin;
        }
        if ((i10 & 8) != 0) {
            i9 = marginLayoutParams.bottomMargin;
        }
        marginLayoutParams.setMargins(i6, i7, i8, i9);
    }

    public static /* synthetic */ void updateMarginsRelative$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i6, int i7, int i8, int i9, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i6 = marginLayoutParams.getMarginStart();
        }
        if ((i10 & 2) != 0) {
            i7 = marginLayoutParams.topMargin;
        }
        if ((i10 & 4) != 0) {
            i8 = marginLayoutParams.getMarginEnd();
        }
        if ((i10 & 8) != 0) {
            i9 = marginLayoutParams.bottomMargin;
        }
        marginLayoutParams.setMarginStart(i6);
        marginLayoutParams.topMargin = i7;
        marginLayoutParams.setMarginEnd(i8);
        marginLayoutParams.bottomMargin = i9;
    }

    public static final boolean contains(@NotNull ViewGroup viewGroup, @NotNull View view) {
        if (viewGroup.indexOfChild(view) != -1) {
            return true;
        }
        return false;
    }

    public static final void forEach(@NotNull ViewGroup viewGroup, @NotNull Function1<? super View, kotlin.n1> function1) {
        int childCount = viewGroup.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            function1.invoke(viewGroup.getChildAt(i6));
        }
    }

    public static final void forEachIndexed(@NotNull ViewGroup viewGroup, @NotNull Function2<? super Integer, ? super View, kotlin.n1> function2) {
        int childCount = viewGroup.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            function2.invoke(Integer.valueOf(i6), viewGroup.getChildAt(i6));
        }
    }

    @NotNull
    public static final View get(@NotNull ViewGroup viewGroup, int i6) {
        View childAt = viewGroup.getChildAt(i6);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException("Index: " + i6 + ", Size: " + viewGroup.getChildCount());
    }

    public static final int getSize(@NotNull ViewGroup viewGroup) {
        return viewGroup.getChildCount();
    }

    public static final boolean isEmpty(@NotNull ViewGroup viewGroup) {
        if (viewGroup.getChildCount() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean isNotEmpty(@NotNull ViewGroup viewGroup) {
        if (viewGroup.getChildCount() != 0) {
            return true;
        }
        return false;
    }

    public static final void minusAssign(@NotNull ViewGroup viewGroup, @NotNull View view) {
        viewGroup.removeView(view);
    }

    public static final void plusAssign(@NotNull ViewGroup viewGroup, @NotNull View view) {
        viewGroup.addView(view);
    }

    public static final void setMargins(@NotNull ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i6) {
        marginLayoutParams.setMargins(i6, i6, i6, i6);
    }

    public static final void updateMargins(@NotNull ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i6, @Px int i7, @Px int i8, @Px int i9) {
        marginLayoutParams.setMargins(i6, i7, i8, i9);
    }

    public static final void updateMarginsRelative(@NotNull ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i6, @Px int i7, @Px int i8, @Px int i9) {
        marginLayoutParams.setMarginStart(i6);
        marginLayoutParams.topMargin = i7;
        marginLayoutParams.setMarginEnd(i8);
        marginLayoutParams.bottomMargin = i9;
    }
}
