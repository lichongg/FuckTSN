package org.junit.experimental.theories.internal;

import java.util.Arrays;
import java.util.List;
import org.junit.experimental.theories.PotentialAssignment;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c extends org.junit.experimental.theories.b {
    @Override // org.junit.experimental.theories.b
    public List<PotentialAssignment> a(org.junit.experimental.theories.a aVar) {
        return Arrays.asList(PotentialAssignment.a("true", Boolean.TRUE), PotentialAssignment.a("false", Boolean.FALSE));
    }
}
