package br.com.diegosilva.smarthome.model;

/**
 * Created by 98379720172 on 15/06/2016.
 */
public class Camera {

    private Long id;
    private String nome;
    private String snapshotUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSnapshotUrl() {
        return snapshotUrl;
    }

    public void setSnapshotUrl(String snapshotUrl) {
        this.snapshotUrl = snapshotUrl;
    }
}
