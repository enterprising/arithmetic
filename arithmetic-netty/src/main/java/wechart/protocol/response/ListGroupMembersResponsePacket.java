package wechart.protocol.response;

import lombok.Data;
import wechart.protocol.Packet;
import wechart.session.Session;

import java.util.List;

import static wechart.protocol.Command.LIST_GROUP_MEMBERS_RESPONSE;

/**
 * Created by peng.tan on 2019/5/5.
 */
@Data
public class ListGroupMembersResponsePacket extends Packet {

    private String groupId;

    private List<Session> sessionList;

    @Override
    public Byte getCommand() {

        return LIST_GROUP_MEMBERS_RESPONSE;
    }
}
