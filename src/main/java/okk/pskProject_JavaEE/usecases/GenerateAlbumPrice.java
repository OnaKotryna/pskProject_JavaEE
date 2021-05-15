package okk.pskProject_JavaEE.usecases;

import okk.pskProject_JavaEE.entities.Album;
import okk.pskProject_JavaEE.services.PriceGenerator;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


@SessionScoped
@Named
public class GenerateAlbumPrice implements Serializable {

    @Inject
    PriceGenerator priceGenerator;

    private CompletableFuture<Double> priceGenerationTask = null;

    public String generateNewAlbumPrice(Album album) {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        priceGenerationTask = CompletableFuture.supplyAsync(() -> priceGenerator.generatePrice(album));

        return "/albumDetails.xhtml?faces-redirect=true&albumId=" + requestParameters.get("albumId");
    }

    public boolean isPriceGeneratorRunning() {
        return priceGenerationTask != null && !priceGenerationTask.isDone();
    }

    public String getPriceGeneratorStatus() throws ExecutionException, InterruptedException {
        if(priceGenerationTask == null){
            return null;
        } else if (isPriceGeneratorRunning()) {
            return "Price generation is in progress";
        }
        return "Calculated price: " + priceGenerationTask.get();
    }

}
