/*
 * This file is part of packetevents - https://github.com/retrooper/packetevents
 * Copyright (C) 2021 retrooper and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.github.retrooper.packetevents.wrapper.game.server;

import io.github.retrooper.packetevents.event.impl.PacketSendEvent;
import io.github.retrooper.packetevents.protocol.PacketType;
import io.github.retrooper.packetevents.wrapper.SendablePacketWrapper;

public class WrapperGameServerHeldItemChange extends SendablePacketWrapper<WrapperGameServerHeldItemChange> {
    private byte slot;

    public WrapperGameServerHeldItemChange(PacketSendEvent event) {
        super(event);
    }

    public WrapperGameServerHeldItemChange(byte slot) {
        super(PacketType.Game.Server.HELD_ITEM_CHANGE.getID());
        this.slot = slot;
    }

    @Override
    public void readData() {
        this.slot = readByte();
    }

    @Override
    public void readData(WrapperGameServerHeldItemChange wrapper) {
        this.slot = wrapper.slot;
    }

    @Override
    public void writeData() {
        writeByte(slot);
    }

    public byte getSlot() {
        return slot;
    }

    public void setSlot(byte slot) {
        this.slot = slot;
    }

    @Override
    public void createPacket() {
        writeByte(slot);
    }
}
