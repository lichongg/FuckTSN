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
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.base.v2.common.utils.h;
import com.bxkj.student.R;
import com.bxkj.student.generated.callback.a;
import com.bxkj.student.v2.ui.sports.v3.detail.V3RecordDetailActivity;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class V3LayoutSportDetailDataCommonBindingImpl extends V3LayoutSportDetailDataCommonBinding implements a.InterfaceC0207a {

    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;

    @Nullable
    private static final SparseIntArray sViewsWithIds;

    @Nullable
    private final View.OnClickListener mCallback73;

    @Nullable
    private final View.OnClickListener mCallback74;
    private long mDirtyFlags;

    @NonNull
    private final ConstraintLayout mboundView0;

    public V3LayoutSportDetailDataCommonBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 52, sIncludes, sViewsWithIds));
    }

    @Override // com.bxkj.student.generated.callback.a.InterfaceC0207a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        V3RecordDetailActivity v3RecordDetailActivity;
        if (sourceId != 1) {
            if (sourceId == 2 && (v3RecordDetailActivity = this.mMActivity) != null) {
                v3RecordDetailActivity.T();
                return;
            }
            return;
        }
        V3RecordDetailActivity v3RecordDetailActivity2 = this.mMActivity;
        if (v3RecordDetailActivity2 != null) {
            v3RecordDetailActivity2.T();
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

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.v_left, 15);
        sparseIntArray.put(R.id.v_right, 16);
        sparseIntArray.put(R.id.iv_distance, 17);
        sparseIntArray.put(R.id.tv_distance_hint, 18);
        sparseIntArray.put(R.id.tv_distance_unit, 19);
        sparseIntArray.put(R.id.iv_time, 20);
        sparseIntArray.put(R.id.tv_time_hint, 21);
        sparseIntArray.put(R.id.iv_step_count, 22);
        sparseIntArray.put(R.id.tv_step_count_hint, 23);
        sparseIntArray.put(R.id.tv_step_count_unit, 24);
        sparseIntArray.put(R.id.iv_step_distance, 25);
        sparseIntArray.put(R.id.tv_step_distance_hint, 26);
        sparseIntArray.put(R.id.tv_step_distance_unit, 27);
        sparseIntArray.put(R.id.iv_step, 28);
        sparseIntArray.put(R.id.tv_step_hint, 29);
        sparseIntArray.put(R.id.tv_step_unit, 30);
        sparseIntArray.put(R.id.iv_heart, 31);
        sparseIntArray.put(R.id.tv_heart_hint, 32);
        sparseIntArray.put(R.id.tv_heart_unit, 33);
        sparseIntArray.put(R.id.iv_hot, 34);
        sparseIntArray.put(R.id.tv_hot_hint, 35);
        sparseIntArray.put(R.id.tv_hot_unit, 36);
        sparseIntArray.put(R.id.iv_pjpl, 37);
        sparseIntArray.put(R.id.tv_pjpl_hint, 38);
        sparseIntArray.put(R.id.tv_pjpl_unit, 39);
        sparseIntArray.put(R.id.iv_zjps, 40);
        sparseIntArray.put(R.id.tv_zjps_hint, 41);
        sparseIntArray.put(R.id.tv_zjps_unit, 42);
        sparseIntArray.put(R.id.iv_pjsd, 43);
        sparseIntArray.put(R.id.tv_pjsd_hint, 44);
        sparseIntArray.put(R.id.tv_pjsd_unit, 45);
        sparseIntArray.put(R.id.iv_fast_speed, 46);
        sparseIntArray.put(R.id.tv_fast_speed_hint, 47);
        sparseIntArray.put(R.id.tv_fast_speed_unit, 48);
        sparseIntArray.put(R.id.iv_slow_speed, 49);
        sparseIntArray.put(R.id.tv_slow_speed_hint, 50);
        sparseIntArray.put(R.id.tv_slow_speed_unit, 51);
    }

    private V3LayoutSportDetailDataCommonBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[17], (ImageView) bindings[46], (ImageView) bindings[31], (ImageView) bindings[34], (ImageView) bindings[37], (ImageView) bindings[43], (ImageView) bindings[49], (ImageView) bindings[28], (ImageView) bindings[22], (ImageView) bindings[25], (ImageView) bindings[20], (ImageView) bindings[40], (TextView) bindings[4], (TextView) bindings[1], (TextView) bindings[18], (TextView) bindings[19], (TextView) bindings[13], (TextView) bindings[47], (TextView) bindings[48], (TextView) bindings[8], (TextView) bindings[32], (TextView) bindings[33], (TextView) bindings[12], (TextView) bindings[35], (TextView) bindings[36], (TextView) bindings[10], (TextView) bindings[38], (TextView) bindings[39], (TextView) bindings[9], (TextView) bindings[44], (TextView) bindings[45], (TextView) bindings[14], (TextView) bindings[50], (TextView) bindings[51], (TextView) bindings[7], (TextView) bindings[3], (TextView) bindings[23], (TextView) bindings[24], (TextView) bindings[5], (TextView) bindings[26], (TextView) bindings[27], (TextView) bindings[6], (TextView) bindings[29], (TextView) bindings[30], (TextView) bindings[2], (TextView) bindings[21], (TextView) bindings[11], (TextView) bindings[41], (TextView) bindings[42], (View) bindings[15], (View) bindings[16]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.tvBfException.setTag(null);
        this.tvDistance.setTag(null);
        this.tvFastSpeed.setTag(null);
        this.tvHeart.setTag(null);
        this.tvHot.setTag(null);
        this.tvPjpl.setTag(null);
        this.tvPjsd.setTag(null);
        this.tvSlowSpeed.setTag(null);
        this.tvStep.setTag(null);
        this.tvStepCount.setTag(null);
        this.tvStepDistance.setTag(null);
        this.tvStepException.setTag(null);
        this.tvTime.setTag(null);
        this.tvZjps.setTag(null);
        setRootTag(root);
        this.mCallback74 = new a(this, 2);
        this.mCallback73 = new a(this, 1);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j6;
        long j7;
        long j8;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        synchronized (this) {
            j6 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Map<String, ? extends Object> map = this.mMap;
        long j9 = 5 & j6;
        if (j9 != 0) {
            c0 c0Var = c0.f16887a;
            double f6 = c0Var.f(map, "app_format_sportRange");
            String t5 = c0Var.t(map, "app_format_sportTime");
            str8 = c0Var.t(map, "bestPaceKm");
            str9 = c0Var.t(map, "stepDistance");
            str10 = c0Var.t(map, "slowSpeed");
            str11 = c0Var.t(map, "rate");
            str12 = c0Var.t(map, "heartRate");
            j8 = 0;
            str5 = c0Var.t(map, "stepMinute");
            str6 = c0Var.t(map, "calorie");
            j7 = j6;
            String t6 = c0Var.t(map, "app_format_avgspeed");
            String t7 = c0Var.t(map, "fastSpeed");
            str2 = c0Var.u(map, "stepCount", "0");
            str3 = h.f16899a.a(f6);
            str7 = t5;
            str = t6;
            str4 = t7;
        } else {
            j7 = j6;
            j8 = 0;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            str8 = null;
            str9 = null;
            str10 = null;
            str11 = null;
            str12 = null;
        }
        if ((j7 & 4) != j8) {
            this.tvBfException.setOnClickListener(this.mCallback73);
            this.tvStepException.setOnClickListener(this.mCallback74);
        }
        if (j9 != 0) {
            TextViewBindingAdapter.setText(this.tvDistance, str3);
            TextViewBindingAdapter.setText(this.tvFastSpeed, str4);
            TextViewBindingAdapter.setText(this.tvHeart, str12);
            TextViewBindingAdapter.setText(this.tvHot, str6);
            TextViewBindingAdapter.setText(this.tvPjpl, str11);
            TextViewBindingAdapter.setText(this.tvPjsd, str);
            TextViewBindingAdapter.setText(this.tvSlowSpeed, str10);
            TextViewBindingAdapter.setText(this.tvStep, str5);
            TextViewBindingAdapter.setText(this.tvStepCount, str2);
            TextViewBindingAdapter.setText(this.tvStepDistance, str9);
            TextViewBindingAdapter.setText(this.tvTime, str7);
            TextViewBindingAdapter.setText(this.tvZjps, str8);
        }
    }

    @Override // com.bxkj.student.databinding.V3LayoutSportDetailDataCommonBinding
    public void setMActivity(@Nullable V3RecordDetailActivity MActivity) {
        this.mMActivity = MActivity;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(17);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.V3LayoutSportDetailDataCommonBinding
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
}
