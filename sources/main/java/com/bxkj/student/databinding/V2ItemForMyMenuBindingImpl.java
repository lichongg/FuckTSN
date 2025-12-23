package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.bxkj.base.R;
import com.bxkj.base.v2.base.o;
import com.bxkj.base.v2.common.utils.c0;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class V2ItemForMyMenuBindingImpl extends V2ItemForMyMenuBinding {

    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;

    @Nullable
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;

    public V2ItemForMyMenuBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j6;
        Object obj;
        synchronized (this) {
            j6 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Map<String, ? extends Object> map = this.mMap;
        long j7 = j6 & 3;
        String str = null;
        if (j7 != 0) {
            Object obj2 = map != null ? map.get(CommonNetImpl.NAME) : null;
            str = c0.f16887a.t(map, "icon");
            obj = obj2;
        } else {
            obj = null;
        }
        if (j7 != 0) {
            ImageView imageView = this.ivIcon;
            o.g(imageView, str, AppCompatResources.getDrawable(imageView.getContext(), R.drawable.v2_logo), AppCompatResources.getDrawable(this.ivIcon.getContext(), com.bxkj.student.R.drawable.v2_home_menu_more));
            TextViewBindingAdapter.setText(this.tvName, (CharSequence) obj);
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
            this.mDirtyFlags = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    private V2ItemForMyMenuBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ConstraintLayout) bindings[0], (ImageView) bindings[1], (TextView) bindings[2]);
        this.mDirtyFlags = -1L;
        this.clRoot.setTag(null);
        this.ivIcon.setTag(null);
        this.tvName.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // com.bxkj.student.databinding.V2ItemForMyMenuBinding
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
        if (20 != variableId) {
            return false;
        }
        setMap((Map) variable);
        return true;
    }
}
