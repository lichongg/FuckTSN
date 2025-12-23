package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.databinding.NewPubTitleBinding;
import com.bxkj.student.R;
import com.bxkj.student.v2.ui.sports.set.SportsDescriptionActivity;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class AcV2SportsDescriptionBinding extends ViewDataBinding {

    @NonNull
    public final Button btStart;

    @NonNull
    public final CheckBox cbIgnore;

    @Bindable
    protected SportsDescriptionActivity mMActivity;

    @Bindable
    protected Boolean mShowBottom;

    @Bindable
    protected Boolean mStartButtonEnable;

    @NonNull
    public final SmartWebView swv;

    @NonNull
    public final NewPubTitleBinding titleLayout;

    public static AcV2SportsDescriptionBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static AcV2SportsDescriptionBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public abstract void setMActivity(@Nullable SportsDescriptionActivity mActivity);

    public abstract void setShowBottom(@Nullable Boolean showBottom);

    public abstract void setStartButtonEnable(@Nullable Boolean startButtonEnable);

    @Deprecated
    public static AcV2SportsDescriptionBinding bind(@NonNull View view, @Nullable Object component) {
        return (AcV2SportsDescriptionBinding) ViewDataBinding.bind(component, view, R.layout.ac_v2_sports_description);
    }

    @NonNull
    @Deprecated
    public static AcV2SportsDescriptionBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (AcV2SportsDescriptionBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ac_v2_sports_description, root, attachToRoot, component);
    }

    @Nullable
    public SportsDescriptionActivity getMActivity() {
        return this.mMActivity;
    }

    @Nullable
    public Boolean getShowBottom() {
        return this.mShowBottom;
    }

    @Nullable
    public Boolean getStartButtonEnable() {
        return this.mStartButtonEnable;
    }

    protected AcV2SportsDescriptionBinding(Object _bindingComponent, View _root, int _localFieldCount, Button btStart, CheckBox cbIgnore, SmartWebView swv, NewPubTitleBinding titleLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btStart = btStart;
        this.cbIgnore = cbIgnore;
        this.swv = swv;
        this.titleLayout = titleLayout;
    }

    @NonNull
    public static AcV2SportsDescriptionBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcV2SportsDescriptionBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (AcV2SportsDescriptionBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ac_v2_sports_description, null, false, component);
    }
}
