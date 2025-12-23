package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nMenu.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Menu.kt\nandroidx/core/view/MenuKt$iterator$1\n+ 2 Menu.kt\nandroidx/core/view/MenuKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,90:1\n83#2:91\n1#3:92\n*S KotlinDebug\n*F\n+ 1 Menu.kt\nandroidx/core/view/MenuKt$iterator$1\n*L\n74#1:91\n74#1:92\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class MenuKt$iterator$1 implements Iterator<MenuItem>, m3.d {
    final /* synthetic */ Menu $this_iterator;
    private int index;

    MenuKt$iterator$1(Menu menu) {
        this.$this_iterator = menu;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.$this_iterator.size();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    @NotNull
    public MenuItem next() {
        Menu menu = this.$this_iterator;
        int i6 = this.index;
        this.index = i6 + 1;
        MenuItem item = menu.getItem(i6);
        if (item != null) {
            return item;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // java.util.Iterator
    public void remove() {
        kotlin.n1 n1Var;
        Menu menu = this.$this_iterator;
        int i6 = this.index - 1;
        this.index = i6;
        MenuItem item = menu.getItem(i6);
        if (item != null) {
            menu.removeItem(item.getItemId());
            n1Var = kotlin.n1.f44123a;
        } else {
            n1Var = null;
        }
        if (n1Var == null) {
            throw new IndexOutOfBoundsException();
        }
    }
}
