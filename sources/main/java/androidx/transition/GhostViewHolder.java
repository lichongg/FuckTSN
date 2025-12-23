package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"ViewConstructor"})
/* loaded from: D:\Downloads\app\classes.dex */
class GhostViewHolder extends FrameLayout {
    private boolean mAttached;

    @NonNull
    private ViewGroup mParent;

    private static boolean isOnTop(ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        if (arrayList.isEmpty() || arrayList2.isEmpty() || arrayList.get(0) != arrayList2.get(0)) {
            return true;
        }
        int min = Math.min(arrayList.size(), arrayList2.size());
        for (int i6 = 1; i6 < min; i6++) {
            View view = arrayList.get(i6);
            View view2 = arrayList2.get(i6);
            if (view != view2) {
                return isOnTop(view, view2);
            }
        }
        return arrayList2.size() == min;
    }

    static GhostViewHolder getHolder(@NonNull ViewGroup viewGroup) {
        return (GhostViewHolder) viewGroup.getTag(R.id.ghost_view_holder);
    }

    private int getInsertIndex(ArrayList<View> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int childCount = getChildCount() - 1;
        int i6 = 0;
        while (i6 <= childCount) {
            int i7 = (i6 + childCount) / 2;
            getParents(((GhostViewPort) getChildAt(i7)).mView, arrayList2);
            if (isOnTop(arrayList, (ArrayList<View>) arrayList2)) {
                i6 = i7 + 1;
            } else {
                childCount = i7 - 1;
            }
            arrayList2.clear();
        }
        return i6;
    }

    void addGhostView(GhostViewPort ghostViewPort) {
        ArrayList<View> arrayList = new ArrayList<>();
        getParents(ghostViewPort.mView, arrayList);
        int insertIndex = getInsertIndex(arrayList);
        if (insertIndex < 0 || insertIndex >= getChildCount()) {
            addView(ghostViewPort);
        } else {
            addView(ghostViewPort, insertIndex);
        }
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        if (!this.mAttached) {
            throw new IllegalStateException("This GhostViewHolder is detached!");
        }
        super.onViewAdded(view);
    }

    void popToOverlayTop() {
        if (!this.mAttached) {
            throw new IllegalStateException("This GhostViewHolder is detached!");
        }
        ViewGroupUtils.getOverlay(this.mParent).remove(this);
        ViewGroupUtils.getOverlay(this.mParent).add(this);
    }

    GhostViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext());
        setClipChildren(false);
        this.mParent = viewGroup;
        viewGroup.setTag(R.id.ghost_view_holder, this);
        ViewGroupUtils.getOverlay(this.mParent).add(this);
        this.mAttached = true;
    }

    private static void getParents(View view, ArrayList<View> arrayList) {
        Object parent = view.getParent();
        if (parent instanceof ViewGroup) {
            getParents((View) parent, arrayList);
        }
        arrayList.add(view);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if ((getChildCount() == 1 && getChildAt(0) == view) || getChildCount() == 0) {
            this.mParent.setTag(R.id.ghost_view_holder, null);
            ViewGroupUtils.getOverlay(this.mParent).remove(this);
            this.mAttached = false;
        }
    }

    private static boolean isOnTop(View view, View view2) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int childCount = viewGroup.getChildCount();
        if (view.getZ() != view2.getZ()) {
            return view.getZ() > view2.getZ();
        }
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = viewGroup.getChildAt(ViewGroupUtils.getChildDrawingOrder(viewGroup, i6));
            if (childAt == view) {
                return false;
            }
            if (childAt == view2) {
                return true;
            }
        }
        return true;
    }
}
