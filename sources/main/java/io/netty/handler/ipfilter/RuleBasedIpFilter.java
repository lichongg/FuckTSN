package io.netty.handler.ipfilter;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import java.net.InetSocketAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ChannelHandler.Sharable
/* loaded from: D:\Downloads\app\classes7.dex */
public class RuleBasedIpFilter extends AbstractRemoteAddressFilter<InetSocketAddress> {
    private final IpFilterRule[] rules;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.ipfilter.AbstractRemoteAddressFilter
    public boolean accept(ChannelHandlerContext channelHandlerContext, InetSocketAddress inetSocketAddress) throws Exception {
        IpFilterRule ipFilterRule;
        IpFilterRule[] ipFilterRuleArr = this.rules;
        int length = ipFilterRuleArr.length;
        for (int i6 = 0; i6 < length && (ipFilterRule = ipFilterRuleArr[i6]) != null; i6++) {
            if (ipFilterRule.matches(inetSocketAddress)) {
                return ipFilterRule.ruleType() == IpFilterRuleType.ACCEPT;
            }
        }
        return true;
    }

    public RuleBasedIpFilter(IpFilterRule... ipFilterRuleArr) {
        if (ipFilterRuleArr != null) {
            this.rules = ipFilterRuleArr;
            return;
        }
        throw new NullPointerException("rules");
    }
}
