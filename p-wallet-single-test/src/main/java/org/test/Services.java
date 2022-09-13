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

@Consumes(value = { MediaType.APPLICATION_JSON })
@Produces(value = { MediaType.APPLICATION_JSON })
public interface Services {
	@POST
    @Path("/add")
    public String addWallet(Wallet wallet);
    
    @GET
    @Path("/find/{id}")
    public Wallet getWallet(@PathParam("id") int id);

    @GET
    @Path("/all")
    public List<Wallet> getAllWallets();

    @PUT
    @Path("/topup/{walletId}/{value}")
    public Wallet topup(@PathParam("walletId") Long walletId,@PathParam("value") Double value);

    @DELETE
    @Path("/delete/{id}")
    public void deleteWallet(@PathParam("id") int id); 
    @GET
    @Path("/topup/{walletId}/{value}")
    public Wallet deduct(@PathParam("walletId") Long walletId,@PathParam("value") Double value);
}
