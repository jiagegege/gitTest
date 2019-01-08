package cn.huahai.tel.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileNameConversion {
	//文件名问题
	public static void setHeader(HttpServletResponse response,
            HttpServletRequest request, String filename)
            throws UnsupportedEncodingException {
        response.reset();
        response.setHeader("Set-Cookie", "fileDownload=true; path=/");
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        // 设置为下载application/x-download
        response.setContentType("application/x-download charset=UTF-8");
        // 通常解决汉字乱码方法用URLEncoder.encode(...)
        String filenamedisplay = URLEncoder.encode(filename, "UTF-8");
        if ("FF".equals(getBrowser(request))) {
            // 针对火狐浏览器处理方式不一样了
            filenamedisplay = new String(filename.getBytes("UTF-8"),
                    "iso-8859-1");
        }
        response.setHeader("Content-Disposition", "attachment;filename="
                + filenamedisplay);
    }
	
	//获取浏览器版本型号；
	public static String getBrowser(HttpServletRequest request) {
        String UserAgent = request.getHeader("USER-AGENT").toLowerCase();
        if (UserAgent != null) {
            if (UserAgent.indexOf("msie") >= 0)
                return "IE";
            if (UserAgent.indexOf("firefox") >= 0)
                return "FF";
            if (UserAgent.indexOf("safari") >= 0)
                return "SF";
        }
        return null;
    }


}
