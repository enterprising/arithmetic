package wechart.protocol.request;

import wechart.protocol.Packet;

import static wechart.protocol.Command.HEARTBEAT_REQUEST;

/**
 * Created by peng.tan on 2019/5/7.
 */
public class HeartBeatRequestPacket extends Packet {

    @Override
    public Byte getCommand() {
        return HEARTBEAT_REQUEST;
    }
}