import net.tanpeng.mybatis.model.Shop;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Created by peng.tan on 2020/1/27.
 */
public class ShopMapperTest extends BaseMapperTest {
    @Test
    public void testUserSelectById() {
        SqlSession sqlSession = getSqlSession();
        try {
            Shop shop = sqlSession.selectOne("net.tanpeng.mybatis.mapper.ShopMapper.selectByid", 7);
            System.out.println(shop.getShardid());
        } finally {
            sqlSession.close();
        }
    }
}
