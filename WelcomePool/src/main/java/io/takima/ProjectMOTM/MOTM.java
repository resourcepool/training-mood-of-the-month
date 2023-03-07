package io.takima.ProjectMOTM;

import java.util.Objects;

public class MOTM {
    private String titre;
    private String modeleMessage;
    private String modelePage;

    // Constructeur
    public MOTM(String titre, String modeleMessage, String modelePage) {
        this.titre = titre;
        this.modeleMessage = modeleMessage;
        this.modelePage = modelePage;
    }

    // Getters et Setters
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getModeleMessage() {
        return modeleMessage;
    }

    public void setModeleMessage(String modeleMessage) {
        this.modeleMessage = modeleMessage;
    }

    public String getModelePage() {
        return modelePage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MOTM motm)) return false;
        return titre.equals(motm.titre) && modeleMessage.equals(motm.modeleMessage) && modelePage.equals(motm.modelePage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titre, modeleMessage, modelePage);
    }

    public void setModelePage(String modelePage) {
        this.modelePage = modelePage;
    }
}

