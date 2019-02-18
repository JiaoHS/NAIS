import com.nasi.portal.data.model.Campus;
import com.nasi.portal.service.CampusService;
import com.nasi.portal.web.model.JsonResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations={"classpath:spring.xml"}) //加载配置文件
public class TestJson {

    @Autowired
    private CampusService campusService;

    @org.junit.Test
    @Transactional
    public void testJson(){
        Long id = 1L;
        List<Campus> campusList=campusService.getCampusRecordBySelect(id);
        if(campusList==null||campusList!=null&&campusList.size()==0) {
            System.out.println(JsonResult.error("不存在校区id为" + id + "的记录！"));
        }
        System.out.println(JsonResult.success(campusList));
    }

}
