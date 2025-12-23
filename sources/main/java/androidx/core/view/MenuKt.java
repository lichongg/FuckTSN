package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nMenu.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Menu.kt\nandroidx/core/view/MenuKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,90:1\n1#2:91\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class MenuKt {
    @NotNull
    public static final kotlin.sequences.m<MenuItem> getChildren(@NotNull final Menu menu) {
        return new kotlin.sequences.m<MenuItem>() { // from class: androidx.core.view.MenuKt$children$1
            @Override // kotlin.sequences.m
            @NotNull
            public Iterator<MenuItem> iterator() {
                return MenuKt.iterator(menu);
            }
        };
    }

    @NotNull
    public static final Iterator<MenuItem> iterator(@NotNull Menu menu) {
        return new MenuKt$iterator$1(menu);
    }

    public static final boolean contains(@NotNull Menu menu, @NotNull MenuItem menuItem) {
        int size = menu.size();
        for (int i6 = 0; i6 < size; i6++) {
            if (kotlin.jvm.internal.g0.g(menu.getItem(i6), menuItem)) {
                return true;
            }
        }
        return false;
    }

    public static final void forEach(@NotNull Menu menu, @NotNull Function1<? super MenuItem, kotlin.n1> function1) {
        int size = menu.size();
        for (int i6 = 0; i6 < size; i6++) {
            function1.invoke(menu.getItem(i6));
        }
    }

    public static final void forEachIndexed(@NotNull Menu menu, @NotNull Function2<? super Integer, ? super MenuItem, kotlin.n1> function2) {
        int size = menu.size();
        for (int i6 = 0; i6 < size; i6++) {
            function2.invoke(Integer.valueOf(i6), menu.getItem(i6));
        }
    }

    @NotNull
    public static final MenuItem get(@NotNull Menu menu, int i6) {
        return menu.getItem(i6);
    }

    public static final int getSize(@NotNull Menu menu) {
        return menu.size();
    }

    public static final boolean isEmpty(@NotNull Menu menu) {
        if (menu.size() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean isNotEmpty(@NotNull Menu menu) {
        if (menu.size() != 0) {
            return true;
        }
        return false;
    }

    public static final void minusAssign(@NotNull Menu menu, @NotNull MenuItem menuItem) {
        menu.removeItem(menuItem.getItemId());
    }

    public static final void removeItemAt(@NotNull Menu menu, int i6) {
        kotlin.n1 n1Var;
        MenuItem item = menu.getItem(i6);
        if (item != null) {
            menu.removeItem(item.getItemId());
            n1Var = kotlin.n1.f44123a;
        } else {
            n1Var = null;
        }
        if (n1Var != null) {
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
}
