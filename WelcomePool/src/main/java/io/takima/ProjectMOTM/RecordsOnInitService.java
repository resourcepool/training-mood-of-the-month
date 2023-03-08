package io.takima.ProjectMOTM;

public class RecordsOnInitService {

    public void onInit(){
        RecordsJDBC recordsJDBC = new RecordsJDBC();
        recordsJDBC.flushEmployeeOnInit();
        recordsJDBC.flushMotmOnInit();
        recordsJDBC.insertRecordsInEmployeeOnInit();
    }
}
