package xyz.adscope.ad;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import xyz.adscope.ad.model.impl.db.AdvertisingDBModel;
import xyz.adscope.ad.model.impl.db.StrategyEventDBModel;
import xyz.adscope.common.v2.model.IDatabaseModel;
import xyz.adscope.common.v2.persistent.db.IBaseDbHelper;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class h extends IBaseDbHelper {
    @Override // xyz.adscope.common.v2.persistent.db.IBaseDbHelper
    protected List<Class<? extends IDatabaseModel>> acceptTable() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(AdvertisingDBModel.class);
        arrayList.add(StrategyEventDBModel.class);
        return arrayList;
    }

    public h(Context context) {
        super(context);
    }

    @Override // xyz.adscope.common.v2.persistent.db.IBaseDbHelper
    protected String createDBNameWithoutSuffix() {
        return f0.a();
    }
}
