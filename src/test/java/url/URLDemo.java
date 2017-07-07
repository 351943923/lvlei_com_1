package url;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
 
public class URLDemo
{
   public static void main(String [] args)
   {
      try
      {
         URL url = new URL("http://www.baidu.com");
         System.out.println("URL 为：" + url.toString());
         System.out.println("协议为：" + url.getProtocol());
         System.out.println("验证信息：" + url.getAuthority());
         System.out.println("文件名及请求参数：" + url.getFile());
         System.out.println("主机名：" + url.getHost());
         System.out.println("路径：" + url.getPath());
         System.out.println("端口：" + url.getPort());
         System.out.println("默认端口：" + url.getDefaultPort());
         System.out.println("请求参数：" + url.getQuery());
         System.out.println("定位位置：" + url.getRef());
         System.out.println("定位位置：" + url.getContent());
         URLConnection urlCon = url.openConnection() ;
         InputStream is = urlCon.getInputStream();
         OutputStream out = new FileOutputStream("d://my.html");
		byte[] be=new byte[100];
		while(is.read(be)>-1){
			is.read(be);
			out.write(be);
		}
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}