package org.junit.runner;

import com.huawei.hms.framework.common.ContainerUtils;
import org.junit.runner.FilterFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class c {
    static FilterFactory c(Class<? extends FilterFactory> cls) throws FilterFactory.FilterNotCreatedException {
        try {
            return cls.getConstructor(null).newInstance(null);
        } catch (Exception e6) {
            throw new FilterFactory.FilterNotCreatedException(e6);
        }
    }

    c() {
    }

    public static org.junit.runner.manipulation.a a(Class<? extends FilterFactory> cls, d dVar) throws FilterFactory.FilterNotCreatedException {
        return c(cls).a(dVar);
    }

    public static org.junit.runner.manipulation.a b(String str, d dVar) throws FilterFactory.FilterNotCreatedException {
        return d(str).a(dVar);
    }

    static FilterFactory d(String str) throws FilterFactory.FilterNotCreatedException {
        try {
            return c(org.junit.internal.a.a(str).asSubclass(FilterFactory.class));
        } catch (Exception e6) {
            throw new FilterFactory.FilterNotCreatedException(e6);
        }
    }

    public static org.junit.runner.manipulation.a e(f fVar, String str) throws FilterFactory.FilterNotCreatedException {
        String[] strArr;
        Description description = fVar.h().getDescription();
        if (str.contains(ContainerUtils.KEY_VALUE_DELIMITER)) {
            strArr = str.split(ContainerUtils.KEY_VALUE_DELIMITER, 2);
        } else {
            strArr = new String[]{str, ""};
        }
        return b(strArr[0], new d(description, strArr[1]));
    }
}
