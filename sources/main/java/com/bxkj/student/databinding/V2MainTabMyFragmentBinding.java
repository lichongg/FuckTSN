package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.bxkj.base.v2.data.b;
import com.bxkj.student.R;
import com.bxkj.student.v2.ui.main.MyFragment;
import com.google.android.material.button.MaterialButton;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class V2MainTabMyFragmentBinding extends ViewDataBinding {

    @NonNull
    public final MaterialButton btLogout;

    @NonNull
    public final CardView cardHead;

    @NonNull
    public final ImageView ivHead;

    @Bindable
    protected b mLoggedInUser;

    @Bindable
    protected MyFragment mMyFragment;

    @NonNull
    public final NestedScrollView root;

    @NonNull
    public final RecyclerView rvMenu;

    @NonNull
    public final TextView tvName;

    @NonNull
    public final TextView tvSchool;

    @NonNull
    public final TextView tvTitle;

    @NonNull
    public final TextView tvUserNumber;

    public static V2MainTabMyFragmentBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V2MainTabMyFragmentBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public abstract void setLoggedInUser(@Nullable b loggedInUser);

    public abstract void setMyFragment(@Nullable MyFragment myFragment);

    @Deprecated
    public static V2MainTabMyFragmentBinding bind(@NonNull View view, @Nullable Object component) {
        return (V2MainTabMyFragmentBinding) ViewDataBinding.bind(component, view, R.layout.v2_main_tab_my_fragment);
    }

    @NonNull
    @Deprecated
    public static V2MainTabMyFragmentBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V2MainTabMyFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.v2_main_tab_my_fragment, root, attachToRoot, component);
    }

    @Nullable
    public b getLoggedInUser() {
        return this.mLoggedInUser;
    }

    @Nullable
    public MyFragment getMyFragment() {
        return this.mMyFragment;
    }

    protected V2MainTabMyFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, MaterialButton btLogout, CardView cardHead, ImageView ivHead, NestedScrollView root, RecyclerView rvMenu, TextView tvName, TextView tvSchool, TextView tvTitle, TextView tvUserNumber) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btLogout = btLogout;
        this.cardHead = cardHead;
        this.ivHead = ivHead;
        this.root = root;
        this.rvMenu = rvMenu;
        this.tvName = tvName;
        this.tvSchool = tvSchool;
        this.tvTitle = tvTitle;
        this.tvUserNumber = tvUserNumber;
    }

    @NonNull
    public static V2MainTabMyFragmentBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V2MainTabMyFragmentBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V2MainTabMyFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.v2_main_tab_my_fragment, null, false, component);
    }
}
