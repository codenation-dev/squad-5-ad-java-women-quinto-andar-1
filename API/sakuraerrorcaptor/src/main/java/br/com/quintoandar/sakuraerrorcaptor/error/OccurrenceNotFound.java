package br.com.quintoandar.sakuraerrorcaptor.error;

public class OccurrenceNotFound extends RuntimeException{

    private static final long serialVersionUID = 4134635699371907069L;

    public OccurrenceNotFound(Long id){
        super("Occurrence with id " + id + " not found.");
    }

}
