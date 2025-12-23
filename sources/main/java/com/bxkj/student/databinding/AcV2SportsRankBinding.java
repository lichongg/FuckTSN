package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.base.databinding.NewPubTitleBinding;
import com.bxkj.base.v2.common.view.b;
import com.bxkj.student.R;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class AcV2SportsRankBinding extends ViewDataBinding {

    @Bindable
    protected Map<String, Object> mDataMap;

    @Bindable
    protected b mMActvity;

    @NonNull
    public final NewPubTitleBinding titleLayout;

    @NonNull
    public final TextView tvRunClassRank;

    @NonNull
    public final TextView tvRunDepartmentRank;

    @NonNull
    public final TextView tvRunMajorRank;

    @NonNull
    public final TextView tvRunSchoolRank;

    public static AcV2SportsRankBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static AcV2SportsRankBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public abstract void setDataMap(@Nullable Map<String, Object> dataMap);

    public abstract void setMActvity(@Nullable b mActvity);

    @Deprecated
    public static AcV2SportsRankBinding bind(@NonNull View view, @Nullable Object component) {
        return (AcV2SportsRankBinding) ViewDataBinding.bind(component, view, R.layout.ac_v2_sports_rank);
    }

    @NonNull
    @Deprecated
    public static AcV2SportsRankBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (AcV2SportsRankBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ac_v2_sports_rank, root, attachToRoot, component);
    }

    @Nullable
    public Map<String, Object> getDataMap() {
        return this.mDataMap;
    }

    @Nullable
    public b getMActvity() {
        return this.mMActvity;
    }

    protected AcV2SportsRankBinding(Object _bindingComponent, View _root, int _localFieldCount, NewPubTitleBinding titleLayout, TextView tvRunClassRank, TextView tvRunDepartmentRank, TextView tvRunMajorRank, TextView tvRunSchoolRank) {
        super(_bindingComponent, _root, _localFieldCount);
        this.titleLayout = titleLayout;
        this.tvRunClassRank = tvRunClassRank;
        this.tvRunDepartmentRank = tvRunDepartmentRank;
        this.tvRunMajorRank = tvRunMajorRank;
        this.tvRunSchoolRank = tvRunSchoolRank;
    }

    @NonNull
    public static AcV2SportsRankBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcV2SportsRankBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (AcV2SportsRankBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ac_v2_sports_rank, null, false, component);
    }
}
