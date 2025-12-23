package xyz.adscope.common;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import xyz.adscope.common.analyse2.db.AnalyseEventDBModel;
import xyz.adscope.common.v2.model.IDatabaseModel;
import xyz.adscope.common.v2.persistent.db.IBaseDbHelper;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class e extends IBaseDbHelper {
    @Override // xyz.adscope.common.v2.persistent.db.IBaseDbHelper
    protected List<Class<? extends IDatabaseModel>> acceptTable() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(AnalyseEventDBModel.class);
        return arrayList;
    }

    @Override // xyz.adscope.common.v2.persistent.db.IBaseDbHelper
    protected String createDBNameWithoutSuffix() {
        return "Analyse";
    }

    public e(Context context) {
        super(context);
    }
}
