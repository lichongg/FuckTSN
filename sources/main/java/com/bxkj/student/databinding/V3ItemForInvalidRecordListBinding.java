package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.R;
import com.bxkj.student.v2.ui.sports.v3.record.tab.V3RecordInValidFragment;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class V3ItemForInvalidRecordListBinding extends ViewDataBinding {

    @NonNull
    public final Button btAppeal;

    @NonNull
    public final Button btFace;

    @NonNull
    public final CardView card;

    @NonNull
    public final ImageView ivArrow;

    @NonNull
    public final ImageView ivQuestion;

    @NonNull
    public final LinearLayout llQuestion;

    @Bindable
    protected V3RecordInValidFragment mMActivity;

    @Bindable
    protected Map<String, Object> mMap;

    @NonNull
    public final TextView status;

    @NonNull
    public final TextView tvDistance;

    @NonNull
    public final TextView tvNo;

    @NonNull
    public final TextView tvStartTime;

    @NonNull
    public final TextView tvStatus;

    @NonNull
    public final TextView tvStepCount;

    @NonNull
    public final TextView tvTimeCount;

    @NonNull
    public final TextView tvUploadType;

    public static V3ItemForInvalidRecordListBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V3ItemForInvalidRecordListBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public abstract void setMActivity(@Nullable V3RecordInValidFragment mActivity);

    public abstract void setMap(@Nullable Map<String, Object> map);

    @Deprecated
    public static V3ItemForInvalidRecordListBinding bind(@NonNull View view, @Nullable Object component) {
        return (V3ItemForInvalidRecordListBinding) ViewDataBinding.bind(component, view, R.layout.v3_item_for_invalid_record_list);
    }

    @NonNull
    @Deprecated
    public static V3ItemForInvalidRecordListBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V3ItemForInvalidRecordListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.v3_item_for_invalid_record_list, root, attachToRoot, component);
    }

    @Nullable
    public V3RecordInValidFragment getMActivity() {
        return this.mMActivity;
    }

    @Nullable
    public Map<String, Object> getMap() {
        return this.mMap;
    }

    protected V3ItemForInvalidRecordListBinding(Object _bindingComponent, View _root, int _localFieldCount, Button btAppeal, Button btFace, CardView card, ImageView ivArrow, ImageView ivQuestion, LinearLayout llQuestion, TextView status, TextView tvDistance, TextView tvNo, TextView tvStartTime, TextView tvStatus, TextView tvStepCount, TextView tvTimeCount, TextView tvUploadType) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btAppeal = btAppeal;
        this.btFace = btFace;
        this.card = card;
        this.ivArrow = ivArrow;
        this.ivQuestion = ivQuestion;
        this.llQuestion = llQuestion;
        this.status = status;
        this.tvDistance = tvDistance;
        this.tvNo = tvNo;
        this.tvStartTime = tvStartTime;
        this.tvStatus = tvStatus;
        this.tvStepCount = tvStepCount;
        this.tvTimeCount = tvTimeCount;
        this.tvUploadType = tvUploadType;
    }

    @NonNull
    public static V3ItemForInvalidRecordListBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V3ItemForInvalidRecordListBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V3ItemForInvalidRecordListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.v3_item_for_invalid_record_list, null, false, component);
    }
}
