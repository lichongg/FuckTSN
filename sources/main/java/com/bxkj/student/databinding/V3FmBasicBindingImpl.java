package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.bxkj.student.R;
import com.bxkj.student.generated.callback.a;
import com.bxkj.student.v2.common.view.TrackProgressView;
import com.bxkj.student.v2.ui.sports.v3.detail.V3RecordDetailActivity;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class V3FmBasicBindingImpl extends V3FmBasicBinding implements a.InterfaceC0207a {

    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes;

    @Nullable
    private static final SparseIntArray sViewsWithIds;

    @Nullable
    private final View.OnClickListener mCallback71;
    private long mDirtyFlags;

    @NonNull
    private final NestedScrollView mboundView0;

    @NonNull
    private final ConstraintLayout mboundView1;

    @Nullable
    private final V3LayoutSportDetailDataCommonBinding mboundView11;

    @NonNull
    private final ImageView mboundView2;

    public V3FmBasicBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 33, sIncludes, sViewsWithIds));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j6;
        synchronized (this) {
            j6 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        V3RecordDetailActivity v3RecordDetailActivity = this.mMActivity;
        Map<String, Object> map = this.mMap;
        long j7 = 6 & j6;
        if ((5 & j6) != 0) {
            this.mboundView11.setMActivity(v3RecordDetailActivity);
        }
        if (j7 != 0) {
            this.mboundView11.setMap(map);
        }
        if ((j6 & 4) != 0) {
            this.mboundView2.setOnClickListener(this.mCallback71);
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
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(33);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"v3_layout_sport_detail_data_common"}, new int[]{3}, new int[]{R.layout.v3_layout_sport_detail_data_common});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.cl_root, 4);
        sparseIntArray.put(R.id.card_user, 5);
        sparseIntArray.put(2131298083, 6);
        sparseIntArray.put(2131297148, 7);
        sparseIntArray.put(2131298986, 8);
        sparseIntArray.put(R.id.tv_account, 9);
        sparseIntArray.put(R.id.card1, 10);
        sparseIntArray.put(R.id.tp_step, 11);
        sparseIntArray.put(R.id.tp_time, 12);
        sparseIntArray.put(R.id.tp_distance, 13);
        sparseIntArray.put(R.id.tv_current_step, 14);
        sparseIntArray.put(R.id.tv_current_time, 15);
        sparseIntArray.put(R.id.tv_current_distance, 16);
        sparseIntArray.put(R.id.tv1, 17);
        sparseIntArray.put(R.id.card2, 18);
        sparseIntArray.put(R.id.tv_rank_hint, 19);
        sparseIntArray.put(R.id.card_rank_line, 20);
        sparseIntArray.put(R.id.tv_result_hint, 21);
        sparseIntArray.put(2131299062, 22);
        sparseIntArray.put(R.id.tv_rank_unit, 23);
        sparseIntArray.put(R.id.tv_result, 24);
        sparseIntArray.put(R.id.card3, 25);
        sparseIntArray.put(R.id.tv_cj_hint, 26);
        sparseIntArray.put(R.id.card_cj_line, 27);
        sparseIntArray.put(R.id.tv_cj, 28);
        sparseIntArray.put(R.id.iv_jb1, 29);
        sparseIntArray.put(R.id.iv_jb2, 30);
        sparseIntArray.put(R.id.iv_jb3, 31);
        sparseIntArray.put(2131298030, 32);
    }

    private V3FmBasicBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (MaterialCardView) bindings[10], (MaterialCardView) bindings[18], (MaterialCardView) bindings[25], (MaterialCardView) bindings[27], (MaterialCardView) bindings[20], (MaterialCardView) bindings[5], (ConstraintLayout) bindings[4], (ShapeableImageView) bindings[7], (ImageView) bindings[29], (ImageView) bindings[30], (ImageView) bindings[31], (LinearLayout) bindings[32], (LinearLayout) bindings[6], (TrackProgressView) bindings[13], (TrackProgressView) bindings[11], (TrackProgressView) bindings[12], (TextView) bindings[17], (TextView) bindings[9], (TextView) bindings[28], (TextView) bindings[26], (TextView) bindings[16], (TextView) bindings[14], (TextView) bindings[15], (TextView) bindings[8], (TextView) bindings[22], (TextView) bindings[19], (TextView) bindings[23], (TextView) bindings[24], (TextView) bindings[21]);
        this.mDirtyFlags = -1L;
        NestedScrollView nestedScrollView = (NestedScrollView) bindings[0];
        this.mboundView0 = nestedScrollView;
        nestedScrollView.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[1];
        this.mboundView1 = constraintLayout;
        constraintLayout.setTag(null);
        V3LayoutSportDetailDataCommonBinding v3LayoutSportDetailDataCommonBinding = (V3LayoutSportDetailDataCommonBinding) bindings[3];
        this.mboundView11 = v3LayoutSportDetailDataCommonBinding;
        setContainedBinding(v3LayoutSportDetailDataCommonBinding);
        ImageView imageView = (ImageView) bindings[2];
        this.mboundView2 = imageView;
        imageView.setTag(null);
        setRootTag(root);
        this.mCallback71 = new a(this, 1);
        invalidateAll();
    }

    @Override // com.bxkj.student.generated.callback.a.InterfaceC0207a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        V3RecordDetailActivity v3RecordDetailActivity = this.mMActivity;
        if (v3RecordDetailActivity != null) {
            v3RecordDetailActivity.U();
        }
    }

    @Override // com.bxkj.student.databinding.V3FmBasicBinding
    public void setMActivity(@Nullable V3RecordDetailActivity MActivity) {
        this.mMActivity = MActivity;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(17);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.V3FmBasicBinding
    public void setMap(@Nullable Map<String, Object> Map) {
        this.mMap = Map;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(20);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (17 == variableId) {
            setMActivity((V3RecordDetailActivity) variable);
            return true;
        }
        if (20 != variableId) {
            return false;
        }
        setMap((Map) variable);
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.mboundView11.setLifecycleOwner(lifecycleOwner);
    }
}
