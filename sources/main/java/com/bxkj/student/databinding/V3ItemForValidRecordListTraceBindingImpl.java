package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class V3ItemForValidRecordListTraceBindingImpl extends V3ItemForValidRecordListTraceBinding {

    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;

    @Nullable
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    @NonNull
    private final ConstraintLayout mboundView0;

    public V3ItemForValidRecordListTraceBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j6;
        synchronized (this) {
            j6 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        int i6 = this.mSportType;
        long j7 = j6 & 3;
        int i7 = 0;
        if (j7 != 0) {
            boolean z5 = i6 == 5;
            if (j7 != 0) {
                j6 |= z5 ? 8L : 4L;
            }
            if (z5) {
                i7 = 8;
            }
        }
        if ((j6 & 3) != 0) {
            this.ivSportsDistance.setVisibility(i7);
            this.ivSportsStep.setVisibility(i7);
            this.tvDistance.setVisibility(i7);
            this.tvDistanceUnit.setVisibility(i7);
            this.tvStep.setVisibility(i7);
            this.tvStepUnit.setVisibility(i7);
            this.vCenter.setVisibility(i7);
            this.vLeft.setVisibility(i7);
            this.vRight.setVisibility(i7);
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
        sparseIntArray.put(R.id.iv_sports_type, 10);
        sparseIntArray.put(R.id.tv_sports_type_name, 11);
        sparseIntArray.put(2131299158, 12);
        sparseIntArray.put(R.id.iv_sports_time, 13);
        sparseIntArray.put(R.id.tv_duration, 14);
    }

    private V3ItemForValidRecordListTraceBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[4], (ImageView) bindings[7], (ImageView) bindings[13], (ImageView) bindings[10], (TextView) bindings[5], (TextView) bindings[6], (TextView) bindings[14], (TextView) bindings[11], (TextView) bindings[8], (TextView) bindings[9], (TextView) bindings[12], (View) bindings[2], (View) bindings[1], (View) bindings[3]);
        this.mDirtyFlags = -1L;
        this.ivSportsDistance.setTag(null);
        this.ivSportsStep.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.tvDistance.setTag(null);
        this.tvDistanceUnit.setTag(null);
        this.tvStep.setTag(null);
        this.tvStepUnit.setTag(null);
        this.vCenter.setTag(null);
        this.vLeft.setTag(null);
        this.vRight.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // com.bxkj.student.databinding.V3ItemForValidRecordListTraceBinding
    public void setSportType(int SportType) {
        this.mSportType = SportType;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(26);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (26 != variableId) {
            return false;
        }
        setSportType(((Integer) variable).intValue());
        return true;
    }
}
