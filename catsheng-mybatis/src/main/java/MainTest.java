import net.tanpeng.mybatis.mapper.ShopMapper;
import net.tanpeng.mybatis.model.Shop;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @author: peng.tan
 * @create: 2020/05/13 22:25
 */
public class MainTest {
    public static void main(String[] args) {
        try {
            //使用MyBatis提供的Resources类加载mybatis的配置文件
            Reader reader = null;
            reader = Resources.getResourceAsReader("mybatis/mybatis-config.xml");
            //构建sqlSession的工厂
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);

            SqlSession session = sessionFactory.openSession();
            ShopMapper mapper = session.getMapper(ShopMapper.class);
            Shop user = mapper.selectByid(1L);
            System.out.println(user.getShardid());

            // update 的时候，如果没设置autocommit=true，一定要手动commit
            session.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
