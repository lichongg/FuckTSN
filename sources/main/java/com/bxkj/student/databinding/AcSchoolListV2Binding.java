package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.base.v2.common.view.EmptyRecyclerView;
import com.bxkj.base.v2.common.view.b;
import com.bxkj.base.view.SearchView;
import com.bxkj.student.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class AcSchoolListV2Binding extends ViewDataBinding {

    @NonNull
    public final View emptyLayout;

    @Bindable
    protected b mActivity;

    @NonNull
    public final EmptyRecyclerView rvSchool;

    @NonNull
    public final SearchView searchView;

    @NonNull
    public final V3PubTitleBinding titleLayout;

    public static AcSchoolListV2Binding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static AcSchoolListV2Binding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public abstract void setActivity(@Nullable b activity);

    @Deprecated
    public static AcSchoolListV2Binding bind(@NonNull View view, @Nullable Object component) {
        return (AcSchoolListV2Binding) ViewDataBinding.bind(component, view, R.layout.ac_school_list_v2);
    }

    @NonNull
    @Deprecated
    public static AcSchoolListV2Binding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (AcSchoolListV2Binding) ViewDataBinding.inflateInternal(inflater, R.layout.ac_school_list_v2, root, attachToRoot, component);
    }

    @Nullable
    public b getActivity() {
        return this.mActivity;
    }

    protected AcSchoolListV2Binding(Object _bindingComponent, View _root, int _localFieldCount, View emptyLayout, EmptyRecyclerView rvSchool, SearchView searchView, V3PubTitleBinding titleLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.emptyLayout = emptyLayout;
        this.rvSchool = rvSchool;
        this.searchView = searchView;
        this.titleLayout = titleLayout;
    }

    @NonNull
    public static AcSchoolListV2Binding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcSchoolListV2Binding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (AcSchoolListV2Binding) ViewDataBinding.inflateInternal(inflater, R.layout.ac_school_list_v2, null, false, component);
    }
}
