package okhttp3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import kotlin.collections.n;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class EventListener {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @JvmField
    @NotNull
    public static final EventListener NONE = new EventListener() { // from class: okhttp3.EventListener$Companion$NONE$1
    };

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class AggregateEventListener extends EventListener {

        @NotNull
        private final EventListener[] eventListeners;

        public AggregateEventListener(@NotNull EventListener[] eventListeners) {
            g0.p(eventListeners, "eventListeners");
            this.eventListeners = eventListeners;
        }

        @Override // okhttp3.EventListener
        public void cacheConditionalHit(@NotNull Call call, @NotNull Response cachedResponse) {
            g0.p(call, "call");
            g0.p(cachedResponse, "cachedResponse");
            for (EventListener eventListener : this.eventListeners) {
                eventListener.cacheConditionalHit(call, cachedResponse);
            }
        }

        @Override // okhttp3.EventListener
        public void cacheHit(@NotNull Call call, @NotNull Response response) {
            g0.p(call, "call");
            g0.p(response, "response");
            for (EventListener eventListener : this.eventListeners) {
                eventListener.cacheHit(call, response);
            }
        }

        @Override // okhttp3.EventListener
        public void cacheMiss(@NotNull Call call) {
            g0.p(call, "call");
            for (EventListener eventListener : this.eventListeners) {
                eventListener.cacheMiss(call);
            }
        }

        @Override // okhttp3.EventListener
        public void callEnd(@NotNull Call call) {
            g0.p(call, "call");
            for (EventListener eventListener : this.eventListeners) {
                eventListener.callEnd(call);
            }
        }

        @Override // okhttp3.EventListener
        public void callFailed(@NotNull Call call, @NotNull IOException ioe) {
            g0.p(call, "call");
            g0.p(ioe, "ioe");
            for (EventListener eventListener : this.eventListeners) {
                eventListener.callFailed(call, ioe);
            }
        }

        @Override // okhttp3.EventListener
        public void callStart(@NotNull Call call) {
            g0.p(call, "call");
            for (EventListener eventListener : this.eventListeners) {
                eventListener.callStart(call);
            }
        }

        @Override // okhttp3.EventListener
        public void canceled(@NotNull Call call) {
            g0.p(call, "call");
            for (EventListener eventListener : this.eventListeners) {
                eventListener.canceled(call);
            }
        }

        @Override // okhttp3.EventListener
        public void connectEnd(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy, @Nullable Protocol protocol) {
            g0.p(call, "call");
            g0.p(inetSocketAddress, "inetSocketAddress");
            g0.p(proxy, "proxy");
            for (EventListener eventListener : this.eventListeners) {
                eventListener.connectEnd(call, inetSocketAddress, proxy, protocol);
            }
        }

        @Override // okhttp3.EventListener
        public void connectFailed(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy, @Nullable Protocol protocol, @NotNull IOException ioe) {
            g0.p(call, "call");
            g0.p(inetSocketAddress, "inetSocketAddress");
            g0.p(proxy, "proxy");
            g0.p(ioe, "ioe");
            for (EventListener eventListener : this.eventListeners) {
                eventListener.connectFailed(call, inetSocketAddress, proxy, protocol, ioe);
            }
        }

        @Override // okhttp3.EventListener
        public void connectStart(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy) {
            g0.p(call, "call");
            g0.p(inetSocketAddress, "inetSocketAddress");
            g0.p(proxy, "proxy");
            for (EventListener eventListener : this.eventListeners) {
                eventListener.connectStart(call, inetSocketAddress, proxy);
            }
        }

        @Override // okhttp3.EventListener
        public void connectionAcquired(@NotNull Call call, @NotNull Connection connection) {
            g0.p(call, "call");
            g0.p(connection, "connection");
            for (EventListener eventListener : this.eventListeners) {
                eventListener.connectionAcquired(call, connection);
            }
        }

        @Override // okhttp3.EventListener
        public void connectionReleased(@NotNull Call call, @NotNull Connection connection) {
            g0.p(call, "call");
            g0.p(connection, "connection");
            for (EventListener eventListener : this.eventListeners) {
                eventListener.connectionReleased(call, connection);
            }
        }

        @Override // okhttp3.EventListener
        public void dispatcherQueueEnd(@NotNull Call call, @NotNull Dispatcher dispatcher) {
            g0.p(call, "call");
            g0.p(dispatcher, "dispatcher");
            for (EventListener eventListener : this.eventListeners) {
                eventListener.dispatcherQueueEnd(call, dispatcher);
            }
        }

        @Override // okhttp3.EventListener
        public void dispatcherQueueStart(@NotNull Call call, @NotNull Dispatcher dispatcher) {
            g0.p(call, "call");
            g0.p(dispatcher, "dispatcher");
            for (EventListener eventListener : this.eventListeners) {
                eventListener.dispatcherQueueStart(call, dispatcher);
            }
        }

        @Override // okhttp3.EventListener
        public void dnsEnd(@NotNull Call call, @NotNull String domainName, @NotNull List<InetAddress> inetAddressList) {
            g0.p(call, "call");
            g0.p(domainName, "domainName");
            g0.p(inetAddressList, "inetAddressList");
            for (EventListener eventListener : this.eventListeners) {
                eventListener.dnsEnd(call, domainName, inetAddressList);
            }
        }

        @Override // okhttp3.EventListener
        public void dnsStart(@NotNull Call call, @NotNull String domainName) {
            g0.p(call, "call");
            g0.p(domainName, "domainName");
            for (EventListener eventListener : this.eventListeners) {
                eventListener.dnsStart(call, domainName);
            }
        }

        @Override // okhttp3.EventListener
        public void followUpDecision(@NotNull Call call, @NotNull Response networkResponse, @Nullable Request request) {
            g0.p(call, "call");
            g0.p(networkResponse, "networkResponse");
            for (EventListener eventListener : this.eventListeners) {
                eventListener.followUpDecision(call, networkResponse, request);
            }
        }

        @NotNull
        public final EventListener[] getEventListeners() {
            return this.eventListeners;
        }

        @Override // okhttp3.EventListener
        public void proxySelectEnd(@NotNull Call call, @NotNull HttpUrl url, @NotNull List<Proxy> proxies) {
            g0.p(call, "call");
            g0.p(url, "url");
            g0.p(proxies, "proxies");
            for (EventListener eventListener : this.eventListeners) {
                eventListener.proxySelectEnd(call, url, proxies);
            }
        }

        @Override // okhttp3.EventListener
        public void proxySelectStart(@NotNull Call call, @NotNull HttpUrl url) {
            g0.p(call, "call");
            g0.p(url, "url");
            for (EventListener eventListener : this.eventListeners) {
                eventListener.proxySelectStart(call, url);
            }
        }

        @Override // okhttp3.EventListener
        public void requestBodyEnd(@NotNull Call call, long j6) {
            g0.p(call, "call");
            for (EventListener eventListener : this.eventListeners) {
                eventListener.requestBodyEnd(call, j6);
            }
        }

        @Override // okhttp3.EventListener
        public void requestBodyStart(@NotNull Call call) {
            g0.p(call, "call");
            for (EventListener eventListener : this.eventListeners) {
                eventListener.requestBodyStart(call);
            }
        }

        @Override // okhttp3.EventListener
        public void requestFailed(@NotNull Call call, @NotNull IOException ioe) {
            g0.p(call, "call");
            g0.p(ioe, "ioe");
            for (EventListener eventListener : this.eventListeners) {
                eventListener.requestFailed(call, ioe);
            }
        }

        @Override // okhttp3.EventListener
        public void requestHeadersEnd(@NotNull Call call, @NotNull Request request) {
            g0.p(call, "call");
            g0.p(request, "request");
            for (EventListener eventListener : this.eventListeners) {
                eventListener.requestHeadersEnd(call, request);
            }
        }

        @Override // okhttp3.EventListener
        public void requestHeadersStart(@NotNull Call call) {
            g0.p(call, "call");
            for (EventListener eventListener : this.eventListeners) {
                eventListener.requestHeadersStart(call);
            }
        }

        @Override // okhttp3.EventListener
        public void responseBodyEnd(@NotNull Call call, long j6) {
            g0.p(call, "call");
            for (EventListener eventListener : this.eventListeners) {
                eventListener.responseBodyEnd(call, j6);
            }
        }

        @Override // okhttp3.EventListener
        public void responseBodyStart(@NotNull Call call) {
            g0.p(call, "call");
            for (EventListener eventListener : this.eventListeners) {
                eventListener.responseBodyStart(call);
            }
        }

        @Override // okhttp3.EventListener
        public void responseFailed(@NotNull Call call, @NotNull IOException ioe) {
            g0.p(call, "call");
            g0.p(ioe, "ioe");
            for (EventListener eventListener : this.eventListeners) {
                eventListener.responseFailed(call, ioe);
            }
        }

        @Override // okhttp3.EventListener
        public void responseHeadersEnd(@NotNull Call call, @NotNull Response response) {
            g0.p(call, "call");
            g0.p(response, "response");
            for (EventListener eventListener : this.eventListeners) {
                eventListener.responseHeadersEnd(call, response);
            }
        }

        @Override // okhttp3.EventListener
        public void responseHeadersStart(@NotNull Call call) {
            g0.p(call, "call");
            for (EventListener eventListener : this.eventListeners) {
                eventListener.responseHeadersStart(call);
            }
        }

        @Override // okhttp3.EventListener
        public void retryDecision(@NotNull Call call, @NotNull IOException exception, boolean z5) {
            g0.p(call, "call");
            g0.p(exception, "exception");
            for (EventListener eventListener : this.eventListeners) {
                eventListener.retryDecision(call, exception, z5);
            }
        }

        @Override // okhttp3.EventListener
        public void satisfactionFailure(@NotNull Call call, @NotNull Response response) {
            g0.p(call, "call");
            g0.p(response, "response");
            for (EventListener eventListener : this.eventListeners) {
                eventListener.satisfactionFailure(call, response);
            }
        }

        @Override // okhttp3.EventListener
        public void secureConnectEnd(@NotNull Call call, @Nullable Handshake handshake) {
            g0.p(call, "call");
            for (EventListener eventListener : this.eventListeners) {
                eventListener.secureConnectEnd(call, handshake);
            }
        }

        @Override // okhttp3.EventListener
        public void secureConnectStart(@NotNull Call call) {
            g0.p(call, "call");
            for (EventListener eventListener : this.eventListeners) {
                eventListener.secureConnectStart(call);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface Factory {
        @NotNull
        EventListener create(@NotNull Call call);
    }

    public void cacheConditionalHit(@NotNull Call call, @NotNull Response cachedResponse) {
        g0.p(call, "call");
        g0.p(cachedResponse, "cachedResponse");
    }

    public void cacheHit(@NotNull Call call, @NotNull Response response) {
        g0.p(call, "call");
        g0.p(response, "response");
    }

    public void cacheMiss(@NotNull Call call) {
        g0.p(call, "call");
    }

    public void callEnd(@NotNull Call call) {
        g0.p(call, "call");
    }

    public void callFailed(@NotNull Call call, @NotNull IOException ioe) {
        g0.p(call, "call");
        g0.p(ioe, "ioe");
    }

    public void callStart(@NotNull Call call) {
        g0.p(call, "call");
    }

    public void canceled(@NotNull Call call) {
        g0.p(call, "call");
    }

    public void connectEnd(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy, @Nullable Protocol protocol) {
        g0.p(call, "call");
        g0.p(inetSocketAddress, "inetSocketAddress");
        g0.p(proxy, "proxy");
    }

    public void connectFailed(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy, @Nullable Protocol protocol, @NotNull IOException ioe) {
        g0.p(call, "call");
        g0.p(inetSocketAddress, "inetSocketAddress");
        g0.p(proxy, "proxy");
        g0.p(ioe, "ioe");
    }

    public void connectStart(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy) {
        g0.p(call, "call");
        g0.p(inetSocketAddress, "inetSocketAddress");
        g0.p(proxy, "proxy");
    }

    public void connectionAcquired(@NotNull Call call, @NotNull Connection connection) {
        g0.p(call, "call");
        g0.p(connection, "connection");
    }

    public void connectionReleased(@NotNull Call call, @NotNull Connection connection) {
        g0.p(call, "call");
        g0.p(connection, "connection");
    }

    public void dispatcherQueueEnd(@NotNull Call call, @NotNull Dispatcher dispatcher) {
        g0.p(call, "call");
        g0.p(dispatcher, "dispatcher");
    }

    public void dispatcherQueueStart(@NotNull Call call, @NotNull Dispatcher dispatcher) {
        g0.p(call, "call");
        g0.p(dispatcher, "dispatcher");
    }

    public void dnsEnd(@NotNull Call call, @NotNull String domainName, @NotNull List<InetAddress> inetAddressList) {
        g0.p(call, "call");
        g0.p(domainName, "domainName");
        g0.p(inetAddressList, "inetAddressList");
    }

    public void dnsStart(@NotNull Call call, @NotNull String domainName) {
        g0.p(call, "call");
        g0.p(domainName, "domainName");
    }

    public void followUpDecision(@NotNull Call call, @NotNull Response networkResponse, @Nullable Request request) {
        g0.p(call, "call");
        g0.p(networkResponse, "networkResponse");
    }

    @NotNull
    public final EventListener plus(@NotNull EventListener other) {
        g0.p(other, "other");
        EventListener eventListener = NONE;
        if (this == eventListener) {
            return other;
        }
        EventListener[] eventListeners = this instanceof AggregateEventListener ? ((AggregateEventListener) this).getEventListeners() : new EventListener[]{this};
        if (other == eventListener) {
            return this;
        }
        return new AggregateEventListener((EventListener[]) n.y3(eventListeners, other instanceof AggregateEventListener ? ((AggregateEventListener) other).getEventListeners() : new EventListener[]{other}));
    }

    public void proxySelectEnd(@NotNull Call call, @NotNull HttpUrl url, @NotNull List<Proxy> proxies) {
        g0.p(call, "call");
        g0.p(url, "url");
        g0.p(proxies, "proxies");
    }

    public void proxySelectStart(@NotNull Call call, @NotNull HttpUrl url) {
        g0.p(call, "call");
        g0.p(url, "url");
    }

    public void requestBodyEnd(@NotNull Call call, long j6) {
        g0.p(call, "call");
    }

    public void requestBodyStart(@NotNull Call call) {
        g0.p(call, "call");
    }

    public void requestFailed(@NotNull Call call, @NotNull IOException ioe) {
        g0.p(call, "call");
        g0.p(ioe, "ioe");
    }

    public void requestHeadersEnd(@NotNull Call call, @NotNull Request request) {
        g0.p(call, "call");
        g0.p(request, "request");
    }

    public void requestHeadersStart(@NotNull Call call) {
        g0.p(call, "call");
    }

    public void responseBodyEnd(@NotNull Call call, long j6) {
        g0.p(call, "call");
    }

    public void responseBodyStart(@NotNull Call call) {
        g0.p(call, "call");
    }

    public void responseFailed(@NotNull Call call, @NotNull IOException ioe) {
        g0.p(call, "call");
        g0.p(ioe, "ioe");
    }

    public void responseHeadersEnd(@NotNull Call call, @NotNull Response response) {
        g0.p(call, "call");
        g0.p(response, "response");
    }

    public void responseHeadersStart(@NotNull Call call) {
        g0.p(call, "call");
    }

    public void retryDecision(@NotNull Call call, @NotNull IOException exception, boolean z5) {
        g0.p(call, "call");
        g0.p(exception, "exception");
    }

    public void satisfactionFailure(@NotNull Call call, @NotNull Response response) {
        g0.p(call, "call");
        g0.p(response, "response");
    }

    public void secureConnectEnd(@NotNull Call call, @Nullable Handshake handshake) {
        g0.p(call, "call");
    }

    public void secureConnectStart(@NotNull Call call) {
        g0.p(call, "call");
    }
}
