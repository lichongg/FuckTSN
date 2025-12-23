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
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.bxkj.student.generated.callback.a;
import com.bxkj.student.v2.ai.fitness.AIFitnessHomeActivity;
import com.bxkj.student.v2.ai.fitness.data.FitnessModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class V2ItemForAiFitnessListBindingImpl extends V2ItemForAiFitnessListBinding implements a.InterfaceC0207a {

    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;

    @Nullable
    private static final SparseIntArray sViewsWithIds;

    @Nullable
    private final View.OnClickListener mCallback78;
    private long mDirtyFlags;

    @NonNull
    private final ConstraintLayout mboundView0;

    @NonNull
    private final CardView mboundView1;

    public V2ItemForAiFitnessListBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j6;
        synchronized (this) {
            j6 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        FitnessModel fitnessModel = this.mFitnessModel;
        long j7 = 6 & j6;
        String b6 = (j7 == 0 || fitnessModel == null) ? null : fitnessModel.b();
        if (j7 != 0) {
            TextViewBindingAdapter.setText(this.btMenu, b6);
        }
        if ((j6 & 4) != 0) {
            this.mboundView1.setOnClickListener(this.mCallback78);
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
            this.mDirtyFlags = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (2 == variableId) {
            setAiFitnessHomeActivity((AIFitnessHomeActivity) variable);
            return true;
        }
        if (10 != variableId) {
            return false;
        }
        setFitnessModel((FitnessModel) variable);
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131297155, 3);
    }

    private V2ItemForAiFitnessListBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[2], (ImageView) bindings[3]);
        this.mDirtyFlags = -1L;
        this.btMenu.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        CardView cardView = (CardView) bindings[1];
        this.mboundView1 = cardView;
        cardView.setTag(null);
        setRootTag(root);
        this.mCallback78 = new a(this, 1);
        invalidateAll();
    }

    @Override // com.bxkj.student.generated.callback.a.InterfaceC0207a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        AIFitnessHomeActivity aIFitnessHomeActivity = this.mAiFitnessHomeActivity;
        FitnessModel fitnessModel = this.mFitnessModel;
        if (aIFitnessHomeActivity != null) {
            aIFitnessHomeActivity.N(fitnessModel);
        }
    }

    @Override // com.bxkj.student.databinding.V2ItemForAiFitnessListBinding
    public void setAiFitnessHomeActivity(@Nullable AIFitnessHomeActivity AiFitnessHomeActivity) {
        this.mAiFitnessHomeActivity = AiFitnessHomeActivity;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.V2ItemForAiFitnessListBinding
    public void setFitnessModel(@Nullable FitnessModel FitnessModel) {
        this.mFitnessModel = FitnessModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }
}
