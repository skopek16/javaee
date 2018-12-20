package pl.bskopinski.javaee.kolokwium2.service;

import pl.bskopinski.javaee.kolokwium2.domain.Camera;

import java.util.ArrayList;
import java.util.List;

public class CameraService {
    private List<Camera> db = new ArrayList<Camera>();

    public void addCamera(Camera camera) {
        Camera newCamera = new Camera(camera.getName(), camera.getDate(), camera.getColor(), camera.getExtras());
        db.add(newCamera);
    }


    public List<Camera> getAllCamera() {
        return db;
    }

    public void removeNewsletter(Camera camera) {
        db.remove(camera);
    }
}
