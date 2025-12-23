package f5;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import org.junit.runners.Suite;
import org.junit.runners.model.f;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a extends Suite {
    private static Class<?>[] J(Class<?>[] clsArr) {
        ArrayList arrayList = new ArrayList(clsArr.length);
        for (Class<?> cls : clsArr) {
            if (!Modifier.isAbstract(cls.getModifiers())) {
                arrayList.add(cls);
            }
        }
        return (Class[]) arrayList.toArray(new Class[arrayList.size()]);
    }

    public a(Class<?> cls, f fVar) throws Throwable {
        super(fVar, cls, J(cls.getClasses()));
    }
}
