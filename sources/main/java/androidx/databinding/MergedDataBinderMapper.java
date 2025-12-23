package androidx.databinding;

import android.view.View;
import androidx.annotation.RestrictTo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\Downloads\app\classes.dex */
public class MergedDataBinderMapper extends DataBinderMapper {
    private static final String TAG = "MergedDataBinderMapper";
    private Set<Class<? extends DataBinderMapper>> mExistingMappers = new HashSet();
    private List<DataBinderMapper> mMappers = new CopyOnWriteArrayList();
    private List<String> mFeatureBindingMappers = new CopyOnWriteArrayList();

    /* JADX WARN: Multi-variable type inference failed */
    public void addMapper(DataBinderMapper dataBinderMapper) {
        if (this.mExistingMappers.add(dataBinderMapper.getClass())) {
            this.mMappers.add(dataBinderMapper);
            Iterator<DataBinderMapper> it = dataBinderMapper.collectDependencies().iterator();
            while (it.hasNext()) {
                addMapper(it.next());
            }
        }
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i6) {
        Iterator<DataBinderMapper> it = this.mMappers.iterator();
        while (it.hasNext()) {
            ViewDataBinding dataBinder = it.next().getDataBinder(dataBindingComponent, view, i6);
            if (dataBinder != null) {
                return dataBinder;
            }
        }
        if (loadFeatures()) {
            return getDataBinder(dataBindingComponent, view, i6);
        }
        return null;
    }

    private boolean loadFeatures() {
        boolean z5 = false;
        for (String str : this.mFeatureBindingMappers) {
            try {
                Class<?> cls = Class.forName(str);
                if (DataBinderMapper.class.isAssignableFrom(cls)) {
                    addMapper((DataBinderMapper) cls.newInstance());
                    this.mFeatureBindingMappers.remove(str);
                    z5 = true;
                }
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
            }
        }
        return z5;
    }

    @Override // androidx.databinding.DataBinderMapper
    public String convertBrIdToString(int i6) {
        Iterator<DataBinderMapper> it = this.mMappers.iterator();
        while (it.hasNext()) {
            String convertBrIdToString = it.next().convertBrIdToString(i6);
            if (convertBrIdToString != null) {
                return convertBrIdToString;
            }
        }
        if (loadFeatures()) {
            return convertBrIdToString(i6);
        }
        return null;
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(String str) {
        Iterator<DataBinderMapper> it = this.mMappers.iterator();
        while (it.hasNext()) {
            int layoutId = it.next().getLayoutId(str);
            if (layoutId != 0) {
                return layoutId;
            }
        }
        if (loadFeatures()) {
            return getLayoutId(str);
        }
        return 0;
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i6) {
        Iterator<DataBinderMapper> it = this.mMappers.iterator();
        while (it.hasNext()) {
            ViewDataBinding dataBinder = it.next().getDataBinder(dataBindingComponent, viewArr, i6);
            if (dataBinder != null) {
                return dataBinder;
            }
        }
        if (loadFeatures()) {
            return getDataBinder(dataBindingComponent, viewArr, i6);
        }
        return null;
    }

    protected void addMapper(String str) {
        this.mFeatureBindingMappers.add(str + ".DataBinderMapperImpl");
    }
}
