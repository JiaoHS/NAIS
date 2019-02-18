import com.nasi.portal.common.helper.DateHelper;
import com.nasi.portal.data.mapper.HomeWorkTaskMapper;
import com.nasi.portal.data.mapper.WebConfigMapper;
import com.nasi.portal.data.model.*;
import com.nasi.portal.service.InfoService;
import com.nasi.portal.web.model.JsonResult;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Date;
import java.util.List;

/**
 * created by xdCao on 2018/4/18
 */
@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations={"classpath:spring.xml"}) //加载配置文件
public class Test {

    @Autowired
    private WebConfigMapper mapper;

    @Autowired
    private InfoService infoService;

    @Autowired
    private HomeWorkTaskMapper homeWorkTaskMapper;

    @org.junit.Test
    @Transactional
    public void testWebConfig(){

        WebConfigExample example=new WebConfigExample();
        example.createCriteria().andActiveEqualTo(1);
        List<WebConfig> configs = mapper.selectByExample(example);
        System.out.println(configs.size());

    }


    @org.junit.Test
    @Transactional
    public void testInfo(){
//        Info info=new Info();
//        info.setTitle("测试一");
//        info.setTitleImg("图片地址");
//        info.setDescInfo("。。。");
//        info.setContent("内容");
//        info.setCreateTime(new Date());
//        info.setUpdateTime(new Date());
//
//        infoService.insertInfo(info);

        List<Info> infoListLimit = infoService.getInfoListLimit(4);
        for (int i = 0; i < infoListLimit.size(); i++) {
            System.out.println(infoListLimit.get(i).getCreateTime());
        }

        System.out.println();
        System.out.println();

        List<Info> infoList = infoService.getInfoList();
        for (int i = 0; i < infoList.size(); i++) {
            System.out.println(infoList.get(i).getId());
        }

    }


    @org.junit.Test
    public void pageTest(){

        JsonResult<?> infoListByPage = infoService.getInfoListByPage(1, 100);
        System.out.println("------------------------------------------------------"+infoListByPage);


    }


    @org.junit.Test
    public void testHomeDetail(){

        Date date = DateHelper.strToDate("2018-5-21", "yyyy-MM-dd");

        HomeWorkTaskExample example=new HomeWorkTaskExample();

        example.createCriteria()
                .andCreateTimeGreaterThanOrEqualTo(date).andCreateTimeLessThan(DateHelper.tomorrow(date))
                .andTaskArrangeIdEqualTo(65L)
                .andTaskTypeEqualTo(1);

        List<HomeWorkTask> homeWorkTasksTemp = homeWorkTaskMapper.selectByExample(example);
        if (homeWorkTasksTemp==null||homeWorkTasksTemp.size()==0){
            System.out.println("------------------------------------------------------null");
        }else {
            System.out.println(homeWorkTasksTemp.get(0).getTaskCourseCode());
        }
    }



}
