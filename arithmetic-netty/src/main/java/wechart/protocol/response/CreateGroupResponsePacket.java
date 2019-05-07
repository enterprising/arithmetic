package wechart.protocol.response;

import lombok.Data;
import wechart.protocol.Packet;

import java.util.List;

import static wechart.protocol.Command.CREATE_GROUP_RESPONSE;

/**
 * Created by peng.tan on 2019/5/5.
 */
@Data
public class CreateGroupResponsePacket extends Packet {
    private boolean success;

    private String groupId;

    private List<String> userNameList;

    @Override
    public Byte getCommand() {

        return CREATE_GROUP_RESPONSE;
    }
}
