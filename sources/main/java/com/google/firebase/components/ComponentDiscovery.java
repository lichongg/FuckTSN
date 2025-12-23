package com.google.firebase.components;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.inject.Provider;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class ComponentDiscovery<T> {
    private static final String COMPONENT_KEY_PREFIX = "com.google.firebase.components:";
    private static final String COMPONENT_SENTINEL_VALUE = "com.google.firebase.components.ComponentRegistrar";
    static final String TAG = "ComponentDiscovery";
    private final T context;
    private final RegistrarNameRetriever<T> retriever;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.firebase.components.ComponentDiscovery$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class MetadataRegistrarNameRetriever implements RegistrarNameRetriever<Context> {
        private final Class<? extends Service> discoveryService;

        /* synthetic */ MetadataRegistrarNameRetriever(Class cls, AnonymousClass1 anonymousClass1) {
            this(cls);
        }

        private Bundle getMetadata(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, this.discoveryService), 128);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Objects.toString(this.discoveryService);
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        private MetadataRegistrarNameRetriever(Class<? extends Service> cls) {
            this.discoveryService = cls;
        }

        @Override // com.google.firebase.components.ComponentDiscovery.RegistrarNameRetriever
        public List<String> retrieve(Context context) {
            Bundle metadata = getMetadata(context);
            if (metadata == null) {
                return Collections.EMPTY_LIST;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : metadata.keySet()) {
                if (ComponentDiscovery.COMPONENT_SENTINEL_VALUE.equals(metadata.get(str)) && str.startsWith(ComponentDiscovery.COMPONENT_KEY_PREFIX)) {
                    arrayList.add(str.substring(31));
                }
            }
            return arrayList;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @VisibleForTesting
    interface RegistrarNameRetriever<T> {
        List<String> retrieve(T t5);
    }

    public static ComponentDiscovery<Context> forContext(Context context, Class<? extends Service> cls) {
        return new ComponentDiscovery<>(context, new MetadataRegistrarNameRetriever(cls, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static ComponentRegistrar instantiate(String str) {
        try {
            Class<?> cls = Class.forName(str);
            if (ComponentRegistrar.class.isAssignableFrom(cls)) {
                return (ComponentRegistrar) cls.getDeclaredConstructor(null).newInstance(null);
            }
            throw new InvalidRegistrarException(String.format("Class %s is not an instance of %s", str, COMPONENT_SENTINEL_VALUE));
        } catch (ClassNotFoundException unused) {
            String.format("Class %s is not an found.", str);
            return null;
        } catch (IllegalAccessException e6) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s.", str), e6);
        } catch (InstantiationException e7) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s.", str), e7);
        } catch (NoSuchMethodException e8) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s", str), e8);
        } catch (InvocationTargetException e9) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s", str), e9);
        }
    }

    @Deprecated
    public List<ComponentRegistrar> discover() {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.retriever.retrieve(this.context).iterator();
        while (it.hasNext()) {
            try {
                ComponentRegistrar instantiate = instantiate(it.next());
                if (instantiate != null) {
                    arrayList.add(instantiate);
                }
            } catch (InvalidRegistrarException unused) {
            }
        }
        return arrayList;
    }

    public List<Provider<ComponentRegistrar>> discoverLazy() {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.retriever.retrieve(this.context).iterator();
        while (it.hasNext()) {
            arrayList.add(ComponentDiscovery$$Lambda$1.lambdaFactory$(it.next()));
        }
        return arrayList;
    }

    @VisibleForTesting
    ComponentDiscovery(T t5, RegistrarNameRetriever<T> registrarNameRetriever) {
        this.context = t5;
        this.retriever = registrarNameRetriever;
    }
}
