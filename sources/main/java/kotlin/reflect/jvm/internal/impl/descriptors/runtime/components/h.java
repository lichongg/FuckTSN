package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.text.u;
import kotlin.text.v0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(kotlin.reflect.jvm.internal.impl.name.b bVar) {
        String w22 = u.w2(bVar.g().a(), '.', v0.f47959c, false, 4, null);
        if (bVar.f().c()) {
            return w22;
        }
        return bVar.f() + '.' + w22;
    }
}
