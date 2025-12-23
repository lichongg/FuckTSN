package org.junit.experimental.categories;

import java.util.ArrayList;
import java.util.List;
import org.junit.runner.FilterFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
abstract class a implements FilterFactory {
    protected abstract org.junit.runner.manipulation.a b(List<Class<?>> list);

    private List<Class<?>> c(String str) throws ClassNotFoundException {
        ArrayList arrayList = new ArrayList();
        for (String str2 : str.split(",")) {
            arrayList.add(org.junit.internal.a.a(str2));
        }
        return arrayList;
    }

    a() {
    }

    @Override // org.junit.runner.FilterFactory
    public org.junit.runner.manipulation.a a(org.junit.runner.d dVar) throws FilterFactory.FilterNotCreatedException {
        try {
            return b(c(dVar.a()));
        } catch (ClassNotFoundException e6) {
            throw new FilterFactory.FilterNotCreatedException(e6);
        }
    }
}
