package url;

import java.io.BufferedInputStream;
import java.io.CharArrayWriter;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Snippet {
	public static void main(String[] args) {
		Snippet s=new Snippet();
		try {
			System.out.println(s.httpGet("http://www.baidu.com", null));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String httpGet(String urlStr, Map<String, String> params) throws Exception {
	    StringBuilder sb = new StringBuilder();
	    if (null != params && params.size() > 0) {
	        sb.append("?");
	        Entry<String, String> en;
	        for (Iterator<Entry<String, String>> ir = params.entrySet().iterator(); ir.hasNext();) {
	            en = ir.next();
	            sb.append(en.getKey() + "=" + URLEncoder.encode(en.getValue(),"utf-8") + (ir.hasNext() ? "&" : ""));
	        }
	    }
	    URL url = new URL(urlStr + sb);
	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	    conn.setConnectTimeout(5000);
	    conn.setReadTimeout(5000);
	    conn.setRequestMethod("GET");
	    if (conn.getResponseCode() != 200)
	        throw new Exception("ÇëÇóÒì³£×´Ì¬Öµ:" + conn.getResponseCode());
	    BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
	    Reader reader = new InputStreamReader(bis,"gbk");
	    char[] buffer = new char[2048];
	    int len = 0;
	    CharArrayWriter caw = new CharArrayWriter();
	    while ((len = reader.read(buffer)) > -1)
	        caw.write(buffer, 0, len);
	    reader.close();
	    bis.close();
	    conn.disconnect();
	    //System.out.println(caw);
	    return caw.toString();
	}
}

