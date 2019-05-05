package wechart.protocol.request;

import lombok.Data;
import wechart.protocol.Packet;

import java.util.List;

import static wechart.protocol.command.Command.CREATE_GROUP_REQUEST;

/**
 * Created by peng.tan on 2019/5/5.
 */
@Data
public class CreateGroupRequestPacket extends Packet {
    private List<String> userIdList;

    @Override
    public Byte getCommand() {

        return CREATE_GROUP_REQUEST;
    }
}
