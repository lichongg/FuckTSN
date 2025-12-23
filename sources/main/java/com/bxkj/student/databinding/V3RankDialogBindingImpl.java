package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.R;
import com.bxkj.student.generated.callback.a;
import com.bxkj.student.v2.ui.sports.v3.detail.V3RankTipsDialog;
import com.google.android.material.imageview.ShapeableImageView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class V3RankDialogBindingImpl extends V3RankDialogBinding implements a.InterfaceC0207a {

    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;

    @Nullable
    private static final SparseIntArray sViewsWithIds;

    @Nullable
    private final View.OnClickListener mCallback75;
    private long mDirtyFlags;

    @NonNull
    private final ConstraintLayout mboundView0;

    @NonNull
    private final ShapeableImageView mboundView1;

    public V3RankDialogBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j6;
        synchronized (this) {
            j6 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        if ((j6 & 2) != 0) {
            this.mboundView1.setOnClickListener(this.mCallback75);
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

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.rl_threetwoone, 2);
        sparseIntArray.put(2131298982, 3);
    }

    private V3RankDialogBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (CardView) bindings[2], (TextView) bindings[3]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        ShapeableImageView shapeableImageView = (ShapeableImageView) bindings[1];
        this.mboundView1 = shapeableImageView;
        shapeableImageView.setTag(null);
        setRootTag(root);
        this.mCallback75 = new a(this, 1);
        invalidateAll();
    }

    @Override // com.bxkj.student.generated.callback.a.InterfaceC0207a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        V3RankTipsDialog v3RankTipsDialog = this.mDialog;
        if (v3RankTipsDialog != null) {
            v3RankTipsDialog.dismiss();
        }
    }

    @Override // com.bxkj.student.databinding.V3RankDialogBinding
    public void setDialog(@Nullable V3RankTipsDialog Dialog) {
        this.mDialog = Dialog;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(9);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (9 != variableId) {
            return false;
        }
        setDialog((V3RankTipsDialog) variable);
        return true;
    }
}
