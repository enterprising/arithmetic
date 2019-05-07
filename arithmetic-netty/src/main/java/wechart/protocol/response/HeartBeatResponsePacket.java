package wechart.protocol.response;

import wechart.protocol.Packet;

import static wechart.protocol.Command.HEARTBEAT_RESPONSE;

/**
 * Created by peng.tan on 2019/5/7.
 */
public class HeartBeatResponsePacket extends Packet {

    @Override
    public Byte getCommand() {
        return HEARTBEAT_RESPONSE;
    }
}
