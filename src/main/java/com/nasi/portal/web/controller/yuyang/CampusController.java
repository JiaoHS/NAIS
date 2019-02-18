package com.nasi.portal.web.controller.yuyang;

import com.nasi.portal.data.model.Campus;
import com.nasi.portal.service.CampusService;
import com.nasi.portal.service.HotelService;
import com.nasi.portal.web.controller.BaseController;
import com.nasi.portal.web.controller.caohao.DataGridResult;
import com.nasi.portal.web.controller.yuyang.DTO.campusInfo;
import com.nasi.portal.web.model.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * created by yuyang on 2018/4/19
 */

@Controller
@RequestMapping(value = "/campus")
public class CampusController extends BaseController {
    @Autowired
    private CampusService campusService;
    private HotelService hotelService;

    @RequestMapping("/campushome")
    public String campushome() {
        return "campus/campus";
    }

    @RequestMapping(value = "/show/list")
    @ResponseBody
    public JsonResult<?> showCampusInfo() {
        List<Campus> campusList = campusService.getCampusMessageForHomePage();
        if (campusList == null || campusList != null && campusList.size() == 0)
            return JsonResult.error("后台数据为空！");
        return JsonResult.success(campusList);
    }

    //根据校区名搜索
    @RequestMapping(value = "/find")
    @ResponseBody
    public DataGridResult showCampusInfoByQuery(@RequestParam(value = "query", required = false) String query,
                                                @RequestParam(value = "page") Integer page,
                                                @RequestParam(value = "rows") Integer rows) {
        DataGridResult campusListByQuery = null;
        if (query == null || query.equals("")) {
            campusListByQuery = campusService.getCampusListForDataGridByPage(page, rows);
        } else {
            campusListByQuery = campusService.getCampusRecordFromQuery(query, page, rows);
        }
        return campusListByQuery;
    }

    @RequestMapping(value = "/findHotel")
    @ResponseBody
    public DataGridResult showHotelInfoByQuery(@RequestParam(value = "query", required = false) String query,
                                               @RequestParam(value = "page") Integer page,
                                               @RequestParam(value = "rows") Integer rows) {
        DataGridResult campusListByQuery = null;
        if (query == null || query.equals("")) {
            campusListByQuery = hotelService.getCampusListForDataGridByPage(page, rows);
        } else {
            campusListByQuery = hotelService.getCampusRecordFromQuery(query, page, rows);
        }
        return campusListByQuery;
    }

    //for ajax
    @RequestMapping(value = "/found")
    @ResponseBody
    public DataGridResult showCampusInfoForAjax(@RequestParam(value = "page") Integer page,
                                                @RequestParam(value = "rows") Integer rows) {
        DataGridResult campusListByQuery = null;
        campusListByQuery = campusService.getCampusRecords(page, rows);
        return campusListByQuery;
    }

    //for ajax
    @RequestMapping(value = "/founded")
    @ResponseBody
    public JsonResult showCampusInfoForAjaxO() {
        List<campusInfo> list = campusService.getCampusRecordsAnother();
        return JsonResult.success(list);
    }

    //选择查看某一条记录
    @RequestMapping(value = "/show/list/select")
    @ResponseBody
    public JsonResult showCampusInfoBySelect(@RequestParam("id") Long id) {
        List<Campus> campusList = campusService.getCampusRecordBySelect(id.longValue());
        if (campusList == null || campusList != null && campusList.size() == 0)
            return JsonResult.error("不存在校区id为" + id + "的记录！");
        return JsonResult.success(campusList);
    }

    @RequestMapping("/updateSave")
    @ResponseBody
    public JsonResult<?> saveData(@RequestParam(value = "id", required = false) Long id,
                                  @RequestParam("campusName") String campusName,
                                  @RequestParam("campusNameEn") String campusNameEn,
                                  @RequestParam("seasonStart") @DateTimeFormat(pattern = "yyyy-MM-dd") Date seasonStart,
                                  @RequestParam("seasonEnd") @DateTimeFormat(pattern = "yyyy-MM-dd") Date seasonEnd,
                                  @RequestParam("campusPhoto") String campusPhoto,
                                  @RequestParam("campusBannerPhoto") String campusBannerPhoto,
                                  @RequestParam("campusDesc") String campusDesc,
                                  @RequestParam("adreesDesc") String adreesDesc,
                                  @RequestParam("hotelDesc") String hotelDesc,
                                  @RequestParam("hotelPhoto") String hotelPhoto,
                                  @RequestParam("hotelimage1") String hotelPhoto1,
                                  @RequestParam("hotelimage2") String hotelPhoto2,
                                  @RequestParam("hotelname") String HotelName,
                                  @RequestParam("hoteladdress") String HotelAddress,
                                  @RequestParam("hotalstar") String HotelStar,
                                  @RequestParam("hoteldistance") String HotelDistance) {
        Campus campus = new Campus();
        if (id == null || id.equals("")) {
            //insert
            campus.setId(null);
            campus.setCampusName(campusName);
            campus.setCampusNameEn(campusNameEn);
            campus.setSeasonStart(seasonStart);
            campus.setSeasonEnd(seasonEnd);
            campus.setCampusPhoto(campusPhoto);
            campus.setCampusBannerPhoto(campusBannerPhoto);
            campus.setCampusDesc(campusDesc);
            campus.setAdreesDesc(adreesDesc);
            campus.setHotelDesc(hotelDesc);
            campus.setHotelPhoto(hotelPhoto);

            campus.setHotelimage1(hotelPhoto1);
            campus.setHotelimage2(hotelPhoto2);
            campus.setHoteladdress(HotelAddress);
            campus.setHotalstar(HotelStar);
            campus.setHotelDesc(hotelDesc);
            campus.setHotelname(HotelName);
            campus.setHoteldistance(HotelDistance);
            campusService.insertOrUpdate(campus);
        } else {
            //update
            campus.setId(id.longValue());
            campus.setCampusName(campusName);
            campus.setCampusNameEn(campusNameEn);
            campus.setSeasonStart(seasonStart);
            campus.setSeasonEnd(seasonEnd);
            campus.setCampusPhoto(campusPhoto);
            campus.setCampusBannerPhoto(campusBannerPhoto);
            campus.setCampusDesc(campusDesc);
            campus.setAdreesDesc(adreesDesc);
            campus.setHotelDesc(hotelDesc);
            campus.setHotelPhoto(hotelPhoto);

            campus.setHotelimage1(hotelPhoto1);
            campus.setHotelimage2(hotelPhoto2);
            campus.setHoteladdress(HotelAddress);
            campus.setHotalstar(HotelStar);
            campus.setHotelname(HotelName);
            campus.setHoteldistance(HotelDistance);
            campus.setCreateTime(new Date());
            campus.setUpdateTime(new Date());
            campusService.insertOrUpdate(campus);
        }
        return JsonResult.success(campus);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult deleteRecord(@RequestParam("id") Long id) {
        if (id != null) {
            if (campusService.deleteCampusRecord(id.longValue()) == 1) {
                //success
                return JsonResult.success(id);
            } else {
                //fail
                return JsonResult.error("不存在校区id为" + id + "的记录！");
            }
        } else {
            return JsonResult.error("id不能为空");
        }
    }

    @RequestMapping(value = "/img/upload")
    @ResponseBody
    public JsonResult<?> imgUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {

        //如果文件不为空，写入上传路径
        if (!file.isEmpty()) {
            //上传文件路径
            String path = request.getSession().getServletContext().getRealPath("static") + File.separator + "images";
            //上传文件名
            String filename = file.getOriginalFilename();
            File filepath = new File(path, filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            file.transferTo(new File(path + File.separator + filename));
            return JsonResult.success("/static/images" + File.separator + filename);
        } else {
            return JsonResult.error("上传失败");
        }
    }


    @RequestMapping(value = "/show/page")
    @ResponseBody
    public JsonResult<?> showByPage(@RequestParam("page") Integer page,
                                    @RequestParam("rows") Integer rows) {
        return campusService.getCampusListByPage(page, rows);
    }

    @RequestMapping(value = "/admin/show/page")
    @ResponseBody
    public DataGridResult showByPageAdmin(@RequestParam("page") Integer page,
                                          @RequestParam("rows") Integer rows) {
        return campusService.getCampusListForDataGridByPage(page, rows);
    }

    @RequestMapping(value = "/batchDelete")
    @ResponseBody
    public JsonResult<?> deleteBatchInfo(@RequestParam String ids) {

        String[] split = ids.split(",");
        try {
            for (int i = 0; i < split.length; i++) {
                Long id = Long.parseLong(split[i]);
                campusService.deleteCampusRecord(id);
            }
            return JsonResult.success(null, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("删除失败");
        }
    }
}
