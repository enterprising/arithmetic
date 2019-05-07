package wechart.protocol.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import wechart.protocol.Packet;

import static wechart.protocol.Command.GROUP_MESSAGE_REQUEST;

/**
 * Created by peng.tan on 2019/5/6.
 */
@Data
@NoArgsConstructor
public class GroupMessageRequestPacket extends Packet {
    private String toGroupId;
    private String message;

    public GroupMessageRequestPacket(String toGroupId, String message) {
        this.toGroupId = toGroupId;
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return GROUP_MESSAGE_REQUEST;
    }
}
