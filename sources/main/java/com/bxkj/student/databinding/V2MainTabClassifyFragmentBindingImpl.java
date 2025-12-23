package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.bxkj.student.R;
import com.bxkj.student.generated.callback.a;
import com.bxkj.student.v2.ui.main.ClassifyFragment;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class V2MainTabClassifyFragmentBindingImpl extends V2MainTabClassifyFragmentBinding implements a.InterfaceC0207a {

    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;

    @Nullable
    private static final SparseIntArray sViewsWithIds;

    @Nullable
    private final View.OnClickListener mCallback76;

    @Nullable
    private final View.OnClickListener mCallback77;
    private long mDirtyFlags;

    @NonNull
    private final ConstraintLayout mboundView0;

    public V2MainTabClassifyFragmentBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }

    @Override // com.bxkj.student.generated.callback.a.InterfaceC0207a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        ClassifyFragment classifyFragment;
        if (sourceId != 1) {
            if (sourceId == 2 && (classifyFragment = this.mClassifyFragment) != null) {
                classifyFragment.n();
                return;
            }
            return;
        }
        ClassifyFragment classifyFragment2 = this.mClassifyFragment;
        if (classifyFragment2 != null) {
            classifyFragment2.n();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j6;
        synchronized (this) {
            j6 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        if ((j6 & 2) != 0) {
            this.tvHomeMenuArrow.setOnClickListener(this.mCallback77);
            this.tvHomeMenuCount.setOnClickListener(this.mCallback76);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.mDirtyFlags != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (6 != variableId) {
            return false;
        }
        setClassifyFragment((ClassifyFragment) variable);
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131299164, 3);
        sparseIntArray.put(R.id.card_home, 4);
        sparseIntArray.put(R.id.tv_home_menu_hint, 5);
        sparseIntArray.put(R.id.rv_home_menu, 6);
        sparseIntArray.put(R.id.rv_menu, 7);
    }

    private V2MainTabClassifyFragmentBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (CardView) bindings[4], (RecyclerView) bindings[6], (RecyclerView) bindings[7], (ImageView) bindings[2], (TextView) bindings[1], (TextView) bindings[5], (TextView) bindings[3]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.tvHomeMenuArrow.setTag(null);
        this.tvHomeMenuCount.setTag(null);
        setRootTag(root);
        this.mCallback76 = new a(this, 1);
        this.mCallback77 = new a(this, 2);
        invalidateAll();
    }

    @Override // com.bxkj.student.databinding.V2MainTabClassifyFragmentBinding
    public void setClassifyFragment(@Nullable ClassifyFragment ClassifyFragment) {
        this.mClassifyFragment = ClassifyFragment;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(6);
        super.requestRebind();
    }
}
