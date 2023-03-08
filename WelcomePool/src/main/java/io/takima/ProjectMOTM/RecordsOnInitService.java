package io.takima.ProjectMOTM;

public class RecordsOnInitService {

    public void onInit(){
        RecordsJDBC recordsJDBC = new RecordsJDBC();
        recordsJDBC.insertRecordsOnInit();
    }
}
