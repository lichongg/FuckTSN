package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.R;
import com.bxkj.student.v2.ui.face.FaceCollectConfirmActivity;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class V3FaceCollectConfirmBinding extends ViewDataBinding {

    @NonNull
    public final ImageView ivFace;

    @NonNull
    public final V3PubTitleBinding layoutTitle;

    @Bindable
    protected FaceCollectConfirmActivity mActivity;

    @NonNull
    public final TextView tvInfo;

    @NonNull
    public final TextView tvInfoTitle;

    public static V3FaceCollectConfirmBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V3FaceCollectConfirmBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public abstract void setActivity(@Nullable FaceCollectConfirmActivity activity);

    @Deprecated
    public static V3FaceCollectConfirmBinding bind(@NonNull View view, @Nullable Object component) {
        return (V3FaceCollectConfirmBinding) ViewDataBinding.bind(component, view, R.layout.v3_face_collect_confirm);
    }

    @NonNull
    @Deprecated
    public static V3FaceCollectConfirmBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V3FaceCollectConfirmBinding) ViewDataBinding.inflateInternal(inflater, R.layout.v3_face_collect_confirm, root, attachToRoot, component);
    }

    @Nullable
    public FaceCollectConfirmActivity getActivity() {
        return this.mActivity;
    }

    protected V3FaceCollectConfirmBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivFace, V3PubTitleBinding layoutTitle, TextView tvInfo, TextView tvInfoTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.ivFace = ivFace;
        this.layoutTitle = layoutTitle;
        this.tvInfo = tvInfo;
        this.tvInfoTitle = tvInfoTitle;
    }

    @NonNull
    public static V3FaceCollectConfirmBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V3FaceCollectConfirmBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V3FaceCollectConfirmBinding) ViewDataBinding.inflateInternal(inflater, R.layout.v3_face_collect_confirm, null, false, component);
    }
}
