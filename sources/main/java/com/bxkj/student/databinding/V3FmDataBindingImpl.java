package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.bxkj.student.R;
import com.bxkj.student.v2.ui.sports.v3.detail.V3RecordDetailActivity;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class V3FmDataBindingImpl extends V3FmDataBinding {

    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes;

    @Nullable
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    @NonNull
    private final NestedScrollView mboundView0;

    @NonNull
    private final ConstraintLayout mboundView1;

    @Nullable
    private final V3LayoutSportDetailDataCommonBinding mboundView11;

    public V3FmDataBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 48, sIncludes, sViewsWithIds));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j6;
        synchronized (this) {
            j6 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Map<String, Object> map = this.mMap;
        V3RecordDetailActivity v3RecordDetailActivity = this.mMActivity;
        long j7 = 5 & j6;
        long j8 = j6 & 6;
        if (j7 != 0) {
            this.mboundView11.setMap(map);
        }
        if (j8 != 0) {
            this.mboundView11.setMActivity(v3RecordDetailActivity);
        }
        ViewDataBinding.executeBindingsOn(this.mboundView11);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                return this.mboundView11.hasPendingBindings();
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
        this.mboundView11.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(48);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"v3_layout_sport_detail_data_common"}, new int[]{2}, new int[]{R.layout.v3_layout_sport_detail_data_common});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.cl_root, 3);
        sparseIntArray.put(R.id.card1, 4);
        sparseIntArray.put(R.id.tv1, 5);
        sparseIntArray.put(R.id.tv2, 6);
        sparseIntArray.put(R.id.card_user, 7);
        sparseIntArray.put(2131298083, 8);
        sparseIntArray.put(2131297148, 9);
        sparseIntArray.put(2131298986, 10);
        sparseIntArray.put(R.id.tv_account, 11);
        sparseIntArray.put(R.id.card_total_tagrt, 12);
        sparseIntArray.put(R.id.tv_zdbsj, 13);
        sparseIntArray.put(R.id.iv_yxlc, 14);
        sparseIntArray.put(R.id.tv_yxlc_hint, 15);
        sparseIntArray.put(R.id.tv_yxlc, 16);
        sparseIntArray.put(R.id.tv_yxlc_unit, 17);
        sparseIntArray.put(R.id.iv_dblc, 18);
        sparseIntArray.put(R.id.tv_dblc_hint, 19);
        sparseIntArray.put(R.id.tv_dblc, 20);
        sparseIntArray.put(R.id.tv_dblc_unit, 21);
        sparseIntArray.put(R.id.iv_sylc, 22);
        sparseIntArray.put(R.id.tv_sylc_hint, 23);
        sparseIntArray.put(R.id.tv_sylc, 24);
        sparseIntArray.put(R.id.tv_sylc_unit, 25);
        sparseIntArray.put(R.id.pb_distance, 26);
        sparseIntArray.put(R.id.iv_yxxs, 27);
        sparseIntArray.put(R.id.tv_yxcs_hint, 28);
        sparseIntArray.put(R.id.tv_yxcs, 29);
        sparseIntArray.put(R.id.tv_yxcs_unit, 30);
        sparseIntArray.put(R.id.iv_dbcs, 31);
        sparseIntArray.put(R.id.tv_dbcs_hint, 32);
        sparseIntArray.put(R.id.tv_dbcs, 33);
        sparseIntArray.put(R.id.tv_dbcs_unit, 34);
        sparseIntArray.put(R.id.iv_sycl, 35);
        sparseIntArray.put(R.id.tv_sycs_hint, 36);
        sparseIntArray.put(R.id.tv_sycs, 37);
        sparseIntArray.put(R.id.tv_sycs_unit, 38);
        sparseIntArray.put(R.id.pb_count, 39);
        sparseIntArray.put(R.id.iv_ljsc, 40);
        sparseIntArray.put(R.id.tv_lssc_hint, 41);
        sparseIntArray.put(R.id.tv_ljsc, 42);
        sparseIntArray.put(R.id.tv_ljsc_unit, 43);
        sparseIntArray.put(R.id.iv_pbts, 44);
        sparseIntArray.put(R.id.tv_pbts_hint, 45);
        sparseIntArray.put(R.id.tv_pbts, 46);
        sparseIntArray.put(R.id.tv_pbts_unit, 47);
    }

    private V3FmDataBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (MaterialCardView) bindings[4], (MaterialCardView) bindings[12], (MaterialCardView) bindings[7], (ConstraintLayout) bindings[3], (ImageView) bindings[31], (ImageView) bindings[18], (ShapeableImageView) bindings[9], (ImageView) bindings[40], (ImageView) bindings[44], (ImageView) bindings[35], (ImageView) bindings[22], (ImageView) bindings[14], (ImageView) bindings[27], (LinearLayout) bindings[8], (ProgressBar) bindings[39], (ProgressBar) bindings[26], (TextView) bindings[5], (TextView) bindings[6], (TextView) bindings[11], (TextView) bindings[33], (TextView) bindings[32], (TextView) bindings[34], (TextView) bindings[20], (TextView) bindings[19], (TextView) bindings[21], (TextView) bindings[42], (TextView) bindings[43], (TextView) bindings[41], (TextView) bindings[10], (TextView) bindings[46], (TextView) bindings[45], (TextView) bindings[47], (TextView) bindings[37], (TextView) bindings[36], (TextView) bindings[38], (TextView) bindings[24], (TextView) bindings[23], (TextView) bindings[25], (TextView) bindings[29], (TextView) bindings[28], (TextView) bindings[30], (TextView) bindings[16], (TextView) bindings[15], (TextView) bindings[17], (TextView) bindings[13]);
        this.mDirtyFlags = -1L;
        NestedScrollView nestedScrollView = (NestedScrollView) bindings[0];
        this.mboundView0 = nestedScrollView;
        nestedScrollView.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[1];
        this.mboundView1 = constraintLayout;
        constraintLayout.setTag(null);
        V3LayoutSportDetailDataCommonBinding v3LayoutSportDetailDataCommonBinding = (V3LayoutSportDetailDataCommonBinding) bindings[2];
        this.mboundView11 = v3LayoutSportDetailDataCommonBinding;
        setContainedBinding(v3LayoutSportDetailDataCommonBinding);
        setRootTag(root);
        invalidateAll();
    }

    @Override // com.bxkj.student.databinding.V3FmDataBinding
    public void setMActivity(@Nullable V3RecordDetailActivity MActivity) {
        this.mMActivity = MActivity;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(17);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.V3FmDataBinding
    public void setMap(@Nullable Map<String, Object> Map) {
        this.mMap = Map;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(20);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (20 == variableId) {
            setMap((Map) variable);
            return true;
        }
        if (17 != variableId) {
            return false;
        }
        setMActivity((V3RecordDetailActivity) variable);
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.mboundView11.setLifecycleOwner(lifecycleOwner);
    }
}
