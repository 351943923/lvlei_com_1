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
         System.out.println("URL Ϊ��" + url.toString());
         System.out.println("Э��Ϊ��" + url.getProtocol());
         System.out.println("��֤��Ϣ��" + url.getAuthority());
         System.out.println("�ļ��������������" + url.getFile());
         System.out.println("��������" + url.getHost());
         System.out.println("·����" + url.getPath());
         System.out.println("�˿ڣ�" + url.getPort());
         System.out.println("Ĭ�϶˿ڣ�" + url.getDefaultPort());
         System.out.println("���������" + url.getQuery());
         System.out.println("��λλ�ã�" + url.getRef());
         System.out.println("��λλ�ã�" + url.getContent());
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