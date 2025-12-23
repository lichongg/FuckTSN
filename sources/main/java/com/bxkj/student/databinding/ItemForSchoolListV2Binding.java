package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class ItemForSchoolListV2Binding extends ViewDataBinding {

    @NonNull
    public final CardView cardView;

    @NonNull
    public final TextView tvName;

    public static ItemForSchoolListV2Binding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemForSchoolListV2Binding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemForSchoolListV2Binding bind(@NonNull View view, @Nullable Object component) {
        return (ItemForSchoolListV2Binding) ViewDataBinding.bind(component, view, R.layout.item_for_school_list_v2);
    }

    @NonNull
    @Deprecated
    public static ItemForSchoolListV2Binding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (ItemForSchoolListV2Binding) ViewDataBinding.inflateInternal(inflater, R.layout.item_for_school_list_v2, root, attachToRoot, component);
    }

    protected ItemForSchoolListV2Binding(Object _bindingComponent, View _root, int _localFieldCount, CardView cardView, TextView tvName) {
        super(_bindingComponent, _root, _localFieldCount);
        this.cardView = cardView;
        this.tvName = tvName;
    }

    @NonNull
    public static ItemForSchoolListV2Binding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemForSchoolListV2Binding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (ItemForSchoolListV2Binding) ViewDataBinding.inflateInternal(inflater, R.layout.item_for_school_list_v2, null, false, component);
    }
}
