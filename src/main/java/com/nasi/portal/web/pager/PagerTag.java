package com.nasi.portal.web.pager;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 自定义分页标签
 * @author anliyong
 * 
 */
public class PagerTag extends TagSupport {

    private static final long serialVersionUID = 1L;
    private int pageSize = 10;
    private int pageNo = 1;
    private int recordCount;
    private String method;

    public int doStartTag() throws JspException {

        pageSize = pageSize == 0 ? pageSize = 10 : pageSize;
        
        int pageCount = (this.recordCount + this.pageSize - 1) / this.pageSize;
        
        StringBuilder sb = new StringBuilder();
        
        sb.append("<style type=\"text/css\">");
        sb.append(".pager{float:right;display:block;padding:6px;line-height:36px;font-size:12px;margin:0px;}");
        sb.append(".pager div{float:left;}");
        sb.append(".pager .pager_info{border:#EEEEEE 1px solid;box-shadow:1px 2px 3px #bcbcbc;border-radius:5px;background-color:#FFF;}");
        sb.append(".pager .pager_info .no_data{padding:0px 9px;}");
        sb.append(".pager .pager_info a{padding:0 9px;color:#333;display:block;text-decoration:none;float:left;}");
        sb.append(".pager .pager_info a:hover{text-decoration:none;}");
        sb.append(".pager .pager_list{margin-right:5px;}");
        sb.append(".pager .pager_list a{background:#f3f3f3;border:1px solid #f3f3f3;border-radius:25px;margin-left:5px;overflow:hidden;-webkit-transition:all linear .2s;-moz-transition:all linear .2s;-ms-transition:all linear .2s;transition:all linear .2s;line-height:24px;margin-top:6px;}");
        sb.append(".pager .pager_list a:hover{background-color:#fff;border-color:#45abfa;color:#08c;cursor:pointer;}");
        sb.append(".pager .pager_pre a.pre{border-right:1px solid #e8e8e8;}");
        sb.append(".pager .pager_next a.next{border-left:1px solid #e8e8e8;}");
        sb.append(".pager .pager_pre a.pre:hover,.pager div.pager_next a.next:hover{color:#08c;cursor:pointer;border-bottom:0px;}");
        sb.append(".pager .pager_pre a.pre.disable:hover,.pager div.pager_next a.next.disable:hover{color:#333;cursor:default;}");
        sb.append(".pager .pager_list a.disable{background:#FFF;border:0px;}");
        sb.append(".pager .pager_list a.disable:hover{background:#FFF;border:0px;cursor:default;color:#333;}");
        sb.append(".pager .pager_list a.current{background-color:#08c;border-color:#08c;color:#fff;}");
        sb.append(".pager .pager_list a.current:hover{cursor:default;display:}");
        sb.append(".pager .pager_info .jump{margin-right:5px;}");
        sb.append(".pager .pager_info .jump div{padding:0 5px;display:block;float:left;}");
        sb.append(".pager .pager_info .jump input{border:1px solid #e8e8e8;border-radius:25px;margin-left:5px;overflow:hidden;-webkit-transition:all linear .2s;-moz-transition:all linear .2s;-ms-transition:all linear .2s;transition:all linear .2s;line-height:24px;margin:6px 0px 0px 0px;height:16px;width:24px;padding:4px 5px;text-align:center;line-height:16px\\9;background: #FFF;-webkit-box-sizing:content-box;-moz-box-sizing:content-box;box-sizing:content-box;vertical-align:baseline;}");
        sb.append(".pager .pager_info .jump input:focus{background-color:#fff;border-color:#45abfa;color:#08c;outline:0;}");
        sb.append("</style>\r\n");
        sb.append("<div class=\"pager\"><div class=\"pager_info\">");
        
        if (this.recordCount == 0) {
            sb.append("<strong>没有可显示的项目</strong>");
        } else {
            
            if (this.pageNo > pageCount) {
                this.pageNo = pageCount;
            }
            
            if (this.pageNo < 1) {
                this.pageNo = 1;
            }
            
            if (this.pageNo == 1) {
                sb.append("<div class=\"pager_pre\">");
                sb.append("<a href=\"javascript:void(0);\" class=\"pre disable\">&laquo;&nbsp;首页</a>");
                sb.append("<a href=\"javascript:void(0);\" class=\"pre disable\">上一页</a>");
                sb.append("</div>");
            } else {
                sb.append("<div class=\"pager_pre\">");
                sb.append("<a href=\"").append(method).append(1).append(");\" class=\"pre\">&laquo;&nbsp;首页</a>");
                sb.append("<a href=\"").append(method).append(pageNo - 1).append(");\" class=\"pre\">上一页</a>");
                sb.append("</div>");
            }
            
            sb.append("<div class=\"pager_list\">");

            int start = 1;
            
            if (pageNo > 4) {
                start = pageNo - 1;
                sb.append("<a href=\"").append(method).append("1)\">1</a>");
                sb.append("<a href=\"").append(method).append("2)\">2</a>");
                sb.append("<a class=\"disable\">&hellip;</a>");
            }
            
            int end = pageNo + 1;
            if (end > pageCount) {
                end = pageCount;
            }
            
            for (int i = start; i <= end; ++i) {
                if (pageNo == i){
                    sb.append("<a href=\"javascript:void(0);\" class=\"current\">").append(i).append("</a>");
                } else {
                    sb.append("<a href=\"").append(method).append(i).append(")\">").append(i).append("</a>");
                }
            }

            if (end < pageCount - 2) {
                sb.append("<a class=\"disable\">&hellip;</a>");
            }
            if (end < pageCount - 1) {
                sb.append("<a href=\"").append(method).append(pageCount - 1).append(")\">").append(pageCount - 1).append("</a>");
            }
            if (end < pageCount) {
                sb.append("<a href=\"").append(method).append(pageCount).append(")\">").append(pageCount).append("</a>");
            }
            
            sb.append("</div><div class=\"jump\">");
            sb.append("<div><input type=\"text\" name=\"custompage\" size=\"2\" title=\"输入页码，按回车快速跳转\" value=\"").append(pageNo).append("\" onkeydown=\"if(event.keyCode==13) {").append(method).append("value)}\"></div>");            
            sb.append("<div title=\"共 ").append(pageCount).append(" 页\"> / ").append(pageCount).append(" 页 </div></div>");
            if (pageNo == pageCount) {
                sb.append("<div class=\"pager_next\">");
                sb.append("<a href=\"javascript:void(0);\" class=\"next disable\">下一页</a>");
                sb.append("<a href=\"javascript:void(0);\" class=\"next disable\">末页&nbsp;&raquo;</a>");
                sb.append("</div>");
            } else {
                sb.append("<div class=\"pager_next\">");
                sb.append("<a href=\"").append(method).append(pageNo + 1).append(");\" class=\"next\">下一页</a>");
                sb.append("<a href=\"").append(method).append(pageCount).append(");\" class=\"next\">末页&nbsp;&raquo;</a>");
                sb.append("</div>");
            }
            
        }
        
        sb.append("</div></div>");
        
        try {
            this.pageContext.getOut().println(sb.toString());
        } catch (IOException e) {
            throw new JspException(e);
        }
        
        return 0;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public void setMethod(String method) {
        this.method = "javascript:" + method + "(";
    }

}
