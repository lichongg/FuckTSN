package com.google.firebase.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class CycleDetector {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.firebase.components.CycleDetector$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class ComponentNode {
        private final Component<?> component;
        private final Set<ComponentNode> dependencies = new HashSet();
        private final Set<ComponentNode> dependents = new HashSet();

        void addDependency(ComponentNode componentNode) {
            this.dependencies.add(componentNode);
        }

        void addDependent(ComponentNode componentNode) {
            this.dependents.add(componentNode);
        }

        Component<?> getComponent() {
            return this.component;
        }

        Set<ComponentNode> getDependencies() {
            return this.dependencies;
        }

        boolean isLeaf() {
            return this.dependencies.isEmpty();
        }

        boolean isRoot() {
            return this.dependents.isEmpty();
        }

        void removeDependent(ComponentNode componentNode) {
            this.dependents.remove(componentNode);
        }

        ComponentNode(Component<?> component) {
            this.component = component;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class Dep {
        private final Class<?> anInterface;
        private final boolean set;

        /* synthetic */ Dep(Class cls, boolean z5, AnonymousClass1 anonymousClass1) {
            this(cls, z5);
        }

        private Dep(Class<?> cls, boolean z5) {
            this.anInterface = cls;
            this.set = z5;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Dep) {
                Dep dep = (Dep) obj;
                if (dep.anInterface.equals(this.anInterface) && dep.set == this.set) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((this.anInterface.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.set).hashCode();
        }
    }

    private static Set<ComponentNode> getRoots(Set<ComponentNode> set) {
        HashSet hashSet = new HashSet();
        for (ComponentNode componentNode : set) {
            if (componentNode.isRoot()) {
                hashSet.add(componentNode);
            }
        }
        return hashSet;
    }

    private static Set<ComponentNode> toGraph(List<Component<?>> list) {
        Set<ComponentNode> set;
        HashMap hashMap = new HashMap(list.size());
        Iterator<Component<?>> it = list.iterator();
        while (true) {
            AnonymousClass1 anonymousClass1 = null;
            if (!it.hasNext()) {
                Iterator it2 = hashMap.values().iterator();
                while (it2.hasNext()) {
                    for (ComponentNode componentNode : (Set) it2.next()) {
                        for (Dependency dependency : componentNode.getComponent().getDependencies()) {
                            if (dependency.isDirectInjection() && (set = (Set) hashMap.get(new Dep(dependency.getInterface(), dependency.isSet(), anonymousClass1))) != null) {
                                for (ComponentNode componentNode2 : set) {
                                    componentNode.addDependency(componentNode2);
                                    componentNode2.addDependent(componentNode);
                                }
                            }
                        }
                    }
                }
                HashSet hashSet = new HashSet();
                Iterator it3 = hashMap.values().iterator();
                while (it3.hasNext()) {
                    hashSet.addAll((Set) it3.next());
                }
                return hashSet;
            }
            Component<?> next = it.next();
            ComponentNode componentNode3 = new ComponentNode(next);
            for (Class<? super Object> cls : next.getProvidedInterfaces()) {
                Dep dep = new Dep(cls, !next.isValue(), anonymousClass1);
                if (!hashMap.containsKey(dep)) {
                    hashMap.put(dep, new HashSet());
                }
                Set set2 = (Set) hashMap.get(dep);
                if (!set2.isEmpty() && !dep.set) {
                    throw new IllegalArgumentException(String.format("Multiple components provide %s.", cls));
                }
                set2.add(componentNode3);
            }
        }
    }

    CycleDetector() {
    }

    static void detect(List<Component<?>> list) {
        Set<ComponentNode> graph = toGraph(list);
        Set<ComponentNode> roots = getRoots(graph);
        int i6 = 0;
        while (!roots.isEmpty()) {
            ComponentNode next = roots.iterator().next();
            roots.remove(next);
            i6++;
            for (ComponentNode componentNode : next.getDependencies()) {
                componentNode.removeDependent(next);
                if (componentNode.isRoot()) {
                    roots.add(componentNode);
                }
            }
        }
        if (i6 == list.size()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (ComponentNode componentNode2 : graph) {
            if (!componentNode2.isRoot() && !componentNode2.isLeaf()) {
                arrayList.add(componentNode2.getComponent());
            }
        }
        throw new DependencyCycleException(arrayList);
    }
}
