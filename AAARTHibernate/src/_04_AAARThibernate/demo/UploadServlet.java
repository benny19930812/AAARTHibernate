package _04_AAARThibernate.demo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Part part = req.getPart("myfile");
        String disposition = part.getHeader("Content-Disposition");
        String suffix = disposition.substring(disposition.lastIndexOf("."),disposition.length()-1);
          //随机的生存一个32的字符串
        String filename = UUID.randomUUID()+suffix;
          //获取上传的文件名
        InputStream is = part.getInputStream();
        //动态获取服务器的路径
        String serverpath = req.getServletContext().getRealPath("upload");
        FileOutputStream fos = new FileOutputStream(serverpath+"/"+filename);
        byte[] bty = new byte[1024];
        int length =0;
        while((length=is.read(bty))!=-1){
            fos.write(bty,0,length);
        }
        fos.close();
        is.close();
    }

}
