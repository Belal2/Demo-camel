package org.test;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.camel.Body;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;

@Consumes(value = { MediaType.APPLICATION_JSON })
@Produces(value = { MediaType.APPLICATION_JSON })
public interface Services {
	@POST
    @Path("/add")
    public Object addWallet(Wallet wallet);
    
    @GET
    @Path("/find/{id}")
    public Object getWallet(@PathParam("id") int id);

    @GET
    @Path("/all")
    public Object getAllWallets();

    @PUT
    @Path("/topup/{id}/{value}")
    public Object topup(@PathParam("id") Long walletId,@PathParam("value") Double value);
    
    @POST
    @Path("/topup2/{id}/{value}")
    public Object topup2(@PathParam("id") Long walletId,@PathParam("value") Double value);


    @DELETE
    @Path("/delete/{id}")
    public void deleteWallet(@PathParam("id") int id); 
    
	@DELETE
	@Path("/delete2")
	public Object delete2(@Body DeletedDto delDto);
	
    @PUT
    @Path("/deduct/{id}/{value}")
    public Object deduct(@PathParam("id") Long walletId,@PathParam("value") Double value);
    
    @POST
	@Path("/uploadfile/{id}")
	 @Consumes(MediaType.MULTIPART_FORM_DATA)
	public Object uploadfile(@PathParam("id") Long id,@Multipart(value = "imageFile") org.apache.cxf.jaxrs.ext.multipart.Attachment  mulfile) ;

}
