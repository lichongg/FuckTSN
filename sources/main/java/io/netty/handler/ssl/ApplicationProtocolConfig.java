package io.netty.handler.ssl;

import io.netty.util.internal.ObjectUtil;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class ApplicationProtocolConfig {
    public static final ApplicationProtocolConfig DISABLED = new ApplicationProtocolConfig();
    private final Protocol protocol;
    private final SelectedListenerFailureBehavior selectedBehavior;
    private final SelectorFailureBehavior selectorBehavior;
    private final List<String> supportedProtocols;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum Protocol {
        NONE,
        NPN,
        ALPN,
        NPN_AND_ALPN
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum SelectedListenerFailureBehavior {
        ACCEPT,
        FATAL_ALERT,
        CHOOSE_MY_LAST_PROTOCOL
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum SelectorFailureBehavior {
        FATAL_ALERT,
        NO_ADVERTISE,
        CHOOSE_MY_LAST_PROTOCOL
    }

    public ApplicationProtocolConfig(Protocol protocol, SelectorFailureBehavior selectorFailureBehavior, SelectedListenerFailureBehavior selectedListenerFailureBehavior, Iterable<String> iterable) {
        this(protocol, selectorFailureBehavior, selectedListenerFailureBehavior, ApplicationProtocolUtil.toList(iterable));
    }

    public ApplicationProtocolConfig(Protocol protocol, SelectorFailureBehavior selectorFailureBehavior, SelectedListenerFailureBehavior selectedListenerFailureBehavior, String... strArr) {
        this(protocol, selectorFailureBehavior, selectedListenerFailureBehavior, ApplicationProtocolUtil.toList(strArr));
    }

    public Protocol protocol() {
        return this.protocol;
    }

    public SelectedListenerFailureBehavior selectedListenerFailureBehavior() {
        return this.selectedBehavior;
    }

    public SelectorFailureBehavior selectorFailureBehavior() {
        return this.selectorBehavior;
    }

    public List<String> supportedProtocols() {
        return this.supportedProtocols;
    }

    private ApplicationProtocolConfig(Protocol protocol, SelectorFailureBehavior selectorFailureBehavior, SelectedListenerFailureBehavior selectedListenerFailureBehavior, List<String> list) {
        this.supportedProtocols = Collections.unmodifiableList((List) ObjectUtil.checkNotNull(list, "supportedProtocols"));
        this.protocol = (Protocol) ObjectUtil.checkNotNull(protocol, "protocol");
        this.selectorBehavior = (SelectorFailureBehavior) ObjectUtil.checkNotNull(selectorFailureBehavior, "selectorBehavior");
        this.selectedBehavior = (SelectedListenerFailureBehavior) ObjectUtil.checkNotNull(selectedListenerFailureBehavior, "selectedBehavior");
        Protocol protocol2 = Protocol.NONE;
        if (protocol != protocol2) {
            if (list.isEmpty()) {
                throw new IllegalArgumentException("supportedProtocols must be not empty");
            }
            return;
        }
        throw new IllegalArgumentException("protocol (" + protocol2 + ") must not be " + protocol2 + '.');
    }

    private ApplicationProtocolConfig() {
        this.supportedProtocols = Collections.EMPTY_LIST;
        this.protocol = Protocol.NONE;
        this.selectorBehavior = SelectorFailureBehavior.CHOOSE_MY_LAST_PROTOCOL;
        this.selectedBehavior = SelectedListenerFailureBehavior.ACCEPT;
    }
}
