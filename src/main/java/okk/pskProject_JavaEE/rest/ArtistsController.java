package okk.pskProject_JavaEE.rest;

import lombok.Getter;
import lombok.Setter;
import okk.pskProject_JavaEE.entities.Artist;
import okk.pskProject_JavaEE.persistence.ArtistsDAO;
import okk.pskProject_JavaEE.rest.contracts.ArtistDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path(("/artists"))
public class ArtistsController {

    @Inject
    @Getter @Setter
    private ArtistsDAO artistsDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id){
        Artist artist = artistsDAO.findOne(id);
        if(artist == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        ArtistDTO artistDTO = new ArtistDTO();
        artistDTO.setName(artist.getName());
        artistDTO.setCountry(artist.getCountry());

        return Response.ok(artistDTO).build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") final Integer artistId, ArtistDTO artistData){
        try {
            Artist existingArtist = artistsDAO.findOne(artistId);
            if(existingArtist == null){
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            existingArtist.setName(artistData.getName());
            existingArtist.setCountry(artistData.getCountry());

            artistsDAO.update(existingArtist);

            return Response.ok().build();
        } catch (OptimisticLockException ole){
            return  Response.status(Response.Status.CONFLICT).build();
        }
    }

    @Path("/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(ArtistDTO artistData) {
        try{
            Artist artist = new Artist();

            artist.setName(artistData.getName());
            artist.setCountry(artistData.getName());

            artistsDAO.persist(artist);

            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }

    }

}
