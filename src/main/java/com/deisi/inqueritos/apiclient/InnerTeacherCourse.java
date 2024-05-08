package com.deisi.inqueritos.apiclient;

public class InnerTeacherCourse {
    private String id;
    private boolean coordinador;
    private boolean theoretical;
    private boolean practical;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isCoordinador() {
        return coordinador;
    }

    public void setCoordinador(boolean coordinador) {
        this.coordinador = coordinador;
    }

    public boolean isTheoretical() {
        return theoretical;
    }

    public void setTheoretical(boolean theoretical) {
        this.theoretical = theoretical;
    }

    public boolean isPractical() {
        return practical;
    }

    public void setPractical(boolean practical) {
        this.practical = practical;
    }
}
