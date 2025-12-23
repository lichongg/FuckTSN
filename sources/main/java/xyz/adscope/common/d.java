package xyz.adscope.common;

import android.content.Context;
import com.huawei.hms.common.util.Logger;
import java.util.ArrayList;
import java.util.List;
import xyz.adscope.common.analyse.model.impl.HistoryDbModel;
import xyz.adscope.common.v2.model.IDatabaseModel;
import xyz.adscope.common.v2.persistent.db.IBaseDbHelper;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class d extends IBaseDbHelper {
    @Override // xyz.adscope.common.v2.persistent.db.IBaseDbHelper
    protected List<Class<? extends IDatabaseModel>> acceptTable() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(HistoryDbModel.class);
        return arrayList;
    }

    @Override // xyz.adscope.common.v2.persistent.db.IBaseDbHelper
    protected String createDBNameWithoutSuffix() {
        return Logger.f33115b;
    }

    public d(Context context) {
        super(context);
    }
}
