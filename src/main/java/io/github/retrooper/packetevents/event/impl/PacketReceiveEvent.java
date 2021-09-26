package io.github.retrooper.packetevents.event.impl;

import io.github.retrooper.packetevents.event.PacketListenerAbstract;
import io.github.retrooper.packetevents.event.ProtocolPacketEvent;
import io.github.retrooper.packetevents.protocol.ConnectionState;
import io.github.retrooper.packetevents.protocol.PacketSide;
import io.github.retrooper.packetevents.utils.netty.buffer.ByteBufAbstract;
import io.github.retrooper.packetevents.utils.netty.channel.ChannelAbstract;
import io.github.retrooper.packetevents.wrapper.PacketWrapper;
import org.bukkit.entity.Player;

public class PacketReceiveEvent extends ProtocolPacketEvent {
    private PacketWrapper<?> lastUsedWrapper;

    public PacketReceiveEvent(ChannelAbstract channel, Player player, ByteBufAbstract byteBuf) {
        super(PacketSide.CLIENT, channel, player, byteBuf);
    }

    public PacketReceiveEvent(ConnectionState connectionState, ChannelAbstract channel, Player player, ByteBufAbstract byteBuf) {
        super(PacketSide.CLIENT, connectionState, channel, player, byteBuf);
    }

    public PacketReceiveEvent(Object channel, Player player, Object rawByteBuf) {
        super(PacketSide.CLIENT, channel, player, rawByteBuf);
    }

    public PacketReceiveEvent(ConnectionState connectionState, Object channel, Player player, Object rawByteBuf) {
        super(PacketSide.CLIENT, connectionState, channel, player, rawByteBuf);
    }

    @Override
    public void call(PacketListenerAbstract listener) {
        listener.onPacketReceive(this);
    }

    @Deprecated
    public PacketWrapper<?> getLastUsedWrapper() {
        return lastUsedWrapper;
    }

    @Deprecated
    public void setLastUsedWrapper(PacketWrapper<?> currentPacketWrapper) {
        this.lastUsedWrapper = currentPacketWrapper;
    }
}
