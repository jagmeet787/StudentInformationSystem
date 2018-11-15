package org.satyam.ss.restServices.resource;

import java.io.File;
import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.glassfish.jersey.media.multipart.ContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.satyam.ss.restServices.Service.RestService;
import org.satyam.ss.restServices.model.Student;
import org.satyam.ss.restServices.model.simple;





@Path("student")
public class StudentResource {
	private RestService service=new RestService();
	@GET
	@Path("add1")
	public int addStudent() {
		System.out.println("hello");
		return 0;
	}
	@POST
	@Path("addWithImage")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public int uploadFileAndJSON(FormDataMultiPart form) { 
		FormDataBodyPart filePart = form.getField("file");
		InputStream is = filePart.getValueAs(InputStream.class);
		ContentDisposition cdh =  filePart.getContentDisposition();
		String fname=cdh.getFileName();
		System.out.println(fname);
		FormDataBodyPart jsonPart=form.getField("json");
		jsonPart.setMediaType(MediaType.APPLICATION_JSON_TYPE);
		Student obj=jsonPart.getValueAs(Student.class);
		String path="C://Users/satyam/Desktop/"+obj.getRollNumber()+".png";
		int res=service.addStudentWithImage(obj,is,path);
	    return res;
	}
	@POST
	@Path("add2")
	@Consumes(MediaType.APPLICATION_JSON)
	public int check(simple obj) {
		System.out.println(obj.abc);
		return 0;
	}
}
