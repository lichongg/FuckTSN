package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.R;
import com.bxkj.student.v2.common.view.CustomBarChart;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class FmV2SportsStatisticsBinding extends ViewDataBinding {

    @NonNull
    public final CustomBarChart barChart;

    public static FmV2SportsStatisticsBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FmV2SportsStatisticsBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FmV2SportsStatisticsBinding bind(@NonNull View view, @Nullable Object component) {
        return (FmV2SportsStatisticsBinding) ViewDataBinding.bind(component, view, R.layout.fm_v2_sports_statistics);
    }

    @NonNull
    @Deprecated
    public static FmV2SportsStatisticsBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (FmV2SportsStatisticsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fm_v2_sports_statistics, root, attachToRoot, component);
    }

    protected FmV2SportsStatisticsBinding(Object _bindingComponent, View _root, int _localFieldCount, CustomBarChart barChart) {
        super(_bindingComponent, _root, _localFieldCount);
        this.barChart = barChart;
    }

    @NonNull
    public static FmV2SportsStatisticsBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FmV2SportsStatisticsBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (FmV2SportsStatisticsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fm_v2_sports_statistics, null, false, component);
    }
}
