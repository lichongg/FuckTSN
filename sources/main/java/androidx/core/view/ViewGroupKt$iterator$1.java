package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class ViewGroupKt$iterator$1 implements Iterator<View>, m3.d {
    final /* synthetic */ ViewGroup $this_iterator;
    private int index;

    ViewGroupKt$iterator$1(ViewGroup viewGroup) {
        this.$this_iterator = viewGroup;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.$this_iterator.getChildCount();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    @NotNull
    public View next() {
        ViewGroup viewGroup = this.$this_iterator;
        int i6 = this.index;
        this.index = i6 + 1;
        View childAt = viewGroup.getChildAt(i6);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // java.util.Iterator
    public void remove() {
        ViewGroup viewGroup = this.$this_iterator;
        int i6 = this.index - 1;
        this.index = i6;
        viewGroup.removeViewAt(i6);
    }
}
