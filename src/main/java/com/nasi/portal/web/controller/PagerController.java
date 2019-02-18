/**
 * 
 */
package com.nasi.portal.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author anly
 * 
 */
@Controller
@RequestMapping(value = "/pager")
public class PagerController extends BaseController {
    /**
     *  function changePager(pageNo) {
            var form = newForm('${pageContext.request.contextPath }/system/ebook/list', 'post', '');
            newElement(form, 'pageNo', pageNo);
            newElement(form, 'search.number', '${search.number }');
            newElement(form, 'search.name', '${search.name }');
            newElement(form, 'search.author', '${search.author }');
            form.submit();
        }
     * <c:import url="/pager/${pageNo }-${pageSize }-${recordCount }-changePager" charEncoding="UTF-8"/>
     * @author anliyong@baidu.com
     * 2015-7-17 下午5:57:11
     */
    @RequestMapping(value = "/{pageNo}-{pageSize}-{recordCount}-{method}")
    public String list(@PathVariable(value = "pageNo") Integer pageNo,
            @PathVariable(value = "pageSize") Integer pageSize,
            @PathVariable(value = "recordCount") Integer recordCount, @PathVariable(value = "method") String method,
            @PathVariable(value = "type") Integer type, HttpServletRequest request) {
        request.setAttribute("pageNo", pageNo);
        request.setAttribute("pageSize", pageSize);
        request.setAttribute("recordCount", recordCount);
        request.setAttribute("method", method);
        return "include/pager";
    }

}
