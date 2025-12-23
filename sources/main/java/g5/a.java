package g5;

import java.util.ArrayList;
import java.util.List;
import org.junit.experimental.theories.PotentialAssignment;
import org.junit.experimental.theories.b;
import org.junit.experimental.theories.suppliers.TestedOn;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a extends b {
    @Override // org.junit.experimental.theories.b
    public List<PotentialAssignment> a(org.junit.experimental.theories.a aVar) {
        ArrayList arrayList = new ArrayList();
        for (int i6 : ((TestedOn) aVar.g(TestedOn.class)).ints()) {
            arrayList.add(PotentialAssignment.a("ints", Integer.valueOf(i6)));
        }
        return arrayList;
    }
}
