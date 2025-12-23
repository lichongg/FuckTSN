package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.bxkj.student.R;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartView;
import com.google.android.material.card.MaterialCardView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class FmV3SportsChartBindingImpl extends FmV3SportsChartBinding {

    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;

    @Nullable
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    @NonNull
    private final NestedScrollView mboundView0;

    public FmV3SportsChartBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 31, sIncludes, sViewsWithIds));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
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
            this.mDirtyFlags = 1L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.cl_root, 1);
        sparseIntArray.put(R.id.card_pace, 2);
        sparseIntArray.put(R.id.tv_pace_hint, 3);
        sparseIntArray.put(R.id.card_pace_line, 4);
        sparseIntArray.put(R.id.tv_avg_pace_hint, 5);
        sparseIntArray.put(R.id.tv_best_pace_hint, 6);
        sparseIntArray.put(R.id.tv_avg_pace, 7);
        sparseIntArray.put(R.id.tv_best_pace, 8);
        sparseIntArray.put(R.id.tv_y_name, 9);
        sparseIntArray.put(R.id.AAChartView, 10);
        sparseIntArray.put(R.id.tv_x_name, 11);
        sparseIntArray.put(R.id.card_step, 12);
        sparseIntArray.put(R.id.tv_step_hint, 13);
        sparseIntArray.put(R.id.card_step_line, 14);
        sparseIntArray.put(R.id.tv_avg_step_hint, 15);
        sparseIntArray.put(R.id.tv_best_step_hint, 16);
        sparseIntArray.put(R.id.tv_avg_step, 17);
        sparseIntArray.put(R.id.tv_best_step, 18);
        sparseIntArray.put(R.id.tv_y_step_name, 19);
        sparseIntArray.put(R.id.AAChartView_step, 20);
        sparseIntArray.put(R.id.tv_x_step_name, 21);
        sparseIntArray.put(R.id.card_pace2, 22);
        sparseIntArray.put(R.id.tv_pace2_hint, 23);
        sparseIntArray.put(R.id.card_pace2_line, 24);
        sparseIntArray.put(R.id.tv_avg_pace2_hint, 25);
        sparseIntArray.put(R.id.tv_best_pace2_hint, 26);
        sparseIntArray.put(R.id.tv_avg_pace2, 27);
        sparseIntArray.put(R.id.tv_best_pace2, 28);
        sparseIntArray.put(R.id.rv_pace2, 29);
        sparseIntArray.put(R.id.tv_last_km_pace, 30);
    }

    private FmV3SportsChartBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (AAChartView) bindings[10], (AAChartView) bindings[20], (MaterialCardView) bindings[2], (MaterialCardView) bindings[22], (MaterialCardView) bindings[24], (MaterialCardView) bindings[4], (MaterialCardView) bindings[12], (MaterialCardView) bindings[14], (ConstraintLayout) bindings[1], (RecyclerView) bindings[29], (TextView) bindings[7], (TextView) bindings[27], (TextView) bindings[25], (TextView) bindings[5], (TextView) bindings[17], (TextView) bindings[15], (TextView) bindings[8], (TextView) bindings[28], (TextView) bindings[26], (TextView) bindings[6], (TextView) bindings[18], (TextView) bindings[16], (TextView) bindings[30], (TextView) bindings[23], (TextView) bindings[3], (TextView) bindings[13], (TextView) bindings[11], (TextView) bindings[21], (TextView) bindings[9], (TextView) bindings[19]);
        this.mDirtyFlags = -1L;
        NestedScrollView nestedScrollView = (NestedScrollView) bindings[0];
        this.mboundView0 = nestedScrollView;
        nestedScrollView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
