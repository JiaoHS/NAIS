/**
 * @author anliyong@baidu.com
 * 2015-5-31 下午5:56:43
 */
package com.nasi.portal.web.controller.system;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.nasi.portal.common.helper.IOHelper;
import com.nasi.portal.data.model.Column;
import com.nasi.portal.service.ColumnService;
import com.nasi.portal.service.IncService;
import com.nasi.portal.web.controller.BaseController;

/**
 * @author anliyong@baidu.com 2015-5-31下午5:56:43
 */
@Controller
@RequestMapping(value = "/system/column")
public class ColumnSystemController extends BaseController {

    @Resource
    private ColumnService columnService;

    @Resource
    private IncService incService;

    @RequestMapping(value = "/list")
    public String list(Model model) {

        List<Column> columns = columnService.getListByParentId(0);

        model.addAttribute("columns", columns);

        return "system/column/columnList";
    }

    @RequestMapping(value = "/show")
    public String add(@RequestParam(required = false, defaultValue = "1") Integer type, 
            @RequestParam(required = false, defaultValue = "1") Integer level,
            @RequestParam(required = false, defaultValue = "0") Integer parentId, Model model) {
        Column column = new Column();
        column.setColumnType(type);
        column.setLevel(level);
        column.setParentId(parentId);
        model.addAttribute("column", column);
        return "system/column/columnEdit";
    }

    @RequestMapping(value = "/show/{id}")
    public String show(@PathVariable(value = "id") Integer id, Model model) {

        Column column = columnService.getByPrimaryKey(id);

        model.addAttribute("column", column);

        return "system/column/columnEdit";
    }

    @RequestMapping(value = "/select")
    public void select(@RequestParam(required = false, defaultValue = "1") Integer level, @RequestParam Integer type,
            HttpServletResponse response) {

        List<Column> columns = columnService.getSelectData(level, type);

        JSONArray jsonArray = new JSONArray();

        if (columns != null && columns.size() > 0) {
            for (Column column : columns) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id", column.getId());
                jsonObject.put("title", column.getTitle());
                jsonArray.add(jsonObject);
            }
        }

        super.response2Client(response, jsonArray.toString());

    }

    @RequestMapping(value = "/edit")
    public String edit(HttpServletRequest request, @RequestParam(value = "bannerFile", required = false) MultipartFile bannerFile,
            @RequestParam(value = "ebannerFile", required = false) MultipartFile ebannerFile, @ModelAttribute Column column,
            Model model) {

        columnService.insertOrUpdate(column);
        
        //保存  
        try {  
            
            String fileSeparator = System.getProperty("file.separator");
            String basePath = request.getSession().getServletContext().getRealPath(fileSeparator);  
            if(!basePath.endsWith(fileSeparator)) {
                basePath += fileSeparator;
            }
            
            if (!bannerFile.isEmpty()) {
                String suffix = bannerFile.getOriginalFilename().substring(bannerFile.getOriginalFilename().lastIndexOf(".") + 1);
                String relativePath = String.format("upload%simages%scolumn%sbanner_cn_%s.%s", fileSeparator, fileSeparator, fileSeparator, column.getId(), suffix);
                File bannerTargetFile = new File(basePath + relativePath);
                IOHelper.makeDirs(bannerTargetFile);
                bannerFile.transferTo(bannerTargetFile);
                column.setBanner(relativePath);
            }
            if (!ebannerFile.isEmpty()) {
                String suffix = ebannerFile.getOriginalFilename().substring(ebannerFile.getOriginalFilename().lastIndexOf("."));
                String relativePath = String.format("upload%simages%scolumn%sbanner_en_%s.%s", fileSeparator, fileSeparator, fileSeparator, column.getId(), suffix);
                File bannerTargetFile = new File(basePath + relativePath);
                IOHelper.makeDirs(bannerTargetFile);
                bannerFile.transferTo(bannerTargetFile);
                column.setEbanner(relativePath);
            }
            
            if (!bannerFile.isEmpty() || !ebannerFile.isEmpty()) {
                columnService.insertOrUpdate(column);
            }
             
        } catch (Exception e) {  
            e.printStackTrace();  
        }  

        incService.updateTopInc();

        return "redirect:list";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable(value = "id") Integer id) {
        columnService.deleteByPrimaryKey(id);
        incService.updateTopInc();
        return "redirect:../list";
    }
    
    @RequestMapping(value = "/showColumnList")
    public String showColumnList(@RequestParam("id") Integer id, Model model) {

        List<Column> columns = columnService.getListByParentId(id);

        model.addAttribute("columns", columns);

        return "system/column/columnListAjax";

    }

}
