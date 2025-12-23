package org.junit.experimental.categories;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.experimental.categories.Categories;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class d extends org.junit.experimental.categories.a {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a extends Categories.a {
        public a(List<Class<?>> list) {
            this(new HashSet(list));
        }

        public a(Set<Class<?>> set) {
            super(true, set, true, null);
        }

        @Override // org.junit.experimental.categories.Categories.a, org.junit.runner.manipulation.a
        public String b() {
            return "includes " + super.b();
        }
    }

    @Override // org.junit.experimental.categories.a
    protected org.junit.runner.manipulation.a b(List<Class<?>> list) {
        return new a(list);
    }
}
