import com.sun.org.apache.bcel.internal.generic.Instruction;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        RandomAccessFile raf = new RandomAccessFile(new File("test.txt"),"rw");
        raf.writeBytes("BBM 102");
        raf.writeBytes(" Introduction to Programming");
        raf.seek(16000);
        raf.writeBytes("Advanced Programming ");
        raf.writeBytes("Class II ");
        raf.seek(0);
        byte[] bytes = new byte[5];
        raf.read(bytes);
        String str = new String(bytes);
        System.out.println(str);
        long length = raf.length();
        raf.setLength(length + 1);
        raf.seek(raf.length());
        raf.writeBytes("is great!");
        raf.close();

        Map<String,String> map = new HashMap<String,String>();
        Set<String> keys = map.keySet();

        Iterator<String> it = keys.iterator();
        
        for (;it.hasNext();) {
            String key = it.next();
        }

        double x = 30;

        System.out.println(Math.sin(x));
    }
    public void cs (double c ){
        double y = 30;

        System.out.println(Math.sin(y));

    }
}
