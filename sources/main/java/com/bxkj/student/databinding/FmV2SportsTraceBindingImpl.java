package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import cn.bluemobi.dylan.http.JsonParse;
import com.amap.api.maps.TextureMapView;
import com.bxkj.student.R;
import com.bxkj.student.run.app.utils.RecordPathView;
import com.bxkj.student.run.app.utils.SportTrailView;
import com.bxkj.student.run.app.utils.i;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class FmV2SportsTraceBindingImpl extends FmV2SportsTraceBinding {

    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;

    @Nullable
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    public FmV2SportsTraceBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
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

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.map, 5);
        sparseIntArray.put(R.id.rpv, 6);
        sparseIntArray.put(R.id.stv, 7);
        sparseIntArray.put(2131298015, 8);
        sparseIntArray.put(2131299113, 9);
        sparseIntArray.put(R.id.tv_account, 10);
        sparseIntArray.put(R.id.tv_school_name, 11);
        sparseIntArray.put(2131298986, 12);
        sparseIntArray.put(R.id.bt_track, 13);
    }

    private FmV2SportsTraceBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (Button) bindings[13], (LinearLayout) bindings[8], (LinearLayout) bindings[0], (TextureMapView) bindings[5], (RecordPathView) bindings[6], (SportTrailView) bindings[7], (TextView) bindings[10], (TextView) bindings[4], (TextView) bindings[12], (TextView) bindings[3], (TextView) bindings[11], (TextView) bindings[1], (TextView) bindings[9], (TextView) bindings[2]);
        this.mDirtyFlags = -1L;
        this.llRoot.setTag(null);
        this.tvDistance.setTag(null);
        this.tvPeisu.setTag(null);
        this.tvSpeed.setTag(null);
        this.tvTime.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j6;
        Object obj;
        String str;
        Object obj2;
        Object obj3;
        synchronized (this) {
            j6 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Map<String, Object> map = this.mDataMap;
        long j7 = j6 & 3;
        Object obj4 = null;
        if (j7 != 0) {
            boolean z5 = map == null;
            long j8 = JsonParse.getLong(map, "sportTime", 0L);
            if (j7 != 0) {
                j6 |= z5 ? 8L : 4L;
            }
            if (map != null) {
                obj4 = map.get("avgspeed");
                obj2 = map.get("speed");
                obj3 = map.get("sportRange");
            } else {
                obj3 = null;
                obj2 = null;
            }
            r10 = z5 ? 8 : 0;
            str = i.g(j8);
            Object obj5 = obj4;
            obj4 = obj3;
            obj = obj5;
        } else {
            obj = null;
            str = null;
            obj2 = null;
        }
        if ((j6 & 3) != 0) {
            this.llRoot.setVisibility(r10);
            TextViewBindingAdapter.setText(this.tvDistance, (CharSequence) obj4);
            TextViewBindingAdapter.setText(this.tvPeisu, (CharSequence) obj2);
            TextViewBindingAdapter.setText(this.tvSpeed, (CharSequence) obj);
            TextViewBindingAdapter.setText(this.tvTime, str);
        }
    }

    @Override // com.bxkj.student.databinding.FmV2SportsTraceBinding
    public void setDataMap(@Nullable Map<String, Object> DataMap) {
        this.mDataMap = DataMap;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (8 != variableId) {
            return false;
        }
        setDataMap((Map) variable);
        return true;
    }
}
