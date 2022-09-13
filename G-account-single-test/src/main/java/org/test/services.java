package org.test;

import java.io.File;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.camel.Attachment;
import org.apache.camel.Body;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;

@Consumes(value = { MediaType.APPLICATION_JSON ,MediaType.MULTIPART_FORM_DATA})
@Produces(value = { MediaType.APPLICATION_JSON })
public interface services {

	@POST
	@Path("/add")
	public Object addAccount(@Body Account account);

	@POST
	@Path("/addaccounts")
	public Object addaccounts(@Body List<Account> accounts);

	@GET
	@Path("/find/{id}")
	public Object getAccount(@PathParam("id") int id);

	@GET
	@Path("/all")
	public Object getAllAccounts();

	@PUT
	@Path("/update")
	public Object updateAccount(@Body Account account);
	@POST
	@Path("/update/{id}/{name}")
	public Object updateName(@PathParam("id") Long id,@PathParam("name") String name);

	@DELETE
	@Path("/delete/{id}")
	public Object deleteAccount(@PathParam("id") int id);
	
	@DELETE
	@Path("/delete2")
	public Object delete2(@Body DeletedDto delDto);
	
	@POST
	@Path("/uploadfile/{id}")
	@Consumes("multipart/form-data")
	public Object uploadfile(@PathParam("id") Long id,@Multipart(value = "imageFile") File  mulfile) throws Exception;
}
