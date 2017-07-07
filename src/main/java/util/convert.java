package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class convert {
	
	static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
public static Date String2Date(String str){
		try {
			return sdf.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

}
}
